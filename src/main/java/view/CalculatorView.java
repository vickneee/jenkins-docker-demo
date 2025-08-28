package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CalculatorView extends Application {

    /**
     * Starts the JavaFX application by loading the FXML file and setting up the primary stage.
     *
     * @param primaryStage The primary stage for this application.
     * @throws Exception If an error occurs during the loading of the FXML file.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/calculator_view.fxml"));
            Parent root = fxmlLoader.load();

            primaryStage.setScene(new Scene(root));
            // primaryStage.setTitle("Calculator");
            primaryStage.setResizable(false);
            primaryStage.show();
        } catch (Exception e) {
            System.out.println("Error loading FXML file: " + e.getMessage());
        }
    }

}
