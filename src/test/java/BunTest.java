import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BunTest {
    Bun bun;
    String name;
    float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {"Пшеничная", 100},
                {"Ржаная", 120}
        };
    }

    @Before
    public void preBun() {
            bun = new Bun(name,price
        );
    }

    /*
     * Test check get bun name
     * */
    @Test
    public void checkGetName() {
        assertEquals(name, bun.getName());
    }

    /*
     * Test check get bun price
     * */
    @Test
    public void checkGetPrice() {
        assertEquals(price, bun.getPrice(), 0);
    }
}
