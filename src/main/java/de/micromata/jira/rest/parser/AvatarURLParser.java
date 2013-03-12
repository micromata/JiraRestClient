package de.micromata.jira.rest.parser;

import com.google.gson.JsonObject;
import de.micromata.jira.rest.domain.AvatarURLBean;
import de.micromata.jira.rest.util.URIParser;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Christian
 * Date: 07.03.13
 * Time: 13:38
 * To change this template use File | Settings | File Templates.
 */
public class AvatarURLParser extends BaseParser {

    public static AvatarURLBean parse(JsonObject object){
        AvatarURLBean bean = new AvatarURLBean();
        String prop16x16 = object.get(PROP_16x16).getAsString();
        URI uri16x16 = URIParser.parseStringToURI(prop16x16);
        String prop48x48 = object.get(PROP_48x48).getAsString();
        URI uri48x48 = URIParser.parseStringToURI(prop48x48);
        bean.setUri16x16(uri16x16);
        bean.setUri48x48(uri48x48);
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
