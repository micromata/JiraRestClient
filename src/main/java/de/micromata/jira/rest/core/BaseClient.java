package de.micromata.jira.rest.core;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import de.micromata.jira.rest.JiraRestClient;
import org.apache.commons.lang3.Validate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;

/**
 * Author: Christian Date: 09.12.2014.
 */
public abstract class BaseClient {

    protected final JiraRestClient jiraRestClient ;
    protected final CloseableHttpClient client;
    protected final HttpClientContext clientContext;
    protected final URI baseUri;
    protected ExecutorService executorService;

	protected Gson gson	= new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

    public BaseClient(JiraRestClient jiraRestClient) {
        this.baseUri = jiraRestClient.getBaseUri();
        this.clientContext = jiraRestClient.getClientContext();
        this.jiraRestClient = jiraRestClient;
        this.client = jiraRestClient.getClient();
    }

    protected JsonReader toJsonReader(InputStream inputStream)
			throws UnsupportedEncodingException {

		Validate.notNull(inputStream);
		InputStreamReader reader = new InputStreamReader(inputStream, "UTF-8");
		JsonReader jsonReader = new JsonReader(reader);
		jsonReader.setLenient(true);
		return jsonReader;
	}

	protected URIBuilder buildPath(String... paths) throws URISyntaxException {
		URIBuilder uriBuilder = new URIBuilder(baseUri);
		String basePath = uriBuilder.getPath();
		for (String path : paths) {
            if(path.startsWith("/")){
                basePath = basePath.concat(path);
            }else{
                basePath = basePath.concat("/").concat(path);
            }
		}
		uriBuilder.setPath(basePath);
		return uriBuilder;
	}
}
