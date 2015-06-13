package com.twu.biblioteca;

import java.util.Scanner;
//handles i/o
public class BibliotecaView implements Messages{

    Scanner scanner = new Scanner(System.in);

    public  BibliotecaView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void printToConsole(String message) {
        System.out.println(message);
    }

    public int readInput() {
        return scanner.nextInt();
    }
}
