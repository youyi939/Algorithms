import java.io.BufferedOutputStream;
import java.util.Arrays;
import java.util.Random;

/**
 * @Author: KenChen
 * @Description:
 * @Date: Create in  2021/5/6 下午7:46
 */
public class Test {
    public static void main(String[] args) {
        int l = 100000;
        shellSort(l);
        insertionSort(l);
        selectionSort(l);
    }

    //归并排序
    public static void mergeSort(){

    }


    //希尔排序
    public static void shellSort(int l){
        int [] nums = initData(l);
        long startTime = System.currentTimeMillis();

        int len = nums.length;
        int temp,gap = len/2;

        while (gap>0){
            for (int i = gap; i < len ; i++) {
                temp = nums[i];                         //进行分组,如果是第一次分组的话，temp等于8
                int preIndex = i - gap;                 //找到组内另一个元素，准备进行插入排序,第一次分组的话就相当于找到了3
                while (preIndex >= 0 && nums[preIndex] > temp){             //进行插入排序
                    nums[preIndex + gap]=nums[preIndex];
                    preIndex -= gap;
                }
                nums[preIndex + gap]=temp;          //执行插入动作
            }
            gap /= 2;                   //首次分组排序后再次分组
        }

        long endTime = System.currentTimeMillis();
        System.out.println(Arrays.toString(nums));
        System.out.println("希尔排序运行时间: "+(endTime-startTime)+" ms");
    }


    //插入排序
    public static void insertionSort(int l){
        int [] nums = initData(l);
        long startTime = System.currentTimeMillis();

        int j;  //已排序列表下标
        int t;  //待排序元素
        for (int i = 0; i < nums.length -1; i++) {
            j = i;
            t = nums[i+1];
            while (j >= 0 && t < nums[j]){
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = t;
        }

        long endTime = System.currentTimeMillis();
        System.out.println(Arrays.toString(nums));
        System.out.println("插入排序运行时间: "+(endTime-startTime)+" ms");
    }

    //选择排序（鸡尾酒排序）
    public static void selectionSort(int l){
        int [] nums = initData(l);
        long startTime = System.currentTimeMillis();
        int t = 0;

        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i; j < nums.length ; j++) {
                if (nums[j] < nums[minIndex]) { //找到最小的数
                    minIndex = j; //将最小数的索引保存
                }
            }
            int temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;

        }

        long endTime = System.currentTimeMillis();
        System.out.println(Arrays.toString(nums));
        System.out.println("选择排序运行时间: "+(endTime-startTime)+" ms,共对比了 "+ t+" 轮");
    }

    //冒泡排序
    public static void bubbleSort(int l){

        int [] nums = initData(l);
//        int [] nums = new int[]{3,2,1,4,6,5,8,7,9,0};
        long startTime = System.currentTimeMillis();

        int t = 0;

        for (int i = 0; i < nums.length -1 ; i++) {

            for (int j = 0; j < nums.length -i -1 ; j++) {
                if (nums[j+1]<nums[j] ){
                    int temp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = temp;
                }
                t = t+1;
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("冒泡排序运行时间: "+(endTime-startTime)+" ms,共对比了 "+ t+" 轮");
    }

    //洗牌算法
    public static void shuffle(int[] nums) {
        Random rnd = new Random();
        for (int i = nums.length - 1; i > 0; i--) {
            int j = rnd.nextInt(i + 1);
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }

        System.out.println(Arrays.toString(nums));
    }


    public static int[] initData(int l){
        int[] nums = new int[l];
        Random random = new Random();
        for (int i = 0; i < nums.length ; i++) {
            nums[i] = random.nextInt(l);
        }
        return nums;
    }


}
