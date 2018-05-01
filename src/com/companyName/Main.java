package com.companyName;

public class Main {
    public static void main(String[] args) {

        SortingType sortingType = resolveCommand(args);
        String outputFile = initializeOutputFileName(args);

        List myList = new List(args[1], outputFile);

        long startTime = System.nanoTime();

        switch (sortingType) {
            case BUBBLE:
                myList.bubbleSort();
                break;
            case INSERTION:
                myList.insertionSort();
                break;
            case SELECTION:
                myList.selectSort();
                break;
        }

        long elapsedTime = System.nanoTime() - startTime;

        myList.writeListToFile();
        System.out.println("Output file has been created. Sorting took " + elapsedTime + " nanoseconds");
    }

    private static SortingType resolveCommand(String[] args) {
        String c = args[0];
        if ("BUBBLE".equals(c)) {
            return SortingType.BUBBLE;
        } else if ("INSERTION".equals(c)) {
            return SortingType.INSERTION;
        } else if ("SELECTION".equals(c)) {
            return SortingType.SELECTION;
        } else
            throw new IllegalArgumentException("ADD, DELETE or LIST command expected");
    }

    private static String initializeOutputFileName(String[] args) {
        String outputFile;
        if (args.length >= 3) {
            outputFile = args[2];
        } else {
            outputFile = "sorted.txt";
        }
        return outputFile;
    }
}
