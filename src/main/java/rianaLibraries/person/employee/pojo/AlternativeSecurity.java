package rianaLibraries.person.employee.pojo;



public class AlternativeSecurity extends Personnel {
    private  Integer codeSq1;
    private  Integer codeSq2;
    private  Integer codeSq3;
    private  String secAns1;
    private  String secAns2;
    private  String secAns3;



    public AlternativeSecurity(){};

    public AlternativeSecurity(Long codePers, Integer codeSq1, Integer codeSq2, Integer codeSq3, String secAns1, String secAns2, String secAns3) {
        super(codePers);
        this.codeSq1 = codeSq1;
        this.codeSq2 = codeSq2;
        this.codeSq3 = codeSq3;
        this.secAns1 = secAns1;
        this.secAns2 = secAns2;
        this.secAns3 = secAns3;
    }


    public Integer getCodeSq1() {
        return codeSq1;
    }

    public void setCodeSq1(Integer codeSq1) {
        this.codeSq1 = codeSq1;
    }

    public Integer getCodeSq2() {
        return codeSq2;
    }

    public void setCodeSq2(Integer codeSq2) {
        this.codeSq2 = codeSq2;
    }

    public Integer getCodeSq3() {
        return codeSq3;
    }

    public void setCodeSq3(Integer codeSq3) {
        this.codeSq3 = codeSq3;
    }

    public String getSecAns1() {
        return secAns1;
    }

    public void setSecAns1(String secAns1) {
        this.secAns1 = secAns1;
    }

    public String getSecAns2() {
        return secAns2;
    }

    public void setSecAns2(String secAns2) {
        this.secAns2 = secAns2;
    }

    public String getSecAns3() {
        return secAns3;
    }

    public void setSecAns3(String secAns3) {
        this.secAns3 = secAns3;
    }
}
