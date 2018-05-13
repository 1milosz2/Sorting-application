package com.companyName.List;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ListWriter {

    public void flush(WordList list, String output) {
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
        String communicate = "List have been exported to an external file ";
        System.out.println(communicate + output);
    }

    public void flush(WordList list) {
         String outputFileName = "sorted.txt";
         flush(list,outputFileName);
            }

    private void initializeOutputFileIfNotExists(String outputFileName) {
        File registry = new File(outputFileName);
        try {
            boolean created = registry.exists();
            if (!created) registry.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

