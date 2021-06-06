package com.geektrust.family.service;

import com.geektrust.family.constants.FamilyConstants;
import com.geektrust.family.model.Person;

import java.util.ArrayList;
import java.util.List;

public class RelationshipHandler {
    private static boolean printFlag = false;
    private static boolean foundFlag = false;

    public static void getRelationship(String person, String relation, FamilyTreeInitializer familyTreeInitializer) {
        List<Person> queenChildren;
        switch (relation) {
            case FamilyConstants.SON:
                if (familyTreeInitializer.getQueen().getName().equals(person) || familyTreeInitializer.getKing().getName().equals(person)) {
                    foundFlag = true;
                    List<Person> children = familyTreeInitializer.getQueen().getChildren();
                    for (Person son : children) {
                        if (son.getGender().equals(FamilyConstants.MALE)) {
                            printFlag = true;
                            System.out.print(son.getName() + " ");
                        }

                    }
                } else {
                    queenChildren = familyTreeInitializer.getQueen().getChildren();
                    for (Person child : queenChildren) {
                        getSon(person, child);
                    }
                }
                break;

            case FamilyConstants.DAUGHTER:
                if (familyTreeInitializer.getQueen().getName().equals(person)) {
                    foundFlag = true;
                    List<Person> children = familyTreeInitializer.getQueen().getChildren();
                    for (Person daughter : children) {
                        if (daughter.getGender().equals(FamilyConstants.FEMALE)) {
                            printFlag = true;
                            System.out.print(daughter.getName() + " ");
                        }

                    }
                } else {
                    queenChildren = familyTreeInitializer.getQueen().getChildren();
                    for (Person child : queenChildren) {
                        getDaughter(person, child);
                    }
                }
                break;
            case FamilyConstants.SIBLINGS:
                queenChildren = familyTreeInitializer.getQueen().getChildren();
                for (Person child : queenChildren) {
                    getSibling(person, child);
                }
                break;

            case FamilyConstants.PATERNALUNCLE:
                queenChildren = familyTreeInitializer.getQueen().getChildren();
                for (Person child : queenChildren) {
                    getPaternalUncle(person, child);
                }
                break;
            case FamilyConstants.PATERNALAUNT:
                queenChildren = familyTreeInitializer.getQueen().getChildren();
                for (Person child : queenChildren) {
                    getPaternalAunt(person, child);
                }
                break;
            case FamilyConstants.MATERNALUNCLE:
                queenChildren = familyTreeInitializer.getQueen().getChildren();
                for (Person child : queenChildren) {
                    getMaternalUncle(person, child);
                }
                break;
            case FamilyConstants.MATAERNALAUNT:
                queenChildren = familyTreeInitializer.getQueen().getChildren();
                for (Person child : queenChildren) {
                    getMaternalAunt(person, child);
                }
                break;
            case FamilyConstants.SISTERINLAW:
                queenChildren = familyTreeInitializer.getQueen().getChildren();
                for (Person child : queenChildren) {
                    getSisterInLawSpouseSisters(person, child);
                }
                if (!foundFlag) {
                    for (Person child : queenChildren) {
                        getSisterInLawWivesOfSibling(person, child);
                    }
                }
                break;
            case FamilyConstants.BROTHERINLAW:
                queenChildren = familyTreeInitializer.getQueen().getChildren();
                for (Person child : queenChildren) {
                    getBrotherInLawSpousesBrothers(person, child);
                }
                if(!foundFlag){
                    for (Person child : queenChildren) {
                        getBrotherInLawHusbandsOfSiblings(person, child);
                    }
                }
                break;
            default:
                System.out.print("Invalid Relation");
                break;
        }
        if (!foundFlag)
            System.out.print("PERSON_NOT_FOUND");
        else if (!printFlag)
            System.out.print("NONE");
    }

    private static void getDaughter(String parent, Person child) {
        if (child.getName().equals(parent) || child.getPartner() != null && child.getPartner().getName().equals(parent)) {
            foundFlag = true;
            if (child.getChildren() != null) {
                List<Person> children = child.getChildren();
                for (Person daughter : children) {
                    if (daughter.getGender().equals(FamilyConstants.FEMALE)) {
                        printFlag = true;
                        System.out.print(daughter.getName() + " ");
                    }
                }
            }
        } else if (child.getChildren() != null) {
            List<Person> children = child.getChildren();
            for (Person kid : children) {
                getDaughter(parent, kid);
            }
        }
    }

    public static void getSon(String parent, Person child) {
        if (child.getName().equals(parent) || child.getPartner() != null && child.getPartner().getName().equals(parent)) {
            foundFlag = true;
            if (child.getChildren() != null) {
                List<Person> children = child.getChildren();
                for (Person son : children) {
                    if (son.getGender().equals(FamilyConstants.MALE)) {
                        printFlag = true;
                        System.out.print(son.getName() + " ");
                    }
                }
            }
        } else if (child.getChildren() != null) {
            List<Person> children = child.getChildren();
            for (Person kid : children) {
                getSon(parent, kid);
            }
        }

    }

    public static void getSibling(String person, Person child) {
        if (child.getName().equals(person) || child.getPartner() != null && child.getPartner().getName().equals(person)) {
            foundFlag = true;
            if (child.getParents() != null) {
                List<Person> children = child.getParents().getMother().getChildren();
                for (Person kid : children) {
                    if (!kid.getName().equals(person)) {
                        printFlag = true;
                        System.out.print(kid.getName() + " ");
                    }
                }
            }
        } else if (child.getChildren() != null) {
            List<Person> children = child.getChildren();
            for (Person kid : children) {
                getSibling(person, kid);
            }
        }

    }

    public static void getPaternalUncle(String person, Person child) {
        List<Person> parentChildren = new ArrayList<>();
        if (child.getName().equals(person) || child.getPartner() != null && child.getPartner().getName().equals(person)) {
            foundFlag = true;
            if (child.getParents().getFather().getParents() != null) {
                parentChildren = child.getParents().getFather().getParents().getMother().getChildren();
            }
            for (Person kid : parentChildren) {
                if (!kid.getName().equals(person) && kid.getGender().equals(FamilyConstants.MALE)) {
                    printFlag = true;
                    System.out.print(kid.getName() + " ");
                }
            }
        } else if (child.getChildren() != null) {
            List<Person> children = child.getChildren();
            for (Person kid : children) {
                getPaternalUncle(person, kid);
            }
        }
    }

    private static void getPaternalAunt(String person, Person child) {
        List<Person> parentChildren = new ArrayList<>();
        if (child.getName().equals(person) || child.getPartner() != null && child.getPartner().getName().equals(person)) {
            foundFlag = true;
            if (child.getParents().getFather().getParents() != null) {
                parentChildren = child.getParents().getFather().getParents().getMother().getChildren();
            }
            for (Person kid : parentChildren) {
                if (!kid.getName().equals(person) && kid.getGender().equals(FamilyConstants.FEMALE)) {
                    printFlag = true;
                    System.out.print(kid.getName() + " ");
                }

            }
        } else if (child.getChildren() != null) {
            List<Person> children = child.getChildren();
            for (Person kid : children) {
                getPaternalAunt(person, kid);
            }
        }
    }

    public static void getMaternalUncle(String person, Person child) {
        List<Person> parentChildren = new ArrayList<>();
        if (child.getName().equals(person) || child.getPartner() != null && child.getPartner().getName().equals(person)) {
            foundFlag = true;
            if (child.getParents().getMother().getParents() != null) {
                parentChildren = child.getParents().getMother().getParents().getMother().getChildren();
            }
            for (Person kid : parentChildren) {
                if (!kid.getName().equals(child.getParents().getFather().getName()) && kid.getGender().equals(FamilyConstants.MALE)) {
                    printFlag = true;
                    System.out.print(kid.getName() + " ");
                }
            }
        } else if (child.getChildren() != null) {
            List<Person> children = child.getChildren();
            for (Person kid : children) {
                getMaternalUncle(person, kid);
            }
        }
    }

    public static void getMaternalAunt(String person, Person child) {
        List<Person> parentChildren = new ArrayList<>();
        if (child.getName().equals(person) || child.getPartner() != null && child.getPartner().getName().equals(person)) {
            foundFlag = true;
            if (child.getParents().getMother().getParents() != null) {
                parentChildren = child.getParents().getMother().getParents().getMother().getChildren();
            }
            for (Person kid : parentChildren) {
                if (!kid.getName().equals(child.getParents().getMother().getName()) && kid.getGender().equals(FamilyConstants.FEMALE)) {
                    printFlag = true;
                    System.out.print(kid.getName() + " ");
                }
            }
        } else if (child.getChildren() != null) {
            List<Person> children = child.getChildren();
            for (Person kid : children) {
                getMaternalAunt(person, kid);
            }
        }
    }

    public static void getSisterInLawSpouseSisters(String person, Person child) {

        if (child.getPartner() != null && child.getPartner().getName().equals(person)) {
            foundFlag = true;
            List<Person> spouseSisters = child.getParents().getMother().getChildren();
            for (Person sisterInLaw : spouseSisters) {
                if (sisterInLaw.getGender().equals(FamilyConstants.FEMALE)) {
                    printFlag = true;
                    System.out.print(sisterInLaw.getName() + " ");
                }
            }
        } else if (child.getChildren() != null) {
            List<Person> children = child.getChildren();
            for (Person kid : children) {
                getSisterInLawSpouseSisters(person, kid);
            }
        }
    }

    public static void getSisterInLawWivesOfSibling(String person, Person child) {
        if (child.getName().equals(person) && child.getParents().getMother().getChildren() != null) {
            foundFlag = true;
            List<Person> mothersChildren = child.getParents().getMother().getChildren();
            for (Person kid : mothersChildren) {
                if (kid.getPartner() != null && kid.getPartner().getGender().equals(FamilyConstants.FEMALE)) {
                    printFlag = true;
                    System.out.print(kid.getPartner().getName() + " ");
                }
            }
        } else if (child.getChildren() != null) {
            List<Person> children = child.getChildren();
            for (Person kid : children) {
                getSisterInLawWivesOfSibling(person, kid);
            }
        }
    }

    public static void getBrotherInLawSpousesBrothers(String person, Person child) {
        if (child.getPartner() != null && child.getPartner().getName().equals(person)) {
            foundFlag = true;
            List<Person> spouseSisters = child.getParents().getMother().getChildren();
            for (Person sisterInLaw : spouseSisters) {
                if (sisterInLaw.getGender().equals(FamilyConstants.MALE)) {
                    printFlag = true;
                    System.out.print(sisterInLaw.getName() + " ");
                }
            }
        } else if (child.getChildren() != null) {
            List<Person> children = child.getChildren();
            for (Person kid : children) {
                getBrotherInLawSpousesBrothers(person, kid);
            }
        }
    }

        public static void getBrotherInLawHusbandsOfSiblings (String person, Person child){
            if (child.getName().equals(person) && child.getParents().getMother().getChildren() != null) {
                foundFlag = true;
                List<Person> wivesOfSiblings = child.getParents().getMother().getChildren();
                for (Person daughter : wivesOfSiblings) {
                    if (daughter.getPartner() != null && daughter.getPartner().getGender().equals(FamilyConstants.MALE)) {
                        printFlag = true;
                        System.out.print(daughter.getPartner().getName() + " ");
                    }
                }
            } else if (child.getChildren() != null) {
                List<Person> children = child.getChildren();
                for (Person kid : children) {
                    getBrotherInLawHusbandsOfSiblings(person, kid);
                }
            }
        }
    }
