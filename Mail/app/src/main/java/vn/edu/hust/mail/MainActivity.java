package vn.edu.hust.mail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import vn.edu.hust.mail.adapter.MailAdapter;
import vn.edu.hust.mail.adapter.MailRecycleViewAdapter;
import vn.edu.hust.mail.model.MailModel;

public class MainActivity extends AppCompatActivity implements MailItemClickListener{

    List<MailModel> items;
    TextView txtFindKeyword;
    Button filterFavorite;
    MailRecycleViewAdapter adapter;
    int filterWithFavorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items = new ArrayList<>();
        items.add(new MailModel("Quora",
                "More related to \"How do I find the value of nCr%1000000007 for the large number n (n <= 10^6) in C?\"",
                "This email was sent by Quora. If you dont want to receive this type of email in the future, please unsubscribe.",
                "12:34 PM"));
        items.add(new MailModel("Indeed",
                "Tuyển fresher C at Nhà Tuyển Dụng",
                "FIST ALLIANCES, Ky Nguyen Van",
                "12:28 PM"));
        items.add(new MailModel("ACD Systems",
                "Claim your free copy of Video Source",
                "ACDSee Brand new tutorials, photos, videos",
                "11:39 AM"));
        items.add(new MailModel("Edurila.com",
                "$19 Only (First 10 spots) - Bestselling ",
                "Are you looking to Learn Web Designing Course",
                "11:22 AM"));
        items.add(new MailModel("Chris Abad",
                "Help make Campaign Monitor better",
                "Let us know your thoughts! No Images seem better!",
                "11:21 AM"));
        items.add(new MailModel("Tuto.com",
                "8h de formation gratuite et les nouvea de la...",
                "Photoshop, SEO, Blender, CSS, Wordpress and so on",
                "11:04 AM"));
        items.add(new MailModel("Random Nerd Tutorials",
                "ESP32/ESP8266 HTTP GET and POST",
                "New ESP Guides published on the RNT blog. Hi. I hope you're doing well",
                "Apr 8"));
        items.add(new MailModel("ACD Systems",
                "Your accID temporary password",
                "Your accID temporarry has been sent!",
                "Apr 8"));
        items.add(new MailModel("Xanh Tiệm",
                "GIVEAWAY || 1 ĐIỀU \"HƠN\" NHẬN ĐƯỢC KHI NHẬP HỘI TIỆM XANH",
                "Tuần này của bạn thế nào vậy?",
                "Feb 19"));
        items.add(new MailModel("Do Ba Lam",
                "[IT2030] Tài liệu học tập",
                "Chào các bạn, Theo phân công của Viện và Bộ môn",
                "Feb 14"));
        items.add(new MailModel("[Tuyển sinh] Hoàng Thi Thảo",
                "[ĐH FUNiX/FPT]_Thông tin Khoá Học Trực tuyến Lập trình viên",
                "Dear Anh / Chị ! Em là Hoàng Thảo - cán bộ",
                "Feb 3"));

        txtFindKeyword = (TextView) findViewById(R.id.find_keyword);
        filterFavorite = (Button) findViewById(R.id.filter_favorite);
        filterWithFavorite = 0;

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new MailRecycleViewAdapter(items, this);
        recyclerView.setAdapter(adapter);

        txtFindKeyword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length() >= 3 || s.length() == 0)
                    filter(s.toString());
            }
        });


        filterFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<MailModel> filteredList = new ArrayList<>();
                if(filterWithFavorite == 0){
                    filterWithFavorite = 1;
                    for(MailModel item : items){
                        if(item.isFavorite()){
                            filteredList.add(item);
                        }
                        adapter.filterList(filteredList);
                    }
                } else{
                    filterWithFavorite = 0;
                    for(MailModel item : items){
                        if(!item.isFavorite()){
                            filteredList.add(item);
                        }
                        adapter.filterList(filteredList);
                    }
                }

            }
        });
    }

    private void filter(String query){
        ArrayList<MailModel> filteredList = new ArrayList<>();
        String queryToLowerCase = query.toLowerCase();
        for(MailModel item : items){
            if(item.getName().toLowerCase().contains(queryToLowerCase)
            || item.getContent().toLowerCase().contains(queryToLowerCase)
            || item.getHeader().toLowerCase().contains(queryToLowerCase)){
                filteredList.add(item);
            }
            adapter.filterList(filteredList);
        }
    }

    @Override
    public void OnItemClick(int position) { }
}
