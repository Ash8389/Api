package com.example.api.controller;

import com.example.api.model.Item;
import com.example.api.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/item")
public class ItemController {

    private final ItemService itemService;

    // Constructor-based dependency injection
    ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

     // API to add a new item.
     // @param item JSON request body containing item details
     // @return Success or error message
    @PostMapping("/add")
    public ResponseEntity<String> addItem(@RequestBody Item item) {
        boolean added = itemService.addItem(item);

        if (!added) {
            return ResponseEntity.badRequest()
                    .body("Item ID already exists or required fields are missing!");
        }

        return ResponseEntity.ok("Item Added Successfully!");
    }


     // API to fetch an item by ID.
     // @param id Item ID from URL path
     // @return Item object if found, 404 otherwise
    @GetMapping("/{id}")
    public ResponseEntity<Item> getItem(@PathVariable int id) {
        Item item = itemService.getItem(id);

        if (item == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(item);
    }
}
