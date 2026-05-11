module co.edu.uniquindio.poo.techparkuq {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.poo.techparkuq to javafx.fxml;
    exports co.edu.uniquindio.poo.techparkuq;
    exports co.edu.uniquindio.poo.techparkuq.view;
    opens co.edu.uniquindio.poo.techparkuq.view to javafx.fxml;
}