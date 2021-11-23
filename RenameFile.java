package com.tests;

import java.util.Scanner;

public class RenameFile {

    Scanner userInput = new Scanner(System.in);
    String currentName = "test.txt";
    /*This test method is the basic concept of how the renaming of the file will work.
    It will ask the user for a new name including its extension. This will then be stored as newName
    which will then overwrite the current name.*/
    public void renameFile() {
        System.out.println("Please input a new name: ");
        String newName = userInput.nextLine();
        currentName = newName;

    }
}
