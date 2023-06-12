package com.example.androidproject;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class HotelDetailActivity extends AppCompatActivity {

    private ImageView hotelImageView;
    private TextView hotelNameTextView;
    private TextView hotelDescriptionTextView;
    private TextView hotelFacilitiesTextView;
    private TextView hotelIntroduceTextView;
    private TextView hotelTelTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_datail);

        // 인텐트에서 호텔 데이터 받아오기
        Hotel selectedHotel = getIntent().getParcelableExtra("hotel");

        // SupportMapFragment를 가져와서 지도를 비동기적으로 로드합니다
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapFragment);
        if (mapFragment == null) {
            mapFragment = SupportMapFragment.newInstance();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.mapFragment, mapFragment).commit();
        }

        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                // 선택한 호텔 객체에서 위도와 경도 값을 가져옵니다
                double latitude = selectedHotel.getLatitude();
                double longitude = selectedHotel.getLongitude();

                // 위도와 경도로 LatLng 객체를 생성합니다
                LatLng hotelLocation = new LatLng(latitude, longitude);

                // 지도의 표시 유형을 설정합니다
                googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

                // 카메라를 호텔의 위치로 이동하고 확대합니다
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(hotelLocation, 15));

                // 호텔의 위치에 마커를 추가합니다
                googleMap.addMarker(new MarkerOptions().position(hotelLocation).title(selectedHotel.getName()));
            }
        });

        // 뷰 초기화
        hotelImageView = findViewById(R.id.hotelImageView);
        hotelNameTextView = findViewById(R.id.hotelNameTextView);
        hotelDescriptionTextView = findViewById(R.id.hotelDescriptionTextView);
        hotelFacilitiesTextView = findViewById(R.id.hotelFacilitiesTextView);
        hotelIntroduceTextView = findViewById(R.id.hotelIntroduceTextView);
        hotelTelTextView = findViewById(R.id.hotelTelTextView);


        // 호텔 정보 표시
        if (selectedHotel != null) {
            Glide.with(this).load(selectedHotel.getImageUrl()).into(hotelImageView);
            hotelNameTextView.setText(selectedHotel.getName());
            hotelDescriptionTextView.setText(selectedHotel.getDescription());
            hotelFacilitiesTextView.setText(selectedHotel.getFacilities());
            hotelIntroduceTextView.setText(selectedHotel.getIntroduce());
            hotelTelTextView.setText(selectedHotel.getTel());

            Linkify.addLinks(hotelTelTextView, Linkify.WEB_URLS);
            hotelTelTextView.setMovementMethod(LinkMovementMethod.getInstance());

        }
    }
}
