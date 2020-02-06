package edu.ucsb.cs56.ratcalc.model;
/** A class to represent a rational number
    with a numerator and denominator

    @author P. Conrad for CS56 F16

    */

public class Rational {

    private int num;
    private int denom;

    /** 
	greatest common divisor of a and b
	@param a first number
	@param b second number
	@return gcd of a and b
    */
    public static int gcd(int a, int b) {
	if (a==0)
	    return b;
	else if (b==0)
	    return a;
	else
	    return gcd(b%a, a);
    }
    
    public Rational() {
	this.num = 1;
	this.denom = 1;
    }

    public Rational(int num, int denom) {
	if (denom== 0) {
	    throw new IllegalArgumentException("denominator may not be zero");
	}
	this.num = num;
	this.denom = denom;
	if (num != 0) {
	    int gcd = Rational.gcd(num,denom);
	    this.num /= gcd;
	    this.denom /= gcd;
	}
    }

    public String toString() {
	if (denom == 1 || num == 0)
	    return "" + num;
	return num + "/" + denom;
    }

    public int getNumerator() { return this.num; }
    public int getDenominator() { return this.denom; }

    public Rational times(Rational r) {
	return new Rational(this.num * r.num,
			    this.denom * r.denom);
    }

    public static Rational product(Rational a, Rational b) {
	return new Rational(a.num * b.num,
			    a.denom * b.denom);
    }

    public static int lcm(int a, int b){ //returns 0 when a or b are 0, crashes if both
		int abs = Math.abs(a*b);
		int gcd = gcd(a,b);
		return abs/gcd;
	}

	public Rational plus(Rational r){
		int numPlus, denomPlus;
		denomPlus = this.denom * r.denom;
		numPlus = this.num * r.denom + this.denom * r.num;
		Rational result = new Rational(numPlus, denomPlus);
    if(result.denom<0){
      result.denom *= -1;
      result.num *= -1;
    }
    return result;
	}

	public static Rational sum(Rational a, Rational b){
		Rational result = a.plus(b);
		return result;
	}

	public Rational minus(Rational r){
		Rational neg = new Rational(-1*r.num,r.denom);
		Rational result = this.plus(neg);
		if(result.denom<0){
			result.num=result.num*-1;
			result.denom=result.denom*-1;
		}
		return result;
	}

	public static Rational difference(Rational a, Rational b){
		Rational result = a.minus(b);
		return result;
	}

	public Rational reciprocalOf(){
		if(this.num==0){
			throw new ArithmeticException("Numerator is 0\n");
		}
    	Rational result = new Rational(this.denom,this.num);
    	if(result.denom < 0){
          result.denom *= -1;
          result.num *= -1;
    	}
    	return result;
	}

	public Rational dividedBy(Rational r){
		Rational reci = r.reciprocalOf();
		return new Rational(this.num*reci.num,this.denom*reci.denom);
	}

	public static Rational quotient(Rational a, Rational b){
		Rational result = a.dividedBy(b);
		return result;
	}


    /** 
	For testing getters.  
	@param args unused
     */

    public static void main (String [] args) {
	Rational r = new Rational(5,7);
	System.out.println("r.getNumerator()=" + r.getNumerator());
	System.out.println("r.getDenominator()=" + r.getDenominator());
    }

    
}
