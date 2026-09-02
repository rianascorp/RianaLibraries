package rianaLibraries.person.base;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class testo {
    private static SimpleStringProperty name=new SimpleStringProperty();
    private static SimpleObjectProperty<Integer> age=new SimpleObjectProperty<>();

    public SimpleStringProperty nameProperty(){return this.name;}
    public String getName(){return nameProperty().get();}
    public void setName(String aname){nameProperty().set(aname);}

    public SimpleObjectProperty<Integer> ageProperty(){return this.age;};
    public Integer getAge(){return ageProperty().get();}
    public void setAge(Integer age){ageProperty().set(age);}

    public testo(String name, Integer age){
        setName(name);
        setAge(age);
    }





}
