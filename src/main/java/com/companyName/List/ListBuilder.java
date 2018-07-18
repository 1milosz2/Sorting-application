package com.companyName.list;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ListBuilder {

    public static ArrayList<String> buildFromFile(String input) {
        File inputFile = new File(input);
        ArrayList<String> list = new ArrayList<>();

        Scanner scanner = null;
        try {
            scanner = new Scanner(inputFile);
            while (scanner.hasNextLine()) {
                String item = scanner.nextLine();
                list.add(item);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.print("Cannot find specified input file.");
            System.exit(1);
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        return list;
    }

}
