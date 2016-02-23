package de.micromata.jira.rest.core.custom;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import de.micromata.jira.rest.core.domain.IssueBean;

import java.lang.reflect.Type;

/**
 * Created by cschulc on 18.02.16.
 */
public class IssueBeanSerializer implements JsonSerializer<IssueBean> {

    @Override
    public JsonElement serialize(IssueBean src, Type typeOfSrc, JsonSerializationContext context) {
        return null;
    }
}
