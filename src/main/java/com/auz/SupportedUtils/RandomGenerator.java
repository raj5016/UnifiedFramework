package com.auz.SupportedUtils;

import com.google.common.base.CharMatcher;
import org.apache.commons.lang3.RandomStringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public final class RandomGenerator {

    public static String random(Integer length, PermittedCharacters permittedCharacters) {
        String randomString = null;
        if (PermittedCharacters.ALPHABETS.equals(permittedCharacters)) {
            randomString = randomString(length);
        } else if (PermittedCharacters.NUMERIC.equals(permittedCharacters)) {
            randomString = randomInteger(length);
        } else if (PermittedCharacters.ALPHANUMERIC.equals(permittedCharacters)) {
            randomString = randomAlphanumeric(length);
        } else if (PermittedCharacters.ANY_CHARACTERS.equals(permittedCharacters)) {
            randomString = randomAsciiCharacters(length);
        } else if (PermittedCharacters.ANY_CHARACTERS_SUPPORTS_MULTILINGUAL.equals(permittedCharacters)) {
            randomString = randomAsciiCharacters(length);
        }else if (PermittedCharacters.EMAIL.equals(permittedCharacters)) {
            randomString = randomEmailAddress(length);
        }
        return randomString;
    }
   
    /**
     * Generates random Number.
     *
     * @param length length of random number to be generated
     */
    private static String randomInteger(Integer length) {
        return RandomStringUtils.randomNumeric(length);
    }

    /**
     * Generates random String.
     *
     * @param length length of random characters to be generated
     */
    private static String randomString(Integer length) {
        return RandomStringUtils.random(length, true, false);
    }

    /**
     * Generates random alphanumeric String.
     *
     * @param length length of random alphanumeric characters to be generated
     */
    private static String randomAlphanumeric(Integer length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }

    /**
     * Generates random alphabetic String.
     *
     * @param length length of random alphabetic characters to be generated
     */
    public static String randomAlphabetic(Integer length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    /**
     * Generates random emailaddress for @example.com domain  in lower case
     *
     * @param length length of random alphanumeric characters to be generated for the local part of email address
     */
    public static String randomEmailAddress(Integer length) {
        String email = randomAlphanumeric(length) + "@example.com";
        return email.toLowerCase();
    }

    /**
     * Generates random gender in short text form "M" , "F" , "U"
     * M = Male , F = Female , U = Unspecified
     */
    public static String randomGenderShortText() {
        List<String> gender = new LinkedList<>();
        gender.add("M");
        gender.add("F");
        gender.add("U");
        Random rand = new Random();
        int choice = rand.nextInt(gender.size());
        return gender.get(choice);
    }

    /**
     * Generates random gender in full text form
     * Male , Female , Unspecified
     */
    public static String randomGenderFullText() {
        List<String> gender = new LinkedList<>();
        gender.add("Male");
        gender.add("Female");
        gender.add("Unspecified");
        Random rand = new Random();
        int choice = rand.nextInt(gender.size());
        return gender.get(choice);
    }

    /**
     * Generates random plus or minus
     * "-" , "+"
     */

    public static String randomPlusOrMinus() {
        List<String> item = new LinkedList<>();
        item.add("-");
        item.add("+");

        Random rand = new Random();
        int choice = rand.nextInt(item.size());
        return item.get(choice);
    }


    public static DateTime randomAdultsDOB() {
        DateTime dateTime = new DateTime();
        dateTime = dateTime.minusYears((int) (18 + (Math.random() * ((50 - 18) + 1))));
        return dateTime.minusYears((int) (18 + (Math.random() * ((50 - 18) + 1))));
    }

    public static String formatDate(DateTime dateTime, String dateformat) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(dateformat);
        return dateTime.toString(dateTimeFormatter);
    }

    public static DateTimeFormatter dateFormatterWithLocale(Locale locale) {
        return DateTimeFormat.mediumDate().withLocale(locale);
    }

    public static String dateWithNoLeadingZero(String dateWithLeadingZero) {
        String dateWithNoLeadingZero;
        dateWithNoLeadingZero = CharMatcher.is('0').trimLeadingFrom(dateWithLeadingZero);
        return dateWithNoLeadingZero;
    }

    public static String randomFutureYearDate(String dateformat) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(dateformat);
        DateTime dateTime = new DateTime();
        final DateTime plusYears = dateTime.plusYears((int) (1 + Math.random() * (10 - 1)));
        return plusYears.toString(dateTimeFormatter);
    }

    public static String randomAsciiCharacters(Integer characterAmount) {
        return RandomStringUtils.random(characterAmount, 32, 127, false, false);
    }
    
    public static String getCurrentDate(String dateformat) {
    	DateFormat df = new SimpleDateFormat(dateformat);
    	Date dateobj = new Date();
		return df.format(dateobj);
    }
    
    public static String generateOrderId() {
    	  String orderid = "ORD-" +randomInteger(9);
          return orderid;
    }
    
    public static String getFutureDate(String dateformat) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(dateformat);
        DateTime dateTime = new DateTime();
        final DateTime plusdays = dateTime.plusDays((int) (1 + Math.random() * (10 - 1)));
        return plusdays.toString(dateTimeFormatter);
    }
    
    public static String randomAddress() {
        String address = randomString(3)+" "+randomInteger(2) +"," +"opp. Bharatiya Vidya Bhavan School"+","
        									+ randomString(6)+" "+"Hills" +","+"Hyderabad, Telangana";
        return address;
    }
    
    public static String randomName() {
        String name = "AmitKumar"+randomInteger(4)+randomString(3);
        return name;
    }
    
    public static String randomPhonenumber() {
    	int mobilefirstindex = ThreadLocalRandom.current().nextInt(6, 10);
    	String mobileotherindex=RandomGenerator.random(9, PermittedCharacters.NUMERIC);
    	String mobileNum=mobilefirstindex+mobileotherindex;
        return mobileNum;
    }
    
    public static String randomTabletName() {
        String tabletName = "AP PROTEIN SUPP" +randomAlphabetic(2)+""+randomInteger(3)+"G";
        return tabletName.toUpperCase();
    }
    
    public static String randomTabletId() {
        String tabletName = "AP0" +randomInteger(3)+"G";
        return tabletName;
    }
    
    
    public static String randomJobTiTle() {
        String jobtitle = "Senior Developement Test" +randomAlphabetic(2)+"Engineer"+" "+randomInteger(3);
        return jobtitle;
    }
    
    public static String randomMinSalary() {
    	String minSalary=1+""+randomInteger(2);
		return minSalary;
    	
    }
    
    public static String randomMaxSalary() {
    	String maxSalary=2+""+randomInteger(2);
		return maxSalary;
    	
    }

    public static String randomCompanyName() {
        String tabletName = "Procter & Gamble" +randomAlphabetic(2)+""+randomInteger(3)+"srl";
        return tabletName.toUpperCase();
    }
    
    public static String randomCurrentDesgination() {
        String tabletName = "Associate Project" +randomInteger(3)+"Engineer";
        return tabletName;
    }
    
    
    public static String randomStageTitle() {
        String stageTitle = "OnScreenRound"+"000"+randomInteger(3);
        return stageTitle;
    }
    
    public static String randomLocation() {
        String location = "Cananda"+randomInteger(4);
        return location;
    }
    
	
}