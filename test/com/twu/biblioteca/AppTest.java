package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AppTest {

    @Test
    public void specToCheckAppReadingInput() {

        View view = mock(View.class);
        MenuController menuController = mock(MenuController.class);
        when(view.readInput()).thenReturn(1, 1, 2, 0);
        App app = new App();
        app.start(view, menuController);

        verify(view, Mockito.times(4)).readInput();
    }

}