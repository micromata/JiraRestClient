package de.micromata.jira.rest.util;

import com.sun.jersey.api.client.ClientResponse;

import de.micromata.jira.rest.parser.ErrorParser;

/**
 * Created with IntelliJ IDEA.
 * User: Christian
 * Date: 06.03.13
 * Time: 13:20
 * To change this template use File | Settings | File Templates.
 */
@SuppressWarnings("serial")
public class RestException extends Exception {

	private int statusCode;
	
	private String reasonPhrase;
	
	private String restErrorMessage;
	
    /**
     * Instantiates a new REST exception.
     *
     * @param response the response of the client
     */
    public RestException(ClientResponse response) {
    	this(response.getStatus(), response.getClientResponseStatus().getReasonPhrase(), 
            		ErrorParser.parse(response.getEntityInputStream()));
    }
	
	public RestException(int statusCode, String reasonPhrase, String restErrorMessage) {
		super(statusCode + " " + reasonPhrase + " " + restErrorMessage);
		this.statusCode = statusCode;
		this.reasonPhrase = reasonPhrase;
		this.restErrorMessage = restErrorMessage;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getReasonPhrase() {
		return reasonPhrase;
	}

	public void setReasonPhrase(String reasonPhrase) {
		this.reasonPhrase = reasonPhrase;
	}

	public String getRestErrorMessage() {
		return restErrorMessage;
	}

	public void setRestErrorMessage(String restErrorMessage) {
		this.restErrorMessage = restErrorMessage;
	}
}
