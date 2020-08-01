package com.application.tuanlv.danhbadienthoai;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ContectAdapter extends BaseAdapter {
    Context context;
    ArrayList<ContactModel> listContacts;
    LayoutInflater inflater;

    public ContectAdapter(Context context, ArrayList<ContactModel> listContacts) {
        this.context = context;
        this.listContacts = listContacts;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return listContacts.size();
    }

    @Override
    public Object getItem(int position) {
        return listContacts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null) {
            convertView = inflater.inflate(R.layout.contact_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.imgAvatar = convertView.findViewById(R.id.avatar_item);
            viewHolder.tvName = convertView.findViewById(R.id.tvName);
            viewHolder.tvPhoneNumber = convertView.findViewById(R.id.tvNumber);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tvName.setText(listContacts.get(position).getName());
        viewHolder.tvPhoneNumber.setText(listContacts.get(position).getNumber());
        viewHolder.imgAvatar.setImageBitmap(listContacts.get(position).getAvatar());
        return convertView;
    }
    class ViewHolder {
        TextView tvName;
        TextView tvPhoneNumber;
        ImageView imgAvatar;
    }
}
