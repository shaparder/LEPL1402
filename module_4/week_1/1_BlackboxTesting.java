import org.junit.Test;
import static org.junit.Assert;

public class TestSuite{

  Exercise exc = new Exercise();
  int[] a = {4, 32, 6, 7, 8, 3, 1, 11, 21, 12 , 13, 14 , 15, 16};

    @Test
    public void test(){
      Assert.assertEquals(7 , exc.binarySearch(a, 5, 8, 11));
      Assert.assertEquals(-1 , exc.binarySearch(a, 5, 8, 15));
      Assert.assertEquals(-2, exc.binarySearch(a, -1, 8, 15));
      Assert.assertEquals(-2, exc.binarySearch(a, 10, 8, 15));
      Assert.assertEquals(-2, exc.binarySearch(a, 10, 15, 15));
    }
}

