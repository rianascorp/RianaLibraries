package rianaLibraries.validation;

import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import net.synedra.validatorfx.Decoration;
import net.synedra.validatorfx.ValidationMessage;

public class RianaDecoration {



    public Decoration labelDecorator(ValidationMessage m) {
        return new Decoration() {
            /* */
            @Override
            public void remove(Node target) {
                ((Label) target).setText("");
            }
            @Override
            public void add(Node target) {
                ((Label) target).setText(m.getText());
            }
        };
    }

    public Decoration fxFieldDecorator(ValidationMessage m) {
        return new Decoration() {
            /* */
            @Override
            public void remove(Node target) {
                target.getStyleClass().clear();
                target.getStyleClass().add("jfx-text-field");
            }
            @Override
            public void add(Node target) {
                target.getStyleClass().add("text-input-error");
            }
        };
    }

    public Decoration fieldDecorator(ValidationMessage m) {
        return new Decoration() {
            /* */
            @Override
            public void remove(Node target) {
                target.getStyleClass().clear();
                target.getStyleClass().add("text-input");
            }
            @Override
            public void add(Node target) {
                target.getStyleClass().add("text-input-error");
            }
        };
    }

    public Decoration mfxTextFieldDecorator(ValidationMessage m) {
        return new Decoration() {
            /* */
            @Override
            public void remove(Node target) {
                //target.getStyleClass().clear();
                target.getStyleClass().removeIf("mfx-text-field-error"::equals);
                //target.getStyleClass().add("mfx-text-field-error");

                //target.getStyleClass().add("-mfx-text-field-error");
                //target.setStyle("-fx-border-color: none;");
            }
            @Override
            public void add(Node target) {
                //target.setStyle("-fx-border-color: -mfx-red;");
                target.getStyleClass().add("mfx-text-field-error");
            }
        };
    }



    public Decoration checkDecorator(ValidationMessage m) {
        return new Decoration() {
            /* */
            @Override
            public void remove(Node target) {
                target.getStyleClass().clear();
                target.getStyleClass().add("check-box");
            }
            @Override
            public void add(Node target) {
                target.getStyleClass().add("check-box-error");
            }
        };
    }


}
