package rianaLibraries.person.employee;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Privilleges extends Account{
    private  SimpleIntegerProperty codeStatutLogin=new SimpleIntegerProperty();
    public SimpleIntegerProperty codeStatutLoginProperty(){return this.codeStatutLogin;}
    public Integer getCodeStatutLogin(){return codeStatutLoginProperty().get();}
    public void setCodeStatutLogin(Integer codeStatutLogin){codeStatutLoginProperty().set(codeStatutLogin);}

    private  SimpleBooleanProperty isDepositaire=new SimpleBooleanProperty();
    public SimpleBooleanProperty isDepositaireProperty(){return this.isDepositaire;}
    public Boolean getIsDepositaire(){return isDepositaireProperty().get();}
    public void setIsDepositaire(boolean isDepositaire){isDepositaireProperty().set(isDepositaire);}

    private  SimpleBooleanProperty isDirecteur=new SimpleBooleanProperty();
    public SimpleBooleanProperty isDirecteurProperty(){return this.isDirecteur;}
    public Boolean getIsDirecteur(){return isDirecteurProperty().get();}
    public void setIsDirecteur(boolean isDirecteur){isDirecteurProperty().set(isDirecteur);}

    private  SimpleBooleanProperty isEconome=new SimpleBooleanProperty();
    public SimpleBooleanProperty isEconomeProperty(){return this.isEconome;}
    public Boolean getIsEconome(){return isEconomeProperty().get();}
    public void setIsEconome(boolean isEconome){isEconomeProperty().set(isEconome);}


    private  SimpleBooleanProperty isEnseignant=new SimpleBooleanProperty();
    public SimpleBooleanProperty isEnseignantProperty(){return this.isEnseignant;}
    public Boolean getIsEnseignant(){return isEnseignantProperty().get();}
    public void setIsEnseignant(boolean isEnseignant){isEnseignantProperty().set(isEnseignant);}

    private  SimpleBooleanProperty isSecretaire=new SimpleBooleanProperty();
    public SimpleBooleanProperty isSecretaireProperty(){return this.isSecretaire;}
    public Boolean getIsSecretaire(){return isSecretaireProperty().get();}
    public void setIsSecretaire(boolean isSecretaire){isSecretaireProperty().set(isSecretaire);}

    private  SimpleBooleanProperty isSurveillant=new SimpleBooleanProperty();
    public SimpleBooleanProperty isSurveillantProperty(){return this.isSurveillant;}
    public Boolean getIsSurveillant(){return isSurveillantProperty().get();}
    public void setIsSurveillant(boolean isSurveillant){isSurveillantProperty().set(isSurveillant);}

    public Privilleges(Integer codePers,String nom,String prenoms,String nomUtilisateur,Integer codeStatutLogin,Boolean isDepositaire, Boolean isDirecteur,Boolean isEconome,Boolean isEnseignant, Boolean isSecretaire, Boolean isSurveillant){
        super(codePers,nom,prenoms,nomUtilisateur);
        setCodeStatutLogin(codeStatutLogin);
        setIsDepositaire(isDepositaire);
        setIsDirecteur(isDirecteur);
        setIsEconome(isEconome);
        setIsSecretaire(isSecretaire);
        setIsEnseignant(isEnseignant);
        setIsSurveillant(isSurveillant);
    }
}
