package de.micromata.jira.rest.util;

import com.sun.jersey.api.client.ClientResponse;

/**
 * Created with IntelliJ IDEA.
 * User: Christian
 * Date: 06.03.13
 * Time: 13:20
 * To change this template use File | Settings | File Templates.
 */
public class RestException extends Exception {

	private static final long serialVersionUID = -4441370450013391046L;

	/** The client response. */
	private ClientResponse response = null;

    /**
     * Instantiates a new REST exception.
     *
     * @param response the response of the client
     */
    public RestException(ClientResponse response) {
            super(response.getClientResponseStatus().getReasonPhrase());
            this.response = response;
    }

	/**
	 * Gets the response.
	 *
	 * @return the response
	 */
	public ClientResponse getResponse() {
		return response;
	}
}
