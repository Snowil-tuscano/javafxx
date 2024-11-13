import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EventHandlingDemo extends Application {

    @Override
    public void start(Stage stage) {
        // Create UI elements
        TextField textField = new TextField();
        Button button = new Button("Display Text");
        Label label = new Label();

        // Event handler for button
        button.setOnAction(e -> label.setText("Text: " + textField.getText()));

        // Layout and Scene setup
        VBox root = new VBox(10, textField, button, label);
        Scene scene = new Scene(root, 300, 200);

        // Stage setup
        stage.setScene(scene);
        stage.setTitle("Event Handling Demo");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
