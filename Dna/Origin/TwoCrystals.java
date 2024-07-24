public class TwoCrystals {
    public static int find(boolean[] breaks){
        int sqrt = (int)Math.sqrt(breaks.length);
        int i;
        for(i = sqrt; i<breaks.length; i+= sqrt){
            if(breaks[i] == true)
                break;
        }
        i -= sqrt;
        for(int j = 0; j<sqrt && i<breaks.length; i++, j++){
            if(breaks[i])
                return i;
        }
        return -1;
    }
}
