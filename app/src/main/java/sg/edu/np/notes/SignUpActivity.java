package sg.edu.np.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    EditText newUsername, newPassword;
    Button backBtn, signupBtn;
    DBHandler dbHandler = new DBHandler(this, null, null, 1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        newUsername = findViewById(R.id.createUsername);
        newPassword = findViewById(R.id.createPassword);
        backBtn = findViewById(R.id.backBtnSignup);
        signupBtn = findViewById(R.id.signupBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (newUsername.getText().toString() == "" || newPassword.getText().toString() == "")
                {
                    Toast.makeText(SignUpActivity.this, "Please enter a username and password!",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    UserData userQuery = dbHandler.findUser(newUsername.getText().toString());
                    if (userQuery == null)
                    {
                        UserData newUser = new UserData(newUsername.getText().toString(), newPassword.getText().toString());
                        dbHandler.addUser(newUser);
                        Toast.makeText(SignUpActivity.this,"New user created!",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    else
                    {
                        Toast.makeText(SignUpActivity.this, "User already exists!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}