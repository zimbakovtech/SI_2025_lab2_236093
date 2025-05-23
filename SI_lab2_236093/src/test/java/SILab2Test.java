import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    SILab2 siLab2 = new SILab2();

    @Test
    void checkCart() {

        RuntimeException e;
        e = assertThrows(RuntimeException.class, () ->  siLab2.checkCart(null, ""));
        assertTrue(e.getMessage().contains("allItems list can't be null!"));

        List<Item> items = new LinkedList<>();
        items.add(new Item("Laptop", 1 , 1, 0));
        e = assertThrows(RuntimeException.class, () ->  siLab2.checkCart(items, ""));
        assertTrue(e.getMessage().contains("Invalid card number!"));

        e = assertThrows(RuntimeException.class, () ->  siLab2.checkCart(items, "123451234512345a"));
        System.out.println(e.getMessage());
        assertTrue(e.getMessage().contains("Invalid character in card number!"));

        List<Item> items2 = new LinkedList<>();
        items2.add(new Item(null, 0 , 0, 0));
        e = assertThrows(RuntimeException.class, () ->  siLab2.checkCart(items2, ""));
        assertTrue(e.getMessage().contains("Invalid item!"));

        assertEquals(1, siLab2.checkCart(items, "1234512345123456"));
    }

    @Test
    void checkCartMultipleCondition() {
        // 1
        List<Item> allItems = new LinkedList<>();
        allItems.add(new Item("Laptop", 0, 250, 0));
        assertEquals(-30, siLab2.checkCart(allItems, "1234512345123456"));
        // 2
        List<Item> allItems2 = new LinkedList<>();
        allItems2.add(new Item("Laptop", 0, 1, 0.1));
        assertEquals(-30, siLab2.checkCart(allItems2, "1234512345123456"));
        // 3
        List<Item> allItems3 = new LinkedList<>();
        allItems3.add(new Item("Laptop", 2, 3, 0));
        assertEquals(6, siLab2.checkCart(allItems3, "1234512345123456"));
        // 4
        List<Item> allItems4 = new LinkedList<>();
        allItems4.add(new Item("Laptop", 15, 10, 0.1));
        assertEquals(105, siLab2.checkCart(allItems4, "1234512345123456"));
    }
}