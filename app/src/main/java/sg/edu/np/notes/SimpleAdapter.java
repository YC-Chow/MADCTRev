package sg.edu.np.notes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.security.PublicKey;
import java.util.ArrayList;

public class SimpleAdapter extends RecyclerView.Adapter<SimpleViewHolder>
{
    ArrayList<String> data;

    public SimpleAdapter(ArrayList<String> input){ data = input;}

    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.simplerecyclerview, parent, false);
        return new SimpleViewHolder(item);
    }

    public void onBindViewHolder(SimpleViewHolder holder, int position)
    {
        // individual data get from position
        String info = data.get(position);
        holder.text1.setText(info);
    }

    public int getItemCount() {return data.size();}
}
