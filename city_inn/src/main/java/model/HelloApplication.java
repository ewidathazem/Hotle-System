package model;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
         login_stage(stage);
    }


    public static void main(String[] args) {
        launch();

    }

    public boolean check_login(String username, String password, Login user) {
        if (username.equals(user.username) && password.equals(user.password))
            return true;
        else
            return false;
    }

    public void login_stage(Stage stage) {
        Login user = new Login();
        Group root = new Group();
        Scene scene = new Scene(root, 900, 500, Color.GAINSBORO);
        Image image = new Image("C:\\Users\\hp\\Desktop\\digital\\img_1.png");
        ImageView v1 = new ImageView(image);
        v1.setFitHeight(500);
        v1.setFitWidth(600);
        root.getChildren().add(v1);
        Label username = new Label("User Name");
        username.setTranslateY(200);
        username.setTranslateX(610);
        username.setFont(new Font("Cambria", 24));
        root.getChildren().add(username);
        Label password = new Label("Password");
        password.setTranslateY(300);
        password.setTranslateX(610);
        password.setFont(new Font("Cambria", 24));
        root.getChildren().add(password);
        PasswordField passwordField = new PasswordField();
        passwordField.setTranslateX(730);
        passwordField.setTranslateY(305);
        root.getChildren().add(passwordField);
        TextField userfield = new TextField();
        userfield.setTranslateX(730);
        userfield.setTranslateY(205);
        root.getChildren().add(userfield);
        Button login = new Button();
        login.setText("-----LOGIN-----");
        login.setFont(new Font("Cambria", 20));
        login.setTextFill(Color.CYAN);
        login.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(5), Insets.EMPTY)));
        DropShadow shadow2 = new DropShadow(10, Color.RED);
        login.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            login.setEffect(shadow2);
        });
        login.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            login.setEffect(null);
        });
        login.setTranslateX(680);
        login.setTranslateY(370);
        root.getChildren().add(login);
        stage.setTitle("page1");
        stage.setScene(scene);
        login.setOnAction((ActionEvent e) -> {
            if (check_login(userfield.getText(), passwordField.getText(), user))
                menu_stage();
            else
                wrong_login(stage);
        });
        stage.show();
    }


    public void menu_stage() {
        Stage stage = new Stage();
        Group root = new Group();
        Scene scene = new Scene(root, 900, 500, Color.DARKORANGE);
        Image image = new Image("C:\\Users\\hp\\Desktop\\digital\\photo.jpg");
        ImageView v1 = new ImageView(image);
        v1.setFitWidth(900);
        v1.setFitHeight(500);
        Image emp_image = new Image("C:\\Users\\hp\\Desktop\\digital\\emp.PNG");
        Button employee = new Button("Employee", new ImageView(emp_image));
        employee.setPrefWidth(200);
        employee.setContentDisplay(ContentDisplay.LEFT);
        employee.setFont(new Font("Cambria", 20));
        employee.setTextFill(Color.CYAN);
        employee.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(5), Insets.EMPTY)));
        DropShadow shadow = new DropShadow(10, Color.RED);
        employee.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            employee.setEffect(shadow);
        });
        employee.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            employee.setEffect(null);
        });
        employee.setOnAction((ActionEvent e) -> {
            stage.close();
            employee_view();
        });
        employee.setTranslateX(50);
        employee.setTranslateY(180);
        Image cus_image = new Image("C:\\Users\\hp\\Desktop\\digital\\cus.PNG");
        Button customer = new Button("Customer", new ImageView(cus_image));
        customer.setPrefWidth(200);
        customer.setContentDisplay(ContentDisplay.LEFT);
        customer.setFont(new Font("Cambria", 20));
        customer.setTextFill(Color.CYAN);
        customer.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(5), Insets.EMPTY)));
        DropShadow shadow1 = new DropShadow(10, Color.RED);
        customer.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            customer.setEffect(shadow1);
        });
        customer.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            customer.setEffect(null);
        });
        customer.setOnAction((ActionEvent e) -> {
            stage.close();
            customer_view();});
        customer.setTranslateX(600);
        customer.setTranslateY(180);
        Image room_image = new Image("C:\\Users\\hp\\Desktop\\digital\\room.PNG");
        Button room = new Button("Room", new ImageView(room_image));
        room.setPrefWidth(200);
        room.setContentDisplay(ContentDisplay.LEFT);
        room.setFont(new Font("Cambria", 20));
        room.setTextFill(Color.CYAN);
        room.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(5), Insets.EMPTY)));
        DropShadow shadow2 = new DropShadow(10, Color.RED);
        room.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            room.setEffect(shadow2);
        });
        room.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            room.setEffect(null);
        });
        room.setOnAction((ActionEvent e) -> {
            stage.close();
            room_view();
        });
        room.setTranslateX(50);
        room.setTranslateY(300);
        Image booking_image = new Image("C:\\Users\\hp\\Desktop\\digital\\booking.PNG");
        Button booking = new Button("Booking", new ImageView(booking_image));
        booking.setPrefWidth(200);
        booking.setContentDisplay(ContentDisplay.LEFT);
        booking.setFont(new Font("Cambria", 20));
        booking.setTextFill(Color.CYAN);
        booking.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(5), Insets.EMPTY)));
        DropShadow shadow3 = new DropShadow(10, Color.RED);
        booking.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            booking.setEffect(shadow3);
        });
        booking.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            booking.setEffect(null);
        });
        booking.setOnAction((ActionEvent e) -> {
            stage.close();
            booking_view();});
        booking.setTranslateX(600);
        booking.setTranslateY(300);
        root.getChildren().add(v1);
        root.getChildren().add(customer);
        root.getChildren().add(employee);
        root.getChildren().add(room);
        root.getChildren().add(booking);
        stage.setScene(scene);
        stage.show();
    }

    public void wrong_login(Stage stage1) {
        Stage stage = new Stage();
        Group root = new Group();
        Scene scene = new Scene(root, 500, 200, Color.AQUA);
        Label wrong = new Label("wrong username or password try again");
        wrong.setFont(new Font("Cambria", 24));
        wrong.setTranslateX(50);
        wrong.setTranslateY(10);
        Button try_ = new Button("---Try Again---");
        try_.setFont(new Font("Cambria", 24));
        try_.setTranslateX(160);
        try_.setTranslateY(100);
        try_.setTextFill(Color.CYAN);
        try_.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(5), Insets.EMPTY)));
        DropShadow shadow3 = new DropShadow(10, Color.RED);
        try_.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            try_.setEffect(shadow3);
        });
        try_.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            try_.setEffect(null);
        });
        try_.setOnAction((ActionEvent e) -> {
            stage.close();
            login_stage(stage1);

        });
        root.getChildren().add(try_);
        root.getChildren().add(wrong);
        stage.setScene(scene);
        stage.show();
    }

    public void employee_view() {
        Employee_Queries E_c = new Employee_Queries();
        Stage stage = new Stage();
        Group root = new Group();
        Scene scene = new Scene(root, 900, 500, Color.AQUA);
        DropShadow shadow = new DropShadow(10, Color.RED);
        Button back = new Button("--back to main menu--");
        back.setFont(new Font("Cambria", 14));
        back.setTextFill(Color.RED);
        back.setTranslateX(390);
        back.setTranslateY(450);
        back.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            back.setEffect(shadow);
        });
        back.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            back.setEffect(null);
        });
        back.setOnAction((ActionEvent e) -> {
            stage.close();
            menu_stage();
        });
        root.getChildren().add(back);
        ObservableList<Employee> data = FXCollections.observableArrayList(E_c.getallEmployee());
        TableView employee_table = new TableView();
        TableColumn columnid = new TableColumn("ID");
        columnid.setCellValueFactory(new PropertyValueFactory("e_id"));
        TableColumn columnname = new TableColumn("Employee Name");
        columnname.setCellValueFactory(new PropertyValueFactory("e_name"));
        TableColumn columnrating = new TableColumn("Rating");
        columnrating.setCellValueFactory(new PropertyValueFactory("rating"));
        TableColumn columnphonenumber = new TableColumn("Phone Number");
        columnphonenumber.setCellValueFactory(new PropertyValueFactory("phone_num"));
        TableColumn columnEmail = new TableColumn("Email");
        columnEmail.setCellValueFactory(new PropertyValueFactory("Email"));
        TableColumn columnSalary = new TableColumn("Salary($)");
        columnSalary.setCellValueFactory(new PropertyValueFactory("salry"));
        TableColumn columntybe_of_employee = new TableColumn("type of employment");
        columntybe_of_employee.setCellValueFactory(new PropertyValueFactory("tybe_of_employee"));
        employee_table.getColumns().addAll(columnid, columnname, columnrating, columnphonenumber, columnSalary, columntybe_of_employee, columnEmail);
        employee_table.setTranslateY(30);
        columnid.setPrefWidth(50);
        columnrating.setPrefWidth(50);
        columnphonenumber.setPrefWidth(200);
        columnSalary.setPrefWidth(100);
        columnEmail.setPrefWidth(300);
        columnname.setPrefWidth(100);
        columntybe_of_employee.setPrefWidth(100);
        employee_table.setItems(data);
        root.getChildren().add(employee_table);
        employee_table.setPrefSize(900, 400);
        stage.setScene(scene);
        stage.show();
    }

    public void customer_view() {
        Stage stage = new Stage();
        Customer_Queries Q_c = new Customer_Queries();
        //Stage stage = new Stage();
        Group root = new Group();
        ObservableList<Customer> data = FXCollections.observableArrayList(Q_c.getallCustomer());
        Scene scene = new Scene(root, 1200, 600, Color.AQUA);
        Button insert = new Button("-Add New Customer-");
        insert.setPrefWidth(150);
        insert.setFont(new Font("Cambria", 14));
        insert.setTextFill(Color.RED);
        insert.setTranslateX(0);
        insert.setTranslateY(0);
        DropShadow shadow = new DropShadow(10, Color.RED);
        insert.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            insert.setEffect(shadow);
        });
        insert.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            insert.setEffect(null);
        });
        insert.setOnAction((ActionEvent e) -> {
            TextField name = new TextField();
            name.setPromptText("Customer Name");
            name.setTranslateX(170);
            root.getChildren().add(name);
            TextField phone = new TextField();
            phone.setPromptText("Phome number");
            phone.setTranslateX(330);
            root.getChildren().add(phone);
            TextField Address = new TextField();
            Address.setPromptText("Address");
            Address.setTranslateX(490);
            root.getChildren().add(Address);
            TextField Guide_ID = new TextField();
            Guide_ID.setPromptText("Guide_ID");
            Guide_ID.setTranslateX(650);
            root.getChildren().add(Guide_ID);
            TextField Email = new TextField();
            Email.setPromptText("Email");
            Email.setTranslateX(810);
            Email.setPrefWidth(250);
            root.getChildren().add(Email);
            Button save = new Button("Save Customer");
            save.setTranslateX(1080);
            save.setFont(new Font("Cambria", 14));
            save.setTextFill(Color.RED);
            save.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent a) -> {
                save.setEffect(shadow);
            });
            save.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent a) -> {
                save.setEffect(null);
            });
            root.getChildren().add(save);
            save.setOnAction((ActionEvent c) -> {
                if (Q_c.add_Customer(name.getText(), Integer.parseInt(phone.getText()), Email.getText(), Address.getText(), Integer.parseInt(Guide_ID.getText())) == "Add Done") {

                    Alert alert = new Alert(Alert.AlertType.NONE);
                    alert.setAlertType(Alert.AlertType.CONFIRMATION);
                    alert.setContentText("Add Done");
                    alert.show();

                } else {
                    Alert alert = new Alert(Alert.AlertType.NONE);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("Try Again(Employee not found)");
                    alert.show();
                }
            });

        });

        root.getChildren().add(insert);
        Button delete = new Button("----Delete Customer----");
        delete.setFont(new Font("Cambria", 14));
        delete.setTextFill(Color.RED);
        delete.setTranslateX(0);
        delete.setTranslateY(30);
        delete.setPrefWidth(150);
        delete.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            delete.setEffect(shadow);
        });
        delete.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            delete.setEffect(null);
        });
        delete.setOnAction((ActionEvent d) -> {
            TextField delete_id = new TextField();
            delete_id.setTranslateY(30);
            delete_id.setTranslateX(170);
            delete_id.setPromptText("ID Customer");
            Button delete_ = new Button("Delete");
            delete_.setPrefWidth(100);
            delete_.setFont(new Font("Cambria", 14));
            delete_.setTextFill(Color.RED);
            delete_.setTextFill(Color.RED);
            delete_.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
                delete_.setEffect(shadow);
            });
            delete_.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
                delete_.setEffect(null);
            });
            delete_.setOnAction((ActionEvent l) -> {
                Reservation_Queries r_q = new Reservation_Queries();
                if (Q_c.delete_Customer(Integer.parseInt(delete_id.getText())) == "delete done" &&
                        r_q.Search_by_customerID(Integer.parseInt(delete_id.getText())) == null) {
                    Alert alert = new Alert(Alert.AlertType.NONE);
                    alert.setAlertType(Alert.AlertType.CONFIRMATION);
                    alert.setContentText("Delete Done");
                    alert.show();

                } else {
                    Alert alert = new Alert(Alert.AlertType.NONE);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("Try Again(Customer not found) or Customer booked room(cancel booked first)");
                    alert.show();
                }

            });
            delete_.setTranslateY(30);
            delete_.setTranslateX(330);
            root.getChildren().add(delete_);
            root.getChildren().add(delete_id);

        });

        root.getChildren().add(delete);
        Button refresh = new Button("Refresh");
        refresh.setPrefWidth(200);
        refresh.setFont(new Font("Cambria", 16));
        refresh.setTextFill(Color.RED);
        refresh.setTranslateX(1000);
        refresh.setTranslateY(570);
        refresh.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            refresh.setEffect(shadow);
        });
        refresh.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            refresh.setEffect(null);
        });
        refresh.setOnAction((ActionEvent f) -> {
            customer_view();
        });
        root.getChildren().add(refresh);
        Button search = new Button("----All Customer Booked Room in Specific Floor----");
        search.setPrefWidth(400);
        search.setFont(new Font("Cambria", 14));
        search.setTextFill(Color.RED);
        search.setTranslateX(0);
        search.setTranslateY(290);
        search.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            search.setEffect(shadow);
        });
        search.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            search.setEffect(null);
        });
        search.setOnAction((ActionEvent x) -> {
            TextField id = new TextField();
            id.setTranslateY(320);
            id.setTranslateX(0);
            id.setPromptText("Floor Number");
            Button Save = new Button("Save");
            Save.setPrefWidth(700);
            Save.setTranslateX(200);
            Save.setTranslateY(320);
            Save.setPrefWidth(100);
            Save.setFont(new Font("Cambria", 14));
            Save.setTextFill(Color.RED);
            Save.setTextFill(Color.RED);
            root.getChildren().addAll(Save, id);
            Save.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
                Save.setEffect(shadow);
            });
            Save.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
                Save.setEffect(null);
            });
            Save.setOnAction((ActionEvent L) -> {
                ObservableList<String> name_customer = FXCollections.observableArrayList(Q_c.Customer_who_booked_room_in_Floor(Integer.parseInt(id.getText())));
                TextArea custmers = new TextArea();
                custmers.setFont(new Font("Cambria", 14));
                custmers.setEditable(false);
                for (int i = 0; i < name_customer.size(); i++)
                    custmers.appendText(name_customer.get(i) + "\n");
                custmers.setPrefSize(110, 150);
                custmers.setTranslateY(350);
                custmers.setTranslateX(140);
                root.getChildren().add(custmers);
            });
        });
        root.getChildren().add(search);
        Button update = new Button("--Customers who booked Room --");
        update.setFont(new Font("Cambria", 14));
        update.setTextFill(Color.RED);
        update.setTranslateX(0);
        update.setTranslateY(100);
        update.setPrefWidth(400);
        update.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            update.setEffect(shadow);
        });
        update.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            update.setEffect(null);
        });
        update.setOnAction((ActionEvent s) -> {
            ObservableList<String> name_customer = FXCollections.observableArrayList(Q_c.Customer_who_booked_room());
            TextArea custmers = new TextArea();
            custmers.setFont(new Font("Cambria", 14));
            custmers.setEditable(false);
            for (int i = 0; i < name_customer.size(); i++)
                custmers.appendText(name_customer.get(i) + "\n");
            custmers.setPrefSize(110, 150);
            custmers.setTranslateY(130);
            custmers.setTranslateX(140);
            root.getChildren().add(custmers);
        });
        root.getChildren().add(update);
        Button back = new Button("--back to main menu--");
        back.setFont(new Font("Cambria", 16));
        back.setTextFill(Color.RED);
        back.setTranslateX(0);
        back.setTranslateY(570);
        back.setPrefWidth(200);
        back.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            back.setEffect(shadow);
        });
        back.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            back.setEffect(null);
        });
        back.setOnAction((ActionEvent e) -> {
            menu_stage();
            stage.close();
        });
        root.getChildren().add(back);
        TableView<Customer> customer_table = new TableView<>();
        customer_table.setEditable(true);
        TableColumn<Customer, Integer> columnid = new TableColumn("ID");
        columnid.setCellValueFactory(new PropertyValueFactory("c_id"));
        TableColumn<Customer, String> columnname = new TableColumn("Customer Name");
        columnname.setCellValueFactory(new PropertyValueFactory("c_name"));
        TableColumn<Customer, Integer> columnemp_id = new TableColumn("Guide_ID");
        columnemp_id.setCellValueFactory(new PropertyValueFactory("Guide_emp"));
        TableColumn<Customer, Integer> columnphonenumber = new TableColumn("Phone Number");
        columnphonenumber.setCellValueFactory(new PropertyValueFactory("phone_num"));
        TableColumn<Customer, String> columnEmail = new TableColumn("Email");
        columnEmail.setCellValueFactory(new PropertyValueFactory("Email"));
        TableColumn<Customer, String> columnAddress = new TableColumn("Address");
        columnAddress.setCellValueFactory(new PropertyValueFactory("address"));
        customer_table.getColumns().addAll(columnid, columnname, columnphonenumber, columnAddress, columnemp_id, columnEmail);
        customer_table.setEditable(true);
        customer_table.setItems(data);
        customer_table.setTranslateX(400);
        customer_table.setTranslateY(100);
        root.getChildren().add(customer_table);
        customer_table.setPrefSize(800, 400);
        columnid.setPrefWidth(50);
        columnemp_id.setPrefWidth(50);
        columnEmail.setPrefWidth(300);
        columnphonenumber.setPrefWidth(100);
        columnAddress.setPrefWidth(120);
        columnname.setPrefWidth(150);
        stage.setScene(scene);
        stage.show();
    }

    public void room_view() {
        Stage stage = new Stage();
        Room_Queries R_q = new Room_Queries();
        Group root = new Group();
        Scene scene = new Scene(root, 900, 500, Color.AQUA);
        ObservableList<Room> data = FXCollections.observableArrayList(R_q.getallRoom());
        Button Filter = new Button("-Get Capacity for specific room-");
        Filter.setFont(new Font("Cambria", 14));
        Filter.setTextFill(Color.RED);
        Filter.setTranslateX(325);
        Filter.setTranslateY(212);
        Filter.setPrefWidth(325);
        DropShadow shadow = new DropShadow(10, Color.RED);
        Filter.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            Filter.setEffect(shadow);
        });
        Filter.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            Filter.setEffect(null);
        });
        Filter.setOnAction((ActionEvent n) -> {
            TextField room_id = new TextField();
            room_id.setPromptText("ID Room");
            room_id.setTranslateX(325);
            room_id.setTranslateY(243);
            room_id.setPrefWidth(150);
            Button save = new Button("Save");
            save.setFont(new Font("Cambria", 14));
            save.setTextFill(Color.RED);
            save.setPrefWidth(150);
            save.setTranslateX(500);
            save.setTranslateY(243);
            save.setOnAction((ActionEvent x) -> {
                ObservableList<String> capcity = FXCollections.observableArrayList(R_q.room_Capacity(Integer.parseInt(room_id.getText())));
                TextArea cap = new TextArea();
                cap.setFont(new Font("Cambria", 14));
                cap.setEditable(false);
                for (int i = 0; i < capcity.size(); i++)
                    cap.appendText(capcity.get(i) + "\n");
                cap.setPrefSize(110, 50);
                cap.setTranslateY(273);
                cap.setTranslateX(450);
                root.getChildren().add(cap);
            });
            root.getChildren().add(save);
            root.getChildren().add(room_id);
        });
        root.getChildren().add(Filter);
        Button Reserved = new Button("----Show Reserved Rooms----");
        Reserved.setFont(new Font("Cambria", 14));
        Reserved.setPrefWidth(325);
        Reserved.setTextFill(Color.RED);
        Reserved.setTranslateX(0);
        Reserved.setTranslateY(0);
        Reserved.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            Reserved.setEffect(shadow);
        });
        Reserved.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            Reserved.setEffect(null);
        });
        Reserved.setOnAction((ActionEvent q) -> {
            ObservableList<Integer> rooms = FXCollections.observableArrayList(R_q.room_reseved());
            TextArea r_rooms = new TextArea();
            r_rooms.setFont(new Font("Cambria", 14));
            r_rooms.setEditable(false);
            for (int i = 0; i < rooms.size(); i++)
                r_rooms.appendText(rooms.get(i) + "\n");
            r_rooms.setPrefSize(110, 150);
            r_rooms.setTranslateY(60);
            r_rooms.setTranslateX(100);
            root.getChildren().add(r_rooms);
        });
        root.getChildren().add(Reserved);
        Button search = new Button("--Get Name Customer who booked specific room--");
        search.setFont(new Font("Cambria", 14));
        search.setPrefWidth(325);
        search.setTextFill(Color.RED);
        search.setTranslateX(0);
        search.setTranslateY(212);
        search.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            search.setEffect(shadow);
        });
        search.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            search.setEffect(null);
        });
        search.setOnAction((ActionEvent c) -> {
            TextField room_id = new TextField();
            room_id.setPromptText("ID Room");
            room_id.setTranslateX(0);
            room_id.setTranslateY(243);
            room_id.setPrefWidth(150);
            Button save = new Button("Save");
            save.setFont(new Font("Cambria", 14));
            save.setTextFill(Color.RED);
            save.setPrefWidth(150);
            save.setTranslateX(175);
            save.setTranslateY(243);
            save.setOnAction((ActionEvent x) -> {
                ObservableList<String> name = FXCollections.observableArrayList(R_q.customer_room(Integer.parseInt(room_id.getText())));
                TextArea name_customer = new TextArea();
                name_customer.setFont(new Font("Cambria", 14));
                name_customer.setEditable(false);
                for (int i = 0; i < name.size(); i++)
                    name_customer.appendText(name.get(i) + "\n");
                name_customer.setPrefSize(110, 50);
                name_customer.setTranslateY(273);
                name_customer.setTranslateX(100);
                root.getChildren().add(name_customer);
            });
            root.getChildren().add(save);
            root.getChildren().add(room_id);
            save.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
                save.setEffect(shadow);
            });
            save.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
                save.setEffect(null);
            });

        });
        root.getChildren().add(search);
        Button Avsilable = new Button("--Show rooms with cost less than specific number--");
        Avsilable.setFont(new Font("Cambria", 14));
        Avsilable.setOnAction((ActionEvent b) -> {
            TextField cost = new TextField();
            cost.setPromptText("Cost");
            cost.setTranslateX(325);
            cost.setTranslateY(30);
            Button save = new Button("Save");
            save.setTextFill(Color.RED);
            save.setTranslateX(500);
            save.setTranslateY(30);
            save.setPrefWidth(150);
            save.setOnAction((ActionEvent t) -> {
                ObservableList<Integer> rooms_cost = FXCollections.observableArrayList(R_q.room_cost(Integer.parseInt(cost.getText())));
                TextArea r_rooms = new TextArea();
                r_rooms.setFont(new Font("Cambria", 14));
                r_rooms.setEditable(false);
                for (int i = 0; i < rooms_cost.size(); i++)
                    r_rooms.appendText(rooms_cost.get(i) + "\n");
                r_rooms.setPrefSize(110, 150);
                r_rooms.setTranslateY(60);
                r_rooms.setTranslateX(430);
                root.getChildren().add(r_rooms);
            });

            save.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
                save.setEffect(shadow);
            });
            save.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
                save.setEffect(null);
            });
            root.getChildren().add(save);
            root.getChildren().add(cost);
        });
        ;
        Avsilable.setTextFill(Color.RED);
        Avsilable.setPrefWidth(325);
        Avsilable.setTranslateX(325);
        Avsilable.setTranslateY(0);
        Avsilable.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            Avsilable.setEffect(shadow);
        });
        Avsilable.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            Avsilable.setEffect(null);
        });
        root.getChildren().add(Avsilable);
        Button back = new Button("--back to main menu--");
        back.setFont(new Font("Cambria", 20));
        back.setTextFill(Color.RED);
        back.setTranslateX(0);
        back.setTranslateY(460);
        back.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            back.setEffect(shadow);
        });
        back.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            back.setEffect(null);
        });
        back.setOnAction((ActionEvent e) -> {
            menu_stage();
            stage.close();
        });
        Button refresh = new Button("--refresh--");
        refresh.setFont(new Font("Cambria", 20));
        refresh.setTextFill(Color.RED);
        refresh.setTranslateX(770);
        refresh.setTranslateY(460);
        refresh.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            refresh.setEffect(shadow);
        });
        refresh.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            refresh.setEffect(null);
        });
        refresh.setOnAction((ActionEvent e) -> {
            menu_stage();
            stage.close();
        });
        refresh.setOnAction((ActionEvent n) -> {
            stage.close();
            room_view();
        });
        root.getChildren().add(back);
        root.getChildren().add(refresh);
        TableView room_table = new TableView();
        TableColumn columnid = new TableColumn("Room ID");
        columnid.setCellValueFactory(new PropertyValueFactory("room_id"));
        TableColumn columnfloor = new TableColumn("Floor number");
        columnfloor.setCellValueFactory(new PropertyValueFactory("floor_num"));
        TableColumn columroom_rating = new TableColumn("Room rating");
        columroom_rating.setCellValueFactory(new PropertyValueFactory("room_ritng_id"));
        room_table.getColumns().addAll(columnid, columnfloor, columroom_rating);
        room_table.setTranslateX(650);
        room_table.setTranslateY(0);
        root.getChildren().add(room_table);
        room_table.setPrefSize(250, 450);
        room_table.setItems(data);
        stage.setScene(scene);
        stage.show();
    }

    public void booking_view() {
        Stage stage = new Stage();
        Group root = new Group();
        Scene scene = new Scene(root, 900, 500, Color.AQUA);
        Reservation_Queries r_q = new Reservation_Queries();
        Button Add = new Button("-Add Booking-");
        Add.setFont(new Font("Cambria", 18));
        Add.setTextFill(Color.RED);
        Add.setTranslateX(0);
        Add.setTranslateY(0);
        Add.setPrefWidth(150);
        DropShadow shadow = new DropShadow(10, Color.RED);
        Add.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            Add.setEffect(shadow);
        });
        Add.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            Add.setEffect(null);
        });
        Add.setOnAction((ActionEvent) -> {
            TextField room_id = new TextField();
            room_id.setPromptText("Room ID");
            room_id.setTranslateX(160);
            room_id.setPrefWidth(100);
            TextField customer_id = new TextField();
            customer_id.setPromptText("Customer ID");
            customer_id.setPrefWidth(100);
            customer_id.setTranslateX(270);
            TextField start_date = new TextField();
            start_date.setPromptText("Stard Date");
            start_date.setTranslateX(380);
            start_date.setPrefWidth(100);
            TextField end_date = new TextField();
            end_date.setPromptText("End Date");
            end_date.setTranslateX(490);
            end_date.setPrefWidth(100);
            Button save = new Button("Save");
            save.setTranslateX(600);
            save.setFont(new Font("Cambria", 14));
            save.setTextFill(Color.RED);
            save.setPrefWidth(150);
            save.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
                save.setEffect(shadow);
            });
            save.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
                save.setEffect(null);
            });
            save.setOnAction((ActionEvent x) -> {
                if (r_q.add_Reservation(Integer.parseInt(room_id.getText()), Integer.parseInt(customer_id.getText()), start_date.getText(), end_date.getText()) == "Add Done") {
                    Alert alert = new Alert(Alert.AlertType.NONE);
                    alert.setAlertType(Alert.AlertType.CONFIRMATION);
                    alert.setContentText("Add Done");
                    alert.show();

                } else {
                    Alert alert = new Alert(Alert.AlertType.NONE);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("Try Again (Wrong Data)");
                    alert.show();
                }

            });
            root.getChildren().addAll(end_date, start_date, room_id, customer_id, save);
        });
        root.getChildren().

                add(Add);

        Button Reserved = new Button("Delete Booking");
        Reserved.setFont(new

                Font("Cambria", 18));
        Reserved.setTextFill(Color.RED);
        Reserved.setTranslateX(0);
        Reserved.setTranslateY(35);
        Reserved.setPrefWidth(150);
        Reserved.addEventHandler(MouseEvent.MOUSE_ENTERED, (
                MouseEvent e) ->

        {
            Reserved.setEffect(shadow);
        });
        Reserved.addEventHandler(MouseEvent.MOUSE_EXITED, (
                MouseEvent e) ->

        {
            Reserved.setEffect(null);
        });
        Reserved.setOnAction((
                ActionEvent H) ->

        {
            TextField room_id = new TextField();
            room_id.setPromptText("Room ID");
            room_id.setTranslateY(35);
            room_id.setTranslateX(160);
            room_id.setPrefWidth(100);
            TextField Customer_id = new TextField();
            Customer_id.setPromptText("Customer ID");
            Customer_id.setTranslateY(35);
            Customer_id.setTranslateX(270);
            Customer_id.setPrefWidth(100);
            Button save = new Button("Save");
            save.setTranslateX(380);
            save.setTranslateY(35);
            save.setFont(new Font("Cambria", 14));
            save.setTextFill(Color.RED);
            save.setPrefWidth(100);
            save.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
                save.setEffect(shadow);
            });
            save.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
                save.setEffect(null);
            });
            save.setOnAction((ActionEvent m)->{
               if(r_q.delete_Reservation(Integer.parseInt(room_id.getText()),Integer.parseInt(Customer_id.getText()))=="delete done"){
                   Alert alert = new Alert(Alert.AlertType.NONE);
                   alert.setAlertType(Alert.AlertType.CONFIRMATION);
                   alert.setContentText("Delete Done");
                   alert.show();

               } else {
                   Alert alert = new Alert(Alert.AlertType.NONE);
                   alert.setAlertType(Alert.AlertType.WARNING);
                   alert.setContentText("Try Again(Customer or room not found)");
                   alert.show();
               }
            });
            root.getChildren().addAll(save, Customer_id, room_id);

        });
        root.getChildren().

                add(Reserved);

        Button back = new Button("--back to main menu--");
        back.setFont(new

                Font("Cambria", 18));
        back.setTextFill(Color.RED);
        back.setTranslateX(0);
        back.setTranslateY(463);
        back.addEventHandler(MouseEvent.MOUSE_ENTERED, (
                MouseEvent e) ->

        {
            back.setEffect(shadow);
        });
        back.addEventHandler(MouseEvent.MOUSE_EXITED, (
                MouseEvent e) ->

        {
            back.setEffect(null);
        });
        back.setOnAction((
                ActionEvent e) ->
        {
              stage.close();
              menu_stage();
        });
        Button refrech = new Button("--refresh--");
        refrech.setFont(new

                Font("Cambria", 18));
        refrech.setTextFill(Color.RED);
        refrech.setTranslateX(790);
        refrech.setTranslateY(463);
        refrech.addEventHandler(MouseEvent.MOUSE_ENTERED, (
                MouseEvent e) ->

        {
            refrech.setEffect(shadow);
        });
        refrech.addEventHandler(MouseEvent.MOUSE_EXITED, (
                MouseEvent e) ->

        {
            refrech.setEffect(null);
        });
        refrech.setOnAction((
                ActionEvent e) ->
        {
            stage.close();
            booking_view();
        });
        Button upade_date=new Button("Update End date for specific Reservation");
        upade_date.setTranslateY(100);
        upade_date.setTranslateX(0);
        upade_date.setPrefWidth(605);
        upade_date.setFont(new

                Font("Cambria", 18));
        upade_date.setTextFill(Color.RED);
        upade_date.addEventHandler(MouseEvent.MOUSE_ENTERED, (
                MouseEvent e) ->

        {
            upade_date.setEffect(shadow);
        });
        upade_date.addEventHandler(MouseEvent.MOUSE_EXITED, (
                MouseEvent e) ->

        {
            upade_date.setEffect(null);
        });
        upade_date.setOnAction((ActionEvent n)->{
            TextField customer_id= new TextField();
            customer_id.setPromptText("Customer ID");
            customer_id.setTranslateX(0);
            customer_id.setTranslateY(140);
            customer_id.setPrefWidth(100);
            TextField room_id= new TextField();
            room_id.setPromptText("Room ID");
            room_id.setTranslateX(120);
            room_id.setTranslateY(140);
            room_id.setPrefWidth(100);
            TextField end_date= new TextField();
            end_date.setPromptText("New End Date");
            end_date.setTranslateX(240);
            end_date.setTranslateY(140);
            end_date.setPrefWidth(100);
            Button save= new Button("Save");
            save.setTranslateX(360);
            save.setTranslateY(140);
            save.setPrefWidth(100);
            save.setFont(new

                    Font("Cambria", 14));
            save.setTextFill(Color.RED);
            save.addEventHandler(MouseEvent.MOUSE_ENTERED, (
                    MouseEvent e) ->

            {
                save.setEffect(shadow);
            });
            save.addEventHandler(MouseEvent.MOUSE_EXITED, (
                    MouseEvent e) ->

            {
                save.setEffect(null);

            });
            root.getChildren().addAll(save,room_id,customer_id,end_date);
            save.setOnAction((ActionEvent q)->{
                if(r_q.update_end_date_Reservation(Integer.parseInt(room_id.getText()),Integer.parseInt(customer_id.getText()),end_date.getText())=="update Done"){
                    Alert alert = new Alert(Alert.AlertType.NONE);
                    alert.setAlertType(Alert.AlertType.CONFIRMATION);
                    alert.setContentText("Update Done");
                    alert.show();

                } else {
                    Alert alert = new Alert(Alert.AlertType.NONE);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("Try Again(Customer or room not found)");
                    alert.show();
                }
            });

        });

        root.getChildren().add(upade_date);
        root.getChildren().add(refrech);
        root.getChildren().add(back);

        ObservableList<Reservation> data = FXCollections.observableArrayList(r_q.getallReservation());
        TableView Reservation_table = new TableView();
        TableColumn columnroomid = new TableColumn("Room ID");
        columnroomid.setCellValueFactory(new

                PropertyValueFactory("RoomRoom_ID"));
        TableColumn columncustomerid = new TableColumn("Customer ID");
        columncustomerid.setCellValueFactory(new

                PropertyValueFactory("CustomerCustomer_ID"));
        TableColumn columstart_date = new TableColumn("Start date");
        columstart_date.setCellValueFactory(new

                PropertyValueFactory("start_date"));
        TableColumn columend_date = new TableColumn("End date");
        columend_date.setCellValueFactory(new PropertyValueFactory("end_date"));
        Reservation_table.getColumns().addAll(columnroomid, columncustomerid,columstart_date,columend_date);
        Reservation_table.setItems(data);
        Reservation_table.setTranslateX(607);
        Reservation_table.setTranslateY(60);
        root.getChildren().

                add(Reservation_table);
        Reservation_table.setPrefSize(290, 400);
        stage.setScene(scene);
        stage.show();
    }

}


