package com.geektrust.family.service;

import com.geektrust.family.model.Parents;
import com.geektrust.family.model.Person;

import java.util.ArrayList;
import java.util.List;

public class FamilyTreeInitializer {
    private Person king = new Person();
    private Person queen = new Person();

    public FamilyTreeInitializer(){
        king.setName("Shan");
        queen.setName("Anga");
        createFamily();

    }
    void createFamily(){
        Person Chit = new Person();
        Chit.setName("Chit");
        Chit.setGender("Male");

        Person Ish = new Person();
        Ish.setName("Ish");
        Ish.setGender("Male");

        Person Vich = new Person();
        Vich.setName("Vich");
        Vich.setGender("Male");

        Person Aras = new Person();
        Aras.setName("Aras");
        Aras.setGender("Male");

        Person Vyan = new Person();
        Vyan.setName("Vyan");
        Vyan.setGender("Male");

        Person Jaya = new Person();
        Jaya.setName("Jaya");
        Jaya.setGender("Male");

        Person Vritha = new Person();
        Vritha.setName("Vritha");
        Vritha.setGender("Male");

        Person Arit = new Person();
        Arit.setName("Arit");
        Arit.setGender("Male");

        Person Ahit = new Person();
        Ahit.setName("Ahit");
        Ahit.setGender("Male");

        Person Asva = new Person();
        Asva.setName("Asva");
        Asva.setGender("Male");

        Person Vyas = new Person();
        Vyas.setName("Vyas");
        Vyas.setGender("Male");


        Person Yodhan = new Person();
        Yodhan.setName("Yodhan");
        Yodhan.setGender("Male");

        Person Laki = new Person();
        Laki.setName("Laki");
        Laki.setGender("Male");

        Person Vasa = new Person();
        Vasa.setName("Vasa");
        Vasa.setGender("Male");

        Person Kriya = new Person();
        Kriya.setName("Kriya");
        Kriya.setGender("Male");

        //Female
        Person Krithi = new Person();
        Krithi.setName("Krithi");
        Krithi.setGender("Female");

        Person Lavnya = new Person();
        Lavnya.setName("Lavnya");
        Lavnya.setGender("Female");

        Person Dritha = new Person();
        Dritha.setName("Dritha");
        Dritha.setGender("Female");

        Person Tritha = new Person();
        Tritha.setName("Tritha");
        Tritha.setGender("Female");

        Person Vila = new Person();
        Vila.setName("Vila");
        Vila.setGender("Female");

        Person Chika = new Person();
        Chika.setName("Chika");
        Chika.setGender("Female");

        Person Jnki = new Person();
        Jnki.setName("Jnki");
        Jnki.setGender("Female");

        Person Satvy = new Person();
        Satvy.setName("Satvy");
        Satvy.setGender("Female");

        Person Krpi = new Person();
        Krpi.setName("Krpi");
        Krpi.setGender("Female");

        Person Atya = new Person();
        Atya.setName("Atya");
        Atya.setGender("Female");

        Person Satya = new Person();
        Satya.setName("Satya");
        Satya.setGender("Female");

        Person Chitra = new Person();
        Chitra.setName("Chitra");
        Chitra.setGender("Female");

        Person Lika = new Person();
        Lika.setName("Lika");
        Lika.setGender("Female");

        Person Amba = new Person();
        Amba.setName("Amba");
        Amba.setGender("Female");

        //set partner
        king.setPartner(queen);
        queen.setPartner(king);

        Chit.setPartner(Amba);
        Amba.setPartner(Chit);

        Vich.setPartner(Lika);
        Lika.setPartner(Vich);

        Aras.setPartner(Chitra);
        Chitra.setPartner(Aras);

        Satya.setPartner(Vyan);
        Vyan.setPartner(Satya);

        Dritha.setPartner(Jaya);
        Jaya.setPartner(Dritha);

        Arit.setPartner(Jnki);
        Jnki.setPartner(Arit);

        Satvy.setPartner(Asva);
        Asva.setPartner(Satvy);

        Krpi.setPartner(Vyas);
        Vyas.setPartner(Krpi);

        //set children
        List<Person> KingQueenChildren = new ArrayList<>();
        KingQueenChildren.add(Chit);
        KingQueenChildren.add(Ish);
        KingQueenChildren.add(Vich);
        KingQueenChildren.add(Aras);
        KingQueenChildren.add(Satya);
        king.setChildren(KingQueenChildren);
        queen.setChildren(KingQueenChildren);

        List<Person> ChitAmbaChildren = new ArrayList<>();
        ChitAmbaChildren.add(Dritha);
        ChitAmbaChildren.add(Tritha);
        ChitAmbaChildren.add(Vritha);
        Chit.setChildren(ChitAmbaChildren);
        Amba.setChildren(ChitAmbaChildren);


        List<Person> VichLikaChildren = new ArrayList<>();
        VichLikaChildren.add(Vila);
        VichLikaChildren.add(Chika);
        Vich.setChildren(VichLikaChildren);
        Lika.setChildren(VichLikaChildren);

        List<Person> ArasChitraChildren = new ArrayList<>();
        ArasChitraChildren.add(Jnki);
        ArasChitraChildren.add(Ahit);
        Aras.setChildren(ArasChitraChildren);
        Chitra.setChildren(ArasChitraChildren);

        List<Person> SatyaVyanChildren = new ArrayList<>();
        SatyaVyanChildren.add(Asva);
        SatyaVyanChildren.add(Vyas);
        SatyaVyanChildren.add(Atya);
        Satya.setChildren(SatyaVyanChildren);
        Vyan.setChildren(SatyaVyanChildren);

        List<Person> KrpiVyasChildren = new ArrayList<>();
        KrpiVyasChildren.add(Kriya);
        KrpiVyasChildren.add(Krithi);
        Krpi.setChildren(KrpiVyasChildren);
        Vyas.setChildren(KrpiVyasChildren);

        List<Person> SatvyAsvaChildren = new ArrayList<>();
        SatvyAsvaChildren.add(Vasa);
        Satvy.setChildren(SatvyAsvaChildren);
        Asva.setChildren(SatvyAsvaChildren);

        List<Person> AritJnkiChildren = new ArrayList<>();
        AritJnkiChildren.add(Laki);
        AritJnkiChildren.add(Lavnya);
        Arit.setChildren(AritJnkiChildren);
        Jnki.setChildren(AritJnkiChildren);

        List<Person> DrithaJayaChildren = new ArrayList<>();
        DrithaJayaChildren.add(Yodhan);
        Dritha.setChildren(DrithaJayaChildren);
        Jaya.setChildren(DrithaJayaChildren);

        //setting parents for children
        Parents parents = new Parents();
        parents.setFather(king);
        parents.setMother(queen);
        Satya.setParents(parents);
        Aras.setParents(parents);
        Vich.setParents(parents);
        Ish.setParents(parents);
        Chit.setParents(parents);

        parents = new Parents();
        parents.setFather(Jaya);
        parents.setMother(Dritha);
        Yodhan.setParents(parents);

        parents = new Parents();
        parents.setFather(Arit);
        parents.setMother(Jnki);
        Laki.setParents(parents);
        Lavnya.setParents(parents);

        parents = new Parents();
        parents.setFather(Asva);
        parents.setMother(Satvy);
        Vasa.setParents(parents);

        parents = new Parents();
        parents.setFather(Vyas);
        parents.setMother(Krpi);
        Kriya.setParents(parents);
        Krithi.setParents(parents);

        parents = new Parents();
        parents.setFather(Vyan);
        parents.setMother(Satya);
        Asva.setParents(parents);
        Vyas.setParents(parents);
        Atya.setParents(parents);

        parents = new Parents();
        parents.setFather(Aras);
        parents.setMother(Chitra);
        Jnki.setParents(parents);
        Ahit.setParents(parents);

        parents = new Parents();
        parents.setFather(Vich);
        parents.setMother(Lika);
        Vila.setParents(parents);
        Chika.setParents(parents);

        parents = new Parents();
        parents.setFather(Chit);
        parents.setMother(Amba);
        Dritha.setParents(parents);
        Tritha.setParents(parents);
        Vritha.setParents(parents);
    }
    public Person getKing(){
        return king;
    }
    public Person getQueen(){
        return queen;
    }
}
