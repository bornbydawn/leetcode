public class BrokenCalculator {
    public static void main(String[] args) {
         //int X = 5;
         //int Y = 8; 
         
          //int X = 1024;
          //int Y = 1; 
         
         
          //int X = 1;
         
          //int Y =  1000000000; 
         
         // int X = 2;
        //  int Y = 3;
        
        
           int X = 3;
           int Y = 10;

        System.out.println(new BrokenCalculator().brokenCalc(X, Y));
    }

    public int brokenCalc(int X, int Y) {
        if(X == Y) return 0;
        if(X > Y ) return X - Y;
       
        int count = 0;
        while(X != Y){
            if(Y % 2 == 0 && Y > X){
                Y/=2;
            }
            else{
                Y = Y + 1;
            }
            count++;
        }

        return count;
    }

    // public int brokenCalc(int X, int Y) {
    //     int count = 0;
    //    while(true){
    //        if(X == Y) return count;
    //        if(X > Y) return count + X - Y;
    //        if(Y == 2*X) return count + 1;
    //        if(Y == 2*X -1) return count + 2;
    //        if(2*X + 1 > Y){
    //         ++count;
    //         X = X - 1;
    //        }
    //        else{
    //            ++count;
    //            X = X*2;
    //        }
    //    }
    // }
}
