package palleteer.UI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ItemView extends Application{

	@Override
	public void start(Stage stage) {

		//Setting up main frame
		GridPane mainMontage = new GridPane();
		mainMontage.setVgap(5);
		mainMontage.setHgap(5);
		mainMontage.setAlignment(Pos.CENTER);
		mainMontage.setPadding(new Insets(20, 20, 20, 20));

		//Creation of components
		Label codeLabel = new Label("Product code");
		Label nameLabel = new Label("Product name");
		Label weightLabel = new Label("Product weight (kg)");

		TextField codeField = new TextField("");
		TextField nameField = new TextField("");
		TextField weightField = new TextField("");

		Button saveButton = new Button("Save");
		Button closeButton = new Button ("Close");

		//Assembling the components
		mainMontage.add(codeLabel, 0, 0);
		mainMontage.add(nameLabel, 0, 1);
		mainMontage.add(weightLabel, 0, 1);
		mainMontage.add(codeField, 1, 0);
		mainMontage.add(nameField, 1, 1);
		mainMontage.add(weightField, 1, 2);

		mainMontage.add(saveButton, 1, 3);
		mainMontage.add(closeButton, 0, 3);

		Scene setting = new Scene(mainMontage, 200, 400);
		stage.setScene(setting);
		stage.show();


	}

}
