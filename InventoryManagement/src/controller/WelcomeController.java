package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import models.DataController;


public class WelcomeController {
	
	DataController dtc = new DataController();
	
	@FXML
	private VBox wel;
	
	
	@FXML
    private TextField username ;
    @FXML
    private PasswordField password ;
    @FXML
    protected void submit(ActionEvent e) throws IOException {
    	System.out.println(dtc.authUser(username.textProperty().get(), password.textProperty().get()));
    	
    	//System.out.println("User: " + username.textProperty().get() + " Password: " + password.textProperty().get());
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("adminPage.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage1 = new Stage();
        stage1.setTitle("Administrator Page");
        stage1.setScene(new Scene(root1));  
        stage1.show();
        Stage st = (Stage)wel.getScene().getWindow();
        st.close();
    }
    @FXML
    protected void cancel(ActionEvent e) {
		System.exit(0);
	}
    
}
