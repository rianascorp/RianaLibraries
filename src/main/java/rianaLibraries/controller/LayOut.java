package rianaLibraries.controller;


import io.github.palexdev.materialfx.dialogs.MFXGenericDialog;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import org.kordamp.ikonli.javafx.FontIcon;

import java.util.ArrayList;

public class LayOut {
    public ArrayList<Object> deleteLayout(StackPane root, Label Header, Label Body, FontIcon fontIcon){
        Button OKButton=new Button("Supprimer");
        OKButton.getStyleClass().setAll("btn-sm","btn-danger");

        Button CancelButton=new Button("Cancel");
        CancelButton.getStyleClass().setAll("btn-sm","btn-default");


        //FontIcon fontIcon=new FontIcon("fa-exclamation-triangle");
        fontIcon.setIconSize(34);
        fontIcon.setIconColor(Paint.valueOf("orange"));
        Body.setGraphic(fontIcon);

        MFXGenericDialog dialogLayout=new MFXGenericDialog();
        dialogLayout.setHeaderText(Header.getText());
        dialogLayout.setContent(Body);
        dialogLayout.addActions(CancelButton,OKButton);
        dialogLayout.setPrefSize(300,200);
        dialogLayout.setLayoutX(5);
        dialogLayout.setLayoutY(5);

        ArrayList<Object> buttonArrayList=new ArrayList<>();
        buttonArrayList.add(0,OKButton);
        buttonArrayList.add(1,CancelButton);
        buttonArrayList.add(2,dialogLayout);

        return buttonArrayList;
    }

}
