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

	ClientResponse response = null;

    public RestException(ClientResponse response) {
            super(response.getClientResponseStatus().getReasonPhrase());
            this.response = response;
    }
}
