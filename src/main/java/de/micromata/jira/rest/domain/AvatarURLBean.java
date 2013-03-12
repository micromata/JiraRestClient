package de.micromata.jira.rest.domain;

import java.net.URI;

/**
 * Created with IntelliJ IDEA.
 * User: Christian
 * Date: 07.03.13
 * Time: 10:21
 * To change this template use File | Settings | File Templates.
 */
public class AvatarURLBean {

    private URI uri16x16 = null;

    private URI uri48x48 = null;

    public URI getUri16x16() {
        return uri16x16;
    }

    public void setUri16x16(URI uri16x16) {
        this.uri16x16 = uri16x16;
    }

    public URI getUri48x48() {
        return uri48x48;
    }

    public void setUri48x48(URI uri48x48) {
        this.uri48x48 = uri48x48;
    }
}
