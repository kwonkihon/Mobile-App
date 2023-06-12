package com.example.androidproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Hotel> hotelList;
    private HotelListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 호텔 데이터 생성
        hotelList = createHotelList();

        // 호텔 목록을 표시하는 ListView 설정
        ListView hotelListView = findViewById(R.id.hotelListView);
        adapter = new HotelListAdapter(this, hotelList);
        hotelListView.setAdapter(adapter);

        // 호텔 목록에서 호텔을 클릭하면 상세 정보 액티비티로 이동
        hotelListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Hotel selectedHotel = hotelList.get(position);
                Intent intent = new Intent(MainActivity.this, HotelDetailActivity.class);
                intent.putExtra("hotel", selectedHotel);
                startActivity(intent);
            }
        });
    }

    private List<Hotel> createHotelList() {
        List<Hotel> hotels = new ArrayList<>();

        // 호텔 데이터 추가
        hotels.add(new Hotel("부산 롯데호텔", "https://www.lottehotel.com/content/dam/lotte-hotel/lotte/busan/accommodation/club-floor/club-deluxe-room/180829-24-2000-acc-busan-hotel.jpg.thumb.1440.1440.jpg", "주소 : 부산 부산진구 가야대로 772", "연락처 : 051-810-1000","감각적인 라이프 스타일과 모던하고 세련된 스타일로 리노베이션 된 객실과 사계절 온수풀로 즐기는 야외수영장과 풀카페&바, 다양한 레스토랑에서 여행을 즐기십시오.","https://www.lottehotel.com/busan-hotel/ko.html",35.156766,129.0558));
        hotels.add(new Hotel("서울 신라호텔", "https://www.shilla.net/images/contents/accmo/ACCMO_INDEX/R000000013SJ_KR.jpg", "주소 : 서울 중구 동호로 249번지", "연락처 : 02-2233-3131","한국의 전통미와 현대적 감각을 겸비하고 있는 세계 속의 명문호텔 서울신라호텔은 세계 최고의 럭셔리 어번 라이프스타일 호텔로 고객들에게 최고급 Hospitality 서비스를 제공합니다.","https://www.shilla.net/seoul/index.do",37.5559034,127.0052509));
        hotels.add(new Hotel("메이필드 호텔", "https://cf.bstatic.com/xdata/images/hotel/max1024x768/335687762.jpg?k=81f6a7d0f1edc96454155d13ad3c2e750a9fe75542ae4401ddabe61aa7653166&o=&hp=1", "주소 : 서울특별시 강서구 방화대로 94 메이필드호텔", "연락처 : 02-2660-9000","일상에서 휴식을 찾는 것은 어려운 일이지만 이 곳에서는 나만을 위한 온전한 휴식을 어렵지 않게 찾으실 수 있습니다.","https://www.mayfield.co.kr/main/",37.5475247, 126.8187885));
        hotels.add(new Hotel("해비치호텔앤드리조트", "https://api.cdn.visitjeju.net/photomng/imgpath/201804/30/b68dc52e-6e1a-4eb2-9797-e84f03bc14c0.jpg","주소 : 제주특별자치도 서귀포시 표선면 민속해안로 537","연락처 : 064-780-8000","가장 아름다운 곳에서 시작되는 당신의 특별한 순간을 완성하기 위해 해비치는 남들이 가지 않은 길을 먼저 걷겠습니다.","https://www.haevichi.com/",33.323125,126.8447251));
        hotels.add(new Hotel("아난티 힐튼 부산", "https://cf.bstatic.com/xdata/images/hotel/max1024x768/140025306.jpg?k=98f627211c7a60aee45d0a500845974586e6cd00d4dab99cfe2983f1b85c42f6&o=&hp=1","주소 : 부산광역시 기장군 기장해안로 268-32","051-509-1111","너른 잔디와 푸른 나무, 시원한 바다, 그늘 아래 휴식을 취하는 사람들, 이 모든 것이 가능한 아름다운 호텔에서 자유로운 시간을 누려보세요.","https://ananti.kr/",35.1976638,129.2280861));
        hotels.add(new Hotel("포시즌스 호텔 서울", "https://www.hotelscombined.co.kr/rimg/himg/3b/7d/b0/leonardo-2009719-_Four_Seasons_Hotel_Seoul__Ambassador_Suite_Living_O-754993.jpg?width=1366&height=768&crop=true","주소 : 서울특별시 종로구 새문안로 97","연락처 : 02-6388-5000","자연광이 가득 들어오는 곳에서 한눈에 펼쳐지는 도심 전망과 함께, 여유로운 거실 공간, 스마트하게 디자인된 이태리 대리석 욕실을 갖추어 커플을 위한 평화로운 휴식을 선사합니다.","https://www.fourseasons.com/",37.570707,126.975412));


        return hotels;
    }
}
