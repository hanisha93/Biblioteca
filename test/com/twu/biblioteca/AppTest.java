package com.twu.biblioteca;

import com.twu.biblioteca.CommonMenuAction.CommonMenuAction;
import com.twu.biblioteca.controller.MenuController;
import com.twu.biblioteca.controller.MenuItemController;
import com.twu.biblioteca.menuAction.CheckOutOption;
import com.twu.biblioteca.menuAction.MenuAction;
import com.twu.biblioteca.models.LibrarianJob;
import com.twu.biblioteca.models.UserValidation;
import org.junit.Test;

import java.util.HashMap;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class AppTest {

    @Test
    public void specToCheckAppReadingInput() {
        View view = mock(View.class);
        UserValidation userValidation = mock(UserValidation.class);
        HashMap<String, CommonMenuAction> commonMenuAction = new HashMap<>();
        MenuController menuController = mock(MenuController.class);
        MenuItemController menuItemController = mock(MenuItemController.class);
        LibrarianJob librarianJobHandlesBooks = mock(LibrarianJob.class);
        HashMap<String, MenuAction> menuAction = new HashMap<>();
        menuAction.put("1", new CheckOutOption(menuItemController, librarianJobHandlesBooks, "book"));
        HashMap<String, String> menu = new HashMap<>();
        menu.put("librarian", "menu");
        HashMap<String, HashMap<String, MenuAction>> menuActions = new HashMap<>();
        menuActions.put("librarian", menuAction);
        when(userValidation.validateUser("001-0001", "hanisha")).thenReturn("librarian");
        when(view.readInput()).thenReturn("3", "001-0001", "hanisha", "1", "7");
        App app = new App();
        app.start(view, menuActions, userValidation, menu, menuController, commonMenuAction);

        verify(view, times(5)).readInput();
    }

    @Test
    public void specToCheckAppDisplayingMessagesToUser() {
        View view = mock(View.class);
        UserValidation userValidation = mock(UserValidation.class);
        HashMap<String, CommonMenuAction> commonMenuAction = new HashMap<>();
        MenuController menuController = mock(MenuController.class);
        MenuItemController menuItemController = mock(MenuItemController.class);
        LibrarianJob librarianJobHandlesBooks = mock(LibrarianJob.class);
        HashMap<String, MenuAction> menuAction = new HashMap<>();
        menuAction.put("1", new CheckOutOption(menuItemController, librarianJobHandlesBooks, "book"));
        HashMap<String, String> menu = new HashMap<>();
        menu.put("librarian", "menu");
        HashMap<String, HashMap<String, MenuAction>> menuActions = new HashMap<>();
        menuActions.put("librarian", menuAction);
        when(userValidation.validateUser("001-0001", "hanisha")).thenReturn("librarian");
        when(view.readInput()).thenReturn("3", "001-0001", "hanisha", "1", "7");
        App app = new App();
        app.start(view, menuActions, userValidation, menu, menuController, commonMenuAction);

        verify(view, times(7)).printToConsole(anyString());

    }

    @Test
    public void specToTestWhenUserChooseToLoginItShouldValidateUser() {
        View view = mock(View.class);
        UserValidation userValidation = mock(UserValidation.class);
        HashMap<String, CommonMenuAction> commonMenuAction = new HashMap<>();
        MenuController menuController = mock(MenuController.class);

        MenuItemController menuItemController = mock(MenuItemController.class);
        LibrarianJob librarianJobHandlesBooks = mock(LibrarianJob.class);
        HashMap<String, MenuAction> menuAction = new HashMap<>();
        menuAction.put("1", new CheckOutOption(menuItemController, librarianJobHandlesBooks, "book"));
        HashMap<String, String> menu = new HashMap<>();
        menu.put("librarian", "menu");
        HashMap<String, HashMap<String, MenuAction>> menuActions = new HashMap<>();
        menuActions.put("librarian", menuAction);
        when(userValidation.validateUser("b01-0002", "hanisha")).thenReturn("librarian");

        when(view.readInput()).thenReturn("1", "3", "b01-0002", "hanisha", "7");
        App app = new App();
        app.start(view, menuActions, userValidation, menu, menuController, commonMenuAction);

        verify(userValidation).validateUser("b01-0002", "hanisha");
    }

    @Test
    public void specToTestWhenMenuControllerIsDisplayingOptions() {
        View view = mock(View.class);
        UserValidation userValidation = mock(UserValidation.class);
        HashMap<String, CommonMenuAction> commonMenuAction = new HashMap<>();
        MenuController menuController = mock(MenuController.class);
        MenuItemController menuItemController = mock(MenuItemController.class);
        LibrarianJob librarianJobHandlesBooks = mock(LibrarianJob.class);
        HashMap<String, MenuAction> menuAction = new HashMap<>();
        menuAction.put("1", new CheckOutOption(menuItemController, librarianJobHandlesBooks, "book"));
        HashMap<String, String> menu = new HashMap<>();
        menu.put("librarian", "menu");
        HashMap<String, HashMap<String, MenuAction>> menuActions = new HashMap<>();
        menuActions.put("librarian", menuAction);
        when(userValidation.validateUser("b01-0002", "hanisha")).thenReturn("librarian");

        when(view.readInput()).thenReturn("1", "3", "b01-0002", "hanisha", "7");
        App app = new App();
        app.start(view, menuActions, userValidation, menu, menuController, commonMenuAction);

        verify(menuController, times(2)).displayMenu();
    }

    @Test
    public void specToTestWhenUserLogOutShouldBreakInnerLoop() {
        View view = mock(View.class);
        UserValidation userValidation = mock(UserValidation.class);
        HashMap<String, CommonMenuAction> commonMenuAction = new HashMap<>();
        MenuController menuController = mock(MenuController.class);
        MenuItemController menuItemController = mock(MenuItemController.class);
        LibrarianJob librarianJobHandlesBooks = mock(LibrarianJob.class);
        HashMap<String, MenuAction> menuAction = new HashMap<>();
        menuAction.put("1", new CheckOutOption(menuItemController, librarianJobHandlesBooks, "book"));
        HashMap<String, String> menu = new HashMap<>();
        menu.put("librarian", "menu");
        HashMap<String, HashMap<String, MenuAction>> menuActions = new HashMap<>();
        menuActions.put("librarian", menuAction);
        menuActions.put("member", menuAction);
        when(userValidation.validateUser("b01-0002", "hanisha")).thenReturn("librarian");
        when(userValidation.validateUser("b01-0003", "priya")).thenReturn("member");
        when(view.readInput()).thenReturn("3", "b01-0003", "priya", "0", "3", "b01-0002", "hanisha", "7");
        App app = new App();
        app.start(view, menuActions, userValidation, menu, menuController, commonMenuAction);

        verify(menuController, times(2)).displayMenu();
    }


}