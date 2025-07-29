package inventorymanagementsystem;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdminDashboardController implements Initializable {

    @FXML
    private VBox productVBox;
    @FXML
    private Button productBtn;
    @FXML
    private Button customerBtn;
    @FXML
    private Button ordersBtn;
    @FXML
    private VBox customerVBox;
    @FXML
    private VBox orderVBox;

    @FXML
    private TextField tfproductType;
    @FXML
    private TextField tfproductName;
    @FXML
    private TextField tfproductQty;
    @FXML
    private TextField tfproductPrice;
    @FXML
    private Button productbtnAdd;
    @FXML
    private Button productbtnUpdate;
    @FXML
    private Button productbtnDelete;
    @FXML
    private TableView<?> productTable;

    @FXML
    private TextField tfcustomerName;
    @FXML
    private TextField tfcustomerAddress;
    @FXML
    private TextField tfcustomerPhone;
    @FXML
    private TextField tfcustomerEmail;
    @FXML
    private Button customerbtnAdd;
    @FXML
    private Button customerbtnUpdate;
    @FXML
    private Button customerbtnDelete;

    @FXML
    private Label orderLabel;
    @FXML
    private TextField tforderType;
    @FXML
    private TextField tforderName;
    @FXML
    private TextField tforderQty;
    @FXML
    private TextField tforderPrice;
    @FXML
    private Button orderAdd;
    @FXML
    private Button orderbtnUpdate;
    @FXML
    private Button orderbtnDelete;

    @FXML
    private Button logoutBtn;
    @FXML
    private Label productLabel;
    @FXML
    private TableColumn<?, ?> colPtype;
    @FXML
    private TableColumn<?, ?> colPname;
    @FXML
    private TableColumn<?, ?> colPQty;
    @FXML
    private TableColumn<?, ?> colPPrice;
    @FXML
    private Label customerLabel;
    @FXML
    private TableView<?> productTable1;
    @FXML
    private TableColumn<?, ?> colCname;
    @FXML
    private TableColumn<?, ?> colCadd;
    @FXML
    private TableColumn<?, ?> colCphone;
    @FXML
    private TableColumn<?, ?> colCemail;
    @FXML
    private TableView<?> productTable2;
    @FXML
    private TableColumn<?, ?> colOtype;
    @FXML
    private TableColumn<?, ?> colOname;
    @FXML
    private TableColumn<?, ?> colOQty;
    @FXML
    private TableColumn<?, ?> colOPrice;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showOnly(null);  // কোন সেকশন ডিফল্ট দেখাবে না
    }    

    private void showOnly(VBox toShow) {
        productVBox.setVisible(false);
        productVBox.setManaged(false);

        customerVBox.setVisible(false);
        customerVBox.setManaged(false);

        orderVBox.setVisible(false);
        orderVBox.setManaged(false);

        if (toShow != null) {
            toShow.setVisible(true);
            toShow.setManaged(true);
        }
    }

    @FXML
    private void showProducts(ActionEvent event) {
        showOnly(productVBox);
        System.out.println("Products section shown");
    }

    @FXML
    private void showCustomers(ActionEvent event) {
        showOnly(customerVBox);
        System.out.println("Customers section shown");
    }

    @FXML
    private void showOrders(ActionEvent event) {
        showOnly(orderVBox);
        System.out.println("Orders section shown");
    }

    // Product Buttons
    @FXML
    private void productaddMethod(ActionEvent event) {
        // এখানে প্রোডাক্ট যুক্ত করার কোড দিবে
        System.out.println("Add product clicked");
    }

    @FXML
    private void productupdateMethod(ActionEvent event) {
        // এখানে প্রোডাক্ট আপডেট করার কোড দিবে
        System.out.println("Update product clicked");
    }

    @FXML
    private void productdeleteMethod(ActionEvent event) {
        // এখানে প্রোডাক্ট ডিলিট করার কোড দিবে
        System.out.println("Delete product clicked");
    }

    // Customer Buttons
    @FXML
    private void customeraddMethod(ActionEvent event) {
        // এখানে কাস্টমার যুক্ত করার কোড দিবে
        System.out.println("Add customer clicked");
    }

    @FXML
    private void customerupdateMethod(ActionEvent event) {
        // এখানে কাস্টমার আপডেট করার কোড দিবে
        System.out.println("Update customer clicked");
    }

    @FXML
    private void customerdeleteMethod(ActionEvent event) {
        // এখানে কাস্টমার ডিলিট করার কোড দিবে
        System.out.println("Delete customer clicked");
    }

    // Order Buttons
    @FXML
    private void orderaddMethod(ActionEvent event) {
        // এখানে অর্ডার যুক্ত করার কোড দিবে
        System.out.println("Add order clicked");
    }

    @FXML
    private void orderupdateMethod(ActionEvent event) {
        // এখানে অর্ডার আপডেট করার কোড দিবে
        System.out.println("Update order clicked");
    }

    @FXML
    private void orderdeleteMethod(ActionEvent event) {
        // এখানে অর্ডার ডিলিট করার কোড দিবে
        System.out.println("Delete order clicked");
    }

    @FXML
    private void Logout(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Login Form");
        stage.show();
        ((Stage) logoutBtn.getScene().getWindow()).close();
    }

}
