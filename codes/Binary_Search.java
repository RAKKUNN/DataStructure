import java.util.*;
public class Binary_Search {
    public static void main(String[] args) {

        int[] n_arr = {8, 16, 32, 64, 128, 256, 512, 1024}; //n배열

        for (int i = 0; i < 8; i++) {

            int[] seq_result = new int[2];
            int[] bin_result = new int[2];
            int[] bin_arr = new int[n_arr[i]];
            int[] seq_arr = new int[n_arr[i]];

            for (int j = 0; j < bin_arr.length; j++) {
                bin_arr[j] = j;
            }
            Random ran = new Random();
            for (int j = 0; j < seq_arr.length; j++) {

                int num = ran.nextInt(n_arr[i]);
                seq_arr[j] = num;
            }

            int tar = ran.nextInt(n_arr[i]);

            seq_result = seq_search(seq_arr, tar);
            bin_result = bin_search(bin_arr, tar);

            System.out.println("n= " + n_arr[i]);
            System.out.println("목표 값: " + tar);
            System.out.println("순차탐색(count, index): (" + seq_result[0] + ", " + seq_result[1] + ")");
            System.out.println("이진탐색(count, index): (" + bin_result[0] + ", " + bin_result[1] + ")");
            System.out.println("= = = = = = = = = = = = = = = = = = = = = = =");
        }

    }

    public static int[] seq_search(int[] array, int target) {
        int lng = array.length;
        int[] result = new int[2];

        for(int i = 0; i < lng; i++){
            result[0]++;
            if(array[i]==target){
                result[1] = i;
                return result;
            }

        }
        result[1]=-lng;
        return result;
    }
    public static int[] bin_search(int[] array, int target){
        int lng = array.length;
        int low = 0;
        int high = lng - 1;
        int mid;
        int[] result = new int[2];
        while(low<=high){
            mid = (low+high)/2;
            if(target==array[mid]){
                result[1] = mid;
                return result;
            } else if (target>array[mid]) {
                low = mid + 1;
                result[0]++;
            } else {
                high = mid - 1;
                result[0]++;
            }

        }
        result[1] = -lng;
        return result;
    }
}
