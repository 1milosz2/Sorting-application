package com.companyName;

public class Main {
    public static void main (String [] args) {

        String mode = args [0];
        String inputFile = args [1];
        String outputFile = args [2];

//        List list = new List(inputFile);

//        System.out.println(list.getList());

        System.out.println("I'll sort by " + mode + ", take data from " + inputFile + " and export outcome to " + outputFile);
    }
}
