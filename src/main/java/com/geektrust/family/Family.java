package com.geektrust.family;

import com.geektrust.family.service.FamilyTreeInitializer;
import com.geektrust.family.utils.FileReader;

import java.io.File;

public class Family {

    public static void main(String args[]) {
        try {
            FamilyTreeInitializer family = new FamilyTreeInitializer();
            File file = new File(args[0]);
            FileReader.processInputFile(family, file);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Please enter file location(s)!");
        }
    }
}
