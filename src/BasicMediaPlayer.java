import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;
import java.io.File;

public class BasicMediaPlayer extends Application {
    @Override
    public void start(Stage stage) {
        File mediaFile = new File("src//2849-163375551_medium.mp4"); 
        Media media = new Media(mediaFile.toURI().toString());

        MediaPlayer mediaPlayer = new MediaPlayer(media);

        MediaView mediaView = new MediaView(mediaPlayer);

        mediaView.setFitWidth(800);
        mediaView.setPreserveRatio(true); 

        Button playButton = new Button("Play");
        playButton.setMinWidth(70); 
        playButton.setOnAction(e -> mediaPlayer.play());

        Button pauseButton = new Button("Pause");
        pauseButton.setMinWidth(70); 
        pauseButton.setOnAction(e -> mediaPlayer.pause());

        Button stopButton = new Button("Stop");
        stopButton.setMinWidth(70); 
        stopButton.setOnAction(e -> mediaPlayer.stop());

        Button forwardButton = new Button(">>");
        forwardButton.setMinWidth(70);
        forwardButton.setOnAction(e -> mediaPlayer.seek(mediaPlayer.getCurrentTime().add(Duration.seconds(10))));

        Button rewindButton = new Button("<<");
        rewindButton.setMinWidth(70); 
        rewindButton.setOnAction(e -> mediaPlayer.seek(mediaPlayer.getCurrentTime().subtract(Duration.seconds(10))));

        Region buttonSpacer = new Region();
        HBox.setHgrow(buttonSpacer, Priority.ALWAYS);

        HBox controls = new HBox(10, playButton, pauseButton, stopButton, rewindButton, forwardButton, buttonSpacer);
        controls.setStyle("-fx-alignment: center;");

        VBox root = new VBox(10, mediaView, controls);

        Scene scene = new Scene(root, 960, 540); 
        stage.setScene(scene);
        stage.setTitle("Basic Media Player");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}