import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MyTests {
    @Test
    public void testTask1() {
        Main tester = new Main();
        assertEquals(0, tester.res(0, 0));
    }

    @Test
    public void testTask2() {
        Main2 tester = new Main2();
        assertEquals("B=2.0 inside (1,3) range", tester.result(1,2,5));
    }

    @Test
    public void testTask3() {
        Main3 tester = new Main3();
        assertEquals(0.4615384615384615, tester.result(0.01));
    }

    @Test
    public void testTask4() {
        Main4 tester = new Main4();
        int[] arr=new int[] {24, 2, 6, 1, 8, 14, 23, 5, 21, 10, 22, 9, 5, 12, 15, 1};
        assertEquals(5, tester.result(arr));
    }

    @Test
    public void testTask5() {
        double[] exp = new double[]{0.0, 0.842, 0.933, 0.525,
                1.867, 10.208, 34.8, 89.892, 195.733, 379.575, 676.667};
        for (int i=0; i<exp.length; i++){
            assertEquals(exp[i], Main5.function(i), 0.001);
        }
    }
}
