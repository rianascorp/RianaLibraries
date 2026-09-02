
package rianaLibraries.controller;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import io.github.palexdev.materialfx.controls.MFXListView;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;
import net.synedra.validatorfx.Validator;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.postgresql.util.PSQLException;
import rianaLibraries.controls.RianaGetName;
import rianaLibraries.login.SqlSessionFactoryUtils;
import rianaLibraries.model.Models;
import rianaLibraries.validation.Language;

import java.io.IOException;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Controllers {
    StackPane root;


    public <M> void initModelInfo (Models<M> model, TableView<M> table, RianaEdit re, RianaDelete rd, RianaRefresh rf) throws IOException {
        table.getItems().clear();
        table.setItems(model.getMList());
        if (rf!=null) rf.Refresh();

        //AddButtonToTable
        TableColumn<M, Void> colBtn = new TableColumn("Actions");

        Callback<TableColumn<M, Void>, TableCell<M, Void>> cellFactory = new Callback<>() {
            @Override
            public TableCell<M, Void> call(final TableColumn<M, Void> param) {
                final TableCell<M, Void> cell = new TableCell<>() {
                    private final Button EditBtn = new Button();
                    private final Button DeleteBtn = new Button();
                    HBox pane = new HBox(1, EditBtn, DeleteBtn);

                    {
                        EditBtn.getStyleClass().setAll("btn-sm", "btn-info");

                        EditBtn.setCursor(Cursor.HAND);

                        DeleteBtn.setCursor(Cursor.HAND);
                        DeleteBtn.getStyleClass().setAll("btn-sm", "btn-danger");
                        FontAwesomeIconView deleteIcon=new FontAwesomeIconView(FontAwesomeIcon.TRASH_ALT);
                        //FontIcon deleteIcon = new FontIcon(FontAwesome.TRASH);
                        //FontIcon editIcon = new FontIcon(FontAwesome.EDIT);
                        FontAwesomeIconView editIcon=new FontAwesomeIconView(FontAwesomeIcon.INFO);

                        DeleteBtn.setGraphic(deleteIcon);
                        EditBtn.setGraphic(editIcon);

                        EditBtn.setOnAction((ActionEvent event) -> {
                            M selected = getTableView().getItems().get(getIndex());
                            model.setCurrent(selected);
                            try {
                                re.Edit();
                            } catch (NoSuchMethodException | IOException e) {
                                e.printStackTrace();
                            }
                        });

                        DeleteBtn.setOnAction((ActionEvent event) -> {
                            try {
                                M selected = getTableView().getItems().get(getIndex());
                                model.setCurrent(selected);
                                rd.Delete(selected);
                            } catch (Exception e) {
                                e.getMessage();
                            }
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(pane);
                        }
                    }
                };
                return cell;
            }
        };
        colBtn.setCellFactory(cellFactory);
        table.getColumns().add(colBtn);

        //table.getColumns().remove(table.getColumns().size()-1);

        //
        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> model.setCurrent(newSelection));

        model.currentProperty().addListener((obs, oldPeriode, newPeriode) -> {
            if (newPeriode == null) {
                table.getSelectionModel().clearSelection();
            } else {
                table.getSelectionModel().select(newPeriode);
            }
        });
    }

    //Instead of edit, the icon is changed to info

    public <M> void initModel (Models<M> model, TableView<M> table, RianaEdit re, RianaDelete rd, RianaRefresh rf) throws IOException {
        table.getItems().clear();
        table.setItems(model.getMList());
        if (rf!=null) rf.Refresh();

        //AddButtonToTable
        TableColumn<M, Void> colBtn = new TableColumn("Actions");

        Callback<TableColumn<M, Void>, TableCell<M, Void>> cellFactory = new Callback<>() {
            @Override
            public TableCell<M, Void> call(final TableColumn<M, Void> param) {
                final TableCell<M, Void> cell = new TableCell<>() {
                    private final Button EditBtn = new Button();
                    private final Button DeleteBtn = new Button();
                    HBox pane = new HBox(1, EditBtn, DeleteBtn);
                    {
                        EditBtn.getStyleClass().setAll("btn-sm", "btn-warning");

                        EditBtn.setCursor(Cursor.HAND);

                        DeleteBtn.setCursor(Cursor.HAND);
                        DeleteBtn.getStyleClass().setAll("btn-sm", "btn-danger");
                        FontAwesomeIconView deleteIcon=new FontAwesomeIconView(FontAwesomeIcon.TRASH_ALT);
                        //FontIcon deleteIcon = new FontIcon(FontAwesome.TRASH);
                        //FontIcon editIcon = new FontIcon(FontAwesome.EDIT);
                        FontAwesomeIconView editIcon=new FontAwesomeIconView(FontAwesomeIcon.EDIT);

                        DeleteBtn.setGraphic(deleteIcon);
                        EditBtn.setGraphic(editIcon);

                        EditBtn.setOnAction((ActionEvent event) -> {
                            M selected = getTableView().getItems().get(getIndex());
                            model.setCurrent(selected);
                            try {
                                re.Edit();
                            } catch (NoSuchMethodException | IOException e) {
                                e.printStackTrace();
                            }
                        });

                        DeleteBtn.setOnAction((ActionEvent event) -> {
                            try {
                                M selected = getTableView().getItems().get(getIndex());
                                model.setCurrent(selected);
                                rd.Delete(selected);
                            } catch (Exception e) {
                                e.getMessage();
                            }
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(pane);
                        }
                    }
                };
                return cell;
            }
        };
        colBtn.setCellFactory(cellFactory);
        table.getColumns().add(colBtn);

        //table.getColumns().remove(table.getColumns().size()-1);

        //
        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> model.setCurrent(newSelection));

        model.currentProperty().addListener((obs, oldPeriode, newPeriode) -> {
            if (newPeriode == null) {
                table.getSelectionModel().clearSelection();
            } else {
                table.getSelectionModel().select(newPeriode);
            }
        });
    }


    public <M> void initModel (Models<M> model, TableView<M> table, RianaRefresh rf) throws IOException {
        table.getItems().clear();
        table.setItems(model.getMList());
        if (rf!=null) rf.Refresh();

        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> model.setCurrent(newSelection));

        model.currentProperty().addListener((obs, oldPeriode, newPeriode) -> {
            if (newPeriode == null) {
                table.getSelectionModel().clearSelection();
            } else {
                table.getSelectionModel().select(newPeriode);
            }
        });
    }


    public <M> void showImage(Models<M> model, TableView<M> table, RianaGetName<M> rgn, M m, ImageView imageView, Integer gender, String malePhotoPath, String femalePhotoPath){
        if (model.getCurrent()!=null)getImage( rgn,  m,  imageView, gender, malePhotoPath,femalePhotoPath);

        table.getSelectionModel().selectedItemProperty().addListener((obs,oldS,newS)->{
            getImage(rgn, m,  imageView, gender, malePhotoPath,femalePhotoPath);
        });
    }

    public<M> void getImage(RianaGetName<M> rgn, M m, ImageView imageView,Integer gender,String malePhotoPath,String femalePhotoPath){
        if (rgn.getName(m)!=null){
            Image image;
            if (rgn.getName(m)!=null){
                image=new Image(Paths.get(rgn.getName(m)).toUri().toString());
            }
            else{
                if(gender==1){
                    image=new Image(malePhotoPath);
                }
                else{   image=new Image(femalePhotoPath);}
            }
            imageView.setImage(image);}
    }

    public <T> void Delete(String deleteString, Object Code,Models<T> models, String refreshMapperPath, Comparator<T> comparator) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Supprimer");
        alert.setHeaderText("Voulez-vous supprimer?");
        if (Code!=null) {
            alert.setContentText("Cette action peut entraîner la suppression en cascade des informations dépendantes. Voulez-vous poursuivre?");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                SqlSession sqlSession;
                sqlSession = SqlSessionFactoryUtils.openSqlSession();
                sqlSession.delete(deleteString, Code);
                sqlSession.commit();
                sqlSession.close();
                alert.close();
                Refresh(models,refreshMapperPath,comparator);
            }
        }
        else{
            alert.setContentText("Impossible de faire la suppression car le donnée n'existe pas");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                alert.close();
            }
        }

    }

    // Jakarta JPA
    public <T> void Delete(Class<T> tClass, EntityManagerFactory emf, Object Code, Language language) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        String title=new String();
        switch (language){
            case MALAGASY -> title="Hamafa";
            case FRENCH -> title="Supprimer";
            case ENGLISH -> title="Delete";
        }
        alert.setTitle(title);

        String header=new String();
        switch (language){
            case MALAGASY -> header="Hamafa io va ianao?";
            case FRENCH -> header="Voulez-vous supprimer cet élément?";
            case ENGLISH -> header="Do you want to delete this item?";
        }
        alert.setHeaderText(header);
        String contextText=new String();
        if (Code!=null) {
            switch (language){
                case MALAGASY -> contextText="Raha mamafa ianao dia mety ho voafafa avy hatrany ireo fafana mifandraika aminy. Atao?";
                case FRENCH -> contextText="Cette action peut entraîner la suppression en cascade des informations dépendantes. Voulez-vous poursuivre?";
                case ENGLISH -> contextText="This action may lead to the removal of all dependant information. Do you want to proceed?";
            }
            alert.setContentText(contextText);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                EntityManager em=emf.createEntityManager();
                em.getTransaction().begin();
                T t=em.find(tClass,Code);
                em.remove(t);
                em.getTransaction().commit();
                em.close();
                alert.close();
            }
        }
        else{
            switch (language){
                case MALAGASY -> contextText="Tsy fantatra izay ho fafàna";
                case FRENCH -> contextText="Impossible de faire la suppression car le donnée n'existe pas";
                case ENGLISH -> contextText="No chosen element";
            }
            alert.setContentText(contextText);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                alert.close();
            }
        }
    }

    //Jakarta JPA with refresh
    public <T> void Delete(Class<T> tClass, EntityManagerFactory emf, Object Code, Language language,RianaRefresh refresh) throws IOException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        String title=new String();
        switch (language){
            case MALAGASY -> title="Hamafa";
            case FRENCH -> title="Supprimer";
            case ENGLISH -> title="Delete";
        }
        alert.setTitle(title);

        String header=new String();
        switch (language){
            case MALAGASY -> header="Hamafa io va ianao?";
            case FRENCH -> header="Voulez-vous supprimer cet élément?";
            case ENGLISH -> header="Do you want to delete this item?";
        }
        alert.setHeaderText(header);
        String contextText=new String();
        if (Code!=null) {
            switch (language){
                case MALAGASY -> contextText="Raha mamafa ianao dia mety ho voafafa avy hatrany ireo fafana mifandraika aminy. Atao?";
                case FRENCH -> contextText="Cette action peut entraîner la suppression en cascade des informations dépendantes. Voulez-vous poursuivre?";
                case ENGLISH -> contextText="This action may lead to the removal of all dependant information. Do you want to proceed?";
            }
            alert.setContentText(contextText);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                EntityManager em=emf.createEntityManager();
                em.getTransaction().begin();
                T t=em.find(tClass,Code);
                em.remove(t);
                em.getTransaction().commit();
                em.close();
                alert.close();
               refresh.Refresh();
            }
        }
        else{
            switch (language){
                case MALAGASY -> contextText="Tsy fantatra izay ho fafàna";
                case FRENCH -> contextText="Impossible de faire la suppression car le donnée n'existe pas";
                case ENGLISH -> contextText="No chosen element";
            }
            alert.setContentText(contextText);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                alert.close();
            }
        }
    }

    // Jakarta JPA
    public <T> void Delete(Class<T> tClass, EntityManagerFactory emf, Object object, Map<String,Object> map, Language language) throws IOException {
        try{
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        String title=new String();
        switch (language){
            case MALAGASY -> title="Hamafa";
            case FRENCH -> title="Supprimer";
            case ENGLISH -> title="Delete";
        }
        alert.setTitle(title);

        String header=new String();
        switch (language){
            case MALAGASY -> header="Hamafa io va ianao?";
            case FRENCH -> header="Voulez-vous supprimer cet élément?";
            case ENGLISH -> header="Do you want to delete this item?";
        }
        alert.setHeaderText(header);
        String contextText=new String();
        if (object!=null) {
            switch (language){
                case MALAGASY -> contextText="Raha mamafa ianao dia mety ho voafafa avy hatrany ireo fafana mifandraika aminy. Atao?";
                case FRENCH -> contextText="Cette action peut entraîner la suppression en cascade des informations dépendantes. Voulez-vous poursuivre?";
                case ENGLISH -> contextText="This action may lead to the removal of all dependant information. Do you want to proceed?";
            }
            alert.setContentText(contextText);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                EntityManager em=emf.createEntityManager();
                em.getTransaction().begin();
                T t=em.find(tClass,object,map);
                em.remove(t);
                em.getTransaction().commit();
                em.close();
                alert.close();
            }
        }
        else{
            switch (language){
                case MALAGASY -> contextText="Tsy fantatra izay ho fafàna";
                case FRENCH -> contextText="Impossible de faire la suppression car le donnée n'existe pas";
                case ENGLISH -> contextText="No chosen element";
            }
            alert.setContentText(contextText);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                alert.close();
            }
        }}
        catch (Exception ex){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur");
            alert.setContentText(ex.getMessage());
            alert.show();
            ex.printStackTrace();
        }
    }



    //No Refresh
    public <T> Boolean Delete(String deleteString, Object Code) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Supprimer");
        alert.setHeaderText("Voulez-vous supprimer?");
        if (Code!=null) {
            alert.setContentText("Cette action peut entraîner la suppression en cascade des informations dépendantes. Voulez-vous poursuivre?");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                SqlSession sqlSession;
                sqlSession = SqlSessionFactoryUtils.openSqlSession();
                sqlSession.delete(deleteString, Code);
                sqlSession.commit();
                sqlSession.close();
                alert.close();
                return true;
            }
        }
        else{
            alert.setContentText("Impossible de faire la suppression car le donnée n'existe pas");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                alert.close();
            }
        }
        return  false;
    }

    public <T> void SetTableModel(TableView<T> table, Models<T> model,Integer param,String path,Comparator<T> comparator) {
        table.getItems().clear();
        table.setItems(model.getMList());
        model.loadAll(model.getByParam(path,param),comparator);

        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> model.setCurrent(newSelection));

        model.currentProperty().addListener((obs, oldPeriode, newPeriode) -> {
            if (newPeriode == null) {
                table.getSelectionModel().clearSelection();
            } else {
                table.getSelectionModel().select(newPeriode);
            }
        });
    }

    public <T> void SetTableModel(TableView<T> table, Models<T> model,ObservableList<T> list) {
        table.getItems().clear();
        table.setItems(list);

        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> model.setCurrent(newSelection));

        model.currentProperty().addListener((obs, oldPeriode, newPeriode) -> {
            if (newPeriode == null) {
                table.getSelectionModel().clearSelection();
            } else {
                table.getSelectionModel().select(newPeriode);
            }
        });
    }


    public <T> void Delete(String deleteString, Object Code,Models<T> models, String refreshMapperPath, Comparator<T> comparator, Object code) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        if (Code!=null) {
            alert.setTitle("Supprimer");
            alert.setHeaderText("Voulez-vous supprimer?");
            alert.setContentText("Cette action peut entraîner la suppression en cascade des informations dépendantes. Voulez-vous poursuivre?");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                SqlSession sqlSession;
                sqlSession = SqlSessionFactoryUtils.openSqlSession();
                sqlSession.delete(deleteString, Code);
                sqlSession.commit();
                sqlSession.close();
                alert.close();
                Refresh(models,refreshMapperPath,comparator,code);
            }
        }
        else{
            alert.setTitle("Supprimer");
            alert.setHeaderText("Pas de donnée!");
            alert.setContentText("Impossible de faire la suppression car le donnée n'existe pas");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                alert.close();
            }
        }
    }

    public void Delete(String deleteString, Object Code, RianaRefresh rr) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        if (Code!=null) {
            alert.setTitle("Supprimer");
            alert.setHeaderText("Voulez-vous supprimer?");
            alert.setContentText("Cette action peut entraîner la suppression en cascade des informations dépendantes. Voulez-vous poursuivre?");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                SqlSession sqlSession;
                sqlSession = SqlSessionFactoryUtils.openSqlSession();
                sqlSession.delete(deleteString, Code);
                sqlSession.commit();
                sqlSession.close();
                alert.close();
                rr.Refresh();
            }
        }
        else{
            alert.setTitle("Supprimer");
            alert.setHeaderText("Pas de donnée!");
            alert.setContentText("Impossible de faire la suppression car le donnée n'existe pas");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                alert.close();
            }
        }
    }


    public<T> void Refresh(Models<T> models, String mapperPath, Comparator<T> comparator){
        SqlSession sqlSession;
        sqlSession = SqlSessionFactoryUtils.openSqlSession();
        List<T> list;
        list = sqlSession.selectList(mapperPath);
        models.loadAll(list, comparator);
        sqlSession.close();
    }

    public<T> void Refresh(Models<T> models, String mapperPath, Comparator<T> comparator, Object code){
        if (code!=null) {
            SqlSession sqlSession;
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            List<T> list;
            list = sqlSession.selectList(mapperPath, code);
            models.loadAll(list, comparator);
            sqlSession.close();
        }
    }

    public void Save(RianaValidation rianaValidation, String caller,String AddName, RianaInsert rianaInsert, RianaUpdate rianaUpdate, RianaRefresh rianaRefresh,Button closeButton,Boolean thenClose) throws IOException {
        Validator validator = new Validator();
        rianaValidation.validation(validator);
        if (validator.validate()){
            try {
                SqlSession sqlSession;
                sqlSession = SqlSessionFactoryUtils.openSqlSession();
                if (caller.equals(AddName)) {
                    rianaInsert.Insert(sqlSession);
                } else {
                    rianaUpdate.Update(sqlSession);
                }
                sqlSession.commit();
                sqlSession.close();
                rianaRefresh.Refresh();
                if (thenClose) {
                    Stage stage = (Stage) closeButton.getScene().getWindow();
                    stage.close();
                }
            }
            catch (PersistenceException e){
                ibatisCatcher(e);
            }
            catch (Exception ex){
                Catcher(ex);
            }
        }
    }

    //Raha jakarta (jpa)

    public void Save(RianaValidation rianaValidation, String caller, String AddName, EntityManagerFactory emf, RianaInsertJpa rianaInsertJpa, RianaUpdateJpa rianaUpdateJpa, RianaRefresh rianaRefresh, Button closeButton, Boolean thenClose) throws IOException, SQLException {
        Validator validator = new Validator();
        rianaValidation.validation(validator);
        if (validator.validate()){

                EntityManager em= emf.createEntityManager();
                em.getTransaction().begin();
                if (caller.equals(AddName)) {
                    rianaInsertJpa.Insert(em);
                } else {
                    rianaUpdateJpa.Update(em);
                }
                em.getTransaction().commit();
                em.close();
                rianaRefresh.Refresh();
                if (thenClose) {
                    Stage stage = (Stage) closeButton.getScene().getWindow();
                    stage.close();
                }
        }
    }

    public Boolean trySave(RianaValidation rianaValidation, String caller, String AddName, EntityManagerFactory emf, RianaInsertJpa rianaInsertJpa, RianaUpdateJpa rianaUpdateJpa, RianaRefresh rianaRefresh, Button closeButton, Boolean thenClose) throws IOException {
        Validator validator = new Validator();
        rianaValidation.validation(validator);
        Boolean ret=false;
        if (validator.validate()){
            try {
                EntityManager em= emf.createEntityManager();
                em.getTransaction().begin();
                if (caller.equals(AddName)) {
                    rianaInsertJpa.Insert(em);
                } else {
                    rianaUpdateJpa.Update(em);
                }
                em.getTransaction().commit();
                em.close();
                rianaRefresh.Refresh();
                if (thenClose) {
                    Stage stage = (Stage) closeButton.getScene().getWindow();
                    stage.close();
                }
                ret=true;
            }

            catch (Exception ex){
                Catcher(ex);
            }
        }
        return ret;
    }


    //Raha misy telo ny callers Add

    public void Save(RianaValidation rianaValidation, String caller,String AddName,String AddName2,String AddName3, RianaInsert rianaInsert, RianaUpdate rianaUpdate, RianaRefresh rianaRefresh,Button closeButton,Boolean thenClose) throws IOException {
        Validator validator = new Validator();
        rianaValidation.validation(validator);
        if (validator.validate()){
            try {
                SqlSession sqlSession;
                sqlSession = SqlSessionFactoryUtils.openSqlSession();
                if (caller.equals(AddName) || caller.equals(AddName2) || caller.equals(AddName3)) {
                    rianaInsert.Insert(sqlSession);
                } else {
                    rianaUpdate.Update(sqlSession);
                }
                sqlSession.commit();
                sqlSession.close();
                rianaRefresh.Refresh();
                if (thenClose) {
                    Stage stage = (Stage) closeButton.getScene().getWindow();
                    stage.close();
                }
            }
            catch (PersistenceException e){
                ibatisCatcher(e);
            }
            catch (Exception ex){
                Catcher(ex);
            }
        }
    }

    //Raha misy params ny refresh
    public void Save(RianaValidation rianaValidation, String caller,String AddName, RianaInsert rianaInsert, RianaUpdate rianaUpdate, RianaRefreshWithParam rianaRefresh,Object paramObject,Button closeButton,Boolean thenClose) throws IOException {
        Validator validator = new Validator();
        rianaValidation.validation(validator);
        if (validator.validate()){
            try {
                SqlSession sqlSession;
                sqlSession = SqlSessionFactoryUtils.openSqlSession();
                if (caller.equals(AddName)) {
                    rianaInsert.Insert(sqlSession);
                } else {
                    rianaUpdate.Update(sqlSession);
                }
                sqlSession.commit();
                sqlSession.close();
                rianaRefresh.Refresh(paramObject);
                if (thenClose) {
                    Stage stage = (Stage) closeButton.getScene().getWindow();
                    stage.close();
                }
            }
            catch (PersistenceException e){
                ibatisCatcher(e);
            }
            catch (Exception ex){
                Catcher(ex);
            }
        }
    }

    //Raha tsy mila discriminant

    public  void Save(RianaValidation rianaValidation, Models models, RianaInsert rianaInsert, RianaUpdate rianaUpdate, Button closeButton){
        Validator validator=new Validator();
        rianaValidation.validation(validator);
        SqlSession sqlSession=SqlSessionFactoryUtils.openSqlSession();
        try{
            if (validator.validate()){
                if (models.getMList().isEmpty()){
                    rianaInsert.Insert(sqlSession);
                }
                else{
                    rianaUpdate.Update(sqlSession);
                }
                sqlSession.commit();
                sqlSession.close();
                Stage stage = (Stage) closeButton.getScene().getWindow();
                stage.close();
            }}
        catch (PersistenceException e){
            ibatisCatcher(e);
        }
        catch (Exception ex){
            Catcher(ex);
        }
    }
    //New way

    public  void Save(RianaValidation rianaValidation, String caller, String AddName, FunctionalInterface mapper, RianaSmartInsert rianaInsert, RianaSmartUpdate rianaUpdate, RianaRefresh rianaRefresh, Button closeButton, Boolean thenClose) throws IOException {
        Validator validator = new Validator();
        rianaValidation.validation(validator);
        if (validator.validate()){
            try {
                SqlSession sqlSession;
                sqlSession = SqlSessionFactoryUtils.openSqlSession();
                mapper=sqlSession.getMapper(mapper.getClass());
                if (caller.equals(AddName)) {
                    rianaInsert.Insert(mapper);
                } else {
                    rianaUpdate.Update(mapper);
                }
                sqlSession.commit();
                sqlSession.close();
                rianaRefresh.Refresh();
                if (thenClose) {
                    Stage stage = (Stage) closeButton.getScene().getWindow();
                    stage.close();
                }
            }
            catch (PersistenceException e){
                ibatisCatcher(e);
            }
            catch (Exception ex){
                Catcher(ex);
            }
        }
    }

//No need to refresh (asynchronous java)
    public  void Save(RianaValidation rianaValidation, String caller, String AddName, FunctionalInterface mapper, RianaSmartInsert rianaInsert, RianaSmartUpdate rianaUpdate, Button closeButton, Boolean thenClose) throws IOException {
        Validator validator = new Validator();
        rianaValidation.validation(validator);
        if (validator.validate()){
            try {
                SqlSession sqlSession;
                sqlSession = SqlSessionFactoryUtils.openSqlSession();
                mapper=sqlSession.getMapper(mapper.getClass());
                if (caller.equals(AddName)) {
                    rianaInsert.Insert(mapper);
                } else {
                    rianaUpdate.Update(mapper);
                }
                sqlSession.commit();
                sqlSession.close();
                if (thenClose) {
                    Stage stage = (Stage) closeButton.getScene().getWindow();
                    stage.close();
                }
            }
            catch (PersistenceException e){
                ibatisCatcher(e);
            }
            catch (Exception ex){
                Catcher(ex);
            }
        }
    }


    //No refresh, simplest form

    public void Save(String caller,String AddName, RianaInsert rianaInsert, RianaUpdate rianaUpdate ,Button closeButton,Boolean thenClose) {
            try {
                SqlSession sqlSession;
                sqlSession = SqlSessionFactoryUtils.openSqlSession();
                if (caller.equals(AddName)) {
                    rianaInsert.Insert(sqlSession);
                } else {
                    rianaUpdate.Update(sqlSession);
                }
                sqlSession.commit();
                sqlSession.close();
                if (thenClose) {
                    Stage stage = (Stage) closeButton.getScene().getWindow();
                    stage.close();
                }
            }
            catch (PersistenceException e){
                ibatisCatcher(e);
            }
            catch (Exception ex){
                Catcher(ex);
            }
    }
    //Raha tsy mila afa-tsy insert ary tsy mila bouton

    public void Save(RianaValidation rianaValidation, RianaInsert rianaInsert, RianaRefresh rianaRefresh) throws IOException {
        Validator validator = new Validator();
        rianaValidation.validation(validator);
        if (validator.validate()){
            try {
                SqlSession sqlSession;
                sqlSession = SqlSessionFactoryUtils.openSqlSession();
                rianaInsert.Insert(sqlSession);
                sqlSession.commit();
                sqlSession.close();
                rianaRefresh.Refresh();
            }
            catch (PersistenceException e){
                ibatisCatcher(e);
            }
            catch (Exception ex){
                Catcher(ex);
            }
        }
    }

//Ho an'ny suite

    public void  Save(RianaValidation rianaValidation, String caller,String AddName, RianaInsert rianaInsert, RianaUpdate rianaUpdate, RianaRefresh rianaRefresh,Button closeButton,RianaNextWindow rianaNextWindow,String nextPath,String nextTitle,Boolean maximize) throws IOException {
        Validator validator = new Validator();
        rianaValidation.validation(validator);
        if (validator.validate()){
            try {
                SqlSession sqlSession;
                sqlSession = SqlSessionFactoryUtils.openSqlSession();
                if (caller.equals(AddName)) {
                    rianaInsert.Insert(sqlSession);
                    //next show
                    rianaNextWindow.NextWindow( nextPath, nextTitle, maximize);
                } else {
                    rianaUpdate.Update(sqlSession);
                    Stage stage = (Stage) closeButton.getScene().getWindow();
                    stage.close();
                }
                sqlSession.commit();
                sqlSession.close();
                rianaRefresh.Refresh();

            }
            catch (PersistenceException e){
                ibatisCatcher(e);
            }
            catch (Exception ex){
                Catcher(ex);
            }

        }
    }

//Ho an'ny suite: raha misy object ny refresh

    public void  Save(RianaValidation rianaValidation, String caller,String AddName, RianaInsert rianaInsert, RianaUpdate rianaUpdate, RianaRefresh rianaRefresh,Button closeButton,RianaNextWindow rianaNextWindow,String nextPath,String nextTitle,Boolean maximize,RianaRefreshWithParam rianaRefreshWithParam,Object param) throws IOException {
        Validator validator = new Validator();
        rianaValidation.validation(validator);
        if (validator.validate()){
            try {
                SqlSession sqlSession;
                sqlSession = SqlSessionFactoryUtils.openSqlSession();
                if (caller.equals(AddName)) {
                    rianaInsert.Insert(sqlSession);
                    //next show
                    rianaNextWindow.NextWindow( nextPath, nextTitle, maximize);
                } else {
                    rianaUpdate.Update(sqlSession);
                    Stage stage = (Stage) closeButton.getScene().getWindow();
                    stage.close();
                }
                sqlSession.commit();
                sqlSession.close();
                rianaRefreshWithParam.Refresh(param);
            }
            catch (PersistenceException e){
                ibatisCatcher(e);
            }
            catch (Exception ex){
                Catcher(ex);
            }
        }
    }

    public void Catcher(Exception ex){
        Alert alert=new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText("Erreur");
        alert.setContentText(ex.getMessage());
        alert.show();
        ex.printStackTrace();
    }


    public void hibernateCatcher(org.hibernate.exception.ConstraintViolationException e){
        e.printStackTrace();
        Alert alert=new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText("Erreur de données");
        Throwable realCause= e.getCause();

        if (realCause.getClass().getName().equals("org.postgresql.util.PSQLException")){
            if (((PSQLException) realCause).getSQLState().equals("28P01")){
                alert.setContentText("Nom utilisateur et/ou Mot de passe incorrect.");
            }
            else if (((PSQLException) realCause).getSQLState().equals("28000")){
                alert.setContentText("pas de nom utilisateur");
            }
            else if (((PSQLException) realCause).getSQLState().equals("23505")){
                alert.setHeaderText("Enregistrement dupliqué.");
                alert.setContentText("Le code de cet enregistrement est déjà en utilisation. Veuillez recommencer et choisir un autre");
            }
            else if (((PSQLException) realCause).getSQLState().equals("23502")){
                alert.setHeaderText("Null interdit.");
                alert.setContentText("Vous avez oublié d'entrer une valeur dans un champ obligatoire");
            }
            else{
                alert.setContentText(realCause.getMessage());
            }
        }
        else{
            alert.setContentText("Nom: "+e.getClass().getName()+" Message "+e.getMessage());
        }
        alert.show();
    }

    public void ibatisCatcher(PersistenceException e){
        e.printStackTrace();
        Alert alert=new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText("Erreur de données");
        Throwable realCause= e.getCause();

        if (realCause.getClass().getName().equals("org.postgresql.util.PSQLException")){
            if (((PSQLException) realCause).getSQLState().equals("28P01")){
                alert.setContentText("Nom utilisateur et/ou Mot de passe incorrect.");
            }
            else if (((PSQLException) realCause).getSQLState().equals("28000")){
                alert.setContentText("pas de nom utilisateur");
            }
            else if (((PSQLException) realCause).getSQLState().equals("23505")){
                alert.setHeaderText("Enregistrement dupliqué.");
                alert.setContentText("Le code de cet enregistrement est déjà en utilisation. Veuillez recommencer et choisir un autre");
            }
            else if (((PSQLException) realCause).getSQLState().equals("23502")){
                alert.setHeaderText("Null interdit.");
                alert.setContentText("Vous avez oublié d'entrer une valeur dans un champ obligatoire");
            }
            else{
                alert.setContentText(realCause.getMessage());
            }
        }
        else{
            alert.setContentText("Nom: "+e.getClass().getName()+" Message "+e.getMessage());
        }
        alert.show();
    }

    public<C> void showList(ListView<C> listView ,Models<C> models, List<C> list, RianaGetName<C> rgn,String refreshPath,Comparator<C> comparator){
        if(models.getMList()!=null)models.getMList().clear();
        if(list!=null)list.clear();
        Refresh(models,refreshPath,comparator);
        listView.setItems(models.getMList());
        listView.getSelectionModel().selectFirst();
    }

    public<C> void showList(ListView<C> listView ,Models<C> models, List<C> list, RianaGetName<C> rgn,String refreshPath,Comparator<C> comparator, Integer codeSuperHierarchy){
        if(models.getMList()!=null)models.getMList().clear();
        if(list!=null)list.clear();
        Refresh(models,refreshPath,comparator,codeSuperHierarchy);
        listView.setItems(models.getMList());
        listView.getSelectionModel().selectFirst();
    }

    public<C> void showList(ListView<C> listView ,ObservableList<C> observableList,RianaGetName<C> rianaGetName){
            listView.itemsProperty().setValue(observableList);
        listView.setCellFactory(listView1 ->{
            Label label=new Label();
            ListCell<C> cell=new ListCell<>(){
                @Override
                public void updateItem(C c,boolean empty){
                    super.updateItem(c,empty);
                    if (empty || c==null){
                        setText(null);
                    }
                    else{
                        setText(rianaGetName.getName(c));

                    }
                }
            };
            return cell;
                });
        listView.getSelectionModel().selectFirst();
    }

    //MfxList

    public<C> void showMfxList(MFXListView<C> listView ,ObservableList<C> observableList, RianaGetName<C> rgn){
        if (listView.getItems()!=null)listView.getItems().clear();

            listView.setItems(observableList);

            StringConverter<C> cStringConverter = new StringConverter<>() {

                @Override
                public String toString(C c) {
                    return rgn.getName(c);
                }

                @Override
                public C fromString(String s) {
                    return null;
                }
            };
            listView.setConverter(cStringConverter);
            if (observableList.size() > 0)
                listView.getSelectionModel().selectIndex(0);

    }
}