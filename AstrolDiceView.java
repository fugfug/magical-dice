import java.io.FileNotFoundException;
import java.net.MalformedURLException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

// messy but done

/*

astrology dice inspired by: https://eclecticwitchcraft.com/astrology-dice/ and 
https://aminoapps.com/c/the-witches-united/page/blog/divination-astrodice/L22k_D5Xs8ug8j4zJpxjjPRz5qQVebQo42 

*/

public class AstrolDiceView {
	
	private VBox primaryBox;
	
	private Text introText;
	private static Label instructionText;
	private TextField inputText;
	private Button inputButton;
	private Image signImg, planetImg;  // where do images go when using MVC design pattern?
	private ImageView pImageView, sImageView;
	private Label hText;
	// imgs from wikipedia. had to rename b/c image names are too long
	private Label sign, planet, house; // name
	private Label signEx, planetEx, houseEx; // name&meaning/explanation
	private final static Font resFont = Font.font(16);
	VBox introBox;
	
	public AstrolDiceView() {
		primaryBox = new VBox();
		primaryBox.setAlignment(Pos.CENTER);
		primaryBox.setStyle("-fx-background-color: mistyrose");
		
		introBox = new VBox(10);
		introText = new Text("Enter Question: ");
		introText.setFill(Color.BLACK);
		inputText = new TextField();
		inputButton = new Button("Enter");
		instructionText = new Label(instructions());
		introBox.getChildren().addAll(introText, inputText, inputButton, instructionText);
		introBox.setAlignment(Pos.CENTER);
		introBox.setPadding(new Insets(20)); // leave spaces around edges
		primaryBox.getChildren().add(introBox);
		
		// results
		HBox resultNameBox = new HBox();
		sign = new Label();
		planet = new Label();
		house = new Label();
		sign.setMaxWidth(200);
//		sign.setPadding(new Insets(20, 0, 0, 0));
		resultNameBox.setSpacing(222);
		resultNameBox.setPadding(new Insets(5, 0, 150, 20)); // leave space for imgs
		resultNameBox.getChildren().addAll(sign, planet, house);
		primaryBox.getChildren().add(resultNameBox);
		
		// images of sign&planet results. house result won't be an image, but a text/label
		HBox resImgBox = new HBox(20);
		signImg = new Image(getClass().getClassLoader().getResourceAsStream("Aquarius.png")); // just using as default
		sImageView = new ImageView(signImg);
		planetImg = new Image(getClass().getClassLoader().getResourceAsStream("Jupiter.png")); // just using as default
		pImageView = new ImageView(planetImg);
		sImageView.setVisible(false);
		pImageView.setVisible(false);
		
		hText = new Label("");
		hText.setVisible(false);
		
		resImgBox.getChildren().addAll(sImageView, pImageView, hText);
		resImgBox.setPadding(new Insets(-90, 0, 80, 20));
		resImgBox.setSpacing(20);
		primaryBox.getChildren().add(resImgBox);
		
		// meanings of results
		HBox resultExBox = new HBox(20);
		signEx = new Label();
		planetEx = new Label();
		houseEx = new Label();
		signEx.setWrapText(true);
		signEx.setMaxWidth(200);
	//	signEx.setPadding(new Insets(0, 0, 0, 20)); // move away from the left edge of screen
		planetEx.setWrapText(true);
		planetEx.setMaxWidth(200);
		houseEx.setWrapText(true);
		houseEx.setMaxWidth(200);
		resultExBox.getChildren().addAll(signEx, planetEx, houseEx);
		resultExBox.setSpacing(20);
		resultExBox.setPadding(new Insets(-90, 0, -10, 20));
		primaryBox.getChildren().add(resultExBox);
	}
	
	
	public void resultImgs(String pImgName, String sImgName, int hInt) throws FileNotFoundException, MalformedURLException {
		signImg = new Image(sImgName, 180, 180, true, true);
		sImageView.setImage(signImg);
		planetImg = new Image(pImgName, 180, 180, true, true);
		pImageView.setImage(planetImg);
		
		hText.setText(hInt+"");
		hText.setFont(Font.font(150));
		hText.setPadding(new Insets(-10, 10, 0, 69));
		
		sImageView.setVisible(true);
		pImageView.setVisible(true);
		hText.setVisible(true);
	}
	
	//in a separate method b/c it will be too long
	private static String instructions() { 
		String inspiredBy = "inspired by: https://eclecticwitchcraft.com/astrology-dice/ and \n" + 
		"https://aminoapps.com/c/the-witches-united/page/blog/divination-astrodice/L22k_D5Xs8ug8j4zJpxjjPRz5qQVebQo42 \n\n\n";

		String instructions =  
		"First: as with all divination: ask a question, the more specific the question the better. \n"+
		"Instead of saying \"will I earn more money\" try asking \"will my boss give me the promotion I've been trying to get\"\n"+
		"Second: Roll the Dice and read them like this\n"+
		"\tPlanets- What\n"+
		"\tSigns- How\n"+
		"\tHouses- Where\" \n\n\n"+
		inspiredBy;
		//instructionText.setText(instructions);
		//instructionText.setWrapText(true);
		return instructions;
	}
	
	public Parent getParent() {
		return primaryBox;
	}
	
	public void disable() {
		inputButton.setDisable(true);
		inputButton.setText("Processing");
		inputText.setDisable(true);
	}
	
	public void invisible() {
		introText.setVisible(false);
		inputText.setVisible(false);
		instructionText.setVisible(false);
		inputButton.setVisible(false);
		
		primaryBox.getChildren().removeAll(introBox);
		// box.setVisible(false);
		
	}
	

	public void resultNames(String p, String s, int h) {
		planet.setText(p);
		sign.setText(s);
		house.setText(h + "");
		planet.setFont(resFont);
		sign.setFont(resFont);
		house.setFont(resFont);
		sign.setVisible(true);
		planet.setVisible(true);
		house.setVisible(true);
	}
	
	public void resultEx(String p, String s, String h) {
		planetEx.setText(p);
		signEx.setText(s);
		houseEx.setText(h + "");
		planetEx.setVisible(true);
		signEx.setVisible(true);
		houseEx.setVisible(true);
	}
	
	public void setProcessAction(EventHandler<ActionEvent> handler) {
		inputButton.setOnAction(handler);
	}

}
