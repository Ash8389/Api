package com.example.api.service;

import com.example.api.model.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ItemService {

    // In-memory storage for items (data will be lost on app restart)
    private final ArrayList<Item> items = new ArrayList<>();

     // Adds a new item to the list.
     // @param item Item object sent from the controller
     // @return true if item is valid and added, false otherwise

    public boolean addItem(Item item) {

        // Check if an item with the same ID already exists
        for (Item it : items) {
            if (it.getId() == item.getId()) {
                return false; // Duplicate ID not allowed
            }
        }

        // Basic validation of required fields
        if (item.getName() != null && !item.getName().isEmpty()
                && item.getDescription() != null && !item.getDescription().isEmpty()
                && item.getCost() > 0) {

            items.add(item);
            return true;
        }

        // Validation failed
        return false;
    }

     // Retrieves an item by its ID.
     // @param id Item ID
     // @return Item if found, otherwise null
    public Item getItem(int id) {
        for (Item it : items) {
            if (it.getId() == id) {
                return it;
            }
        }
        return null;
    }
}
