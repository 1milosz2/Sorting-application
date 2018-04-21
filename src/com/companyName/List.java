package com.companyName;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class List {

//    private String inputFile;

    private ArrayList<String> list;

    public List(String inputFile) {
        readListFromFile(inputFile);
    }

    public void readListFromFile(String s) {
        File input = new File(s);
        Scanner scanner = null;
        try {
            scanner = new Scanner(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.print("Cannot find specified input file.");
            System.exit(1);
        }
        while (scanner.hasNext()) {
            String item = scanner.next();
            System.out.println("dodaje " + item);
            list.add(item);
        }
        scanner.close();
    }

    public ArrayList<String> getList() {
        return list;
    }
}
