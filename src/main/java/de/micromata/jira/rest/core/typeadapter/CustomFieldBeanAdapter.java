package de.micromata.jira.rest.core.typeadapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import de.micromata.jira.rest.core.domain.CustomFieldBean;

import java.io.IOException;

/**
 * Created by cschulc on 09.02.2016.
 */
public class CustomFieldBeanAdapter extends TypeAdapter<CustomFieldBean> {


    @Override
    public void write(JsonWriter out, CustomFieldBean value) throws IOException {

    }

    @Override
    public CustomFieldBean read(JsonReader in) throws IOException {
        System.out.println("customfield");

        return null;
    }
}
