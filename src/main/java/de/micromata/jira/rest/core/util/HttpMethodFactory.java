package de.micromata.jira.rest.core.util;

import org.apache.commons.codec.CharEncoding;
import org.apache.http.*;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;

import javax.ws.rs.core.MediaType;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.nio.charset.Charset;

/**
 * User: Christian Schulze
 * Email: c.schulze@micromata.de
 * Date: 25.08.2014
 */
public class HttpMethodFactory {


    public static HttpGet createGetMethod(URI uri){
        if(uri == null) return null;
        HttpGet method = new HttpGet(uri);
        setHeader(method);
        return method;
    }

    public static HttpGet createHttpGetForFile(URI uri){
        if(uri == null) return null;
        HttpGet method = new HttpGet(uri);
        method.addHeader (HttpHeaders.ACCEPT,
                MediaType.APPLICATION_OCTET_STREAM);
        return method;
    }

    public static HttpPost createPostMethod(URI uri, String body) throws UnsupportedEncodingException {
        if(uri == null) return null;
        HttpPost method = new HttpPost(uri);
        setHeader(method);
        StringEntity entity = new StringEntity(body, CharEncoding.UTF_8);
        method.setEntity(entity);
        return method;
    }

    public static HttpPut createPutMethod(URI uri, String body) throws UnsupportedEncodingException {
        if(uri == null) return null;
        HttpPut method = new HttpPut(uri);
        setHeader(method);
        StringEntity entity = new StringEntity(body, CharEncoding.UTF_8);
        method.setEntity(entity);
        return method;
    }

    public static HttpPost createMultiPartPostMethod(URI uri, File content, String contentType) throws FileNotFoundException {
        if(uri == null) return null;
        HttpPost method = new HttpPost(uri.getPath());
        method.addHeader("X-Atlassian-Token", "nocheck");
        InputStreamEntity reqEntity = new InputStreamEntity(
                new FileInputStream(content), -1, ContentType.APPLICATION_OCTET_STREAM);
        reqEntity.setChunked(true);
        return method;
    }


    private static void setHeader(HttpMessage httpMessage){
        httpMessage.addHeader(new BasicHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON));
        httpMessage.addHeader(new BasicHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON));
    }
}
