import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class KeypadLayout {
	

	private Scene scene;
	private TextField numberField=new TextField();
	private Button okButton = new Button("Ok");
	private	Button cancelButton=new Button("Cancel");
	public void prepareScene()
	{
		Background buttonBackground=new Background(new BackgroundFill(Color.LIGHTBLUE,CornerRadii.EMPTY, Insets.EMPTY));
		Button b0= new Button("0");
		Button b1= new Button("1");
		Button b2= new Button("2");
		Button b3= new Button("3");
		Button b4= new Button("4");
		Button b5= new Button("5");
		Button b6= new Button("6");
		Button b7= new Button("7");
		Button b8= new Button("8");
		Button b9= new Button("9");

		b0.setBackground(buttonBackground);
		b1.setBackground(buttonBackground);
		b2.setBackground(buttonBackground);
		b3.setBackground(buttonBackground);
		b4.setBackground(buttonBackground);
		b5.setBackground(buttonBackground);
		b6.setBackground(buttonBackground);
		b7.setBackground(buttonBackground);
		b8.setBackground(buttonBackground);
		b9.setBackground(buttonBackground);
		
		b0.setTextFill(Color.ALICEBLUE);
		b1.setTextFill(Color.ALICEBLUE);
		b2.setTextFill(Color.ALICEBLUE);
		b3.setTextFill(Color.ALICEBLUE);
		b4.setTextFill(Color.ALICEBLUE);
		b5.setTextFill(Color.ALICEBLUE);
		b6.setTextFill(Color.ALICEBLUE);
		b7.setTextFill(Color.ALICEBLUE);
		b8.setTextFill(Color.ALICEBLUE);
		b9.setTextFill(Color.ALICEBLUE);
		
		b0.setFont(Font.font(16));
		b1.setFont(Font.font(16));
		b2.setFont(Font.font(16));
		b3.setFont(Font.font(16));
		b4.setFont(Font.font(16));
		b5.setFont(Font.font(16));
		b6.setFont(Font.font(16));
		b7.setFont(Font.font(16));
		b8.setFont(Font.font(16));
		b9.setFont(Font.font(16));
		
		numberField.setPromptText("Enter amount");
		
		GridPane grid=new GridPane();
		grid.setPadding(new Insets(30));

		grid.setVgap(8);
		grid.setHgap(8);
		
		GridPane.setConstraints(b1, 0,1);
		GridPane.setConstraints(b2, 1,1);
		GridPane.setConstraints(b3, 2,1);
		GridPane.setConstraints(b4, 0,2);
		GridPane.setConstraints(b5, 1,2);
		GridPane.setConstraints(b6, 2,2);
		GridPane.setConstraints(b7, 0,3);
		GridPane.setConstraints(b8, 1,3);
		GridPane.setConstraints(b9, 2,3);
		GridPane.setConstraints(b0, 1,4);

		
		grid.getChildren().addAll(b0,b1,b2,b3,b4,b5,b6,b7,b8,b9);
		grid.setAlignment(Pos.CENTER);
		
		HBox hbox =new HBox();
		hbox.getChildren().setAll(numberField,okButton,cancelButton);
		hbox.setAlignment(Pos.BOTTOM_CENTER);
		
		
		BorderPane layout=new BorderPane();
		layout.setBackground(new Background(new BackgroundFill(Color.GHOSTWHITE,CornerRadii.EMPTY, Insets.EMPTY)));
		layout.setCenter(grid);
		layout.setBottom(hbox);
		
		scene=new Scene(layout,450,350);
		
		b0.setOnAction(e->{
			numberField.setText(numberField.getText() + "0");
		});
		
		b1.setOnAction(e->{
			numberField.setText(numberField.getText() + "1");
		});
		
		b2.setOnAction(e->{
			numberField.setText(numberField.getText() + "2");
		});
		
		b3.setOnAction(e->{
			numberField.setText(numberField.getText() + "3");
		});
		b4.setOnAction(e->{
			numberField.setText(numberField.getText() + "4");
		});
		b5.setOnAction(e->{
			numberField.setText(numberField.getText() + "5");
		});
		b6.setOnAction(e->{
			numberField.setText(numberField.getText() + "6");
		});
		b7.setOnAction(e->{
			numberField.setText(numberField.getText() + "7");
		});
		b8.setOnAction(e->{
			numberField.setText(numberField.getText() + "8");
		});
		b9.setOnAction(e->{
			numberField.setText(numberField.getText() + "9");
		});
			
	}
	
	public TextField getNumberField() {
		return numberField;
	}
	
	public Button getOkButton() {
		return okButton;
	}
	
    public Button getCancelButton() {
	   return cancelButton;
    }
	
	public Scene getScene() {
		return scene;
	}
	


}
