package sg.edu.np.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    EditText etUsername, etPassword;
    Button loginBtn;
    TextView newUser;
    DBHandler dbHandler = new DBHandler(this, null, null, 1);


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUsername = findViewById(R.id.userUsername);
        etPassword = findViewById(R.id.userPassword);
        loginBtn = findViewById(R.id.loginBtn);
        newUser = findViewById(R.id.newUserText);

        newUser.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
                return false;
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                if (username == "" || password == "")
                {
                    Toast.makeText(MainActivity.this, "Please enter username and password!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    UserData userQuery = dbHandler.findUser(username);
                    if (userQuery == null)
                    {
                        Toast.makeText(MainActivity.this, "wrong username or password", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        if(username.equals(userQuery.getUsername()) && password.equals(userQuery.getPassword()))
                        {
                            Toast.makeText(MainActivity.this,"login successful", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                            startActivity(intent);
                            finish();
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this, "wrong username or password", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });

    }
}