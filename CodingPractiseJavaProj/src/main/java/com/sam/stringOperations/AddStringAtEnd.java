package com.sam.stringOperations;

import java.util.Arrays;
import java.util.List;

public class AddStringAtEnd {

    public static void main(String[] args) {
        String str = "Samanth";
        List<String> operations = Arrays.asList("delete", "add a", "add left b", "add left left b");
    }

    public String performOperation(String originalStr, List<String> operations) {
        for(String s : operations) {
            String[] oprArray = s.split(" ");
            switch (oprArray[0]) {
                case "delete":
                    if("left".equalsIgnoreCase(oprArray[1]))
                        return deleteStringFromLeft(originalStr, oprArray);
                    return deleteStringAtEnd(originalStr, oprArray);
                case "add":
                    if("left".equalsIgnoreCase(oprArray[1]))
                        return addStringFromLeft(originalStr, oprArray);
                    return addStringAtEnd(originalStr, oprArray);
                default:
                    return "Operation is not matching";
            }
        }
        return "empty list";
    }

    public String addStringAtEnd(String originalStr, String[] oprArray) {
        return originalStr;
    }

    public String deleteStringAtEnd(String originalStr, String[] oprArray) {
        return originalStr;
    }

    public String addStringFromLeft(String originalStr, String[] oprArray) {
        return originalStr;
    }

    public String deleteStringFromLeft(String originalStr, String[] oprArray) {
        return originalStr;
    }
}
