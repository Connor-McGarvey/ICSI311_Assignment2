package com.mcgarvey;

import java.util.StringTokenizer;

/**
 * Represents a person
 * Each person has a name, phone number, and a birthday.
 *
 * @author Connor McGarvey
 * @version 1.0
 */

public class Person implements Comparable {
    /**
     * Instance Variables
     * name is the name of this person
     * phoneNumber is this persons phone number
     * birthdayMonth is this persons birth month
     * birthdayDay is this persons birth date
     * birthdayYear is this persons birth year
     */

    String name;
    String phoneNumber;
    String birthdayMonth;
    int birthDay;
    int birthYear;

    /**
     * Default Constructor for Person.
     * Takes no parameters, sets string to null and int to 0.
     */
    public Person() {
        name = null;
        phoneNumber = null;
        birthdayMonth = null;
        birthDay = 00;
        birthYear = 0000;
    }

    /**
     * Constructor for Person. Takes one parameter, a String name.
     * The parameter is used to set the name of the person.
     *
     * @param name used to set the name of the person.
     */

    public Person(String name) {
        this.name = name;
    }

    /**
     * Constructor for person, takes name and phone number
     * Assigns name to name and phone number to phone number
     *
     * @param name
     * @param phoneNumber
     */
    public Person(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Constructor for person, takes name and phone number and birthday
     */
    public Person(String name, String phoneNumber, String birthMonth, int birthDay, int birthYear) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthdayMonth = birthMonth;
        this.birthDay = birthDay;
        this.birthYear = birthYear;
    }

    /**
     * Set method for name
     * Public Method Used to set the name of a Person object
     * The string passed will be used to reset the name
     *
     * @param name the name in which you are setting the value to
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get method for name. Used to return a string containing the name of this person.
     *
     * @return String containing the name of this person.
     */
    public String getName() {
        return name;
    }

    /**
     * get method for phone number. Used to return a string containing the phone number of this person.
     *
     * @return The string containing the phone number of this person.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * set method for phone number. Used to change or set the phone number of this person. Takes a string as parameter and sets the
     * value of this persons phone number to the value passed in.
     *
     * @param phoneNumber The string that will be set as this persons phone number
     */

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * get method for birthday month. Returns a string containing the birth month of this person.
     *
     * @return The string containing the birthday month of this person.
     */
    public String getBirthdayMonth() {
        return birthdayMonth;
    }

    /**
     * Set method for birthday month. Used to change or set the birthday month of this person.
     * Takes a string and sets that string to the birthday month of this person.
     *
     * @param birthdayMonth The string that will be set as the birthday month of this person.
     */
    public void setBirthdayMonth(String birthdayMonth) {
        this.birthdayMonth = birthdayMonth;
    }

    /**
     * get method for birthday day. Returns a int containing the birth date (00) of this person.
     *
     * @return The int containing the birthday date of this person.
     */
    public int getBirthDay() {
        return birthDay;
    }

    /**
     * Set method for birthday date. Used to change or set the birthday date of this person.
     * Takes an int as a parameter and sets that int to the birthday date of this person.
     *
     * @param birthDay The int that will be set to birthDay
     */
    public void setBirthDay(int birthDay) {
        this.birthDay = birthDay;
    }

    /**
     * get method for birthday year. Returns a int containing the birth year of this person.
     *
     * @return The int containing the birthday year of this person.
     */
    public int getBirthYear() {
        return birthYear;
    }

    /**
     * set method for birthday year. Used to change or set birthday year for this person.
     * int taken as parameter and used to set birthday year.
     *
     * @param birthYear The int that will be set to birthYear for this person.
     */
    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    /**
     * Overridden toString method. Returns string that only contains the name of this person.
     *
     * @return String containing name of this person
     */
    public String toString() {
        return name;
    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
