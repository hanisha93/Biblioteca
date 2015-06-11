package com.twu.biblioteca;

import java.util.Scanner;
//handles i/o
public class BibliotecaView implements Messages{

    public void printToConsole(String message) {
        System.out.println(message);
    }

    public int readInput() {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        return input;
    }
}
