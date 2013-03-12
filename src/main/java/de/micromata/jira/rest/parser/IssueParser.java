package de.micromata.jira.rest.parser;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import de.micromata.jira.rest.domain.IssueBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Christian
 * Date: 07.03.13
 * Time: 08:37
 * To change this template use File | Settings | File Templates.
 */
public class IssueParser extends BaseParser {


    public static IssueBean parse(JsonObject jsonObject){
        IssueBean issueBean = new IssueBean();
        parseBaseProperties(issueBean, jsonObject);
        JsonElement keyElement = jsonObject.get(PROP_KEY);
        if(keyElement != null){
            issueBean.setKey(keyElement.getAsString());
        }
        JsonElement expandElement = jsonObject.get(PROP_EXPAND);
        if(expandElement != null){
            issueBean.setExpand(expandElement.getAsString());
        }

        JsonElement fieldsElement = jsonObject.get(ELEM_FIELDS);
        if(fieldsElement != null){
            JsonObject fieldObject = fieldsElement.getAsJsonObject();
            JsonElement summaryElement = fieldObject.get(PROP_SUMMARY);
            if(summaryElement != null){
                issueBean.setSummary(summaryElement.getAsString());
            }
            JsonElement issuetypeElement = fieldObject.get(ELEM_ISSUETYPES);
            if(issuetypeElement != null){

            }


        }


        return issueBean;
    }


    public static List<IssueBean> parse(List<JsonObject> jsonObjects) {
        List<IssueBean> retval = new ArrayList<IssueBean>();
        for (JsonObject jsonObject : jsonObjects) {
              retval.add(parse(jsonObject));
        }
        return retval;
    }
}
