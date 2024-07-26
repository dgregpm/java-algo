public class BinarySearch {

    public static boolean search(int[] haystack, int needle){
        int lo = 0;
        int hi = haystack.length - 1;

        while(lo <= hi){
            int mid = (lo + hi)/2;
            if(haystack[mid] == needle)
                return true;
            else if(haystack[mid] < needle)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return false;
    }

}
