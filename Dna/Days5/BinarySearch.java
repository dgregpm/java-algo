public class BinarySearch {

    public static boolean search(int[] haystack, int needle){
        int lo = 0;
        int hi = haystack.length;

        while(lo < hi){
            int mid = (int)((lo + hi)/2);
            if(haystack[mid] == needle)
                return true;
            else if(haystack[mid] < needle)
                lo = mid + 1;
            else 
                hi = mid;
        }
        return false;
    }

}
