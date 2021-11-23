package com.tests;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadDisc {
    //This method reads the contents of the file and prints it to the screen.
    public void readDisc() {
        BufferedReader br = new BufferedReader(FileReader(filename));
        String line = br.readLine();
        while (line != null) {
            System.out.println(line);
            line = br.readLine();
        }
        br.close();
    }
}
