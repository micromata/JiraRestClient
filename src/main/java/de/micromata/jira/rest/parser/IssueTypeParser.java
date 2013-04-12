package de.micromata.jira.rest.parser;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import de.micromata.jira.rest.domain.IssueTypeBean;
import de.micromata.jira.rest.util.URIParser;

import static de.micromata.jira.rest.util.JsonElementUtil.checkNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Christian
 * Date: 07.03.13
 * Time: 15:26
 * To change this template use File | Settings | File Templates.
 */
public class IssueTypeParser extends BaseParser {

    public static IssueTypeBean parse(JsonObject object) {
        IssueTypeBean bean = new IssueTypeBean();
        parseBaseProperties(bean, object);
        
        JsonElement descriptionElement = object.get(PROP_DESCRIPTION);
        if(checkNotNull(descriptionElement)) {
	        String description = descriptionElement.getAsString();
	        bean.setDescription(description);
        }
        
        JsonElement subtaskElement = object.get(PROP_SUBTASK);
        if(checkNotNull(subtaskElement)) {
	        boolean subtask = subtaskElement.getAsBoolean();
	        bean.setSubtask(subtask);
        }

        JsonElement iconUrlElement = object.get(PROP_ICONURL);
        if(checkNotNull(iconUrlElement)) {
	        String iconURL = iconUrlElement.getAsString();
	        URI uriIcon = URIParser.parseStringToURI(iconURL);
	        bean.setIconURL(uriIcon);
        }
        return bean;
    }

    public static List<IssueTypeBean> parse(List<JsonObject> objects) {
        List<IssueTypeBean> retval = new ArrayList<IssueTypeBean>();
        for (JsonObject object : objects) {
            IssueTypeBean issueTypeBean = parse(object);
            retval.add(issueTypeBean);
        }
        return retval;
    }

}
