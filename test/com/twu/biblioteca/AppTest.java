package com.twu.biblioteca;

import com.twu.biblioteca.controller.MenuController;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AppTest {

    @Test
    public void specToCheckAppReadingInput() {

        View view = mock(View.class);
        MenuController menuController = mock(MenuController.class);
        when(view.readInput()).thenReturn("1", "1", "2", "0");
        App app = new App();
        app.start(view, menuController);

        verify(view, Mockito.times(4)).readInput();
    }

    @Test
    public void specToCheckAppDisplayingMenuList() {

        View view = mock(View.class);
        MenuController menuController = mock(MenuController.class);
        App app = new App();
        when(view.readInput()).thenReturn("1","0");
        app.start(view, menuController);
        verify(view, Mockito.times(2)).printToConsole("1.ListBooks\n" +
                "2.CheckOut\n" +
                "3.ReturnBook\n" +
                "0.quit");
    }
}