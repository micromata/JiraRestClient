/*
 * Copyright 2013 the original author or authors.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.micromata.jira.rest.util;

import com.sun.jersey.api.client.ClientResponse;
import de.micromata.jira.rest.domain.ErrorBean;
import de.micromata.jira.rest.parser.ErrorParser;

/**
 * @author Christian Schulze
 * @author Vitali Filippow
 */
@SuppressWarnings("serial")
public class RestException extends Exception {

    private int statusCode;

    private String reasonPhrase;

    private ErrorBean restErrorMessage;

    /**
     * Instantiates a new REST exception.
     *
     * @param response the response of the client
     */
    public RestException(ClientResponse response) {
        this(response.getStatus(), response.getClientResponseStatus().getReasonPhrase(),
                ErrorParser.parse(response.getEntityInputStream()));
    }

    public RestException(int statusCode, String reasonPhrase, ErrorBean restErrorMessage) {
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

    public ErrorBean getRestErrorMessage() {
        return restErrorMessage;
    }

    public void setRestErrorMessage(ErrorBean restErrorMessage) {
        this.restErrorMessage = restErrorMessage;
    }
}
