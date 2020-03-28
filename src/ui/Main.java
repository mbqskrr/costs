package ui;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
            Parent root = FXMLLoader.load(getClass().getResource("PayrollGUI.fxml"));
            primaryStage.setTitle("Nomina");
            primaryStage.setScene(new Scene(root));
            primaryStage.setResizable(true);
            primaryStage.show();
        } catch (Exception e) {
            e.getMessage();
        }
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
