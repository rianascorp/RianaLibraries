package rianaLibraries.repos;

public class Alert {

      /*Optional<ButtonType> result=alert.showAndWait();
        if (result.isPresent() && result.get()==ButtonType.OK){
            SqlSession sqlSession;
            sqlSession= SqlSessionFactoryUtils.openSqlSession();
            NewPersonnelMapper newPersonnelMapper=sqlSession.getMapper(NewPersonnelMapper.class);
            newPersonnelMapper.deletePersonnel(personnel.getCodePers());
            sqlSession.commit();
            sqlSession.close();

            Close();
        }*/

        /*
        alert.showAndWait();
        if(alert.getResult()==ButtonType.OK){
            SqlSession sqlSession;
            sqlSession= SqlSessionFactoryUtils.openSqlSession();
            NewPersonnelMapper newPersonnelMapper=sqlSession.getMapper(NewPersonnelMapper.class);
            newPersonnelMapper.deletePersonnel(personnel.getCodePers());
            sqlSession.commit();
            sqlSession.close();
            Close();
            alert.close();
        }*/

    /*
    *   Button OKButton=new Button("Supprimer");
            Button CancelButton=new Button("Cancel");
            TypePeriode typePeriode= model.getCurrent();
           JFXDialogLayout dialogLayout=new JFXDialogLayout();
           final Label Titre=new Label("Voulez-vous vraiment supprimer?");
           final Label Description=new Label("Attention, si vous cliquez sur supprimer, l'enregistrement sera supprimé!");
           FontIcon fontIcon=new FontIcon("fa-exclamation-triangle");
           fontIcon.setIconSize(34);
           fontIcon.setIconColor(Paint.valueOf("orange"));
           Description.setGraphic(fontIcon);
           dialogLayout.setHeading(Titre);
           dialogLayout.setBody(Description);
           dialogLayout.setActions(CancelButton,OKButton);

            JFXDialog dialog=new JFXDialog();
            dialog.setDialogContainer(root);
            dialogLayout.setPrefSize(300,200);
            dialogLayout.setLayoutX(5);
            dialogLayout.setLayoutY(5);
            dialog.setContent(dialogLayout);
            dialog.setTransitionType(JFXDialog.DialogTransition.TOP);
            dialog.setOverlayClose(false);


            OKButton.getStyleClass().setAll("btn-sm","btn-danger");

            CancelButton.getStyleClass().setAll("btn-sm","btn-default");

            CancelButton.setOnAction(action->dialog.close());
           OKButton.setOnAction(action->{SqlSession sqlSession;
               sqlSession= SqlSessionFactoryUtils.openSqlSession();
               TypePeriodeMapper type_periodeMapper=sqlSession.getMapper(TypePeriodeMapper.class);
               type_periodeMapper.deleteTypePeriode(typePeriode.getId());
               sqlSession.commit();
               sqlSession.close();
               Refresh();
                dialog.close();});

            dialog.show();*/
}
