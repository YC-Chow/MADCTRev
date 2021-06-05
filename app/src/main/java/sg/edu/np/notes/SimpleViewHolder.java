package sg.edu.np.notes;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class SimpleViewHolder extends RecyclerView.ViewHolder
{
    ImageView image1;
    TextView text1;
    public SimpleViewHolder(View itemView){
        super(itemView);
        text1 = itemView.findViewById(R.id.textView);
        image1 = itemView.findViewById(R.id.imageView);
    }
}
