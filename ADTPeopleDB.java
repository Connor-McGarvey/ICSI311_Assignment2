package com.mcgarvey;

/**
 * Represents a data base of people objects. Uses a BST to hold the data
 *
 * @author Connor McGarvey
 * @version 1.0
 */

public class ADTPeopleDB {
    /**
     * The BSTGeneric object that will contain all of the people objects with their information
     */
    BSTGeneric tree;

    /**
     * Default Constructor, Takes no input, Tree is set to null
     */
    public ADTPeopleDB() {
        tree = new BSTGeneric();
    }

    /**
     * Constructor takes string name as parameter
     * Creates a new Person with the name you passed in
     *
     * @param name to be created as a new contact
     */

    public void newContact(String name) {
        Person newPerson = new Person(name);
        NodeGeneric node = new NodeGeneric(newPerson);
        tree.insert(node);
    }

    /**
     * Constructor takes a name and a phone number as parameter
     * Creates a new Person with the name and number passed in.
     * New person is inserted into the data tree.
     *
     * @param name        to be created as a new contact
     * @param phoneNumber to be associated with the same contact
     */
    public void newContact(String name, String phoneNumber) {
        Person newPerson = new Person(name, phoneNumber);
        NodeGeneric node = new NodeGeneric(newPerson);
        tree.insert(node);
    }

    /**
     * Constructor takes multiple parameters to fully create the person object (filling in all values)
     *
     * @param name        the name of the new contact
     * @param phoneNumber the number of the new contact
     * @param month       the birth month of the new contact
     * @param day         the birth day of the new contact
     * @param year        the birth year of the new contact
     */


    public void newContact(String name, String phoneNumber, String month, int day, int year) {
        Person newPerson = new Person(name, phoneNumber, month, day, year);
        NodeGeneric node = new NodeGeneric((newPerson));
        tree.insert(node);
    }

    /**
     * Search method takes name as a parameter.
     * Creates a new person with the entered name and uses that node to call the searchBST() method from the tree class
     * Incorporates some conditional checks to avoid run errors
     *
     * @param personName the String name of the person you would like to search for
     */

    public void search(String personName) {
        Person searchPerson = new Person(personName);

        if (tree.searchBST(tree.getRoot(), searchPerson) != null) {
            Person foundPerson = (Person) tree.searchBST(tree.getRoot(), searchPerson).getElement();
            if (foundPerson.getName().compareToIgnoreCase(personName) == 0) {
                System.out.println("---Returning Search Results---");
                System.out.println(foundPerson.name + " | " + foundPerson.phoneNumber + " | " + foundPerson.birthdayMonth + " | " + foundPerson.birthDay + " | " + foundPerson.birthYear);
            }
        } else {
            System.out.println("Error: " + searchPerson + " Not Found");
        }

    }

    /**
     * search by month method. Used to output all contacts of a given month.
     * Takes a month in, outputs all contacts who contain that month
     *
     * @param month the month to be compared to month of all contacts in tree
     */

    public void searchMonth(String month) {
        Person searchPerson = new Person("JOHN DOE", "0000000000", month, 00, 0000);
        GenericTreeIterator treeIterator = new GenericTreeIterator(tree);
        treeIterator.setInorder();
        System.out.println("--Contacts of month " + month + "---");
        while (treeIterator.hasNext()) {
            Person currentPerson = (Person) treeIterator.next();
            if (currentPerson.getBirthdayMonth().compareToIgnoreCase(month) == 0) {
                System.out.println(currentPerson);
            }

        }
        System.out.println("---End of List---");
    }

    /**
     * Remove method takes a name as a parameter
     * Creates a new person with the entered name and uses that node to search for the actual tree node,
     * we then pass that tree node into the removeNode method of the tree class. The node is then removed.
     * Incorporates some conditional checks to avoid run errors
     *
     * @param removeName The name of person you would like to remove from tree
     */

    public void removeContact(String removeName) {
        Person removePerson = new Person(removeName);
        NodeGeneric removeNode = tree.searchBST(tree.getRoot(), removePerson);
        if (removeNode != null) {
            tree.removeNode(removeNode);
            System.out.println("CONTACT DELETED " + removeName + " has been removed");
        } else {
            System.out.println("ERROR: " + removeName + " Not Found");
        }
    }

    /**
     * Used to print the tree of people inorder
     */

//    public void inorder() {
//        System.out.println("\nListing People in inorder\n");
//        GenericTreeIterator treeIterator = new GenericTreeIterator(tree);
//        treeIterator.setInorder();
//        while (treeIterator.hasNext()) {
//            System.out.println(treeIterator.next());
//        }
//    }
    public void inorder() {
        System.out.println("\n---Listing People in inorder---");
        GenericTreeIterator treeIterator = new GenericTreeIterator(tree);
        treeIterator.setInorder();
        while (treeIterator.hasNext()) {
            Person currentPerson = (Person) treeIterator.next();
            System.out.println(currentPerson.name + " | " + currentPerson.phoneNumber + " | " + currentPerson.birthdayMonth + " | " + currentPerson.birthYear);
        }
        System.out.println("---End of List---\n");
    }

    /**
     * Used to print the tree of people preorder
     */

    public void preorder() {
        System.out.println("\n---Listing People in preorder---");
        GenericTreeIterator treeIterator = new GenericTreeIterator(tree);
        treeIterator.setPreorder();
        while (treeIterator.hasNext()) {
            System.out.println(treeIterator.next());
        }
        System.out.println("---End of List---\n");
    }

    /**
     * Method used to modify the phone number of a contact that already exists
     * Pass in contact name and the new phone number
     * Searches for contact by name, creates new person object will same info and new number
     * removes old person adds new person to tree
     * Sends Error message if name is not found in the tree
     *
     * @param name      the name of the contact
     * @param newNumber the new number for the contact
     */

    public void modifyNumber(String name, String newNumber) {
        Person searchPerson = new Person(name);
        if (tree.searchBST(tree.getRoot(), searchPerson) != null) {
            NodeGeneric currentNode = tree.searchBST(tree.getRoot(), searchPerson);
            Person currentPerson = (Person) currentNode.getElement();
            Person newPerson = new Person(name, newNumber, currentPerson.getBirthdayMonth(), currentPerson.getBirthDay(), currentPerson.getBirthYear());
            NodeGeneric newNode = new NodeGeneric(newPerson);
            tree.removeNode(currentPerson);
            tree.insert(newNode);
        } else {
            System.out.println("ERROR: " + name + " Not Found: NO MODIFICATION WERE MADE");
        }
    }

    /**
     * Method used to modify the birth day of a contact that already exists
     * Pass in contact name and the new birth day month year
     * Searches for contact by name, creates new person object will same info and new birthday
     * removes old person adds new person to tree
     * Sends Error message if name is not found in the tree
     *
     * @param name       the name of the contact
     * @param birthMonth the new month for the contact
     * @param day        the new birth date for the contact
     * @param year       the new birth year for the contact
     */

    public void modifyBirthDay(String name, String birthMonth, int day, int year) {
        Person searchPerson = new Person(name);
        if (tree.searchBST(tree.getRoot(), searchPerson) != null) {
            NodeGeneric currentNode = tree.searchBST(tree.getRoot(), searchPerson);
            Person currentPerson = (Person) currentNode.getElement();
            Person newPerson = new Person(name, currentPerson.getPhoneNumber(), birthMonth, day, year);
            NodeGeneric newNode = new NodeGeneric(newPerson);
            tree.removeNode(currentPerson);
            tree.insert(newNode);
        } else {
            System.out.println("ERROR: " + name + " Not Found: NO MODIFICATION WERE MADE");
        }
    }


}
