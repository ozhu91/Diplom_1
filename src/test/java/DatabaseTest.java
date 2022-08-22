import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;

import static org.hamcrest.CoreMatchers.instanceOf;


public class DatabaseTest {
    Database database;

    @Before
    public void afterMethod() {
        database = new Database();
    }


    @Test
    public void checkAvailableBuns() {
            Assert.assertTrue(database.availableBuns().size() >= 3);
    }

    @Test
    public void checkAvailableIngredients() {
        Assert.assertTrue(database.availableIngredients().size() >= 6);
    }

    @Test
    public void checkAvailableBunsClass() {
        Assert.assertTrue(database.availableBuns().get(0) instanceof  Bun);
    }

    @Test
    public void checkAvailableIngredientsClass() {
        Assert.assertTrue(database.availableIngredients().get(0) instanceof  Ingredient);
    }

}
