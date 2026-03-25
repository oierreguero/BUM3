module eus.ehu {
    requires transitive javafx.controls;
    requires transitive javafx.fxml;
    requires com.google.gson;
    requires okhttp3;
    opens eus.ehu to javafx.fxml, com.google.gson, okhttp3;
    exports eus.ehu;
}
