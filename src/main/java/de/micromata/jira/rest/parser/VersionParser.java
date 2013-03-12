package de.micromata.jira.rest.parser;

import com.google.gson.JsonObject;
import de.micromata.jira.rest.domain.VersionBean;
import de.micromata.jira.rest.util.DateParser;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Christian
 * Date: 07.03.13
 * Time: 08:36
 * To change this template use File | Settings | File Templates.
 */
public class VersionParser extends BaseParser {




    public static VersionBean parse(JsonObject object){
        VersionBean bean = new VersionBean();
        parseBaseProperties(bean, object);
        String description = object.get(PROP_DESCRIPTION).getAsString();
        bean.setDescription(description);
        String relesaseDateString = object.get(PROP_RELEASEDATE).getAsString();
        Date releaseDate = DateParser.parseDateFormat1(relesaseDateString);
        bean.setReleaseDate(releaseDate);
        boolean archived = object.get(PROP_ARCHIVED).getAsBoolean();
        bean.setArchived(archived);
        boolean released = object.get(PROP_RELEASED).getAsBoolean();
        bean.setReleased(released);
        boolean overdue = object.get(PROP_OVERDUE).getAsBoolean();
        bean.setOverdue(overdue);
        return bean;
    }

    public static List<VersionBean> parse(List<JsonObject> objects){
        List<VersionBean> retval = new ArrayList<VersionBean>();
        for (JsonObject object : objects) {
            VersionBean versionBean = parse(object);
            retval.add(versionBean);
        }
        return retval;
    }
}

