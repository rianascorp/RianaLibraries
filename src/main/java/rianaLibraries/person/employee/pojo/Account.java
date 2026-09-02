package rianaLibraries.person.employee.pojo;



public class Account extends rianaLibraries.person.employee.pojo.Personnel {


    private String nomUtilisateur;

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }





    public Account(){};



    public Account(Long codePers, String nomUtilisateur){
        super(codePers);
        setNomUtilisateur(nomUtilisateur);
    }


    public Account( Long codePers,String nom,String prenoms,String nomUtilisateur){
        super(codePers,nom,prenoms);
        setNomUtilisateur(nomUtilisateur);
    }

    public Account(Long codePers,String nom,String prenoms,Integer sexe,String phoneNumber,String nomUtilisateur){
        super(codePers,nom,prenoms,sexe,phoneNumber);
        setNomUtilisateur(nomUtilisateur);
    }

    public Account(Long codePers,String nom,String prenoms,Integer sexe,String phoneNumber,String email,Integer numCin,String fullName,String shortGender,String nomUtilisateur){
        super(codePers,nom,prenoms,sexe,phoneNumber,email,numCin,fullName,shortGender);
        setNomUtilisateur(nomUtilisateur);
    }

    public Account(Long codePers, String nom, String prenoms, Integer sexe, String phoneNumber, String nomUtilisateur, String fullName, String shortGender) {
        super(codePers,nom,prenoms,sexe,phoneNumber,fullName,shortGender);
        setNomUtilisateur(nomUtilisateur);
    }







}
