import com.subham.MathOperations.services.MathsOperations;
import com.subham.MathsOperations.models.MathOperators;
import org.junit.Assert;
import org.junit.Test;

public class MathsOperationsTests {
    @Test
    public void additionTest(){
        MathOperators mathOperator = new MathOperators(2, 3);
        MathsOperations mathsOperations = new MathsOperations();
        Assert.assertEquals(5,  mathsOperations.add(mathOperator));
    }

    @Test
    public void subtractionTest(){
        MathOperators mathOperator = new MathOperators(2, 3);
        MathsOperations mathsOperations = new MathsOperations();
        Assert.assertEquals(-1,  mathsOperations.subtract(mathOperator));
    }

    @Test
    public void multiplyTest(){
        MathOperators mathOperator = new MathOperators(2, 3);
        MathsOperations mathsOperations = new MathsOperations();
        Assert.assertEquals(6,  mathsOperations.multiply(mathOperator));
    }

    @Test
    public void divideTest(){
        MathOperators mathOperator = new MathOperators(2, 3);
        MathsOperations mathsOperations = new MathsOperations();
        Assert.assertEquals(0,  mathsOperations.divide(mathOperator));
    }

}
