package com.example.androidproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;


import java.util.List;

public class HotelListAdapter extends BaseAdapter {
    private Context context;
    private List<Hotel> hotelList;

    public HotelListAdapter(Context context, List<Hotel> hotelList) {
        this.context = context;
        this.hotelList = hotelList;
    }

    @Override
    public int getCount() {
        return hotelList.size();
    }

    @Override
    public Object getItem(int position) {
        return hotelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.hotel_item, parent, false);
            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.hotelImage);
            holder.nameTextView = convertView.findViewById(R.id.hotelName);
            holder.descriptionTextView = convertView.findViewById(R.id.hotelDescription);
            holder.facilitiesTextView = convertView.findViewById(R.id.hotelFacilities);
            holder.introduceTextView = convertView.findViewById(R.id.hotelIntroduce);
            holder.telTextView = convertView.findViewById(R.id.hotelTel);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Hotel hotel = hotelList.get(position);

        holder.nameTextView.setText(hotel.getName());
        holder.descriptionTextView.setText(hotel.getDescription());
        holder.facilitiesTextView.setText(hotel.getFacilities());
        holder.introduceTextView.setText(hotel.getIntroduce());
        holder.telTextView.setText(hotel.getTel());

        // 호텔 이미지를 Picasso 라이브러리를 사용하여 로드 및 표시
        Picasso.get().load(hotel.getImageUrl()).into(holder.imageView);

        return convertView;
    }

    private static class ViewHolder {
        ImageView imageView;
        TextView nameTextView;
        TextView descriptionTextView;
        TextView facilitiesTextView;
        TextView introduceTextView;
        TextView telTextView;
    }
}
