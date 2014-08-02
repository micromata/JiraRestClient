/*
 * Copyright 2013 the original author or authors.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.micromata.jira.rest.core.parser;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import de.micromata.jira.rest.core.domain.AttachmentBean;
import de.micromata.jira.rest.core.domain.UserBean;
import de.micromata.jira.rest.core.util.DateParser;
import de.micromata.jira.rest.core.util.JsonElementUtil;
import de.micromata.jira.rest.core.util.URIParser;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Christian Schulze
 * @author Vitali Filippow
 */
public class AttachmentParser extends BaseParser {

    public static AttachmentBean parse(JsonObject object) {
        AttachmentBean bean = new AttachmentBean();
        parseBaseProperties(bean, object);
        JsonElement filenameElement = object.get(PROP_FILENAME);
        if (JsonElementUtil.checkNotNull(filenameElement) == true) {
            String fn = filenameElement.getAsString();
            bean.setFileName(fn);
        }
        JsonElement authorElement = object.get(ELEM_AUTHOR);
        if (JsonElementUtil.checkNotNull(authorElement) == true) {
            UserBean authorBean = UserParser.parse(authorElement.getAsJsonObject());
            bean.setAuthor(authorBean);
        }
        JsonElement createdElement = object.get(PROP_CREATED);
        if (JsonElementUtil.checkNotNull(createdElement) == true) {
            Date date = DateParser.parseDateFormat(createdElement.getAsString(), DateParser.Format.YYYY_MM_DD);
            bean.setCreated(date);
        }
        JsonElement sizeElement = object.get(PROP_SIZE);
        if (JsonElementUtil.checkNotNull(sizeElement) == true) {
            int size = sizeElement.getAsInt();
            bean.setSize(size);
        }
        JsonElement mimeTypeElement = object.get(PROP_MIME_TYPE);
        if (JsonElementUtil.checkNotNull(mimeTypeElement) == true) {
            String mt = mimeTypeElement.getAsString();
            bean.setMimeType(mt);
        }
        JsonElement contentElement = object.get(PROP_CONTENT);
        if (JsonElementUtil.checkNotNull(contentElement) == true) {
            URI curi = URIParser.parseStringToURI(contentElement.getAsString());
            bean.setContent(curi);
        }
        JsonElement thumbmailElement = object.get(PROP_THUMBNAIL);
        if (JsonElementUtil.checkNotNull(thumbmailElement) == true) {
            URI turi = URIParser.parseStringToURI(thumbmailElement.getAsString());
            bean.setThumbnail(turi);
        }
        return bean;
    }

    public static List<AttachmentBean> parse(List<JsonObject> list) {
        List<AttachmentBean> attachments = new ArrayList<AttachmentBean>();
        for (JsonObject o : list) {
            AttachmentBean bean = parse(o);
            attachments.add(bean);
        }
        return attachments;
    }
}
