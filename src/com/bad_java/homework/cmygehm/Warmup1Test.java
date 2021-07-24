package com.bad_java.homework.cmygehm;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(DataProviderRunner.class)
public class Warmup1Test {
    /**
     * The parameter weekday is true if it is a weekday,
     * and the parameter vacation is true if we are on vacation.
     * We sleep in if it is not a weekday or we're on vacation.
     * Return true if we sleep in.
     * <p>
     * <p>
     * sleepIn(false, false) → true
     * sleepIn(true, false) → false
     * sleepIn(false, true) → true
     */
    @Test
    @UseDataProvider("sleepInProvider")
    public void sleepIn(boolean weekday, boolean vacation, boolean expected) {

        Warmup1 w = new Warmup1();
        assertThat(w.sleepIn(weekday, vacation), equalTo(expected));
    }

    @DataProvider
    public static Object[] sleepInProvider() {
        return new Object[][]{
                {true, true, true},
                {true, false, false},
                {false, true, true},
                {false, false, true}
        };
    }
}
