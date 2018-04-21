package com.companyName;

import java.io.IOException;

public class Main {
    public static void main (String [] args) throws IOException {

        String mode = args [0];
        String inputFile = args [1];
        String outputFile = args [2];

        List list = new List(inputFile);

        list.initializeFileIfNotExists(outputFile);

        list.writeListToFile(outputFile);

        System.out.println("I'll sort by " + mode + ", take data from " + inputFile + " and export outcome to " + outputFile);
    }
}
