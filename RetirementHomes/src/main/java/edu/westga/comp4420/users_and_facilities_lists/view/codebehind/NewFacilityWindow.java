package edu.westga.comp4420.users_and_facilities_lists.view.codebehind;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.util.List;

import edu.westga.comp4420.users_and_facilities_lists.model.Facility;

/**
 * CodeBehind To Handle Processing for the NewUserWindow
 *
 * @author	Comp 4420
 * @version Spring 2025
 */
public class NewFacilityWindow {   
	@FXML private AnchorPane guiPane;
	@FXML private TextField homeName;
    @FXML private TextField address;
	@FXML private TextField owner;
	
	private List<Facility> facilities;
	
	private void closeWindow() {
		this.guiPane.getScene().getWindow().hide();
	}

    @FXML
    void addFacility(ActionEvent event) {
		try {
			String homeName = this.homeName.getText();
			String address = this.address.getText();
			String owner = this.owner.getText();
			Facility newFacility = new Facility(homeName, address, owner);
			this.facilities.add(newFacility);
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
	
	
	public void setItemList(List<Facility> facilities) {
		this.facilities = facilities;
	}
	
	@FXML
	void initialize() {
		assert this.owner != null : "fx:id=\"email\" was not injected: check your FXML file 'NewUserWindow.fxml'.";
        assert this.homeName != null : "fx:id=\"firstName\" was not injected: check your FXML file 'NewUserWindow.fxml'.";
        assert this.guiPane != null : "fx:id=\"guiPane\" was not injected: check your FXML file 'NewUserWindow.fxml'.";
        assert this.address != null : "fx:id=\"lastName\" was not injected: check your FXML file 'NewUserWindow.fxml'.";
	}
}
