import basket.Item;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ItemTest {

    private Item brie;

    @Before
    public void before(){
        brie = new Item("Brie", 5.50);
    }

    @Test
    public void canGetName() {
        assertEquals("Brie", brie.getName());
    }

    @Test
    public void canGetPrice() {
        assertEquals(5.50, brie.getPrice(), 0.01);
    }
}
