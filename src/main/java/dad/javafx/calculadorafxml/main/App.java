package dad.javafx.calculadorafxml.main;

import dad.javafx.calculadorafxml.mvc.CalculadoraController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
	
	
	private CalculadoraController controller;
	
	

	@Override
	public void start(Stage primaryStage) throws Exception {
	
		
		controller= new CalculadoraController();
		Scene scene= new Scene (controller.getView(),400,340);
		primaryStage.setScene(scene);
		primaryStage.setTitle("CalculadoraFXML");
		primaryStage.show();
		
	

	}

	public static void main(String[] args) {
     launch(args);

	}

}
