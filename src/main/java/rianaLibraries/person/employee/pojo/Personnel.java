package rianaLibraries.person.employee.pojo;



import java.time.LocalDate;

public class Personnel extends rianaLibraries.person.base.pojo.Person {

    private  Long codePers;
    private  String aeEx;
    private  LocalDate dateEntreeAdmin;
    private  Integer im;
    private  Boolean persEtat;

    //months
    private  Integer january;
    private  Integer february;
    private  Integer march;
    private  Integer april;
    private  Integer may;
    private  Integer june;
    private  Integer july;
    private  Integer august;
    private  Integer september;
    private  Integer october;
    private  Integer november;
    private  Integer december;

    private  Integer hours;
    private  Integer howMuch;
    
    
    public Personnel(){}

    public Personnel(Long codePers){
        setCodePers(codePers);
    }

    public Personnel(Long codePers,Integer id,String mail,String phoneNumber){
        super(id,mail,phoneNumber);
        setCodePers(codePers);

    }

    public Personnel (Long codePers,String nomPers,String prenomPers){
        super(nomPers,prenomPers);
        setCodePers(codePers);
    }

    public Personnel (Long codePers,String nomPers,String prenomPers,Integer gender,String phoneNumber){
        super(nomPers,prenomPers,gender,phoneNumber);
        setCodePers(codePers);
    }

    public Personnel (String nomPers,String prenomPers){
        super(nomPers,prenomPers);
    }

    public Personnel(Long codePers, String lastName, String firstName, Integer id, LocalDate idDate, String idPlace, Integer gender, String email, String phoneNumber){
        super(lastName,firstName,id,idDate,idPlace,gender,email,phoneNumber);
        setCodePers(codePers);
    }

    public Personnel(Long codePers, String lastName, String firstName, LocalDate dateOfBirth, String placeOfBirth, Integer gender, String address, String phoneNumber, String photo, Integer id, LocalDate idDate, String idPlace, LocalDate idDateRecovery, String idPlaceRecovery, Integer spouse, Integer children, Integer familyStatus, String aeEx, boolean persEtat, Integer im, LocalDate dateEntreeAdmin, Integer codeSq1, Integer codeSq2, Integer codeSq3, String secAns1, String secAns2, String secAns3){
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

    public Personnel(Long codePers, String nom, String prenoms, Integer sexe, String phoneNumber, String fullName, String shortGender) {
        super(nom,prenoms,sexe,phoneNumber,fullName,shortGender);
        setCodePers(codePers);
    }


    public Personnel(Long codePers, String nom, String prenoms, Integer sexe, String phoneNumber, String email,Integer numCin, String fullName, String shortGender) {
        super(nom,prenoms,sexe,phoneNumber,email,numCin,fullName,shortGender);
        setCodePers(codePers);
    }


    public Long getCodePers() {
        return codePers;
    }

    public void setCodePers(Long codePers) {
        this.codePers = codePers;
    }

    public String getAeEx() {
        return aeEx;
    }

    public void setAeEx(String aeEx) {
        this.aeEx = aeEx;
    }

    public LocalDate getDateEntreeAdmin() {
        return dateEntreeAdmin;
    }

    public void setDateEntreeAdmin(LocalDate dateEntreeAdmin) {
        this.dateEntreeAdmin = dateEntreeAdmin;
    }

    public Integer getIm() {
        return im;
    }

    public void setIm(Integer im) {
        this.im = im;
    }

    public Boolean getPersEtat() {
        return persEtat;
    }

    public void setPersEtat(Boolean persEtat) {
        this.persEtat = persEtat;
    }

    public Integer getJanuary() {
        return january;
    }

    public void setJanuary(Integer january) {
        this.january = january;
    }

    public Integer getFebruary() {
        return february;
    }

    public void setFebruary(Integer february) {
        this.february = february;
    }

    public Integer getMarch() {
        return march;
    }

    public void setMarch(Integer march) {
        this.march = march;
    }

    public Integer getApril() {
        return april;
    }

    public void setApril(Integer april) {
        this.april = april;
    }

    public Integer getMay() {
        return may;
    }

    public void setMay(Integer may) {
        this.may = may;
    }

    public Integer getJune() {
        return june;
    }

    public void setJune(Integer june) {
        this.june = june;
    }

    public Integer getJuly() {
        return july;
    }

    public void setJuly(Integer july) {
        this.july = july;
    }

    public Integer getAugust() {
        return august;
    }

    public void setAugust(Integer august) {
        this.august = august;
    }

    public Integer getSeptember() {
        return september;
    }

    public void setSeptember(Integer september) {
        this.september = september;
    }

    public Integer getOctober() {
        return october;
    }

    public void setOctober(Integer october) {
        this.october = october;
    }

    public Integer getNovember() {
        return november;
    }

    public void setNovember(Integer november) {
        this.november = november;
    }

    public Integer getDecember() {
        return december;
    }

    public void setDecember(Integer december) {
        this.december = december;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Integer getHowMuch() {
        return howMuch;
    }

    public void setHowMuch(Integer howMuch) {
        this.howMuch = howMuch;
    }
}
