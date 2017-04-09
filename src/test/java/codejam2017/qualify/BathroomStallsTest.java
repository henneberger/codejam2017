package codejam2017.qualify;

import java.math.BigInteger;
import java.util.Random;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by henneberger on 4/8/17.
 */
public class BathroomStallsTest {

    @Test public void test0(){assertEquals("2 1", BathroomStalls.test(8,2));}
    @Test public void test1(){assertEquals("1 0", BathroomStalls.test(4,2));}
    @Test public void test2(){assertEquals("1 0", BathroomStalls.test(5,2));}
    @Test public void test3(){assertEquals("1 1", BathroomStalls.test(6,2));}
    @Test public void test4(){assertEquals("0 0", BathroomStalls.test(1000,1000));}
    @Test public void test5(){assertEquals("500 499", BathroomStalls.test(1000,1));}
    @Test public void test6(){assertEquals("0 0", BathroomStalls.test(2,2));}
    @Test public void test7(){assertEquals("0 0", BathroomStalls.test(1,1));}

    @Test public void testLarge() {
        Random random = new Random(0);
        for (int i = 0; i < 100; i++) {
            long a = Math.abs(random.nextLong());
            long b = Math.abs(random.nextInt(25) + 1);

            System.out.println(a + ":" + b);
            System.out.println(BathroomStalls.test(Math.max(a, b), Math.min(a,b)));
        }
    }
    @Test public void test8() {
        for (int i = 1; i < 8; i++) {
            System.out.println(BathroomStalls.test(8, i));
        }
    }
}