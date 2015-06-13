package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class InvalidOptionTest {

    @Test
    public void specToCheckHandleInvalidOption() {

        View view = mock(View.class);
        InvalidOption invalidOption = new InvalidOption(view);
        invalidOption.handleOption();

        verify(view, Mockito.times(1)).printToConsole(Messages.INVALID_OPTION);
    }

}