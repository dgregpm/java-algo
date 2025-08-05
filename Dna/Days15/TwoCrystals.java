
public class TwoCrystals {
    public static int find(boolean[] breaks){
        if(breaks[0])
            return 0;
        int sqrt = (int)Math.sqrt(breaks.length);
        int i = sqrt;
        for (; i < breaks.length; i+=sqrt) {
            if(breaks[i]){
                System.out.println("i: " + i);
                break;
            }
        }
        i -= sqrt;
        i++;
        System.out.println("i + 1: " + i);
        for (int j = 0; j < sqrt && i < breaks.length; j++,i++) {
            if(breaks[i])
                return i;            
        }
        return -1;
    }
}
