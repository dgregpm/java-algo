public class TwoCrystals {
    public static int find(boolean[] breaks){
        if(breaks[0])
            return 0;
        int sqrt = (int)Math.sqrt(breaks.length);
        int i = 0;
        for (; i < breaks.length; i += sqrt) {
            if(breaks[i])
                break;
        }
        i -= sqrt + 1;
        for (int j = 0; j < sqrt && i < breaks.length; j++,i++) {
            if(breaks[i])            
                return i;
        }
        return -1;
    }
}
