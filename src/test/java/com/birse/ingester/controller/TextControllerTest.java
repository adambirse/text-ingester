package com.birse.ingester.controller;

import com.birse.ingester.resource.Data;
import com.birse.ingester.service.TextService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TextControllerTest {


    @InjectMocks
    private TextController controller;

    @Mock
    private Model model;

    @Mock
    private BindingResult result;

    @Mock
    private Data data;

    @Mock
    private TextService textService;


    @Test
    public void testGet() {
        String expectedPage = controller.get(model);
        verify(model, Mockito.times(1)).addAttribute(eq("data"), any(Data.class));
        assertEquals("text", expectedPage);
    }

    @Test
    public void testPostSuccess() {

        when(result.hasErrors()).thenReturn(false);

        String expectedPage = controller.addData(data,result,model);

        verify(textService, times(1)).send(data);
        assertEquals("index", expectedPage);
    }

    @Test
    public void testPostInvalidData() {

        when(result.hasErrors()).thenReturn(true);

        String expectedPage = controller.addData(data,result,model);

        verify(textService, times(0)).send(data);
        assertEquals("text", expectedPage);
    }

}