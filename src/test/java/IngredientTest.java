import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoSession;
import praktikum.Ingredient;
import praktikum.IngredientType;


@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType type;
    private final  String name;
    private final float price;

    private Ingredient ingredient;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name="type:{0} name=:{1} price:{2}")
    public static Object[][] GetIngredientsData() {
        return new Object[][] {
                {IngredientType.SAUCE, "Барбекю", 100},
                {IngredientType.FILLING, "Мясо", 350},
        };
    }

    /*
     * Test getting ingredient price
     * */
    @Test
    public void checkGetPrice() {
        ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(price, ingredient.getPrice(), 0);
    }

    /*
     * Test getting ingredient name
     * */
    @Test
    public void checkGetName() {
        ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(name, ingredient.getName());
    }

    /*
     * Test getting ingredient type
     * */
    @Test
    public void checkGetType() {
        ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(type, ingredient.getType());
    }





}
