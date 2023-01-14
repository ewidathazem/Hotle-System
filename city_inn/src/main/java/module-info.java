module com.example.city_inn {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.city_inn to javafx.fxml;
    exports com.example.city_inn;
    exports model;
    opens model to javafx.fxml;
}