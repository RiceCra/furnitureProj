package com.example.furnitureproj;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    // Declare the screen containers
    private StackPane screen1;
    private StackPane screen2;
    private StackPane screen3;
    private StackPane mainContent;
    private Pane room;

    @Override
    public void start(Stage primaryStage) {
        // Create the screens
        screen1 = new StackPane();
        screen2 = new StackPane();
        screen3 = new StackPane();

        // Add content to each screen (this can be customized)

        //screen1.getChildren().add(new javafx.scene.control.Label("Your room"));
        screen2.getChildren().add(new javafx.scene.control.Label("Item Management functionality WIP"));
        screen3.getChildren().add(new javafx.scene.control.Label("A.I. Functionality WIP"));

        // Initialize with screen1 displayed
        mainContent = screen1;

        // Create buttons for navigation
        Button btnScreen1 = new Button("Your Room");
        Button btnScreen2 = new Button("Your Items");
        Button btnScreen3 = new Button("A.I. Assistant");

        // Layout for buttons (bottom of the window)
        HBox buttonLayout = new HBox(); // Buttons will be placed horizontally
        buttonLayout.getChildren().addAll(btnScreen1, btnScreen2, btnScreen3);

        // Set button actions to switch between screens
        btnScreen1.setOnAction(e -> {
            switchScreen(mainContent, screen1);
            //buttonLayout.toFront();
        });
        btnScreen2.setOnAction(e -> {
            switchScreen(mainContent, screen2);
            //buttonLayout.toFront();
        });
        btnScreen2.setOnAction(e -> {
            switchScreen(mainContent, screen3);
            //buttonLayout.toFront();
        });

        // Make each button take 1/3rd of the width of the window
        buttonLayout.widthProperty().addListener((obs, oldVal, newVal) -> {
            double buttonWidth = newVal.doubleValue() / 3;
            double buttonHeight = newVal.doubleValue() / 7;

            btnScreen1.setPrefWidth(buttonWidth);
            btnScreen1.setPrefHeight(buttonHeight);

            btnScreen2.setPrefWidth(buttonWidth);
            btnScreen2.setPrefHeight(buttonHeight);

            btnScreen3.setPrefWidth(buttonWidth);
            btnScreen3.setPrefHeight(buttonHeight);
        });

        // Add padding and alignment
        buttonLayout.setStyle("-fx-alignment: center; -fx-padding: 0px;");

        // Create the main layout with BorderPane
        BorderPane root = new BorderPane();
        root.setCenter(mainContent); // Show the initial screen
        root.setBottom(buttonLayout); // Buttons at the bottom

        // Create the scene and set the stage
        Scene scene = new Scene(root, 400, 750); // iPhone-like size
        primaryStage.setTitle("iPhone Aspect Ratio Window with Multiple Screens");
        primaryStage.setScene(scene);
        primaryStage.show();

        //The "room" is the parent pane
        room = new Pane();

        screen1.getChildren().add(room);
        makeDraggable(room, false);
        //drawing the on screen images
        makeContent1();
        drawRoom();
        room.getChildren().forEach(n -> makeDraggable(n, true));
        //make them all draggable
        //screen1.getChildren().forEach(n -> makeDraggable(n));
        System.out.print(screen1.getChildren());
        buttonLayout.toFront();

    }

    private void makeContent1() {
        // Screen 1 content

        //bed
        Rectangle rect = new spRectangle(7 * 30, 5 * 30, Color.GREY);

        //desk
        Rectangle rect2 = new spRectangle((int)(4.5 * 30), (int)(2.5 * 30), Color.BROWN);

        //cloths
        Rectangle rect3 = new spRectangle((int)(2 * 30), (int)(4 * 30), Color.GREEN);

        //chair
        Rectangle rect4 = new spRectangle((int)(2 * 30), (int)(2 * 30), Color.ORANGE);

        //computer monitor
        Rectangle rect5 = new spRectangle((int)(1.5 * 30), (int)(0.1 * 30), Color.BLACK);

        //computer
        Rectangle rect6 = new spRectangle((int)(2 * 30), (int)(0.5 * 30), Color.GREY);

        //computer keyboard
        Rectangle rect7 = new spRectangle((int)(2 * 30), (int)(2 * 30), Color.WHITE);

        //rect.setRotate(45);

        room.getChildren().add(rect);
        room.getChildren().add(rect2);
        room.getChildren().add(rect3);
        room.getChildren().add(rect4);
        room.getChildren().add(rect5);
        room.getChildren().add(rect6);
        room.getChildren().add(rect7);

    }

    private layoutNode createTestNodes() {
        layoutNode newNode1 = new layoutNode(4, "right", "wall");
        layoutNode newNode2 = new layoutNode(2.5, "up", "wall");
        layoutNode newNode3 = new layoutNode(6, "right", "wall");
        layoutNode newNode4 = new layoutNode(2.5, "down", "wall");
        layoutNode newNode5 = new layoutNode(2.5, "right", "wall");
        layoutNode newNode6 = new layoutNode(3, "down", "wall");
        layoutNode newNode7 = new layoutNode(0.2, "right", "wall");
        layoutNode newNode8 = new layoutNode(3, "up", "wall");
        layoutNode newNode9 = new layoutNode(5, "right", "wall");
        layoutNode newNode10 = new layoutNode(8, "down", "wall");
        layoutNode newNode11 = new layoutNode(5, "left", "wall");
        layoutNode newNode12 = new layoutNode(0.5, "up", "wall");
        layoutNode newNode13 = new layoutNode(0.2, "left", "wall");
        layoutNode newNode14 = new layoutNode(2.5, "down", "wall");
        layoutNode newNode15 = new layoutNode(12.5, "left", "wall");
        layoutNode newNode16 = new layoutNode(10, "up", "wall");

        newNode1.next = newNode2;
        newNode2.next = newNode3;
        newNode3.next = newNode4;
        newNode4.next = newNode5;
        newNode5.next = newNode6;
        newNode6.next = newNode7;
        newNode7.next = newNode8;
        newNode8.next = newNode9;
        newNode9.next = newNode10;
        newNode10.next = newNode11;
        newNode11.next = newNode12;
        newNode12.next = newNode13;
        newNode13.next = newNode14;
        newNode14.next = newNode15;
        newNode15.next = newNode15;
        newNode15.next = newNode16;

        return newNode1;
    }

    private void drawRoom() {
        layoutNode newNode = createTestNodes();

        int roomX = 50;
        int roomY = 50;

        Path path = new Path();
        path.getElements().add(new MoveTo(roomX, roomY)); // Starting at (50, 50)

        layoutNode curr = newNode;
        while (curr != null) {
            if (curr.getDirection().equals("left")) {
                roomX = roomX - (int)(curr.getLength()*30);
            } else if (curr.getDirection().equals("right")) {
                roomX = roomX + (int)(curr.getLength()*30);
            } else if (curr.getDirection().equals("up")) {
                roomY = roomY - (int)(curr.getLength()*30);
            } else {                        //down
                roomY = roomY + (int)(curr.getLength()*30);
            }
            path.getElements().add(new LineTo(roomX, roomY));
            curr = curr.next;
        }

        path.setStroke(Color.BLACK);
        path.setStrokeWidth(4);
        room.getChildren().add(path);
    }

    // Helper method to switch screens
    private void switchScreen(StackPane currentContent, StackPane newScreen) {
        BorderPane root = (BorderPane) currentContent.getParent();
        root.setCenter(newScreen);
        mainContent = newScreen;
    }

    private  double startX;
    private  double startY;

    private void makeDraggable (Node node, boolean item) {

        node.setOnMousePressed(e -> {
            if (e.getButton() == MouseButton.PRIMARY && item) {
                startX = e.getSceneX() - node.getTranslateX();
                startY = e.getSceneY() - node.getTranslateY();
            } else if (e.getButton() == MouseButton.SECONDARY && !item) {
                startX = e.getSceneX() - node.getTranslateX();
                startY = e.getSceneY() - node.getTranslateY();
            }

        });

        node.setOnMouseDragged(e -> {
            if (e.getButton() == MouseButton.PRIMARY && item) {
                node.setTranslateX(e.getSceneX() - startX);
                node.setTranslateY(e.getSceneY() - startY);
            } else if (e.getButton() == MouseButton.SECONDARY && !item) {
                node.setTranslateX(e.getSceneX() - startX);
                node.setTranslateY(e.getSceneY() - startY);
            }
        });

    }
    public static void main(String[] args) {
        launch();
    }
}