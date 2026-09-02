package rianaLibraries.data;

import javafx.beans.property.SimpleObjectProperty;
import org.apache.ibatis.session.SqlSession;

public class PkeyMan {

    private SimpleObjectProperty<Integer> maxId=new SimpleObjectProperty<>();
    public SimpleObjectProperty<Integer> maxIdProperty(){return this.maxId;}

    public Integer getMaxId() {
        return maxIdProperty().get();
    }

    public void setMaxId(Integer maxId) {
        this.maxIdProperty().set(maxId);
    }

    public void fetchMaxId(String dbPath) {

        SqlSession sqlSession=rianaLibraries.login.SqlSessionFactoryUtils.openSqlSession();
        Integer maxId=sqlSession.selectOne(dbPath);
        sqlSession.close();
        this.maxIdProperty().set(maxId);
    }

    public void fetchMaxId(String dbPath,Object condition) {
        SqlSession sqlSession=rianaLibraries.login.SqlSessionFactoryUtils.openSqlSession();
        Integer maxId=sqlSession.selectOne(dbPath,condition);
        sqlSession.close();
        this.maxIdProperty().set(maxId);
    }


    private SimpleObjectProperty<Integer> id=new SimpleObjectProperty<>();
    public SimpleObjectProperty<Integer> idProperty(){return this.id;}

    public Integer getNextId() {
        Integer id;
        if (getMaxId()==null){
            id=1;
        }
        else{
            id=getMaxId()+1;
        }
        return id;
    }

    public Integer getId() {
        return idProperty().get();
    }

    public void setId(Integer id) {
        this.idProperty().set(id);
    }


    public PkeyMan(){};

    public PkeyMan(Integer maxId){
        setMaxId( maxId);
    }

}
