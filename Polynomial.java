public class Polynomial {
	double [] c;;

	public Polynomial() {
	    c = new double[9];

	}

	public Polynomial(double [] r) {
		c = r;

		

	}

	public Polynomial add(Polynomial object) {
	
		int a = this.c.length;
		int b = object.c.length;
		int size = 0;
		int min = 0;


		if (a>b) {
	    	    min = b;
		    size = a;
			}
		else {
	    	    min = a;
		    size = b;

			}

		double [] f = new double[size];

		for(int i=0;i<size;i++){
			if (i >= a) {
				f[i] = object.c[i];
			} else if (i >= b) {
				f[i] = this.c[i];
			} else {
				f[i] = this.c[i] + object.c[i];
		}
			
		}
		
		
	
		Polynomial p = new Polynomial(f);
		return p;

	}

	public double evaluate(double a) {
		if (this.c==null) {
			return 0.0;
		}

		else {
			double b = 0;
			int size = this.c.length;

			for(int i=0;i<size;i++){
				b = b + (this.c[i]*Math.pow(a,i));
			}

			return b;
			}
		}

	public boolean hasRoot(double s) {

		return evaluate(s) == 0;
	}
}