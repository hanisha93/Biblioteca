package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MenuTest {

    @Test
    public void specToCheckHandleRequest() {

        HashMap<Integer, MenuAction> menuAction = new HashMap<Integer, MenuAction>();

        ListBooks list = mock(ListBooks.class);
        menuAction.put(1, list);
        Menu menu = new Menu(menuAction);

        menu.handleRequest(1);

        verify(list, Mockito.times(1)).handleOption();

    }
}