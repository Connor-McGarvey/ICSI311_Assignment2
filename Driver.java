package com.mcgarvey;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("data.txt"));
        /**
         * Instantiates the People Database
         */
        ADTPeopleDB dataBase = new ADTPeopleDB();

        /**
         * Populates Database with data from text file
         * 20 people get a name, phone number and birthday
         */

        while (sc.hasNextLine()) {
            String[] arrayOfLine = sc.nextLine().split(",");
            String name = arrayOfLine[0];
            String phoneNumber = arrayOfLine[1];
            String month = arrayOfLine[2];
            int day = Integer.parseInt(arrayOfLine[3]);
            int year = Integer.parseInt(arrayOfLine[4]);

            dataBase.newContact(name, phoneNumber, month, day, year);

        }

        /**
         * Print Tree Inorder
         *
         * Print based on birth Month
         * Print based on birth Month
         *
         * Print Tree Preorder
         */
        dataBase.inorder();

        dataBase.searchMonth("June");
        dataBase.searchMonth("September");

        dataBase.preorder();


        /**
         * Demonstrates Search call of a name that is in the tree
         * Demonstrates Remove Method of a name that is in the tree
         * Demonstrates Error message for searching a name not in the tree && Demonstrates Remove method worked
         * Demonstrates Error message for trying to remove a name not in the tree
         * Demonstrates Adding New Contact
         * Demonstrates Adding New Contact
         * Demonstrates Adding New Contact
         * Demonstrates that those contacts were actually added
         * Demonstrates that those contacts were actually added
         * Demonstrates that those contacts were actually added
         */
        System.out.println("\n--- TESTING Search, remove Contact, new Contact ---\n");

        dataBase.search("Olivia Red");
        dataBase.removeContact("Olivia Red");
        dataBase.search("Olivia Red");
        dataBase.removeContact("Mark");
        dataBase.newContact("Mark");
        dataBase.newContact("Joey Evans", "5145698745");
        dataBase.newContact("Janice Kyle", "8452365489", "August", 21, 1898);
        dataBase.search("Mark");
        dataBase.search("Joey Evans");
        dataBase.search("Janice Kyle");
        dataBase.removeContact("Joey Evans");

        /**
         * Demonstrates modify number and modify birthday
         */
        System.out.println("\n--- TESTING modify Number and modify Birthday ---\n");

        dataBase.modifyNumber("Janice Kyl", "0000000000");
        dataBase.search("Janice Kyle");
        dataBase.modifyNumber("Mark", "9876543210");
        dataBase.search("Mark");
        dataBase.modifyBirthDay("Mark", "June", 15, 2015);
        dataBase.search("Mark");
    }
}
