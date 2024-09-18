package pa2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

    @Test
    void testAdd() {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals("1 2 3 ", list.traverse_recursive(list.head));
    }

    @Test
    void testAdd2() {
        LinkedList list = new LinkedList();
        list.add(2);
        list.add(3);
        list.add(1);
        assertEquals("1 2 3 ", list.traverse_recursive(list.head));
    }
    @Test
    void testAdd3() {
        LinkedList list = new LinkedList();
        list.add(6);
        list.add(4);
        list.add(3);
        assertEquals("3 4 6 ", list.traverse_recursive(list.head));
    }

    @Test
    void testAdd4() {
        LinkedList list = new LinkedList();
        list.add(0);
        list.add(4);
        list.add(4);
        assertEquals("0 4 4 ", list.traverse_recursive(list.head));
    }

    @Test
    void testRemove() {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(2);
        assertEquals("1 3 ", list.traverse_recursive(list.head));
    }

    @Test
    void testRemove_first() {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(1);
        assertEquals("2 3 ", list.traverse_recursive(list.head));
    }

    @Test
    void testRemove_none() {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(4);
        assertEquals("1 2 3 ", list.traverse_recursive(list.head));
    }

    @Test
    void testRemove_last() {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(3);
        assertEquals("1 2 ", list.traverse_recursive(list.head));
    }
    @Test
    void testRemove_only() {
        LinkedList list = new LinkedList();
        list.add(1);
        list.remove(1);
        assertEquals("", list.traverse_recursive(list.head));
    }

    @Test
    void traverse() {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals("1 2 3 ", list.traverse_recursive(list.head));
    }

    @Test
    void reverse() {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals("3 2 1 ", list.reverse(list.head));
    }

    @Test
    void mergesort() {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list2.add(4);
        list2.add(5);
        list2.add(6);
        LinkedList newlist = LinkedList.merge(list1, list2);
        assertEquals("1 2 3 4 5 6 ", newlist.traverse_recursive(newlist.head));
    }
}


