package com.geektrust.family.service;

import com.geektrust.family.constants.FamilyConstants;
import com.geektrust.family.model.Parents;
import com.geektrust.family.model.Person;

import java.util.ArrayList;
import java.util.List;

public class NewChildHandler {

    public static void addChild(String mother, String childName, String childGender, FamilyTreeInitializer family) {
        try {
            List<Person> queenChildren = family.getQueen().getChildren();
            Person mom = new Person();
            for (Person person : queenChildren) {
                mom = findPerson(person, mother);
                if(mom!=null && mom.getName().equals(mother)){
                    break;
                }
                if (person.getPartner()!=null && person.getPartner().getName().equals(mother)) {
                    mom = person.getPartner();
                    break;
                }

            }if (mom == null) {
                System.out.print("PERSON_NOT_FOUND");
            }
            else if (mom.getGender().equals(FamilyConstants.MALE)) {
                throw new Exception("");
            }
             else {
                List<Person> children;
                if (mom.getChildren() != null)
                    children = mom.getChildren();
                else
                    children = new ArrayList<>();
                Person child = createChild(childName, childGender, mom);
                children.add(child);
                mom.setChildren(children);
                Person father = child.getParents().getFather();
                father.setChildren(children);
                System.out.print("CHILD_ADDITION_SUCCEEDED");
            }
        } catch (
                Exception addChildException) {
            System.out.print("CHILD_ADDITION_FAILED");
        }

    }

    public static Person findPerson(Person child, String search) {
        if (child.getName().equals(search)) {
            return child;
        }else if(child.getPartner()!=null && child.getPartner().getName().equals(search))
            return child.getPartner();
        else if (child.getChildren() != null) {
            List<Person> children = child.getChildren();
            for (Person kid : children) {
                findPerson(kid, search);
                if (kid.getPartner() != null) {
                    return findPerson(kid.getPartner(), search);
                }
            }
        }
        return null;
    }

    public static Person createChild(String childName, String childGender, Person mother) {
        Person child = new Person();
        child.setName(childName);
        child.setGender(childGender);
        Parents parents = new Parents();
        parents.setMother(mother);
        if (mother.getPartner() != null)
            parents.setFather(mother.getPartner());
        child.setParents(parents);
        return child;
    }
}
