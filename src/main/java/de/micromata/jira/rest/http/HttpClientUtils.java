package de.micromata.jira.rest.http;

import org.apache.commons.httpclient.HttpMethod;

import java.io.IOException;
import java.io.InputStream;

/**
 * User: Christian Schulze
 * Email: c.schulze@micromata.de
 * Date: 25.08.2014
 */
public class HttpClientUtils {

    public static String getResponseBodyAsString(HttpMethod method) throws IOException
    {
        final InputStream in = method.getResponseBodyAsStream();
        StringBuilder sb = new StringBuilder();
        byte[] b = new byte[4096];
        for (int n; (n = in.read(b)) != -1;) {
            sb.append(new String(b, 0, n, "utf-8"));
        }
        return sb.toString();
    }
}
