package com.ysc.restfullapitest;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class IPAddressAdapter extends ArrayAdapter<Address> {
    private static class ViewHolder {
        TextView ip;
        TextView province;
        TextView city;
    }

    public IPAddressAdapter(Context context, ArrayList<Address> notes) {
        super(context, R.layout.item_address, notes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Address address = getItem(position);
        ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();

            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_address, parent, false);

            viewHolder.ip = (TextView) convertView.findViewById(R.id.value_address_ip);
            viewHolder.province = (TextView) convertView.findViewById(R.id.label_address_province);
            //viewHolder.city = (TextView) convertView.findViewById(R.id.);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.ip.setText(address.getIpAddress());
        viewHolder.province.setText(address.getProvince());
        //viewHolder.city.setText(address.getCity());

        return convertView;
    }
}