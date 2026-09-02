package rianaLibraries.repos;
import javafx.application.Application;
import javafx.stage.Stage;

public class FxButtonExample extends Application {
    @Override
    public void start(Stage stage) throws Exception {

    }
   /* // Create the Message Label
    Label messageLbl = new Label("Press any Button to see the message");

    public static void main(String[] args) {

        Application.launch(args);

    }
    @Override
    public void start(Stage stage)
    {
        // Create a normal button with N as its mnemonic
        Button newBtn = new Button("_New");
        // Add EventHandler to the Button
        newBtn.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent e)
            {
                printMessage("You have pressed the new Button");
            }
        });

// Create a default button with S as its mnemonic
        Button saveBtn = new Button("_Save");
// Set this Button as the Default
        saveBtn.setDefaultButton(true);
// Add EventHandler to the Button
        saveBtn.setOnAction(new EventHandler<ActionEvent>()
        {
@Override public void handle(ActionEvent e)
        {
        printMessage("You have pressed the save Button");
        }
// Create a cancel button with C as its mnemonic
        Button cancelBtn = new Button("_Cancel");
        cancelBtn.setCancelButton(true);
// Add EventHandler to the Button
        cancelBtn.setOnAction(new EventHandler<ActionEvent>()
        {
@Override public void handle(ActionEvent e)
        {
        printMessage("You have pressed the cancel Button");
        }
// Create the HBox
        HBox buttonBox = new HBox();
// Add the children to the HBox
        buttonBox.getChildren().addAll(newBtn, saveBtn, cancelBtn);
// Set the vertical spacing between children to 15px
        buttonBox.setSpacing(15);
// Create the VBox
        VBox root = new VBox();
// Add the children to the VBox
        root.getChildren().addAll(messageLbl, buttonBox);
// Set the vertical spacing between children to 15px
        root.setSpacing(15);
// Set the Size of the VBox
        root.setMinSize(350, 250);
/*
 * Set the padding of the VBox
 * Set the border-style of the VBox
 * Set the border-width of the VBox
}
 * Set the border-insets of the VBox
 * Set the border-radius of the VBox
 * Set the border-color of the VBox
*/
    //INCOMPLETE VERSION
}