import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class DoneLayout {
	
	private Stage stage;
	private Scene scene;
	private HomepageLayout homepageLayout;
	private String message;
	private LoginLayout loginLayout;
	private ArrayList<Transaction> history;
    private BankCard bankCard;
	
	DoneLayout(Stage stage,BankCard bankCard) {
		this.stage=stage;
		this.bankCard=bankCard;
	}
	
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void prepareScene()
	{
		Label doneLabel = new Label(message);
		Label transactionLabel=new Label("Would you like to make another transaction?");
		doneLabel.setTextFill(Color.GREEN);
		transactionLabel.setTextFill(Color.STEELBLUE);
		transactionLabel.setFont(Font.font(14));
		Button noButton=new Button("No");
        Button yesButton=new Button("Yes");
        yesButton.setMinWidth(40);
        noButton.setMinWidth(40);
        
		GridPane grid=new GridPane();
		grid.add(doneLabel, 0, 0);
		grid.add(transactionLabel, 0, 1);
		grid.setAlignment(Pos.CENTER);
		HBox downMenu=new HBox();
		downMenu.getChildren().addAll(yesButton,noButton);
		downMenu.setAlignment(Pos.CENTER);
		BorderPane layout=new BorderPane();
		layout.setCenter(grid);
		layout.setBottom(downMenu);
		layout.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE,CornerRadii.EMPTY, Insets.EMPTY)));
		scene=new Scene(layout,450,350);
		
		yesButton.setOnAction(e->{
			homepageLayout.prepareScene();
			stage.setScene(homepageLayout.getScene());
		});
		
		noButton.setOnAction(e->{
			history=bankCard.getHistory();
			history.clear();
			homepageLayout.setHistory(history);
			bankCard.setI(0);
			loginLayout.prepareScene();
			stage.setScene(loginLayout.getScene());
		});
		
		
	}
	
	public void setHomepageLayout(HomepageLayout homepageLayout) {
		this.homepageLayout = homepageLayout;
	}
	
	public Scene getScene() {
		return scene;
	}
	
	public void setLoginLayout(LoginLayout loginLayout) {
		this.loginLayout = loginLayout;
	}
	
}
