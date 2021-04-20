package com.wolfie.checkingin;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.wolfie.checkingin.Db;
import com.wolfie.checkingin.R;

import java.util.List;

public class Dblist extends ArrayAdapter<Db> {
    private Activity context;
    private List<Db> dblist;

    public Dblist(Activity context,List<Db> dblist){
        super(context,R.layout.activity_history,dblist);
        this.context=context;
        this.dblist=dblist;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View listviewitem = inflater.inflate(R.layout.activity_history,null);
        TextView t1=listviewitem.findViewById(R.id.t1);
        TextView t2=listviewitem.findViewById(R.id.textView2);
        Db db=dblist.get(position);
        t1.setText(db.getdbtext());
        t2.setText(db.getdbdate());
        return listviewitem;
    }
}
