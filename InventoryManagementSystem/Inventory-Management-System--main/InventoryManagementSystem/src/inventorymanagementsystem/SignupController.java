/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package inventorymanagementsystem;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author PuRoVi
 */
public class SignupController implements Initializable {

    @FXML
    private TextField tfname;
    @FXML
    private TextField tfusername;
    @FXML
    private TextField tfcontact;
    @FXML
    private PasswordField tfpass;
    @FXML
    private PasswordField tfrepass;
    @FXML
    private Button signupBtn;
    @FXML
    private Hyperlink loginLink;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void SignUp(ActionEvent event) {
        String fullname = tfname.getText().trim();
        String username = tfusername.getText().trim();
        String contact = tfcontact.getText().trim();
        String password = tfpass.getText();
        String confirmPassword = tfrepass.getText();

        if (fullname.isEmpty() || username.isEmpty() || contact.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            System.out.println("Please fill in all required fields.");
            return;
        }

        if (!password.equals(confirmPassword)) {
            System.out.println("Passwords do not match.");
            return;
        }

        try (Connection conn = ConnectDB.getConnection()) {
            PreparedStatement stmt;
            PreparedStatement checkStmt = conn.prepareStatement("SELECT COUNT(*) FROM users WHERE username = ?");
            checkStmt.setString(1, username);
            ResultSet rs = checkStmt.executeQuery();
            rs.next();
            if (rs.getInt(1) > 0) {
                System.out.println("Username already exists. Please choose a different one.");
                return;
            }

                String sql = "INSERT INTO users (fullname, username, contact, password) VALUES (?, ?, ?, ?)";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, fullname);
                stmt.setString(2, username);
                stmt.setString(3, contact);
                stmt.setString(4, password);

                stmt.executeUpdate();
                System.out.println("User registered successfully!");

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Login Form");
            stage.show();
            ((Stage) signupBtn.getScene().getWindow()).close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error occurred during registration.");
        }
    }

    @FXML
    private void backLogin(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Login Form");
        stage.show();
        ((Stage) loginLink.getScene().getWindow()).close();
    }
    
}
