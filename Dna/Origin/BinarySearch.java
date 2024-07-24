public class BinarySearch {
    public static boolean search(int[] haystack, int needle){
        int lo = 0;
        int hi = haystack.length;
        int mid;
        while(lo < hi){
            mid = (lo + hi)/2;
            if(haystack[mid] == needle){
                return true;
            } else if(haystack[mid] < needle){
                lo = mid + 1;
            } else if(haystack[mid] > needle){
                hi = mid;
            }
        }
        return false;
    }
}
