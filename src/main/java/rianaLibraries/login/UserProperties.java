package rianaLibraries.login;

import javafx.beans.property.SimpleStringProperty;

import java.util.Properties;

public  class UserProperties {

    private  Properties UserProperty=new Properties();
    private static final SimpleStringProperty Username=new SimpleStringProperty();
    private static final  SimpleStringProperty Password=new SimpleStringProperty();
    private static final SimpleStringProperty Driver=new SimpleStringProperty();
    private static final SimpleStringProperty Url=new SimpleStringProperty();

    public   Properties getUserProperty() {
        return UserProperty;
    }

    public  SimpleStringProperty DriverProperty(){return this.Driver;}
    public static String getDriver(){return Driver.get();}
    public void setDriver(String driver) {this.Driver.set(driver);}

    public SimpleStringProperty UrlProperty(){return this.Url;}
    public static String getUrl(){return Url.get();}
    public void setUrl(String url) {this.Url.set(url);}

    public SimpleStringProperty UsernameProperty(){return this.Username;}
    public static String getUsername(){return Username.get();}
    public void setUsername(String username) {this.Username.set(username);}

    public SimpleStringProperty PasswordProperty(){return this.Password;}
    public static String getPassword(){return Password.get();}
    public void setPassword(String password) {this.Password.set(password);}

    public void setUserProperties(){
        UserProperty.setProperty("driver",getDriver());
        UserProperty.setProperty("url",getUrl());
        UserProperty.setProperty("username",getUsername());
        UserProperty.setProperty("password",getPassword());
    }

    public UserProperties(){}
    public UserProperties(String username, String password, String driverProperties, String url){
        setUsername(username);
        setPassword(password);
        setDriver(driverProperties);
        setUrl(url);
    }




}
