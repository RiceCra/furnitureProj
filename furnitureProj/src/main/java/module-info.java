module com.example.furnitureproj {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.furnitureproj to javafx.fxml;
    exports com.example.furnitureproj;
}