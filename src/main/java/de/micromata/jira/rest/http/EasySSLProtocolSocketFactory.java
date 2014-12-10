/////////////////////////////////////////////////////////////////////////////
//
// Project   Micromata Genome Core
//
// User    roger@micromata.de
// Created   29.03.2008
// Copyright Micromata 29.03.2008
//
/////////////////////////////////////////////////////////////////////////////
package de.micromata.jira.rest.http;

import org.apache.commons.httpclient.ConnectTimeoutException;
import org.apache.commons.httpclient.HttpClientError;
import org.apache.commons.httpclient.params.HttpConnectionParams;
import org.apache.commons.httpclient.protocol.SecureProtocolSocketFactory;

import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.net.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * <p>
 * EasySSLProtocolSocketFactory can be used to creats SSL {@link java.net.Socket}s that accept self-signed certificates.
 * </p>
 * <p>
 * This socket factory SHOULD NOT be used for productive systems due to security reasons, unless it is a concious decision and you are
 * perfectly aware of security implications of accepting self-signed certificates
 * </p>
 *
 * <p>
 * Example of using custom protocol socket factory for a specific host:
 *
 * <pre>
 * Protocol easyhttps = new Protocol(&quot;https&quot;, new EasySSLProtocolSocketFactory(), 443);
 * HttpClient client = new HttpClient();
 * client.getHostConfiguration().setHost(&quot;localhost&quot;, 443, easyhttps);
 * // use relative url only
 * GetMethod httpget = new GetMethod(&quot;/&quot;);
 * client.executeMethod(httpget);
 * </pre>
 *
 * </p>
 * <p>
 * Example of using custom protocol socket factory per default instead of the standard one:
 *
 * <pre>
 * Protocol easyhttps = new Protocol(&quot;https&quot;, new EasySSLProtocolSocketFactory(), 443);
 * Protocol.registerProtocol(&quot;https&quot;, easyhttps);
 * HttpClient client = new HttpClient();
 * GetMethod httpget = new GetMethod(&quot;https://localhost/&quot;);
 * client.executeMethod(httpget);
 * </pre>
 *
 * </p>
 *
 * @author <a href="mailto:oleg -at- ural.ru">Oleg Kalnichevski</a>
 *
 * <p>
 * DISCLAIMER: HttpClient developers DO NOT actively support this component. The component is provided as a reference material, which may be
 * inappropriate for use without additional customization.
 * </p>
 */
public class EasySSLProtocolSocketFactory implements SecureProtocolSocketFactory
{

  private SSLContext sslcontext = null;

  private static SSLContext createEasySSLContext()
  {
    try {
      SSLContext context = SSLContext.getInstance("SSL");
      context.init(null, new TrustManager[] { new X509TrustManager() {
        public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException
        {
        }

        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException
        {
        }

        public X509Certificate[] getAcceptedIssuers()
        {
          return null;
        }
      }}, null);
      return context;
    } catch (Exception e) {
      /**
       * @logging
       * @reason Fehler beim erzeugen von SSLContext
       * @action Entwickler kontaktieren
       */
      throw new HttpClientError(e.toString());
    }
  }

  private SSLContext getSSLContext()
  {
    if (this.sslcontext == null) {
      this.sslcontext = createEasySSLContext();
    }
    return this.sslcontext;
  }

  /**
   * @see SecureProtocolSocketFactory#createSocket(String,int,java.net.InetAddress,int)
   */
  public Socket createSocket(String host, int port, InetAddress clientHost, int clientPort) throws IOException, UnknownHostException
  {

    return getSSLContext().getSocketFactory().createSocket(host, port, clientHost, clientPort);
  }

  /**
   * Attempts to get a new socket connection to the given host within the given time limit.
   * <p>
   * To circumvent the limitations of older JREs that do not support connect timeout a controller thread is executed. The controller thread
   * attempts to create a new socket within the given limit of time. If socket constructor does not return until the timeout expires, the
   * controller terminates and throws an {@link ConnectTimeoutException}
   * </p>
   *
   * @param host the host name/IP
   * @param port the port on the host
   * @param params {@link HttpConnectionParams Http connection parameters}
   *
   * @return Socket a new socket
   *
   * @throws java.io.IOException if an I/O error occurs while creating the socket
   * @throws java.net.UnknownHostException if the IP address of the host cannot be determined
   */
  public Socket createSocket(final String host, final int port, final InetAddress localAddress, final int localPort,
      final HttpConnectionParams params) throws IOException, UnknownHostException, ConnectTimeoutException
      {
    if (params == null) {
      throw new IllegalArgumentException("Parameters may not be null");
    }
    int timeout = params.getConnectionTimeout();
    SocketFactory socketfactory = getSSLContext().getSocketFactory();
    if (timeout == 0) {
      return socketfactory.createSocket(host, port, localAddress, localPort);
    } else {
      Socket socket = socketfactory.createSocket();
      SocketAddress localaddr = new InetSocketAddress(localAddress, localPort);
      SocketAddress remoteaddr = new InetSocketAddress(host, port);
      socket.bind(localaddr);
      socket.connect(remoteaddr, timeout);
      return socket;
    }
      }

  /**
   * @see SecureProtocolSocketFactory#createSocket(String,int)
   */
  public Socket createSocket(String host, int port) throws IOException, UnknownHostException
  {
    return getSSLContext().getSocketFactory().createSocket(host, port);
  }

  /**
   * @see SecureProtocolSocketFactory#createSocket(java.net.Socket,String,int,boolean)
   */
  public Socket createSocket(Socket socket, String host, int port, boolean autoClose) throws IOException, UnknownHostException
  {
    return getSSLContext().getSocketFactory().createSocket(socket, host, port, autoClose);
  }
}
