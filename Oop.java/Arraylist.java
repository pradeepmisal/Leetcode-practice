import java.util.ArrayList;

public class  Arraylist{
    public static void swap(ArrayList<Integer> list , int idx1, int idx2){
        int temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);
     }
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<Boolean> list3 = new ArrayList<>();

        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(8);
        list1.add(5);

        int idx1 =1 , idx2 = 3;
        System.out.println(list1);
        swap(list1, 1, 3);
        System.out.println(list1);

    }
}