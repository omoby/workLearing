package algs4;




import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @ClassName BinarySearch
 * @Author zhangqx02
 * @Date 2019/12/19 11:45
 * @Description
 * 二分查找
 */

public class BinarySearch {
    public static void main(String[] args){
        String filePath = "D:\\MyFile\\workLearning\\spark\\src\\files\\BinarySearch.txt";
//        String filePath = "D:\\MyFile\\books\\算法\\Algorithm-binary and brute force\\Algorithm\\largeT.txt";
//        String keyPath = "D:\\MyFile\\books\\算法\\Algorithm-binary and brute force\\Algorithm\\tinyT.txt";
        File input = new File(filePath);

        InputStreamReader reader;
        BufferedReader bufferedReader ;
        String data = "";
        String key = "";
        if (input.exists()){
            FileInputStream inputStream ;
            try{
                inputStream = new FileInputStream(input);
                reader = new InputStreamReader(inputStream);
                bufferedReader = new BufferedReader(reader);
                try {
                    data = bufferedReader.readLine();
                    key = bufferedReader.readLine();
//                    Stream<String> lines = bufferedReader.lines();
//                    lines.count();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }catch ( FileNotFoundException e){
                e.printStackTrace();
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (!data.isEmpty()){
            String[] dataStr = data.trim().split(" ");
            for (String elem: dataStr){
                arrayList.add(Integer.valueOf(elem));
            }
        }
        int[] arr = new int[arrayList.size()];
        for (int i =0 ; i < arr.length;i++){
            arr[i] = arrayList.get(i);
        }
        int keyValue = Integer.valueOf(key);
        Arrays.sort(arr);
//        int index = rank(arr,keyValue);
        int index = rank(keyValue,arr);
        System.out.println("data: "+ Arrays.toString(arr));
        System.out.println("key: "+ keyValue);
        System.out.println("index: "+index);


    }

    /**
     * 二分查找算法
     * @param arr
     * @param key
     * @return
     */
    private static int rank(int[] arr,int key){
        int start = 0;
        int end = arr.length-1;
        while (start <= end){
            int mid = start + (start + end) / 2;
            if (key == arr[mid]){
                return mid;
            }else if (key < arr[mid]){
                end = mid -1;
            }else {
                start = mid + 1;
            }
        }
       return -1;
    }

    /**
     * 递归实现二分查找
     * @param key
     * @param arr
     * @return
     */
    public static int rank(int key,int[] arr){
        return rank(key,arr,0,arr.length-1);
    }

    private static int rank(int key,int[] arr,int low,int hight){
        int mid = low + (hight - low) / 2;
        if (key < arr[mid]){
            return rank(key,arr,low,mid-1);
        }else if (key > arr[mid]){
            return rank(key,arr,mid + 1,hight);
        }else {
            return mid;
        }
    }
}
