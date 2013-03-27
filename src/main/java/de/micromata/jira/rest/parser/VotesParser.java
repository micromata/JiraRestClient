package de.micromata.jira.rest.parser;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;

import de.micromata.jira.rest.domain.VotesBean;

public class VotesParser extends BaseParser {

	public static VotesBean parse(JsonObject object) {
		VotesBean bean = new VotesBean();
		parseBaseProperties(bean, object);
		int votes = object.get(PROP_VOTES).getAsInt();
		boolean hasVoted = object.get(PROP_HAS_VOTED).getAsBoolean();
		bean.setVotes(votes);
		bean.setHasVoted(hasVoted);
		return bean;
	}

	public static List<VotesBean> parse(List<JsonObject> objects) {
        List<VotesBean> retval = new ArrayList<VotesBean>();
        for (JsonObject object : objects) {
        	VotesBean votesBean = parse(object);
            retval.add(votesBean);
        }
        return retval;
    }
}
