package com.simple.demo.utils;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;





public class FileUtils {


	private static final  Logger logger = LoggerFactory.getLogger(FileUtils.class);

	private static Random random=new SecureRandom();

	public static String getRandomOTPnumber(int length) {
		String output = "";
		try {
			final String ALPHA_NUM = "0123456789";
			StringBuilder sb = new StringBuilder(10);
			for (int i = 0; i < length; i++) {

				int ndx = random.nextInt(ALPHA_NUM.length());
				sb.append(ALPHA_NUM.charAt(ndx));
			}
			output = sb.toString();
		}

		catch (Exception e1) {
			
//logger.info(AppConstants.TECHNICAL_ERROR,e1);
		}

		return output;
	}

	public static String getRandomString() {
		String output = "";
		try {
			final String ALPHA_NUM = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhhmmss");
			String formattedDate = sdf.format(date);
			StringBuilder sb = new StringBuilder(10);
			for (int i = 0; i < 10; i++) {
				int ndx = random.nextInt(ALPHA_NUM.length());
				sb.append(ALPHA_NUM.charAt(ndx));
			}
			output = sb.toString() + formattedDate;
		}

		catch (Exception e1) {
//			logger.info(AppConstants.TECHNICAL_ERROR,e1);

		}

		return output;
	}

	public String genrateFolderName(String toEncrypt) {
		String ret = "";

		for (int i = 0; i < toEncrypt.length(); i++) {
			ret += ((int) toEncrypt.charAt(i));
		}

		return ret;
	}

	public static String getRandomOrderNumer() {
		String output = "";
		try {
			final String ALPHA_NUM = "0123456789";
			StringBuilder sb = new StringBuilder(10);
			for (int i = 0; i < 5; i++) {
				int ndx = random.nextInt(ALPHA_NUM.length());
				sb.append(ALPHA_NUM.charAt(ndx));
			}
			output = sb.toString();
		}

		catch (Exception e1) {
//			logger.info(AppConstants.TECHNICAL_ERROR,e1);

		}

		return output;
	}

	public static String getRandomAlphaNumericString() {
		String output = "";
		try {
			final String ALPHA_NUM = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			StringBuilder sb = new StringBuilder(10);
			for (int i = 0; i < 10; i++) {
				int ndx = random.nextInt(ALPHA_NUM.length());
				sb.append(ALPHA_NUM.charAt(ndx));
			}
			output = sb.toString();
		}

		catch (Exception e1) {
//			logger.info(AppConstants.TECHNICAL_ERROR,e1);

		}

		return output;
	}

	
	public static String getRandomOrderNumerString() {
		String output = "";
		try {
			final String ALPHA_NUM = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			StringBuilder sb = new StringBuilder(10);
			for (int i = 0; i < 6; i++) {
				int ndx = random.nextInt(ALPHA_NUM.length());
				sb.append(ALPHA_NUM.charAt(ndx));
			}
			output = sb.toString();
		}

		catch (Exception e1) {
//			logger.info(AppConstants.TECHNICAL_ERROR,e1);

		}

		return output;
	}
	
	
	
	public static String getRandomStringPassword(){
		 String output ="";
		 try{
				 final String ALPHA_NUM ="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";  
				            
				 StringBuilder sb = new  StringBuilder(10);  
			      for (int i=0;  i<6;  i++) {  
			         int ndx = random.nextInt(ALPHA_NUM.length());  
			         sb.append(ALPHA_NUM.charAt(ndx));  
			      }  
		         output = sb.toString();
			   }
			
			catch(Exception e1)
		     {
//				logger.info(AppConstants.TECHNICAL_ERROR,e1);
				
		     }
			
			    return output;
			 }	
	
	public static Date calculatemintus(Date d1) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(d1);
		cal.add(Calendar.SECOND, 180);
		Date date = cal.getTime();
		
		System.out.println(date+ "datedate");
		return date;
	}
	
//	public static LocalDateTime localDateTimeFormate() {
//		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//		String formatDateTime = LocalDateTime.now().format(format);
//		LocalDateTime a = LocalDateTime.parse(formatDateTime);
//		return a;
//	}
	
	public static LocalDateTime localDateTimeFormate() {
		 
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime localDateTime = LocalDateTime.now(); // get current date time
 
		String formatDateTime = localDateTime.format(formatter);
 
		return LocalDateTime.parse(formatDateTime, formatter);
	}

//	public static String dateTime(LoginHistory history) {
//		LocalDateTime toDateTime =LocalDateTime.now();
//		history.setToDate(toDateTime);
//		
//		LocalDateTime tempDateTime = LocalDateTime.from( history.getDate() );
//
//		long years = tempDateTime.until( toDateTime, ChronoUnit.YEARS );
//		tempDateTime = tempDateTime.plusYears( years );
//
//		long months = tempDateTime.until( toDateTime, ChronoUnit.MONTHS );
//		tempDateTime = tempDateTime.plusMonths( months );
//
//		long days = tempDateTime.until( toDateTime, ChronoUnit.DAYS );
//		tempDateTime = tempDateTime.plusDays( days );
//
//
//		long hours = tempDateTime.until( toDateTime, ChronoUnit.HOURS );
//		tempDateTime = tempDateTime.plusHours( hours );
//
//		long minutes = tempDateTime.until( toDateTime, ChronoUnit.MINUTES );
//		tempDateTime = tempDateTime.plusMinutes( minutes );
//
//		long seconds = tempDateTime.until( toDateTime, ChronoUnit.SECONDS );
//		
//		long hrsValue=days*24;
//		long hrs=(hours+hrsValue);
//		String dateTime=String.valueOf(hrs);
//		if (dateTime.length()==1) {
//			dateTime="0"+dateTime;
//		}
//		String dateMinutes=String.valueOf(minutes);
//		if (dateMinutes.length()==1) {
//			dateMinutes="0"+dateMinutes;
//		}
//		String dateSeconds=String.valueOf(seconds);
//		if (dateSeconds.length()==1) {
//			dateSeconds="0"+dateSeconds;
//		}
//		String value=dateTime+":"+dateMinutes+":"+dateSeconds;
//		System.out.println("Value :"+value);
//
//		System.out.println( years + " years " + 
//		        months + " months " + 
//		        days + " days " +
//		        hours + " hours " +
//		        minutes + " minutes " +
//		        seconds + " seconds.");
//		return value;
//		
//
//	}

//	public static String getIpAddress() throws UnknownHostException {
//		return InetAddress.getLocalHost().getHostAddress();
//	}
	
	
	

	public static String PasswordGenerator() {
	    
	    String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String specialCharacters = "#@";
        
        String combinedChars = upperCaseLetters + lowerCaseLetters + numbers + specialCharacters;
        Random random = new Random();
        
        // Start the password with a special character
        String password = String.valueOf(specialCharacters.charAt(random.nextInt(specialCharacters.length())));
        
        // Add at least one number to the password
        password += numbers.charAt(random.nextInt(numbers.length()));
        
        // Generate the remaining characters for the password
        for(int i = 1; i < 7; i++) {
            password += combinedChars.charAt(random.nextInt(combinedChars.length()));
        }
        
        return password;
    }
	    
	}


