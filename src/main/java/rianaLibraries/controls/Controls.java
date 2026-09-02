package rianaLibraries.controls;

import io.github.palexdev.materialfx.controls.*;


import io.github.palexdev.materialfx.dialogs.MFXGenericDialog;
import javafx.collections.FXCollections;
import javafx.geometry.Orientation;
import rianaLibraries.model.Models;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import javafx.util.StringConverter;
import org.kordamp.ikonli.javafx.FontIcon;

public class Controls {



    public MFXGenericDialog rianaOkCancelDialogLayout(String Title, String labelDescription, String dFontIcon, String dFontIconColor, String OkButtonName, String OkBtnColor){
        Button OKButton=new Button(OkButtonName);
        Button CancelButton=new Button("Fermer");
        MFXGenericDialog dialogLayout=new MFXGenericDialog();
        final Label Titre=new Label(Title);
        final Label Description=new Label(labelDescription);
        FontIcon fontIcon=new FontIcon(dFontIcon);
        fontIcon.setIconSize(34);
        fontIcon.setIconColor(Paint.valueOf(dFontIconColor));
        Description.setGraphic(fontIcon);
        dialogLayout.setHeaderText(Title);
        dialogLayout.setContent(Description);
        dialogLayout.setActionsOrientation(Orientation.HORIZONTAL);
        dialogLayout.addActions(OKButton,CancelButton);
        dialogLayout.setPrefSize(400,200);
        dialogLayout.setLayoutX(5);
        dialogLayout.setLayoutY(5);

        return dialogLayout;
    }

    // COMBOS
    // MFXCombos
    public <M> void initializeMfxCombo(MFXComboBox<M> comboBox,Models<M> models,RianaGetName<M> rgn){
        comboBox.setItems(models.getMList());
        comboBox.setConverter(new StringConverter<M>() {
            @Override
            public String toString(M m) {
                if (m==null || rgn.getName(m).isEmpty() || rgn.getName(m).isBlank()) {
                    return null;
                }
            else{
                return rgn.getName(m);
                }
            }
            @Override
            public M fromString(String s) {
                return null;
            }
        });

        comboBox.getSelectionModel().selectFirst();
        models.setCurrent(comboBox.getSelectionModel().getSelectedItem());
        comboBox.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection)->models.setCurrent(newSelection));
    }


    public <M> void initializeMfxCombo(MFXComboBox<M> comboBox,Models<M> models,  RianaGetName<M> rgn,RianaGetCode<M> rgc, Integer code) throws NoSuchMethodException {

        comboBox.setItems(models.getMList());
        comboBox.setConverter(new StringConverter<M>() {
            @Override
            public String toString(M m) {
                if (m==null || rgn.getName(m).isEmpty() || rgn.getName(m).isBlank()) {
                    return null;
                }
                else{
                    return rgn.getName(m);
                }
            }
            @Override
            public M fromString(String s) {
                return null;
            }
        });

        comboBox.getSelectionModel().selectFirst();
        //models.setCurrent(comboBox.getSelectionModel().getSelectedItem());
        comboBox.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection)->models.setCurrent(newSelection));
        selectMfxComboValue(comboBox,code,((m, integer) -> rgc.getCode(m).equals(integer)));
        models.setCurrent(comboBox.getValue());
    }

    public static <T> void selectMfxComboValue(MFXComboBox<T> comboBox, Integer value, Func<T, Integer> f) {
        for (T t : comboBox.getItems()) {
            if (f.compare(t, value)) {
                comboBox.setValue(t);
            }
        }
    }


    public <M> void initializeMfxCombo(MFXComboBox<M> comboBox,Models<M> models,  RianaGetName<M> rgn,RianaLongGetCode<M> rlgc, Long code) throws NoSuchMethodException {

        comboBox.setItems(models.getMList());
        comboBox.setConverter(new StringConverter<M>() {
            @Override
            public String toString(M m) {
                if (m==null || rgn.getName(m).isEmpty() || rgn.getName(m).isBlank()) {
                    return null;
                }
                else{
                    return rgn.getName(m);
                }
            }
            @Override
            public M fromString(String s) {
                return null;
            }
        });

        comboBox.getSelectionModel().selectFirst();
        //models.setCurrent(comboBox.getSelectionModel().getSelectedItem());
        comboBox.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection)->models.setCurrent(newSelection));
        selectMfxComboValue(comboBox,code,((m, Long) -> rlgc.getCode(m).equals(Long)));
        models.setCurrent(comboBox.getValue());
    }

    public static <T> void selectMfxComboValue(MFXComboBox<T> comboBox, Long value, Func<T, Long> f) {
        for (T t : comboBox.getItems()) {
            if (f.compare(t, value)) {
                comboBox.setValue(t);
            }
        }
    }



    public <M> void initializeMfxStringCodeCombo(MFXComboBox<M> comboBox, Models<M> models, RianaGetName<M> rgn, RianaGetName <M> rgn2, String code) {

        comboBox.setItems(models.getMList());
        comboBox.setConverter(new StringConverter<M>() {
            @Override
            public String toString(M m) {
                if (m==null || rgn.getName(m).isEmpty() || rgn.getName(m).isBlank()) {
                    return null;
                }
                else{
                    return rgn.getName(m);
                }
            }
            @Override
            public M fromString(String s) {
                return null;
            }
        });

        comboBox.getSelectionModel().selectFirst();
        comboBox.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection)->models.setCurrent(newSelection));
        selectMfxStringComboValue(comboBox,code,((m, string) -> rgn2.getName(m).equals(string)));
        models.setCurrent(comboBox.getValue());
    }

    public static <T> void selectMfxStringComboValue(MFXComboBox<T> comboBox, String value, Func<T, String> f) {
        for (T t : comboBox.getItems()) {
            if (f.compare(t, value)) {
                comboBox.setValue(t);
            }
        }
    }

    //Combos

    public <M> void initializeCombo(MFXComboBox<M> comboBox,Models<M> models,RianaGetName<M> rgn){
        comboBox.setItems(models.getMList());
        comboBox.setConverter(new StringConverter<M>() {
            @Override
            public String toString(M m) {
                if (m==null || rgn.getName(m).isEmpty() || rgn.getName(m).isBlank()) {
                    return null;
                }
                else{
                    return rgn.getName(m);
                }
            }
            @Override
            public M fromString(String s) {
                return null;
            }
        });

        comboBox.getSelectionModel().selectFirst();
        models.setCurrent(comboBox.getSelectionModel().getSelectedItem());
        comboBox.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection)->models.setCurrent(newSelection));
    }


    public <M> void initializeCombo(ComboBox<M> comboBox,Models<M> models,RianaGetName<M> rgn){
        comboBox.setItems(models.getMList());
        comboBox.setConverter(new StringConverter<>() {
            @Override
            public String toString(M m) {

                if (m == null || rgn.getName(m).isEmpty() || rgn.getName(m).isBlank() || rgn.getName(m)==null) {
                    return null;
                } else {
                    return rgn.getName(m);
                }
            }

            @Override
            public M fromString(String s) {
                return null;
            }
        });
            comboBox.getSelectionModel().selectFirst();
            models.setCurrent(comboBox.getSelectionModel().getSelectedItem());
            comboBox.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> models.setCurrent(newSelection));
    }

    public <M> void initializeComboWithNumber(ComboBox<M> comboBox,Models<M> models,RianaLongGetCode<M> rlgc){
        comboBox.setItems(models.getMList());
        comboBox.setConverter(new StringConverter<>() {
            @Override
            public String toString(M m) {

                if (m == null) {
                    return null;
                } else {
                    return rlgc.getCode(m).toString();
                }
            }

            @Override
            public M fromString(String s) {
                M result = null;
               for (M m :models.getMList()){
                   if (rlgc.getCode(m).toString().equals(s)){
                       result= m;
                   }
               }
               return result;
            }
        });
        //comboBox.getSelectionModel().selectFirst();
        models.setCurrent(comboBox.getSelectionModel().getSelectedItem());
        comboBox.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> models.setCurrent(newSelection));
    }

    public <M> void initializeFilteredCombo(ComboBox<M> comboBox,Models<M> models,RianaGetName<M> rgn){
        comboBox.setItems(models.getFilteredList());
        comboBox.setConverter(new StringConverter<M>() {
            @Override
            public String toString(M m) {
                if (m==null || rgn.getName(m).isEmpty() || rgn.getName(m).isBlank()) {
                    return null;
                }
                else{
                    return rgn.getName(m);
                }
            }
            @Override
            public M fromString(String s) {
                return null;
            }
        });

        comboBox.getSelectionModel().selectFirst();
        models.setCurrent(comboBox.getSelectionModel().getSelectedItem());
        comboBox.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection)->models.setCurrent(newSelection));
    }




    public <M> void initializeCombo(ComboBox<M> comboBox,Models<M> models,  RianaGetName<M> rgn,RianaGetCode<M> rgc, Integer code) throws NoSuchMethodException {

        comboBox.setItems(models.getMList());
        comboBox.setConverter(new StringConverter<M>() {
            @Override
            public String toString(M m) {
                if (m==null || rgn.getName(m).isEmpty() || rgn.getName(m).isBlank()) {
                    return null;
                }
                else{
                    return rgn.getName(m);
                }
            }
            @Override
            public M fromString(String s) {
                return null;
            }
        });

        comboBox.getSelectionModel().selectFirst();
        models.setCurrent(comboBox.getSelectionModel().getSelectedItem());
        comboBox.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection)->models.setCurrent(newSelection));
        selectComboValue(comboBox,code,(m, integer) -> rgc.getCode(m).equals(integer));
    }


    public <M,T> void initializeCombo(ComboBox<M> comboBox, Models<M> models, RianaGetName<M> rgn, RianaLongGetCode<M> rlgc, Long code) throws NoSuchMethodException {

        comboBox.setItems(models.getMList());
        comboBox.setConverter(new StringConverter<M>() {
            @Override
            public String toString(M m) {

                if (m==null || rgn.getName(m)==null || rgn.getName(m).isEmpty() || rgn.getName(m).isBlank()) {
                    return null;
                }
                else{
                    return rgn.getName(m);
                }
            }

            @Override
            public M fromString(String s) {
                return null;
            }
        });
        comboBox.getSelectionModel().selectFirst();
        models.setCurrent(comboBox.getSelectionModel().getSelectedItem());
        selectComboValue(comboBox,code,(m, v) -> rlgc.getCode(m).equals(v));
        comboBox.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection)->models.setCurrent(newSelection));
    }

    public <M> void initializeComboWithNumber(ComboBox<M> comboBox,Models<M> models,RianaLongGetCode<M> rlgc, Long code){
        comboBox.setItems(models.getMList());
        comboBox.setConverter(new StringConverter<>() {
            @Override
            public String toString(M m) {

                if (m == null) {
                    return null;
                } else {
                    return rlgc.getCode(m).toString();
                }
            }

            @Override
            public M fromString(String s) {
                M result = null;
                for (M m :models.getMList()){
                    if (rlgc.getCode(m).toString().equals(s)){
                        result= m;
                    }
                }
                return result;
            }
        });
        comboBox.getSelectionModel().selectFirst();
        models.setCurrent(comboBox.getSelectionModel().getSelectedItem());
        selectComboValue(comboBox,code,(m, v) -> rlgc.getCode(m).equals(v));
        comboBox.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> models.setCurrent(newSelection));
    }


    public static <T> void selectComboValue(ComboBox<T> comboBox, Integer value, Func<T, Integer> f) {
        for (T t : comboBox.getItems()) {
            if (f.compare(t, value)) {
                comboBox.setValue(t);
        }}
    }



    public static <T> void selectComboValue(ComboBox<T> comboBox, Long value, Func<T, Long> f) {

      if (value==null){
          comboBox.setValue(null);
      }
      else{
        for (T t : comboBox.getItems()) {
            if (f.compare(t, value)) {
                comboBox.setValue(t);
            }
        }}
    }

    public <M> void initializeStringCodeCombo(ComboBox<M> comboBox, Models<M> models, RianaGetName<M> rgn, RianaGetName <M> rgn2, String code) {

        comboBox.setItems(models.getMList());
        comboBox.setConverter(new StringConverter<M>() {
            @Override
            public String toString(M m) {
                if (m==null || rgn.getName(m).isEmpty() || rgn.getName(m).isBlank()) {
                    return null;
                }
                else{
                    return rgn.getName(m);
                }
            }
            @Override
            public M fromString(String s) {
                return null;
            }
        });

        comboBox.getSelectionModel().selectFirst();
        models.setCurrent(comboBox.getSelectionModel().getSelectedItem());
        comboBox.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection)->models.setCurrent(newSelection));
        selectStringComboValue(comboBox,code,((m, string) -> rgn2.getName(m).equals(string)));
    }

    public static <T> void selectStringComboValue(ComboBox<T> comboBox, String value, Func<T, String> f) {
        for (T t : comboBox.getItems()) {
            if (f.compare(t, value)) {
                comboBox.setValue(t);
            }
        }
    }

}