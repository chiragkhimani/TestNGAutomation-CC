package com.automation.class01;

import org.testng.annotations.*;

public class PracticeTest {

    @BeforeSuite // Before All
    public void setUp() {
        System.out.println("Before");
    }

    @AfterSuite // After All
    public void cleanUp() {
        System.out.println("After");
    }

    @Test
    public void test1() {
        System.out.println("Test 1");
    }

    @Test
    public void test2() {
        System.out.println("Test 2");
    }

}
