package com.companyName;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ListTest {

    @Test
    void writesGivenListToAGivenExternalTextFile() {
        List l = new List("random.txt","test1.txt");
        l.writeListToFile();
        List testList = new List("test1.txt","test2.txt");
        assertEquals(l,testList,"The list from output file is different from the original one");
    }

    @Test
    void bubbleSortsGivenListOfStrings() {
        List testList = new List("test3.txt","test4.txt");
        testList.bubbleSort();
        testListAssertion(testList);
    }

    @Test
    void insertionSort() {
        List testList = new List("test3.txt","test4.txt");
        testList.insertionSort();
        testListAssertion(testList);
    }

    @Test
    void selectSort() {
        List testList = new List("test3.txt","test4.txt");
        testList.selectSort();
        testListAssertion(testList);
    }

    private void testListAssertion(List l) {
        assertEquals("A",l.getList().get(0));
        assertEquals("B",l.getList().get(1));
        assertEquals("C",l.getList().get(2));
        assertEquals("D",l.getList().get(3));
    }
}