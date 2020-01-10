package test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName Find4Num
 * @Author zhangqx02
 * @Date 2019/12/28 10:17
 * @Description
 */

public class Find4Num {
    public static void main(String[] args){
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        find(4,15,array);

    }
    private static void find(int count,int tag,int[] arr){
        int length = arr.length;
        for (int i = 0; i < length-3; i++ ){
//            int result = arr[i];
            for (int j = i+1; j < length-2;j++){
//                result +=arr[j];
                for (int k = j+1; k < length -1; k++){
//                    result += arr[k];
                    for (int z = k +1; z < length; z++){
                        int result =  arr[i]+arr[j]+arr[k]+arr[z];
                        if (result == tag){
                            System.out.println("found: "+ result+ " " + arr[i] +" "+arr[j] +" "+ arr[k]+ " "+arr[z] );
                        }
                    }
                }
            }

        }
    }
    private static void find2(int count, int tag,int[] arr){
        for (int i = 0; i < arr.length; i ++){
            List<Integer> resultList = new ArrayList<>();
            List<Integer> arrList = new ArrayList(Arrays.asList(arr));
            int sum = 0;
            int index = i;
            while (index < arr.length){
                sum +=arr[index];
                if(sum == tag && resultList.size() == count){
                    resultList.add(index);
                    System.out.println(resultList.toArray());
                    sum -= arr[index];
                    resultList.remove(index);
                    index = resultList.indexOf(resultList.size());
                    sum -= arr[index];
                }else if (sum == tag && resultList.size() < count){
                    resultList.add(index);
                }else if(sum < tag && resultList.size() >= count){
                    sum -= arr[index];
//                    index
                }else{
                    if (!resultList.isEmpty()){
                        resultList.remove(resultList.size());
                        index = resultList.indexOf(resultList.size());
                    }
                }
                index++;
            }
        }
    }
}
