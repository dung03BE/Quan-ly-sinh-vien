package com.vti.backend.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class DateUtils {
	 public static String DateCreated() {
		 	Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String d = format.format(date);
			return d;
	    }

}
