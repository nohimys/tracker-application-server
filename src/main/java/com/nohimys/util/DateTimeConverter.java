package com.nohimys.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeConverter {

	private static final String DATE_TIME_STRING_FORMAT = "yyyy-MM-dd HH:mm:ss";

	private DateTimeConverter() {
		// Private constructor to avoid creating instances
	}

	public static Timestamp getTimestampFromString(String dateTimeString) throws ParseException {

		DateFormat dateFormat = new SimpleDateFormat(DATE_TIME_STRING_FORMAT);
		Date date = dateFormat.parse(dateTimeString);

		return new Timestamp(date.getTime());
	}

	public static String getStringFromTimestamp(Timestamp timestamp) {

		DateFormat dateFormat = new SimpleDateFormat(DATE_TIME_STRING_FORMAT);
		return dateFormat.format(new Date(timestamp.getTime()));
	}
}
