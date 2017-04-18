/*
  Created by Robert on 4/12/2017.

  JavaFX Control class for Product Lookup.fxml
 */

package ProductLookup;


import Database.Employee;
import Database.Item;
import Menu.Menu;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;

public class Lookup
{
    // Text boxes for user input
    @FXML private TextField productSearchBox; // Text box for user to enter product ID

    // Text boxes for program output
    @FXML private TextField productIDBox;       // Text box to write the product ID to
    @FXML private TextField productNameBox;     // Text box to write the product name to
    @FXML private TextField productPriceBox;    // Text box to write the product price to
    @FXML private TextField productStockBox;    // Text box to write the product stock amount to

    private static Employee User; // The user that is currently logged in

    // Public no-args constructor
    public Lookup()
    {
    }

    public static void launchProductLookup(Employee user, Window prevScreen)
    {
        try
        {
            User = user;

            // Load main menu

            AnchorPane page = FXMLLoader.load(Lookup.class.getResource("Product Lookup.fxml"));
            Scene scene = new Scene(page);
            Stage stage = new Stage();
            stage.setTitle("Pharmacy Interface - Product Lookup");
            stage.setScene(scene);
            stage.show();

            prevScreen.hide(); // Closes the previous screen
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private String convertIDToString(int ID)
    // Converts an integer ID to a zero filled, 9 digit, string ID
    {
        String itemIDAsString = String.valueOf(ID); // set string ID to value of integer ID

        StringBuilder sb = new StringBuilder();

        if(itemIDAsString.length() <= 9)
        {
            while(sb.length() + itemIDAsString.length() < 9)
            {
                sb.append('0');
            }

            sb.append(ID);

            itemIDAsString = sb.toString();

            return itemIDAsString;
        }

        else return "";

    }

    @FXML private void handleCancelClick(ActionEvent event)
    // Returns user to main menu and exits the product lookup screen
    {
        Window lookupScreen = ((Node)(event.getSource())).getScene().getWindow(); // get reference to current window

        Menu.launchMenu(User, lookupScreen); // launch the main menu interface, passing the user's information and the current window
    }

    @FXML private void handleEnterClick() throws ClassNotFoundException, SQLException
    // Calls function to search for item with matching ID in database
    {
        tryLookup(); // attempt to find the item in the database and display its attributes
    }

    @FXML private void handleEnterKeyPressed(KeyEvent event) throws ClassNotFoundException, SQLException
    // Calls function to search for item with matching ID in database
    {
        if(event.getCode() == KeyCode.ENTER) // ignore other key presses aside from Enter key
        {
            tryLookup(); // attempt to find the item in the database and display its attributes
        }
    }

    private void tryLookup() throws ClassNotFoundException, SQLException
    // Attempts to find item with matching ID in database -- if user entered something other than a number
    // An error message will be displayed. If the item doesn't exist, an error message will also be displayed.
    {
        try
        {
            int itemID = Integer.parseInt(productSearchBox.getText()); // this may throw NumberFormatException, see catch block below

            String itemIDAsString = convertIDToString(itemID);  // the item ID displayed as a string (zero filled, 9 digits)
                                                                // -- returns empty string if user entered an ID with more than 9 digits

            if(itemIDAsString.equals("")) // Item ID invalid length error
            {
                Alert invalidLength = new Alert(Alert.AlertType.WARNING);
                invalidLength.initStyle(StageStyle.UTILITY);
                invalidLength.setTitle(null);
                invalidLength.setHeaderText("Invalid item ID length");
                invalidLength.setContentText("The item ID you have entered is of invalid length.\n\nDouble check that the ID is 9 digits or less (leading zeroes can be ignored).");

                invalidLength.showAndWait();
            }

            else // Item ID 9 digits or less, try to find item with matching ID in database
            {
                Item item = Item.readItem(itemID); // Item object -- if null item does not exist

                if (item != null)
                {
                    // Display full product ID (with leading zeroes)

                    productIDBox.setVisible(true);
                    productIDBox.setText(itemIDAsString);

                    // Display product name

                    productNameBox.setVisible(true);
                    productNameBox.setText(item.getName());

                    // Display product cost

                    productPriceBox.setVisible(true);
                    productPriceBox.setText(String.format("$%.2f", item.getCost()));
                }

                else
                {
                    Alert noItemFound = new Alert(Alert.AlertType.WARNING);
                    noItemFound.initStyle(StageStyle.UTILITY);
                    noItemFound.setTitle(null);
                    noItemFound.setHeaderText("No items found");
                    noItemFound.setContentText(String.format("There is no item with matching ID: %s.\n\nDouble check that the ID was entered correctly.", itemIDAsString));

                    noItemFound.showAndWait();
                }
            }
        }

        catch(NumberFormatException nfe)
        {
            Alert invalidFormat = new Alert(Alert.AlertType.WARNING);
            invalidFormat.initStyle(StageStyle.UTILITY);
            invalidFormat.setTitle(null);
            invalidFormat.setHeaderText("Invalid item ID formatting");
            invalidFormat.setContentText("The item ID you have entered is improperly formatted.\n\nDouble check that the ID is composed only of numbers (no spaces/separators)");

            invalidFormat.showAndWait();
        }
    }
}