package DivideAndConquer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ms1714 {
    public int[] smallestK(int[] arr, int k) {
        List<Integer>arrList=new ArrayList<>(),resList;
        for (int i : arr) {
            arrList.add(i);
        }
//        System.out.println(arr.length);
        if (k==0){
            return new int[0];
        }
        if (k== arr.length){
            return arr;
        }
        resList=divide(arrList, k);
        int[] res=new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i]=resList.get(i);
        }
        return res;
    }

    private List<Integer> divide(List<Integer>arrList, int k){
        if (arrList==null||arrList.size()==0){
            return arrList;
        }
        List<Integer>left=new ArrayList<>(),right=new ArrayList<>();
        int index=(int) (Math.random()*arrList.size());
        int pivot=arrList.get(index);
        for (int i = 0; i < arrList.size(); i++) {
            if (i==index){
                continue;
            }
            if (arrList.get(i)<=pivot){
                left.add(arrList.get(i));
            }
            else {
                right.add(arrList.get(i));
            }
        }
        if (left.size()==k){
            return left;
        }
        else if (left.size()+1==k){
            left.add(pivot);
            return left;
        }
        else if (left.size()>k){
            return divide(left, k);
        }
        else {
            left.add(pivot);
            List<Integer>res=divide(right, k- left.size());
            left.addAll(res);
            return left;
        }
    }

    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3};

    }
}
