
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;



public class LoginLayout  {
	
	private Stage stage;
	private Scene scene;
	private HomepageLayout homepageLayout;
	private BankCard bankCard;
	private int count=0;
	
	LoginLayout(Stage stage,BankCard bankCard) {
		this.stage=stage;
		this.bankCard=bankCard;
	}
	
	public void prepareScene()
	{
		Label welcomeLabel=new Label("Welcome to my ATM Machine");
		Label cardNumberLabel = new Label("Card Number");
		TextField cardNumberField= new TextField();
		Label pincodeLabel = new Label("Pincode");
		PasswordField pincodeField= new PasswordField();
		
		cardNumberLabel.setTextFill(Color.ALICEBLUE);
		pincodeLabel.setTextFill(Color.ALICEBLUE);
		welcomeLabel.setTextFill(Color.ALICEBLUE);
		
		cardNumberLabel.setFont(Font.font(16));
		welcomeLabel.setFont(Font.font(20));
		pincodeLabel.setFont(Font.font(16));
		
		cardNumberLabel.setStyle("-fx-font-weight: bold");
		welcomeLabel.setStyle("-fx-font-weight: bold");
		pincodeLabel.setStyle("-fx-font-weight: bold");
		
		Label errorMessage=new Label("Invalid Card Number or Incorrect Pincode.");
		errorMessage.setTextFill(Color.RED);
		
		Button enterButton=new Button("Enter");
		enterButton.setDefaultButton(true);
		enterButton.setStyle("-fx-background-color: #FFFFFF");
		
		GridPane grid=new GridPane();
		
		grid.setHgap(5);
		grid.setVgap(5);
		
		grid.add(welcomeLabel, 1, 0);
		grid.add(cardNumberLabel, 0, 3);
		grid.add(cardNumberField, 1, 3);
		grid.add(pincodeLabel, 0, 4);
		grid.add(pincodeField, 1, 4);
		grid.add(enterButton, 1, 6);
		
		grid.setAlignment(Pos.CENTER);
		grid.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE,CornerRadii.EMPTY, Insets.EMPTY)));
		
		scene=new Scene(grid,450,350);
		
        enterButton.setOnAction(e->{
        	String check= cardNumberField.getText();
        	String check2=pincodeField.getText();
        	if(check.equals(bankCard.getCardNumber()) && check2.equals(bankCard.getPincode()))
        	{
        		homepageLayout.prepareScene();
        		stage.setScene(homepageLayout.getScene());     			
        	}
        	else if(count==0)
        	{
        		grid.add(errorMessage,1,5);
        		count++;
        	}
        	
        });

	}	
	
	public Scene getScene() {
		return scene;
	}
	
	public void setHomepageLayout(HomepageLayout homepageLayout) {
		this.homepageLayout = homepageLayout;
	}
	
	public void setCount(int count) {
		this.count = count;
	}


}


