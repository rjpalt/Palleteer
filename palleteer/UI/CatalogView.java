package palleteer.UI;

import java.sql.SQLException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import palleteer.domain.HawleItem;
import palleteer.logic.PalleteerDAO;

public class CatalogView extends Application{

	private ArrayList<HawleItem> catalog;

	@Override
	public void start(Stage stage) {

		PalleteerDAO dao = new PalleteerDAO();

		try {
			catalog = dao.list();
		} catch (SQLException t) {
			System.out.println(t.getMessage());
		}


		BorderPane mainMontage = new BorderPane();
		ListView<String> catalogList = new ListView<String>();
		GridPane controlPane = new GridPane();

		//GridPane buttons
		Button closeButton = new Button("Close");
		Button editButton = new Button ("Edit");
		Button addButton = new Button ("Add");
		Button removeButton = new Button ("Remove");
		Button selectButton = new Button ("Select");

		//GridPane settings and assembly
		controlPane.setPadding(new Insets(20, 20, 20, 20));
		controlPane.setVgap(5);
		controlPane.setHgap(30);
		controlPane.setAlignment(Pos.BOTTOM_CENTER);
		controlPane.add(selectButton, 0, 0);
		controlPane.add(editButton, 1, 0);
		controlPane.add(addButton, 2, 0);
		controlPane.add(removeButton, 3, 0);
		controlPane.add(closeButton, 0, 1);

		//Assembly and setup of ListView
		catalog.stream().forEach((item) -> {
			StringBuilder newItem = new StringBuilder();
			newItem.append(item.getProductId() + "\t" + item.getName() + "\t"+ item.getTotalWeight());
			catalogList.getItems().add(newItem.toString());
		});

		//Close-button assembly and setup
		closeButton.setOnAction((event) -> {
			stage.close();
		});

		//Edit-button assembly and setup
		//Requires edit screen
		editButton.setOnAction((event) -> {
			ItemView newItemView = new ItemView();
			Stage newStage = new Stage();
			newItemView.start(newStage);
		});

		//Add-button assembly and setup
		addButton.setOnAction((event) -> {
			ItemView newItemView = new ItemView();
			Stage newStage = new Stage();
			newItemView.start(newStage);
		});

		mainMontage.setTop(catalogList);
		mainMontage.setBottom(controlPane);

		Scene setting = new Scene(mainMontage, 750, 500);

		stage.setTitle("Catalog window!");
		stage.setScene(setting);
		stage.show();

	}

}
