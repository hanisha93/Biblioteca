package com.twu.biblioteca;

import java.util.Scanner;
//handles i/o
public class View implements Messages{

    Scanner scanner = new Scanner(System.in);

    public View(Scanner scanner) {
        this.scanner = scanner;
    }

    public void printToConsole(String message) {
        System.out.println(message);
    }

    public String  readInput() {
        return scanner.next();
    }

    public Book readBook() {
        String bookTitle = scanner.next();
        return new Book(bookTitle, "", "");
    }

}
