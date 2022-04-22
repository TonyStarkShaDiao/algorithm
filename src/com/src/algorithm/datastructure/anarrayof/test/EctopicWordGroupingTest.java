package com.src.algorithm.datastructure.anarrayof.test;

import com.src.algorithm.datastructure.anarrayof.prod.EctopicWordGrouping;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EctopicWordGroupingTest {

    private EctopicWordGrouping ectopicWordGrouping;
    private List<List<String>> expectedArray;
    private String[] ectopicWordsArray;

    @BeforeEach
    void setUp() {
        ectopicWordGrouping = new EctopicWordGrouping();
        ectopicWordsArray = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        expectedArray = new ArrayList<>();
        expectedArray.add(new ArrayList<String>() {{
            add("eat");
            add("tea");
            add("ate");
        }});
        expectedArray.add(new ArrayList<String>() {{
            add("tan");
            add("nat");
        }});
        expectedArray.add(new ArrayList<String>() {{
            add("bat");
        }});
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void mySelf_compareCharactersEctopicWordGrouping() {

        List<List<String>> ectopicWordGroupingCollect = ectopicWordGrouping.mySelf_compareCharactersEctopicWordGrouping(ectopicWordsArray);
        Object[] needCheckEctopicWordGroupingArray = ectopicWordGroupingCollect.toArray();
        assertArrayEquals(expectedArray.toArray(), needCheckEctopicWordGroupingArray);
    }
}