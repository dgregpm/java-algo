import java.util.Arrays;
import java.lang.Math;

public class ArrayString{
    public static void main(String[] args){
        ArrayString a = new ArrayString();

        //a.MergeSortedArray(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6},3);
        //a.removeElement(new int[]{0,1,2,2,3,0,4,2},2);
        //a.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});
        //a.removeDuplicatesII(new int[]{0,0,1,1,1,1,2,3,3});
        //a.majorityElement(new int[]{2,2,1,1,1,2,2});
        a.rotateII(new int[]{1,2,3,4,5,6,7},-2);
    }

    // 88. Merge Sorted Array
    public void MergeSortedArray(int[] nums1, int m, int[] nums2, int n){
        int ptr1 = m - 1;
        int ptr2 = n - 1;
        int len = (m + n) - 1;
        
        for (int i = len; i >= 0 && ptr2 >= 0; i--) {
            if(ptr1 >= 0 && nums1[ptr1] > nums2[ptr2]){
                nums1[i] = nums1[ptr1];
                ptr1--;
            } else {
                nums1[i] = nums2[ptr2];
                ptr2--;
            }
        }
        System.out.println(Arrays.toString(nums1));
    }

    // 27. Remove Element
    public int removeElement(int[] nums, int val){
        int ptr = 0;
        int len = nums.length - 1;
        while(ptr <= len){
            if(nums[ptr] == val){
                nums[ptr] = nums[len--];
            } else {
                ptr++;
            }
        }
        System.out.println("K: " + ptr + ", " + Arrays.toString(nums));
        return ptr;
    }

    // 26. Remove Duplicates from Sorted Array
    public int removeDuplicates(int[] nums){
        int cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i-1]){
                nums[cnt] = nums[i];
                cnt++;
            }
        }
        System.out.println("Count: " + cnt + ", " + Arrays.toString(nums));
        return cnt;
    }

    // 80. Remove Duplicates from Sorted Array II
    public int removeDuplicatesII(int[] nums){
        int cnt = 2;
        for (int i = 2; i < nums.length; i++) {
            if(nums[i] != nums[i-2]){
                nums[cnt] = nums[i];
                cnt++;
            }
        }
        System.out.println("Count: " + cnt + ", " + Arrays.toString(nums));
        return cnt;
    }

    // 169. Majority Element
    public int majorityElement(int[] nums){
        int num = 0;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if(cnt == 0){
                num = nums[i];
            }
            if(num == nums[i]){
                cnt++;
            } else {
                cnt--;
            }
        }
        System.out.println("Majority: " + num);
        return num;
    }

    // 189. Rotate Array
    public void rotate(int[] nums, int k){
        int n = nums.length;
        if(Math.abs(k) >= n){
            k = k % n;
        }
        if(k == 0){
            return;
        }
        
        int ptr = 0;
        int prev = 0;
        int max = 0;
                    
        int itr = 0;
        while(max < n) {
            ptr = itr;
            int start = ptr;
            prev = nums[ptr];
            do{
                int curr = prev;
                ptr += k;
                if(ptr >= n){
                    ptr = ptr - n;
                } else if(ptr < 0){
                    ptr = n + ptr;
                }
                prev = nums[ptr];
                nums[ptr] = curr;
                max++;
            }while(ptr != start && max < n);
            itr++;
        }            
       
        System.out.println(Arrays.toString(nums));
    }

    public void rotateII(int[] nums, int k){
        k = k % nums.length;
        if(k == 0){
            return;
        } else if(k < 0){
            k = nums.length + k;
        }
        reverse(nums,0,nums.length - 1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length - 1);

        System.out.println(Arrays.toString(nums));
    }

    private void reverse(int[] nums, int l, int r){
        while(l < r){
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }
    }
/*
    // 121. Best Time to Buy and Sell Stock
    public int maxProfit(int[] prices){
        
    }

    // 122. Best Time to Buy and Sell Stock II
    public int maxProfitII(int[] prices){

    }

    // 55. Jump Game
    public boolean canJump(int[] nums){

    }

    // 45. Jump Game II
    public int jump(int[] nums){

    }
    */
}
