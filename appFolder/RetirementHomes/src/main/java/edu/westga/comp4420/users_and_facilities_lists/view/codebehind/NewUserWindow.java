package edu.westga.comp4420.users_and_facilities_lists.view.codebehind;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.util.List;

import edu.westga.comp4420.users_and_facilities_lists.model.UserAccount;

/**
 * CodeBehind To Handle Processing for the NewUserWindow
 *
 * @author	Comp 4420
 * @version Spring 2025
 */
public class NewUserWindow {   
	@FXML private AnchorPane guiPane;
	@FXML private TextField firstName;
    @FXML private TextField lastName;
	@FXML private TextField email;
	
	private List<UserAccount> users;
	
	private void closeWindow() {
		this.guiPane.getScene().getWindow().hide();
	}

    @FXML
    void addUser(ActionEvent event) {
		try {
			String firstName = this.firstName.getText();
			String lastName = this.lastName.getText();
			String email = this.email.getText();
			UserAccount newUser = new UserAccount(firstName, lastName, email);
			this.users.add(newUser);
			this.closeWindow();
		} catch (NumberFormatException error) {
			Alert errorBox = new Alert(AlertType.ERROR);
			errorBox.setContentText("Must provide value number for amount needed.");
			errorBox.showAndWait();
		} catch (IllegalArgumentException error) {
			Alert errorBox = new Alert(AlertType.ERROR);
			errorBox.setContentText(error.getMessage());
			errorBox.showAndWait();
		}

    }

    @FXML
    void cancel(ActionEvent event) {
		this.closeWindow();
    }
	
	
	public void setItemList(List<UserAccount> users) {
		this.users = users;
	}
	
	@FXML
	void initialize() {
		assert this.email != null : "fx:id=\"email\" was not injected: check your FXML file 'NewUserWindow.fxml'.";
        assert this.firstName != null : "fx:id=\"firstName\" was not injected: check your FXML file 'NewUserWindow.fxml'.";
        assert this.guiPane != null : "fx:id=\"guiPane\" was not injected: check your FXML file 'NewUserWindow.fxml'.";
        assert this.lastName != null : "fx:id=\"lastName\" was not injected: check your FXML file 'NewUserWindow.fxml'.";
	}
}
