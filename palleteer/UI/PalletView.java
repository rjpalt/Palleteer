package palleteer.UI;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import palleteer.domain.Pallet;
import palleteer.domain.PalletType;


public class PalletView extends Application {

	@Override
	public void start(Stage stage) {

		//Initialization of a new pallet
		Pallet pallet = new Pallet();

		//Creation of the mainframe
		BorderPane mainMontage = new BorderPane();

		//TopControl section
		BorderPane topControls = new BorderPane();
		topControls.setPadding(new Insets(20, 20, 20, 20));

		//Closebutton section
		Button closeWindowButton = new Button("Close");
		closeWindowButton.setPadding(new Insets(5, 5, 5, 5));
		closeWindowButton.setAlignment(Pos.TOP_LEFT);

		closeWindowButton.setOnAction((event) -> {
			stage.close();
		});

		//Label for the pallet info for top section
		Label summaryLabel = new Label("");
		summaryLabel.setPadding(new Insets(5, 5, 5, 5));
		summaryLabel.setAlignment(Pos.TOP_CENTER);

		//TypeMenu section
		MenuButton typeMenu = new MenuButton("Pallet type");
		typeMenu.setLineSpacing(10);
		typeMenu.setPadding(new Insets(5, 5, 5, 5));

		//Creation of the MenuItems for the TypeMenu
		MenuItem fin = new MenuItem("FIN");
		fin.setOnAction((event) -> {
			typeMenu.setText("FIN");
			pallet.setType(PalletType.FIN);
			summaryLabel.setText(pallet.toString());
		});

		MenuItem eur = new MenuItem("EUR");
		eur.setOnAction((event) -> {
			typeMenu.setText("EUR");
			pallet.setType(PalletType.EUR);
			summaryLabel.setText(pallet.toString());
		});

		MenuItem teho = new MenuItem("TEHO");
		teho.setOnAction((event) -> {
			typeMenu.setText("TEHO");
			pallet.setType(PalletType.TEHO);
			summaryLabel.setText(pallet.toString());
		});

		MenuItem other = new MenuItem("OTHER");
		other.setOnAction((event) -> {
			typeMenu.setText("OTHER");
			pallet.setType(PalletType.MUU);
			summaryLabel.setText(pallet.toString());
		});

		typeMenu.getItems().addAll(fin, eur, teho, other);

		//Assembly of the top controls section
		topControls.setLeft(closeWindowButton);
		topControls.setCenter(summaryLabel);
		topControls.setRight(typeMenu);

		ListView itemList = new ListView();

		HBox bottomControls = new HBox();
		bottomControls.setSpacing(25);
		bottomControls.setPadding(new Insets(20, 20, 20, 20));
		bottomControls.setAlignment(Pos.CENTER);

		Button changeButton = new Button("Change line");
		Button addLineButton = new Button("Add line");
		Button removeLineButton = new Button("Remove line");
		Button addItemButton = new Button("+");
		Button removeItemButton = new Button("-");

		bottomControls.getChildren().addAll(changeButton, addLineButton, removeLineButton, addItemButton, removeItemButton);

		mainMontage.setTop(topControls);
		mainMontage.setCenter(itemList);
		mainMontage.setBottom(bottomControls);

		Scene setting = new Scene(mainMontage, 750, 500);

		stage.setTitle("New pallet");
		stage.setScene(setting);
		stage.show();


	}

}

//2-do -list:
// 1) Tutki kuinka saisit MenuItemien valinnan toimimaan fiksummin.
