package com.example.alex.mapcurrentlocation.Software;

import android.content.Context;
import android.support.v4.widget.TextViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.alex.mapcurrentlocation.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by James Nikolaidis on 10/19/2016.
 */
public class CustomAdapter extends ArrayAdapter {


    public CustomAdapter(Context context,String[] data ) {
        super(context, android.R.layout.simple_list_item_2, data);
    }




    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            View adapterView = layoutInflater.inflate(R.layout.print_protocol_layout,parent,false);
            String store = (String) getItem(position);
            TextView Store_view = (TextView)adapterView.findViewById(R.id.Stores);
            Store_view.setText(store);
            return adapterView;
    }
}
