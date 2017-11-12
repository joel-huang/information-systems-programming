
// Homework Question 5
// total: 15 points

//===============================================
// todo: complete the following program
//===============================================




   public class SumOdds {
        public static void main (String[] args) {
            int number = -54321;
            System.out.println(sumOdd(number));

            }
        
        public static int sumOdd(int i) {
            // terminal case - if the number fed into sumOdd is 0.
            if (i==0) return 0;
            // even case - do not add the current LSD
            if (i%2==0) return sumOdd(i/10);
            // odd case & non-MSD negative number
            if (i<-9 && i%2!=0) return -i%10 + sumOdd(i/10);
            // MSD is negative
            return i%10 + sumOdd(i/10);
        }
    }
