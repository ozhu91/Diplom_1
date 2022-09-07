import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

public class IngredientTypeTest {

    @Test
    public void checkMinTypes() {
        Assert.assertTrue(IngredientType.values().length >= 2);
    }

}
