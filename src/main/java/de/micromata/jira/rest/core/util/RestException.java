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

package de.micromata.jira.rest.core.util;

import de.micromata.jira.rest.core.domain.ErrorBean;
import de.micromata.jira.rest.core.parser.ErrorParser;
import org.apache.commons.httpclient.HttpMethod;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Christian Schulze
 * @author Vitali Filippow
 */
public class RestException extends Exception {

    private int statusCode;

    private String reasonPhrase;

    private ErrorBean restErrorMessage;


    public RestException(int statusCode, String reasonPhrase, ErrorBean restErrorMessage) {
        super(statusCode + " " + reasonPhrase + " " + restErrorMessage);
        this.statusCode = statusCode;
        this.reasonPhrase = reasonPhrase;
        this.restErrorMessage = restErrorMessage;
    }

    public RestException(HttpMethod method) {
        this.statusCode = method.getStatusCode();
        this.reasonPhrase = method.getStatusText();
//        try {
////            InputStream inputStream = method.getResponseBodyAsStream();
////            this.restErrorMessage = ErrorParser.parse(inputStream);
//        } catch (IOException e) {
//            // nothing to say
//        } finally {
            method.releaseConnection();
//        }

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
