package sg.edu.np.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CountDownStartActivity extends AppCompatActivity
{
    Button backBtn, startBtn;
    EditText input;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_down_start);
        backBtn = findViewById(R.id.backBtnCD);
        startBtn = findViewById(R.id.startBtnCD);
        input = findViewById(R.id.userInput);

        backBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(CountDownStartActivity.this, MenuActivity.class);
                startActivity(intent);
                finish();
            }
        });

        startBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String userInput = input.getText().toString();
                if (userInput.matches("")){
                    Toast.makeText(CountDownStartActivity.this, "Please enter a duration in sec!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(CountDownStartActivity.this , CountDownMainActivity.class);
                    intent.putExtra("duration" , userInput);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}