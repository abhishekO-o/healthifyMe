package com.wolfie.checkingin;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    String mood_rcv[], energy_level_rcv[], activity_now_rcv[], date_rcv[], time_rcv[];
    Context ct;
    public MyAdapter(Context context, String[] m1, String[] m2, String[] m3, String[] m4, String[] m5){
        ct = context;
        mood_rcv = m1;
        energy_level_rcv = m2;
        activity_now_rcv = m3;
        date_rcv = m4;
        time_rcv = m5;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ct);
        View view = inflater.inflate(R.layout.my_layout_file, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.date.setText(date_rcv[position]);
        holder.time.setText(time_rcv[position]);
        holder.activity_now.setText(activity_now_rcv[position]);
        Log.d("mood", mood_rcv[position]);
            switch (mood_rcv[position]){
                case "rad":
                    holder.mood.setImageResource(R.drawable.rad);
                    break;
                case "good":
                    holder.mood.setImageResource(R.drawable.good);
                    break;
                case "meh":
                    holder.mood.setImageResource(R.drawable.meh);
                    break;
                case "bad":
                    holder.mood.setImageResource(R.drawable.bad);
                    break;
            }
    }

    @Override
    public int getItemCount() {
        return mood_rcv.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView date, time, activity_now;
        ImageView mood;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.textView21);
            time = itemView.findViewById(R.id.textView22);
            activity_now = itemView.findViewById(R.id.textView23);
            mood = itemView.findViewById(R.id.mood_view);
        }
    }
}
