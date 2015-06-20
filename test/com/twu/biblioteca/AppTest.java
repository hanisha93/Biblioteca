package com.twu.biblioteca;

import com.twu.biblioteca.menuAction.ListBooks;
import com.twu.biblioteca.menuAction.QuitOption;
import com.twu.biblioteca.models.UserValidation;
import com.twu.biblioteca.menuAction.MenuAction;
import org.junit.Test;

import java.util.HashMap;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class AppTest {


    @Test
    public void specToCheckAppReadingInput() {
        View view = mock(View.class);
        UserValidation userValidation = mock(UserValidation.class);

        HashMap<String, MenuAction> menuAction = new HashMap<>();
        HashMap<String, String> menu = new HashMap<>();
        menu.put("librarian", "menu");
        HashMap<String, HashMap<String, MenuAction>> menuActions = new HashMap<>();
        menuActions.put("librarian", menuAction);
        when(userValidation.validateUser("001-0001", "hanisha")).thenReturn("librarian");
        when(view.readInput()).thenReturn("001-0001", "hanisha", "1", "9");
        App app = new App();
        app.start(view, menuActions, userValidation, menu);

        verify(view, times(4)).readInput();
    }

    @Test
    public void specToCheckAppDisplayingMessagesToUser() {
        View view = mock(View.class);
        UserValidation userValidation = mock(UserValidation.class);

        HashMap<String, MenuAction> menuAction = new HashMap<>();
        menuAction.put("1", mock(ListBooks.class));
        HashMap<String, String> menu = new HashMap<>();
        menu.put("librarian", "menu");
        HashMap<String, HashMap<String, MenuAction>> menuActions = new HashMap<>();
        menuActions.put("librarian", menuAction);
        when(userValidation.validateUser("001-0001", "hanisha")).thenReturn("librarian");
        when(view.readInput()).thenReturn("001-0001", "hanisha", "1", "9");
        App app = new App();
        app.start(view, menuActions, userValidation, menu);

        verify(view, times(6)).printToConsole(anyString());

    }

}