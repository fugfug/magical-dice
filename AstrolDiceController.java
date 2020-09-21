import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*

astrology dice inspired by: https://eclecticwitchcraft.com/astrology-dice/ and 
https://aminoapps.com/c/the-witches-united/page/blog/divination-astrodice/L22k_D5Xs8ug8j4zJpxjjPRz5qQVebQo42 

*/

public class AstrolDiceController extends Application{

	private AstrolDiceModel astroModel;
	private AstrolDiceView astroView;

	
	public AstrolDiceController() {
		astroModel = new AstrolDiceModel();
		astroView = new AstrolDiceView();
		astroView.setProcessAction(this::process);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		AstrolDiceController controller = new AstrolDiceController();		
		Scene scene = new Scene(controller.astroView.getParent(), 666, 666);
		
		primaryStage.setResizable(false);
		primaryStage.setTitle("A S T R O L O G Y D I C E");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	private void process(ActionEvent event) {
/*		astroView.disable();
		
		try { // randomize time here?
			Thread.sleep(5000); 
		} catch (InterruptedException e) { }
	*/ // guess i won't use this anymore, but i'll leave it here	
		astroView.invisible();
		
		
		try {
			astroView.resultNames(astroModel.getP(), astroModel.getS(), astroModel.getH());
			astroView.resultImgs(astroModel.detPImg(), astroModel.detSImg(), astroModel.showH());
			astroView.resultEx(astroModel.getPlanet(), astroModel.getSign(), astroModel.getHouse());
		} catch (IOException e) { }
	}

	public static void main(String[] args) {
		launch();
	}
	

}
