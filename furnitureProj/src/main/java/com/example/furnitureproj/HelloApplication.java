package com.example.furnitureproj;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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

    @Override
    public void start(Stage primaryStage) {
        // Create the screens
        screen1 = new StackPane();
        screen2 = new StackPane();
        screen3 = new StackPane();

        // Add content to each screen (this can be customized)
        screen1.getChildren().add(new javafx.scene.control.Label("Screen 1 Content"));
        screen2.getChildren().add(new javafx.scene.control.Label("Screen 2 Content"));
        screen3.getChildren().add(new javafx.scene.control.Label("Screen 3 Content"));

        // Initialize with screen1 displayed
        mainContent = screen1;

        // Create buttons for navigation
        Button btnScreen1 = new Button("Screen 1");
        Button btnScreen2 = new Button("Screen 2");
        Button btnScreen3 = new Button("Screen 3");

        // Set button actions to switch between screens
        btnScreen1.setOnAction(e -> switchScreen(mainContent, screen1));
        btnScreen2.setOnAction(e -> switchScreen(mainContent, screen2));
        btnScreen3.setOnAction(e -> switchScreen(mainContent, screen3));

        // Layout for buttons (bottom of the window)
        HBox buttonLayout = new HBox(); // Buttons will be placed horizontally
        buttonLayout.getChildren().addAll(btnScreen1, btnScreen2, btnScreen3);

        // Make each button take 1/3rd of the width of the window
        buttonLayout.widthProperty().addListener((obs, oldVal, newVal) -> {
            double buttonWidth = newVal.doubleValue() / 3;
            btnScreen1.setPrefWidth(buttonWidth);
            btnScreen2.setPrefWidth(buttonWidth);
            btnScreen3.setPrefWidth(buttonWidth);
        });

        // Add padding and alignment
        buttonLayout.setStyle("-fx-alignment: center; -fx-padding: 10px;");

        // Create the main layout with BorderPane
        BorderPane root = new BorderPane();
        root.setCenter(mainContent); // Show the initial screen
        root.setBottom(buttonLayout); // Buttons at the bottom

        // Create the scene and set the stage
        Scene scene = new Scene(root, 390, 844); // iPhone-like size
        primaryStage.setTitle("iPhone Aspect Ratio Window with Multiple Screens");
        primaryStage.setScene(scene);
        primaryStage.show();

        makeContent1();
        makeContent2();
        screen1.getChildren().forEach(n -> makeDraggable(n));
    }

    private void makeContent1() {
        // Screen 1 content
        Rectangle rect = new spRectangle(100, 100, Color.YELLOW);
        Rectangle rect2 = new spRectangle(150, 150, Color.BLUE);
        //rect.setRotate(45);
        rect.setTranslateX(50);
        rect.setTranslateY(50);
        rect.setTranslateX(60);
        rect.setTranslateY(60);

        screen1.getChildren().add(rect);
        screen1.getChildren().add(rect2);

    }

    private void makeContent2() {
        layoutNode newNode = new layoutNode(10, "left", "wall");
        Path path = new Path();
        // Move to the starting point (0, 0)
        path.getElements().add(new MoveTo(50, 50)); // Starting at (50, 50)

        // Draw the first leg of the 90-degree angle (horizontal line)
        path.getElements().add(new LineTo(150, 50)); // To the right (150, 50)

        // Draw the second leg of the 90-degree angle (vertical line)
        path.getElements().add(new LineTo(150, 150)); // Down (150, 150)

        // Set stroke color and width
        path.setStroke(Color.BLACK);
        path.setStrokeWidth(3);
        screen1.getChildren().add(path);

    }

    // Helper method to switch screens
    private void switchScreen(StackPane currentContent, StackPane newScreen) {
        BorderPane root = (BorderPane) currentContent.getParent();
        root.setCenter(newScreen);
        mainContent = newScreen;
    }

    private  double startX;
    private  double startY;

    private void makeDraggable (Node node) {

        node.setOnMousePressed(e -> {
            startX = e.getSceneX() - node.getTranslateX();
            startY = e.getSceneY() - node.getTranslateY();
        });

        node.setOnMouseDragged(e -> {
            node.setTranslateX(e.getSceneX() - startX);
            node.setTranslateY(e.getSceneY() - startY);
        });

    }


    public static void main(String[] args) {
        launch();
    }
}