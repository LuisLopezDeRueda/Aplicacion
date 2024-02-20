package PantallasService;

import Controllers.AppController;
import Modelo.Cliente;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CrearClienteService extends AppController {
	@FXML
	private TextField tfNombre;
	@FXML
	private TextField dni;

	@FXML
	public void crearCliente() {

		if (dni.getText().isBlank() || tfNombre.getText().isBlank()) {
			alert("Los campos tienen que estar rellenos");
			dni.setText("");
			tfNombre.setText("");
		} else if (service.consultarCliente(dni.getText()) == null) {
			service.insertarCliente(new Cliente(dni.getText(), tfNombre.getText()));
			alertInformativa("El cliente con el dni " + dni.getText() + " ha sido añadido correctamente");
			atras();
		} else {
			alert("Cliente existente con ese dni");
			dni.setText("");
		}
	}

	@FXML
	public void atras() {
		irUsuario();
	}
}
