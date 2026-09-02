package rianaLibraries.person.base;

import javafx.beans.property.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Person {

    private SimpleStringProperty firstName=new SimpleStringProperty();
    private SimpleStringProperty lastName=new SimpleStringProperty();
    private SimpleStringProperty name=new SimpleStringProperty();
    private SimpleStringProperty fullName=new SimpleStringProperty();
    private SimpleStringProperty shortGender=new SimpleStringProperty();
    private SimpleObjectProperty<LocalDate> dateOfBirth=new SimpleObjectProperty<>();
    private SimpleStringProperty placeOfBirth=new SimpleStringProperty();
    private SimpleIntegerProperty gender=new SimpleIntegerProperty();
    private SimpleObjectProperty<Float> height=new SimpleObjectProperty<>();
    private SimpleObjectProperty<Float> weight=new SimpleObjectProperty<>();
    private SimpleIntegerProperty ethnicity=new SimpleIntegerProperty();
    private SimpleStringProperty photo=new SimpleStringProperty();
    private SimpleObjectProperty<Integer> parents=new SimpleObjectProperty<>();
    private SimpleIntegerProperty siblings=new SimpleIntegerProperty();
    private SimpleStringProperty address=new SimpleStringProperty();
    private SimpleStringProperty phoneNumber=new SimpleStringProperty();
    private SimpleStringProperty email=new SimpleStringProperty();
    private SimpleIntegerProperty lifeStatus=new SimpleIntegerProperty();
    private SimpleIntegerProperty handicap=new SimpleIntegerProperty();
    private SimpleStringProperty id=new SimpleStringProperty();
    private SimpleStringProperty idPlace=new SimpleStringProperty();
    private SimpleObjectProperty<LocalDate> idDate=new SimpleObjectProperty<>();
    private SimpleObjectProperty<LocalDate> idDateRecovery=new SimpleObjectProperty<>();
    private SimpleStringProperty idPlaceRecovery=new SimpleStringProperty();
    private SimpleIntegerProperty children=new SimpleIntegerProperty();
    //private SimpleObjectProperty<Integer> spouse=new SimpleObjectProperty<Integer>();
    private SimpleIntegerProperty familyStatus=new SimpleIntegerProperty();
    private SimpleStringProperty descriptions=new SimpleStringProperty();
    private SimpleLongProperty age=new SimpleLongProperty();
    private SimpleStringProperty appellation=new SimpleStringProperty();

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

    public Person(String id, String mail,String numTel) {
        setId(id);
        setEmail(mail);
        setPhoneNumber(numTel);
    }

    public Person(String lastName,String firstName){
        setLastName(lastName);
        setFirstName(firstName);
    }

    public Person(String lastName, String firstName, String id, LocalDate idDate, String idPlace, Integer gender, String email, String phoneNumber) {
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
        setName(appellation);
    }



    public Person(String lastName, String firstName, LocalDate dateOfBirth, String placeOfBirth, Integer gender, String address, String phoneNumber, String photo, String id, LocalDate idDate, String idPlace, LocalDate idDateRecovery, String idPlaceRecovery, Integer children, Integer familyStatus){
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


    public Person(String nom, String prenoms, Integer sexe, String phoneNumber, String email,String numCin, String fullName, String shortGender) {
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




    public final SimpleStringProperty firstNameProperty(){return this.firstName;}
    public final String getFirstName(){return this.firstNameProperty().get();}
    public void setFirstName(String firstName) {this.firstNameProperty().set(wordUpperFirst(firstName));}

    public final SimpleStringProperty lastNameProperty(){return this.lastName;}
    public final String getLastName(){return this.lastNameProperty().get();}
    public void setLastName(String lastName) {this.lastNameProperty().set(wordUpperFirst(lastName).toUpperCase());}

    public  SimpleStringProperty fullNameProperty(){return this.fullName;}
    public  String getFullNameAuto(){return this.fullName();}
    public String getFullName(){return  fullNameProperty().getName();}
    public void setFullName(String fullName) {this.fullNameProperty().set(fullNameUpper(fullName));}

    public final SimpleStringProperty nameProperty(){return this.name;}
    public final String getName(){return this.nameProperty().get();}
    public void setName(String name) {this.nameProperty().set(wordUpperFirst(name));}

    public final SimpleStringProperty appellationProperty(){return this.appellation;}
    public final String getAppellation(){return this.appellationProperty().get();}
    public void setAppellation (String appellation) {this.appellationProperty().set(appellation);}


    public SimpleLongProperty ageProperty(){return this.age;}
    public Long getAge(){return this.getTheAge(dateOfBirth.get());}
    public void setAge(){this.ageProperty().set(getTheAge(dateOfBirth.get()));}

    public final SimpleObjectProperty<LocalDate> dateOfBirthProperty(){return this.dateOfBirth;}
    public final LocalDate getDateOfBirth(){return this.dateOfBirthProperty().get();}
    public void setDateOfBirth(LocalDate dateOfBirth) {this.dateOfBirthProperty().set(dateOfBirth);}

    public final SimpleStringProperty placeOfBirthProperty(){return this.placeOfBirth;}
    public final String getPlaceOfBirth(){return this.placeOfBirthProperty().get();}
    public void setPlaceOfBirth(String placeOfBirth) {this.placeOfBirthProperty().set(placeOfBirth);}

    public final SimpleIntegerProperty genderProperty(){return this.gender;}
    public final Integer getGender(){return this.genderProperty().get();}
    public void setGender(Integer gender){this.genderProperty().set(gender);}

    public final SimpleStringProperty shortGenderProperty(){return this.shortGender;}
    public final String getShortGender(){return this.shortCivility();}
    public void setShortGender(String shortGender){shortGenderProperty().set(shortGender);}

    public final SimpleObjectProperty<Float> heightProperty(){return this.height;}
    public final Float getHeight(){return this.heightProperty().get();}
    public void setHeight(Float height){this.heightProperty().set(height);}

    public final SimpleObjectProperty<Float> weightProperty(){return this.weight;}
    public final Float getWeight(){return this.weightProperty().get();}
    public void setWeight(Float weight){this.weightProperty().set(weight);}

    public final SimpleIntegerProperty ethnicityProperty(){return this.ethnicity;}
    public final Integer getEthnicity(){return this.ethnicityProperty().get();}
    public void setEthnicity(Integer ethnicity){this.ethnicityProperty().set(ethnicity);}

    public final SimpleStringProperty photoProperty(){return this.photo;}
    public final String getPhoto(){return this.photoProperty().get();}
    public void setPhoto(String photo) {this.photoProperty().set(photo);}

    public final SimpleObjectProperty<Integer> parentsProperty(){return this.parents;}
    public final Integer getParents(){return this.parentsProperty().get();}
    public void setParents(Integer parents){this.parentsProperty().set(parents);}

    public final SimpleIntegerProperty siblingsProperty(){return this.siblings;}
    public final Integer getSiblings(){return this.siblingsProperty().get();}
    public void setSiblings(Integer siblings){this.siblingsProperty().set(siblings);}

    public final SimpleStringProperty addressProperty(){return this.address;}
    public final String getAddress(){return this.addressProperty().get();}
    public void setAddress(String address) {this.addressProperty().set(address);}

    public final SimpleStringProperty phoneNumberProperty(){return this.phoneNumber;}
    public final String getPhoneNumber(){return this.phoneNumberProperty().get();}
    public void setPhoneNumber(String phoneNumber) {this.phoneNumberProperty().set(phoneNumber);}

    public final SimpleStringProperty emailProperty(){return this.email;}
    public final String getEmail(){return this.emailProperty().get();}
    public void setEmail(String email) {this.emailProperty().set(email);}

    public final SimpleIntegerProperty lifeStatusProperty(){return this.lifeStatus;}
    public final Integer getLifeStatus(){return this.lifeStatusProperty().get();}
    public void setLifeStatus(Integer lifeStatus){this.lifeStatusProperty().set(lifeStatus);}

    public final SimpleIntegerProperty handicapProperty(){return this.handicap;}
    public final Integer getHandicap(){return this.handicapProperty().get();}
    public void setHandicap(Integer handicap){this.handicapProperty().set(handicap);}

    public final SimpleStringProperty idProperty(){return this.id;}
    public final String getId(){return this.idProperty().get();}
    public void setId(String id){this.idProperty().set(id);}

    public final SimpleStringProperty idPlaceProperty(){return this.idPlace;}
    public final String getIdPlace(){return this.idPlaceProperty().get();}
    public void setIdPlace(String idPlace){this.idPlaceProperty().set(idPlace);}

    public final SimpleObjectProperty<LocalDate> idDateProperty(){return this.idDate;}
    public final LocalDate getIdDate(){return this.idDateProperty().get();}
    public void setIdDate(LocalDate idDate) {this.idDateProperty().set(idDate);}

    public final SimpleObjectProperty<LocalDate> idDateRecoveryProperty(){return this.idDateRecovery;}
    public final LocalDate getIdDateRecovery(){return this.idDateRecoveryProperty().get();}
    public void setIdDateRecovery(LocalDate idDateRecovery) {this.idDateRecoveryProperty().set(idDateRecovery);}

    public final SimpleStringProperty idPlaceRecoveryProperty(){return this.idPlaceRecovery;}
    public final String getIdPlaceRecovery(){return this.idPlaceRecoveryProperty().get();}
    public void setIdPlaceRecovery(String idPlaceRecovery){this.idPlaceRecoveryProperty().set(idPlaceRecovery);}

    /*public final SimpleObjectProperty<Integer> spouseProperty(){return this.spouse;}
    public final Integer getSpouse(){return this.spouseProperty().get();}
    public void setSpouse(Integer spouse){this.spouseProperty().set(spouse);}*/

    public final SimpleIntegerProperty childrenProperty(){return this.children;}
    public final Integer getChildren(){return this.childrenProperty().get();}
    public void setChildren(Integer children){this.childrenProperty().set(children);}

    public final SimpleIntegerProperty familyStatusProperty(){return this.familyStatus;}
    public final Integer getFamilyStatus(){return this.familyStatusProperty().get();}
    public void setFamilyStatus(Integer familyStatus){this.familyStatusProperty().set(familyStatus);}

    public final SimpleStringProperty descriptionsProperty(){return this.descriptions;}
    public final String getDescriptions(){return this.descriptionsProperty().get();}
    public void setDescriptions(String descriptions){this.descriptionsProperty().set(descriptions);}



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

}
