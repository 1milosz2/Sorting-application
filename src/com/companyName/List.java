package com.companyName;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class List implements Serializable {

    private ArrayList list;

    List(String inputFile) {
        this.list = readListFromFile(inputFile);
    }

    private ArrayList readListFromFile(String inputFile) {
//        throws IOException {
//            FileInputStream fin = null;
//            ObjectInputStream ois = null;
//            try {
//                fin = new FileInputStream(inputFile);
//                ois = new ObjectInputStream(fin);
//                list = (ArrayList<String>) ois.readObject();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            ois.close();
//            fin.close();
//            return list;

        File input = new File(inputFile);
        Scanner scanner = null;
        ArrayList list = new ArrayList();
        try {
            scanner = new Scanner(input);
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

    public void writeListToFile (String outputFile) {

    }

    public void initializeFileIfNotExists(String outputFile)
            throws IOException {
        File registry = new File(outputFile);
        boolean created = registry.createNewFile();
        if (created) {
            list = new ArrayList<>();
//            writeListToFile(outputFile);
        }
    }

    public ArrayList getList() {
        return list;
    }
}
