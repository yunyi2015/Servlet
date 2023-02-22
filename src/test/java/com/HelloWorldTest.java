package com;

import org.testng.annotations.*;

import static org.testng.Assert.*;



public class HelloWorldTest {

    @BeforeTest
    public void setUp() throws Exception {
    }

    @AfterTest
    public void tearDown() throws Exception {
    }

    @Test
    public void DoGet() {
        int i,j;
        for (i=1;i<=10;i++);
        {j=i;}
        assertEquals(j, new HelloWorld().HW(11,1));
        }


    }