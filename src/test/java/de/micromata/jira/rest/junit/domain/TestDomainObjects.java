package de.micromata.jira.rest.junit.domain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import de.micromata.jira.rest.core.domain.IssueBean;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;

/**
 * User: Christian Schulze
 * Email: c.schulze@micromata.de
 * Date: 19.11.2014
 */
public class TestDomainObjects {

    private static final String ISSUE_FILE = "src\\test\\resource\\issue.json";

    @Test
    public void testIssueObject() throws FileNotFoundException, UnsupportedEncodingException {
        Gson gson = new GsonBuilder().create();
        JsonReader jsonReader = new JsonReader(new FileReader(ISSUE_FILE));
        jsonReader.setLenient(true);
        IssueBean issue = gson.fromJson(jsonReader, IssueBean.class);
        Assert.assertNotNull(issue);
    }


}
