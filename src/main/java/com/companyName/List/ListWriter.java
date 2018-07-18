package com.companyName.list;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ListWriter {

    public static void flush(List<String> list, String output) {
        initializeOutputFileIfNotExists(output);
        try {
            FileWriter writer = new FileWriter(output);
            for (String str : list) {
                writer.write(str);
                writer.write(System.lineSeparator());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String communicate = "list have been exported to an external file ";
        System.out.println(communicate + output);
    }

    private static void initializeOutputFileIfNotExists(String outputFileName) {
        File registry = new File(outputFileName);
        try {
            boolean created = registry.exists();
            if (!created) registry.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

