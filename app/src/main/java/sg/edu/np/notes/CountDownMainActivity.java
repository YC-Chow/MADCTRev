package sg.edu.np.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CountDownMainActivity extends AppCompatActivity
{
    TextView time;
    Button resumeBtn, pauseBtn, backBtn, newBtn, restartBtn, startBtn;
    int duration , timeLeft;
    CountDownTimer cdt;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_down_main);
        
        startBtn = findViewById(R.id.startBtnCD2);
        resumeBtn = findViewById(R.id.resumeBtn);
        pauseBtn = findViewById(R.id.pauseBtn);
        newBtn = findViewById(R.id.newBtn);
        backBtn = findViewById(R.id.backBtnCD2);
        time = findViewById(R.id.timeLeft);
        restartBtn = findViewById(R.id.restartBtn);
        
        duration = Integer.parseInt(getIntent().getStringExtra("duration")) * 1000;
        timeLeft = duration;

        time.setText("" + duration/1000);
        resumeBtn.setEnabled(false);
        pauseBtn.setEnabled(false);


        backBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(CountDownMainActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        newBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(CountDownMainActivity.this, CountDownStartActivity.class);
                startActivity(intent);
                finish();
            }
        });

        startBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startBtn.setEnabled(false);
                pauseBtn.setEnabled(true);
                startTimer(timeLeft);
            }
        });

        pauseBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                cdt.cancel();
                pauseBtn.setEnabled(false);
                resumeBtn.setEnabled(true);
            }
        });

        resumeBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startTimer(timeLeft);
                resumeBtn.setEnabled(false);
                pauseBtn.setEnabled(true);
            }
        });

        restartBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                cdt.cancel();
                timeLeft = duration;
                resumeBtn.setEnabled(false);
                pauseBtn.setEnabled(false);
                startBtn.setEnabled(true);
                time.setText("" + duration/1000);
            }
        });
    }

    private void startTimer(int duration){
        cdt = new CountDownTimer(duration, 1000)
        {
            @Override
            public void onTick(long millisUntilFinished)
            {
                time.setText("" + millisUntilFinished/1000);
                timeLeft = (int) millisUntilFinished;
            }

            @Override
            public void onFinish()
            {
                Toast.makeText(CountDownMainActivity.this, "Time run out", Toast.LENGTH_SHORT).show();
                resumeBtn.setEnabled(false);
                pauseBtn.setEnabled(false);
                startBtn.setEnabled(true);

            }
        };
        cdt.start();
    }
}