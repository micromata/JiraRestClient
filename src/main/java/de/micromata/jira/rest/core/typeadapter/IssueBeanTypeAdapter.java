package de.micromata.jira.rest.core.typeadapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import de.micromata.jira.rest.core.domain.IssueBean;

import java.io.IOException;

/**
 * Created by cschulc on 09.02.2016.
 */
public class IssueBeanTypeAdapter extends TypeAdapter<IssueBean> {

    @Override
    public void write(JsonWriter jsonWriter, IssueBean issueBean) throws IOException {

    }

    @Override
    public IssueBean read(JsonReader jsonReader) throws IOException {

       return null;
    }
}
