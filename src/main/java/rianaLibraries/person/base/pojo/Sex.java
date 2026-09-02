package rianaLibraries.person.base.pojo;

public class Sex {

    private Integer codeSexe;

    private String nomSexeGrand;

    private String sigleSexeGrand;

    private String nomSexePetit;

    private String sigleSexePetit;

    private String descriptions;

    public Sex(){}

    public Sex(Integer a_codeSexe, String a_nomSexeGrand, String a_sigleSexeGrand, String a_sexePetit, String a_sigleSexePetit, String a_descriptions){
        setCodeSexe(a_codeSexe);
        setNomSexeGrand(a_nomSexeGrand);
        setSigleSexeGrand(a_sigleSexeGrand);
        setNomSexePetit(a_sexePetit);
        setSigleSexePetit(a_sigleSexePetit);
        setDescriptions(a_descriptions);
    }

    public Integer getCodeSexe() {
        return codeSexe;
    }

    public void setCodeSexe(Integer codeSexe) {
        this.codeSexe = codeSexe;
    }

    public String getNomSexeGrand() {
        return nomSexeGrand;
    }

    public void setNomSexeGrand(String nomSexeGrand) {
        this.nomSexeGrand = nomSexeGrand;
    }

    public String getSigleSexeGrand() {
        return sigleSexeGrand;
    }

    public void setSigleSexeGrand(String sigleSexeGrand) {
        this.sigleSexeGrand = sigleSexeGrand;
    }

    public String getNomSexePetit() {
        return nomSexePetit;
    }

    public void setNomSexePetit(String nomSexePetit) {
        this.nomSexePetit = nomSexePetit;
    }

    public String getSigleSexePetit() {
        return sigleSexePetit;
    }

    public void setSigleSexePetit(String sigleSexePetit) {
        this.sigleSexePetit = sigleSexePetit;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }
}