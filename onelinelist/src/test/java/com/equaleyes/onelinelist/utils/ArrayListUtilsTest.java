package com.equaleyes.onelinelist.utils;

import com.equaleyes.onelinelist.binders.Binder;
import com.equaleyes.onelinelist.binders.BoldOnEvenBinder;
import com.equaleyes.onelinelist.binders.CheckBoxBinder;
import com.equaleyes.onelinelist.binders.ImageViewBinder;
import com.equaleyes.onelinelist.binders.TextViewBinder;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ArrayListUtilsTest {

    @Test
    public void insertInEmptyListTest() {
        ArrayList<Binder> binders = new ArrayList<>();
        ArrayListUtils.insertIfNotYetInList(binders, new TextViewBinder());

        assertEquals(1, binders.size());
    }

    @Test
    public void insertMultipleObjectsTest() {
        ArrayList<Binder> binders = new ArrayList<>();
        ArrayListUtils.insertIfNotYetInList(binders, new TextViewBinder());
        ArrayListUtils.insertIfNotYetInList(binders, new BoldOnEvenBinder());
        ArrayListUtils.insertIfNotYetInList(binders, new CheckBoxBinder());
        ArrayListUtils.insertIfNotYetInList(binders, new ImageViewBinder());

        assertEquals(4, binders.size());
    }

    @Test
    public void addingTheSameInstanceTwice() throws Exception {
        ArrayList<Binder> binders = new ArrayList<>();
        Binder binder = new BoldOnEvenBinder();

        ArrayListUtils.insertIfNotYetInList(binders, binder);
        ArrayListUtils.insertIfNotYetInList(binders, binder);

        assertEquals(1, binders.size());
    }

    @Test
    public void addingTheSameTypeTwice() throws Exception {
        ArrayList<Binder> binders = new ArrayList<>();

        ArrayListUtils.insertIfNotYetInList(binders, new BoldOnEvenBinder());
        ArrayListUtils.insertIfNotYetInList(binders, new BoldOnEvenBinder());

        assertEquals(2, binders.size());
    }

    @Test
    public void removeFromListCorrectSize() throws Exception {
        ArrayList<Binder> binders = new ArrayList<>();

        Binder binder = new TextViewBinder();

        ArrayListUtils.insertIfNotYetInList(binders, new BoldOnEvenBinder());
        ArrayListUtils.insertIfNotYetInList(binders, binder);

        ArrayListUtils.removeFromList(binders, binder);

        assertEquals(1, binders.size());
    }

    @Test
    public void removeFromListCorrectObject() throws Exception {
        ArrayList<Binder> binders = new ArrayList<>();

        Binder binder = new TextViewBinder();
        Binder bold = new BoldOnEvenBinder();

        ArrayListUtils.insertIfNotYetInList(binders, bold);
        ArrayListUtils.insertIfNotYetInList(binders, binder);

        ArrayListUtils.removeFromList(binders, binder);

        assertEquals(bold, binders.get(0));
    }

    @Test
    public void removeFromEmptyList() throws Exception {
        ArrayList<Binder> binders = new ArrayList<>();

        Binder binder = new TextViewBinder();

        ArrayListUtils.removeFromList(binders, binder);

        assertEquals(0, binders.size());
    }

    @Test
    public void insertTest() {
        ArrayList<Binder> binders = new ArrayList<>();
        ArrayListUtils.insertIfNotYetInList(binders, new TextViewBinder());
        ArrayListUtils.insertIfNotYetInList(binders, new TextViewBinder());

        assertEquals(2, binders.size());
    }
}
