package oop.collections.list.linkedlist;
import oop.collections.list.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ListIterator;

public class LinkedListTest {
    //TDD Test Driven Development

    @Test
    public void givenANewList_thenSizeIsZero(){
        //Inicialización, Given
        LinkedList linkedlist = new LinkedList();

        //Ejecución, When
        int size = linkedlist.getSize();

        //Validación, Then
        Assertions.assertEquals(0,size);
    }

    @Test
    public void givenANewList_whenAddAtTail_thenSizeIsOne(){
        //Inicialización, Given
        LinkedList linkedlist = new LinkedList();

        //Ejecución, When
        linkedlist.addAtTail("One");

        //Validación, Then
        Assertions.assertEquals(1,linkedlist.getSize());
        Assertions.assertEquals("One",linkedlist.getAt(0));
    }

    @Test
    public void givenANonEmptyList_whenAddAtTail_thenSizeIsIncreased(){
        //Inicialización, Given
        LinkedList linkedlist = new LinkedList();
        linkedlist.addAtTail("One");

        //Ejecución, When
        linkedlist.addAtTail("Two");

        //Validación, Then
        Assertions.assertEquals(2,linkedlist.getSize());
        Assertions.assertEquals("One",linkedlist.getAt(0));
        Assertions.assertEquals("Two",linkedlist.getAt(1));
    }

    @Test
    public void givenANewList_whenAddAtFront_thenSizeIsOne(){
        //Inicialización, Given
        LinkedList linkedlist = new LinkedList();

        //Ejecución, When
        linkedlist.addAtFront("One");

        //Validación, Then
        Assertions.assertEquals(1,linkedlist.getSize());
        Assertions.assertEquals("One",linkedlist.getAt(0));
    }

    @Test
    public void givenANonEmptyList_whenAddAtFront_thenSizeIsIncreased() {
        //Inicialización, Given
        LinkedList linkedlist = new LinkedList();
        linkedlist.addAtFront("One");

        //Ejecución, When
        linkedlist.addAtFront("Two");

        //Validación, Then
        Assertions.assertEquals(2,linkedlist.getSize());
        Assertions.assertEquals("Two",linkedlist.getAt(0));
        Assertions.assertEquals("One",linkedlist.getAt(1));
    }

    @Test
    public void givenAList_whenRemoveLessThanZero_thenReturnFalse() {
        //Inicialización, Given
        LinkedList linkedlist = new LinkedList();
        linkedlist.addAtFront("One");

        //Ejecución, When
        boolean result = linkedlist.removeIndex(-1);

        //Validación, Then
        Assertions.assertFalse(result);
    }

    @Test
    public void givenAList_whenRemoveGreaterThanSize_thenReturnFalse() {
        //Inicialización, Given
        LinkedList linkedlist = new LinkedList();
        linkedlist.addAtFront("One");

        //Ejecución, When
        boolean result = linkedlist.removeIndex(1);

        //Validación, Then
        Assertions.assertFalse(result);
    }

    @Test
    public void givenAListWithOneElement_whenRemove0_thenReturnTrue() {
        //Inicialización, Given
        LinkedList linkedlist = new LinkedList();
        linkedlist.addAtFront("One");

        //Ejecución, When
        boolean result = linkedlist.removeIndex(0);

        //Validación, Then
        Assertions.assertTrue(result);
        Assertions.assertEquals(0,linkedlist.getSize());
    }

    @Test
    public void givenAListWithTwoElements_whenRemoveHead_thenReturnTrue() {
        //Inicialización, Given
        LinkedList linkedlist = new LinkedList();
        linkedlist.addAtFront("One");
        linkedlist.addAtFront("Two");

        //Ejecución, When
        boolean result = linkedlist.removeIndex(0);

        //Validación, Then
        Assertions.assertTrue(result);
        Assertions.assertEquals(1,linkedlist.getSize());
        Assertions.assertEquals("One",linkedlist.getAt(0));
    }

    @Test
    public void givenAListWithTwoElements_whenRemoveTail_thenReturnTrue() {
        //Inicialización, Given
        LinkedList linkedlist = new LinkedList();
        linkedlist.addAtTail("One");
        linkedlist.addAtTail("Two");

        //Ejecución, When
        boolean result = linkedlist.removeIndex(1);

        //Validación, Then
        Assertions.assertTrue(result);
        Assertions.assertEquals(1,linkedlist.getSize());
        Assertions.assertEquals("One",linkedlist.getAt(0));
    }

    @Test
    public void givenAListWith3Elements_whenRemoveMiddle_thenReturnTrue() {
        //Inicialización, Given
        LinkedList linkedlist = new LinkedList();
        linkedlist.addAtTail("One");
        linkedlist.addAtTail("Two");
        linkedlist.addAtTail("Three");

        //Ejecución, When
        boolean result = linkedlist.removeIndex(1);

        //Validación, Then
        Assertions.assertTrue(result);
        Assertions.assertEquals(2,linkedlist.getSize());
        Assertions.assertEquals("One",linkedlist.getAt(0));
        Assertions.assertEquals("Three",linkedlist.getAt(1));
    }

    @Test
    public void givenAListWith3Elements_whenRemoveAll_thenSizeIsZero() {
        //Inicialización, Given
        LinkedList linkedlist = new LinkedList();
        linkedlist.addAtTail("One");
        linkedlist.addAtTail("Two");
        linkedlist.addAtTail("Three");

        //Ejecución, When
        linkedlist.removeAll();

        //Validación, Then
        Assertions.assertEquals(0,linkedlist.getSize());
    }

    @Test
    public void givenAListWith3Elements_whenSetAt1_thenElementIsModified() {
        //Inicialización, Given
        LinkedList linkedlist = new LinkedList();
        linkedlist.addAtTail("One");
        linkedlist.addAtTail("Two");
        linkedlist.addAtTail("Three");

        //Ejecución, When
        linkedlist.setAt(1,"Four");

        //Validación, Then
        Assertions.assertEquals(3,linkedlist.getSize());
        Assertions.assertEquals("One",linkedlist.getAt(0));
        Assertions.assertEquals("Four",linkedlist.getAt(1));
        Assertions.assertEquals("Three",linkedlist.getAt(2));
    }

    @Test
    public void givenAListWith3Elements_whenSetAtLessThanZero_thenReturnNull() {
        //Inicialización, Given
        LinkedList linkedlist = new LinkedList();
        linkedlist.addAtTail("One");
        linkedlist.addAtTail("Two");
        linkedlist.addAtTail("Three");

        //Ejecución, When
        boolean result = linkedlist.setAt(-1,"Four");

        //Validación, Then
        Assertions.assertEquals(3,linkedlist.getSize());
        Assertions.assertEquals("One",linkedlist.getAt(0));
        Assertions.assertEquals("Two",linkedlist.getAt(1));
        Assertions.assertEquals("Three",linkedlist.getAt(2));
        Assertions.assertFalse(result);
    }

    @Test
    public void givenAListWith3Elements_whenSetAtIndex3_thenReturnNull() {
        //Inicialización, Given
        LinkedList linkedlist = new LinkedList();
        linkedlist.addAtTail("One");
        linkedlist.addAtTail("Two");
        linkedlist.addAtTail("Three");

        //Ejecución, When
        boolean result = linkedlist.setAt(3,"Four");

        //Validación, Then
        Assertions.assertEquals(3,linkedlist.getSize());
        Assertions.assertEquals("One",linkedlist.getAt(0));
        Assertions.assertEquals("Two",linkedlist.getAt(1));
        Assertions.assertEquals("Three",linkedlist.getAt(2));
        Assertions.assertFalse(result);
    }

    @Test
    public void givenAListWith3Elements_whenGetAtLessThanZero_thenReturnNull() {
        //Inicialización, Given
        LinkedList linkedlist = new LinkedList();
        linkedlist.addAtTail("One");
        linkedlist.addAtTail("Two");
        linkedlist.addAtTail("Three");

        //Ejecución, When
        linkedlist.getAt(-1);

        //Validación, Then
        Assertions.assertEquals(3,linkedlist.getSize());
        Assertions.assertEquals("One",linkedlist.getAt(0));
        Assertions.assertEquals("Two",linkedlist.getAt(1));
        Assertions.assertEquals("Three",linkedlist.getAt(2));
        Assertions.assertNull(linkedlist.getAt(-1));
    }

    @Test
    public void givenAListWith3Elements_whenGetAtIndex3_thenReturnNull() {
        //Inicialización, Given
        LinkedList linkedlist = new LinkedList();
        linkedlist.addAtTail("One");
        linkedlist.addAtTail("Two");
        linkedlist.addAtTail("Three");

        //Ejecución, When
        linkedlist.getAt(3);

        //Validación, Then
        Assertions.assertEquals(3,linkedlist.getSize());
        Assertions.assertEquals("One",linkedlist.getAt(0));
        Assertions.assertEquals("Two",linkedlist.getAt(1));
        Assertions.assertEquals("Three",linkedlist.getAt(2));
        Assertions.assertNull(linkedlist.getAt(-1));
    }

    @Test
    public void givenAListWith3Elements_whenRemoveEspecificValue_thenReturnTrue() {
        //Inicialización, Given
        LinkedList linkedlist = new LinkedList();
        linkedlist.addAtFront("One");
        linkedlist.addAtTail("Two");
        linkedlist.addAtFront("One");

        //Ejecución, When
        boolean result = linkedlist.removeAllWithValue("One");

        //Validación, Then
        Assertions.assertTrue(result);
        Assertions.assertEquals(1,linkedlist.getSize());
    }

    @Test
    public void givenAListWith3Elements_whenRemoveEspecificValueIsAtTail_thenReturnTrue() {
        //Inicialización, Given
        LinkedList linkedlist = new LinkedList();
        linkedlist.addAtTail("One");
        linkedlist.addAtTail("Two");
        linkedlist.addAtTail("Three");

        //Ejecución, When
        boolean result = linkedlist.removeAllWithValue("Three");

        //Validación, Then
        Assertions.assertTrue(result);
        Assertions.assertEquals(2,linkedlist.getSize());
        Assertions.assertEquals("One",linkedlist.getAt(0));
        Assertions.assertEquals("Two",linkedlist.getAt(1));
    }

    @Test
    public void givenAListWith3Elements_whenRemoveEspecificValueIsAtMedium_thenReturnTrue() {
        //Inicialización, Given
        LinkedList linkedlist = new LinkedList();
        linkedlist.addAtTail("One");
        linkedlist.addAtTail("Two");
        linkedlist.addAtTail("Three");

        //Ejecución, When
        boolean result = linkedlist.removeAllWithValue("Two");

        //Validación, Then
        Assertions.assertTrue(result);
        Assertions.assertEquals(2,linkedlist.getSize());
        Assertions.assertEquals("One",linkedlist.getAt(0));
        Assertions.assertEquals("Three",linkedlist.getAt(1));
    }

    @Test
    public void givenAListWith3Elements_whenRemoveEspecificValueIsNotOnTheList_thenReturnTrue() {
        //Inicialización, Given
        LinkedList linkedlist = new LinkedList();
        linkedlist.addAtFront("One");
        linkedlist.addAtTail("Two");
        linkedlist.addAtFront("Three");

        //Ejecución, When
        boolean result = linkedlist.removeAllWithValue("Four");

        //Validación, Then
        Assertions.assertTrue(result);
        Assertions.assertEquals(3,linkedlist.getSize());
    }

    @Test
    public void givenAList_WhenGetIterator_thenReturnIterator() {
        //Inicialización, Given
        LinkedList linkedlist = new LinkedList();
        linkedlist.addAtFront("One");
        linkedlist.addAtTail("Two");
        linkedlist.addAtTail("Three");

        //Ejecución, When
        LinkedListIterator iterator=linkedlist.getIterator();

        //Validación, Then
        int index=0;
        while (iterator.hasNext()){
            Assertions.assertEquals(linkedlist.getAt(index),iterator.next());
            index++;
        }
    }
}
