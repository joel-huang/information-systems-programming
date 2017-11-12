
// Homework Question 4
// total: 10 points

//===============================================
// todo: complete the following program
//===============================================




import java.util.InputMismatchException;

public class Handshake {
    public static void main (String[] args) {
        try {
         
            System.out.println(handshake(10));
            System.out.println(handshake(3));
            System.out.println(handshake(-4));

        }
        catch (InputMismatchException ex) {
            System.out.println("Sorry. Number of persons cannot be negative.");
        }
    }

    public static int handshake (int k) throws InputMismatchException {
        
        // the number of handshakes for k people is
        // (k-1) + the number of handshakes for (k-1) people.
        if (k<0) throw new InputMismatchException();
        if (k==1||k==0) return 0;

        return (k-1) + handshake(k-1);

    }
}
