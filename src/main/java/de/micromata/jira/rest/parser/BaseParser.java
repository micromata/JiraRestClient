package de.micromata.jira.rest.parser;

import java.net.URI;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import de.micromata.jira.rest.domain.BaseBean;
import de.micromata.jira.rest.util.JsonConstants;
import de.micromata.jira.rest.util.JsonElementUtil;
import de.micromata.jira.rest.util.URIParser;

/**
 * User: Christian
 * Date: 07.03.13
 * Time: 14:51
 */
public class BaseParser implements JsonConstants {

    public static void parseBaseProperties(BaseBean bean, JsonObject object){

        JsonElement idElement = object.get(PROP_ID);
        if(JsonElementUtil.checkNotNull(idElement) == true){
          long id = idElement.getAsLong();
            bean.setId(id);
        }
        JsonElement selfElement = object.get(PROP_SELF);
        if(JsonElementUtil.checkNotNull(selfElement) == true){
            String self = selfElement.getAsString();
            URI uri = URIParser.parseStringToURI(self);
            bean.setSelf(uri);
        }
        JsonElement nameElement = object.get(PROP_NAME);
        if(JsonElementUtil.checkNotNull(nameElement) == true){
            String name = nameElement.getAsString();
            bean.setName(name);
        }
    }
}
