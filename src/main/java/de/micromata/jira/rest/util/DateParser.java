/*
 * Micromata GmbH
 * Copyright (c)
 *
 * 23.08.13 09:14
 * connect
 * Christian
 */

package de.micromata.jira.rest.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Christian Schulze
 * @author Vitali Filippow
 *
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
	
    public static Date parseDateFormat(String dateString, DateParser.Format dateFormat){
        try {
            return dateFormat.simpleDateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
