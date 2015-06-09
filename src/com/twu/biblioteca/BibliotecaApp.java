package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String args[]) {
        OutputMessages msg = new OutputMessages();
        msg.displayWelcomeMessage();

        Scanner option = new Scanner(System.in);
        msg.displayMenu();
        int choice = option.nextInt();

    }

}
