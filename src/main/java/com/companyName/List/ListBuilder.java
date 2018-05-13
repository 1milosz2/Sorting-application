package com.companyName.List;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ListBuilder {

    public ArrayList<String> readListFromFile(String input) {
        File inputFile = new File(input);
        Scanner scanner = null;
        ArrayList<String> list = new ArrayList<>();
        try {
            scanner = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.print("Cannot find specified input file.");
            System.exit(1);
        }
        while (scanner.hasNextLine()) {
            String item = scanner.nextLine();
            list.add(item);
        }
        scanner.close();
        return list;
    }

}
