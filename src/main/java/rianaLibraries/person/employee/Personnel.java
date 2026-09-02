package rianaLibraries.person.employee;

import rianaLibraries.person.base.Person;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class Personnel extends Person {

    public Personnel(){}

    public Personnel(Integer codePers){
        setCodePers(codePers);
    }

    public Personnel(Integer codePers,String id,String mail,String phoneNumber){
        super(id,mail,phoneNumber);
        setCodePers(codePers);

    }

    public Personnel (Integer codePers,String nomPers,String prenomPers){
        super(nomPers,prenomPers);
        setCodePers(codePers);
    }

    public Personnel (Integer codePers,String nomPers,String prenomPers,Integer gender,String phoneNumber){
        super(nomPers,prenomPers,gender,phoneNumber);
        setCodePers(codePers);
    }

    public Personnel (String nomPers,String prenomPers){
        super(nomPers,prenomPers);
    }

    public Personnel(Integer codePers, String lastName, String firstName, String id, LocalDate idDate, String idPlace, Integer gender, String email, String phoneNumber){
        super(lastName,firstName,id,idDate,idPlace,gender,email,phoneNumber);
        setCodePers(codePers);
    }

    public Personnel(Integer codePers, String lastName, String firstName, LocalDate dateOfBirth, String placeOfBirth, Integer gender, String address, String phoneNumber, String photo, String id, LocalDate idDate, String idPlace, LocalDate idDateRecovery, String idPlaceRecovery, Integer spouse, Integer children, Integer familyStatus, String aeEx, boolean persEtat, Integer im, LocalDate dateEntreeAdmin, Integer codeSq1, Integer codeSq2, Integer codeSq3, String secAns1, String secAns2, String secAns3){
        super(lastName,firstName,dateOfBirth,placeOfBirth,gender,address,phoneNumber,photo,id,idDate,idPlace,idDateRecovery,idPlaceRecovery,children,familyStatus);
        setCodePers(codePers);
        setAeEx(aeEx);
        setDateEntreeAdmin(dateEntreeAdmin);
        setIm(im);
        setPersEtat(persEtat);
    }

    public Personnel(
          Integer january,
          Integer february,
          Integer march,
          Integer april,
          Integer may,
          Integer june,
          Integer july,
          Integer august,
          Integer september,
          Integer october,
          Integer november,
          Integer december,
          Integer hours,
          Integer howMuch){
        setJanuary(january);
        setFebruary(february);
        setMarch(march);
        setApril(april);
        setMay(may);
        setJune(june);
        setJuly(july);
        setAugust(august);
        setSeptember(september);
        setOctober(october);
        setNovember(november);
        setDecember(december);
        setHours(hours);
        setHowMuch(howMuch);
    }

    public Personnel(
            Integer january,
            Integer february,
            Integer march,
            Integer april,
            Integer may,
            Integer june,
            Integer july,
            Integer august,
            Integer september,
            Integer october,
            Integer november,
            Integer december,
            Integer hours){
        setJanuary(january);
        setFebruary(february);
        setMarch(march);
        setApril(april);
        setMay(may);
        setJune(june);
        setJuly(july);
        setAugust(august);
        setSeptember(september);
        setOctober(october);
        setNovember(november);
        setDecember(december);
        setHours(hours);
    }

    private  SimpleIntegerProperty codePers=new SimpleIntegerProperty();
    private  SimpleStringProperty aeEx=new SimpleStringProperty();
    private  SimpleObjectProperty<LocalDate> dateEntreeAdmin=new SimpleObjectProperty<>();
    private  SimpleObjectProperty<Integer> im=new SimpleObjectProperty<>();
    private  SimpleBooleanProperty persEtat=new SimpleBooleanProperty();
    //amda


    //months
    private  SimpleIntegerProperty january=new SimpleIntegerProperty();
    private  SimpleIntegerProperty february=new SimpleIntegerProperty();
    private  SimpleIntegerProperty march=new SimpleIntegerProperty();
    private  SimpleIntegerProperty april=new SimpleIntegerProperty();
    private  SimpleIntegerProperty may=new SimpleIntegerProperty();
    private  SimpleIntegerProperty june=new SimpleIntegerProperty();
    private  SimpleIntegerProperty july=new SimpleIntegerProperty();
    private  SimpleIntegerProperty august=new SimpleIntegerProperty();
    private  SimpleIntegerProperty september=new SimpleIntegerProperty();
    private  SimpleIntegerProperty october=new SimpleIntegerProperty();
    private  SimpleIntegerProperty november=new SimpleIntegerProperty();
    private  SimpleIntegerProperty december=new SimpleIntegerProperty();

    private  SimpleIntegerProperty hours=new SimpleIntegerProperty();
    private  SimpleIntegerProperty howMuch=new SimpleIntegerProperty();



    public Personnel(Integer codePers, String nom, String prenoms, Integer sexe, String phoneNumber, String fullName, String shortGender) {
        super(nom,prenoms,sexe,phoneNumber,fullName,shortGender);
        setCodePers(codePers);
    }


    public Personnel(Integer codePers, String nom, String prenoms, Integer sexe, String phoneNumber, String email,String numCin, String fullName, String shortGender) {
        super(nom,prenoms,sexe,phoneNumber,email,numCin,fullName,shortGender);
        setCodePers(codePers);
    }


    public SimpleIntegerProperty codePersProperty(){return this.codePers;}
    public Integer getCodePers(){return codePersProperty().get();}
    public void setCodePers(Integer codePers){codePersProperty().set(codePers);}

    public SimpleStringProperty aeExProperty(){return this.aeEx;}
    public String getAeEx(){return aeExProperty().get();}
    public void setAeEx(String aeEx){aeExProperty().set(aeEx);}

    public SimpleObjectProperty<LocalDate> dateEntreeAdminProperty(){return this.dateEntreeAdmin;}
    public LocalDate getDateEntreeAdmin(){return dateEntreeAdminProperty().get();}
    public void setDateEntreeAdmin(LocalDate dateEntreeAdmin){dateEntreeAdminProperty().set(dateEntreeAdmin);}

    public SimpleObjectProperty<Integer> imProperty(){return this.im;}
    public Integer getIm(){return imProperty().get();}
    public void setIm(Integer im){imProperty().set(im);}

    public SimpleBooleanProperty persEtatProperty(){return this.persEtat;}
    public Boolean getPersEtat(){return persEtatProperty().get();}
    public void setPersEtat(Boolean persEtat){persEtatProperty().set(persEtat);}


    //months

    public SimpleIntegerProperty januaryProperty(){return this.january;}
    public Integer getJanuary(){return januaryProperty().get();}
    public void setJanuary(Integer january){januaryProperty().set(january);}

    public SimpleIntegerProperty februaryProperty(){return this.february;}
    public Integer getFebruary(){return februaryProperty().get();}
    public void setFebruary(Integer february){februaryProperty().set(february);}

    public SimpleIntegerProperty marchProperty(){return this.march;}
    public Integer getMarch(){return marchProperty().get();}
    public void setMarch(Integer march){marchProperty().set(march);}

    public SimpleIntegerProperty aprilProperty(){return this.april;}
    public Integer getApril(){return aprilProperty().get();}
    public void setApril(Integer april){aprilProperty().set(april);}

    public SimpleIntegerProperty mayProperty(){return this.may;}
    public Integer getMay(){return mayProperty().get();}
    public void setMay(Integer may){mayProperty().set(may);}

    public SimpleIntegerProperty juneProperty(){return this.june;}
    public Integer getJune(){return juneProperty().get();}
    public void setJune(Integer june){juneProperty().set(june);}

    public SimpleIntegerProperty julyProperty(){return this.july;}
    public Integer getJuly(){return julyProperty().get();}
    public void setJuly(Integer july){julyProperty().set(july);}

    public SimpleIntegerProperty augustProperty(){return this.august;}
    public Integer getAugust(){return augustProperty().get();}
    public void setAugust(Integer august){augustProperty().set(august);}

    public SimpleIntegerProperty septemberProperty(){return this.september;}
    public Integer getSeptember(){return septemberProperty().get();}
    public void setSeptember(Integer september){septemberProperty().set(september);}

    public SimpleIntegerProperty octoberProperty(){return this.october;}
    public Integer getOctober(){return octoberProperty().get();}
    public void setOctober(Integer october){octoberProperty().set(october);}

    public SimpleIntegerProperty novemberProperty(){return this.november;}
    public Integer getNovember(){return novemberProperty().get();}
    public void setNovember(Integer november){novemberProperty().set(november);}

    public SimpleIntegerProperty decemberProperty(){return this.december;}
    public Integer getDecember(){return decemberProperty().get();}
    public void setDecember(Integer december){decemberProperty().set(december);}

//$$
    public SimpleIntegerProperty hoursProperty(){return this.hours;}
    public Integer getHours(){return hoursProperty().get();}
    public void setHours(Integer hours){hoursProperty().set(hours);}

    public SimpleIntegerProperty howMuchProperty(){return this.howMuch;}
    public Integer getHowMuch(){return howMuchProperty().get();}
    public void setHowMuch(Integer howMuch){howMuchProperty().set(howMuch);}


}
