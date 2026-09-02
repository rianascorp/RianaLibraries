package rianaLibraries.person.student;

import rianaLibraries.person.base.Person;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class student extends Person {

    SimpleIntegerProperty matricule=new SimpleIntegerProperty();
    SimpleStringProperty admission=new SimpleStringProperty();
    SimpleIntegerProperty orientation=new SimpleIntegerProperty();
    SimpleIntegerProperty quartier=new SimpleIntegerProperty();
    SimpleIntegerProperty statut=new SimpleIntegerProperty();
    SimpleIntegerProperty tuteur=new SimpleIntegerProperty();
    SimpleStringProperty remarques=new SimpleStringProperty();

    public final SimpleIntegerProperty matriculeProperty(){return this.matricule;}
    public final Integer getMatricule(){return this.matriculeProperty().get();}
    public void setMatricule(Integer matricule){this.matriculeProperty().set(matricule);}

    public final SimpleStringProperty admissionProperty(){return this.admission;}
    public final String getAdmission(){return this.admissionProperty().get();}
    public void setAdmission(String admission){this.admissionProperty().set(admission);}

    
    public final SimpleIntegerProperty orientationProperty(){return this.orientation;}
    public final Integer getOrientation(){return this.orientationProperty().get();}
    public void setOrientation(Integer orientation){this.orientationProperty().set(orientation);}

    public final SimpleIntegerProperty quartierProperty(){return this.quartier;}
    public final Integer getQuartier(){return this.quartierProperty().get();}
    public void setQuartier(Integer quartier){this.quartierProperty().set(quartier);}

    public final SimpleIntegerProperty statutProperty(){return this.statut;}
    public final Integer getStatut(){return this.statutProperty().get();}
    public void setStatut(Integer statut){this.statutProperty().set(statut);}

    public final SimpleIntegerProperty tuteurProperty(){return this.tuteur;}
    public final Integer getTuteur(){return this.tuteurProperty().get();}
    public void setTuteur(Integer tuteur){this.tuteurProperty().set(tuteur);}

    public final SimpleStringProperty remarquesProperty(){return this.remarques;}
    public final String getRemarques(){return this.remarquesProperty().get();}
    public void setRemarques(String remarques){this.remarquesProperty().set(remarques);}

    public student(){
    }

    public student (String nom, String prenom, LocalDate dateNaiss,String lieuNaiss,Integer sexe,Integer handicap,Integer parents,String addresse,String telephone,String photo,Integer matricule,String admission,Integer orientation,Integer quartier,Integer statut,Integer tuteur,String remarques){
        super(nom,prenom,dateNaiss,lieuNaiss,sexe,handicap,parents,addresse,telephone,photo);
        setMatricule(matricule);
        setAdmission(admission);
        setOrientation(orientation);
        setQuartier(quartier);
        setStatut(statut);
        setTuteur(tuteur);
        setRemarques(remarques);
    }

}
