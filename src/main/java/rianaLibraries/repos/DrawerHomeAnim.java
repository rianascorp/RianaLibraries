package rianaLibraries.repos;

public class DrawerHomeAnim {

/*
    //HR and stuff

    public void showRh(ActionEvent event) throws  IOException{
    JFXButton PersonnelButton=createLeftButton("Personnel","ci-person", "/main/personnelSubMenu.fxml");
    JFXButton AcademicsButton=createLeftButton("Académiques","fa-university", "/main/academicSubMenu.fxml");
        ArrayList<JFXButton> leftButtons=new ArrayList<>();
        leftButtons.add(0,PersonnelButton);
        leftButtons.add(1,AcademicsButton);

        showToggle(TBRH,leftButtons);
    }

//ACCOUNTNG AND STUFF
    public void showCompta(ActionEvent event) throws IOException{
        JFXButton FinanceButton=createLeftButton("Financière","ci-money", "/main/financeSubMenu.fxml");
        JFXButton MaterialButton=createLeftButton("Matérielle","ci-object-storage", "/main/materialSubMenu.fxml");
        ArrayList<JFXButton> leftButtons=new ArrayList<>();
        leftButtons.add(0,FinanceButton);
        leftButtons.add(1,MaterialButton);

        showToggle(TBCompta,leftButtons);
    }

    //REPORTS and stuff
    public void showReport(ActionEvent event) throws  IOException{
    JFXButton YearlyButton=createLeftButton("Annuel","fa-paper-plane", "/main/yearlySubMenu.fxml");
    JFXButton EventButton=createLeftButton("Evènement","fa-paper-plane", "/main/eventSubMenu.fxml");
    JFXButton BepcButton=createLeftButton("BEPC","fa-paper-plane", "/main/bepcSubMenu.fxml");
        ArrayList<JFXButton> leftButtons=new ArrayList<>();
        leftButtons.add(0,YearlyButton);
        leftButtons.add(1,EventButton);
        leftButtons.add(2,BepcButton);
        showToggle(TBRapports,leftButtons);
    }

    public void showRh(ActionEvent event) {
    System.out.println("wait for your turn");
}

    public void showCompta(ActionEvent event) {
        System.out.println("wait for your turn");
    }

    public void showReport(ActionEvent event) {
        System.out.println("wait for your turn");
    }



    public void showToggle(ToggleButton toggleButton, ArrayList<MenuButton> jfxButtons) {
        if (!TBAdmin.isSelected() && !TBCompta.isSelected() && !TBRH.isSelected() && !TBRapports.isSelected()){
            drawer.close();
        }
            if (toggleButton.isSelected()){
                CenterPane.getChildren().clear();

                //VBox vBox=createVbox();
                //vBox.getChildren().addAll(jfxButtons);
                drawer.getContent().clear();
                drawer.setSidePane(container);
                drawer.open();
            }
                if (!toggleButton.isSelected())
                toggleButton.setSelected(false);
    }

    public void showToggleMenu(ToggleButton toggleButton,VBox vBox) throws IOException{
        if (!TBAdmin.isSelected() && !TBCompta.isSelected() && !TBRH.isSelected() && !TBRapports.isSelected()){
            drawer.close();
        }
        if (toggleButton.isSelected()){
            drawer.getContent().clear();
            drawer.setSidePane(etabMenuButton);
            drawer.open();
        }
        if (!toggleButton.isSelected())
            toggleButton.setSelected(false);
    }


    public JFXButton createLeftButton(String theBtnName,String iconLiteral,String subLoadPath) throws IOException{
    JFXButton theBtn=new JFXButton();
    theBtn.setText(theBtnName);
        theBtn.setPrefHeight(88);
        theBtn.setPrefWidth(100);
        theBtn.getStyleClass().add("btn");
        FontIcon fontIcon=new FontIcon();
        fontIcon.setIconLiteral(iconLiteral);
        fontIcon.setIconSize(34);
        theBtn.setGraphic(fontIcon);
        theBtn.setContentDisplay(ContentDisplay.TOP);
        FXMLLoader gridPaneLoader=new FXMLLoader(getClass().getResource(subLoadPath));
        GridPane gridPane=gridPaneLoader.load();
        CenterPane.getChildren().add(gridPane);
        return theBtn;
    }

    public VBox createVbox(){
        VBox mybox=new VBox();
        //mybox.getStylesheets().add(getClass().getResource("/rianastyle.css").toExternalForm());mybox.getStyleClass().add("vbox");
        //mybox.getStylesheets().add(get)
        mybox.setPrefHeight(424);
        mybox.setPrefWidth(100);
        mybox.setSpacing(1);
        return mybox;
    }

public void removeCenterPaneContent(){
    CenterPane.getChildren().clear();
}


//Drawer with hamburger

 VBox sideBox=new VBox();
        sideBox.setMaxWidth(MAX_VALUE);
        this.sideBox=sideBox;
        //Creating the menubuttons
        calendarMenuButton=createLeftButton("Calendrier","far-calendar-alt",true);
        establishmentMenuButton=createLeftButton("Etablissement","fas-university",false);
        studentMenuButton=createLeftButton("Elèves","fas-user-graduate",true);
        userMenuButton=createLeftButton("Utilisateurs","fas-users-cog",false);
        helpMenuButton=createLeftButton("Aide","fa-question-circle",false);

        sideBox.getChildren().add(userMenuButton);
        sideBox.getChildren().add(establishmentMenuButton);
        sideBox.getChildren().add(calendarMenuButton);
        sideBox.getChildren().add(studentMenuButton);
        sideBox.getChildren().add(helpMenuButton);



      userMenuButton.setOnAction((ActionEvent event)->{
            try {
                this.showUsers(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        establishmentMenuButton.setOnAction((ActionEvent event)->{
            try {
                this.showEstablishmentMenu(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

       calendarMenuButton.setOnAction((ActionEvent event)->{
            try {
                this.showCalendarMenu(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    studentMenuButton.setOnAction((ActionEvent event)->{
            try {
                this.showStudentMenu(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        helpMenuButton.setOnAction((ActionEvent event)->{
           System.out.println("mbola vao atao");
        });

        //Hamburger
        HamburgerBackArrowBasicTransition hbat=new HamburgerBackArrowBasicTransition(myHam);
        hbat.setRate(-1);
        myDrawer.setSidePane(sideBox);

        myHam.addEventHandler(MouseEvent.MOUSE_PRESSED,(e)->{
            hbat.setRate(hbat.getRate()*-1);
            hbat.play();

            if(myDrawer.isOpened()){
                myDrawer.close();
            }
            else {
                myDrawer.open();
            }
        });



 public JFXButton createLeftButton(String theBtnName,String iconLiteral,boolean parent) throws IOException{
        JFXButton theBtn=new JFXButton();
        Label label=new Label(theBtnName);
        //theBtn.setPrefHeight(88);
        //theBtn.setPrefWidth(100);
        theBtn.getStyleClass().add("menuItem");
        FontIcon fontIcon=new FontIcon();
        fontIcon.setIconLiteral(iconLiteral);
        fontIcon.setIconSize(8);
        theBtn.setGraphic(fontIcon);
        theBtn.setContentDisplay(ContentDisplay.LEFT);
        //theBtn.setPrefWidth(100);
        FontIcon caret=new FontIcon("fa-caret-right");
        caret.setIconSize(8);
        HBox hBox=new HBox();
        hBox.getChildren().add(0,fontIcon);
        hBox.getChildren().add(1,label);
        if (parent){
            //hBox.getChildren().add(2,caret);
            //hBox.getChildren().get(2).
            //caret.setTextAlignment(TextAlignment.RIGHT);
            //caret.setWrappingWidth(sideBox.getLayoutX()-caret.getLayoutX());
        }
        theBtn.setGraphic(hBox);
        theBtn.setMaxWidth(MAX_VALUE);
        return theBtn;
    }
*/
}
