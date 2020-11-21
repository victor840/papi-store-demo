// This is the package it defines the family relation of objects
package com.codedifferently.store;

// This is importing Classes from the org.junit package/folder
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

// This is a public class called Papi
public class PapiStoreTest {

    // creates a reference papiStore of object PapiStore.
    PapiStore papiStore;

    //fixture annotation
    // sets papiStore reference to new PapiStore.
    // the setup method assigning values.
    @Before
    public void setup(){
        papiStore = new PapiStore();
        papiStore.createActiveTab("Jamal");
        papiStore.createActiveTab("Victor");
        papiStore.owesPapiMoney.put("Jamal", 0.0);
        papiStore.owesPapiMoney.put("Victor", 7.0);
    }

    //Test fixture annotation runs test.
    //Checking to see if store is open.
    @Test
    public void OpenStoreTest(){
        //Given

        papiStore.openStore();

        //When
        Boolean expected = true;
        Boolean actual = papiStore.isStoreOpen();

        //Then
        //Assert.assertEquals(expected, actual);
        Assert.assertTrue(actual);
    }

    //Checking to see if person can use tab.
    @Test
    public void allowToUseTabTestSuccess(){
        // given
        PapiStore papiStore = new PapiStore();

        // when
        Boolean expected = true;
        Boolean actual = papiStore.allowToUseTab("Jamal");

        // then
        Assert.assertEquals(expected, actual);
    }

    //Checking to see if person cannot use tab.
    @Test
    public void allowToUseTabTestFail(){
        // given
        PapiStore papiStore = new PapiStore();

        // when
        Boolean expected = false;
        Boolean actual = papiStore.allowToUseTab("Victor");

        // then
        Assert.assertEquals(expected, actual);
    }
}
