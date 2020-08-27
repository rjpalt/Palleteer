
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import palleteer.UI.CatalogView;
import palleteer.UI.PalletView;


public class Palleteer extends Application {

	@Override
	public void start(Stage stage) {

		BorderPane mainMontage = new BorderPane();

		HBox middleBox = new HBox();
		middleBox.setSpacing(40);
		middleBox.setPadding(new Insets(20, 20, 20, 20));
		middleBox.setAlignment(Pos.CENTER);

		Button catalogButton = new Button("Catalog");
		catalogButton.setFont(Font.font("Monospaced", 50));
		catalogButton.setOnAction((event) -> {
			CatalogView openCatalog = new CatalogView();
			Stage catalogStage = new Stage();
			openCatalog.start(catalogStage);
		});

		Button createPallet = new Button("New Pallet");
		createPallet.setFont(Font.font("Monospaced", 50));
		createPallet.setOnAction((event) -> {
			PalletView newPallet = new PalletView();
			Stage palletStage = new Stage();
			newPallet.start(palletStage);
		});

		middleBox.getChildren().addAll(catalogButton, createPallet);

		mainMontage.setCenter(middleBox);

		Scene mainMenu = new Scene(mainMontage, 1024, 768);

		stage.setTitle("The Palleteer!");
		stage.setScene(mainMenu);
		stage.show();

	}

	public static void main(String[] args) {

		launch(Palleteer.class);

	}

}
