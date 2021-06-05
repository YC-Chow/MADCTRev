package sg.edu.np.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity
{
    Button backBtn;
    ArrayList<String> stringList;
    // needs a array list for adapter

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        backBtn = findViewById(R.id.backBtnRV);
        stringList = new ArrayList<>();
        //populate array list
        for (int i = 0; i < 100; i ++){
            stringList.add(String.valueOf(i));
        }

        backBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(RecyclerViewActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        SimpleAdapter adapter = new SimpleAdapter(stringList);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }


    @Override
    protected void onPause()
    {
        super.onPause();
        finish();
    }
}