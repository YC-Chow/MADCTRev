package sg.edu.np.notes;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MenuActivity extends AppCompatActivity
{
    TextView toastText;
    Button toastBtn;
    Button recyclerBtn;
    Button cdBtn;
    Button signOutBtn;
    Button alertBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        toastText = findViewById(R.id.toastText);
        toastBtn = findViewById(R.id.toastButton);
        recyclerBtn = findViewById(R.id.recyclerBtn);
        cdBtn = findViewById(R.id.cdtBtn);
        signOutBtn = findViewById(R.id.signOutBtn);
        alertBtn = findViewById(R.id.alertBtn);

        //random number generator
        int ranNum = ranInt(10000);
        toastBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MenuActivity.this, "The ranNum is " + ranNum, Toast.LENGTH_SHORT).show();
            }
        });

        toastText.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                Toast.makeText(MenuActivity.this, "The ranNum is " + ranNum, Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        recyclerBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MenuActivity.this, RecyclerViewActivity.class);
                startActivity(intent);
                finish();
            }
        });

        alertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert();
            }
        });

        cdBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MenuActivity.this, CountDownStartActivity.class);
                startActivity(intent);
                finish();
            }
        });

        signOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MenuActivity.this, "Sign out successfully!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MenuActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private int ranInt(int limit)
    {
        Random random = new Random();
        int ranNum = random.nextInt(limit);
        return ranNum;
    }

    private void alert()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Alert Dialog");
        builder.setMessage("Press yes to go signout");
        builder.setCancelable(false);
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MenuActivity.this, "Sign out successfully!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MenuActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        builder.setNegativeButton("No", null);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}