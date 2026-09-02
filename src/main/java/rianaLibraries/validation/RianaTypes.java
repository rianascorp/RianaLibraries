package rianaLibraries.validation;

import io.github.palexdev.materialfx.controls.*;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.math.BigInteger;
import java.util.Optional;

public class RianaTypes {

    public Integer nullableMFXTextFieldIntValue(MFXTextField mfxTextField){
        return mfxTextField.getText().isEmpty() || mfxTextField.getText().isBlank()?null:Integer.parseInt(mfxTextField.getText());
    }

    public Double nullableMFXTextFieldDoubleValue(MFXTextField mfxTextField){
        return mfxTextField.getText().isBlank() || mfxTextField.getText().isEmpty()?null:Double.parseDouble(mfxTextField.getText());
    }

    public Long nullableTextFieldLongValue(TextField mfxTextField){
        if (mfxTextField.getText()!=null) {
            return mfxTextField.getText().isEmpty() || mfxTextField.getText().isBlank() ? null : Long.parseLong(mfxTextField.getText());
        }
        else{
            return null;
        }
    }

    public BigInteger nullableTextFieldBigIntValue(TextField mfxTextField){
        if (mfxTextField.getText()!=null) {
            return mfxTextField.getText().isEmpty() || mfxTextField.getText().isBlank() ? null : BigInteger.valueOf(Long.parseLong(mfxTextField.getText()));
        }
        else{
            return null;
        }
    }

    public Long nullableMFXTextFieldLongValue(MFXTextField mfxTextField){
        if (mfxTextField.getText()!=null) {
            return mfxTextField.getText().isEmpty() || mfxTextField.getText().isBlank() ? null : Long.parseLong(mfxTextField.getText());
        }
        else{
            return null;
        }
    }

    public void setIntegerTextField(TextField textField,Integer value){
        if (value!=null){
            textField.setText(value.toString());
        }
    }

    public Integer nullableTextFieldIntValue(TextField mfxTextField){
        if (mfxTextField.getText()!=null) {
            return mfxTextField.getText().isEmpty() || mfxTextField.getText().isBlank() ? null : Integer.parseInt(mfxTextField.getText());
        }
    else{
        return null;
        }
    }

    public Double nullableTextFieldDoubleValue(TextField mfxTextField){
        return mfxTextField.getText().isBlank() || mfxTextField.getText().isEmpty()?null:Double.parseDouble(mfxTextField.getText());
    }

    public Float nullableTextFieldFloatValue(TextField mfxTextField){
        return mfxTextField.getText().isEmpty() || mfxTextField.getText().isBlank()?null:Float.parseFloat(mfxTextField.getText());
    }

    public String nullableTextFieldValue(TextField textField){
        if (textField.getText()!=null) {
            return textField.getText().isEmpty() || textField.getText().isBlank() ? null : textField.getText();
        }
        else{
            return null;
        }
        }

    public String nullableTextAreaValue(TextArea textArea){
        return textArea.getText().isEmpty() || textArea.getText().isBlank()?null:textArea.getText();
    }

    public void setNullableTextField(Object thingToInsert,TextField textField){
        if(thingToInsert!=null){textField.setText(thingToInsert.toString());}else{textField.setText(null);}
    }

    //Kind of rianaTypesInt

    public static Optional<Integer> tryParseInt(String value) {
        try {
            return Optional.of(Integer.parseInt(value));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    public static Optional<Float> tryParseFloat(String value) {
        try {
            return Optional.of(Float.parseFloat(value));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    public static Optional<Long> tryParseLong(String value) {
        try {
            return Optional.of(Long.parseLong(value));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

}
