package PantallasService;

import Controllers.AppController;
import Service.ArticuloException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ActualizarArticuloService extends AppController {
	@FXML
	private TextField tfNombre;
	@FXML
	private TextField tfPrecio;

	@FXML
	public void actualizar() {
		try {
			if(service.consultarArticuloNombre(tfNombre.getText()) == null) {
				throw new ArticuloException();
			}

			service.actualizarArticulo(Double.parseDouble(tfPrecio.getText()), tfNombre.getText());
			alertInformativa("El articulo " + tfNombre.getText() + " se ha actualizado correctamente");
			tfNombre.setText("");
			tfPrecio.setText("");
		} catch (NumberFormatException e) {
			alertInformativa("El precio no es valido");
			tfPrecio.setText("");
		} catch (ArticuloException e) {
			alertInformativa("No hay articulo con ese nombre");
			tfNombre.setText("");
			return;
		}
	}

	@FXML
	public void atras() {
		irGestoriarArticulos();
	}
}
