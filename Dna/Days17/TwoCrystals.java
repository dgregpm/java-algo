public class TwoCrystals {
    public static int find(boolean[] breaks){
      if(breaks[0])
        return 0;
      int i = 0;
      int sqrt = (int)Math.floor(Math.sqrt(breaks.length));
      for(;i<breaks.length;i+=sqrt){
        if(breaks[i])
          break;
      }
      i -= sqrt;
      i++;
      for(int j=0;j<sqrt && i < breaks.length;j++,i++){
        if(breaks[i])
          return i;
      }

        return -1;
    }
}
