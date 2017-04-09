package codejam2017.qualify;

import java.util.Random;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Created by henneberger on 4/8/17.
 */
public class OversizedPancakeFlipperTest {
    @Test
    public void testOne() {
        assertEquals("3", OversizedPancakeFlipper.test("---+-++-", 3));
    }
    @Test
    public void testTwo() {
        assertEquals("0", OversizedPancakeFlipper.test("+++++", 4));
    }
    @Test
    public void testThree() {
        assertEquals("2", OversizedPancakeFlipper.test("------", 3));
    }
    @Test
    public void testFour() {
        assertEquals("IMPOSSIBLE", OversizedPancakeFlipper.test("-+-+-", 4));
    }
    @Test
    public void testLarge() {
        for (int t = 0; t < 1000000; t++) {
            Random random = new Random(4);
            StringBuilder b = new StringBuilder();
            for (int i = 0; i < 1000; i++) {
                b.append(random.nextBoolean() ? "-" : "+");
            }
            OversizedPancakeFlipper.test(b.toString(), random.nextInt(1000));
        }
    }
}