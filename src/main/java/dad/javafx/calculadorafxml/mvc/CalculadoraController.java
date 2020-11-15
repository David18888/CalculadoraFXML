package dad.javafx.calculadorafxml.mvc;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.javafx.calculadorafxml.main.Calculadora;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class CalculadoraController implements Initializable {

	
private Calculadora calculadora= new Calculadora();	
	

@FXML
private GridPane view;

@FXML
private Button ceroButton, unoButton,dosButton,tresButton,cuatroButton,cincoButton,
seisButton,sieteButton,ochoButton,nueveButton,sumaButton,restaButton,divButton,multButton,comaButton,igualButton,borraButton,borraTButton;

@FXML
private TextField pantallaText;

private StringProperty pantallaProperty= new SimpleStringProperty();



	
public CalculadoraController() throws IOException{

	FXMLLoader loader= new FXMLLoader(getClass().getResource("/fxml/CalculadoraView.fxml"));
	loader.setController(this);
	loader.load();
	
}




@Override
public void initialize(URL location, ResourceBundle resources) {
	
	
	pantallaText.textProperty().bind(pantallaProperty);

	
	ceroButton.setOnAction(e->onNumberButtonAction(ceroButton.getText()));
	unoButton.setOnAction(e->onNumberButtonAction(unoButton.getText()));
	dosButton.setOnAction(e->onNumberButtonAction(dosButton.getText()));
	tresButton.setOnAction(e->onNumberButtonAction(tresButton.getText()));
	cuatroButton.setOnAction(e->onNumberButtonAction(cuatroButton.getText()));
	cincoButton.setOnAction(e->onNumberButtonAction(cincoButton.getText()));
	seisButton.setOnAction(e->onNumberButtonAction(seisButton.getText()));
	sieteButton.setOnAction(e->onNumberButtonAction(sieteButton.getText()));
	ochoButton.setOnAction(e->onNumberButtonAction(ochoButton.getText()));
	nueveButton.setOnAction(e->onNumberButtonAction(nueveButton.getText()));
	
	
	
	sumaButton.setOnAction(e->onOperacionAction("suma",'+'));
	restaButton.setOnAction(e->onOperacionAction("resta",'-'));
	divButton.setOnAction(e->onOperacionAction("division",'/'));
	multButton.setOnAction(e->onOperacionAction("multiplicacion",'*'));
	igualButton.setOnAction(e->onOperacionAction("igual",'='));
	comaButton.setOnAction(e->onOperacionAction("coma",'.'));
	borraButton.setOnAction(e->onOperacionAction("borrar",'0'));
	borraTButton.setOnAction(e->onOperacionAction("borrarTodo",'0'));
	
	
	
	
	
	
	
}




private void onOperacionAction(String operacion, char operador ) {
	switch(operacion) {
	
	case "suma":
	case "resta":
	case "division":
	case "multiplicacion":
	case "igual":	
		
		calculadora.operar(operador);
		break;
		
	case "coma":
		calculadora.insertarComa();
		break;
	
	case "borrar":
		calculadora.borrar();
		break;
	case "borrarTodo":
		calculadora.borrarTodo();
		break;
		
		default: break;
	}
	
	pantallaProperty.set(calculadora.getPantalla());
}


private void onNumberButtonAction(String number) {
	calculadora.insertar(number.charAt(0));
	pantallaProperty.set(calculadora.getPantalla());
}
	
	
public GridPane getView() {
	return view;
}	
	
}
