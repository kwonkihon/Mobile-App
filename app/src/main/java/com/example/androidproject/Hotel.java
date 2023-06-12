package com.example.androidproject;

import android.os.Parcel;
import android.os.Parcelable;

public class Hotel implements Parcelable {
    private String name;
    private String imageUrl;
    private String description;
    private String facilities;
    private String introduce;
    private String tel;
    private double latitude;
    private double longitude;


    public Hotel(String name, String imageUrl, String description, String facilities, String introduce, String tel, double latitude, double longitude) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.description = description;
        this.facilities = facilities;
        this.introduce = introduce;
        this.tel = tel;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    protected Hotel(Parcel in) {
        name = in.readString();
        imageUrl = in.readString();
        description = in.readString();
        facilities = in.readString();
        introduce = in.readString();
        tel = in.readString();
        latitude = in.readDouble();
        longitude = in.readDouble();
    }

    public static final Creator<Hotel> CREATOR = new Creator<Hotel>() {
        @Override
        public Hotel createFromParcel(Parcel in) {
            return new Hotel(in);
        }

        @Override
        public Hotel[] newArray(int size) {
            return new Hotel[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public String getFacilities() {
        return facilities;
    }

    public String getIntroduce(){
        return introduce;
    }

    public String getTel(){
        return tel;
    }
    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(imageUrl);
        dest.writeString(description);
        dest.writeString(facilities);
        dest.writeString(introduce);
        dest.writeString(tel);
        dest.writeDouble(latitude);
        dest.writeDouble(longitude);
    }
}
