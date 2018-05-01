package com.companyName;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class List implements Serializable {

    private ArrayList<String> list;
    private String input;
    private String output;

    List(String inputFile, String outputFile) {
        this.input = inputFile;
        this.output = outputFile;
        this.list = readListFromFile();
    }

    private ArrayList<String> readListFromFile() {
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

    public void writeListToFile() {
        initializeOutputFileIfNotExists();
        FileWriter writer;
        try {
            writer = new FileWriter(output);
            for (String str : list) {
                writer.write(str);
                writer.write(System.lineSeparator());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initializeOutputFileIfNotExists() {
        File registry = new File(output);
        try {
            boolean created = registry.exists();
            if (!created) registry.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void bubbleSort() {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    Collections.swap(list, j, j + 1);
                }
            }
        }
    }

    public void insertionSort() {
        String temp;
        for (int i = 1; i < list.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (list.get(j).compareTo(list.get(j - 1)) <= 0) {
                    temp = list.get(j);
                    list.set(j, list.get(j - 1));
                    list.set(j - 1, temp);
                }
            }
        }
    }

    public void selectSort() {

        for (int i = 0; i < list.size() - 1; i++) {
            int index = i;
            for (int j = i + 1; j < list.size(); j++)
                if (list.get(j).compareTo(list.get(index)) <= 0)
                    index = j;

            String previousWord = list.get(index);
            list.set(index, list.get(i));
            list.set(i, previousWord);
        }
    }

    public ArrayList<String> getList() {
        return list;
    }
}
