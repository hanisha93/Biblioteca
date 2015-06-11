package com.twu.biblioteca;

import java.util.Scanner;
//handles i/o
public class BibliotecaView implements Messages{

    public void printToConsole(String message) {
        System.out.println(message);
    }

    public String readInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        return input;
    }
}
