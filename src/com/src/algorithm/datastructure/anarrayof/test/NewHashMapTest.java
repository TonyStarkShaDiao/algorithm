package com.src.algorithm.datastructure.anarrayof.test;

import com.src.algorithm.datastructure.nodes.prod.NewHashMap;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NewHashMapTest {
   NewHashMap<String ,Object> hashMap;
    @BeforeEach
    void setUp() {
      hashMap =new NewHashMap();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void put() {
        List<Integer> integers = Arrays.asList(1, 2, 3);
        hashMap.put("1",integers);
        List<Integer> integers1 = Arrays.asList(2, 3);
        hashMap.put("1",integers1);
    }

    @Test
    void get() {
        List<Integer> integers1 = Arrays.asList(2, 3);
        hashMap.put("1",integers1);
        List<Integer> list = (List<Integer>) hashMap.get("1");
        assertEquals(list.size(), 2, "获取的元素长度不为2,获取错误");
        Object o = hashMap.get("123");
        assertNull(o);
    }

    @Test
    void remove() {
        List<Integer> integers1 = Arrays.asList(2, 3);
        hashMap.put("1",integers1);
        List<Integer> list = (List<Integer>) hashMap.get("1");
        hashMap.remove("1");
        assertNull(hashMap.get("1"));
    }
}