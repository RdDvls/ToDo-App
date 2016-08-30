package sample;

import com.sun.tools.javac.comp.Todo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    @FXML
    ListView todoList;

    @FXML
    TextField todoText;

    ObservableList<ToDoItem> todoItems = FXCollections.observableArrayList(); //makes an observable array list of type todoItem

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        todoList.setItems(todoItems);
    }


    public void addItem() {
        System.out.println("Adding item ...");
        todoItems.add(new ToDoItem(todoText.getText()));
        todoText.setText("");
    }

    public void removeItem() {
        ToDoItem todoItem = (ToDoItem) todoList.getSelectionModel().getSelectedItem();
        System.out.println("Removing " + todoItem.text + " ...");
        todoItems.remove(todoItem);
    }

    public void markAllDone() {
        System.out.println("Marking all as done");
        for (ToDoItem item : todoItems) {
            if (item != null) {
                item.isDone = !item.isDone;
                todoList.setItems(null);
                todoList.setItems(todoItems);
            }
        }
    }
    public void toggleAll(){
        System.out.println("Toggling all ...");
        for(ToDoItem item : todoItems){
            if(item != null){
                item.isDone = !item.isDone;
                todoList.setItems(null);
                todoList.setItems(todoItems);
            }
        }
    }

    public void markAllIncomplete(){
        System.out.println("Marking all incomplete");
        for (ToDoItem item : todoItems){
            if(item != null){
                item.isDone = false;
                todoList.setItems(null);
                todoList.setItems(todoItems);
            }
        }
    }

    public void toggleItem() {
        System.out.println("Toggling item ...");
        ToDoItem todoItem = (ToDoItem) todoList.getSelectionModel().getSelectedItem();
        if (todoItem != null) {
            todoItem.isDone = !todoItem.isDone;
            todoList.setItems(null);
            todoList.setItems(todoItems);
        }
    }

    public void handleEnterPressed(KeyEvent event){
        if(event.getCode() == KeyCode.ENTER){
            todoItems.add(new ToDoItem(todoText.getText()));
            todoText.setText("");
        }
    }


}
