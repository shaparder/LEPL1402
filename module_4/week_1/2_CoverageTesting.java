import org.junit.Test;
import static org.junit.Assert.*;

public class TestSuite{
    char[] noexp = {'a', '-', '0'};
    char[] expplus = {'a', 'b', '+', '0', '2', '4'};
    char[] expmoins = {'0', 'x', '-', '2', '4', '0'};
    char[] expbig =  {'0', '1', '0', '2', '4', '0', '0', '1', '0', '2', '4', '0', '2'};
    char[] expbad = {'+','0','0','0','0','0','0','0','0','0','0','0','e','0','3','4','5'};
    BigDecimal bd = new BigDecimal();

    @Test
    public void resultTest() {
        assertEquals(24, bd.parseExp(expplus, 1, 5));
        assertEquals(-240, bd.parseExp(expmoins, 1, 5));
        assertEquals(24, bd.parseExp(expmoins, 1, 4));
    }

    @Test(expected = NumberFormatException.class)
    public void formatTest1(){
        bd.parseExp(noexp, 0, 2);
    }
    
    @Test(expected = NumberFormatException.class)
    public void formatTest2(){
        bd.parseExp(expbig, -1, 14);
    }

    @Test(expected = NumberFormatException.class)
    public void formatTest3(){
        bd.parseExp(expbad, -1, 18);
    }
}