package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class InvalidOptionTest {

    @Test
    public void specToCheckHandleInvalidOption() {

        BibliotecaView view = mock(BibliotecaView.class);
        InvalidOption invalidOption = new InvalidOption(view);
        invalidOption.handleOption();

        verify(view, Mockito.times(1)).printToConsole(Messages.INVALID_OPTION);
    }

}