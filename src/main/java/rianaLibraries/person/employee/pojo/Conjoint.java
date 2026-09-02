package rianaLibraries.person.employee.pojo;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class Conjoint extends Personnel {
     private static SimpleIntegerProperty codeConjoint=new SimpleIntegerProperty();
    private static SimpleStringProperty lieuServiceConjoint=new SimpleStringProperty();

    public SimpleIntegerProperty codeConjointProperty(){return this.codeConjoint;}
    public Integer getCodeConjoint(){return codeConjointProperty().get();}
    public void setCodeConjoint(Integer codeConjoint){codeConjointProperty().set(codeConjoint);}

    public SimpleStringProperty lieuServiceConjointProperty(){return this.lieuServiceConjoint;}
    public String getLieuServiceConjoint(){return lieuServiceConjointProperty().get();}
    public void setLieuServiceConjoint(String lieuServiceConjoint){lieuServiceConjointProperty().set(lieuServiceConjoint);}

    public Conjoint(){}

    public Conjoint(Integer codeConjoint, Integer codePers,String nom,String prenom,Integer sexe, LocalDate idDate,String idPlace,Integer im, Integer codeFonction,String lieuService,String remarques){}
    
}
