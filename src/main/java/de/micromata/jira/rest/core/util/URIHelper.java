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

import org.apache.commons.validator.routines.UrlValidator;
import org.apache.http.client.utils.URIBuilder;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author Christian Schulze
 * @author Vitali Filippow
 */
public class URIHelper {

    public static URI parseStringToURI(String uri) {
        String[] schemes = {"http","https"};
        UrlValidator urlValidator = new UrlValidator(schemes, UrlValidator.ALLOW_LOCAL_URLS);
        if(urlValidator.isValid(uri)){
            try {
                return new URI(uri);
            } catch (URISyntaxException e) {
                return null;
            }
        }
        return null;
    }


    public static URIBuilder buildPath(URI baseUri, String... paths) throws URISyntaxException {
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
