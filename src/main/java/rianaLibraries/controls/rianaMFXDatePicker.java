package rianaLibraries.controls;

import io.github.palexdev.materialfx.controls.MFXDatePicker;

public class rianaMFXDatePicker extends MFXDatePicker {

    public rianaMFXDatePicker(){
        this.getStyleClass().add("custom-date-picker-default");
    }

    public void setFloatingLabel(boolean labelFloat){
        if(labelFloat){
            this.getStyleClass().removeIf(s->s.equals("disable-label-float"));
            this.getStyleClass().add("enable-label-float");
        }
        else{
            this.getStyleClass().removeIf(s->s.equals("enable-label-float"));
            this.getStyleClass().add("disable-label-float");
        }
    }
}
