package de.micromata.jira.rest.parser;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import de.micromata.jira.rest.domain.StatusBean;
import de.micromata.jira.rest.util.URIParser;

import java.net.URI;

/**
 * User: Christian
 * Date: 12.03.13
 * Time: 17:08
 */
public class StatusParser extends BaseParser {

    public static StatusBean parse(JsonObject jsonObject){
        StatusBean bean = new StatusBean();
        parseBaseProperties(bean, jsonObject);
        JsonElement descObject = jsonObject.get(PROP_DESCRIPTION);
        if(descObject != null){
            bean.setDescription(descObject.getAsString());
        }
        JsonElement iconUrlObject = jsonObject.get(PROP_ICONURL);
        if(iconUrlObject != null){
            String iconUrlString = iconUrlObject.getAsString();
            URI uri = URIParser.parseStringToURI(iconUrlString);
            bean.setIconUrl(uri);
        }
        return bean;
    }

}
