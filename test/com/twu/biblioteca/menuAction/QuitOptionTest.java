package com.twu.biblioteca.menuAction;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import static org.junit.Assert.*;

public class QuitOptionTest {

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void testPerformAction() {
        QuitOption quitOption = new QuitOption();

        exit.expectSystemExitWithStatus(0);

        quitOption.performAction("b01-0001");
    }

}