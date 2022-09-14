package com.example.mediarentalprojectphase2;

import eu.hansolo.tilesfx.events.IndicatorEvent;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        MediaRentalManager mediaRentalManager = new MediaRentalManager();

        CornerRadii cornerRadii = new CornerRadii(10);
        BorderWidths borderWidths = new BorderWidths(2);
        Font font = Font.font("Verdana", FontWeight.BOLD, 16);

        BorderStroke borderStroke = new BorderStroke(Color.BROWN, BorderStrokeStyle.SOLID, cornerRadii,borderWidths );
        Border border = new Border(borderStroke);

        CornerRadii cornerRadii2 = new CornerRadii(0);
        BorderStroke borderStroke2 = new BorderStroke(Color.BROWN, BorderStrokeStyle.SOLID,cornerRadii2 ,borderWidths );
        Border border2 = new Border(borderStroke2);


        System.out.println(100.55D);

        VBox buttonPane = new VBox();
        buttonPane.setSpacing(20);

        Button customer = new Button("Customer");
        customer.setTextFill(Color.BLACK);
        customer.setMinSize(100,50);
        customer.setFont(font);
        customer.setStyle("-fx-border-radius: 10;-fx-background-color: #B28961;-fx-border-color: brown;-fx-background-radius: 10;");
        ImageView cView = new ImageView("C:\\Users\\pro\\IdeaProjects\\MediaRentalProjectPhase2\\src\\main\\java\\com\\example\\mediarentalprojectphase2\\customer.png");
        cView.setFitHeight(30);
        cView.setFitWidth(30);
        customer.setGraphic(cView);
        customer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage customerStage = new Stage();
                Button addCustomer = new Button("Add New Customer");
                addCustomer.setTextFill(Color.BLACK);
                addCustomer.setMinSize(100, 50);
                addCustomer.setStyle("-fx-border-radius: 10;-fx-background-color: #B28961;-fx-border-color: brown;-fx-background-radius: 10;");
                addCustomer.setFont(font);
                addCustomer.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {

                        Stage customerStage = new Stage();

                        GridPane gridPane = new GridPane();
                        gridPane.setAlignment(Pos.CENTER);
                        gridPane.setVgap(10);
                        gridPane.setHgap(20);

                        gridPane.add(new Label("Customer ID:"),0,0);
                        TextField customerIdField = new TextField();
                        customerIdField.setBorder(border2);
                        gridPane.add(customerIdField,1,0);



                        TextField customerNameField = new TextField();
                        customerNameField.setBorder(border2);
                        gridPane.add(new Label("Customer Name:"),0,1);
                        gridPane.add(customerNameField,1,1);
                        customerNameField.disableProperty().bind(Bindings.isEmpty(customerIdField.textProperty()));//activates if previous text field isn't empty



                        gridPane.add(new Label("Customer Address:"),0,3);
                        TextField customerAddressField = new TextField();
                        customerAddressField.setBorder(border2);
                        gridPane.add(customerAddressField,1,3);
                        customerAddressField.setDisable(true);
                        customerAddressField.disableProperty().bind(Bindings.isEmpty(customerNameField.textProperty()));


                        gridPane.add(new Label("Customer Mobile:"),0,5);
                        TextField customerMobileField = new TextField();
                        customerMobileField.setBorder(border2);
                        gridPane.add(customerMobileField,1,5);
                        customerMobileField.disableProperty().bind(Bindings.isEmpty(customerAddressField.textProperty()));

                        gridPane.add(new Label("Customer Plan:"),0,6);
                        TextField customerPlanField = new TextField();
                        customerPlanField.setBorder(border2);
                        gridPane.add(customerPlanField,1,6);
                        customerPlanField.disableProperty().bind(Bindings.isEmpty(customerMobileField.textProperty()));


                        HBox buttonPane = new HBox();
                        buttonPane.setSpacing(10);
                        buttonPane.setAlignment(Pos.CENTER);
                        buttonPane.setMinSize(300,50);


                        Button addToCart = new Button("Add");
                        Font font2 = Font.font("Verdana", FontWeight.BOLD, 12);
                        addToCart.setFont(font2);
                        addToCart.setStyle("-fx-border-radius: 10;-fx-background-color: #B28961;-fx-border-color: brown;-fx-background-radius: 10;");
                        addToCart.setTextFill(Color.BLACK);
                        ImageView addImage = new ImageView("C:\\Users\\pro\\IdeaProjects\\MediaRentalProjectPhase2\\src\\main\\java\\com\\example\\mediarentalprojectphase2\\add.png");
                        addImage.setFitHeight(20);
                        addImage.setFitWidth(20);
                        addToCart.setGraphic(addImage);
                        addToCart.disableProperty().bind(Bindings.isEmpty((customerPlanField.textProperty())));
                        addToCart.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                String name;
                                String id;
                                String address;
                                String mobile;
                                String plan;
                                if(customerMobileField.isEditable()){
                                    id = customerIdField.getText();
                                    name = customerNameField.getText();
                                    address = customerAddressField.getText();
                                    mobile = customerMobileField.getText();
                                    plan = customerPlanField.getText();
                                    mediaRentalManager.addCustomer(id,name,address,mobile,plan);
                                    customerIdField.deleteText(0,id.length());
                                    customerNameField.deleteText(0,name.length());
                                    customerAddressField.deleteText(0,address.length());
                                    customerMobileField.deleteText(0,mobile.length());
                                    customerPlanField.deleteText(0,plan.length());
                                }
                            }
                        });


                        Button back = new Button("Back");
                        back.setFont(font2);
                        back.setStyle("-fx-border-radius: 10;-fx-background-color: #B28961;-fx-border-color: brown;-fx-background-radius: 10;");
                        back.setTextFill(Color.BLACK);
                        ImageView backImage = new ImageView("C:\\Users\\pro\\IdeaProjects\\MediaRentalProjectPhase2\\src\\main\\java\\com\\example\\mediarentalprojectphase2\\back.png");
                        backImage.setFitHeight(20);
                        backImage.setFitWidth(20);
                        back.setGraphic(backImage);

                        back.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                customerStage.close();
                            }
                        });

                        buttonPane.getChildren().addAll(addToCart,back);
                        VBox vBox = new VBox(gridPane,buttonPane);
                        vBox.setMinSize(300,200);
                        //vBox.setBorder(border);
                        vBox.setAlignment(Pos.CENTER);

                        Scene scene = new Scene(vBox,600,600);
                        customerStage.setMaximized(true);
                        customerStage.setTitle("Add Customer Menu");
                        customerStage.setScene(scene);
                        customerStage.show();

                    }
                });

                Button deleteCustomer = new Button("Delete Customer");
                deleteCustomer.setTextFill(Color.BLACK);
                deleteCustomer.setMinSize(100, 50);
                deleteCustomer.setStyle("-fx-border-radius: 10;-fx-background-color: #B28961;-fx-border-color: brown;-fx-background-radius: 10;");
                deleteCustomer.setFont(font);
                deleteCustomer.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        Stage customerStage = new Stage();

                        GridPane gridPane = new GridPane();
                        gridPane.setAlignment(Pos.CENTER);
                        gridPane.setVgap(10);
                        gridPane.setHgap(20);

                        gridPane.add(new Label("Customer ID:"),0,0);
                        TextField customerIdField = new TextField();
                        customerIdField.setBorder(border2);
                        gridPane.add(customerIdField,1,0);



                        TextField customerNameField = new TextField();
                        customerNameField.setBorder(border2);
                        gridPane.add(new Label("Customer Name:"),0,1);
                        gridPane.add(customerNameField,1,1);
                        //customerNameField.disableProperty().bind(Bindings.isEmpty(customerIdField.textProperty()));//activates if previous text field isn't empty



                        gridPane.add(new Label("Customer Address:"),0,3);
                        TextField customerAddressField = new TextField();
                        customerAddressField.setBorder(border2);
                        gridPane.add(customerAddressField,1,3);
                        ///customerAddressField.disableProperty().bind(Bindings.isEmpty(customerNameField.textProperty()));


                        gridPane.add(new Label("Customer Mobile:"),0,5);
                        TextField customerMobileField = new TextField();
                        customerMobileField.setBorder(border2);
                        gridPane.add(customerMobileField,1,5);
                        //customerMobileField.disableProperty().bind(Bindings.isEmpty(customerAddressField.textProperty()));

                        gridPane.add(new Label("Customer Plan:"),0,6);
                        TextField customerPlanField = new TextField();
                        customerPlanField.setBorder(border2);
                        gridPane.add(customerPlanField,1,6);
                        //customerPlanField.disableProperty().bind(Bindings.isEmpty(customerMobileField.textProperty()));


                        HBox buttonPane = new HBox();
                        buttonPane.setSpacing(10);
                        buttonPane.setAlignment(Pos.CENTER);
                        buttonPane.setMinSize(300,50);

                        Button find = new Button("Find");
                        Font font2 = Font.font("Verdana", FontWeight.BOLD, 12);
                        find.setFont(font2);
                        find.setStyle("-fx-border-radius: 10;-fx-background-color: #B28961;-fx-border-color: brown;-fx-background-radius: 10;");
                        find.setTextFill(Color.BLACK);
                        ImageView addImage = new ImageView("C:\\Users\\pro\\IdeaProjects\\MediaRentalProjectPhase2\\src\\main\\java\\com\\example\\mediarentalprojectphase2\\find.png");
                        addImage.setFitHeight(20);
                        addImage.setFitWidth(20);
                        find.setGraphic(addImage);
                        find.disableProperty().bind(Bindings.isEmpty((customerIdField.textProperty())));
                        find.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                String name;
                                String id;
                                String address;
                                String mobile;
                                String plan;

                                id = customerIdField.getText();
                                String[] customerInfo =  mediaRentalManager.findCustomer(id);
                                name = customerInfo[0];
                                address = customerInfo[1];
                                mobile = customerInfo[2];
                                plan = customerInfo[3];
                                customerNameField.setText("name");
                                customerAddressField.setText(address);
                                customerMobileField.setText(mobile);
                                customerPlanField.setText(plan);


                            }
                        });


                        Button delete = new Button("Delete");
                        delete.setFont(font2);
                        delete.setStyle("-fx-border-radius: 10;-fx-background-color: #B28961;-fx-border-color: brown;-fx-background-radius: 10;");
                        delete.setTextFill(Color.BLACK);
                        ImageView deleteImage = new ImageView("C:\\Users\\pro\\IdeaProjects\\MediaRentalProjectPhase2\\src\\main\\java\\com\\example\\mediarentalprojectphase2\\trash.png");
                        deleteImage.setFitHeight(20);
                        deleteImage.setFitWidth(20);
                        delete.setGraphic(deleteImage);
                        delete.disableProperty().bind(Bindings.isEmpty((customerPlanField.textProperty())));
                        delete.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                String name = new String();
                                String id = new String();
                                String address = new String();
                                String mobile = new String();
                                String plan = new String();
                                if(customerMobileField.isEditable()){
                                    id = customerIdField.getText();
                                    name = customerNameField.getText();
                                    address = customerAddressField.getText();
                                    mobile = customerMobileField.getText();
                                    plan = customerPlanField.getText();
                                    mediaRentalManager.deleteCustomer(id,name,address,mobile,plan);
                                    customerIdField.deleteText(0,id.length());
                                    customerNameField.deleteText(0,name.length());
                                    customerAddressField.deleteText(0,address.length());
                                    customerMobileField.deleteText(0,mobile.length());
                                    customerPlanField.deleteText(0,plan.length());
                                }
                            }
                        });


                        Button back = new Button("Back");
                        back.setFont(font2);
                        back.setStyle("-fx-border-radius: 10;-fx-background-color: #B28961;-fx-border-color: brown;-fx-background-radius: 10;");
                        back.setTextFill(Color.BLACK);
                        ImageView backImage = new ImageView("C:\\Users\\pro\\IdeaProjects\\MediaRentalProjectPhase2\\src\\main\\java\\com\\example\\mediarentalprojectphase2\\back.png");
                        backImage.setFitHeight(20);
                        backImage.setFitWidth(20);
                        back.setGraphic(backImage);

                        back.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                customerStage.close();
                            }
                        });

                        buttonPane.getChildren().addAll(find,delete,back);
                        VBox vBox = new VBox(gridPane,buttonPane);
                        vBox.setMinSize(300,200);
                        //vBox.setBorder(border);
                        vBox.setAlignment(Pos.CENTER);

                        Scene scene = new Scene(vBox,600,600);
                        customerStage.setMaximized(true);
                        customerStage.setTitle("Delete Customer Menu");
                        customerStage.setScene(scene);
                        customerStage.show();
                    }
                });

                Button update = new Button("Update Customer Information");
                update.setTextFill(Color.BLACK);
                update.setMinSize(100, 50);
                update.setStyle("-fx-border-radius: 10;-fx-background-color: #B28961;-fx-border-color: brown;-fx-background-radius: 10;");
                update.setFont(font);
                update.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        Stage customerStage = new Stage();

                        GridPane gridPane = new GridPane();
                        gridPane.setAlignment(Pos.CENTER);
                        gridPane.setVgap(10);
                        gridPane.setHgap(20);

                        gridPane.add(new Label("Customer ID:"),0,0);
                        TextField customerIdField = new TextField();
                        customerIdField.setBorder(border2);
                        gridPane.add(customerIdField,1,0);



                        TextField customerNameField = new TextField();
                        customerNameField.setBorder(border2);
                        gridPane.add(new Label("Customer Name:"),0,1);
                        gridPane.add(customerNameField,1,1);
                        //customerNameField.disableProperty().bind(Bindings.isEmpty(customerIdField.textProperty()));//activates if previous text field isn't empty



                        gridPane.add(new Label("Customer Address:"),0,3);
                        TextField customerAddressField = new TextField();
                        customerAddressField.setBorder(border2);
                        gridPane.add(customerAddressField,1,3);
                        ///customerAddressField.disableProperty().bind(Bindings.isEmpty(customerNameField.textProperty()));


                        gridPane.add(new Label("Customer Mobile:"),0,5);
                        TextField customerMobileField = new TextField();
                        customerMobileField.setBorder(border2);
                        gridPane.add(customerMobileField,1,5);
                        //customerMobileField.disableProperty().bind(Bindings.isEmpty(customerAddressField.textProperty()));

                        gridPane.add(new Label("Customer Plan:"),0,6);
                        TextField customerPlanField = new TextField();
                        customerPlanField.setBorder(border2);
                        gridPane.add(customerPlanField,1,6);
                        //customerPlanField.disableProperty().bind(Bindings.isEmpty(customerMobileField.textProperty()));


                        HBox buttonPane = new HBox();
                        buttonPane.setSpacing(10);
                        buttonPane.setAlignment(Pos.CENTER);
                        buttonPane.setMinSize(300,50);

                        Button find = new Button("Find");
                        Font font2 = Font.font("Verdana", FontWeight.BOLD, 12);
                        find.setFont(font2);
                        find.setStyle("-fx-border-radius: 10;-fx-background-color: #B28961;-fx-border-color: brown;-fx-background-radius: 10;");
                        find.setTextFill(Color.BLACK);
                        ImageView addImage = new ImageView("C:\\Users\\pro\\IdeaProjects\\MediaRentalProjectPhase2\\src\\main\\java\\com\\example\\mediarentalprojectphase2\\find.png");
                        addImage.setFitHeight(20);
                        addImage.setFitWidth(20);
                        find.setGraphic(addImage);
                        find.disableProperty().bind(Bindings.isEmpty((customerIdField.textProperty())));
                        find.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                String name;
                                String id;
                                String address;
                                String mobile;
                                String plan;

                                id = customerIdField.getText();
                                String[] customerInfo =  mediaRentalManager.findCustomer(id);
                                name = customerInfo[0];
                                address = customerInfo[1];
                                mobile = customerInfo[2];
                                plan = customerInfo[3];
                                customerNameField.setText("name");
                                customerAddressField.setText(address);
                                customerMobileField.setText(mobile);
                                customerPlanField.setText(plan);


                            }
                        });


                        Button delete = new Button("Delete");
                        delete.setFont(font2);
                        delete.setStyle("-fx-border-radius: 10;-fx-background-color: #B28961;-fx-border-color: brown;-fx-background-radius: 10;");
                        delete.setTextFill(Color.BLACK);
                        ImageView deleteImage = new ImageView("C:\\Users\\pro\\IdeaProjects\\MediaRentalProjectPhase2\\src\\main\\java\\com\\example\\mediarentalprojectphase2\\trash.png");
                        deleteImage.setFitHeight(20);
                        deleteImage.setFitWidth(20);
                        delete.setGraphic(deleteImage);
                        delete.disableProperty().bind(Bindings.isEmpty((customerPlanField.textProperty())));
                        delete.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                String name = new String();
                                String id = new String();
                                String address = new String();
                                String mobile = new String();
                                String plan = new String();
                                if(customerMobileField.isEditable()){
                                    id = customerIdField.getText();
                                    name = customerNameField.getText();
                                    address = customerAddressField.getText();
                                    mobile = customerMobileField.getText();
                                    plan = customerPlanField.getText();
                                    mediaRentalManager.deleteCustomer(id,name,address,mobile,plan);
                                    customerIdField.deleteText(0,id.length());
                                    customerNameField.deleteText(0,name.length());
                                    customerAddressField.deleteText(0,address.length());
                                    customerMobileField.deleteText(0,mobile.length());
                                    customerPlanField.deleteText(0,plan.length());
                                }
                            }
                        });


                        Button back = new Button("Back");
                        back.setFont(font2);
                        back.setStyle("-fx-border-radius: 10;-fx-background-color: #B28961;-fx-border-color: brown;-fx-background-radius: 10;");
                        back.setTextFill(Color.BLACK);
                        ImageView backImage = new ImageView("C:\\Users\\pro\\IdeaProjects\\MediaRentalProjectPhase2\\src\\main\\java\\com\\example\\mediarentalprojectphase2\\back.png");
                        backImage.setFitHeight(20);
                        backImage.setFitWidth(20);
                        back.setGraphic(backImage);

                        back.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                customerStage.close();
                            }
                        });

                        buttonPane.getChildren().addAll(find,delete,back);
                        VBox vBox = new VBox(gridPane,buttonPane);
                        vBox.setMinSize(300,200);
                        //vBox.setBorder(border);
                        vBox.setAlignment(Pos.CENTER);

                        Scene scene = new Scene(vBox,600,600);
                        customerStage.setMaximized(true);
                        customerStage.setTitle("Update Customer Menu");
                        customerStage.setScene(scene);
                        customerStage.show();
                    }

                });

                Button searchbyID = new Button("Search Customer by ID");
                searchbyID.setTextFill(Color.BLACK);
                searchbyID.setMinSize(100, 50);
                searchbyID.setStyle("-fx-border-radius: 10;-fx-background-color: #B28961;-fx-border-color: brown;-fx-background-radius: 10;");
                searchbyID.setFont(font);
                searchbyID.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        Stage customerStage = new Stage();

                        GridPane gridPane = new GridPane();
                        gridPane.setAlignment(Pos.CENTER);
                        gridPane.setVgap(10);
                        gridPane.setHgap(20);

                        gridPane.add(new Label("Customer ID:"),0,0);
                        TextField customerIdField = new TextField();
                        customerIdField.setBorder(border2);
                        gridPane.add(customerIdField,1,0);



                        TextField customerNameField = new TextField();
                        customerNameField.setBorder(border2);
                        gridPane.add(new Label("Customer Name:"),0,1);
                        gridPane.add(customerNameField,1,1);
                        //customerNameField.disableProperty().bind(Bindings.isEmpty(customerIdField.textProperty()));//activates if previous text field isn't empty



                        gridPane.add(new Label("Customer Address:"),0,3);
                        TextField customerAddressField = new TextField();
                        customerAddressField.setBorder(border2);
                        gridPane.add(customerAddressField,1,3);
                        ///customerAddressField.disableProperty().bind(Bindings.isEmpty(customerNameField.textProperty()));


                        gridPane.add(new Label("Customer Mobile:"),0,5);
                        TextField customerMobileField = new TextField();
                        customerMobileField.setBorder(border2);
                        gridPane.add(customerMobileField,1,5);
                        //customerMobileField.disableProperty().bind(Bindings.isEmpty(customerAddressField.textProperty()));

                        gridPane.add(new Label("Customer Plan:"),0,6);
                        TextField customerPlanField = new TextField();
                        customerPlanField.setBorder(border2);
                        gridPane.add(customerPlanField,1,6);
                        //customerPlanField.disableProperty().bind(Bindings.isEmpty(customerMobileField.textProperty()));


                        HBox buttonPane = new HBox();
                        buttonPane.setSpacing(10);
                        buttonPane.setAlignment(Pos.CENTER);
                        buttonPane.setMinSize(300,50);

                        Button find = new Button("Find");
                        Font font2 = Font.font("Verdana", FontWeight.BOLD, 12);
                        find.setFont(font2);
                        find.setStyle("-fx-border-radius: 10;-fx-background-color: #B28961;-fx-border-color: brown;-fx-background-radius: 10;");
                        find.setTextFill(Color.BLACK);
                        ImageView addImage = new ImageView("C:\\Users\\pro\\IdeaProjects\\MediaRentalProjectPhase2\\src\\main\\java\\com\\example\\mediarentalprojectphase2\\find.png");
                        addImage.setFitHeight(20);
                        addImage.setFitWidth(20);
                        find.setGraphic(addImage);
                        find.disableProperty().bind(Bindings.isEmpty((customerIdField.textProperty())));
                        find.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                String name;
                                String id;
                                String address;
                                String mobile;
                                String plan;

                                id = customerIdField.getText();
                                String[] customerInfo =  mediaRentalManager.findCustomer(id);
                                name = customerInfo[0];
                                address = customerInfo[1];
                                mobile = customerInfo[2];
                                plan = customerInfo[3];
                                customerNameField.setText("name");
                                customerAddressField.setText(address);
                                customerMobileField.setText(mobile);
                                customerPlanField.setText(plan);


                            }
                        });


                        Button delete = new Button("Delete");
                        delete.setFont(font2);
                        delete.setStyle("-fx-border-radius: 10;-fx-background-color: #B28961;-fx-border-color: brown;-fx-background-radius: 10;");
                        delete.setTextFill(Color.BLACK);
                        ImageView deleteImage = new ImageView("C:\\Users\\pro\\IdeaProjects\\MediaRentalProjectPhase2\\src\\main\\java\\com\\example\\mediarentalprojectphase2\\trash.png");
                        deleteImage.setFitHeight(20);
                        deleteImage.setFitWidth(20);
                        delete.setGraphic(deleteImage);
                        delete.disableProperty().bind(Bindings.isEmpty((customerPlanField.textProperty())));
                        delete.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                String name = new String();
                                String id = new String();
                                String address = new String();
                                String mobile = new String();
                                String plan = new String();
                                if(customerMobileField.isEditable()){
                                    id = customerIdField.getText();
                                    name = customerNameField.getText();
                                    address = customerAddressField.getText();
                                    mobile = customerMobileField.getText();
                                    plan = customerPlanField.getText();
                                    mediaRentalManager.deleteCustomer(id,name,address,mobile,plan);
                                    customerIdField.deleteText(0,id.length());
                                    customerNameField.deleteText(0,name.length());
                                    customerAddressField.deleteText(0,address.length());
                                    customerMobileField.deleteText(0,mobile.length());
                                    customerPlanField.deleteText(0,plan.length());
                                }
                            }
                        });


                        Button back = new Button("Back");
                        back.setFont(font2);
                        back.setStyle("-fx-border-radius: 10;-fx-background-color: #B28961;-fx-border-color: brown;-fx-background-radius: 10;");
                        back.setTextFill(Color.BLACK);
                        ImageView backImage = new ImageView("C:\\Users\\pro\\IdeaProjects\\MediaRentalProjectPhase2\\src\\main\\java\\com\\example\\mediarentalprojectphase2\\back.png");
                        backImage.setFitHeight(20);
                        backImage.setFitWidth(20);
                        back.setGraphic(backImage);

                        back.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                customerStage.close();
                            }
                        });

                        buttonPane.getChildren().addAll(find,delete,back);
                        VBox vBox = new VBox(gridPane,buttonPane);
                        vBox.setMinSize(300,200);
                        //vBox.setBorder(border);
                        vBox.setAlignment(Pos.CENTER);

                        Scene scene = new Scene(vBox,600,600);
                        customerStage.setMaximized(true);
                        customerStage.setTitle("Search Customer Menu");
                        customerStage.setScene(scene);
                        customerStage.show();

                    }
                });
                Button returnToMain = new Button("Return to Main Page");
                returnToMain.setTextFill(Color.BLACK);
                returnToMain.setMinSize(100, 50);
                returnToMain.setStyle("-fx-border-radius: 10;-fx-background-color: #B28961;-fx-border-color: brown;-fx-background-radius: 10;");
                returnToMain.setFont(font);
                returnToMain.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        customerStage.close();
                    }
                });

                VBox buttonPane = new VBox();
                buttonPane.getChildren().addAll(addCustomer, deleteCustomer, update, searchbyID, returnToMain);
                buttonPane.setSpacing(20);
                buttonPane.setAlignment(Pos.CENTER);

                Scene scene = new Scene(buttonPane,600,600);
                customerStage.setMaximized(true);
                customerStage.setTitle("Delete Customer Menu");
                customerStage.setScene(scene);
                customerStage.show();
            }
        });

        Button media = new Button("Media");
        media.setTextFill(Color.BLACK);
        media.setMinSize(130,50);
        media.setFont(font);
        media.setStyle("-fx-border-radius: 10;-fx-background-color: #B28961;-fx-border-color: brown;-fx-background-radius: 10;");
        ImageView mView = new ImageView("C:\\Users\\pro\\IdeaProjects\\MediaRentalProjectPhase2\\src\\main\\java\\com\\example\\mediarentalprojectphase2\\media.png");
        mView.setFitHeight(30);
        mView.setFitWidth(30);
        media.setGraphic(mView);
        media.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage mediaStage = new Stage();
                Button addMedia = new Button("Add New Media Title");
                addMedia.setTextFill(Color.BLACK);
                addMedia.setMinSize(100, 50);
                addMedia.setStyle("-fx-border-radius: 10;-fx-background-color: #B28961;-fx-border-color: brown;-fx-background-radius: 10;");
                addMedia.setFont(font);
                HBox hBox1 = new HBox();
                addMedia.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {

                        Stage addMediaStage = new Stage();

                        GridPane gridPane = new GridPane();
                        gridPane.setAlignment(Pos.CENTER);
                        gridPane.setVgap(10);
                        gridPane.setHgap(20);
                        String[] mediaTypes = {"Movie","Game","Album"};
                        ComboBox<String> mediaBox = new ComboBox<>();
                        BorderPane pane = new BorderPane();
                        BorderPane borderPane = new BorderPane();
                        borderPane.setLeft(new Label("Select a media type:"));
                        borderPane.setCenter(mediaBox);
                        pane.setTop(borderPane);
                        mediaBox.getItems().addAll(mediaTypes[0],mediaTypes[1],mediaTypes[2]);
                        mediaBox.setBorder(border2);
                        HBox hBox = new HBox(mediaBox);
                        hBox.setAlignment(Pos.CENTER);
                        Button find = new Button("Find");
                        Button back = new Button("Back");
                        Button add = new Button("Add");

                        mediaBox.setOnAction(new EventHandler<ActionEvent>() {

                            @Override
                            public void handle(ActionEvent actionEvent) {
                                if(mediaBox.getValue().equals("Movie")){
                                    gridPane.getChildren().clear();
                                      gridPane.add(new Label("Movie Code:"),0,0);
                                      TextField mediaCodeField = new TextField();
                                      mediaCodeField.setBorder(border2);
                                      gridPane.add(mediaCodeField,1,0);

                                      TextField mediaTitleField = new TextField();
                                      mediaTitleField.setBorder(border2);
                                      gridPane.add(new Label("Media Title:"),0,1);
                                      gridPane.add(mediaTitleField,1,1);

                                      gridPane.add(new Label("Copies Available:"),0,3);
                                      TextField copiesAvailableField = new TextField();
                                      copiesAvailableField.setBorder(border2);
                                      gridPane.add(copiesAvailableField,1,3);

                                }
                                else if(mediaBox.getValue().equals("Game")){
                                    gridPane.getChildren().clear();
                                    gridPane.add(new Label("Game Code:"),0,0);
                                    TextField mediaCodeField = new TextField();
                                    mediaCodeField.setBorder(border2);
                                    gridPane.add(mediaCodeField,1,0);

                                    TextField gameField = new TextField();
                                    gameField.setBorder(border2);
                                    gridPane.add(new Label("Game Title:"),0,1);
                                    gridPane.add(gameField,1,1);

                                    gridPane.add(new Label("Copies Available:"),0,3);
                                    TextField copiesAvailableField = new TextField();
                                    copiesAvailableField.setBorder(border2);
                                    gridPane.add(copiesAvailableField,1,3);

                                    TextField gameWeightField = new TextField();
                                    gameWeightField.setBorder(border2);
                                    gridPane.add(new Label("Game weight:"),0,4);
                                    gridPane.add(gameWeightField,1,4);

                                }
                                else{
                                    gridPane.getChildren().clear();
                                    gridPane.add(new Label("Album Code:"),0,0);
                                    TextField mediaCodeField = new TextField();
                                    mediaCodeField.setBorder(border2);
                                    gridPane.add(mediaCodeField,1,0);

                                    TextField mediaTitleField = new TextField();
                                    mediaTitleField.setBorder(border2);
                                    gridPane.add(new Label("Album Title:"),0,1);
                                    gridPane.add(mediaTitleField,1,1);

                                    gridPane.add(new Label("Artist:"),0,2);
                                    TextField artistField = new TextField();
                                    artistField.setBorder(border2);
                                    gridPane.add(artistField,1,2);

                                    gridPane.add(new Label("songs:"),0,3);
                                    TextField songsField = new TextField();
                                    songsField.setBorder(border2);
                                    gridPane.add(songsField,1,3);

                                    gridPane.add(new Label("Copies Available:"),0,4);
                                    TextField copiesAvailableField = new TextField();
                                    copiesAvailableField.setBorder(border2);
                                    gridPane.add(copiesAvailableField,1,4);
                                    

                                }



                                Font font2 = Font.font("Verdana", FontWeight.BOLD, 12);
                                add.setFont(font2);
                                ImageView addImage = new ImageView("C:\\Users\\pro\\IdeaProjects\\MediaRentalProjectPhase2\\src\\main\\java\\com\\example\\mediarentalprojectphase2\\back.png");
                                addImage.setFitHeight(20);
                                addImage.setFitWidth(20);
                                back.setGraphic(addImage);
                                add.setStyle("-fx-border-radius: 10;-fx-background-color: #B28961;-fx-border-color: brown;-fx-background-radius: 10;");
                                add.setTextFill(Color.BLACK);


                                back.setFont(font2);
                                back.setStyle("-fx-border-radius: 10;-fx-background-color: #B28961;-fx-border-color: brown;-fx-background-radius: 10;");
                                back.setTextFill(Color.BLACK);
                                ImageView backImage = new ImageView("C:\\Users\\pro\\IdeaProjects\\MediaRentalProjectPhase2\\src\\main\\java\\com\\example\\mediarentalprojectphase2\\back.png");
                                backImage.setFitHeight(20);
                                backImage.setFitWidth(20);
                                back.setGraphic(backImage);
                                back.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent actionEvent) {
                                        addMediaStage.close();
                                    }
                                });


                                find.setFont(font2);
                                find.setStyle("-fx-border-radius: 10;-fx-background-color: #B28961;-fx-border-color: brown;-fx-background-radius: 10;");
                                find.setTextFill(Color.BLACK);
                                ImageView findImage = new ImageView("C:\\Users\\pro\\IdeaProjects\\MediaRentalProjectPhase2\\src\\main\\java\\com\\example\\mediarentalprojectphase2\\find.png");
                                addImage.setFitHeight(20);
                                addImage.setFitWidth(20);
                                find.setGraphic(addImage);

                            }

                        });
                        hBox1.getChildren().addAll(find,add,back);
                        hBox1.setAlignment(Pos.CENTER);
                        VBox vBox = new VBox(mediaBox,gridPane,hBox1);
                        vBox.setAlignment(Pos.CENTER);
                        Scene scene = new Scene(vBox,600,600);
                        addMediaStage.setMaximized(true);
                        addMediaStage.setTitle("Add Media Menu");
                        addMediaStage.setScene(scene);
                        addMediaStage.show();

                    }
                });

                Button deleteMedia = new Button("Delete Media");
                deleteMedia.setTextFill(Color.BLACK);
                deleteMedia.setMinSize(100, 50);
                deleteMedia.setStyle("-fx-border-radius: 10;-fx-background-color: #B28961;-fx-border-color: brown;-fx-background-radius: 10;");
                deleteMedia.setFont(font);

                Button update = new Button("Update Media Information");
                update.setTextFill(Color.BLACK);
                update.setMinSize(100, 50);
                update.setStyle("-fx-border-radius: 10;-fx-background-color: #B28961;-fx-border-color: brown;-fx-background-radius: 10;");
                update.setFont(font);

                Button search = new Button("Search Media Title by Code");
                search.setTextFill(Color.BLACK);
                search.setMinSize(100, 50);
                search.setStyle("-fx-border-radius: 10;-fx-background-color: #B28961;-fx-border-color: brown;-fx-background-radius: 10;");
                search.setFont(font);

                Button print = new Button("Print All Media Information");
                print.setTextFill(Color.BLACK);
                print.setMinSize(100, 50);
                print.setStyle("-fx-border-radius: 10;-fx-background-color: #B28961;-fx-border-color: brown;-fx-background-radius: 10;");
                print.setFont(font);

                Button returnToMain = new Button("Return to Main Page");
                returnToMain.setTextFill(Color.BLACK);
                returnToMain.setMinSize(100, 50);
                returnToMain.setStyle("-fx-border-radius: 10;-fx-background-color: #B28961;-fx-border-color: brown;-fx-background-radius: 10;");
                returnToMain.setFont(font);
                returnToMain.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        mediaStage.close();
                    }
                });

                VBox buttonPane = new VBox();
                buttonPane.getChildren().addAll(addMedia, deleteMedia, update, search, print, returnToMain);
                buttonPane.setSpacing(20);
                buttonPane.setAlignment(Pos.CENTER);

                Scene scene = new Scene(buttonPane,600,600);
                mediaStage.setMaximized(true);
                mediaStage.setTitle("Media Menu");
                mediaStage.setScene(scene);
                mediaStage.show();
            }
        });

        Button rent = new Button("Rent");
        rent.setTextFill(Color.BLACK);
        rent.setMinSize(130,50);
        rent.setFont(font);
        rent.setStyle("-fx-border-radius: 10;-fx-background-color: #B28961;-fx-border-color: brown;-fx-background-radius: 10;");
        ImageView rView = new ImageView("C:\\Users\\pro\\IdeaProjects\\MediaRentalProjectPhase2\\src\\main\\java\\com\\example\\mediarentalprojectphase2\\rent.png");
        rView.setFitHeight(30);
        rView.setFitWidth(30);
        rent.setGraphic(rView);
        rent.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage rentStage = new Stage();

                GridPane gridPane = new GridPane();
                gridPane.setAlignment(Pos.CENTER);
                gridPane.setVgap(5);
                gridPane.setHgap(2);

                gridPane.add(new Label("Customer ID:"),0,0);
                TextField customerIdField = new TextField();
                customerIdField.setBorder(border2);
                gridPane.add(customerIdField,1,0);


                TextField customerInfoField = new TextField();

                CornerRadii cornerRadii2 = new CornerRadii(0);
                BorderStroke borderStroke2 = new BorderStroke(Color.BROWN, BorderStrokeStyle.SOLID,cornerRadii2 ,borderWidths );
                Border border2 = new Border(borderStroke2);

                customerInfoField.setBorder(border2);
                customerInfoField.setMinSize(200,75);
                gridPane.add(customerInfoField,1,1);

                gridPane.add(new Label("Media Code:"),0,3);
                TextField mediaInfoField = new TextField();
                TextField mediaCodeField = new TextField();
                mediaCodeField.setBorder(border2);
                gridPane.add(mediaCodeField,1,3);


                gridPane.add(mediaInfoField,1,4);
                mediaInfoField.setBorder(border2);
                mediaInfoField.setMinSize(200,75);

                gridPane.add(new Label("Rented Date:"),0,5);
                TextField rentedDate = new TextField();
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd | HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                rentedDate.setText(dtf.format(now));
                gridPane.add(rentedDate,1,5);
                rentedDate.setBorder(border2);

                HBox buttonPane = new HBox();
                buttonPane.setSpacing(10);
                buttonPane.setAlignment(Pos.CENTER);
                buttonPane.setMinSize(300,50);


                Button addToCart = new Button("Add to Cart");
                Font font2 = Font.font("Verdana", FontWeight.BOLD, 12);
                addToCart.setFont(font2);
                addToCart.setStyle("-fx-border-radius: 10;-fx-background-color: #B28961;-fx-border-color: brown;-fx-background-radius: 10;");
                addToCart.setTextFill(Color.BLACK);
                addToCart.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        String id = customerIdField.getText();

                        String code = mediaCodeField.getText();
                        String[] customerInfo = mediaRentalManager.findCustomer(id);
                        String name = customerInfo[1];
                        Media m = mediaRentalManager.searchMediabyCode(code);
                        mediaRentalManager.addToCart(name,m.getTitle());
                        customerIdField.setText("");
                        customerInfoField.setText("");
                        mediaCodeField.setText("");
                        mediaInfoField.setText("");
                    }
                });

                Button processCart = new Button("Process Cart");
                processCart.setFont(font2);
                processCart.setStyle("-fx-border-radius: 10;-fx-background-color: #B28961;-fx-border-color: brown;-fx-background-radius: 10;");
                processCart.setTextFill(Color.BLACK);
                processCart.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                    //call process cart method from media retnal manager
                    }
                });

                Button back = new Button("Back");
                back.setFont(font2);
                back.setStyle("-fx-border-radius: 10;-fx-background-color: #B28961;-fx-border-color: brown;-fx-background-radius: 10;");
                back.setTextFill(Color.BLACK);
                back.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        rentStage.close();
                    }
                });

                buttonPane.getChildren().addAll(addToCart,processCart,back);
                VBox vBox = new VBox(gridPane,buttonPane);
                vBox.setMinSize(300,200);
                //vBox.setBorder(border);
                vBox.setAlignment(Pos.CENTER);

                Scene scene = new Scene(vBox,600,600);
                rentStage.setMaximized(true);
                rentStage.setTitle("Rent Menu");
                rentStage.setScene(scene);
                rentStage.show();
            }
        });

        buttonPane.getChildren().addAll(customer,media,rent);
        buttonPane.setAlignment(Pos.CENTER_LEFT);

        BorderPane imageDescription = new BorderPane();
        imageDescription.setMaxSize(270,130);


        ImageView imageD = new ImageView("C:\\Users\\pro\\IdeaProjects\\MediaRentalProjectPhase2\\src\\main\\java\\com\\example\\mediarentalprojectphase2\\Content.jpg");
        imageD.setFitWidth(270);
        imageD.setFitHeight(130);
        imageDescription.getChildren().add(imageD);

        FlowPane namePane = new FlowPane();
        Text name = new Text("Rental Media System");
        name.setFont(font);
        namePane.setBorder(border);

        namePane.setMaxSize(name.getScaleX(),name.getScaleY());

        namePane.getChildren().add(name);

        VBox vBox2 = new VBox();
        vBox2.getChildren().addAll(imageD,namePane);

        vBox2.setAlignment(Pos.CENTER_LEFT);
        vBox2.setSpacing(20);

        FlowPane greaterPane = new FlowPane(buttonPane,vBox2);
        greaterPane.setMinSize(500,500);
        greaterPane.setAlignment(Pos.CENTER);
        greaterPane.setHgap(20);
        greaterPane.setVgap(20);
        primaryStage.setTitle("Media_Rental_Manager");
        Scene mainScene = new Scene(greaterPane,600,600);
        primaryStage.setScene(mainScene);
        primaryStage.setMaximized(true);
        primaryStage.show();

    }
}


