package com.geektrust.family.utils;

import com.geektrust.family.constants.FamilyConstants;
import com.geektrust.family.service.FamilyTreeInitializer;
import com.geektrust.family.service.RelationshipHandler;
import com.geektrust.family.service.NewChildHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    public static void processInputFile(FamilyTreeInitializer family, File file) {
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String command = sc.nextLine();
                    processInputCommand(family,command);
                    System.out.println();
                }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found!! Please check the file and the location provided!");
        }
    }

    private static void processInputCommand(FamilyTreeInitializer family, String command) {
        String[] commandParams = command.split(" ");
        switch (commandParams[0]) {
            case FamilyConstants.ADDCHILD:
                NewChildHandler.addChild(commandParams[1], commandParams[2], commandParams[3],family);
                break;

            case FamilyConstants.GETRELATIONSHIP:
                RelationshipHandler.getRelationship(commandParams[1], commandParams[2],family);
                break;
            default:
                System.out.println("INVALID_COMMAND");
                break;
        }


    }
}
