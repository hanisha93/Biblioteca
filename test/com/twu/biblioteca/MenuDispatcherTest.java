package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashMap;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MenuDispatcherTest {

    @Test
    public void specToCheckHandleRequest() {

        HashMap<Integer, MenuAction> menuAction = new HashMap<Integer, MenuAction>();

        ListBooks list = mock(ListBooks.class);
        menuAction.put(1, list);
        BibliotecaView view = mock(BibliotecaView.class);
        MenuDispatcher menuDispatcher = new MenuDispatcher(menuAction, view);

        menuDispatcher.handleRequest(1);

        verify(list, Mockito.times(1)).handleOption();

    }

    @Test
    public void specToCheckInavalidOption() {

        HashMap<Integer, MenuAction> menuAction = new HashMap<Integer, MenuAction>();
        BibliotecaView view = mock(BibliotecaView.class);
        ListBooks list = mock(ListBooks.class);
        menuAction.put(1, list);
        MenuDispatcher menuDispatcher = new MenuDispatcher(menuAction, view);

        menuDispatcher.handleRequest(3);

        verify(view, Mockito.times(1)).printToConsole(Messages.INVALID_OPTION);

    }


}