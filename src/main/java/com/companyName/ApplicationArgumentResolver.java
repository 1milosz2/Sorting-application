package com.companyName;

import com.companyName.sorting.SortingStrategy;

public class ApplicationArgumentResolver {

    private static final String DEFAULT_OUTPUT_FILE_NAME = "sorted.txt";

    private String[] args;

    public ApplicationArgumentResolver(String[] args) {
        this.args = args;
    }

    public SortingStrategy getSortingStrategy() {
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

    public String getInputFileName() {
        return args[1]; //validation should be added here
    }

    public String getOutputFileName() {
        return args.length > 2 ? args[2] : DEFAULT_OUTPUT_FILE_NAME;
    }

}
