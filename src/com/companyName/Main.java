package com.companyName;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main (String [] args) {

        String inputFile = args [1];
        String outputFile = args [2];

        List myList = new List(inputFile);

        myList.initializeFileIfNotExists(outputFile);
        myList.selectSort();
        myList.writeListToFile(outputFile, myList);

    }
}
