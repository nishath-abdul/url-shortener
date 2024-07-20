package com.abdul.projects.urlshortener.service;

import org.springframework.stereotype.Service;

@Service
public class BaseConversion {

    private static final String StringPattern = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private char[] charArray = StringPattern.toCharArray();
    private int base = charArray.length;

    public String encode(long input){
        var encodedString = new StringBuilder();

        if(input == 0) {
            return String.valueOf(charArray[0]);
        }

        while (input > 0) {
            encodedString.append(charArray[(int) (input % base)]);
            input = input / base;
        }
        System.out.println("Encoded String ==> ::" +  encodedString.reverse().toString());
        return encodedString.reverse().toString();
    }
}
