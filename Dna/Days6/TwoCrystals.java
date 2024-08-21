public class TwoCrystals {
    public static int find(boolean[] breaks){
        int sqrt = (int)Math.sqrt(breaks.length);
        int i = 0;
        for (; i < breaks.length; i+=sqrt) {
            if(breaks[i])
                break;
        }
        i = i - sqrt + 1;
        for (int j = 0; j < sqrt && i < breaks.length; j++,i++) {
            if(i < 0)
                continue;
            if(breaks[i])
                return i;
        }
        return -1;
    }
}
