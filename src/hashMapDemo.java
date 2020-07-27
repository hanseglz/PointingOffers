import java.util.HashMap;

public class hashMapDemo {
    public static void main(String[] args) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(1,10);
        System.out.println(hashMap.get(1));
        hashMap.put(1,20);
        System.out.println(hashMap.get(1));
    }
}
