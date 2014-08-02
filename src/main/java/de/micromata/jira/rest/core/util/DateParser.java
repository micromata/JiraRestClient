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

package de.micromata.jira.rest.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Christian Schulze
 * @author Vitali Filippow
 */
public class DateParser {

    public enum Format {

        YYYY_MM_DD("yyyy-MM-dd"),
        DD_MMM_YY("dd'/'MMM'/'yy"),
        YYYY_MM_DD_T_HH_MM_SS_SSSZ("yyyy-MM-dd'T'HH:mm:ss.SSSZ"),
        YYYY_MM_DD_HH_MM("yyyy/MM/dd HH:mm"),
        DD_MMM_YYYY("dd. MMM yyyy");

        private final SimpleDateFormat simpleDateFormat;

        private Format(String pattern) {
            simpleDateFormat = new SimpleDateFormat(pattern);
        }

        public SimpleDateFormat getSimpleDateFormat() {
            return simpleDateFormat;
        }

    }

    public static Date parseDateFormat(String dateString, DateParser.Format dateFormat) {
        try {
            return dateFormat.simpleDateFormat.parse(dateString);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return null;
    }

}
