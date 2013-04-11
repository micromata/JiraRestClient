package de.micromata.jira.rest.parser;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import de.micromata.jira.rest.domain.VotesBean;
import de.micromata.jira.rest.util.JsonElementUtil;

import java.util.ArrayList;
import java.util.List;

public class VotesParser extends BaseParser {

    public static VotesBean parse(JsonObject object) {
        VotesBean bean = new VotesBean();
        parseBaseProperties(bean, object);
        JsonElement votesElement = object.get(PROP_VOTES);
        if (JsonElementUtil.checkNotNull(votesElement) == true) {
            int votes = votesElement.getAsInt();
            bean.setVotes(votes);
        }
        JsonElement hasVotedElement = object.get(PROP_HAS_VOTED);
        if (JsonElementUtil.checkNotNull(hasVotedElement) == true) {
            boolean hasVoted = hasVotedElement.getAsBoolean();
            bean.setHasVoted(hasVoted);
        }
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
