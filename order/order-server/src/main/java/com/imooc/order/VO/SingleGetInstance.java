package com.imooc.order.VO;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPNE;

public class SingleGetInstance {

    private SingleGetInstance(){};
    private static volatile  SingleGetInstance instance =  null;
    public   static  SingleGetInstance  GetInstance(){
        if(instance==null){
            synchronized (SingleGetInstance.class){
                if(instance==null) {
                    instance = new SingleGetInstance();
                }
            }
        }

        return instance;
    }
    public static void main(String [] args) {
        int[] arr = new int[]{100, 90, 94, 7, 58};

        for (int i = 0; i < arr.length ; i++) {
//            boolean didSwap = false;//优化后最好时间复杂度为n,不优化为n2
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
//                    didSwap = true;
                }
            }
            //以下为优化部分
//            if (didSwap == false) {
//                return;
//            }
        }
//
//        int[] array = new int[]{100, 90, 94, 7, 58};
//            for (int i = 0; i < array.length; i++) {
//                boolean didSwap = false;//优化后最好时间复杂度为n,不优化为n2
//                for (int j = 0; j < array.length - i - 1; j++) {
//
//                    if (array[j] < array[j + 1]) {
//                        int tmp = array[j];
//                        array[j] = array[j + 1];
//                        array[j + 1] = tmp;
//                        didSwap = true;
//                        System.out.println(array[j]);
//                    }
//                }
//                //以下为优化部分
//                if (didSwap == false) {
//                    return;
//                }
//
//            }

        }

}
