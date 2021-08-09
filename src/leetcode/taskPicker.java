package leetcode;

import java.util.HashSet;
import java.util.Random;

public class taskPicker {

    public static void main(String[] args) {

        HashSet<Integer> hashSet = new HashSet<>();

        hashSet.add(1);
        hashSet.add(15);
        hashSet.add(21);
        hashSet.add(20);
        hashSet.add(95);

        Random r = new Random();
        int left = 1;
        int right = 100;
        int taskNum = r.nextInt(right - left) + left;
        while (hashSet.contains(taskNum))
            taskNum = r.nextInt(right - left) + left;

        System.out.println(taskNum);
    }
}
