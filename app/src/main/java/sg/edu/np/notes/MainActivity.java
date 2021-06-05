package sg.edu.np.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    TextView toastText = findViewById(R.id.toastText);
    Button toastBtn = findViewById(R.id.toastBtn);
    Button recyclerBtn = findViewById(R.id.recyclerBtn);
    Button cdBtn = findViewById(R.id.cdtBtn);


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //random number generator
        int ranNum = ranInt(10000);

        toastBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(MainActivity.this, "The ranNum is " + ranNum, Toast.LENGTH_SHORT).show();
            }
        });

        toastText.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                Toast.makeText(MainActivity.this, "The ranNum is " + ranNum, Toast.LENGTH_SHORT).show();
                return false;
            }
        });


    }

    @Override
    protected void onPause(){
        super.onPause();
        finish();
    }
    
    private int ranInt(int limit)
    {
        Random random = new Random();
        int ranNum = random.nextInt(limit);
        return ranNum;
    }
}