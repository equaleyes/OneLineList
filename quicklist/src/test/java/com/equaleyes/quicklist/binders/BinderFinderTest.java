package com.equaleyes.quicklist.binders;

import com.equaleyes.quicklist.CorruptedBinder;
import com.equaleyes.quicklist.PrivateConstructorBinder;
import com.equaleyes.quicklist.TestData;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.Field;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

public class BinderFinderTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void oneBinderForAnnotation() throws Exception {
        BinderFinder binderFinder = getBinderFinderWithBinders(TextViewBinder.class);
        Field textTestField = getTestField("testTitle");
        ArrayList<Binder> binders = binderFinder.findBindersForField(textTestField);

        assertEquals(1, binders.size());
    }

    @Test public void correctBinderForAnnotation() throws Exception {
        BinderFinder binderFinder = getBinderFinderWithBinders(TextViewBinder.class);
        Field textTestField = getTestField("testTitle");
        ArrayList<Binder> binders = binderFinder.findBindersForField(textTestField);

        assertThat(binders.get(0), instanceOf(TextViewBinder.class));
    }

    @Test
    public void findMultipleBindersForField() throws Exception {
        BinderFinder binderFinder = getBinderFinderWithBinders(TextViewBinder.class, BoldOnEvenBinder.class);
        Field textTestField = getTestField("twoAnnotations");

        ArrayList<Binder> binders = binderFinder.findBindersForField(textTestField);

        assertEquals(2, binders.size());
    }

    @Test
    public void correctMultipleBindersInOrderForField() throws Exception {
        BinderFinder binderFinder = getBinderFinderWithBinders(TextViewBinder.class, BoldOnEvenBinder.class);
        Field textTestField = getTestField("twoAnnotations");

        ArrayList<Binder> binders = binderFinder.findBindersForField(textTestField);

        assertThat(binders.get(0), instanceOf(TextViewBinder.class));
        assertThat(binders.get(1), instanceOf(BoldOnEvenBinder.class));
    }

    @Test
    public void addingBinder() throws Exception {
        BinderFinder binderFinder = getBinderFinderWithBinders();
        binderFinder.addBinder(new BoldOnEvenBinder());

        assertEquals(1, binderFinder.binders.size());
    }

    @Test
    public void addingTheSameBinderInstanceTwice() throws Exception {
        BinderFinder binderFinder = getBinderFinderWithBinders();

        Binder binder = new BoldOnEvenBinder();

        binderFinder.addBinder(binder);
        binderFinder.addBinder(binder);

        assertEquals(1, binderFinder.binders.size());
    }

    @Test
    public void addingTheSameBinderTypeTwice() throws Exception {
        BinderFinder binderFinder = getBinderFinderWithBinders();

        binderFinder.addBinder(new BoldOnEvenBinder());
        binderFinder.addBinder(new BoldOnEvenBinder());

        assertEquals(2, binderFinder.binders.size());
    }

    @Test
    public void errorHandlingForBinderReturningNullAnnotation() throws Exception {
        BinderFinder binderFinder = getBinderFinderWithBinders(CorruptedBinder.class);
        Field textTestField = getTestField("testTitle");
        binderFinder.findBindersForField(textTestField);
    }

    @Test
    public void binderConstructorPrivate() throws Exception {
        BinderFinder binderFinder = getBinderFinderWithBinders();
        binderFinder.addBinder(PrivateConstructorBinder.getNewInstance());

        Field textTestField = getTestField("testTitle");

        binderFinder.findBindersForField(textTestField);
    }

    public BinderFinder getBinderFinderWithBinders(Class<? extends Binder>... tClass) {
        BinderFinder binderFinder = new BinderFinder();
        binderFinder.binders.clear();

        for (Class<? extends Binder> temp : tClass) {
            try {
                binderFinder.binders.add(temp.newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return binderFinder;
    }

    public Field getTestField(String fieldName) {
        try {
            return TestData.class.getField(fieldName);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        return null;
    }
}