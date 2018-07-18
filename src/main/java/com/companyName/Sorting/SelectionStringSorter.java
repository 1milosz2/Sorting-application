package com.companyName.sorting;

import java.util.List;

public class SelectionStringSorter implements StringSorter {

    @Override
    public void sort(List<String> list) {

        for (int i = 0; i < list.size() - 1; i++) {
            int index = i;
            for (int j = i + 1; j < list.size(); j++)
                if (list.get(j).compareTo(list.get(index)) <= 0)
                    index = j;

            String previousWord = list.get(index);
            list.set(index, list.get(i));
            list.set(i, previousWord);
        }
    }
}
