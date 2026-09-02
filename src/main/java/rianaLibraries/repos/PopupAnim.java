package rianaLibraries.repos;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PopupAnim extends Application {
    @Override
    public void start(Stage primaryStage){
        ContextMenu cm=new ContextMenu(new MenuItem("Item 1"),new MenuItem("Item 2"));
        StackPane root=new StackPane();
        Scene scene=new Scene(root,300,250);
        scene.setOnContextMenuRequested(event ->{
            cm.show(root,event.getScreenX(),event.getScreenY());

            double yIni=scene.getWindow().getY();
            double yEnd=cm.getY();
            cm.setY(yIni);

            final DoubleProperty yProperty=new SimpleDoubleProperty(yIni);
            yProperty.addListener((ob,n,n1)->cm.setY(n1.doubleValue()));

            Timeline timeline=new Timeline();
            timeline.getKeyFrames().add(
                    new KeyFrame(Duration.seconds(0.5),
                            new KeyValue(yProperty,yEnd, Interpolator.EASE_BOTH)));
            timeline.play();
        });
        primaryStage.setTitle("Moving popup");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
