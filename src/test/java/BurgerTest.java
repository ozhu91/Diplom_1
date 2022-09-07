import org.junit.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoSession;
import org.mockito.Spy;
import praktikum.*;

public class BurgerTest {
    Burger burger = new Burger();

    @Mock
    Bun bunMock;

    @Mock
    Ingredient ingredientMock;

    @Spy
    Database data;

    MockitoSession session;

    @Before
    public void beforeMethod() {
        session = Mockito.mockitoSession()
                .initMocks(this)
                .startMocking();
        burger = new Burger();

    }

    @Test
    public void checkBurgerSetBun () {
        burger.setBuns(bunMock);
        Assert.assertEquals(bunMock, burger.bun);
    }

    @Test
    public void checkBurgerAddIngredient () {
        burger.addIngredient(ingredientMock);
        Ingredient burgerIngredient = burger.ingredients.get(0);
        Assert.assertEquals(ingredientMock, burgerIngredient);
    }

    @Test
    public void checkBurgerRemoveIngredient() {
        burger.addIngredient(data.availableIngredients().get(0));
        burger.removeIngredient(0);
        Assert.assertFalse(burger.ingredients.contains(data.availableIngredients().get(0)));
    }

    @Test
    public void checkBurgerMoveIngredient() {
        burger.addIngredient(data.availableIngredients().get(0));
        burger.addIngredient(data.availableIngredients().get(1));
        burger.addIngredient(data.availableIngredients().get(2));
        burger.moveIngredient(0, 2);
        Assert.assertEquals(data.availableIngredients().get(0), burger.ingredients.get(2));
        Assert.assertEquals(data.availableIngredients().get(1), burger.ingredients.get(0));
        Assert.assertEquals(data.availableIngredients().get(2), burger.ingredients.get(1));
    }

    @Test
    public void checkBurgerGetPrice() {
        burger.addIngredient(data.availableIngredients().get(4));
        burger.addIngredient(data.availableIngredients().get(0));
        burger.setBuns(data.availableBuns().get(0));
        Assert.assertEquals(500, burger.getPrice(), 0);
    }

    @Test
    public void checkBurgerGetReceipt() {
        burger.addIngredient(data.availableIngredients().get(4));
        burger.addIngredient(data.availableIngredients().get(0));
        burger.setBuns(data.availableBuns().get(0));
        String finishedReceipt = "(==== black bun ====)\n= filling dinosaur =\n= sauce hot sauce =\n(==== black bun ====)\n\nPrice: 500.000000\n";
        Assert.assertEquals(finishedReceipt, burger.getReceipt());
    }

    @After
    public void afterMethod() {
        session.finishMocking();
    }

}
