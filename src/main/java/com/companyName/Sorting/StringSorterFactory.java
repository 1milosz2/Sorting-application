package com.companyName.Sorting;

public class StringSorterFactory {

    public StringSorterFactory() {
    }

    public static StringSorter getStringSorter(String[] args) {
        SortingStrategy command = resolveCommand(args);
        StringSorter ss = null;
        switch (command) {
            case BUBBLE:
                ss = new BubbleStringSorter();
                break;
            case INSERTION:
                ss = new InsertionStringSorter();
                break;
            case SELECTION:
                ss = new SelectionStringSorter();
                break;
        }
        return ss;
    }

    private static SortingStrategy resolveCommand(String[] args) {
        String c = args[0];
        if ("BUBBLE".equals(c)) {
            return SortingStrategy.BUBBLE;
        } else if ("INSERTION".equals(c)) {
            return SortingStrategy.INSERTION;
        } else if ("SELECTION".equals(c)) {
            return SortingStrategy.SELECTION;
        } else
            throw new IllegalArgumentException("BUBBLE, INSERTION or SELECTION command expected");
    }

}
