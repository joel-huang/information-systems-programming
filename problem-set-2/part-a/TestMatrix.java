
// Question 3
// total: 30 points

//===============================================
// todo: complete the following program
//===============================================


public class TestMatrix {
	public static void main(String[] args) {
		double [][] a = { 
				{1,2,3},
				{4,5,6}
		};
		
		double [][] b = {
				{1,2},
				{3,4},
				{5,6}
		};
		
		double [][] c = matMpy (a,b);
		
		printMat(c);

		//////
		
		int [] f = new int [5];
		f[0] = 2;
		f[1] = 5;
		int [] g = {1, 3, 7};
		
		mergeSortedArray(f, 2, g, 3);
		
		printMat(f);
		
		
		
	}

	public static void printMat(int [] c) {
		int m;
		m = c.length;
		for (int i = 0; i< m; i++) {
			System.out.print(c[i] + ",  ");
		}
		System.out.println();
	}
	
	public static void printMat(double [][] c) {
		int m,n;
		m = c.length;
		n = c[0].length;
		for (int i = 0; i< m; i++) {
			for (int j=0; j< n; j++) {
				System.out.print(c[i][j] + ",  ");
			}
			System.out.println();
		}
		
	}
	
	
	public static double [][] matMpy ( double [][] a, double [][] b) {
		
		if (a[0].length != b.length) return null;

		double [][] result = new double[a.length][b[0].length];
		

		// shameful nested for loops
		// for each i in the answer matrix
		for (int i=0; i<a.length; i++){
			// each column j in the answer matrix
			for (int j=0; j<b[0].length; j++) {
				// for each k existing
				for (int k=0; k<b.length; k++) {
					// Sigma notation for matrix multiplication, AB(i,j) = sigma(k,m)(A(ik)*B(kj))
					result[i][j] += a[i][k] * b[k][j];
				}
			}
		}

		return result;
	}

	public static void mergeSortedArray(int [] A, int m, int [] B, int n) {

        int i = m-1; // index of a
        int j = n-1; // index of b
        int k = m+n-1; // index of a (fully filled)

        // since all indices of A need to be addressed,
        // use k as a counter.
        while (k >= 0) {

        	// if we haven't reached the end of A
            if (i >= 0) {
            	// compare last ele of B and current ele of A
                if (A[i] > B[j]) {
                	// if ele of A larger, replace last ele of A with it.
                	// then, look at the ele to the left in A.
                    A[k] = A[i];
                    i--;
                }

                else {
                	// if ele of B larger. replace last ele of A with it.
                	// then, look at ele to the left in B.
                    A[k] = B[j];
                    j--;
                }
            }

            else {
                A[k] = B[j];
                j--;
            }
            
            // reduce the index in the full size of A
            // that we are addressing.
            k--;
        }
	}

}