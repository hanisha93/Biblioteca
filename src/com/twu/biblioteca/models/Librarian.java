package com.twu.biblioteca.models;

import com.twu.biblioteca.Item;
import com.twu.biblioteca.item.Book;

import java.util.ArrayList;

import static com.twu.biblioteca.Messages.*;

public class Librarian {

    private ArrayList<Item> itemsInLibrary;
    private ArrayList<Item> checkedOutItems;

    public Librarian(ArrayList<Item> ItemsInLibrary, ArrayList<Item> checkedOutItems) {
        this.itemsInLibrary = ItemsInLibrary;
        this.checkedOutItems = checkedOutItems;
    }

    public ArrayList<Item> searchItem(String title, ArrayList<Item> result) {
        for (Item item : itemsInLibrary) {
            if (item.match(title)) {
                result.add(item);
                break;
            }
        }
        return result;
    }

    public ArrayList<Item> searchCheckedOutList(String title, ArrayList<Item> result) {
        for (Item item : checkedOutItems) {
            if (item.match(title)) {
                result.add(item);
                break;
            }
        }
        return result;
    }

    public String doCheckout(ArrayList<Item> result, String itm) {
        for (Item item : result) {
            itemsInLibrary.remove(item);
            checkedOutItems.add(item);
            return SUCCESSFUL_CHECKOUT + itm;
        }
        return itm +CHECKOUT_FAIL;
    }

    public String returnItem(ArrayList<Item> result, String itm) {
        for (Item item : result) {
            itemsInLibrary.add(item);
            checkedOutItems.remove(item);
            return SUCCESSFUL_RETURN + itm;
        }
        return RETURN_FAIL + itm;
    }

}