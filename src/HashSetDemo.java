import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        boolean addSuccess1 = hashSet.add(1);
        boolean addSuccess2 = hashSet.add(1);
        hashSet.add("abc");
        hashSet.add('h');
        int[] arr = {1,2,3};
        hashSet.add(arr);

        System.out.println(addSuccess1);
        System.out.println(addSuccess2);

        Iterator iterator = hashSet.iterator();
        while(iterator.hasNext()){
            Object obj = iterator.next();
            if (obj instanceof Integer)
                System.out.println("Interger: " + obj);
            else if (obj instanceof Character)
                System.out.println("Char: " + obj);
            else if (obj instanceof String)
                System.out.println("String: " + obj);
            else if (obj instanceof int[]){
                System.out.print("Array: ");
                for (int num : arr){
                    System.out.print(num + ",");
                }
                System.out.println("");
            }
        }
    }
}
