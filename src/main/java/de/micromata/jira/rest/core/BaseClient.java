package de.micromata.jira.rest.core;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang3.Validate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

/**
 * Author: Christian Date: 09.12.2014.
 */
public abstract class BaseClient {

	protected final ExecutorService	executorService	= Executors
															.newFixedThreadPool(100);

	protected Gson					gson			= new GsonBuilder()
															.excludeFieldsWithoutExposeAnnotation()
															.create();

	protected JsonReader toJsonReader(InputStream inputStream)
			throws UnsupportedEncodingException {

		Validate.notNull(inputStream);
		InputStreamReader reader = new InputStreamReader(inputStream, "UTF-8");
		JsonReader jsonReader = new JsonReader(reader);
		jsonReader.setLenient(true);
		return jsonReader;
	}

	/**
	 * Workaround FIX for Memory Leak: If you always create a new search client,
	 * then you have to call this method to close the ThreadPool. Otherwise you
	 * have a memory leak in your application.
	 */
	public void close() {

		executorService.shutdownNow();
	}
}
