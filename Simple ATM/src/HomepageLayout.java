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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class HomepageLayout {
	
	private Stage stage;
	private Scene scene;
	private LoginLayout loginLayout;
	private WithdrawlLayout withdrawlLayout;
	private DepositLayout depositLayout;
	private BankCard bankCard;
	private ArrayList<Transaction> history=new ArrayList<>(5);
		
	HomepageLayout(Stage stage,BankCard bankCard) {
		this.stage=stage;
		this.bankCard=bankCard;
	}
	
	public void prepareScene()
	{
		Background buttonBackground=new Background(new BackgroundFill(Color.WHITE,CornerRadii.EMPTY, Insets.EMPTY));
		Label operationLabel=new Label("What do you want to do?");
		Label label= new Label();
		
		operationLabel.setPadding(new Insets(30));
		operationLabel.setStyle("-fx-font-weight: bold");
		operationLabel.setFont(Font.font(24));
		operationLabel.setTextFill(Color.ALICEBLUE);
		
		label.setPadding(new Insets(30));
		label.setFont(Font.font(16));
		label.setTextFill(Color.STEELBLUE);
		label.setStyle("-fx-font-weight: bold");

		Button withdrawlButton=new Button("Withdrawal");
		Button depositButton=new Button("Deposit");
		Button balanceButton=new Button("Balance Inquiry");
		Button nextButton=new Button("Next");
		Button previousButton=new Button("Previous");
		Button exitButton=new Button("Exit");
		
		nextButton.setMinWidth(100);
		previousButton.setMinWidth(100);
		withdrawlButton.setMinWidth(100);
		depositButton.setMinWidth(100);
		exitButton.setMinWidth(100);
		balanceButton.setMinWidth(100);
		
		withdrawlButton.setBackground(buttonBackground);
		depositButton.setBackground(buttonBackground);
		balanceButton.setBackground(buttonBackground);
		nextButton.setBackground(buttonBackground);
		previousButton.setBackground(buttonBackground);
		exitButton.setBackground(buttonBackground);
		
		GridPane grid= new GridPane();
		
		grid.setHgap(5);
		grid.setVgap(5);
		
		grid.add(balanceButton, 0, 0);
		grid.add(withdrawlButton, 1, 0);
		grid.add(depositButton, 2, 0);
		grid.add(nextButton, 1, 1);
		grid.add(previousButton, 0,1);
		grid.add(exitButton, 2,1);
		grid.setAlignment(Pos.CENTER);
		
		BorderPane layout=new BorderPane();
		layout.setAlignment(operationLabel, Pos.TOP_CENTER);
		layout.setAlignment(label, Pos.BOTTOM_CENTER);
		
		layout.setCenter(grid);
		layout.setTop(operationLabel);
		
		layout.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE,CornerRadii.EMPTY, Insets.EMPTY)));
		
		scene=new Scene(layout,450,350,Color.AQUA);
		
		withdrawlButton.setOnAction(e-> {
			nextButton.setDisable(true);
			stage.setScene(withdrawlLayout.getScene());
		});
		
		depositButton.setOnAction(e-> {
			nextButton.setDisable(true);
			stage.setScene(depositLayout.getScene());});

		balanceButton.setOnAction(e->{
			previousButton.setDisable(false);
			nextButton.setDisable(true);
			label.setText("Current Balance: " + bankCard.getBalance() );
			layout.setBottom(label);
			
		});	
		
		if(history.isEmpty()==true)
				previousButton.setDisable(true);
			
		nextButton.setDisable(true);

	       // Adjusting the previous button.
		previousButton.setOnAction(e->{
				Transaction transaction=bankCard.previous();
				if(bankCard.getI()<history.size()-1)
				     nextButton.setDisable(false);
				label.setText(transaction.getType() + ": "+transaction.getValue());
				layout.setBottom(label);	
				if(bankCard.getI()-1<0)
					previousButton.setDisable(true);	
			});
          // Done adjusting the previous button
			
		nextButton.setOnAction(e->{
				Transaction transaction=bankCard.next();
				previousButton.setDisable(false);
					label.setText(transaction.getType() + ": "+transaction.getValue());
					layout.setBottom(label);
					if(bankCard.getI()+1==history.size())
						nextButton.setDisable(true);
					
		});
		
		exitButton.setOnAction(e->{
			history=bankCard.getHistory();
			history.clear();
			bankCard.setI(0);
			loginLayout.setCount(0);
			loginLayout.prepareScene();
			stage.setScene(loginLayout.getScene());
			
		});
		
	}

	
	public Scene getScene()
	{
		return scene;
	}
	
	public void setWithdrawlLayout(WithdrawlLayout withdrawlLayout) {
		this.withdrawlLayout = withdrawlLayout;
	}
	
	public void setDepositLayout(DepositLayout depositLayout) {
		this.depositLayout = depositLayout;
	}
	
    
    public void setHistory(ArrayList<Transaction> history) {
		this.history = history;
	}
    
    public void setLoginLayout(LoginLayout loginLayout) {
		this.loginLayout = loginLayout;
	}
    

}
