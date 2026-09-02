package rianaLibraries.person.employee;


import javafx.beans.property.SimpleStringProperty;

public class Account extends Personnel{



    private  SimpleStringProperty nomUtilisateur=new SimpleStringProperty();



    public SimpleStringProperty nomUtilisateurProperty(){return this.nomUtilisateur;}
    public String getNomUtilisateur(){return nomUtilisateurProperty().get();}
    public void setNomUtilisateur(String nomUtilisateur){nomUtilisateurProperty().set(nomUtilisateur);}



    public Account(){};

    public Account(Integer codePers){
        super(codePers);
    }
    public Account(Integer codePers, String nomUtilisateur){
        super(codePers);
        setNomUtilisateur(nomUtilisateur);
    }


    public Account( Integer codePers,String nom,String prenoms,String nomUtilisateur){
        super(codePers,nom,prenoms);
        setNomUtilisateur(nomUtilisateur);
    }

    public Account(Integer codePers,String nom,String prenoms,Integer sexe,String phoneNumber,String nomUtilisateur){
        super(codePers,nom,prenoms,sexe,phoneNumber);
        setNomUtilisateur(nomUtilisateur);
    }

    public Account(Integer codePers,String nom,String prenoms,Integer sexe,String phoneNumber,String email,String numCin,String fullName,String shortGender,String nomUtilisateur){
        super(codePers,nom,prenoms,sexe,phoneNumber,email,numCin,fullName,shortGender);
        setNomUtilisateur(nomUtilisateur);
    }

    public Account(Integer codePers, String nom, String prenoms, Integer sexe, String phoneNumber, String nomUtilisateur, String fullName, String shortGender) {
        super(codePers,nom,prenoms,sexe,phoneNumber,fullName,shortGender);
        setNomUtilisateur(nomUtilisateur);
    }







}
