package com.liebe.algorithmsAndSorting;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class AlgorithmsAndSorting {

    public static int[] insert(int[] datas){
        for(int i=1;i<datas.length;i++){
            int j =i-1;
            while(j>=0&&datas[j]>datas[j+1]){
                int temp = datas[j];
                datas[j] =datas[j+1];
                datas[j+1]=temp;
                j--;
            }
        }
        return datas;
    }

    public static int[] select(int[] datas){
        for(int i=0;i<datas.length;i++){
            int index =i;
            for(int j = i+1;j<datas.length;j++){
                if(datas[index]>datas[j]){
//                    int temp = datas[i];
//                    datas[i] =datas[j];
//                    datas[j]=temp;
                    index=j;
                }
            }
            if(index !=i){
                int temp = datas[i];
                datas[i] =datas[index];
                datas[index]=temp;
            }

        }
        return datas;
    }

    public static int[] quicks(int[] datas,int left,int right){
        if (left<right){
            int data = qq(datas,left,right);
            quicks(datas,left,data-1);
            quicks(datas,data+1,right);
        }
        return datas;
    }

    public static int qq(int[] datas,int left,int right){
        int temp = datas[left];
        while (left<right){
            while (left<right && temp<=datas[right]){
                right--;
            }
            datas[left] =datas[right];
            while (left<right&& temp>=datas[left]){
                left++;
            }
            datas[right]=datas[left];
        }
        datas[left]=temp;
        int data=left;return data;
    }





    public static int[] dubble(int[] datas){
        for(int i=0;i<datas.length-1;i++){
            for(int j=0;j<datas.length-i-1;j++){
                if(datas[j]>datas[j+1]){
                    int temp = datas[j+1];
                    datas[j+1] =datas[j];
                    datas[j] =temp;
                }
            }
        }
        return datas;
    }
    public static void main(String[] arg){

        int[] datas = {2,54,64,34,67,34,23,45};
//        datas = insert(datas);

//        datas = select(datas);
//
        datas = quicks(datas,0,7);
//
//        datas = dubble(datas);

        for(int i:datas) {
            System.out.println("排序后的数组:"+i);
        }

    }









    //todo 算法与排序 算法：插入排序（插入排序 希尔排序）
// todo                交换排序（快速排序 冒泡排序）
// todo                选择排序（选择排序  堆排序）
// todo                归并排序
// todo                分配排序（基数排序）
    // todo    所需辅助空间最多：归并排序

    // todo    所需辅助空间最少：堆排序

    // todo    平均速度最快：快速排序

    // todo   不稳定：快速排序，希尔排序，堆排序。



//todo  1.直接插入排序
    //todo 每一步将一个待排序的记录，插入到前面已经排好序的有序序列中去，直到插完所有元素为止。
//todo（1）基本思想：在要排序的一组数中，假设前面(n-1)[n>=2] 个数已经是排
//todo 好顺序的，现在要把第n 个数插到前面的有序数中，使得这 n个数
//todo 也是排好顺序的。如此反复循环，直到全部排好顺序。

    public static int[] insertSort(int[] datas){

        for(int i=1;i<datas.length;i++){
            int j=i-1;
//            for(;j>=0;j--){
//                if(datas[j+1]<datas[j]){
//                    int temp = datas[j+1];
//                    datas[j+1]=datas[j];
//                    datas[j]=temp;
//                }
//            }

//            for(;j>=0 && datas[j+1]<datas[j];j--){
//                int temp = datas[j+1];
//                    datas[j+1]=datas[j];
//                    datas[j]=temp;
//            }
//            int index =datas[j+1];
//            for(;j>=0 && index<datas[j];j--){
//                datas[j+1]=datas[j];
//            }
//            datas[j+1]=index;

            while(j>=0&&datas[j+1]<datas[j]){
                int temp = datas[j+1];
                    datas[j+1]=datas[j];
                    datas[j]=temp;
                    j--;
            }

        }
        return datas;

    }

    /**
     * 插入排序法
     *
     * @param datas
     */
    public static int[] sortInsert(int[] datas) {
        for (int i = 1; i < datas.length; i++) {
            int j = i - 1;
            AlgorithmUtil.temp = datas[i];
            for (; j >= 0 && AlgorithmUtil.temp < datas[j]; j--) {
                datas[j + 1] = datas[j];
            }
            datas[j + 1] = AlgorithmUtil.temp;
        }
        return datas;
    }
  //todo 2.简单选择排序
    //todo（1）基本思想：在要排序的一组数中，选出最小的一个数与第一个位置的数交换；
    //todo 然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一
    //todo 个数比较为止。
//    public static int[] sortSelect(int[] datas){
//
//        for(int i=0;i<datas.length;i++){
//            int index =i;
//            for(int j=i+1;j<datas.length;j++){
//                if(datas[index]>datas[j]){
//                    index = j;
//                }
//            }
//            if(index !=i){
//                int temp = datas[i];
//                datas[i] = datas[index];
//                datas[index] = temp;
//            }
//        }
//        return datas;
//    }


    /**
     * 选择排序
     *
     * @return
     */
    public static int[] sortSelect(int[] datas) {
        for (int i = 0; i < datas.length; i++) {
            int index = i;
            for (int j = i + 1; j < datas.length; j++) {
                if (datas[j] < datas[index])
                    index = j;
            }
            if (i != index)
                AlgorithmUtil.swap(datas, i, index);
        }
        return datas;
    }
// todo 3.冒泡排序
    //todo（1）基本思想：在要排序的一组数中，对当前还未排好序的范围内的全部数，自上而下对
    //todo 相邻的两个数依次进行比较和调整，让较大的数往下沉，较小的往上冒。即：每当两相邻的
    //todo 数比较后发现它们的排序与排序要求相反时，就将它们互换。
    /**
     * 冒泡排序
     *
     * @return
     */

    public static int[] sortBubble(int[] datas){
        for(int i=0;i<datas.length-1;i++){
            for(int j=0;j<datas.length-1-i;j++){
                if(datas[j]>datas[j+1]){
                    int temp =datas[j+1];
                    datas[j+1] = datas[j];
                    datas[j]=temp;
                }
            }
        }
        return datas;
    }

 //todo 4.快速排序
    //todo （1）基本思想：选择一个基准元素,通常选择第一个元素或者最后一个元素,通过一趟扫描，
    //todo 将待排序列分成两部分,一部分比基准元素小,一部分大于等于基准元素,此时基准元素在其
    //todo 排好序后的正确位置,然后再用同样的方法递归地排序划分的两部分。

    public static int quick(int[] datas,int left,int right){
        int index = datas[left];
        while (left<right){
            while (left<right && index<=datas[right]){
//                --right;
                right--;
            }
            datas[left] =datas[right];
            while (left<right && index>=datas[left]){
//                ++left;
                left++;
            }
            datas[right]=datas[left];
        }
        datas[left]=index;
        return left;
    }

    public static int[] digui(int[] datas,int left ,int right){
        if (left<right){
            int data = quick(datas,left,right);
            digui(datas,left,data-1);
            digui(datas,data+1,right);
        }

        return datas;
    }

    /**
     * 快速排序；分割数组
     *
     * @param datas
     */
    public static int QuickPartition(int[] datas, int left, int right) {
        int pivot = datas[left];
        while (left < right) {
            while (left < right && datas[right] >= pivot)
                --right;
            datas[left] = datas[right]; // 将比枢轴小的元素移到低端，此时right位相当于空，等待低位比pivotkey大的数补上
            while (left < right && datas[left] <= pivot)
                ++left;
            datas[right] = datas[left]; // 将比枢轴大的元素移到高端，此时left位相当于空，等待高位比pivotkey小的数补上
        }
        datas[left] = pivot; // 当left == right，完成一趟快速排序，此时left位相当于空，等待pivotkey补上
        return left;
    }

    /**
     * 快速排序；递归返回数组
     *
     * @param datas
     */
    public static int[] sortQuick(int[] datas, int left, int right) {
        if (left < right) {
            int data = QuickPartition(datas, left, right);
            sortQuick(datas, left, data - 1);
            sortQuick(datas, data + 1, right);
        }
        return datas;
    }



//    public static void main(String[] arg){

//        ExecutorService executorService = Executors.newFixedThreadPool(1);

//        int[] datas = {2,54,64,34,67,23,45};
//        datas = sortSelect(datas);
//        datas = sortBubble(datas);
//        datas =digui(datas,0,6);

//        datas = sortQuick(datas,0,6);
//        insertSort(datas);
//        sortInsert(datas);
//        insertionSort(datas);
//        for(int i:datas) {
//            System.out.println("排序后的数组:"+i);
//        }
//    }
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                swap(arr,j,j-1);
                j--;
            }
        }
    }
    public static void swap(int []arr,int a,int b){
        arr[a] = arr[a]+arr[b];
        arr[b] = arr[a]-arr[b];
        arr[a] = arr[a]-arr[b];
    }
}
