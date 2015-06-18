package com.twu.biblioteca.controller;

import com.twu.biblioteca.Messages;
import com.twu.biblioteca.View;
import com.twu.biblioteca.controller.MenuController;
import com.twu.biblioteca.menuAction.ListBooks;
import com.twu.biblioteca.menuAction.MenuAction;
import org.junit.Test;

import java.util.HashMap;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MenuControllerTest {

    @Test
    public void specToCheckHandleRequest() {

        HashMap<String, MenuAction> menuAction = new HashMap<String , MenuAction>();

        ListBooks list = mock(ListBooks.class);
        menuAction.put("1", list);
        View view = mock(View.class);
        MenuController menuDispatcher = new MenuController(menuAction, view);

        menuDispatcher.handleOption("1","b01-0001");

        verify(list).performAction("b01-0001");

    }

    @Test
    public void specToCheckInavalidOption() {

        HashMap<String, MenuAction> menuAction = new HashMap<String, MenuAction>();
        View view = mock(View.class);
        ListBooks list = mock(ListBooks.class);
        menuAction.put("1", list);
        MenuController menuDispatcher = new MenuController(menuAction, view);

        menuDispatcher.handleOption("3","001-0001");

        verify(view).printToConsole(Messages.INVALID_OPTION);

    }


}