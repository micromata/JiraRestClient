package de.micromata.jira.rest.core;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * Created by Christian on 09.12.2014.
 */
public abstract class BaseClient {

    protected Gson gson = new GsonBuilder().create();

    protected JsonReader toJsonReader(InputStream inputStream) throws UnsupportedEncodingException {
        InputStreamReader reader = new InputStreamReader(inputStream, "UTF-8");
        JsonReader jsonReader = new JsonReader(reader);
        jsonReader.setLenient(true);
        return jsonReader;
    }
}
