package de.micromata.jira.rest.parser;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import de.micromata.jira.rest.domain.RenderedFieldsBean;
import de.micromata.jira.rest.util.JsonConstants;

/**
 * Created by Christian on 14.07.2014.
 */
public class RenderedFieldsParser implements JsonConstants {

    public static RenderedFieldsBean parse(JsonObject jsonObject){
        RenderedFieldsBean retval = new RenderedFieldsBean();
        JsonElement jsonElement = jsonObject.get(PROP_DESCRIPTION);
        String asString = jsonElement.getAsString();
        retval.setDescription(asString);
        return retval;
    }
}
