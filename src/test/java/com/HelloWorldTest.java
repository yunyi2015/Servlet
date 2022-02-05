package com;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class HelloWorldTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
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