import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CalculatorLayout extends Application {
    @Override
    public void start(Stage stage) {
        // Create GridPane layout
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);  // Center the buttons in the grid
        grid.setHgap(10);  // Horizontal gap between buttons
        grid.setVgap(10);  // Vertical gap between buttons

        // Array of button labels
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        // Initialize row and column for button placement
        int row = 0, col = 0;
        for (String text : buttons) {
            Button button = new Button(text);
            button.setMinSize(50, 50);  // Set size of each button
            grid.add(button, col, row);  // Add button to grid

            col++;
            if (col == 4) {
                col = 0;
                row++;
            }
        }

        // Set up the scene with the grid and window size
        Scene scene = new Scene(grid, 250, 300);
        stage.setScene(scene);
        stage.setTitle("Calculator Layout");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
