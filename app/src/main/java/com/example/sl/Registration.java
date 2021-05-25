package com.example.sl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sl.database.UserDao;
import com.example.sl.database.UserDatabase;
import com.example.sl.model.UserEntity;

public class Registration extends AppCompatActivity {

    EditText userName, password, name, firstname, mail;
    Button register, login;
    private String specialcharacter = "~#^|$%&*!";
    private String upperCase = "(.*[A-Z].*)";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        name = findViewById(R.id.name);
        firstname = findViewById(R.id.firstname);
        mail = findViewById(R.id.emailId);
        userName = findViewById(R.id.userId);
        password = findViewById(R.id.password);
        register = findViewById(R.id.register);
        login = findViewById(R.id.login);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UserEntity userEntity =  new UserEntity();
                userEntity.setName(name.getText().toString());
                userEntity.setFirstname(firstname.getText().toString());
                userEntity.setEmail(mail.getText().toString());
                userEntity.setUserId(userName.getText().toString());
                userEntity.setPassword(password.getText().toString());

                if (name.getText().toString().isEmpty() || firstname.getText().toString().isEmpty() || mail.getText().toString().isEmpty() || userName.getText().toString().isEmpty() || password.getText().toString().isEmpty() ){
                    Toast.makeText(getApplicationContext(), "Il faut remplir tous les champs !", Toast.LENGTH_SHORT).show();
                }else if (password.getText().toString().contains(specialcharacter) && password.getText().toString().contains(upperCase) && password.getText().toString().length() >6 ){
                    Toast.makeText(getApplicationContext(), "Mot de passe fort", Toast.LENGTH_SHORT).show();
                }else{
                    UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                    UserDao userDao = userDatabase.userDao();
                    new Thread(new Runnable() {

                        @Override
                        public void run() {
                            userDao.registerUsers(userEntity);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(), "Utilisateur créer", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }).start();
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Registration.this, Login.class));
            }
        });
    }

    private Boolean validateInput(UserEntity userEntity){
        if  (userEntity.getName().isEmpty() ||
                userEntity.getPassword().isEmpty() ||
                userEntity.getName().isEmpty()){
            return false;
        }
        return true;
    }
}