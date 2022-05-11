package com.src.algorithm.datastructure.graph.prod;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/**
 * 钥匙和房间
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/10
 */
public class KeysAndRooms {


    /**
     * 我自己的计数钥匙和房间
     *
     * @param correspondingKeyInRoomCollect 符合key在里面房间收集
     * @return boolean
     * @error todo 没有考虑到第一个元素不是0号房间的情况
     */
    public boolean myself_countKeysAndRooms(List<List<Integer>> correspondingKeyInRoomCollect) {
        int[] keys = new int[correspondingKeyInRoomCollect.size() + 1];
        for (int rootNumber = 0; rootNumber < correspondingKeyInRoomCollect.size() - 1; rootNumber++) {
            for (Integer roomKeyNumber : correspondingKeyInRoomCollect.get(rootNumber)) {
                keys[roomKeyNumber]++;
            }
            if (keys[rootNumber + 1] == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean myself_BFSKeysAndRooms2(List<List<Integer>> correspondingKeyInRoomCollect) {
        int keyNumber = 0;
        Boolean[] roomIsUnlock = new Boolean[correspondingKeyInRoomCollect.size()];
        roomIsUnlock[0] = true;
        Queue<Integer> keyQueue = new ArrayDeque<>();
        keyQueue.add(0);
        while (!keyQueue.isEmpty()) {
            int roomNumber = keyQueue.poll();
            keyNumber++;
            for (Integer roomKeyNumber : correspondingKeyInRoomCollect.get(roomNumber)) {
                if (!roomIsUnlock[roomKeyNumber]) {
                    roomIsUnlock[roomKeyNumber] = true;
                    keyQueue.offer(roomKeyNumber);
                }
            }
        }
        return keyNumber == correspondingKeyInRoomCollect.size();
    }

}
