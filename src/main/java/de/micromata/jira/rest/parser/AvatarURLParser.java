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
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import de.micromata.jira.rest.domain.AvatarURLBean;
import de.micromata.jira.rest.util.URIParser;

import static de.micromata.jira.rest.util.JsonElementUtil.checkNotNull;

/**
 * @author Christian Schulze
 * @author Vitali Filippow
 *
 */
public class AvatarURLParser extends BaseParser {

    public static AvatarURLBean parse(JsonObject object){
        AvatarURLBean bean = new AvatarURLBean();
        
        JsonElement prop16x16Element = object.get(PROP_16x16);
        if(checkNotNull(prop16x16Element)) {
	        String prop16x16 = prop16x16Element.getAsString();
	        URI uri16x16 = URIParser.parseStringToURI(prop16x16);
	        bean.setUri16x16(uri16x16);
        }
        
        JsonElement prop48x48Element = object.get(PROP_48x48);
        if(checkNotNull(prop48x48Element)) {
        	String prop48x48 = prop48x48Element.getAsString();
	        URI uri48x48 = URIParser.parseStringToURI(prop48x48);
	        bean.setUri48x48(uri48x48);
        }
        return bean;
    }

    public static List<AvatarURLBean> parse(List<JsonObject> objects){
        List<AvatarURLBean> retval = new ArrayList<AvatarURLBean>();
        for (JsonObject object : objects) {
            AvatarURLBean avatarURLBean = parse(object);
            retval.add(avatarURLBean);
        }
        return retval;
    }

}
