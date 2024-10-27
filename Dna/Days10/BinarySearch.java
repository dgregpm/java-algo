public class BinarySearch {

    public static boolean search(int[] haystack, int needle){
        int lo = 0;
        int hi = haystack.length;
        while(lo < hi){
            int mid = (lo + hi)/2;
            if(haystack[mid] == needle)
                return true;
            if(haystack[mid] < needle)
                lo = mid + 1;
            else if(haystack[mid] > needle)
                hi = mid;
        }
        return false;
    }

}