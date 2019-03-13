import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {
	
	private Stage window;
	private Scene scene;
	
	public void display(String message)
	{
		window=new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("ERROR");
		Label alertLabel = new Label(message);
		alertLabel.setTextFill(Color.web("#FF0000"));
		
		StackPane layout=new StackPane();
		layout.getChildren().add(alertLabel);
		scene=new Scene(layout,320,120);
		window.setScene(scene);
		window.showAndWait();
	}

}
