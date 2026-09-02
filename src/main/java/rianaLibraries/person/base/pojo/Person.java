package rianaLibraries.person.base.pojo;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Person {

private String firstName;
private String lastName;
private String name;
private String fullName;
private String shortGender;
private LocalDate dateOfBirth;
private String placeOfBirth;
private Integer gender;
private Float height;
private Float weight;
private Integer ethnicity;
private String photo;
private Integer parents;
private Integer siblings;
private String address;
private String phoneNumber;
private String email;
private Integer lifeStatus;
private Integer handicap;
private Integer id;
private String idPlace;
private LocalDate idDate;
private LocalDate idDateRecovery;
private String idPlaceRecovery;
private Integer children;
//private SimpleObjectProperty<Integer> spouse=new SimpleObjectProperty<Integer>();
private Integer familyStatus;
private String descriptions;
private Long age;
private String appellation;

    public Person(String nomPers, String prenomPers, Integer gender, String phoneNumber) {
        setLastName(nomPers);
        setFirstName(prenomPers);
        setGender(gender);
        setPhoneNumber(phoneNumber);
    }
    public Person(){
    }

    public Person(String fullName){
        setFullName(fullName);
    }

    public Person(String adresse,String telephone,String mail,String descriptions){
        setAddress(adresse);
        setPhoneNumber(telephone);
        setEmail(mail);
        setDescriptions(descriptions);
    }

    public Person(Integer id, String mail,String numTel) {
        setId(id);
        setEmail(mail);
        setPhoneNumber(numTel);
    }

    public Person(String lastName,String firstName){
        setLastName(lastName);
        setFirstName(firstName);
    }

    public Person(String lastName, String firstName, Integer id, LocalDate idDate, String idPlace, Integer gender, String email, String phoneNumber) {
        setLastName(lastName);
        setFirstName(firstName);
        setId(id);
        setIdDate(idDate);
        setIdPlace(idPlace);
        setGender(gender);
        setEmail(email);
        setPhoneNumber(phoneNumber);
    }

    public Person(String lastName, String firstName, LocalDate dateOfBirth, String placeOfBirth, Integer gender, Integer handicap, Integer parents, String address, String phoneNumber, String photo){
        setLastName(lastName);
        setFirstName(firstName);
        setDateOfBirth(dateOfBirth);
        setPlaceOfBirth(placeOfBirth);
        setGender(gender);
        setHandicap(handicap);
        setParents(parents);
        setAddress(address);
        setPhoneNumber(phoneNumber);
        setPhoto(photo);
    }

    public Person(String lastName, String firstName,String appellation, LocalDate dateOfBirth, String placeOfBirth, Integer gender, Integer handicap, Integer parents, String address, String phoneNumber, String photo,String descriptions){
        setLastName(lastName);
        setFirstName(firstName);
        setDateOfBirth(dateOfBirth);
        setPlaceOfBirth(placeOfBirth);
        setGender(gender);
        setHandicap(handicap);
        setParents(parents);
        setAddress(address);
        setPhoneNumber(phoneNumber);
        setPhoto(photo);
        setDescriptions(descriptions);
        setAppellation(appellation);
    }



    public Person(String lastName, String firstName, LocalDate dateOfBirth, String placeOfBirth, Integer gender, String address, String phoneNumber, String photo, Integer id, LocalDate idDate, String idPlace, LocalDate idDateRecovery, String idPlaceRecovery, Integer children, Integer familyStatus){
        setLastName(lastName);
        setFirstName(firstName);
        setDateOfBirth(dateOfBirth);
        setPlaceOfBirth(placeOfBirth);
        setGender(gender);
        setAddress(address);
        setPhoneNumber(phoneNumber);
        setPhoto(photo);
        setId(id);
        setIdDate(idDate);
        setIdPlace(idPlace);
        setIdDateRecovery(idDateRecovery);
        setIdPlaceRecovery(idPlaceRecovery);
        //setSpouse(spouse);
        setChildren(children);
        setFamilyStatus(familyStatus);
    }

    public Person(String nom, String prenoms, Integer sexe, String phoneNumber, String fullName, String shortGender) {
        setLastName(nom);
        setFirstName(prenoms);
        setGender(sexe);
        setPhoneNumber(phoneNumber);
        setFullName(fullName);
        setShortGender(shortGender);
    }


    public Person(String nom, String prenoms, Integer sexe, String phoneNumber, String email,Integer numCin, String fullName, String shortGender) {
        setLastName(nom);
        setFirstName(prenoms);
        setGender(sexe);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setFullName(fullName);
        setShortGender(shortGender);
        setId(numCin);
    }

    public Person(String nomPere,String prenomPere,String nomMere,String prenomMere,String adresseParents,String telephoneParents,String mailParents){
        setLastName(nomPere);
        setFirstName(prenomPere);
        setLastName(nomMere);
        setFirstName(prenomMere);
        setAddress(adresseParents);
        setPhoneNumber(telephoneParents);
        setEmail(mailParents);
    }

    public Person(String nomTuteur, String prenomTuteur, String adresseTuteur, String telTuteur, String descriptions) {
        setLastName(nomTuteur);
        setFirstName(prenomTuteur);
        setAddress(adresseTuteur);
        setPhoneNumber(telTuteur);
        setDescriptions(descriptions);
    }






    public String wordUpperFirst(String sentence) {
        String result="";
        char BLANK=' ';
        int index, numberOfCharacters, beginIdx, endIdx,wordCount;
        numberOfCharacters = sentence.length();
        index = 0;

        while (index < numberOfCharacters) {
            //ignore leading blank spaces
            while (index < numberOfCharacters && sentence.charAt(index) == BLANK) {
                index++;
            }
            beginIdx = index;
            //now locate the end of the word
            while (index < numberOfCharacters && sentence.charAt(index) != BLANK) {
                index++;
            }
            endIdx = index;

            while (index < numberOfCharacters && sentence.charAt(index) == BLANK) {
                index++;
            }

            //another word is found, extract it from the
            //sentence and print it out
            String word = sentence.substring(beginIdx, endIdx);
            word=word.toLowerCase();
            char [] name=word.toCharArray();
            char d=word.charAt(0);
            if (d >= 'a' && d <= 'z'){
                d-=32;
            }
            name[0]=d;

            if (endIdx==numberOfCharacters) {
                result= result+String.valueOf(name);
            }
            else {
                if (sentence.charAt(endIdx)==BLANK){
                    int numberOfNonBlanks=0;
                    for (int i = endIdx; i <numberOfCharacters ; i++) {
                        if (sentence.charAt(i)!=BLANK){
                            numberOfNonBlanks++;
                        }
                    }

                    if (numberOfNonBlanks>=1){
                        result=result+String.valueOf(name)+" ";
                    }
                    else{
                        result= result+String.valueOf(name);
                    }
                }
            }
        }
        return result;
    }

    private Integer checkBlank(String word,int endIndex){
        int nob=0;
        for (int i =0; i <endIndex ; i++)
        {
            if (word.charAt(i)==' '){
                nob++;
            }
        }
        return nob;
    }

    public String fullNameUpper(String sentence) {
        String result="";
        char BLANK=' ';
        int index, numberOfCharacters, beginIdx, endIdx,wordCount;
        numberOfCharacters = sentence.length();
        index = 0;

        while (index < numberOfCharacters) {
            //ignore leading blank spaces
            while (index < numberOfCharacters && sentence.charAt(index) == BLANK) {
                index++;
            }
            beginIdx = index;
            //now locate the end of the word
            while (index < numberOfCharacters && sentence.charAt(index) != BLANK) {
                index++;
            }
            endIdx = index;

            while (index < numberOfCharacters && sentence.charAt(index) == BLANK) {
                index++;
            }

            //another word is found, extract it from the
            //sentence and print it out
            String word = sentence.substring(beginIdx, endIdx);
            word=word.toLowerCase();

            char [] name=word.toCharArray();
            char d=word.charAt(0);
            if (d >= 'a' && d <= 'z'){
                d-=32;
            }
            name[0]=d;

            if (endIdx==numberOfCharacters) {
                if(checkBlank(sentence,numberOfCharacters-1)<1){
                    //result=(checkBlank(sentence,numberOfCharacters-1)).toString();
                    result=word.toUpperCase();
                }
                else{
                    result= result+String.valueOf(name);}
            }
            else {
                if (sentence.charAt(endIdx)==BLANK){
                    //Check for the number of blanks
                    int numberOfBlanks=checkBlank(sentence,endIdx);

                    int numberOfNonBlanks=0;
                    for (int i = endIdx; i <numberOfCharacters ; i++) {
                        if (sentence.charAt(i)!=BLANK){
                            numberOfNonBlanks++;
                        }
                    }

                    if (numberOfBlanks<1){
                        result=(result+String.valueOf(name)).toUpperCase()+" ";
                    }
                    else{
                        if (numberOfNonBlanks>1){
                            result=result+String.valueOf(name)+" ";
                        }
                        else{
                            result= result+String.valueOf(name);
                        }
                    }
                }

            }
        }

        return result;
    }



    public String fullName(){
        return (getLastName()+" "+getFirstName());
    }

    public String shortCivility(){
        String civility;
        if (getGender()==1){
            civility="Mr";
        }
        else {civility="Mme";}
        return civility;
    }
    public String fullCivilName(){
        return shortCivility()+" "+fullName();
    }

    public Long getTheAge(LocalDate dob){
        LocalDate now=LocalDate.now();
        long years= ChronoUnit.YEARS.between(dob,now);
        return years;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortGender() {
        return shortGender;
    }

    public void setShortGender(String shortGender) {
        this.shortGender = shortGender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Integer getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(Integer ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getParents() {
        return parents;
    }

    public void setParents(Integer parents) {
        this.parents = parents;
    }

    public Integer getSiblings() {
        return siblings;
    }

    public void setSiblings(Integer siblings) {
        this.siblings = siblings;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getLifeStatus() {
        return lifeStatus;
    }

    public void setLifeStatus(Integer lifeStatus) {
        this.lifeStatus = lifeStatus;
    }

    public Integer getHandicap() {
        return handicap;
    }

    public void setHandicap(Integer handicap) {
        this.handicap = handicap;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdPlace() {
        return idPlace;
    }

    public void setIdPlace(String idPlace) {
        this.idPlace = idPlace;
    }

    public LocalDate getIdDate() {
        return idDate;
    }

    public void setIdDate(LocalDate idDate) {
        this.idDate = idDate;
    }

    public LocalDate getIdDateRecovery() {
        return idDateRecovery;
    }

    public void setIdDateRecovery(LocalDate idDateRecovery) {
        this.idDateRecovery = idDateRecovery;
    }

    public String getIdPlaceRecovery() {
        return idPlaceRecovery;
    }

    public void setIdPlaceRecovery(String idPlaceRecovery) {
        this.idPlaceRecovery = idPlaceRecovery;
    }

    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }

    public Integer getFamilyStatus() {
        return familyStatus;
    }

    public void setFamilyStatus(Integer familyStatus) {
        this.familyStatus = familyStatus;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getAppellation() {
        return appellation;
    }

    public void setAppellation(String appellation) {
        this.appellation = appellation;
    }
}
