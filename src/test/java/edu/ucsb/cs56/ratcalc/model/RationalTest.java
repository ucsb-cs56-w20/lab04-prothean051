package edu.ucsb.cs56.ratcalc.model;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Before;

public class RationalTest {

    private Rational r_5_15;
    private Rational r_24_6;
    private Rational r_3_7;  
    private Rational r_13_4;
    private Rational r_20_25;
    private Rational r_25_20;
    private Rational r_0_1; 
    
    @Before public void setUp() {
	r_5_15 = new Rational(5,15);
	r_24_6 = new Rational(24,6);
	r_3_7  = new Rational(3,7);
	r_13_4 = new Rational(13,4);
	r_20_25 = new Rational(20,25);
	r_0_1 = new Rational(0,1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_denom_zero() {
	Rational r = new Rational(1,0);
    }
    
    @Test
    public void test_getNumerator_20_25() {
	assertEquals(4, r_20_25.getNumerator());
    }
    
    @Test
    public void test_getNumerator_13_4() {
	assertEquals(13, r_13_4.getNumerator());
    }
    
    @Test
    public void test_getDenominator_20_25() {
	assertEquals(5, r_20_25.getDenominator());
    }
    
    @Test
    public void test_getDenominator_13_4() {
	assertEquals(4, r_13_4.getDenominator());
    }

    @Test
    public void test_toString_5_15() {
	assertEquals("1/3",r_5_15.toString());
    }

    @Test
    public void test_toString_24_6() {
	assertEquals("4",r_24_6.toString());
    }

    @Test
    public void test_toString_3_7() {
	assertEquals("3/7",r_3_7.toString());
    }
    
    @Test
    public void test_toString_20_25() {
	assertEquals("4/5",r_20_25.toString());
    }

    @Test
    public void test_toString_0_1() {
	assertEquals("0",r_0_1.toString());
    }

    @Test
    public void test_gcd_5_15() {
	assertEquals(5, Rational.gcd(5,15));
    }

    @Test
    public void test_gcd_15_5() {
	assertEquals(5, Rational.gcd(15,5));
    }

    @Test
    public void test_gcd_24_6() {
	assertEquals(6, Rational.gcd(24,6));
    }

    @Test
    public void test_gcd_17_5() {
	assertEquals(1, Rational.gcd(17,5));
    }
    
    @Test
    public void test_gcd_1_1() {
	assertEquals(1, Rational.gcd(1,1));
    }

    @Test
    public void test_gcd_20_25() {
	assertEquals(5, Rational.gcd(20,25));
    }

    @Test
    public void test_rational_m10_m5() {
	Rational r = new Rational(-10,-5);
	assertEquals("2",r.toString());
    }

    @Test
    public void test_rational_m5_6() {
	Rational r = new Rational(-5,6);
	assertEquals("-5/6",r.toString());
    }

    @Test
    public void test_rational_7_m8() {
	Rational r = new Rational(7,-8);
	assertEquals("-7/8",r.toString());
    }

    @Test
    public void test_r_5_15_times_r_3_7() {
	Rational r = r_5_15.times(r_3_7);
	assertEquals("1/7",r.toString());
    }

    @Test
    public void test_r_3_7_times_r_13_4() {
	Rational r = r_3_7.times(r_13_4);
	assertEquals("39/28",r.toString());
    }

    @Test
    public void test_r_m3_1_times_1_m3() {
	Rational r_m3_1 = new Rational(-3,1);
	Rational r_1_m3 = new Rational(1,-3);
	Rational r = r_m3_1.times(r_1_m3);
	assertEquals("1",r.toString());
    }

   @Test
    public void test_product_of_r_5_15_and_r_3_7() {
       Rational r = Rational.product(r_5_15,r_3_7);
       assertEquals("1/7",r.toString());
    }

    @Test
    public void test_product_of_r_3_7_and_r_13_4() {
	Rational r = Rational.product(r_3_7,r_13_4);
	assertEquals("39/28",r.toString());
    }

    @Test
    public void test_product_of_r_m3_1_and_1_m3() {
	Rational r_m3_1 = new Rational(-3,1);
	Rational r_1_m3 = new Rational(1,-3);
	Rational r = Rational.product(r_m3_1,r_1_m3);
	assertEquals("1",r.toString());
    }

    @Test
    public void test_lcm_of_6_and_8() {
	int i = Rational.lcm(6,8);
	assertEquals(24,i);
    }

    @Test
    public void test_lcm_of_6_and_0() {
	int i = Rational.lcm(6,0);
	assertEquals(0,i);
    }

    @Test
    public void test_lcm_of_0_and_8() {
	int i = Rational.lcm(0,8);
	assertEquals(0,i);
    }

    @Test
    public void test_plus_of_0_and_0() {
    Rational r_pt1 = new Rational(0,1);
    Rational r_pt2 = new Rational(0,1);
    Rational r_pt1s = r_pt1.plus(r_pt2);
	assertEquals("0",r_pt1s.toString());
    }

    @Test
    public void test_plus_of_5_2_and_6_7() {
    Rational r_pt1 = new Rational(5,2);
    Rational r_pt2 = new Rational(6,7);
    Rational r_pt1s = r_pt1.plus(r_pt2);
	assertEquals("47/14",r_pt1s.toString());
    }

    @Test
    public void test_plus_of_m1_4_and_3_5() {
    Rational r_pt1 = new Rational(-1,4);
    Rational r_pt2 = new Rational(3,5);
    Rational r_pt1s = r_pt1.plus(r_pt2);
    assertEquals("7/20",r_pt1s.toString());
    }

    @Test
    public void test_sum_of_0_and_0() {
    Rational r_pt1 = new Rational(0,1);
    Rational r_pt2 = new Rational(0,1);
    Rational r_pt1s = Rational.sum(r_pt1,r_pt2);
	assertEquals("0",r_pt1s.toString());
    }

    @Test
    public void test_sum_of_4_and_8_5() {
    Rational r_pt1 = new Rational(4,1);
    Rational r_pt2 = new Rational(8,5);
    Rational r_pt1s = Rational.sum(r_pt1,r_pt2);
	assertEquals("28/5",r_pt1s.toString());
    }

    @Test
    public void test_sum_of_m5_3_and_0() {
    Rational r_pt1 = new Rational(-5,3);
    Rational r_pt2 = new Rational(0,1);
    Rational r_pt1s = Rational.sum(r_pt1,r_pt2);
	assertEquals("-5/3",r_pt1s.toString());
    }

    @Test
    public void test_minus_of_0_and_0() {
    Rational r_pt1 = new Rational(0,1);
    Rational r_pt2 = new Rational(0,1);
    Rational r_pt1s = r_pt1.minus(r_pt2);
	assertEquals("0",r_pt1s.toString());
    }

    @Test
    public void test_minus_of_5_8_and_40_9() {
    Rational r_pt1 = new Rational(5,8);
    Rational r_pt2 = new Rational(40,9);
    Rational r_pt1s = r_pt1.minus(r_pt2);
	assertEquals("-275/72",r_pt1s.toString());
    }

    @Test
    public void test_minus_of_m1_4_and_3_5() {
    Rational r_pt1 = new Rational(-1,4);
    Rational r_pt2 = new Rational(3,5);
    Rational r_pt1s = r_pt1.minus(r_pt2);
    assertEquals("-17/20",r_pt1s.toString());
    }

    @Test
    public void test_difference_of_0_and_0() {
    Rational r_pt1 = new Rational(0,1);
    Rational r_pt2 = new Rational(0,1);
    Rational r_pt1s = Rational.difference(r_pt1,r_pt2);
    assertEquals("0",r_pt1s.toString());
    }

    @Test
    public void test_difference_of_5_8_and_40_9() {
    Rational r_pt1 = new Rational(5,8);
    Rational r_pt2 = new Rational(40,9);
    Rational r_pt1s = Rational.difference(r_pt1,r_pt2);
    assertEquals("-275/72",r_pt1s.toString());
    }

    @Test
    public void test_difference_of_7_3_and_m2_3() {
    Rational r_pt1 = new Rational(7,3);
    Rational r_pt2 = new Rational(-2,3);
    Rational r_pt1s = Rational.difference(r_pt1,r_pt2);
    assertEquals("3",r_pt1s.toString());
    }

    @Test
    public void test_reciprocalOf_1_2() {
    Rational r = new Rational(1,2);
    Rational k = r.reciprocalOf();
    assertEquals("2",k.toString());
    }

    @Test
    public void test_reciprocalOf_4_5() {
    Rational r = new Rational(4,5);
    Rational k = r.reciprocalOf();
    assertEquals("5/4",k.toString());
    }

    @Test
    public void test_reciprocalOf_m41_5() {
    Rational r = new Rational(-41,5);
    Rational k = r.reciprocalOf();
    assertEquals("-5/41",k.toString());
    }

    @Test
    public void test_dividedBy_1_2_and_6_9() {
    Rational r = new Rational(1,2);
    Rational m = new Rational(6,9);
    Rational k = r.dividedBy(m);
    assertEquals("3/4",k.toString());
    }

    @Test
    public void test_dividedBy_m8_3_and_6_9() {
    Rational r = new Rational(-8,3);
    Rational m = new Rational(6,9);
    Rational k = r.dividedBy(m);
    assertEquals("-4",k.toString());
    }

    @Test
    public void test_quotient_1_2_and_6_9() {
    Rational r = new Rational(1,2);
    Rational m = new Rational(6,9);
    Rational k = Rational.quotient(r,m);
    assertEquals("3/4",k.toString());
    }
}
