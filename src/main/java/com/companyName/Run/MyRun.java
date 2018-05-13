package com.companyName.Run;

import com.companyName.List.ListWriter;
import com.companyName.List.WordList;
import com.companyName.Sorting.StringSorter;
import com.companyName.Sorting.StringSorterFactory;

import java.time.Duration;
import java.time.LocalDateTime;

public class MyRun implements Runnable {
    private String[] args;

    public MyRun(String[] args) {
        this.args = args;
    }

    @Override
    public void run() {
        WordList wl = new WordList(args);
        StringSorter ss = StringSorterFactory.getStringSorter(args);

        LocalDateTime start = LocalDateTime.now();
        ss.sort(wl);
        LocalDateTime end = LocalDateTime.now();

        Duration between = java.time.Duration.between(start, end);
        System.out.format("Sorting took " + "%02d:%02d:%02d.%03d \n",
                between.toHours(), between.toMinutes(), between.getSeconds(), between.toMillis());
        ListWriter lw = new ListWriter();

        if (args.length < 3) {
            lw.flush(wl);
        } else {
            lw.flush(wl, args[2]);
        }

    }
}
