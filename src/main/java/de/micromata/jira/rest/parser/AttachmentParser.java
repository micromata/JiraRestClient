package de.micromata.jira.rest.parser;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.JsonObject;

import de.micromata.jira.rest.domain.AttachmentBean;
import de.micromata.jira.rest.domain.UserBean;
import de.micromata.jira.rest.util.DateParser;
import de.micromata.jira.rest.util.URIParser;

/**
 * Created with IntelliJ IDEA.
 * User: Christian
 * Date: 07.03.13
 * Time: 08:37
 * To change this template use File | Settings | File Templates.
 */
public class AttachmentParser extends BaseParser {

	public static AttachmentBean parse(JsonObject object) {
		AttachmentBean bean = new AttachmentBean();
		parseBaseProperties(bean, object);
		String fn = object.get(PROP_FILENAME).getAsString();
		UserBean authorBean = UserParser.parse(object.get(ELEM_AUTHOR).getAsJsonObject());
		Date date = DateParser.parseDateFormat1(object.get(PROP_CREATED).getAsString());
		int size = object.get(PROP_SIZE).getAsInt();
		String mt = object.get(PROP_MIME_TYPE).getAsString();
		URI curi = URIParser.parseStringToURI(object.get(PROP_CONTENT).getAsString());
		URI turi = URIParser.parseStringToURI(object.get(PROP_THUMBNAIL).getAsString());
		bean.setFileName(fn);
		bean.setAuthor(authorBean);
		bean.setSize(size);
		bean.setCreated(date);
		bean.setMimeType(mt);
		bean.setThumbnail(turi);
		bean.setContent(curi);
		return bean;
	}
	
	public static List<AttachmentBean> parse(List<JsonObject> list) {
		List<AttachmentBean> attachments = new ArrayList<AttachmentBean>();
		for(JsonObject o : list) {
			AttachmentBean bean = parse(o);
			attachments.add(bean);
		}
		return attachments;
	}
}
