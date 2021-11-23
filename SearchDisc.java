package com.tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
//This test method is used to search for a specific disc from the file. This version is unfinished and more parts will be added to make it function properly.
public class SearchDisc {
    Scanner userInput = new Scanner(System.in);
    public void searchDisc() {
        System.out.println("Please write the title of the disc you would like to find: ");
        String searchTerm = userInput.nextLine();
        BufferedReader br = new BufferedReader(FileReader(fileName));

    }
}
