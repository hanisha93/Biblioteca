package com.twu.biblioteca;

import com.twu.biblioteca.controller.MenuController;
import org.junit.Test;

import java.util.HashMap;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MenuControllerTest {

    @Test
    public void specToCheckHandleRequest() {

        HashMap<String, MenuAction> menuAction = new HashMap<String , MenuAction>();

        menuAction.ListBooks list = mock(menuAction.ListBooks.class);
        menuAction.put("1", list);
        View view = mock(View.class);
        MenuController menuDispatcher = new MenuController(menuAction, view);

        menuDispatcher.handleRequest("1");

        verify(list).handleOption();

    }

    @Test
    public void specToCheckInavalidOption() {

        HashMap<String, MenuAction> menuAction = new HashMap<String, MenuAction>();
        View view = mock(View.class);
        menuAction.ListBooks list = mock(menuAction.ListBooks.class);
        menuAction.put("1", list);
        MenuController menuDispatcher = new MenuController(menuAction, view);

        menuDispatcher.handleRequest("3");

        verify(view).printToConsole(Messages.INVALID_OPTION);

    }


}