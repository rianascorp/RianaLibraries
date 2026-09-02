package rianaLibraries.person.base;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Sex {

    private SimpleIntegerProperty codeSexe=new SimpleIntegerProperty();
    public final SimpleIntegerProperty codeSexeProperty(){return this.codeSexe;}
    public final Integer getCodeSexe(){return codeSexeProperty().get();}
    public void setCodeSexe(Integer codeSexe){codeSexeProperty().set(codeSexe);}

    private SimpleStringProperty nomSexeGrand=new SimpleStringProperty();
    public final SimpleStringProperty nomSexeGrandProperty(){return this.nomSexeGrand;}
    public final String getNomSexeGrand(){return nomSexeGrandProperty().get();}
    public final void setNomSexeGrand(String nomSexeGrand){this.nomSexeGrandProperty().set(nomSexeGrand);}

    private SimpleStringProperty sigleSexeGrand=new SimpleStringProperty();
    public final SimpleStringProperty sigleSexeGrandProperty(){return this.sigleSexeGrand;}
    public final String getSigleSexeGrand(){return sigleSexeGrandProperty().get();}
    public final void setSigleSexeGrand(String sigleSexeGrand){this.sigleSexeGrandProperty().set(sigleSexeGrand);}

    private SimpleStringProperty nomSexePetit=new SimpleStringProperty();
    public final SimpleStringProperty nomSexePetitProperty(){return this.nomSexePetit;}
    public final String getNomSexePetit(){return nomSexePetitProperty().get();}
    public final void setNomSexePetit(String nomSexePetit){this.nomSexePetitProperty().set(nomSexePetit);}

    private SimpleStringProperty sigleSexePetit=new SimpleStringProperty();
    public final SimpleStringProperty sigleSexePetitProperty(){return this.sigleSexePetit;}
    public final String getSigleSexePetit(){return sigleSexePetitProperty().get();}
    public final void setSigleSexePetit(String sigleSexePetit){this.sigleSexePetitProperty().set(sigleSexePetit);}

    private SimpleStringProperty descriptions=new SimpleStringProperty();
    public final SimpleStringProperty descriptionsProperty(){return this.descriptions;}
    public final String getDescriptions(){return descriptionsProperty().get();}
    public final void setDescriptions(String descriptions){this.descriptionsProperty().set(descriptions);}

    public Sex(){}

    public Sex(Integer a_codeSexe, String a_nomSexeGrand, String a_sigleSexeGrand, String a_sexePetit, String a_sigleSexePetit, String a_descriptions){
        setCodeSexe(a_codeSexe);
        setNomSexeGrand(a_nomSexeGrand);
        setSigleSexeGrand(a_sigleSexeGrand);
        setNomSexePetit(a_sexePetit);
        setSigleSexePetit(a_sigleSexePetit);
        setDescriptions(a_descriptions);
    }
}