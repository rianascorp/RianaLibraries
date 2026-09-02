package rianaLibraries.person.employee;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class AlternativeSecurity extends Personnel {
    private  SimpleIntegerProperty codeSq1=new SimpleIntegerProperty();
    private  SimpleIntegerProperty codeSq2=new SimpleIntegerProperty();
    private  SimpleIntegerProperty codeSq3=new SimpleIntegerProperty();
    private  SimpleStringProperty secAns1=new SimpleStringProperty();
    private  SimpleStringProperty secAns2=new SimpleStringProperty();
    private  SimpleStringProperty secAns3=new SimpleStringProperty();

    public SimpleIntegerProperty codeSq1Property(){return this.codeSq1;}
    public Integer getCodeSq1(){return codeSq1Property().get();}
    public void setCodeSq1(Integer codeSq1){codeSq1Property().set(codeSq1);}



    public SimpleIntegerProperty codeSq2Property(){return this.codeSq2;}
    public Integer getCodeSq2(){return codeSq2Property().get();}
    public void setCodeSq2(Integer codeSq2){codeSq2Property().set(codeSq2);}



    public SimpleIntegerProperty codeSq3Property(){return this.codeSq3;}
    public Integer getCodeSq3(){return codeSq3Property().get();}
    public void setCodeSq3(Integer codeSq3){codeSq3Property().set(codeSq3);}


    public SimpleStringProperty secAns1Property(){return this.secAns1;}
    public String getSecAns1(){return secAns1Property().get();}
    public void setSecAns1(String secAns1){secAns1Property().set(secAns1);}

    public SimpleStringProperty secAns2Property(){return this.secAns2;}
    public String getSecAns2(){return secAns2Property().get();}
    public void setSecAns2(String secAns2){secAns2Property().set(secAns2);}

    public SimpleStringProperty secAns3Property(){return this.secAns3;}
    public String getSecAns3(){return secAns3Property().get();}
    public void setSecAns3(String secAns3){secAns3Property().set(secAns3);}

    public AlternativeSecurity(){};
    public AlternativeSecurity(Integer codePers, Integer codeSq1, Integer codeSq2, Integer codeSq3,String secAns1, String secAns2, String secAns3)
    {
        super(codePers);
        setCodeSq1(codeSq1);
        setCodeSq2(codeSq2);
        setCodeSq3(codeSq3);
        setSecAns1(secAns1);
        setSecAns2(secAns2);
        setSecAns3(secAns3);
    }
}
