public class Polynomial {
	double[] coefficients;
	int[] exponents;


	public Polynomial() {
	    this.coefficients = new double[0];
	    this.exponents = new int[0];

	}

	public Polynomial(double[] coefficients, int[] exponents) {
		this.coefficients = coefficients;
		this.exponents = exponents;	

	}
	
	public static int search(int[] arr, int z) {
		
		//search if z is in the array arr.Return index found or -1,works on unsorted arrays as well with bad complexity.
	    for (int i = 0; i < arr.length; i++) {
            if (arr[i] == z) {
                return i;
            }
        }
            return -1;	
		
	}


	public Polynomial add(Polynomial other) {
	
		int a = this.coefficients.length;
		int b = other.coefficients.length;
		int size = a + b;
		double[] sumC = new double[size];
		int[] sumE = new int[size];
		int sumIndex = 0;         //keep track of filled up in sum.
		
		for (int i = 0; i < a; i++) {			//copy first polynomial
			sumC[sumIndex] = this.coefficients[sumIndex];
			sumE[sumIndex] = this.exponents[sumIndex];
			sumIndex++;			
		}
		
		for (int j = 0; j < b; j++) {		//copy or add second polynomial.
			
			int found = search(this.exponents, other.exponents[j]);
			
			if (found == -1) {
				sumC[sumIndex] = other.coefficients[j];
				sumE[sumIndex] = other.exponents[j];
				sumIndex++;					
			}
			else {
				sumC[found] = sumC[found] + other.coefficients[j];
			}		
		}
	
		Polynomial p = new Polynomial(sumC, sumE);
		return p;

	}
	
	
	
	public Polynomial multiply(Polynomial other) {
		
		int a = this.coefficients.length;
		int b = other.coefficients.length;
		int size = a * b;
		double[] productC = new double[size];
		int[] productE = new int[size];
		int productIndex = 0;  
		
		for (int i = 0; i < a; i++) {
			
			for (int j = 0; j < b; j++) {
				int found = search(productE, this.exponents[i] + other.exponents[j]);
				if (found == -1) {
					productC[productIndex] = this.coefficients[i] * other.coefficients[j];
					productE[productIndex] = this.exponents[i] + other.exponents[j];
					productIndex++;
				}
				else {
					productC[found] = productC[found] + (this.coefficients[i] * other.coefficients[j]);
				}
			}			
		}
		
		Polynomial p = new Polynomial(productC, productE);
		return p;
	}

	public double evaluate(double a) {
		if (this.coefficients.length == 0) {
			return 0.0;
		}

		else {
			double b = 0;
			int size = this.coefficients.length;

			for(int i=0;i<size;i++){
				b = b + (this.coefficients[i]*Math.pow(a,this.exponents[i]));
			}

			return b;
			}
		}

	public boolean hasRoot(double s) {

		return evaluate(s) == 0;
	}
}