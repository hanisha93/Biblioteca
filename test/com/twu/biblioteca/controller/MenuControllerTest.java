package com.twu.biblioteca.controller;

import com.twu.biblioteca.CommonMenuAction.CommonMenuAction;
import com.twu.biblioteca.CommonMenuAction.ListBooksOption;
import com.twu.biblioteca.View;
import com.twu.biblioteca.menuAction.CheckOutOption;
import com.twu.biblioteca.menuAction.MenuAction;
import org.junit.Test;

import java.util.HashMap;

import static com.twu.biblioteca.Messages.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MenuControllerTest {

    @Test
    public void specToCheckHandleRequestForCommonMenu() {

        HashMap<String, CommonMenuAction> commonMenuAction = new HashMap<>();

        ListBooksOption list = mock(ListBooksOption.class);
        commonMenuAction.put("1", list);
        View view = mock(View.class);
        MenuController menuController = new MenuController(view, "");

        menuController.handleCommonMenuOption("1", commonMenuAction);

        verify(list).performMenuAction();

    }

    @Test
    public void specToCheckInavalidOptionForCommonMenu() {
        HashMap<String, CommonMenuAction> commonMenuAction = new HashMap<>();
        ListBooksOption listBooksOption = mock(ListBooksOption.class);
        commonMenuAction.put("1", listBooksOption);
        View view = mock(View.class);
        MenuController menuController = new MenuController(view, "");

        menuController.handleCommonMenuOption("5", commonMenuAction);

        verify(view).printToConsole(INVALID_OPTION);

    }

    @Test
    public void specToCheckDisplayMenuForCommonMenu() {
        HashMap<String, CommonMenuAction> commonMenuAction = new HashMap<>();
        ListBooksOption listBooksOption = mock(ListBooksOption.class);
        commonMenuAction.put("1", listBooksOption);
        View view = mock(View.class);
        MenuController menuController = new MenuController(view, "Dispaly ListBooksOption And ListMenu Option");

        menuController.displayMenu();

        verify(view).printToConsole("Dispaly ListBooksOption And ListMenu Option");

    }

    @Test
    public void specToCheckInvaliOptionForUserMenu() {

        HashMap<String, MenuAction> menuAction = new HashMap<>();

        CheckOutOption checkOutOption = mock(CheckOutOption.class);
        menuAction.put("1", checkOutOption);
        View view = mock(View.class);
        MenuController menuController = new MenuController(view, "");

        menuController.handleOption("9", "b01-0002", menuAction);

        verify(view).printToConsole(INVALID_OPTION);

    }

    @Test
    public void specToCheckHandleRequestForUserMenu() {
        HashMap<String, MenuAction> menuAction = new HashMap<>();
        CheckOutOption checkOutOption = mock(CheckOutOption.class);
        menuAction.put("1", checkOutOption);
        View view = mock(View.class);
        MenuController menuController = new MenuController(view, "");

        menuController.handleOption("1", "b01-0002", menuAction);

        verify(checkOutOption).performAction("b01-0002");

    }

    @Test
   public void specToCheckDisplayMenuForUserLoggedIn() {
        HashMap<String, MenuAction> MenuAction = new HashMap<>();
        CheckOutOption checkOutOption = mock(CheckOutOption.class);
        MenuAction.put("1", checkOutOption);
        View view = mock(View.class);
        MenuController menuController = new MenuController(view, "librarianMenu");
        menuController.displayMenu();

        verify(view).printToConsole("librarianMenu");

    }
}