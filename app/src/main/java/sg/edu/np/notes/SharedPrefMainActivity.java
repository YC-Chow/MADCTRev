package sg.edu.np.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SharedPrefMainActivity extends AppCompatActivity {
    EditText newUsername, newPassword;
    Button backBtn, signupBtn;
    SharedPreferences sharedPreferences;

    public String GLOBAL_PREF = "myPrefs";
    public String MY_USERNAME = "myUsername";
    public String MY_PASSWORD = "myPassword";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_pref_main);
        newUsername = findViewById(R.id.createUsername);
        newPassword = findViewById(R.id.createPassword);
        backBtn = findViewById(R.id.backBtnSignup);
        signupBtn = findViewById(R.id.signupBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SharedPrefMainActivity.this, SharedPrefStartActivity.class);
                startActivity(intent);
                finish();
            }
        });

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = newUsername.getText().toString();
                String password = newPassword.getText().toString();
                if(username.equals("") || password.equals(""))
                {
                    Toast.makeText(SharedPrefMainActivity.this, "Please enter username and password!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    sharedPreferences = getSharedPreferences(GLOBAL_PREF, MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(MY_USERNAME, username);
                    editor.putString(MY_PASSWORD, password);
                    editor.apply();

                    Toast.makeText(SharedPrefMainActivity.this, "New User Created", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SharedPrefMainActivity.this, SharedPrefStartActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}