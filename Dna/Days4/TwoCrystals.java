public class TwoCrystals {
    public static int find(boolean[] breaks){
        int sqrt = (int)Math.sqrt(breaks.length);
        int cnt = 0;
        for (; cnt < breaks.length; cnt+=sqrt) {
            if(breaks[cnt])
                break;
        }
        cnt -= sqrt - 1;
        for (int i = 0; i < sqrt && cnt < breaks.length; i++,cnt++) {
            if(breaks[cnt])
                return cnt;
        }
        return -1;
    }
}
