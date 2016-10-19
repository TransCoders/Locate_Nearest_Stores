package com.example.alex.mapcurrentlocation.Software;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

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




        
        return super.getView(position, convertView, parent);
    }
}
