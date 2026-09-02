package rianaLibraries.login;

import javafx.fxml.FXML;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactoryUtils {
    private static UserProperties userProperties;
    private static SqlSessionFactory sqlSessionFactory;
    private static final Class CLASS_LOCK=SqlSessionFactoryUtils.class;

    public SqlSessionFactoryUtils(UserProperties userProperty)  {
        userProperties=userProperty;
    }

    public static SqlSessionFactory initSqlSessionFactory(UserProperties userproperty){
        String resource= "Mybatis_config.xml";
        InputStream inputStream=null;
        try {
            inputStream=Resources.getResourceAsStream(resource);
            //System.out.println(inputStream.getClass().getName());
        }
        catch (IOException e){
            Logger.getLogger(SqlSessionFactoryUtils.class.getName()).log(Priority.DEBUG,null,e);
        }
        synchronized (CLASS_LOCK) {
            if (sqlSessionFactory == null) {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream,userproperty.getUserProperty());
            }
        }
            return sqlSessionFactory;
        }

    public static SqlSession openSqlSession(){
        if(sqlSessionFactory==null){
            initSqlSessionFactory(userProperties);
        }
        return sqlSessionFactory.openSession();
    }

    public  void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        SqlSessionFactoryUtils.sqlSessionFactory = sqlSessionFactory;
    }

    @FXML
    private void connect(){

    }
}
