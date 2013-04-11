package de.micromata.jira.rest.parser;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import de.micromata.jira.rest.domain.AttachmentBean;
import de.micromata.jira.rest.domain.UserBean;
import de.micromata.jira.rest.util.DateParser;
import de.micromata.jira.rest.util.JsonElementUtil;
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
        JsonElement filenameElement = object.get(PROP_FILENAME);
        if(JsonElementUtil.checkNotNull(filenameElement) == true){
            String fn = filenameElement.getAsString();
            bean.setFileName(fn);
        }
        JsonElement authorElement = object.get(ELEM_AUTHOR);
        if(JsonElementUtil.checkNotNull(authorElement) == true){
            UserBean authorBean = UserParser.parse(authorElement.getAsJsonObject());
            bean.setAuthor(authorBean);
        }
        JsonElement createdElement = object.get(PROP_CREATED);
        if(JsonElementUtil.checkNotNull(createdElement) == true){
            Date date = DateParser.parseDateFormat1(createdElement.getAsString());
            bean.setCreated(date);
        }
        JsonElement sizeElement = object.get(PROP_SIZE);
        if(JsonElementUtil.checkNotNull(sizeElement) == true){
            int size = sizeElement.getAsInt();
            bean.setSize(size);
        }
        JsonElement mimeTypeElement = object.get(PROP_MIME_TYPE);
        if(JsonElementUtil.checkNotNull(mimeTypeElement) == true){
            String mt = mimeTypeElement.getAsString();
            bean.setMimeType(mt);
        }
        JsonElement contentElement = object.get(PROP_CONTENT);
        if(JsonElementUtil.checkNotNull(contentElement) == true){
            URI curi = URIParser.parseStringToURI(contentElement.getAsString());
            bean.setContent(curi);
        }
        JsonElement thumbmailElement = object.get(PROP_THUMBNAIL);
        if(JsonElementUtil.checkNotNull(thumbmailElement) == true){
            URI turi = URIParser.parseStringToURI(thumbmailElement.getAsString());
            bean.setThumbnail(turi);
        }
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
