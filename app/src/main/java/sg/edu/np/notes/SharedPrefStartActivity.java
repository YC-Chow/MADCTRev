package sg.edu.np.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SharedPrefStartActivity extends AppCompatActivity {
    EditText username, password;
    Button backBtn, loginBtn;
    TextView newUser;
    SharedPreferences sharedPreferences;

    public String GLOBAL_PREF = "myPrefs";
    public String MY_USERNAME = "myUsername";
    public String MY_PASSWORD = "myPassword";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_pref_start);
        username = findViewById(R.id.userUsername);
        password = findViewById(R.id.userPassword);
        backBtn = findViewById(R.id.backBtnPref);
        loginBtn = findViewById(R.id.loginBtn);
        newUser = findViewById(R.id.newUserText);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SharedPrefStartActivity.this, MenuActivity.class);
                startActivity(intent);
                finish();
            }
        });

        newUser.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent intent = new Intent(SharedPrefStartActivity.this, SharedPrefMainActivity.class);
                startActivity(intent);
                finish();
                return false;
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userUsername = username.getText().toString();
                String userPassword = password.getText().toString();

                if(isValid(userUsername, userPassword))
                {
                    Toast.makeText(SharedPrefStartActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SharedPrefStartActivity.this, MenuActivity.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Toast.makeText(SharedPrefStartActivity.this, "Incorrect username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
    public boolean isValid(String username, String password)
    {
        sharedPreferences = getSharedPreferences(GLOBAL_PREF, MODE_PRIVATE);
        String prefUsername = sharedPreferences.getString(MY_USERNAME, "");
        String prefPassword = sharedPreferences.getString(MY_PASSWORD, "");

        if (prefUsername.equals(username) && prefPassword.equals(password))
        {
            return true;
        }
        return false;
    }
}