public class TwoCrystals {
    public static int find(boolean[] breaks){
        int sqrt = (int)Math.sqrt(breaks.length);
        int i;
        for(i = 0;i<breaks.length;i += sqrt){
            if(breaks[i] == true){
                break;
            }
        }
        i -= sqrt;
        for (int j = 0; j < sqrt && i<breaks.length; j++,i++) {
            if(breaks[i] == true){
                return i;
            }
        }
        return -1;
    }
}
