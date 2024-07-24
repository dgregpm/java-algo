public class TwoCrystals {
    public static int find(boolean[] breaks){
        int sqrt = (int)Math.sqrt(breaks.length);
        int cnt = sqrt;
        for (int i = sqrt; i < breaks.length; i+= sqrt, cnt+= sqrt) {
            if(breaks[i])
                break;
        }

        cnt -= sqrt;
        for (int i = 0; i < sqrt && cnt < breaks.length; i++, cnt++) {
            if(breaks[cnt])
                return cnt;
        }

        return -1;
    }
}
