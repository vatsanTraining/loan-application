package com.example.utils;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ElementNotFoundException extends  RuntimeException{

   private  String message;

    @Override
    public String getMessage() {
        return this.message;
    }
}
