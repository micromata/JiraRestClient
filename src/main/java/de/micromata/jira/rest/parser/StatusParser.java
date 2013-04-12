package de.micromata.jira.rest.parser;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import de.micromata.jira.rest.domain.StatusBean;
import de.micromata.jira.rest.util.URIParser;

import static de.micromata.jira.rest.util.JsonElementUtil.checkNotNull;

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
        if(checkNotNull(descObject)){
            bean.setDescription(descObject.getAsString());
        }
        
        JsonElement iconUrlObject = jsonObject.get(PROP_ICONURL);
        if(checkNotNull(iconUrlObject)){
            String iconUrlString = iconUrlObject.getAsString();
            URI uri = URIParser.parseStringToURI(iconUrlString);
            bean.setIconUrl(uri);
        }
        return bean;
    }



    public static List<StatusBean> parse(List<JsonObject> jsonObjectList){
        List<StatusBean> retval = new ArrayList<StatusBean>();
        for (JsonObject jsonObject : jsonObjectList) {
            StatusBean parse = parse(jsonObject);
            retval.add(parse);
        }
        return retval;
    }

}
