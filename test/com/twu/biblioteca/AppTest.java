package com.twu.biblioteca;

import com.twu.biblioteca.controller.MenuController;
import com.twu.biblioteca.controller.UserValidation;
import com.twu.biblioteca.menuAction.MenuAction;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashMap;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AppTest {

    /*@Test
    public void specToCheckAppReadingInput() {
        View view = mock(View.class);
        MenuController menuController = mock(MenuController.class);
        UserValidation userValidation = mock(UserValidation.class);
        HashMap<String, HashMap<String, MenuAction>> menu = new HashMap<>();
        when(userValidation.validateUser("001-0001", "hanisha")).thenReturn("admin");
        when(view.readInput()).thenReturn("001-0001", "hanisha", "1", "0");
        App app = new App();
        app.start(view, menu, userValidation);

        verify(view, Mockito.times(4)).readInput();
    }

    @Test
    public void specToCheckAppDisplayingMenuList() {
        View view = mock(View.class);
        MenuController menuController = mock(MenuController.class);
        UserValidation userValidation = mock(UserValidation.class);
        HashMap<String, HashMap<String, MenuAction>> menu = new HashMap<>();
        when(userValidation.validateUser("001-0001", "hanisha")).thenReturn("admin");
        App app = new App();
        when(view.readInput()).thenReturn("001-0001", "hanisha", "1", "0");
        app.start(view, menu, userValidation);
        verify(view, Mockito.times(6)).printToConsole(anyString());

    }*/
}