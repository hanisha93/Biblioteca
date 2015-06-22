package com.twu.biblioteca.models;

import com.twu.biblioteca.Item;
import com.twu.biblioteca.item.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.twu.biblioteca.Messages.*;

public class LibrarianJob {

    private ArrayList<Item> itemsInLibrary;
    private ArrayList<Item> checkedOutItems;
    private HashMap<Item, String> users;

    public LibrarianJob(ArrayList<Item> ItemsInLibrary, ArrayList<Item> checkedOutItems, HashMap<Item, String> users) {
        this.itemsInLibrary = ItemsInLibrary;
        this.checkedOutItems = checkedOutItems;
        this.users = users;
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

    public ArrayList<Item> searchCheckedOutList(String title, ArrayList<Item> result, String libraryNo) {
        for (Item item : checkedOutItems) {
            if (item.match(title)) {
                if(users.get(item).equals(libraryNo))
                    result.add(item);
                break;
            }
        }
        return result;
    }

    public String doCheckout(ArrayList<Item> result, String itm, String libraryNo) {
        for (Item item : result) {
            itemsInLibrary.remove(item);
            checkedOutItems.add(item);
            users.put(item, libraryNo);
            return SUCCESSFUL_CHECKOUT + itm;
        }
        return itm + CHECKOUT_FAIL;
    }

    public String acceptReturnItem(ArrayList<Item> result, String itm) {
        for (Item item : result) {
            itemsInLibrary.add(item);
            checkedOutItems.remove(item);
            users.remove(item);
            return SUCCESSFUL_RETURN + itm;
        }
        return RETURN_FAIL + itm;
    }

    public HashMap<Item, String> getCheckOutDetails() {
        return users;
    }

}