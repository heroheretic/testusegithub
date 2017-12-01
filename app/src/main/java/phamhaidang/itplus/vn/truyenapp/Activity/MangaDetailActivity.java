package phamhaidang.itplus.vn.truyenapp.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;
import com.squareup.picasso.Picasso;
import phamhaidang.itplus.vn.truyenapp.FakeModel.FakeData;
import phamhaidang.itplus.vn.truyenapp.FakeModel.Manga;
import phamhaidang.itplus.vn.truyenapp.Fragment.ChapTabsFragment;
import phamhaidang.itplus.vn.truyenapp.Fragment.Info_tabdetailmanga_fragment;
import phamhaidang.itplus.vn.truyenapp.R;

import java.sql.Date;

public class MangaDetailActivity extends AppCompatActivity {
    Manga info;
    ImageView img_avatar_detailmanga;
    TextView txttitle_detailmangatoolbar, txt_name_detailmanga, txt_author_detailmanga, txt_status_detailmanga;
    RatingBar ratingbar_detailmanga;
    Button tableft_detailmanga, tabright_detailmanga;
    ImageButton btback_detailmanga;
    Boolean tab_info_selected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manga_detail);
        InitView();
        BindData();
        InitEvent();
        Tab_info_selected();
    }

    private void InitEvent() {
        btback_detailmanga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Tab_select_listenter();
    }

    private void Tab_select_listenter() {
        tableft_detailmanga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tab_info_selected();
            }
        });
        tabright_detailmanga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tab_Chap_selected();
            }
        });
    }

    private void Tab_info_selected() {
        if (info == null) return;
        Bundle bundle = new Bundle();
        String Gerne = "";
        for (String item : info.getGenre()) {
            Gerne += item + ",";
        }
        if (!tab_info_selected) {
            tableft_detailmanga.setTextColor(Color.BLACK);
            tableft_detailmanga.setBackgroundColor(Color.WHITE);
            tabright_detailmanga.setTextColor(Color.WHITE);
            tabright_detailmanga.setBackground(getDrawable(R.drawable.tabright_mangadetail));
            getSupportFragmentManager().beginTransaction().replace(R.id.Content_Tabdetailmanga, Info_tabdetailmanga_fragment.newInstance(Gerne, info.getDescription())).commit();
            tab_info_selected = !tab_info_selected;
        }
    }

    private void Tab_Chap_selected() {
        if (tab_info_selected) {

            tabright_detailmanga.setTextColor(Color.BLACK);
            tabright_detailmanga.setBackgroundColor(Color.WHITE);
            tableft_detailmanga.setTextColor(Color.WHITE);
            tableft_detailmanga.setBackground(getDrawable(R.drawable.tableft_mangadetail));
            tab_info_selected = !tab_info_selected;
            getSupportFragmentManager().beginTransaction().replace(R.id.Content_Tabdetailmanga, ChapTabsFragment.newInstance(FakeData.chaps,info.getName())).commit();
        }
    }

    private void BindData() {
        GetmangaInfo();
        if (info == null) return;
        Date date=info.getPubDate();
        String pubdate=String.valueOf(date.getDay())+"/"+String.valueOf(date.getMonth())+"/"+String.valueOf(date.getYear());
        txttitle_detailmangatoolbar.setText(info.getName());
        txt_name_detailmanga.setText(info.getName());
        txt_author_detailmanga.setText("Tác Giả: Nobita");
        txt_status_detailmanga.setText("Trạng Thái: " + info.getStatus());
        ratingbar_detailmanga.setRating(Float.valueOf(info.getRate().toString()));
        Picasso.with(getApplicationContext()).load(info.getAvatar()).resize(200,300).into(img_avatar_detailmanga);
    }

    private void GetmangaInfo() {
        Manga temp = (Manga) getIntent().getSerializableExtra("Mangadetail");
        if (temp == null) return;
        info = temp;
    }

    private void InitView() {
        img_avatar_detailmanga = (ImageView) findViewById(R.id.img_avatar_detailmanga);
        txt_author_detailmanga = (TextView) findViewById(R.id.txt_author_detailmanga);
        txttitle_detailmangatoolbar = (TextView) findViewById(R.id.txttitle_detailmangatoolbar);
        txt_name_detailmanga = (TextView) findViewById(R.id.txt_name_detailmanga);
        txt_status_detailmanga = (TextView) findViewById(R.id.txt_status_detailmanga);
        ratingbar_detailmanga = (RatingBar) findViewById(R.id.ratingbar_detailmanga);
        tableft_detailmanga = (Button) findViewById(R.id.tableft_detailmanga);
        tabright_detailmanga = (Button) findViewById(R.id.tabright_detailmanga);
        btback_detailmanga = (ImageButton) findViewById(R.id.btback_detailmanga);
    }
}
