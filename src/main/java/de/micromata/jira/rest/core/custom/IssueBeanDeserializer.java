package de.micromata.jira.rest.core.custom;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import de.micromata.jira.rest.core.domain.*;
import de.micromata.jira.rest.core.domain.customFields.*;

import java.lang.reflect.Type;
import java.util.*;

/**
 * Created by cschulc on 18.02.16.
 */
public class IssueBeanDeserializer extends BaseDeserializer  implements JsonDeserializer<IssueBean> {

    @Override
    public IssueBean deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        IssueBean issueBean = gson.fromJson(json, IssueBean.class);
        FieldsBean fields = issueBean.getFields();
        if(fields == null){
            return issueBean;
        }
        List<CustomFieldBaseBean> customFieldBean = extractCustomFieldBeans(json);
        fields.setCustomFields(customFieldBean);
        return issueBean;
    }


    private List<CustomFieldBaseBean> extractCustomFieldBeans(JsonElement json) {
        List<CustomFieldBaseBean> retval = new ArrayList<>();
        JsonObject issueObj = json.getAsJsonObject();
        JsonElement fields = issueObj.get("fields");
        if(fields == null){
            return retval;
        }
        JsonObject fieldsObj = fields.getAsJsonObject();
        Set<Map.Entry<String, JsonElement>> entries = fieldsObj.entrySet();
        for (Map.Entry<String, JsonElement> entry : entries) {
            String key = entry.getKey();
            if (key.startsWith("customfield_") == true) {
                JsonElement value = entry.getValue();
                if (value.isJsonPrimitive() == true) {
                    CustomFieldBaseBean customField = getPrimitiveCustomField(key, value);
                    if(customField != null) {
                        customField.setId(key);
                        retval.add(customField);
                    }
                }
                else if (value.isJsonObject() == true) {
                    CustomFieldBaseBean customField = getObjectCustomField(key, value);
                    if(customField != null){
                        customField.setId(key);
                        retval.add(customField);
                    }
                }
                else if (value.isJsonArray() == true) {
                    CustomFieldBaseBean arrayCustomField = getArrayCustomField(key, value);
                    if(arrayCustomField != null){
                        arrayCustomField.setId(key);
                        retval.add(arrayCustomField);
                    }
                }
                else if (value.isJsonNull() == true) {

                }
            }
        }
        return retval;
    }




    private CustomFieldBaseBean getPrimitiveCustomField(String key, JsonElement jsonElement) {
        SingleValueBean retval = new SingleValueBean();
        String value = jsonElement.getAsString();
        ValueBean valueBean = new ValueBean();
        valueBean.setValue(value);
        retval.setValue(valueBean);
        CustomFieldType customFieldType = getCustomFieldType(key);
        if(customFieldType == null){
            return null;
        }
        retval.setType(customFieldType);
        return retval;
    }

    private CustomFieldBaseBean getObjectCustomField(String id, JsonElement jsonElement) {
        CustomFieldType customFieldType = getCustomFieldType(id);
        if(customFieldType == null){
            return null;
        }
        switch (customFieldType){
            case SELECT:
                ValueBean valueBean = gson.fromJson(jsonElement, ValueBean.class);
                SingleValueBean singleValueBean = new SingleValueBean();
                singleValueBean.setType(CustomFieldType.SELECT);
                singleValueBean.setValue(valueBean);
                return singleValueBean;
            case RADIO:
                ValueBean optionValue = gson.fromJson(jsonElement, ValueBean.class);
                SingleValueBean option = new SingleValueBean();
                option.setType(CustomFieldType.RADIO);
                option.setValue(optionValue);
                return option;
            case USER:
                UserBean userBean = gson.fromJson(jsonElement, UserBean.class);
                UserSelectBean userSelectBean = new UserSelectBean();
                userSelectBean.setType(CustomFieldType.USER);
                userSelectBean.getUsers().add(userBean);
                return userSelectBean;
            case PROJECT:
                ProjectBean projectBean = gson.fromJson(jsonElement, ProjectBean.class);
                ProjectSelectBean projectSelectBean = new ProjectSelectBean();
                projectSelectBean.setType(CustomFieldType.PROJECT);
                projectSelectBean.setProject(projectBean);
                return projectSelectBean;
            case CASCADING:
                ValueBean cascadingValue = gson.fromJson(jsonElement, ValueBean.class);
                CascadingValueBean cascadingValueBean = new CascadingValueBean();
                cascadingValueBean.setType(CustomFieldType.CASCADING);
                cascadingValueBean.setValue(cascadingValue);
                return cascadingValueBean;
            case GROUP:
                ValueBean groupValue = gson.fromJson(jsonElement, ValueBean.class);
                GroupSelectBean groupSelectBean = new GroupSelectBean();
                groupSelectBean.setType(CustomFieldType.GROUP);
                groupSelectBean.getGroups().add(groupValue);
                return groupSelectBean;
            case VERSION:
                VersionBean versionBean = gson.fromJson(jsonElement, VersionBean.class);
                VersionSelectBean versionSelectBean = new VersionSelectBean();
                versionSelectBean.setType(CustomFieldType.VERSION);
                versionSelectBean.getVersions().add(versionBean);
                return versionSelectBean;
            default:
                return null;
        }
    }

    private CustomFieldBaseBean getArrayCustomField(String id, JsonElement json) {
        CustomFieldType customFieldType = getCustomFieldType(id);
        if(customFieldType == null){
            return null;
        }
        Type valueBeanType = new TypeToken<Collection<ValueBean>>(){}.getType();
        switch (customFieldType){
            case LABELS:
                Type type = new TypeToken<Collection<String>>(){}.getType();
                List<String> labels = gson.fromJson(json, type);
                MultiValueBean labelsBean = new MultiValueBean();
                labelsBean.setType(CustomFieldType.LABELS);
                for (String label : labels) {
                    ValueBean valueBean = new ValueBean();
                    valueBean.setValue(label);
                    labelsBean.getValues().add(valueBean);
                }
                return labelsBean;
            case MULTISELECT:
                List<ValueBean> multiSelectValues = gson.fromJson(json, valueBeanType);
                MultiValueBean multiSelectBean = new MultiValueBean();
                multiSelectBean.setType(CustomFieldType.MULTISELECT);
                multiSelectBean.setValues(multiSelectValues);
                return multiSelectBean;
            case CHECKBOX:
                List<ValueBean> checkboxValues = gson.fromJson(json, valueBeanType);
                MultiValueBean checkboxBean = new MultiValueBean();
                checkboxBean.setType(CustomFieldType.CHECKBOX);
                checkboxBean.setValues(checkboxValues);
                return checkboxBean;
            case MULTIUSER:
                Type userBeanType = new TypeToken<Collection<UserBean>>(){}.getType();
                List<UserBean> userSelectValues = gson.fromJson(json, userBeanType);
                UserSelectBean userSelectBean = new UserSelectBean();
                userSelectBean.setType(CustomFieldType.MULTIUSER);
                userSelectBean.setUsers(userSelectValues);
                return userSelectBean;
            case MULTIVERSION:
                Type versionBeanType = new TypeToken<Collection<VersionBean>>(){}.getType();
                List<VersionBean> versionSelectValues = gson.fromJson(json, versionBeanType);
                VersionSelectBean versionSelectBean = new VersionSelectBean();
                versionSelectBean.setType(CustomFieldType.MULTIVERSION);
                versionSelectBean.setVersions(versionSelectValues);
                return versionSelectBean;
            case MULTIGROUP:
                List<ValueBean> groupSelectValues = gson.fromJson(json, valueBeanType);
                GroupSelectBean groupSelectBean = new GroupSelectBean();
                groupSelectBean.setType(CustomFieldType.MULTIGROUP);
                groupSelectBean.setGroups(groupSelectValues);
                return groupSelectBean;
            default:
                return null;
        }
    }





}
