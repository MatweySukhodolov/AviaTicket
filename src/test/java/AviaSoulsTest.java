import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.AviaSouls;
import ru.netology.Ticket;
import ru.netology.TicketTimeComparator;

import java.util.Comparator;

public class AviaSoulsTest {

    Ticket ticket1 = new Ticket("Москва", "Якутск", 30000, 8, 15);
    Ticket ticket2 = new Ticket("Москва", "Южно-Сахалинск", 30000, 12, 21);
    Ticket ticket3 = new Ticket("Москва", "Архангельск", 5000, 20, 22);
    Ticket ticket4 = new Ticket("Москва", "Нижний Новгород", 3000, 17, 18);
    Ticket ticket5 = new Ticket("Москва", "Новосибирск", 7000, 3, 7);
    Ticket ticket6 = new Ticket("Москва", "Архангельск", 9000, 10, 13);
    Ticket ticket7 = new Ticket("Москва", "Архангельск", 6000, 19, 21);

    AviaSouls manager = new AviaSouls();

    @BeforeEach
    public void setup() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
    }

    @Test
    public void testTest() {
        System.out.println(ticket1.compareTo(ticket2));

        int expected = 0;
        int actual = ticket1.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testTest2() {
        System.out.println(ticket1.compareTo(ticket3));

        int expected = 1;
        int actual = ticket1.compareTo(ticket3);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testTest3() {
        System.out.println(ticket5.compareTo(ticket1));

        int expected = -1;
        int actual = ticket5.compareTo(ticket1);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testTest4() {
        Ticket[] expected = {ticket3, ticket7, ticket6};
        Ticket[] actual = manager.search("Москва", "Архангельск");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testTest5() {
        Ticket[] expected = {ticket1};
        Ticket[] actual = manager.search("Москва", "Якутск");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testTest6() {
        Ticket[] expected = {};
        Ticket[] actual = manager.search("Воркута", "Владикавказ");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testTest7() {
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket3, ticket7, ticket6};
        Ticket[] actual = manager.searchAndSortBy("Москва", "Архангельск", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

}
