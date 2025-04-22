import org.junit.jupiter.api.Test;
import com.example.lab3.util.RequestParser;
import com.google.common.annotations.VisibleForTesting;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tester {
    @Test
    public void testOne(){
        assertTrue(RequestParser.hitCheck(0,0,2));
    }
    @Test
    public void testTwo(){
        assertFalse(RequestParser.hitCheck(-1,1,3));
    }
    @Test
    public void testThree(){
        assertTrue(RequestParser.hitCheck(-1,-1,5));
    }
    @Test
    public void testFour(){
        assertTrue(RequestParser.hitCheck(-1,-1,5));
    }



}
