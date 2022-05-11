package com.src.algorithm.datastructure.graph.test;

import com.src.algorithm.datastructure.graph.prod.KeysAndRooms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class KeysAndRoomsTest {

    private KeysAndRooms keysAndRoomsUnderTest;
    private List<List<Integer>> correspondingKeyInRoomCollect;

    @BeforeEach
    void setUp() {
        keysAndRoomsUnderTest = new KeysAndRooms();
        correspondingKeyInRoomCollect = new ArrayList<>();
        correspondingKeyInRoomCollect.add(Arrays.asList(1));
        correspondingKeyInRoomCollect.add(Arrays.asList(2));
        correspondingKeyInRoomCollect.add(Arrays.asList(3));
        correspondingKeyInRoomCollect.add(Arrays.asList());
    }

    @Test
    void testMyself_countKeysAndRooms() {
        assertThat(keysAndRoomsUnderTest.myself_countKeysAndRooms(correspondingKeyInRoomCollect)).isTrue();
    }
}
