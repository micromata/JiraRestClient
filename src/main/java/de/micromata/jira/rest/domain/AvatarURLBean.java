/*
 * Micromata GmbH
 * Copyright (c)
 *
 * 23.08.13 09:14
 * connect
 * Christian
 */

package de.micromata.jira.rest.domain;

import java.net.URI;

/**
 * @author Christian Schulze
 * @author Vitali Filippow
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

	@Override
	public String toString() {
		return "AvatarURLBean [uri16x16=" + uri16x16 + ", uri48x48=" + uri48x48
				+ "]";
	}
}
