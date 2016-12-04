package com.equaleyes.onelinelist.utils;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ArrayListUtilsTest {

    @Test
    public void insertInEmptyListTest() {
        ArrayList<TestClass> binders = new ArrayList<>();
        ArrayListUtils.insertIfNotYetInList(binders, new TestClass());

        assertEquals(1, binders.size());
    }

    @Test
    public void insertMultipleObjectsTest() {
        ArrayList<TestClass> binders = new ArrayList<>();
        ArrayListUtils.insertIfNotYetInList(binders, new TestClass());
        ArrayListUtils.insertIfNotYetInList(binders, new TestClass());
        ArrayListUtils.insertIfNotYetInList(binders, new TestClass());
        ArrayListUtils.insertIfNotYetInList(binders, new TestClass());

        assertEquals(4, binders.size());
    }

    @Test
    public void addingTheSameInstanceTwice() throws Exception {
        ArrayList<TestClass> binders = new ArrayList<>();
        TestClass binder = new TestClass();

        ArrayListUtils.insertIfNotYetInList(binders, binder);
        ArrayListUtils.insertIfNotYetInList(binders, binder);

        assertEquals(1, binders.size());
    }

    @Test
    public void addingTheSameTypeTwice() throws Exception {
        ArrayList<TestClass> binders = new ArrayList<>();

        ArrayListUtils.insertIfNotYetInList(binders, new TestClass());
        ArrayListUtils.insertIfNotYetInList(binders, new TestClass());

        assertEquals(2, binders.size());
    }

    @Test
    public void removeFromListCorrectSize() throws Exception {
        ArrayList<TestClass> binders = new ArrayList<>();

        TestClass binder = new TestClass();

        ArrayListUtils.insertIfNotYetInList(binders, new TestClass());
        ArrayListUtils.insertIfNotYetInList(binders, binder);

        ArrayListUtils.removeFromList(binders, binder);

        assertEquals(1, binders.size());
    }

    @Test
    public void removeFromListCorrectObject() throws Exception {
        ArrayList<TestClass> binders = new ArrayList<>();

        TestClass binder = new TestClass();
        TestClass bold = new TestClass();

        ArrayListUtils.insertIfNotYetInList(binders, bold);
        ArrayListUtils.insertIfNotYetInList(binders, binder);

        ArrayListUtils.removeFromList(binders, binder);

        assertEquals(bold, binders.get(0));
    }

    @Test
    public void removeFromEmptyList() throws Exception {
        ArrayList<TestClass> binders = new ArrayList<>();

        TestClass binder = new TestClass();

        ArrayListUtils.removeFromList(binders, binder);

        assertEquals(0, binders.size());
    }

    @Test
    public void insertTest() {
        ArrayList<TestClass> binders = new ArrayList<>();
        ArrayListUtils.insertIfNotYetInList(binders, new TestClass());
        ArrayListUtils.insertIfNotYetInList(binders, new TestClass());

        assertEquals(2, binders.size());
    }
}
