package edu.westga.comp4420.users_and_facilities_lists.view.codebehind;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Modality;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.io.IOException;

import edu.westga.comp4420.users_and_facilities_lists.model.UserAccount;
import edu.westga.comp4420.users_and_facilities_lists.Main;
import edu.westga.comp4420.users_and_facilities_lists.model.Facility;

/**
 * CodeBehind To Handle Processing for the MainWindow
 *
 * @author	Comp 4420
 * @version Spring 2025
 */
public class MainWindow {   
	@FXML private ListView<UserAccount> users;
	@FXML private AnchorPane guiPane;
	@FXML private ListView<Facility> facilities;

	@FXML
	void addUser(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource(Main.ADD_USER_WINDOW_RESOURCE));
			loader.load();
			Parent parent = loader.getRoot();
			Scene scene = new Scene(parent);
			Stage addItemStage = new Stage();
			addItemStage.setTitle(Main.WINDOW_TITLE);
			addItemStage.setScene(scene);
			addItemStage.initModality(Modality.APPLICATION_MODAL);

			NewUserWindow controller = (NewUserWindow) loader.getController();
			controller.setItemList(this.users.getItems());

			addItemStage.showAndWait();
		} catch (IOException error) {
			Alert errorBox = new Alert(AlertType.ERROR);
			errorBox.setContentText("Unable to open add window" + error.getMessage());
			errorBox.showAndWait();
		}
	}
	@FXML
	void addFacility(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource(Main.ADD_FACILITY_WINDOW_RESOURCE));
			loader.load();
			Parent parent = loader.getRoot();
			Scene scene = new Scene(parent);
			Stage addItemStage = new Stage();
			addItemStage.setTitle(Main.WINDOW_TITLE);
			addItemStage.setScene(scene);
			addItemStage.initModality(Modality.APPLICATION_MODAL);

			NewFacilityWindow controller = (NewFacilityWindow) loader.getController();
			controller.setItemList(this.facilities.getItems());

			addItemStage.showAndWait();
		} catch (IOException error) {
			Alert errorBox = new Alert(AlertType.ERROR);
			errorBox.setContentText("Unable to open add window");
			errorBox.showAndWait();
		}
	}

	@FXML
	void removeUser(ActionEvent event) {
		UserAccount selectedUser = this.users.getSelectionModel().getSelectedItem();
		if (selectedUser != null) {
			this.users.getItems().remove(selectedUser);
		}
	}
	@FXML
	void removeFacility(ActionEvent event) {
		Facility selectedFacility = this.facilities.getSelectionModel().getSelectedItem();
		if (selectedFacility != null) {
			this.facilities.getItems().remove(selectedFacility);
		}
	}
	
	@FXML
	void initialize() {
		assert this.facilities != null : "fx:id=\"facilities\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.guiPane != null : "fx:id=\"guiPane\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.users != null : "fx:id=\"users\" was not injected: check your FXML file 'MainWindow.fxml'.";
	}
}
