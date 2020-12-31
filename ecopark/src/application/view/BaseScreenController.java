package application.view;

import java.io.IOException;
import java.util.Hashtable;

import javafx.scene.Scene;
import javafx.stage.Stage;


public class BaseScreenController extends FXMLScreenController{
	private Scene scene;
	private BaseScreenController prev;
	protected final Stage stage;
	protected Hashtable<String, String> messages;

	private BaseScreenController(String screenPath) throws IOException {
		super(screenPath);
		this.stage = new Stage();
	}


	public BaseScreenController(Stage stage, String screenPath) throws IOException {
		super(screenPath);
		this.stage = stage;
	}

	public void show() {
		if (this.scene == null) {
			this.scene = new Scene(this.content);
		}
		this.stage.setScene(this.scene);
		this.stage.show();
	}

	public void setScreenTitle(String string) {
		this.stage.setTitle(string);
	}


	public void forward(Hashtable messages) {
		this.messages = messages;
	}

}
