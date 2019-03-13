

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{
	
	BankCard bankCard= new BankCard("112233","1234",2000);

	public static void main(String[] args) {
		launch(args);
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("My ATM");
		
		LoginLayout loginLayout=new LoginLayout(primaryStage,bankCard);
		HomepageLayout homepageLayout=new HomepageLayout(primaryStage,bankCard);
		WithdrawlLayout withdrawlLayout=new WithdrawlLayout(primaryStage,bankCard);
		DepositLayout depositLayout= new DepositLayout(primaryStage,bankCard);
		DoneLayout doneLayout=new DoneLayout(primaryStage,bankCard);
		
		loginLayout.prepareScene();
		withdrawlLayout.prepareScene();
		depositLayout.prepareScene();
		
		withdrawlLayout.prepareOkButton(withdrawlLayout.getOkButton(), withdrawlLayout.getNumberField());
		depositLayout.prepareOkButton(depositLayout.getOkButton(), depositLayout.getNumberField());
		withdrawlLayout.prepareCancelButton(withdrawlLayout.getCancelButton(),withdrawlLayout.getNumberField());
		depositLayout.prepareCancelButton(depositLayout.getCancelButton(),depositLayout.getNumberField());
			
		homepageLayout.setWithdrawlLayout(withdrawlLayout);
		homepageLayout.setDepositLayout(depositLayout);
		homepageLayout.setLoginLayout(loginLayout);
		depositLayout.setDoneLayout(doneLayout);
		withdrawlLayout.setDoneLayout(doneLayout);
		doneLayout.setLoginLayout(loginLayout);

		loginLayout.setHomepageLayout(homepageLayout);
		withdrawlLayout.setHomepageLayout(homepageLayout);
		depositLayout.setHomepageLayout(homepageLayout);
		doneLayout.setHomepageLayout(homepageLayout);
		bankCard.setHomepageLayout(homepageLayout);
		
		primaryStage.setScene(loginLayout.getScene());
		primaryStage.show();
	
	}


}
