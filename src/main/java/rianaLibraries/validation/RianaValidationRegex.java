package rianaLibraries.validation;


import io.github.palexdev.materialfx.controls.*;
import io.github.palexdev.materialfx.utils.others.dates.DateStringConverter;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.control.*;
import net.synedra.validatorfx.Check;
import net.synedra.validatorfx.Validator;
import rianaLibraries.controls.RianaGetCode;
import rianaLibraries.controls.RianaGetName;
import rianaLibraries.controls.RianaLongGetCode;
import rianaLibraries.model.Models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.FormatStyle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RianaValidationRegex {

    RianaDecoration rianaDecoration;

    public RianaValidationRegex(){
        rianaDecoration=new RianaDecoration();
    }



    //**** FUNCTIONS

    private boolean isBlank(String string){
        boolean result;
        final String BLANK="[\\s\\S]+";

        if (string==null) {
            return  true;
        }
        else{
            if(string.matches(BLANK)){
                result=false;
            }
            else{
                result=true;
            }
            return result;
        }
    }

    //This is only for japs


    public void checkTempId (String text, Integer houseHoldId, Check.Context c, Language language){
        final String temp="[A-Z][\\d]{3}";
        String message=null;
        if(houseHoldId>=700){
            if (!text.matches(temp)){
                switch (language){
                    case MALAGASY -> message="Ataovy X###.";
                    case FRENCH -> message="Le format est X###.";
                    case ENGLISH -> message="The format is X###.";
                }
                c.error(message);
            }
        }
    }


    public void checkYesNo(String text,Check.Context c,Language language){
        final String temp="[1-2]|88|98|99";
        String message=new String();
        switch (language){
            case MALAGASY -> message="Na 1 na 2 na 88 na 98 na 99.";
            case FRENCH -> message="Mettez 1 ou 2 ou 88 ou 98 ou 99.";
            case ENGLISH -> message="Insert 1 or 2 or 88 or 98 or 99.";
        }
        if (!(text.matches(temp))){
            c.error(message);
        }
    }


    public void checkYesNoNullable(TextField textField,Check.Context c,Language language){
        final String temp="[1-2]|88|98|99";
        String message=new String();
        switch (language){
            case MALAGASY -> message="Na 1 na 2 na 88 na 98 na 99.";
            case FRENCH -> message="Mettez 1 ou 2 ou 88 ou 98 ou 99.";
            case ENGLISH -> message="Insert 1 or 2 or 88 or 98 or 99.";
        }
        if (!(textField.getText().isBlank() || textField.getText().isEmpty()))
            if (!(textField.getText().matches(temp))){
            c.error(message);
        }
    }


    public void checkRelation (String text,Check.Context c,Language language){
        final String temp="[0-1][0-9]";
        final String temp2="[8-9][8-9]";
        String message=new String();
        switch (language){
            case MALAGASY -> message="Misy diso ny tarehimarika.";
            case FRENCH -> message="Erreur dans le format.";
            case ENGLISH -> message="Format error.";
        }
        if (!(text.matches(temp) || text.matches(temp2))){
            c.error(message);
        }
    }

    public <M> void checkDuplicate(Check.Context c,String code, Models<M> models,String Reference,Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message="Efa niasa io kaody io.";
            case FRENCH -> message="Ce code est déjà utilisé.";
            case ENGLISH -> message="Duplicate code.";
        }

        for (M m:models.getMList()){
            if (code.equals(Reference)){
                c.error(message);
            }
        }
    }

    public boolean hourCheck(String input){
        final String DATE_PATTERN="[0-2][0-9]:[0-6][0-9]";
        boolean answer=input.matches(DATE_PATTERN);
        return answer;
    }

    public boolean weightCheck(String input){
        final String WEIGHT_PATTERN="[0-9]{2}\\.[0-9]{2}";
        boolean answer=input.matches(WEIGHT_PATTERN);
        return answer;
    }

    public boolean heightCheck(String input){
        final String HEIGHT_PATTERN="[0-9]{3}";
        boolean answer=input.matches(HEIGHT_PATTERN);
        return answer;
    }


    public boolean dayCheck(String input){
        final String DATE_PATTERN="[0-3;9][0-9]";
        boolean answer=input.matches(DATE_PATTERN);
        return answer;
    }


    public boolean monthCheck(String input){
        final String DATE_PATTERN="[0-1;9][0-9]";
        boolean answer=input.matches(DATE_PATTERN);
        return answer;
    }

    public boolean yearCheck(String input){
        final String DATE_PATTERN="[1-2][0;9][0-9][0-9]";
        final String PATTERN2="[9][9]";
        boolean answer=input.matches(DATE_PATTERN) || input.matches(PATTERN2);
        return answer;
    }

    //*** USED WITH CONTROLS

    //** DEFAULT CONTROLS

    public void checkBlank(Check.Context c, TextField node,Language language){
        if (isBlank(node.getText())){
            String message=new String();
            switch (language){
                case MALAGASY -> message="Mila valiny.";
                case FRENCH -> message="Champ obligatoire.";
                case ENGLISH -> message="Mandatory field.";
            }
            c.error(message);
        }
    }

    public void checkBlankLabel(Check.Context c, Label node,Language language, String name){
        String message=new String();
        switch (language){
            case MALAGASY -> message="Misafidiana";
            case FRENCH -> message="Veuillez choisir un";
            case ENGLISH -> message="Please, choose a ";
        }
        if (isBlank(node.getText())){
            c.error(message+" "+name+".");
        }
    }

    //Used in japs
    public void checkFalseCheck(Check.Context c,CheckBox checkBox,Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message="Mila marihana.";
            case FRENCH -> message="Veuillez cocher.";
            case ENGLISH -> message="Please, tick.";
        }
        if (!checkBox.isSelected()){
            c.error(message);
        }
    }
    //Used in japs
    public void checkDoubleFalseCheck(Check.Context c,CheckBox checkBox1,CheckBox checkBox2,Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message="Iray ihany no marihana.";
            case FRENCH -> message="Veuillez cocher une seule case.";
            case ENGLISH -> message="Please, tick only one checkbox.";
        }
        if (checkBox1.isSelected() && checkBox2.isSelected()){
            c.error(message);
        }
    }

    public void checkDate(Check.Context c, DatePicker datePicker,Language language){

        String message=new String();
        switch (language){
            case MALAGASY -> message="Daty jj/mm/aaaa no eto.";
            case FRENCH -> message="Entrez une date de format jj/mm/aaaa.";
            case ENGLISH -> message="Please, enter a date format dd/mm/yyyy.";
        }
        if(dateCheck(datePicker.getEditor().getText())==false){
            c.error(message);
        }
    }

    public void checkMfxDate(Check.Context c, MFXDatePicker datePicker,Language language){
            datePicker.setConverterSupplier(() -> new DateStringConverter(FormatStyle.SHORT));
        String message=new String();
        switch (language){
            case MALAGASY -> message="Daty jj/mm/aaaa no eto.";
            case FRENCH -> message="Entrez une date de format jj/mm/aaaa.";
            case ENGLISH -> message="Please, enter a date format dd/mm/yyyy.";
        }
        if(dateCheck(datePicker.getText()) ==false){
            c.error(message);
        }
    }

    public void checkBlankCombo(Check.Context c, ComboBox comboBox, Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message="Mila fenoina eto.";
            case FRENCH -> message="Ce champ est obligatoire.";
            case ENGLISH -> message="This field is mandatory.";
        }
        if (comboBox.getSelectionModel().isEmpty())c.error(message);
    }

    public void checkDateNullable(Check.Context c, DatePicker datePicker,Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message="Daty jj/mm/aaaa no eto.";
            case FRENCH -> message="Entrez une date de format jj/mm/aaaa.";
            case ENGLISH -> message="Please, enter a date format dd/mm/yyyy.";
        }
        if (!isBlank(datePicker.getEditor().getText()))
            if(dateCheck(datePicker.getEditor().getText())==false){
                c.error(message);
                //Entrez une date de format jj/mm/aaaa
            }
    }

    public void checkMfxDateNullable(Check.Context c, MFXDatePicker datePicker,Language language){
        datePicker.setConverterSupplier(() -> new DateStringConverter(FormatStyle.SHORT));
        String message=new String();
        switch (language){
            case MALAGASY -> message="Daty jj/mm/aaaa no eto.";
            case FRENCH -> message="Entrez une date de format jj/mm/aaaa.";
            case ENGLISH -> message="Please, enter a date format dd/mm/yyyy.";
        }
        if (!isBlank(datePicker.getText()))
            if(dateCheck(datePicker.getText())==false){
                c.error(message);
                //Entrez une date de format jj/mm/aaaa
            }
    }

    public boolean dateCheck(String input){
        final String DATE_PATTERN="[0-3][0-9]/[0-1][0-9]/[0-9]{4}";
        boolean answer=input.matches(DATE_PATTERN);
        return answer;
    }



    public void checkDay(Check.Context c,TextField textField,Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message="Diso ny daty, ataovy ##.";
            case FRENCH -> message="La date est incorrecte, le format est ##.";
            case ENGLISH -> message="Incorrect date, enter a ## format.";
        }
        if (!dayCheck(textField.getText())){
            c.error(message);
        }
    }



    public void checkMonth(Check.Context c,TextField textField,Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message="Diso ny volana, ataovy ##.";
            case FRENCH -> message="Le mois est incorrect, le format est ##.";
            case ENGLISH -> message="Incorrect month, enter a ## format.";
        }
        if (!monthCheck(textField.getText())){
            c.error(message);
        }
    }


    public void checkYear(Check.Context c,TextField textField,Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message="Diso ny taona, ataovy ####.";
            case FRENCH -> message="L'année est incorrecte, le format est ####.";
            case ENGLISH -> message="Incorrect year, enter a #### format.";
        }
        if (!yearCheck(textField.getText())){
            c.error(message);
        }
    }

    public void checkHourAfter(Check.Context c,TextField textField1,TextField textField2,Language language)
    {
        String message=new String();
        switch (language){
            case MALAGASY -> message="Mifamadika ny ora.";
            case FRENCH -> message="Les valeurs d'heures sont échangées.";
            case ENGLISH -> message="Hour values are exchanged.";
        }

        if (hourCheck(textField1.getText()) && hourCheck(textField2.getText())){
            if (LocalTime.parse(textField2.getText()).isBefore(LocalTime.parse(textField1.getText()))){
                c.error(message);
            }
        }
    }

    public void checkHour(Check.Context c,TextField textField,Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message="Diso ny ora, ataovy hh:mm.";
            case FRENCH -> message="La valeur de date est incorrecte, le format est hh:mm";
            case ENGLISH -> message="Incorrect date values, enter a hh:mm format.";
        }
        if (!hourCheck(textField.getText())){
            c.error(message);
        }
    }

    public void checkHeight(Check.Context c,TextField textField,Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message="Diso ny refy, ataovy ###.";
            case FRENCH -> message="La valeur de masure est incorrecte, le format est ###";
            case ENGLISH -> message="Incorrect height values, enter a ### format.";
        }
        if (!textField.getText().isEmpty() || !textField.getText().isBlank())
            if (!heightCheck(textField.getText())){
            c.error(message);
        }
    }

    public void checkWeight(Check.Context c,TextField textField,Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message="Diso ny lanja, ataovy ##.## .";
            case FRENCH -> message="La valeur de poids est incorrecte, le format est ##.##";
            case ENGLISH -> message="Incorrect weight values, enter a ##.## format.";
        }
        if (!textField.getText().isEmpty() || !textField.getText().isBlank())
        if (!weightCheck(textField.getText())){
            c.error(message);
        }
    }


    public void checkDateAfter(Check.Context c,DatePicker datePicker1,DatePicker datePicker2,Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message="Mifamadika ny daty.";
            case FRENCH -> message="Les valeurs de dates sont échangées.";
            case ENGLISH -> message="Date values are exchanged.";
        }
        if (dateCheck(datePicker1.getEditor().getText()) && dateCheck(datePicker2.getEditor().getText())){
            if (datePicker2.getValue().isBefore(datePicker1.getValue())){
                c.error(message);
            }
        }
    }

    public void checkDatesOutOfbounds(Check.Context c,DatePicker min, DatePicker max,DatePicker date,Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message="Ivelan'ny fetra ny daty.";
            case FRENCH -> message="La date est hors limite.";
            case ENGLISH -> message="The date is out of bond.";
        }

        if (dateCheck(date.getEditor().getText()) && dateCheck(min.getEditor().getText()) && dateCheck(max.getEditor().getText()))
            if (date.getValue().isBefore(min.getValue()) || date.getValue().isAfter(max.getValue())){
                c.error(message);
            }
    }

    public void checkCustomDatesOutOfBounds(Check.Context c, LocalDate min, LocalDate max, DatePicker date, Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message="Ivelan'ny fetra ny daty.";
            case FRENCH -> message="La date est hors limite.";
            case ENGLISH -> message="The date is out of bond.";
        }

        if (dateCheck(date.getEditor().getText()))
            if (date.getValue().isBefore(min) || date.getValue().isAfter(max)){
                c.error(message);
            }
    }

    public void checkOneSix(Check.Context c,TextField field,Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message="Tarehimarika 1-6.";
            case FRENCH -> message="Entrez un nombre entre [1 - 6].";
            case ENGLISH -> message="Enter a digit [1 - 6].";
        }
        final String PATTERN="[1-6]";
        if (!field.getText().matches(PATTERN))c.error(message);
    }

    public void checkMail(Check.Context c,MFXTextField field,Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message="Tsy mety ny adresy mailaka.";
            case FRENCH -> message="L'adresse mail n'est pas valide.";
            case ENGLISH -> message="The mail adress is not valid.";
        }
        final String PATTERN="^([a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,})$";
        if (!field.getText().matches(PATTERN)){
            c.error(message);
        }
    }

    public void checkIdCard(Check.Context c,MFXTextField field,Language language){
        String message=new String();

        switch (language){
            case MALAGASY -> message="Mampidira tarehi-marika 12.";
            case FRENCH -> message="Entrez 12 chiffres.";
            case ENGLISH -> message="Enter 12 digits.";
        }

        final String PATTERN="[\\d]{12}";
        if (!field.getText().matches(PATTERN)){
            c.error(message);
        }
    }

    public void checkTextFieldLength(Check.Context c,TextField field,Integer number,Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message="Ny isan'ny teny dia tsy mihoatra ny";
            case FRENCH -> message="Le maximum de mots est";
            case ENGLISH -> message="The maximum word count is";
        }
        if (field.getLength()>number){
            c.error(message+" "+number+".");
        }
    }



    public void checkNumber(Check.Context c, TextField field,Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message="Mampidira tarehimarika.";
            case FRENCH -> message="Entrez un nombre entier valide.";
            case ENGLISH -> message="Enter a valid digit.";
        }

        String NumPattern="[\\d]+";
        if (!field.getText().matches(NumPattern)){
            c.error(message);
        }
    }

    public void checkGender(Check.Context c,TextField field,Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message="Mampidira tarehimarika 1 na 2.";
            case FRENCH -> message="Entrez un nombre entier 1 ou 2.";
            case ENGLISH -> message="Enter a number 1 or 2.";
        }

        String NumPattern="[1-2]";
        if (!field.getText().matches(NumPattern)){
            c.error(message);
        }
    }

    //Ity hoe raha vehivavy ihany vao tokony hisy propriété checked ohatra hoe fadimbolana

    public void checkGenderConditional(Check.Context c,TextField field,Integer value,CheckBox checkBox,Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message="Tsy mifanaraka amin'ny sekisa";
            case FRENCH -> message="N'est pas conforme au sexe";
            case ENGLISH -> message="Not suitable for this gender";
        }


        if (Integer.parseInt(field.getText())!=value && checkBox.isSelected()){
            c.error(message);
        }
    }



    public void checkDouble(Check.Context c,TextField field,Language language){

        String message=new String();
        switch (language){
            case MALAGASY -> message="Mampidira tarehimarika lehibe.";
            case FRENCH -> message="Entrez un nombre double valide.";
            case ENGLISH -> message="Enter a valid double.";
        }
        try{
            Double.parseDouble(field.getText());
        } catch (NumberFormatException e) {
            c.error(message);
        }
    }

    public void checkDoubleNullable(Check.Context c,TextField field,Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message="Mampidira tarehimarika lehibe na tsy misy.";
            case FRENCH -> message="Entrez un nombre double valide ou rien.";
            case ENGLISH -> message="Enter a valid double or leave blank.";
        }

        if (!(field.getText().isBlank() || field.getText().isEmpty())){
            try{
                Double.parseDouble(field.getText());
            } catch (NumberFormatException e) {
                c.error(message);
            }
        }
    }

    public void checkFloatNullable(Check.Context c, TextField field, Language language){
        String message;
        switch (language){
            case MALAGASY -> message = "Mampidira isa tafolo amam-paingo na tsy misy.";
            case FRENCH -> message = "Entrez un décimal valide ou rien.";
            case ENGLISH -> message = "Enter a valid decimal or leave blank.";
            default -> message = "Enter a valid decimal or leave blank.";
        }

        String text = field.getText();
        if (text == null || text.trim().isEmpty()) {
            return;
        }

        // Accepts: 123, 123.45, 123,45, -123.45
        String FLOAT_PATTERN = "^-?\\d+(?:[.,]\\d+)?$";
        if (!text.trim().matches(FLOAT_PATTERN)) {
            c.error(message);
        }
    }

    public void checkFloat(Check.Context c, TextField field, Language language){
        String message;
        switch (language){
            case MALAGASY -> message = "Mampidira isa tafolo amam-paingo.";
            case FRENCH -> message = "Entrez un décimal valide.";
            case ENGLISH -> message = "Enter a valid decimal.";
            default -> message = "Enter a valid decimal.";
        }

        String text = field.getText();
        if (text == null || text.trim().isEmpty()) {
            c.error(message);
            return;
        }

        try {
            Float.parseFloat(text.trim().replace(",", "."));
        } catch (NumberFormatException e) {
            c.error(message);
        }
    }

    public void checkNumberNullable(Check.Context c, TextField field,Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message="Mampidira tarehimarika na avelao @ izao.";
            case FRENCH -> message="Entrez un nombre ou laissez un vide.";
            case ENGLISH -> message="Enter a valid number or leave blank.";
        }
        String NumPattern="[\\d]+";
        if (!(field.getText().isEmpty() || field.getText().isBlank()))
            if (!field.getText().matches(NumPattern)){
                c.error(message);
            }
    }


    public void checkNumbers01Nullable(Check.Context c, TextField field,Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message="0 na 1 na avelao @ izao.";
            case FRENCH -> message="Entrez 0 ou 1 ou laissez un vide.";
            case ENGLISH -> message="Enter 0 or 1 or leave blank.";
        }
        String NumPattern="[0-1]";
        if (!(field.getText().isEmpty() || field.getText().isBlank()))
            if (!field.getText().matches(NumPattern)){
                c.error(message);
            }
    }

    //!ONLY WORKS FOR SINGLE CHARACTER
   /* public void checkRangedNumbersNullable(Check.Context c, TextField field,Integer min,Integer max,Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message=min+"-"+max+" na 88 na 98 na 99 na tsisy.";
            case FRENCH -> message=min+"-"+max+" ou 88 ou 98 ou 99 ou vide.";
            case ENGLISH -> message=min+"-"+max+" or 88 or 98 or 99 or blank.";
        }


        String NumPattern="(["+min.toString()+"-"+max.toString()+"])|88|98|99";

        if (!(field.getText().isEmpty() || field.getText().isBlank()))
            if (!field.getText().matches(NumPattern)){
                c.error(message);
            }
    }

    public void checkRangedNumbers(Check.Context c, TextField field,Integer min,Integer max,Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message=min+"-"+max+" na 88 na 98 na 99 na tsisy.";
            case FRENCH -> message=min+"-"+max+" ou 88 ou 98 ou 99 ou vide.";
            case ENGLISH -> message=min+"-"+max+" or 88 or 98 or 99 or blank.";
        }

        String NumPattern="(["+min.toString()+"-"+max.toString()+"])|88|98|99";
        if (!field.getText().matches(NumPattern)){
                c.error(message);
            }
    }*/

    public void checkRangedNumbersNullable(Check.Context c, TextField field, Integer min, Integer max, Language language){
        String message;
        switch (language){
            case MALAGASY -> message = min + "-" + max + " na 88 na 98 na 99 na tsisy.";
            case FRENCH -> message = min + "-" + max + " ou 88 ou 98 ou 99 ou vide.";
            case ENGLISH -> message = min + "-" + max + " or 88 or 98 or 99 or blank.";
            default -> message = min + "-" + max + " or 88 or 98 or 99 or blank.";
        }

        String text = field.getText();
        if (text == null || text.isBlank()) {
            return; // Vide est autorisé
        }

        // Vérifier que c'est un nombre (uniquement des chiffres)
        String numberPattern = "^-?\\d+$";
        if (!text.trim().matches(numberPattern)) {
            c.error(message);
            return;
        }

        try {
            int value = Integer.parseInt(text.trim());

            // Vérifier si la valeur est dans la plage autorisée
            if (value >= min && value <= max) {
                return;
            }
            // Vérifier les valeurs spéciales
            if (value == 88 || value == 98 || value == 99) {
                return;
            }
            c.error(message);
        } catch (NumberFormatException e) {
            c.error(message);
        }
    }

    public void checkRangedNumbers(Check.Context c, TextField field, Integer min, Integer max, Language language){
        String message;
        switch (language){
            case MALAGASY -> message = min + "-" + max + " na 88 na 98 na 99.";
            case FRENCH -> message = min + "-" + max + " ou 88 ou 98 ou 99.";
            case ENGLISH -> message = min + "-" + max + " or 88 or 98 or 99.";
            default -> message = min + "-" + max + " or 88 or 98 or 99.";
        }

        String text = field.getText();
        if (text == null || text.isBlank()) {
            c.error(message);
            return;
        }

        // Vérifier que c'est un nombre (uniquement des chiffres)
        String numberPattern = "^-?\\d+$";
        if (!text.trim().matches(numberPattern)) {
            c.error(message);
            return;
        }

        try {
            int value = Integer.parseInt(text.trim());

            // Vérifier si la valeur est dans la plage autorisée
            if (value >= min && value <= max) {
                return;
            }
            // Vérifier les valeurs spéciales
            if (value == 88 || value == 98 || value == 99) {
                return;
            }
            c.error(message);
        } catch (NumberFormatException e) {
            c.error(message);
        }
    }

    //Multiple characters: needs special pattern
    public void checkRangedNumbersMultiple(Check.Context c, TextField field,Integer min,Integer max,String pattern,Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message=min+"-"+max+" na 88 na 98 na 99 na tsisy.";
            case FRENCH -> message=min+"-"+max+" ou 88 ou 98 ou 99 ou vide.";
            case ENGLISH -> message=min+"-"+max+" or 88 or 98 or 99 or blank.";
        }

        if (!field.getText().matches(pattern)){
            c.error(message);
        }
    }

    public void checkRangedNumbersMultipleNullable(Check.Context c, TextField field,Integer min,Integer max,String pattern,Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message=min+"-"+max+" na 88 na 98 na 99 na tsisy.";
            case FRENCH -> message=min+"-"+max+" ou 88 ou 98 ou 99 ou vide.";
            case ENGLISH -> message=min+"-"+max+" or 88 or 98 or 99 or blank.";
        }
        if (!(field.getText().isEmpty() || field.getText().isBlank()))
        if (!field.getText().matches(pattern)){
            c.error(message);
        }
    }

    public void check01(Check.Context c, TextField field,Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message=" 0 na 1.";
            case FRENCH -> message=" 0 ou 1 .";
            case ENGLISH -> message=" 0 or 1 .";
        }
        String NumPattern="[0-1]";
            if (!field.getText().matches(NumPattern)){
                c.error(message);
            }
    }

    public void check01Nullable(Check.Context c, TextField field,Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message=" 0 na 1 na tsisy.";
            case FRENCH -> message=" 0 ou 1 ou vide.";
            case ENGLISH -> message=" 0 or 1 or empty.";
        }
        String NumPattern="[0-1]";
        if (!(field.getText().isEmpty() || field.getText().isBlank()))
            if (!field.getText().matches(NumPattern)){
                c.error(message);
            }
    }


    public void checkPhoneNumberNullable(Check.Context c, TextField field,Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message="Mampidira tarehimarika 10 na tsy misy.";
            case FRENCH -> message="Entrez 10 nombres  valide ou rien.";
            case ENGLISH -> message="Enter 10 digits or leave blank.";
        }
        String NumPattern="[\\d]{10}";
        if (!(field.getText().isEmpty() || field.getText().isBlank()))
            if (!field.getText().matches(NumPattern)){
                c.error(message);
            }
    }

    public void checkWhiteSpace(Check.Context c, TextField field,Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message="Aza mampiasa espace.";
            case FRENCH -> message="Ne pas utiliser d'espace.";
            case ENGLISH -> message="Don't use spaces.";
        }
        String WHITEPATTERN="[\\s]+";

        Pattern whitePattern=Pattern.compile(WHITEPATTERN);
        Matcher whiteMatcher=whitePattern.matcher(field.getText());
        boolean matchesLetters=whiteMatcher.find();
        if (matchesLetters){
            c.error(message);
        }
    }

    public void checkIntNotInferior(Check.Context c,TextField field,TextField referenceField,Language language)
    {
        String message=new String();
        switch (language){
            case MALAGASY -> message="Tsy tokony ho latsaky ny";
            case FRENCH -> message="Ne doit pas être inférieur à";
            case ENGLISH -> message="Sould not be inferior to";
        }
        if (Integer.parseInt(field.getText()) < Integer.parseInt(referenceField.getText())) {
            c.error(message+" "+referenceField.getText()+".");
        }
    }


    public void checkIntNotSuperior(Check.Context c,TextField field,Integer number,Language language)
    {
        String message=new String();
        switch (language){
            case MALAGASY -> message="Tsy tokony hihoatra ny";
            case FRENCH -> message="Ne doit pas être supérieur à";
            case ENGLISH -> message="Sould not be superior to";
        }
        if (Integer.parseInt(field.getText()) > number) {
            c.error(message+" "+number.toString()+".");
        }
    }

    public void checkGPS (TextField textField,Check.Context c,Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message="Ataovy ##.##### .";
            case FRENCH -> message="Le format est ##.##### .";
            case ENGLISH -> message="The format is ##.##### .";
        }
        
        final String temp="[0-9]{2}[.][0-9]{5}";

        if (!textField.getText().isEmpty() || textField.getText().isBlank())
        {
            if (!(textField.getText().matches(temp))){
                c.error(message);
            }
        }

    }

    public void checkAgeBlank(TextField refTextField,TextField textField,Integer thresHold,Check.Context c,Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message="Tokony hisy tarehimarika tsy latsaky ny.";
            case FRENCH -> message="Entrez un entier supérieur à.";
            case ENGLISH -> message="Enter a number superior to.";
        }
        if (Integer.parseInt(refTextField.getText())<=thresHold && (textField.getText().isBlank()||textField.getText().isEmpty())){
            c.error(message+" "+refTextField.getText()+".");
        }
    }

    //Ity no ampiasaina rehefa tsy maintsy misy ny other specify
    public void checkConditional(TextField refTextField,String refLabel,TextField textField,Integer conditionValue,Check.Context c,Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message="Raha "+conditionValue+" ny "+refLabel+"  dia asiana valiny eto.";
            case FRENCH -> message="Ssi le "+refLabel+"="+conditionValue+", ce champ est obligatoire.";
            case ENGLISH -> message="If the "+refLabel+" equals " +conditionValue+", then this field is mandatory.";
        }
        if (!(refTextField.getText().isBlank() || refTextField.getText().isEmpty())){
        if ((Integer.parseInt(refTextField.getText())==conditionValue && (textField.getText().isBlank()||textField.getText().isEmpty())) || (Integer.parseInt(refTextField.getText())!=conditionValue && (!(textField.getText().isBlank()||textField.getText().isEmpty())))){
            c.error(message);
        }}
    }

    //Raha tsy égalité fa supOrInf
    public void checkConditionalGreaterOrEqual(TextField refTextField, String refLabel, TextField textField,
                                               Integer conditionValue, Check.Context c, Language language,
                                               boolean errorWhenEmpty) {
        String message;
        if (errorWhenEmpty) {
            switch (language){
                case MALAGASY -> message = "Raha < " + conditionValue + " ny " + refLabel + " dia mila valiny eto.";
                case FRENCH -> message = "Si le " + refLabel + " < " + conditionValue + ", alors ce champ est obligatoire.";
                case ENGLISH -> message = "If the " + refLabel + " is < " + conditionValue + ", then this field is mandatory.";
                default -> message = "This field is mandatory when " + refLabel + " < " + conditionValue + ".";
            }
        } else {
            switch (language){
                case MALAGASY -> message = "Raha < " + conditionValue + " ny " + refLabel + ", dia tsy tokony hisy valiny eto.";
                case FRENCH -> message = "Si le " + refLabel + " < " + conditionValue + ", ce champ ne doit pas être rempli.";
                case ENGLISH -> message = "If the " + refLabel + " is < " + conditionValue + ", this field should be empty.";
                default -> message = "This field should be empty when " + refLabel + " < " + conditionValue + ".";
            }
        }

        String refText = refTextField.getText();
        if (refText == null || refText.isBlank()) {
            return;
        }

        try {
            int refValue = Integer.parseInt(refText);

            if (errorWhenEmpty) {
                // Erreur si champ VIDE alors qu'il devrait être rempli
                if (refValue < conditionValue && (textField.getText() == null || textField.getText().isBlank())) {
                    c.error(message);
                }
            } else {
                // Erreur si champ REMPLI alors qu'il devrait être vide
                if (refValue < conditionValue && textField.getText() != null && !textField.getText().isBlank()) {
                    c.error(message);
                }
            }
        } catch (NumberFormatException e) {
            // Ignorer si la référence n'est pas un nombre valide
        }
    }

    public void checkConditionalLess(TextField refTextField, String refLabel, TextField textField,
                                     Integer conditionValue, Check.Context c, Language language,
                                     boolean errorWhenEmpty) {
        String message;
        if (errorWhenEmpty) {
            switch (language){
                case MALAGASY -> message = "Raha >= " + conditionValue + " ny " + refLabel + " dia mila valiny eto.";
                case FRENCH -> message = "Si le " + refLabel + " >= " + conditionValue + ", alors ce champ est obligatoire.";
                case ENGLISH -> message = "If the " + refLabel + " is >= " + conditionValue + ", then this field is mandatory.";
                default -> message = "This field is mandatory when " + refLabel + " >= " + conditionValue + ".";
            }
        } else {
            switch (language){
                case MALAGASY -> message = "Raha >= " + conditionValue + " ny " + refLabel + ", dia tsy tokony hisy valiny eto.";
                case FRENCH -> message = "Si le " + refLabel + " >= " + conditionValue + ", ce champ ne doit pas être rempli.";
                case ENGLISH -> message = "If the " + refLabel + " is >= " + conditionValue + ", this field should be empty.";
                default -> message = "This field should be empty when " + refLabel + " >= " + conditionValue + ".";
            }
        }

        String refText = refTextField.getText();
        if (refText == null || refText.isBlank()) {
            return;
        }

        try {
            int refValue = Integer.parseInt(refText);

            if (errorWhenEmpty) {
                // Erreur si champ VIDE alors qu'il devrait être rempli
                if (refValue >= conditionValue && (textField.getText() == null || textField.getText().isBlank())) {
                    c.error(message);
                }
            } else {
                // Erreur si champ REMPLI alors qu'il devrait être vide
                if (refValue >= conditionValue && textField.getText() != null && !textField.getText().isBlank()) {
                    c.error(message);
                }
            }
        } catch (NumberFormatException e) {
            // Ignorer si la référence n'est pas un nombre valide
        }
    }
//combo ny ref na/sy value
    public void checkConditional(ComboBox refCombo,String refLabel,TextField textField,Integer conditionValue,Check.Context c,Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message="Raha "+conditionValue+" ny "+refLabel+"  dia mila valiny eto.";
            case FRENCH -> message="Si le "+refLabel+"="+conditionValue+", alors ce champ est obligatoire.";
            case ENGLISH -> message="If the "+refLabel+ " equals "+conditionValue+", then this field is mandatory.";
        }
        if (Integer.parseInt(refCombo.getEditor().getText())==conditionValue && (textField.getText().isBlank()||textField.getText().isEmpty())){
            c.error(message);
        }
    }

    // raha checked ny checkbox

    public void checkConditional(CheckBox refCheck,String refLabel,TextField textField,Check.Context c,Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message="Raha voamarika ny "+refLabel+"  dia mila valiny eto.";
            case FRENCH -> message="Si le "+refLabel+" est coché, alors ce champ est obligatoire.";
            case ENGLISH -> message="If the "+refLabel+ " is checked, then this field is mandatory.";
        }
        if (refCheck.isSelected() && (textField.getText().isBlank()||textField.getText().isEmpty())){
            c.error(message);
        }
    }

    // rehefa misy valeur positif dia mila hafa

    public void checkConditionalPositive(TextField refTextField,String refLabel,TextField textField,Check.Context c,Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message="Raha mihoatra ny 0 ny "+refLabel+"  dia asiana valiny eto.";
            case FRENCH -> message="Ssi le "+refLabel+">0, ce champ est obligatoire.";
            case ENGLISH -> message="If the "+refLabel+" is superior to 0, then this field is mandatory.";
        }
        if (!(refTextField.getText().isBlank() || refTextField.getText().isEmpty())){
            if ((Integer.parseInt(refTextField.getText())>0 && (textField.getText().isBlank()||textField.getText().isEmpty())) || (Integer.parseInt(refTextField.getText())==0 && (!(textField.getText().isBlank()||textField.getText().isEmpty())))){
                c.error(message);
            }}
    }

    //rehefa checked ilay checkbox dia mila hafa



    public void checkConditional(ComboBox refCombo,String refLabel,ComboBox valueCombo,Integer conditionValue,Check.Context c,Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message="Raha "+conditionValue+" ny "+refLabel+"  dia mila valiny eto.";
            case FRENCH -> message="Si le "+refLabel+"="+conditionValue+", alors ce champ est obligatoire.";
            case ENGLISH -> message="If the "+refLabel+ " equals "+conditionValue+", then this field is mandatory.";
        }
        if (Integer.parseInt(refCombo.getEditor().getText())==conditionValue && (valueCombo.getEditor().getText().isBlank()||valueCombo.getEditor().getText().isEmpty())){
            c.error(message);
        }
    }

    public void checkConditionalString(String refString,TextField textField,String conditionValue,Check.Context c,Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message="Raha "+conditionValue+"  dia mila valiny eto.";
            case FRENCH -> message="Si "+conditionValue+", alors ce champ est obligatoire.";
            case ENGLISH -> message="If it is "+conditionValue+", then this field is mandatory.";
        }
        if (refString.equals(conditionValue) && (textField.getText().isBlank()||textField.getText().isEmpty())){
            c.error(message);
        }
    }



    public void checkConfirmPassword(MFXPasswordField p1,MFXPasswordField p2,Check.Context c,Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message="Tokony mitovy ny teny miafina roa.";
            case FRENCH -> message="Les deux mots de passes doivent être identique.";
            case ENGLISH -> message="The two passwords should match.";
        }
        if(!p1.getText().equals(p2.getText())){
            c.error(message);
        }
    }



    //** MFX

    public void checkBlank(Check.Context c, MFXTextField node, Language language){
        if (isBlank(node.getText())){
            String message=new String();
            switch (language){
                case MALAGASY -> message="Mila valiny.";
                case FRENCH -> message="Champ obligatoire.";
                case ENGLISH -> message="Mandatory field.";
            }
            c.error(message);
        }
    }

 

    //Used in japs
    public void checkFalseCheck(Check.Context c, MFXCheckbox checkBox, Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message="Mila marihana.";
            case FRENCH -> message="Veuillez cocher.";
            case ENGLISH -> message="Please, tick.";
        }
        if (!checkBox.isSelected()){
            c.error(message);
        }
    }
    //Used in japs
    public void checkDoubleFalseCheck(Check.Context c,MFXCheckbox checkBox1,MFXCheckbox checkBox2,Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message="Iray ihany no marihana.";
            case FRENCH -> message="Veuillez cocher une seule case.";
            case ENGLISH -> message="Please, tick only one checkbox.";
        }
        if (checkBox1.isSelected() && checkBox2.isSelected()){
            c.error(message);
        }
    }

    public void checkDate(Check.Context c, MFXDatePicker MFXDatePicker, Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message="Daty jj/mm/aaaa no eto.";
            case FRENCH -> message="Entrez une date de format jj/mm/aaaa.";
            case ENGLISH -> message="Please, enter a date format dd/mm/yyyy.";
        }
        if(dateCheck(MFXDatePicker.getText())==false){
            c.error(message);
        }
    }

    public void checkBlankCombo(Check.Context c, MFXComboBox comboBox, Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message="Mila fenoina eto.";
            case FRENCH -> message="Ce champ est obligatoire.";
            case ENGLISH -> message="This field is mandatory.";
        }
        //if (comboBox.getSelectionModel().selectedItemProperty().get()==null)c.error(message);
        if (comboBox.getValue()==null)c.error(message);
    }

    public void checkDateNullable(Check.Context c, MFXDatePicker datePicker,Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message="Daty jj/mm/aaaa no eto.";
            case FRENCH -> message="Entrez une date de format jj/mm/aaaa.";
            case ENGLISH -> message="Please, enter a date format dd/mm/yyyy.";
        }
        if (!isBlank(datePicker.getText()))
            if(dateCheck(datePicker.getText())==false){
                c.error(message);
                //Entrez une date de format jj/mm/aaaa
            }
    }

    
    public void checkDay(Check.Context c,MFXTextField textField,Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message="Diso ny daty, ataovy ##.";
            case FRENCH -> message="La date est incorrecte, le format est ##.";
            case ENGLISH -> message="Incorrect date, enter a ## format.";
        }
        if (!dayCheck(textField.getText())){
            c.error(message);
        }
    }

 

    public void checkMonth(Check.Context c,MFXTextField textField,Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message="Diso ny volana, ataovy ##.";
            case FRENCH -> message="Le mois est incorrect, le format est ##.";
            case ENGLISH -> message="Incorrect month, enter a ## format.";
        }
        if (!monthCheck(textField.getText())){
            c.error(message);
        }
    }
  

    public void checkYear(Check.Context c,MFXTextField textField,Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message="Diso ny taona, ataovy ####.";
            case FRENCH -> message="L'année est incorrecte, le format est ####.";
            case ENGLISH -> message="Incorrect year, enter a #### format.";
        }
        if (!yearCheck(textField.getText())){
            c.error(message);
        }
    }

    

    public void checkHourAfter(Check.Context c,MFXTextField textField1,MFXTextField textField2,Language language)
    {
        String message=new String();
        switch (language){
            case MALAGASY -> message="Mifamadika ny ora.";
            case FRENCH -> message="Les valeurs d'heures sont échangées.";
            case ENGLISH -> message="Hour values are exchanged.";
        }

        if (hourCheck(textField1.getText()) && hourCheck(textField2.getText())){
            if (LocalTime.parse(textField2.getText()).isBefore(LocalTime.parse(textField1.getText()))){
                c.error(message);
            }
        }
    }

    public void checkHour(Check.Context c,MFXTextField textField,Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message="Diso ny ora, ataovy ##:##:##.";
            case FRENCH -> message="La valeur de date est incorrecte, le format est ##:##:##.";
            case ENGLISH -> message="Incorrect date values, enter a ##:##:## format.";
        }
        if (!hourCheck(textField.getText())){
            c.error(message);
        }
    }


    public void checkDateAfter(Check.Context c,MFXDatePicker datePicker1,MFXDatePicker datePicker2,Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message="Mifamadika ny daty.";
            case FRENCH -> message="Les valeurs de dates sont échangées.";
            case ENGLISH -> message="Date values are exchanged.";
        }
        if (dateCheck(datePicker1.getText()) && dateCheck(datePicker2.getText())){
            if (datePicker2.getValue().isBefore(datePicker1.getValue())){
                c.error(message);
            }
        }
    }

    public void checkDatesOutOfbounds(Check.Context c,MFXDatePicker min, MFXDatePicker max,MFXDatePicker date,Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message="Ivelan'ny fetra ny daty.";
            case FRENCH -> message="La date est hors limite.";
            case ENGLISH -> message="The date is out of bond.";
        }

        if (dateCheck(date.getText()) && dateCheck(min.getText()) && dateCheck(max.getText()))
            if (date.getValue().isBefore(min.getValue()) || date.getValue().isAfter(max.getValue())){
                c.error(message);
            }
    }

    public void checkOneSix(Check.Context c,MFXTextField field,Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message="Tarehimarika 1-6.";
            case FRENCH -> message="Entrez un nombre entre [1 - 6].";
            case ENGLISH -> message="Enter a digit [1 - 6].";
        }
        final String PATTERN="[1-6]";
        if (!field.getText().matches(PATTERN))c.error(message);
    }

    public void checkTextFieldLength(Check.Context c,MFXTextField field,Integer number,Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message="Ny isan'ny teny dia tsy mihoatra ny";
            case FRENCH -> message="Le maximum de mots est";
            case ENGLISH -> message="The maximum word count is";
        }
        if (field.getLength()>number){
            c.error(message+" "+number+".");
        }
    }

    public void checkTextAreaLength(Check.Context c, TextArea field, Integer number, Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message="Ny isan'ny teny dia tsy mihoatra ny";
            case FRENCH -> message="Le nombre maximum de mots est";
            case ENGLISH -> message="The maximum character is";
        }
        if (field.getLength()>number){
            c.error(message+" "+number+".");
        }
    }

    public void checkNumber(Check.Context c, MFXTextField field,Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message="Mampidira tarehimarika.";
            case FRENCH -> message="Entrez un nombre entier valide.";
            case ENGLISH -> message="Enter a valid digit.";
        }

        String NumPattern="[\\d]+";
        if (!field.getText().matches(NumPattern)){
            c.error(message);
        }
    }

    public void checkGender(Check.Context c,MFXTextField field,Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message="Mampidira tarehimarika 1 na 2.";
            case FRENCH -> message="Entrez un nombre entier 1 ou 2.";
            case ENGLISH -> message="Enter a number 1 or 2.";
        }

        String NumPattern="[1-2]";
        if (!field.getText().matches(NumPattern)){
            c.error(message);
        }
    }

    public void checkDouble(Check.Context c,MFXTextField field,Language language){

        String message=new String();
        switch (language){
            case MALAGASY -> message="Mampidira tarehimarika lehibe.";
            case FRENCH -> message="Entrez un nombre double valide.";
            case ENGLISH -> message="Enter a valid double.";
        }
        try{
            Double.parseDouble(field.getText());
        } catch (NumberFormatException e) {
            c.error(message);
        }
    }

    public void checkDoubleNullable(Check.Context c,MFXTextField field,Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message="Mampidira tarehimarika lehibe na tsy misy.";
            case FRENCH -> message="Entrez un nombre double valide ou rien.";
            case ENGLISH -> message="Enter a valid double or leave blank.";
        }

        if (!(field.getText().isBlank() || field.getText().isEmpty())){
            try{
                Double.parseDouble(field.getText());
            } catch (NumberFormatException e) {
                c.error(message);
            }
        }
    }
    public void checkNumberNullable(Check.Context c, MFXTextField field,Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message="Mampidira tarehimarika na avelao @ izao.";
            case FRENCH -> message="Entrez un nombre ou laissez un vide.";
            case ENGLISH -> message="Enter a valid number or leave blank.";
        }
        String NumPattern="[\\d]+";
        if (!(field.getText().isEmpty() || field.getText().isBlank()))
            if (!field.getText().matches(NumPattern)){
                c.error(message);
            }
    }


    public void checkPhoneNumberNullable(Check.Context c, MFXTextField field,Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message="Mampidira tarehimarika 10 na tsy misy.";
            case FRENCH -> message="Entrez 10 nombres  valide ou rien.";
            case ENGLISH -> message="Enter 10 digits or leave blank.";
        }
        String NumPattern="[\\d]{10}";
        if (!(field.getText().isEmpty() || field.getText().isBlank()))
            if (!field.getText().matches(NumPattern)){
                c.error(message);
            }
    }

    public void checkWhiteSpace(Check.Context c, MFXTextField field,Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message="Aza mampiasa espace.";
            case FRENCH -> message="Ne pas utiliser d'espace.";
            case ENGLISH -> message="Don't use spaces.";
        }
        String WHITEPATTERN="[\\s]+";

        Pattern whitePattern=Pattern.compile(WHITEPATTERN);
        Matcher whiteMatcher=whitePattern.matcher(field.getText());
        boolean matchesLetters=whiteMatcher.find();
        if (matchesLetters){
            c.error(message);
        }
    }

    public void checkIntNotInferior(Check.Context c,MFXTextField field,MFXTextField referenceField,Language language)
    {
        String message=new String();
        switch (language){
            case MALAGASY -> message="Tsy tokony ho latsaky ny";
            case FRENCH -> message="Ne doit pas être inférieur à";
            case ENGLISH -> message="Sould not be inferior to";
        }
        if (Integer.parseInt(field.getText()) < Integer.parseInt(referenceField.getText())) {
            c.error(message+" "+referenceField.getText()+".");
        }
    }

    public void checkGPS (MFXTextField textField,Check.Context c,Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message="Ataovy ##.##### .";
            case FRENCH -> message="Le format est ##.##### .";
            case ENGLISH -> message="The format is ##.##### .";
        }

        final String temp="[0-9]{2}[.][0-9]{5}";

        if (!textField.getText().isEmpty() || textField.getText().isBlank())
        {
            if (!(textField.getText().matches(temp))){
                c.error(message);
            }
        }

    }

    public void checkAgeBlank(MFXTextField refTextField,MFXTextField textField,Integer thresHold,Check.Context c,Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message="Tokony hisy tarehimarika tsy latsaky ny.";
            case FRENCH -> message="Entrez un entier supérieur à.";
            case ENGLISH -> message="Enter a number superior to.";
        }
        if (Integer.parseInt(refTextField.getText())<=thresHold && (textField.getText().isBlank()||textField.getText().isEmpty())){
            c.error(message+" "+refTextField.getText()+".");
        }
    }

    //Ity no ampiasaina rehefa tsy maintsy misy ny other specify
    public void checkConditional(MFXTextField refTextField,MFXTextField textField,Integer conditionValue,Check.Context c,Language language){
        String message=new String();
        switch (language){
            case MALAGASY -> message="Raha "+conditionValue+"  dia mila valiny eto.";
            case FRENCH -> message="Si "+conditionValue+", alors ce champ est obligatoire.";
            case ENGLISH -> message="If it is "+conditionValue+", then this field is mandatory.";
        }
        if (Integer.parseInt(refTextField.getText())==conditionValue && (textField.getText().isBlank()||textField.getText().isEmpty())){
            c.error(message);
        }
    }




    // ****CREATECHECKS********

    public void createCheckGps(String key,TextField textField,Label label,Language language,Validator validator){
        label.getStyleClass().add("label-error");
         validator.createCheck()
                .withMethod(c-> checkGPS(textField,c,language))
                .dependsOn(key,textField.textProperty())
                .decoratingWith(rianaDecoration::fieldDecorator)
                .decorates(textField)
                 .immediate();

        validator.createCheck()
                .withMethod(c-> checkGPS(textField,c,language))
                .dependsOn(key,textField.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }

    public void createCheckMFXGps(String key,MFXTextField textField,Label label,Language language,Validator validator){
        label.getStyleClass().add("label-error");
        validator.createCheck()
                .withMethod(c-> checkGPS(textField,c,language))
                .dependsOn(key,textField.textProperty())
                .decoratingWith(rianaDecoration::fieldDecorator)
                .decorates(textField)
                .immediate();

        validator.createCheck()
                .withMethod(c-> checkGPS(textField,c,language))
                .dependsOn(key,textField.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }

    public void createCheckRelation(String key, TextField field,Label label,Language language,Validator validator){
        label.getStyleClass().add("label-error");
        validator.createCheck()
                .withMethod(c-> checkRelation(field.getText(),c,language))
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::fieldDecorator)
                .decorates(field)
                .immediate();

        validator.createCheck()
                .withMethod(c-> checkRelation(field.getText(),c,language))
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }

    public void createCheckYesNo(String key, TextField field,Label label,Language language,Validator validator,BooleanProperty showError){
        label.getStyleClass().add("label-error");
        validator.createCheck()
                .withMethod(c->{
                    if(showError!=null && !showError.get()) return;
                    checkYesNo(field.getText(),c,language);})
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::fieldDecorator)
                .decorates(field)
                .immediate();

        validator.createCheck()
                .withMethod(c-> {
                    if (showError!=null && !showError.get()) return;
                    checkYesNo(field.getText(), c, language);
                })
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }

    public void createCheckYesNo(String key, TextField field,Label label,Language language,Validator validator) {
        createCheckYesNo(key,field,label,language,validator,null);
    }

        public void createCheckYesNo(String key, TextField field,Boolean nullable,Label label,Language language,Validator validator,BooleanProperty showError){
        label.getStyleClass().add("label-error");
        validator.createCheck()
                .withMethod(  c->{
                    if (showError!=null && !showError.get()) return;
                    if (!nullable){
                        checkYesNo(field.getText(),c,language);}
                    else{
                        checkYesNoNullable(field,c,language);
                    }
                })
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::fieldDecorator)
                .decorates(field)
                .immediate();
        validator.createCheck()
                .withMethod(  c->{
                    if (showError!=null && !showError.get()) return;
                    if (!nullable){
                        checkYesNo(field.getText(),c,language);}
                    else{
                        checkYesNoNullable(field,c,language);
                    }
                })
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }

    public void createCheckYesNo(String key, TextField field,Boolean nullable,Label label,Language language,Validator validator) {
    createCheckYesNo(key,field,nullable,label,language,validator,null);
    }

        public void createCheckMFXRelation(String key, MFXTextField field,Label label,Language language,Validator validator){
        label.getStyleClass().add("label-error");
        validator.createCheck()
                .withMethod(c-> checkRelation(field.getText(),c,language))
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::fieldDecorator)
                .decorates(field)
                .immediate();

        validator.createCheck()
                .withMethod(c-> checkRelation(field.getText(),c,language))
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }

    public void createCheckGender(String key, TextField field, Label label,Language language, Validator validator){
        label.getStyleClass().add("label-error");

        validator.createCheck()
                .withMethod(c-> checkGender(c,field,language))
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::fieldDecorator)
                .decorates(field)
                .immediate();

        validator.createCheck()
                .withMethod(c-> checkGender(c,field,language))
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }


    public void createCheckGenderConditional(String key, TextField field,Integer value,CheckBox checkBox, Label label,Language language, Validator validator){
        label.getStyleClass().add("label-error");

        validator.createCheck()
                .withMethod(c-> checkGenderConditional(c,field,value,checkBox,language))
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::checkDecorator)
                .decorates(checkBox)
                .immediate();

        validator.createCheck()
                .withMethod(c-> checkGenderConditional(c,field,value,checkBox,language))
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }


    public void createCheckMFXGender(String key, MFXTextField field, Label label,Language language, Validator validator){
        label.getStyleClass().add("label-error");

        validator.createCheck()
                .withMethod(c-> checkGender(c,field,language))
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::fieldDecorator)
                .decorates(field)
                .immediate();

        validator.createCheck()
                .withMethod(c-> checkGender(c,field,language))
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }


    public void createCheckConditional(String key,TextField field,ComboBox refCombo,String refLabel,Integer conditionValue,Label label,Language language,Validator validator,SimpleBooleanProperty showErrors){
        label.getStyleClass().add("label-error");

        validator.createCheck()
                .withMethod(c-> {
                    if(showErrors!=null && !showErrors.get()) return;
                    checkConditional(refCombo,refLabel,field,conditionValue,c,language);
                })
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::fieldDecorator)
                .decorates(field)
                .immediate();

        validator.createCheck()
                .withMethod(c->{
                    if(showErrors!=null && !showErrors.get()) return;
                    checkConditional(refCombo,refLabel,field,conditionValue,c,language);}
                )
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }

    public void createCheckConditional(String key,TextField field,ComboBox refCombo,String refLabel,Integer conditionValue,Label label,Language language,Validator validator) {
    createCheckConditional(key,field,refCombo,refLabel,conditionValue,label,language,validator,null);
    }


        public void createCheckConditional(String key,ComboBox valueCombo,ComboBox refCombo,String refLabel,Integer conditionValue,Label label,Language language,Validator validator){
        label.getStyleClass().add("label-error");

        validator.createCheck()
                .withMethod(c->checkConditional(refCombo,refLabel,valueCombo,conditionValue,c,language))
                .dependsOn(key,valueCombo.getEditor().textProperty())
                .decoratingWith(rianaDecoration::fieldDecorator)
                .decorates(valueCombo)
                .immediate();

        validator.createCheck()
                .withMethod(c->checkConditional(refCombo,refLabel,valueCombo,conditionValue,c,language))
                .dependsOn(key,valueCombo.getEditor().textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }

    public void createCheckConditional(String key,CheckBox refCheck,TextField textField,String refLabel,Label label,Language language,Validator validator){
        label.getStyleClass().add("label-error");

        validator.createCheck()
                .withMethod(c->checkConditional(refCheck,refLabel,textField,c,language))
                .dependsOn(key,refCheck.selectedProperty())
                .decoratingWith(rianaDecoration::checkDecorator)
                .decorates(refCheck)
                .immediate();

        validator.createCheck()
                .withMethod(c->checkConditional(refCheck,refLabel,textField,c,language))
                .dependsOn(key,refCheck.selectedProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }

    public void createCheckConditional(String key, TextField field, TextField refTextField, String refLabel, Integer conditionValue, Label label, Language language, Validator validator, BooleanProperty showError){
        label.getStyleClass().add("label-error");

        validator.createCheck()
                .withMethod(c->{
                    if(showError!=null && !showError.get()) return;
                    checkConditional(refTextField,refLabel,field,conditionValue,c,language);})
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::fieldDecorator)
                .decorates(field)
                .immediate();

        validator.createCheck()
                .withMethod(c->{
                    if(showError!=null && !showError.get()) return;
                    checkConditional(refTextField,refLabel,field,conditionValue,c,language);})
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }
    public void createCheckConditional(String key, TextField field, TextField refTextField, String refLabel, Integer conditionValue, Label label, Language language, Validator validator) {
        createCheckConditional(key,field,refTextField,refLabel,conditionValue,label,language,validator,null);
    }

    public void createCheckConditional(String key, TextField field, TextField refTextField,
                                       Boolean greaterOrEqual, String refLabel, Integer conditionValue,
                                       Label label, Language language, Validator validator,
                                       BooleanProperty showError, boolean errorWhenEmpty) {
        label.getStyleClass().add("label-error");

        validator.createCheck()
                .withMethod(c -> {
                    if (showError != null && !showError.get()) return;
                    if (greaterOrEqual) {
                        checkConditionalGreaterOrEqual(refTextField, refLabel, field, conditionValue, c, language, errorWhenEmpty);
                    } else {
                        checkConditionalLess(refTextField, refLabel, field, conditionValue, c, language, errorWhenEmpty);
                    }
                })
                .dependsOn(key, field.textProperty())
                .decoratingWith(rianaDecoration::fieldDecorator)
                .decorates(field)
                .immediate();

        validator.createCheck()
                .withMethod(c -> {
                    if (showError != null && !showError.get()) return;
                    if (greaterOrEqual) {
                        checkConditionalGreaterOrEqual(refTextField, refLabel, field, conditionValue, c, language, errorWhenEmpty);
                    } else {
                        checkConditionalLess(refTextField, refLabel, field, conditionValue, c, language, errorWhenEmpty);
                    }
                })
                .dependsOn(key, field.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }

    // Overload sans showError pour la compatibilité
    public void createCheckConditional(String key, TextField field, TextField refTextField,
                                       Boolean greaterOrEqual, String refLabel, Integer conditionValue,
                                       Label label, Language language, Validator validator,
                                       boolean errorWhenEmpty) {
        createCheckConditional(key, field, refTextField, greaterOrEqual, refLabel, conditionValue,
                label, language, validator, null, errorWhenEmpty);
    }



        public void createCheckConditionalCombo(String key,ComboBox combobox,TextField field,String refString,String conditionValue,Label label,Language language,Validator validator){
        label.getStyleClass().add("label-error");

        validator.createCheck()
                .withMethod(c->checkConditionalString(refString,field,conditionValue,c,language))
                .dependsOn(key,combobox.getEditor().onActionProperty())
                .decoratingWith(rianaDecoration::fieldDecorator)
                .decorates(field)
                .immediate();

        validator.createCheck()
                .withMethod(c->checkConditionalString(refString,field,conditionValue,c,language))
                .dependsOn(key,combobox.getEditor().onActionProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }


    public void createCheckPositiveConditional(String key,TextField refTextField,TextField textField,String refLabel,Label label,Language language,Validator validator){
        label.getStyleClass().add("label-error");

        validator.createCheck()
                .withMethod(c->checkConditionalPositive(refTextField,refLabel,textField,c,language))
                .dependsOn(key,refTextField.textProperty())
                .decoratingWith(rianaDecoration::fieldDecorator)
                .decorates(textField)
                .immediate();

        validator.createCheck()
                .withMethod(c->checkConditionalPositive(refTextField,refLabel,textField,c,language))
                .dependsOn(key,refTextField.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }

    public void createCheckMFXConditional(String key,MFXTextField field,MFXTextField refTextField,Integer conditionValue,Label label,Language language,Validator validator){
        label.getStyleClass().add("label-error");

        validator.createCheck()
                .withMethod(c->checkConditional(refTextField,field,conditionValue,c,language))
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::fieldDecorator)
                .decorates(field)
                .immediate();

        validator.createCheck()
                .withMethod(c->checkConditional(refTextField,field,conditionValue,c,language))
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }


    public void createCheckAgeBlank(String key,TextField field,TextField refTextField,Integer thresHold,Label label,Language language,Validator validator){
        label.getStyleClass().add("label-error");

        validator.createCheck()
                .withMethod(c->checkAgeBlank(refTextField,field,thresHold,c,language))
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::fieldDecorator)
                .decorates(field)
                .immediate();

        validator.createCheck()
                .withMethod(c->checkAgeBlank(refTextField,field,thresHold,c,language))
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }

    public void createCheckMFXAgeBlank(String key,MFXTextField field,TextField refTextField,Integer thresHold,Label label,Language language,Validator validator){
        label.getStyleClass().add("label-error");

        validator.createCheck()
                .withMethod(c->checkAgeBlank(refTextField,field,thresHold,c,language))
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::fieldDecorator)
                .decorates(field)
                .immediate();

        validator.createCheck()
                .withMethod(c->checkAgeBlank(refTextField,field,thresHold,c,language))
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }

    public void createCheckTempId(String key,TextField field,Integer houseHoldId, Label label,Language language, Validator validator){
        label.getStyleClass().add("label-error");

        validator.createCheck()
                .withMethod(c->checkTempId(field.getText(),houseHoldId,c,language))
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::fieldDecorator)
                .decorates(field)
                .immediate();

        validator.createCheck()
                .withMethod(c->checkTempId(field.getText(),houseHoldId,c,language))
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }

    public void createCheckMFXTempId(String key,MFXTextField field,Integer houseHoldId, Label label,Language language, Validator validator){
        label.getStyleClass().add("label-error");

        validator.createCheck()
                .withMethod(c->checkTempId(field.getText(),houseHoldId,c,language))
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::fieldDecorator)
                .decorates(field)
                .immediate();

        validator.createCheck()
                .withMethod(c->checkTempId(field.getText(),houseHoldId,c,language))
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }


    public void createCheckFalseCheck(String key,CheckBox checkBox,Label label,Language language,Validator validator){
        label.getStyleClass().add("label-error");

        validator.createCheck()
                .withMethod(c->checkFalseCheck(c,checkBox,language))
                .dependsOn(key,checkBox.selectedProperty())
                .decoratingWith(rianaDecoration::checkDecorator)
                .decorates(checkBox)
                .immediate();

        validator.createCheck()
                .withMethod(c->checkFalseCheck(c,checkBox,language))
                .dependsOn(key,checkBox.selectedProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }

    public void createCheckMFXFalseCheck(String key,MFXCheckbox checkBox,Label label,Language language,Validator validator){
        label.getStyleClass().add("label-error");

        validator.createCheck()
                .withMethod(c->checkFalseCheck(c,checkBox,language))
                .dependsOn(key,checkBox.selectedProperty())
                .decoratingWith(rianaDecoration::checkDecorator)
                .decorates(checkBox)
                .immediate();

        validator.createCheck()
                .withMethod(c->checkFalseCheck(c,checkBox,language))
                .dependsOn(key,checkBox.selectedProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }


    public void createCheckPhoneNumberNullable(String key, TextField field, Label label,Language language, Validator validator){
        label.getStyleClass().add("label-error");

        validator.createCheck()
                .withMethod(c-> checkPhoneNumberNullable(c,field,language))
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::fieldDecorator)
                .decorates(field)
                .immediate();

        validator.createCheck()
                .withMethod(c-> checkPhoneNumberNullable(c,field,language))
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }

    public void createCheckMFXPhoneNumberNullable(String key, MFXTextField field, Label label,Language language, Validator validator){
        label.getStyleClass().add("label-error");

        validator.createCheck()
                .withMethod(c-> checkPhoneNumberNullable(c,field,language))
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::fieldDecorator)
                .decorates(field)
                .immediate();

        validator.createCheck()
                .withMethod(c-> checkPhoneNumberNullable(c,field,language))
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }


    public void createCheckBlank(String key, TextField field, Label label, Language language, Validator validator, SimpleBooleanProperty showErrors) {
        label.getStyleClass().add("label-error");
        validator.createCheck()
                .withMethod(c -> {
                    if (showErrors != null && !showErrors.get()) return;  // Skip if not showing errors
                    checkBlank(c, field, language);
                })
                .dependsOn(key, field.textProperty())
                .decoratingWith(rianaDecoration::fieldDecorator)
                .decorates(field)
                .immediate();

        validator.createCheck()
                .withMethod(c -> {
                    if (showErrors != null && !showErrors.get()) return;  // Skip
                    checkBlank(c, field, language);
                })
                .dependsOn(key, field.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }

    // Overload without showErrors (for backward compatibility)
    public void createCheckBlank(String key, TextField field, Label label, Language language, Validator validator) {
        createCheckBlank(key, field, label,language, validator,  null);
    }

    public void createCheckMFXBlank(String key, MFXTextField field, Label label,Language language, Validator validator){
        label.getStyleClass().add("label-error");

        validator.createCheck()
                .withMethod(c-> checkBlank(c,field,language))
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::mfxTextFieldDecorator)
                .decorates(field)
                .immediate();

        validator.createCheck()
                .withMethod(c-> checkBlank(c,field,language))
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }

    public void createCheckLabelBlank(String key,String name, Label targetLabel, Label label,Language language, Validator validator){
        label.getStyleClass().add("label-error");
        validator.createCheck()
                .withMethod(c->{
                    checkBlankLabel(c,targetLabel,language,name);
                })
                .dependsOn(key,targetLabel.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }



    public void createCheckTextAreaLength(String key, TextArea textArea, Label label,Integer number, Validator validator,Language language) {
        label.getStyleClass().add("label-error");

        validator.createCheck()
                .withMethod(c->{
                    checkTextAreaLength(c,textArea,number,language);
                })
                .dependsOn(key,textArea.textProperty())
                .decoratingWith(rianaDecoration::fieldDecorator)
                .decorates(textArea)
                .immediate();

        validator.createCheck()
                .withMethod(c->{
                    checkTextAreaLength(c,textArea,number,language);
                })
                .dependsOn(key,textArea.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }

    public void createCheckTextFieldLength(String key, TextField field, Label label,Integer number, Validator validator,Language language) {
        label.getStyleClass().add("label-error");
        validator.createCheck()
                .withMethod(c->{
                    checkTextFieldLength(c,field,number,language);
                })
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::fieldDecorator)
                .decorates(field)
                .immediate();

        validator.createCheck()
                .withMethod(c->{
                    checkTextFieldLength(c,field,number,language);
                })
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }

    public void createCheckMFXTextFieldLength(String key, TextField field, Label label,Integer number, Validator validator,Language language) {
        label.getStyleClass().add("label-error");
        validator.createCheck()
                .withMethod(c->{
                    checkTextFieldLength(c,field,number,language);
                })
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::fieldDecorator)
                .decorates(field)
                .immediate();

        validator.createCheck()
                .withMethod(c->{
                    checkTextFieldLength(c,field,number,language);
                })
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }


    // UPDATED: Similar for numbers (e.g., for valueTextField)
    public void createCheckNumber(String key, TextField field, Label label, Language language, Validator validator, SimpleBooleanProperty showErrors) {
        label.getStyleClass().add("label-error");
        validator.createCheck()
                .withMethod(c -> {
                    if (showErrors != null && !showErrors.get()) return;  // Skip
                    checkNumber(c, field, language);  // Assuming you have checkNumber
                })
                .dependsOn(key, field.textProperty())
                .decoratingWith(rianaDecoration::fieldDecorator)
                .decorates(field)
                .immediate();

        validator.createCheck()
                .withMethod(c -> {
                    if (showErrors != null && !showErrors.get()) return;  // Skip
                    checkNumber(c, field, language);
                })
                .dependsOn(key, field.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }

    // Overload
    public void createCheckNumber(String key, TextField field, Label label, Language language, Validator validator) {
        createCheckNumber(key, field, label, language, validator, null);
    }


    public void createCheckNumber(String key, TextField field,Boolean nullable, Label label, Validator validator, Language language, SimpleBooleanProperty showErrors) {
        label.getStyleClass().add("label-error");
        validator.createCheck()
                .withMethod(c -> {
                    if (showErrors != null && !showErrors.get()) return;  // Skip
                    if(!nullable) {
                        checkNumber(c, field, language);}  // Assuming you have checkNumber
                else{
                    checkNumberNullable(c,field,language);
                    }
                })
                .dependsOn(key, field.textProperty())
                .decoratingWith(rianaDecoration::fieldDecorator)
                .decorates(field)
                .immediate();

        validator.createCheck()
                .withMethod(c -> {
                    if (showErrors != null && !showErrors.get()) return;  // Skip
                    if(!nullable) {
                        checkNumber(c, field, language);}  // Assuming you have checkNumber
                    else{
                        checkNumberNullable(c,field,language);
                    }
                })
                .dependsOn(key, field.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }

    public void createCheckNumber(String key, TextField field,Boolean nullable, Label label, Language language, Validator validator) {
    createCheckNumber(key,field,nullable,label,validator,language,null);
    }

        public void createCheckRangedNumber(String key, TextField field,Boolean nullable,Integer min,Integer max,Language language,Label label,Validator validator,SimpleBooleanProperty showErrors){
        label.getStyleClass().add("label-error");

        validator.createCheck()
                .withMethod(c->{
                    if (showErrors != null && !showErrors.get()) return;  // Skip

                    if (!nullable){
                        checkRangedNumbers( c,  field, min, max, language);}
                    else{
                        checkRangedNumbersNullable( c, field, min, max, language);
                    }
                })
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::fieldDecorator)
                .decorates(field)
                .immediate();

        validator.createCheck()  .withMethod(c->{
                    if (showErrors != null && !showErrors.get()) return;  // Skip

                    if (!nullable){
                        checkRangedNumbers( c,  field, min, max, language);}
                    else{
                        checkRangedNumbersNullable( c, field, min, max, language);
                    }
                })
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }

    public void createCheckRangedNumber(String key, TextField field,Boolean nullable,Integer min,Integer max,Language language,Label label,Validator validator){
        createCheckRangedNumber(key,field,nullable,min,max,language,label,validator,null);
    }



    public void createCheckFloat(String key, TextField field,Boolean nullable, Label label, Validator validator, Language language, SimpleBooleanProperty showErrors) {
        label.getStyleClass().add("label-error");
        validator.createCheck()
                .withMethod(c -> {
                    if (showErrors != null && !showErrors.get()) return;  // Skip
                    if(!nullable) {
                        checkFloatNullable(c, field, language);}  // Assuming you have checkNumber
                    else{
                        checkFloatNullable(c,field,language);
                    }
                })
                .dependsOn(key, field.textProperty())
                .decoratingWith(rianaDecoration::fieldDecorator)
                .decorates(field)
                .immediate();

        validator.createCheck()
                .withMethod(c -> {
                    if (showErrors != null && !showErrors.get()) return;  // Skip
                    if(!nullable) {
                        checkFloatNullable(c, field, language);}  // Assuming you have checkNumber
                    else{
                        checkFloatNullable(c,field,language);
                    }
                })
                .dependsOn(key, field.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }

    public void createCheckFloat(String key, TextField field,Boolean nullable, Label label, Validator validator, Language language) {
        label.getStyleClass().add("label-error");
        validator.createCheck()
                .withMethod(c -> {
                    if(!nullable) {
                        checkFloat(c, field, language);}
                    else{
                        checkFloatNullable(c,field,language);
                    }
                })
                .dependsOn(key, field.textProperty())
                .decoratingWith(rianaDecoration::fieldDecorator)
                .decorates(field)
                .immediate();

        validator.createCheck()
                .withMethod(c -> {
                    if(!nullable) {
                        checkFloat(c, field, language);}  //
                    else{
                        checkFloatNullable(c,field,language);
                    }
                })
                .dependsOn(key, field.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }


        public void createCheckRangedMultipleNumber(String key, TextField field,Boolean nullable,Integer min,Integer max,String pattern,Language language,Label label,Validator validator){
        label.getStyleClass().add("label-error");

        validator.createCheck()
                .withMethod(c->{
                    if (!nullable){
                        checkRangedNumbersMultiple( c,  field, min, max,pattern, language);}
                    else{
                        checkRangedNumbersMultipleNullable( c, field, min, max,pattern, language);
                    }
                })
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::fieldDecorator)
                .decorates(field)
                .immediate();

        validator.createCheck()
                .withMethod(c->{
                    if (!nullable){
                        checkRangedNumbersMultiple( c,  field, min, max,pattern, language);}
                    else{
                        checkRangedNumbersMultipleNullable( c, field, min, max,pattern, language);
                    }
                })
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }


    public void createCheck01Number(String key, TextField field,Boolean nullable,Language language,Label label,Validator validator){
        label.getStyleClass().add("label-error");

        validator.createCheck()
                .withMethod(c->{
                    if (!nullable){
                        check01( c,  field, language);}
                    else{
                        check01Nullable( c, field, language);
                    }
                })
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::fieldDecorator)
                .decorates(field)
                .immediate();

        validator.createCheck()  .withMethod(c->{
                    if (!nullable){
                        check01( c,  field, language);}
                    else{
                        check01Nullable( c, field, language);
                    }
                })
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }


    public void createCheckMFXNumber(String key, MFXTextField field,Boolean nullable ,Label label,Language language, Validator validator){
        label.getStyleClass().add("label-error");

        validator.createCheck()
                .withMethod(c->{
                    if (!nullable){
                        checkNumber(c,field,language);}
                    else{
                        checkNumberNullable(c,field,language);
                    }
                })
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::mfxTextFieldDecorator)
                .decorates(field)
                .immediate();

        validator.createCheck()
                .withMethod(c->{
                    if (!nullable){
                        checkNumber(c,field,language);}
                    else{
                        checkNumberNullable(c,field,language);
                    }
                })
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }

    //This is specifically for the Auto Appreciation Class
    public void createChevauchCheck(){

    }


    public void createCheckDouble(String key, TextField field,Boolean nullable ,Label label,Language language, Validator validator){
        label.getStyleClass().add("label-error");
        validator.createCheck()
                .withMethod(c->{
                    if (!nullable){
                        checkDouble(c,field,language);}
                    else{
                        checkDoubleNullable(c,field,language);
                    }
                })
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::fieldDecorator)
                .decorates(field)
                .immediate();

        validator.createCheck()
                .withMethod(c->{
                    if (!nullable){
                        checkDouble(c,field,language);}
                    else{
                        checkDoubleNullable(c,field,language);
                    }
                })
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }

    public void createCheckMFXDouble(String key, MFXTextField field,Boolean nullable ,Label label,Language language, Validator validator){
        label.getStyleClass().add("label-error");
        validator.createCheck()
                .withMethod(c->{
                    if (!nullable){
                        checkDouble(c,field,language);}
                    else{
                        checkDoubleNullable(c,field,language);
                    }
                })
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::mfxTextFieldDecorator)
                .decorates(field)
                .immediate();

        validator.createCheck()
                .withMethod(c->{
                    if (!nullable){
                        checkDouble(c,field,language);}
                    else{
                        checkDoubleNullable(c,field,language);
                    }
                })
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }


    public void createCheckOneSix(String key, TextField field ,Label label,Language language, Validator validator) {
        label.getStyleClass().add("label-error");

        validator.createCheck()
                .withMethod(c->{
                    checkOneSix(c,field,language);
                })
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::fieldDecorator)
                .decorates(field)
                .immediate();

        validator.createCheck()
                .withMethod(c->{
                    checkOneSix(c,field,language);
                })
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }

    public void createCheckMFXOneSix(String key, MFXTextField field ,Label label,Language language, Validator validator) {
        label.getStyleClass().add("label-error");

        validator.createCheck()
                .withMethod(c->{
                    checkOneSix(c,field,language);
                })
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::mfxTextFieldDecorator)
                .decorates(field)
                .immediate();

        validator.createCheck()
                .withMethod(c->{
                    checkOneSix(c,field,language);
                })
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }

    public void create (String key,ComboBox comboBox,Label label,Language language,Validator validator){
        label.getStyleClass().add("label-error");

        validator.createCheck()
                .withMethod(c->{
                    checkBlankCombo(c,comboBox,language);
                })
                .dependsOn(key,comboBox.getEditor().textProperty())
                .decoratingWith(rianaDecoration::fieldDecorator)
                .decorates(comboBox.getEditor())
                .immediate();

        validator.createCheck()
                .withMethod(c->{
                    checkBlankCombo(c,comboBox,language);
                })
                .dependsOn(key,comboBox.getEditor().textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }

    public void createCheckBlankCombo(String key,ComboBox comboBox,Label label,Language language,Validator validator,BooleanProperty showError){
        label.getStyleClass().add("label-error");

        validator.createCheck()
                .withMethod(c->{
                    if(showError!=null && !showError.get()) return;
                    checkBlankCombo(c,comboBox,language);
                })
                .dependsOn(key,comboBox.getEditor().textProperty())
                .decoratingWith(rianaDecoration::fieldDecorator)
                .decorates(comboBox.getEditor())
                .immediate();

        validator.createCheck()
                .withMethod(c->{
                    if(showError!=null && !showError.get()) return;
                    checkBlankCombo(c,comboBox,language);
                })
                .dependsOn(key,comboBox.getEditor().textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }

    public void createCheckMFXBlankCombo(String key,MFXComboBox comboBox,Label label,Language language,Validator validator){
        label.getStyleClass().add("label-error");

        validator.createCheck()
                .withMethod(c->{
                    checkBlankCombo(c,comboBox,language);
                })
                .dependsOn(key,comboBox.textProperty())
                .decoratingWith(rianaDecoration::mfxTextFieldDecorator)
                .decorates(comboBox)
                .immediate();

        validator.createCheck()
                .withMethod(c-> checkBlankCombo(c,comboBox,language))
                .dependsOn(key,comboBox.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }

    public <M> void createCheckDuplicateNumberCode(String key, TextField field, Label label, Validator validator,String caller,String callerAddValue,Models<M> models,RianaGetCode<M> rgc,Language language) {
        label.getStyleClass().add("label-error");

        validator.createCheck()
                .withMethod(c -> {
                    checkNumber(c, field,language);
                    if (caller.equals(callerAddValue))
                        if (isDuplicateInteger(field.getText(),models,rgc)) {
                            c.error(caller);
                        }
                })
                .dependsOn(key, field.textProperty())
                .decoratingWith(rianaDecoration::fieldDecorator)
                .decorates(field)
                .immediate();

        validator.createCheck()
                .withMethod(c -> {
                    checkNumber(c, field,language);
                    if (caller.equals(callerAddValue))
                        if (isDuplicateInteger(field.getText(),models,rgc)) {
                            c.error(caller);
                        }
                })
                .dependsOn(key, field.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }

    public <M> void createCheckDuplicateNumberCode(String key, TextField field, Label label, Validator validator,String caller,String callerAddValue,Models<M> models,RianaLongGetCode<M> rgc,Language language) {
        label.getStyleClass().add("label-error");

        validator.createCheck()
                .withMethod(c -> {
                    checkNumber(c, field,language);
                    if (caller.equals(callerAddValue))
                        if (isDuplicateLong(field.getText(),models,rgc)) {
                            c.error(caller);
                        }
                })
                .dependsOn(key, field.textProperty())
                .decoratingWith(rianaDecoration::fieldDecorator)
                .decorates(field)
                .immediate();

        validator.createCheck()
                .withMethod(c -> {
                    checkNumber(c, field,language);
                    if (caller.equals(callerAddValue))
                        if (isDuplicateLong(field.getText(),models,rgc)) {
                            c.error(caller);
                        }
                })
                .dependsOn(key, field.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }


    public <M> void createCheckMFXDuplicateNumberCode(String key, MFXTextField field, Label label, Validator validator,String caller,String callerAddValue,Models<M> models,RianaGetCode<M> rgc,Language language) {
        label.getStyleClass().add("label-error");

        validator.createCheck()
                .withMethod(c -> {
                    checkNumber(c, field,language);
                    if (caller.equals(callerAddValue))
                        if (isDuplicateInteger(field.getText(),models,rgc)) {
                            c.error(caller);
                        }
                })
                .dependsOn(key, field.textProperty())
                .decoratingWith(rianaDecoration::mfxTextFieldDecorator)
                .decorates(field)
                .immediate();

        validator.createCheck()
                .withMethod(c -> {
                    checkNumber(c, field,language);
                    if (caller.equals(callerAddValue))
                        if (isDuplicateInteger(field.getText(),models,rgc)) {
                            c.error(caller);
                        }
                })
                .dependsOn(key, field.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }


    public <M> void createCheckMFXDuplicateLongCode(String key, MFXTextField field, Label label, Validator validator, String caller, String callerAddValue, Models<M> models, RianaLongGetCode<M> rlgc, Language language) {
        label.getStyleClass().add("label-error");

        validator.createCheck()
                .withMethod(c -> {
                    checkNumber(c, field,language);
                    createCheckMFXDuplicateLongCode(key,field,label,validator,caller,callerAddValue,models,rlgc,language);
                })
                .dependsOn(key, field.textProperty())
                .decoratingWith(rianaDecoration::mfxTextFieldDecorator)
                .decorates(field)
                .immediate();

        validator.createCheck()
                .withMethod(c -> {
                    checkNumber(c, field,language);
                    createCheckMFXDuplicateLongCode(key,field,label,validator,caller,callerAddValue,models,rlgc,language);
                })
                .dependsOn(key, field.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }

    public <M> void createCheckDuplicateStringCode(String key, TextField field, Label label, Validator validator,String caller,String callerAddValue,Models<M> models,RianaGetName<M> rgm, String qualification,Language language) {
        label.getStyleClass().add("label-error");

        validator.createCheck()
                .withMethod(c -> {
                    checkBlank(c, field,language);
                    if (caller.equals(callerAddValue))
                        if (isDuplicateString(field.getText(),models,rgm)) {
                            c.error("ce code est déjà utilisé");
                        }
                })
                .dependsOn(key, field.textProperty())
                .decoratingWith(rianaDecoration::fieldDecorator)
                .decorates(field)
                .immediate();

        validator.createCheck()
                .withMethod(c -> {
                    checkBlank(c, field,language);
                    if (caller.equals(callerAddValue))
                        if (isDuplicateString(field.getText(),models,rgm)) {
                            c.error("ce "+qualification+" est déjà utilisé");
                        }
                })
                .dependsOn(key, field.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }

    public <M> void createCheckMFXDuplicateStringCode(String key, MFXTextField field, Label label, Validator validator,String caller,String callerAddValue,Models<M> models,RianaGetName<M> rgm, String qualification,Language language) {
        label.getStyleClass().add("label-error");

        validator.createCheck()
                .withMethod(c -> {
                    checkBlank(c, field,language);
                    if (caller.equals(callerAddValue))
                        if (isDuplicateString(field.getText(),models,rgm)) {
                            c.error("ce code est déjà utilisé");
                        }
                })
                .dependsOn(key, field.textProperty())
                .decoratingWith(rianaDecoration::mfxTextFieldDecorator)
                .decorates(field)
                .immediate();

        validator.createCheck()
                .withMethod(c -> {
                    checkBlank(c, field,language);
                    if (caller.equals(callerAddValue))
                        if (isDuplicateString(field.getText(),models,rgm)) {
                            c.error("ce "+qualification+" est déjà utilisé");
                        }
                })
                .dependsOn(key, field.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }


    public  void createDayCheck(String key, TextField textField, Label label,Language language, Validator validator){
        label.getStyleClass().add("label-error");
        validator.createCheck()
                .withMethod(c->checkDay(c,textField,language))
                .dependsOn(key,textField.textProperty())
                .decoratingWith(rianaDecoration::fieldDecorator)
                .decorates(textField)
                .immediate();

        validator.createCheck()
                .withMethod(c->checkDay(c,textField,language))
                .dependsOn(key,textField.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }

    public  void createDayCheckMFX(String key, MFXTextField textField, Label label,Language language, Validator validator){
        label.getStyleClass().add("label-error");
        validator.createCheck()
                .withMethod(c->checkDay(c,textField,language))
                .dependsOn(key,textField.textProperty())
                .decoratingWith(rianaDecoration::mfxTextFieldDecorator)
                .decorates(textField)
                .immediate();

        validator.createCheck()
                .withMethod(c->checkDay(c,textField,language))
                .dependsOn(key,textField.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }

    public  void createMonthCheck(String key, TextField textField, Label label,Language language, Validator validator){
        label.getStyleClass().add("label-error");
        validator.createCheck()
                .withMethod(c->checkMonth(c,textField,language))
                .dependsOn(key,textField.textProperty())
                .decoratingWith(rianaDecoration::fieldDecorator)
                .decorates(textField)
                .immediate();

        validator.createCheck()
                .withMethod(c->checkMonth(c,textField,language))
                .dependsOn(key,textField.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }

    public  void createMonthCheckMFX(String key, MFXTextField textField, Label label,Language language, Validator validator){
        label.getStyleClass().add("label-error");
        validator.createCheck()
                .withMethod(c->checkMonth(c,textField,language))
                .dependsOn(key,textField.textProperty())
                .decoratingWith(rianaDecoration::mfxTextFieldDecorator)
                .decorates(textField)
                .immediate();

        validator.createCheck()
                .withMethod(c->checkMonth(c,textField,language))
                .dependsOn(key,textField.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }

    public  void createYearCheck(String key, TextField textField, Label label,Language language, Validator validator){
        label.getStyleClass().add("label-error");
        validator.createCheck()
                .withMethod(c->checkYear(c,textField,language))
                .dependsOn(key,textField.textProperty())
                .decoratingWith(rianaDecoration::fieldDecorator)
                .decorates(textField)
                .immediate();

        validator.createCheck()
                .withMethod(c->checkYear(c,textField,language))
                .dependsOn(key,textField.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }

    public  void createYearCheckMFX(String key, MFXTextField textField, Label label,Language language, Validator validator){
        label.getStyleClass().add("label-error");
        validator.createCheck()
                .withMethod(c->checkYear(c,textField,language))
                .dependsOn(key,textField.textProperty())
                .decoratingWith(rianaDecoration::mfxTextFieldDecorator)
                .decorates(textField)
                .immediate();

        validator.createCheck()
                .withMethod(c->checkYear(c,textField,language))
                .dependsOn(key,textField.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }


    public  void createCheckHour(String key, TextField textField, Label label,Language language, Validator validator){
        label.getStyleClass().add("label-error");
        validator.createCheck()
                .withMethod(c->checkHour(c,textField,language))
                .dependsOn(key,textField.textProperty())
                .decoratingWith(rianaDecoration::fieldDecorator)
                .decorates(textField)
                .immediate();

        validator.createCheck()
                .withMethod(c->checkHour(c,textField,language))
                .dependsOn(key,textField.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }

    public  void createCheckWeight(String key, TextField textField, Label label,Language language, Validator validator){
        label.getStyleClass().add("label-error");
        validator.createCheck()
                .withMethod(c->checkWeight(c,textField,language))
                .dependsOn(key,textField.textProperty())
                .decoratingWith(rianaDecoration::fieldDecorator)
                .decorates(textField)
                .immediate();

        validator.createCheck()
                .withMethod(c->checkWeight(c,textField,language))
                .dependsOn(key,textField.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }

    public  void createCheckHeight(String key, TextField textField, Label label,Language language, Validator validator){
        label.getStyleClass().add("label-error");
        validator.createCheck()
                .withMethod(c->checkHeight(c,textField,language))
                .dependsOn(key,textField.textProperty())
                .decoratingWith(rianaDecoration::fieldDecorator)
                .decorates(textField)
                .immediate();

        validator.createCheck()
                .withMethod(c->checkHeight(c,textField,language))
                .dependsOn(key,textField.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }

    public  void createCheckMFXHour(String key, MFXTextField textField, Label label,Language language, Validator validator){
        label.getStyleClass().add("label-error");
        validator.createCheck()
                .withMethod(c->checkHour(c,textField,language))
                .dependsOn(key,textField.textProperty())
                .decoratingWith(rianaDecoration::mfxTextFieldDecorator)
                .decorates(textField)
                .immediate();

        validator.createCheck()
                .withMethod(c->checkHour(c,textField,language))
                .dependsOn(key,textField.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }

    public  void createCheckHour(String key, TextField textField1,TextField textField2, Label label,Language language, Validator validator){
        label.getStyleClass().add("label-error");
        validator.createCheck()
                .withMethod(c->checkHourAfter(c,textField1,textField2,language))
                .dependsOn(key,textField2.textProperty())
                .decoratingWith(rianaDecoration::fieldDecorator)
                .decorates(textField2)
                .immediate();

        validator.createCheck()
                .withMethod(c->checkHourAfter(c,textField1,textField2,language))
                .dependsOn(key,textField2.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }

    public  void createCheckMFXHour(String key, MFXTextField textField1,MFXTextField textField2, Label label,Language language, Validator validator){
        label.getStyleClass().add("label-error");
        validator.createCheck()
                .withMethod(c->checkHourAfter(c,textField1,textField2,language))
                .dependsOn(key,textField2.textProperty())
                .decoratingWith(rianaDecoration::mfxTextFieldDecorator)
                .decorates(textField2)
                .immediate();

        validator.createCheck()
                .withMethod(c->checkHourAfter(c,textField1,textField2,language))
                .dependsOn(key,textField2.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }

//Daty mitambatra

    public  void createCheckDate(String key, DatePicker datePicker, Boolean nullable, Label label, Validator validator,Language language){
        label.getStyleClass().add("label-error");
        validator.createCheck()
                .withMethod(c->{
                    if (!nullable){
                        checkDate(c,datePicker,language);
                    }
                    else{
                        checkDateNullable(c,datePicker,language);
                    }
                })
                .dependsOn(key,datePicker.getEditor().textProperty())
                .decoratingWith(rianaDecoration::fieldDecorator)
                .decorates(datePicker.getEditor())
                .immediate();

        validator.createCheck()
                .withMethod(c->{
                    if (!nullable){
                        checkDate(c,datePicker,language);

                    }
                    else{
                        checkDateNullable(c,datePicker,language);
                    }
                })
                .dependsOn(key,datePicker.getEditor().textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }

    public  void createCheckDate(String key, DatePicker datePicker,Boolean nullable, Label label, Validator validator,DatePicker notBeforeDate,Language language){
        label.getStyleClass().add("label-error");
        validator.createCheck()
                .withMethod(c->{
                    if (!nullable){
                        checkDate(c,datePicker,language);
                    }
                    else{
                        checkDateNullable(c,datePicker,language);
                    }
                    checkDateAfter(c,notBeforeDate,datePicker,language);
                })
                .dependsOn(key,datePicker.getEditor().textProperty())
                .decoratingWith(rianaDecoration::fieldDecorator)
                .decorates(datePicker.getEditor())
                .immediate();

        validator.createCheck()
                .withMethod(c->{
                    if (!nullable){
                        checkDate(c,datePicker,language);
                    }
                    else{
                        checkDateNullable(c,datePicker,language);
                    }
                    checkDateAfter(c,notBeforeDate,datePicker,language);
                })
                .dependsOn(key,datePicker.getEditor().textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }

    public  void createCheckDate(String key, DatePicker datePicker,Boolean nullable, Label label, Validator validator,DatePicker minDateBoundary,DatePicker maxDateBoundary,Language language){
        label.getStyleClass().add("label-error");
        validator.createCheck()
                .withMethod(c->{
                    if (!nullable){
                        checkDate(c,datePicker,language);

                    }
                    else{
                        checkDateNullable(c,datePicker,language);
                    }
                    checkDatesOutOfbounds(c,minDateBoundary,maxDateBoundary,datePicker,language);
                })
                .dependsOn(key,datePicker.getEditor().textProperty())
                .decoratingWith(rianaDecoration::fieldDecorator)
                .decorates(datePicker.getEditor())
                .immediate();

        validator.createCheck()
                .withMethod(c->{
                    if (!nullable){
                        checkDate(c,datePicker,language);
                    }
                    else{
                        checkDateNullable(c,datePicker,language);
                    }
                    checkDatesOutOfbounds(c,minDateBoundary,maxDateBoundary,datePicker,language);
                })
                .dependsOn(key,datePicker.getEditor().textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }


    public  void createCheckDate(String key, DatePicker datePicker,Boolean nullable, Label label, Validator validator,LocalDate minDateBoundary,LocalDate maxDateBoundary,Language language){
        label.getStyleClass().add("label-error");
        validator.createCheck()
                .withMethod(c->{
                    if (!nullable){
                        checkDate(c,datePicker,language);

                    }
                    else{
                        checkDateNullable(c,datePicker,language);
                    }
                    checkCustomDatesOutOfBounds(c,minDateBoundary,maxDateBoundary,datePicker,language);
                })
                .dependsOn(key,datePicker.getEditor().textProperty())
                .decoratingWith(rianaDecoration::fieldDecorator)
                .decorates(datePicker.getEditor())
                .immediate();

        validator.createCheck()
                .withMethod(c->{
                    if (!nullable){
                        checkDate(c,datePicker,language);
                    }
                    else{
                        checkDateNullable(c,datePicker,language);
                    }
                    checkCustomDatesOutOfBounds(c,minDateBoundary,maxDateBoundary,datePicker,language);
                })
                .dependsOn(key,datePicker.getEditor().textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }


    public  void createCheckDate(String key, DatePicker datePicker,Boolean nullable, Label label, Validator validator,DatePicker notBeforeDate,DatePicker minDateBoundary,DatePicker maxDateBoundary,Language language){
        label.getStyleClass().add("label-error");
        validator.createCheck()
                .withMethod(c->{
                    if (!nullable){
                        checkDate(c,datePicker,language);
                    }
                    else{
                        checkDateNullable(c,datePicker,language);
                    }
                    checkDateAfter(c,notBeforeDate,datePicker,language);
                    checkDatesOutOfbounds(c,minDateBoundary,maxDateBoundary,datePicker,language);
                })
                .dependsOn(key,datePicker.getEditor().textProperty())
                .decoratingWith(rianaDecoration::fieldDecorator)
                .decorates(datePicker.getEditor())
                .immediate();

        validator.createCheck()
                .withMethod(c->{
                    if (!nullable){
                        checkDate(c,datePicker,language);
                    }
                    else{
                        checkDateNullable(c,datePicker,language);
                    }
                    checkDateAfter(c,notBeforeDate,datePicker,language);
                    checkDatesOutOfbounds(c,minDateBoundary,maxDateBoundary,datePicker,language);
                })
                .dependsOn(key,datePicker.getEditor().textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }

    //MFX date

    public  void createCheckMFXDate(String key, MFXDatePicker datePicker, Boolean nullable, Label label, Validator validator,Language language){
        label.getStyleClass().add("label-error");
        validator.createCheck()
                .withMethod(c->{
                    if (!nullable){
                        checkMfxDate(c,datePicker,language);
                    }
                    else{
                        checkMfxDateNullable(c,datePicker,language);
                    }
                })
                .dependsOn(key,datePicker.textProperty())
                .decoratingWith(rianaDecoration::mfxTextFieldDecorator)
                .decorates(datePicker)
                .immediate();

        validator.createCheck()
                .withMethod(c->{
                    if (!nullable){
                        checkDate(c,datePicker,language);

                    }
                    else{
                        checkDateNullable(c,datePicker,language);
                    }
                })
                .dependsOn(key,datePicker.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }

    public  void createCheckMFXDate(String key, MFXDatePicker datePicker,Boolean nullable, Label label, Validator validator,MFXDatePicker notBeforeDate,Language language){
        label.getStyleClass().add("label-error");
        validator.createCheck()
                .withMethod(c->{
                    if (!nullable){
                        checkMfxDate(c,datePicker,language);
                    }
                    else{
                        checkMfxDateNullable(c,datePicker,language);
                    }
                    checkDateAfter(c,notBeforeDate,datePicker,language);
                })
                .dependsOn(key,datePicker.textProperty())
                .decoratingWith(rianaDecoration::mfxTextFieldDecorator)
                .decorates(datePicker)
                .immediate();

        validator.createCheck()
                .withMethod(c->{
                    if (!nullable){
                        checkDate(c,datePicker,language);
                    }
                    else{
                        checkDateNullable(c,datePicker,language);
                    }
                    checkDateAfter(c,notBeforeDate,datePicker,language);
                })
                .dependsOn(key,datePicker.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }

    public  void createCheckMFXDate(String key, MFXDatePicker datePicker,Boolean nullable, Label label, Validator validator,MFXDatePicker minDateBoundary,MFXDatePicker maxDateBoundary,Language language){
        label.getStyleClass().add("label-error");
        validator.createCheck()
                .withMethod(c->{
                    if (!nullable){
                        checkMfxDate(c,datePicker,language);

                    }
                    else{
                        checkMfxDateNullable(c,datePicker,language);
                    }
                    checkDatesOutOfbounds(c,minDateBoundary,maxDateBoundary,datePicker,language);
                })
                .dependsOn(key,datePicker.textProperty())
                .decoratingWith(rianaDecoration::mfxTextFieldDecorator)
                .decorates(datePicker)
                .immediate();

        validator.createCheck()
                .withMethod(c->{
                    if (!nullable){
                        checkMfxDate(c,datePicker,language);
                    }
                    else{
                        checkMfxDateNullable(c,datePicker,language);
                    }
                    checkDatesOutOfbounds(c,minDateBoundary,maxDateBoundary,datePicker,language);
                })
                .dependsOn(key,datePicker.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }

    public  void createCheckMFXDate(String key, MFXDatePicker datePicker,Boolean nullable, Label label, Validator validator,MFXDatePicker notBeforeDate,MFXDatePicker minDateBoundary,MFXDatePicker maxDateBoundary,Language language){
        label.getStyleClass().add("label-error");
        validator.createCheck()
                .withMethod(c->{
                    if (!nullable){
                        checkMfxDate(c,datePicker,language);
                    }
                    else{
                        checkMfxDateNullable(c,datePicker,language);
                    }
                    checkDateAfter(c,notBeforeDate,datePicker,language);
                    checkDatesOutOfbounds(c,minDateBoundary,maxDateBoundary,datePicker,language);
                })
                .dependsOn(key,datePicker.textProperty())
                .decoratingWith(rianaDecoration::mfxTextFieldDecorator)
                .decorates(datePicker)
                .immediate();

        validator.createCheck()
                .withMethod(c->{
                    if (!nullable){
                        checkMfxDate(c,datePicker,language);
                    }
                    else{
                        checkMfxDateNullable(c,datePicker,language);
                    }
                    checkDateAfter(c,notBeforeDate,datePicker,language);
                    checkDatesOutOfbounds(c,minDateBoundary,maxDateBoundary,datePicker,language);
                })
                .dependsOn(key,datePicker.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }
//End of MFX date
    public void createCheckIntInferior(String key, TextField field,TextField referenceField ,Label label, Validator validator,Language language){
        label.getStyleClass().add("label-error");
        validator.createCheck()
                .withMethod(c->{
                    checkIntNotInferior(c,field,referenceField,language);
                })
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::fieldDecorator)
                .decorates(field)
                .immediate();

        validator.createCheck()
                .withMethod(c->{
                    checkIntNotInferior(c,field,referenceField,language);
                })
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }

    public void createCheckIntSuperior(String key, TextField field,Integer number ,Label label, Validator validator,Language language){
        label.getStyleClass().add("label-error");
        validator.createCheck()
                .withMethod(c->{
                    checkIntNotSuperior(c,field,number,language);
                })
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::fieldDecorator)
                .decorates(field)
                .immediate();

        validator.createCheck()
                .withMethod(c->{
                    checkIntNotSuperior(c,field,number,language);
                })
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }

    public void createCheckMFXIntInferior(String key, MFXTextField field,MFXTextField referenceField ,Label label, Validator validator,Language language){
        label.getStyleClass().add("label-error");
        validator.createCheck()
                .withMethod(c->{
                    checkIntNotInferior(c,field,referenceField,language);
                })
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::mfxTextFieldDecorator)
                .decorates(field)
                .immediate();

        validator.createCheck()
                .withMethod(c->{
                    checkIntNotInferior(c,field,referenceField,language);
                })
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }


    public void createCheckMFXConfirmPassword(String key, MFXPasswordField p1,MFXPasswordField p2 ,Label label, Validator validator,Language language){
        label.getStyleClass().add("label-error");
        validator.createCheck()
                .withMethod(c->{
                    checkConfirmPassword(p1,p2,c,language);
                })
                .dependsOn(key,p2.textProperty())
                .decoratingWith(rianaDecoration::mfxTextFieldDecorator)
                .decorates(p2)
                .immediate();

        validator.createCheck()
                .withMethod(c->{
                    checkConfirmPassword(p1,p2,c,language);
                })
                .dependsOn(key,p2.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }

    public void createCheckMail(String key,MFXTextField field,Label label,Language language,Validator validator){
        label.getStyleClass().add("label-error");
        validator.createCheck()
                .withMethod(c->{
                    checkMail(c,field,language);
                })
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::mfxTextFieldDecorator)
                .decorates(field)
                .immediate();

        validator.createCheck()
                .withMethod(c->{
                    checkMail(c,field,language);
                })
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }


    public void createCheckIdCard(String key,MFXTextField field,Label label,Language language,Validator validator){
        label.getStyleClass().add("label-error");
        validator.createCheck()
                .withMethod(c->{
                    checkIdCard(c,field,language);
                })
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::mfxTextFieldDecorator)
                .decorates(field)
                .immediate();

        validator.createCheck()
                .withMethod(c->{
                    checkIdCard(c,field,language);
                })
                .dependsOn(key,field.textProperty())
                .decoratingWith(rianaDecoration::labelDecorator)
                .decorates(label)
                .immediate();
    }

    private <M> boolean isDuplicateInteger(String code, Models<M> models, RianaGetCode<M> rgc){
        for (M m :models.getMList()){
            if (code.equals(rgc.getCode(m).toString())){
                return true;
            }
        }
        return false;
    }

    private <M> boolean isDuplicateLong(String code, Models<M> models, RianaLongGetCode<M> rlgc){
        for (M m :models.getMList()){
            if (code.equals(rlgc.getCode(m).toString())){
                return true;
            }
        }
        return false;
    }

    private <M> boolean isDuplicateString(String string, Models<M> models, RianaGetName<M> rgm){
        for (M m :models.getMList()){
            if (string.equals(rgm.getName(m))){
                return true;
            }
        }
        return false;
    }

}
