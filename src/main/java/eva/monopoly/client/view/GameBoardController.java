package eva.monopoly.client.view;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import eva.monopoly.api.game.player.Player;
import eva.monopoly.client.MonopolyClient;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GameBoardController implements Initializable {
	@FXML
	Button cards;
	@FXML
	Button streets;
	@FXML
	TextField money;
	@FXML
	Label playerName;
	@FXML
	MenuBar menuBar;
	@FXML
	Label turnName;
	@FXML
	VBox id0;
	@FXML
	VBox id1;
	@FXML
	VBox id2;
	@FXML
	VBox id3;
	@FXML
	VBox id4;
	@FXML
	VBox id5;
	@FXML
	VBox id6;
	@FXML
	VBox id7;
	@FXML
	VBox id8;
	@FXML
	VBox id9;
	@FXML
	VBox id10;
	@FXML
	VBox id11;
	@FXML
	VBox id12;
	@FXML
	VBox id13;
	@FXML
	VBox id14;
	@FXML
	VBox id15;
	@FXML
	VBox id16;
	@FXML
	VBox id17;
	@FXML
	VBox id18;
	@FXML
	VBox id19;
	@FXML
	VBox id20;
	@FXML
	VBox id21;
	@FXML
	VBox id22;
	@FXML
	VBox id23;
	@FXML
	VBox id24;
	@FXML
	VBox id25;
	@FXML
	VBox id26;
	@FXML
	VBox id27;
	@FXML
	VBox id28;
	@FXML
	VBox id29;
	@FXML
	VBox id30;
	@FXML
	VBox id31;
	@FXML
	VBox id32;
	@FXML
	VBox id33;
	@FXML
	VBox id34;
	@FXML
	VBox id35;
	@FXML
	VBox id36;
	@FXML
	VBox id37;
	@FXML
	VBox id38;
	@FXML
	VBox id39;
	private VBox[] streetIDs = { id0, id1, id2, id3, id4, id5, id6, id7, id8, id9, id10, id11, id12, id13, id14, id15,
			id16, id17, id18, id19, id20, id21, id22, id23, id24, id25, id26, id27, id28, id29, id30, id31, id32, id33,
			id34, id35, id36, id37, id38, id39 };
	private String uName;
	private Stage roundWindow;
	private VBox layout;
	private List<Player> players;
	private Player player;

	private static GameBoardController instance;

	public static GameBoardController getInstance() {
		return instance;
	}

	public GameBoardController() {
		instance = this;
	}

	public void initData(String uName) {
		this.uName = uName;
		playerName.setText(uName);
	}

	private void refreshMoney(String amount) {
		// show Money of the Player
		money.setText("" + amount);
	}

	public void showCards() {
		// get Cards from Player and show it in an alert window
	}

	public void showStreets() {
		// get Streets from Player and show it in an alert window
	}

	public void showPlayers() {

	}

	public void startRound() {

		/*
		 * show Dice roll, show data of target field, give button options to buy
		 * or ignore if field is not occupied, give option to place house if
		 * target field and corresponding street is owned by the player
		 */
		if (player.isJailed()) { // give options to either pay 50, use card if
									// in possession, roll dice 3 times
			Label header = new Label("DU BIST IM GEFÄNGNIS!");
			Button firstOpt = new Button("Bezahle M 50");
			Button secondOpt = new Button("Gefängnis-frei Karte");
			Button thirdOpt = new Button("Würfeln");
			firstOpt.setOnAction(e -> {
				MonopolyClient.unjail("money");
			});
			secondOpt.setOnAction(e -> {
				MonopolyClient.unjail("card");
			});
			thirdOpt.setOnAction(e -> {
				MonopolyClient.rollDice();
			});
			HBox dices = new HBox(10);
			dices.setAlignment(Pos.CENTER);
			VBox dice1 = new VBox(10);
			VBox dice2 = new VBox(10);
			Label header1 = new Label("Würfel 1");
			Label header2 = new Label("Würfel 2");
			Label diceNumber1 = new Label();
			Label diceNumber2 = new Label();
			dice1.getChildren().addAll(header1, diceNumber1);
			dice2.getChildren().addAll(header2, diceNumber2);
			dices.getChildren().addAll(dice1, dice2);
			layout = new VBox(10);
			layout.setPadding(new Insets(10, 10, 10, 10));
			layout.getChildren().addAll();
			layout.setAlignment(Pos.CENTER);
			Scene scene = new Scene(layout);
			roundWindow.setScene(scene);
			roundWindow.showAndWait();
		} else {
			HBox dices = new HBox(10);
			dices.setAlignment(Pos.CENTER);
			VBox dice1 = new VBox(10);
			VBox dice2 = new VBox(10);
			Label header1 = new Label("Würfel 1");
			Label header2 = new Label("Würfel 2");
			Label diceNumber1 = new Label();
			Label diceNumber2 = new Label();
			dice1.getChildren().addAll(header1, diceNumber1);
			dice2.getChildren().addAll(header2, diceNumber2);
			dices.getChildren().addAll(dice1, dice2);
			Button rollDice = new Button("Würfeln");
			rollDice.setOnAction(e -> { // send message to Server to roll Dice
				MonopolyClient.rollDice();
			});
			layout = new VBox(10);
			layout.setPadding(new Insets(10, 10, 10, 10));
			layout.getChildren().addAll(dices, rollDice);
			layout.setAlignment(Pos.CENTER);
			Scene scene = new Scene(layout);
			roundWindow.setScene(scene);
			roundWindow.showAndWait();
		}
	}

	public void setDices(int dice1, int dice2) {
		VBox root = (VBox) roundWindow.getScene().getRoot();
		Label diceNumber1 = (Label) ((VBox) ((HBox) root.getChildren().get(0)).getChildren().get(0)).getChildren()
				.get(1);
		Label diceNumber2 = (Label) ((VBox) ((HBox) root.getChildren().get(0)).getChildren().get(1)).getChildren()
				.get(1);
		Button continueBttn = (Button) (root.getChildren().get(1));
		diceNumber1.setText("" + dice1);
		diceNumber2.setText("" + dice2);
		continueBttn.setText("Laufen");
		continueBttn.setOnAction(e -> { 
			MonopolyClient.getStreetData();
		});
	}

	public void menuClose(ActionEvent event) throws IOException {
		Platform.exit();
	}

	public void menuChangeNick(ActionEvent event) throws IOException {
		Parent startUpParent = FXMLLoader.load(getClass().getResource("startupWindow.fxml"));
		Scene startUp = new Scene(startUpParent);
		Stage window = (Stage) menuBar.getScene().getWindow();
		window.setScene(startUp);
		window.show();
	}

	public void menuMainMenu(ActionEvent event) throws IOException {
		goToMainMenu();
	}

	public void setTurnName(String name) {
		turnName.setText(name);
	}

	public void goToMainMenu() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("mainMenu.fxml"));
		Parent mainMenuParent = loader.load();
		Scene mainMenu = new Scene(mainMenuParent);
		Stage window = (Stage) menuBar.getScene().getWindow();
		window.setScene(mainMenu);
		window.show();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

	public void initializeGame(List<Player> players) {
		this.players = players;
		for (Player p : players) {
			if (p.getName().equals(uName)) {
				streetIDs[p.getPositionIndex()].setStyle("-fx-border-color: green;");
				money.setText("" + p.getMoney());
				player = p;
			}
		}
		roundWindow = new Stage();
		roundWindow.initModality(Modality.APPLICATION_MODAL);
		roundWindow.setTitle("Rundenoptionen");
		roundWindow.setMinWidth(400);
		roundWindow.setMinHeight(500);
	}

	public void refreshTurn(Player p) {
		turnName.setText(p.getName());
		streetIDs[p.getPositionIndex()].setStyle("-fx-border-color: red;");
	}
}
