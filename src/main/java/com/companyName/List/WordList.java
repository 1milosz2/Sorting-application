package com.companyName.List;

import java.util.ArrayList;

public class WordList extends ArrayList<String> {

    public WordList(String[] args) {
    ListBuilder lb = new ListBuilder();
        ArrayList<String> myList = lb.readListFromFile(args[1]);
    }

}
