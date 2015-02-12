package de.micromata.jira.rest.core.util;

import org.apache.commons.httpclient.methods.*;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.lang3.CharEncoding;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URI;

/**
 * User: Christian Schulze
 * Email: c.schulze@micromata.de
 * Date: 25.08.2014
 */
public class HttpMethodFactory {


    public static GetMethod createGetMtGetMethod(URI uri){
        if(uri == null) return null;
        GetMethod method = new GetMethod(uri.getPath());
        method.setQueryString(uri.getQuery());
        method.setRequestHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON);
        method.setRequestHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON);
        method.setDoAuthentication(true);
        return method;
    }

    public static PostMethod createPostMethod(URI uri, String body) throws UnsupportedEncodingException {
        if(uri == null) return null;
        PostMethod method = new PostMethod(uri.getPath());
        method.setRequestHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON);
        method.setRequestHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON);
        RequestEntity entity = new StringRequestEntity(body, MediaType.APPLICATION_JSON, CharEncoding.UTF_8);
        method.setRequestEntity(entity);
        return method;
    }

    public static PutMethod createPutMethod(URI uri, String body) throws UnsupportedEncodingException {
        if(uri == null) return null;
        PutMethod method = new PutMethod(uri.getPath());
        method.setRequestHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON);
        method.setRequestHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON);
        RequestEntity entity = new StringRequestEntity(body, MediaType.APPLICATION_JSON, CharEncoding.UTF_8);
        method.setRequestEntity(entity);
        return method;
    }

    public static PostMethod createMultiPartPostMethod(URI uri, File content, String contentType) throws FileNotFoundException {
        if(uri == null) return null;
        PostMethod method = new PostMethod(uri.getPath());
        method.setRequestHeader("X-Atlassian-Token", "nocheck");
        Part[] parts = {new FilePart(content.getName(), content, contentType, "UTF-8")};
        MultipartRequestEntity entity = new MultipartRequestEntity(parts, method.getParams());
        method.setRequestHeader(HttpHeaders.CONTENT_TYPE, entity.getContentType());
        method.setRequestEntity(entity);
        return method;
    }
}
