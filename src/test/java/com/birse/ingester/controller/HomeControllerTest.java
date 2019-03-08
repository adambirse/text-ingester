package com.birse.ingester.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class HomeControllerTest {

    private HomeController controller;

    @Test
    public void returnIndex() {
        controller = new HomeController();
        assertEquals("index", controller.get());
    }
}