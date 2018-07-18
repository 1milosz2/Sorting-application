package com.companyName;

import com.companyName.list.ListBuilder;
import com.companyName.list.ListWriter;
import com.companyName.sorting.SortingStrategy;
import com.companyName.sorting.StringSorter;
import com.companyName.sorting.StringSorterFactory;
import com.companyName.timer.ExecutionTimer;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ApplicationArgumentResolver argumentResolver = new ApplicationArgumentResolver(args);

        String inputFileName = argumentResolver.getInputFileName();
        List<String> list = ListBuilder.buildFromFile(inputFileName);

        SortingStrategy strategy = argumentResolver.getSortingStrategy();
        StringSorter sorter = StringSorterFactory.getStringSorter(strategy);

        ExecutionTimer.runAndMeasure(() -> {
            sorter.sort(list);
        });

        String outputFileName = argumentResolver.getOutputFileName();
        ListWriter.flush(list, outputFileName);
    }

}

