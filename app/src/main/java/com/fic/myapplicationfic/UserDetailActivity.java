package com.fic.myapplicationfic;
import android.widget.TextView;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class UserDetailActivity extends AppCompatActivity {
       private TextView idClientDetail;
    private TextView nameDetail;
    private TextView telClientDetail;
    private TextView emailClientDetail;
    private TextView birthdateClientDetail;
    private TextView typeMemberClient;
    private TextView timeMembership;
    private TextView typeRoutine;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_user_detail);
            // Inicializar las vistas
            idClientDetail = findViewById(R.id.idClientDetail);
            nameDetail = findViewById(R.id.nameDetail);
            telClientDetail = findViewById(R.id.TelClientDetail);
            emailClientDetail = findViewById(R.id.emailClientDetail);
            birthdateClientDetail = findViewById(R.id.birthdateClientDetail);
            typeMemberClient = findViewById(R.id.typeMeberClient);
            timeMembership = findViewById(R.id.timeMebership);
            typeRoutine = findViewById(R.id.typerutine);

            // Simulación de datos (puedes recibir estos datos desde un intent o API)
            String id = "12345";
            String name = "Juan Pérez";
            String phone = "555-1234";
            String email = "juan.perez@example.com";
            String birthdate = "01/01/1990";
            String membership = "Premium";
            String membershipExpiry = "31/12/2024";
            String routineType = "Fuerza";

            // Asignar datos a las vistas
            idClientDetail.setText("Tu ID: " + id);
            nameDetail.setText("Nombre: " + name);
            telClientDetail.setText("Número Telefónico: " + phone);
            emailClientDetail.setText("Correo Electrónico: " + email);
            birthdateClientDetail.setText("Cumpleaños: " + birthdate);
            typeMemberClient.setText("Membresía: " + membership);
            timeMembership.setText("Vence el: " + membershipExpiry);
            typeRoutine.setText("Tipo de Entrenamiento: " + routineType);
    }
}