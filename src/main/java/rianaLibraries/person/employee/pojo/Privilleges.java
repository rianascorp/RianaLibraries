package rianaLibraries.person.employee.pojo;


public class Privilleges extends Account {
    
    private  Long codeStatutLogin;

    private  Boolean isDepositaire;

    private  Boolean isDirecteur;


    private  Boolean isEconome;

    private  Boolean isEnseignant;

    private  Boolean isSecretaire;
    private  Boolean isSurveillant;

    public Privilleges(Long codePers,String nom,String prenoms,String nomUtilisateur,Long codeStatutLogin,Boolean isDepositaire, Boolean isDirecteur,Boolean isEconome,Boolean isEnseignant, Boolean isSecretaire, Boolean isSurveillant){
        super(codePers,nom,prenoms,nomUtilisateur);
        setCodeStatutLogin(codeStatutLogin);
        setDepositaire(isDepositaire);
        setDirecteur(isDirecteur);
        setEconome(isEconome);
        setSecretaire(isSecretaire);
        setEnseignant(isEnseignant);
        setSurveillant(isSurveillant);
    }


    public Long getCodeStatutLogin() {
        return codeStatutLogin;
    }

    public void setCodeStatutLogin(Long codeStatutLogin) {
        this.codeStatutLogin = codeStatutLogin;
    }

    public Boolean getDepositaire() {
        return isDepositaire;
    }

    public void setDepositaire(Boolean depositaire) {
        isDepositaire = depositaire;
    }

    public Boolean getDirecteur() {
        return isDirecteur;
    }

    public void setDirecteur(Boolean directeur) {
        isDirecteur = directeur;
    }

    public Boolean getEconome() {
        return isEconome;
    }

    public void setEconome(Boolean econome) {
        isEconome = econome;
    }

    public Boolean getEnseignant() {
        return isEnseignant;
    }

    public void setEnseignant(Boolean enseignant) {
        isEnseignant = enseignant;
    }

    public Boolean getSecretaire() {
        return isSecretaire;
    }

    public void setSecretaire(Boolean secretaire) {
        isSecretaire = secretaire;
    }

    public Boolean getSurveillant() {
        return isSurveillant;
    }

    public void setSurveillant(Boolean surveillant) {
        isSurveillant = surveillant;
    }
}
