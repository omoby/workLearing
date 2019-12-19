package pointoffer;


/**
 * @ClassName JP01Test
 * @Author zhangqx02
 * @Date 2019/12/9 17:56
 * @Description
 */

public class JP01Test {
    public static void main(String[] args){
        int target = 15;
        JP01 jp01 = new JP01();
        long startTime = getCurrentTime();
//        boolean isContain = jp01.find(target,getArray());
        boolean isContain = jp01.proFind(target,getArray());
        long endTime = getCurrentTime();
        System.out.println("Array contains "+target +" is "+ isContain);
        System.out.println("Using time: "+( endTime - startTime) +" ms");
        System.out.println("Start Time: "+ startTime);
        System.out.println("End Time: "+ endTime);


    }
    private static int[][] getArray(){
        int[][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        return array;
    }
    private static long getCurrentTime(){
        long curTime = System.currentTimeMillis();
        return curTime;
    }
}
