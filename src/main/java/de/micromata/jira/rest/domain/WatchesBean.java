/*
 * Micromata GmbH
 * Copyright (c)
 *
 * 23.08.13 09:14
 * connect
 * Christian
 */

package de.micromata.jira.rest.domain;

/**
 * @author Christian Schulze
 * @author Vitali Filippow
 */
public class WatchesBean extends BaseBean {

	private int watchCount;
	
	private boolean isWatching;

	public int getWatchCount() {
		return watchCount;
	}

	public void setWatchCount(int watchCount) {
		this.watchCount = watchCount;
	}

	public boolean isWatching() {
		return isWatching;
	}

	public void setWatching(boolean isWatching) {
		this.isWatching = isWatching;
	}
}
