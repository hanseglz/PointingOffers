package leetcode;

import java.util.HashSet;
import java.util.Random;

public class taskPicker {

    public static void main(String[] args) {

        HashSet<Integer> hashSet = new HashSet<>();

        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);
        hashSet.add(5);
        hashSet.add(11);
        hashSet.add(15);
        hashSet.add(17);
        hashSet.add(19);
        hashSet.add(20);
        hashSet.add(21);
        hashSet.add(22);
        hashSet.add(31);
        hashSet.add(46);
        hashSet.add(53);
        hashSet.add(70);
        hashSet.add(76);
        hashSet.add(94);
        hashSet.add(101);
        hashSet.add(104);
        hashSet.add(108);
        hashSet.add(121);
        hashSet.add(136);
        hashSet.add(141);
        hashSet.add(155);
        hashSet.add(160);
        hashSet.add(169);
        hashSet.add(206);
        hashSet.add(226);
        hashSet.add(234);
        hashSet.add(283);
        hashSet.add(338);
        hashSet.add(448);
        hashSet.add(543);
        hashSet.add(560);
        hashSet.add(617);
        hashSet.add(763);

        Random r = new Random();
        int left = 1;
        int right = 100;
        int taskNum = r.nextInt(right - left) + left;
        while (hashSet.contains(taskNum))
            taskNum = r.nextInt(right - left) + left;

        System.out.println(taskNum);
    }
}
