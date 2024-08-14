import java.util.*;

public class MultiAl {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>(); /// Here we created main list to store relevant inside the array list
        ArrayList<Integer> list1 = new ArrayList<>();// here we added array elment 
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();

        for (int i = 1; i <=5; i++) {

            list1.add(i*1);// 12345
            list2.add(i*2);//246810
            list3.add(i*3);//3 6 9 12 15
        }
        mainList.add(list1);
        mainList.add(list2);
        mainList.add(list3);
        list2.remove(2);

        System.out.println(mainList);
        
        //nested loop
        for (int i = 0; i < mainList.size(); i++) {
            ArrayList<Integer> CurrList = mainList.get(i);// crate new curr list 
            for (int j = 0; j < CurrList.size(); j++) {
                System.out.print(CurrList.get(j)+ " "); // print currlist which Creted above 
            }
            System.out.println();
        }
    }
}
