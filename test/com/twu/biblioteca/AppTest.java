package com.twu.biblioteca;

import com.twu.biblioteca.controller.MenuController;
import com.twu.biblioteca.controller.UserValidation;
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
        UserValidation userValidation = mock(UserValidation.class);
        when(view.readInput()).thenReturn("1", "1", "2", "0");
        App app = new App();
        app.start(view, menuController,userValidation);

        verify(view, Mockito.times(4)).readInput();
    }

    @Test
    public void specToCheckAppDisplayingMenuList() {
        View view = mock(View.class);
        MenuController menuController = mock(MenuController.class);
        UserValidation userValidation = mock(UserValidation.class);
        App app = new App();
        when(view.readInput()).thenReturn("1", "0");
        app.start(view, menuController, userValidation);
        verify(view, Mockito.times(2)).printToConsole("1.ListBooks\n" +
                "2.CheckOut\n" +
                "3.Return\n" +
                "4.ListMovies\n" +
                "5.CheckOutMovie\n" +
                "6.ReturnMovie\n" +
                "0.quit");
    }
}