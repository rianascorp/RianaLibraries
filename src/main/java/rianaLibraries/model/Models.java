package rianaLibraries.model;

import javafx.beans.property.*;
import rianaLibraries.login.SqlSessionFactoryUtils;
import javafx.collections.ObservableList;
import org.apache.ibatis.session.SqlSession;

import java.util.Comparator;
import java.util.List;

public class Models<M>{
        private final ObservableList<M> MList;
        private ObservableList<M> filteredList;

        private SimpleIntegerProperty listSize=new SimpleIntegerProperty();

        private SqlSession sqlSession;



        public Models(ObservableList<M> mList) {
            MList = mList;
        }

        private SimpleStringProperty id=new SimpleStringProperty();
    public final SimpleStringProperty idProperty(){return this.id;}
    public final String getId(){return this.idProperty().get();}
    public final void setId(String id){this.idProperty().set(id);}


    private final ObjectProperty<M> current=new SimpleObjectProperty<>(null);
        public ObjectProperty<M> currentProperty(){return current;}
        public final M getCurrent(){return currentProperty().get();}
        public final void setCurrent(M m){
            currentProperty().set(m);
        }

        public ObservableList<M> getMList(){
            return MList;
        }

        public List<M> getRawList(String getAll){
            sqlSession= SqlSessionFactoryUtils.openSqlSession();
            List<M> list=sqlSession.selectList(getAll);
            sqlSession.close();
            return list;
        }

        public Integer getOne (String getOne){
            sqlSession= SqlSessionFactoryUtils.openSqlSession();
            Integer i=sqlSession.selectOne(getOne);
            sqlSession.close();
            return i;
        }

        public List<M> getByParam(String string,Integer param){
            sqlSession=SqlSessionFactoryUtils.openSqlSession();
            List<M> list=sqlSession.selectList(string,param);
            sqlSession.close();
            return list;
        }

        public void justLoadAll(List<M> list){
            MList.clear();
            MList.addAll(list);
        }

        public void justLoadToFiltered(List<M> list){
            filteredList.clear();
            filteredList.addAll(list);
        }

        public void loadAll(List<M> list, Comparator<M> comparator){
            MList.clear();
            MList.addAll(list);
            MList.sort(comparator);
        }

        public void loadAllAndSetDates(List<M> list,Comparator<M> comparator,String dateFormat,ModelInterface<M> mi){
            MList.clear();
            for (M m:list){
                mi.insertNewDateIntoObject(m,dateFormat);
                MList.add(list.indexOf(m),m);
            }
            MList.sort(comparator);
        }

        public void setFilteredList(ObservableList<M> filteredList){
            this.filteredList=filteredList;
        }

        public ObservableList<M> getFilteredList(){
            return this.filteredList;
        }

        public SimpleIntegerProperty listSizeProperty(){return this.listSize;}
        public Integer getListSize(){
            return this.listSizeProperty().get();
        }
        public void setListSize(Integer listSize){
            this.listSizeProperty().set(listSize);
        }

        public void refreshListSize(){
            this.listSizeProperty().set(MList.size());
        }

    }


