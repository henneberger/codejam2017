package codejam2017.qualify;

import java.math.BigInteger;
import java.util.Random;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by henneberger on 4/8/17.
 */
public class TidyNumbersTest {

    @Test public void test0() { assertEquals("99", TidyNumbers.test("110")); }
    @Test public void test1() { assertEquals("129", TidyNumbers.test("132")); }
    @Test public void test2() { assertEquals("899999999", TidyNumbers.test("987654321")); }
    @Test public void test3() { assertEquals("99999999999999999", TidyNumbers.test("111111111111111110")); }
    @Test public void test3b() { assertEquals("999999999999999999999999999", TidyNumbers.test("1111111111111111111111111110")); }
    @Test public void test4() { assertEquals("7", TidyNumbers.test("7")); }
    @Test public void test5() { assertEquals("799", TidyNumbers.test("809")); }

    @Test public void testLarge() {
        Random random = new Random(0);
        for (int i = 0; i < 400; i++) {
            String rand = new BigInteger(300, random).toString();
            System.out.println(rand + ":" + TidyNumbers.test(rand));
        }

    }
}