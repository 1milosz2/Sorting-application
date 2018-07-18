package com.companyName.sorting;

public class StringSorterFactory {

    public static StringSorter getStringSorter(SortingStrategy strategy) {
        switch (strategy) {
            case BUBBLE:
                return new BubbleStringSorter();
            case INSERTION:
                return new InsertionStringSorter();
            case SELECTION:
                return new SelectionStringSorter();
        }
        //throw exception
        return null;
    }

}
