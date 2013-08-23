/*
 * Micromata GmbH
 * Copyright (c)
 *
 * 23.08.13 09:14
 * connect
 * Christian
 */

package de.micromata.jira.rest.parser;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import de.micromata.jira.rest.util.ERoles;
import de.micromata.jira.rest.util.JsonConstants;
import de.micromata.jira.rest.util.URIParser;


/**
 * @author Christian Schulze
 * @author Vitali Filippow
 *
 */
public class RolesParser implements JsonConstants {

	public static Map<ERoles, URI> parse(JsonObject object) {
		Map<ERoles, URI> roles = new HashMap<ERoles, URI>();
		
		for(ERoles r : ERoles.values()) {
			JsonElement element = object.get(r.getName());
			if(element != null) {
				String string = element.getAsString();
				URI uri = URIParser.parseStringToURI(string);
				roles.put(r, uri);
			}
		}
		return roles;
	}
	
}
