package vn.edu.hust.mail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<ItemModel> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items = new ArrayList<>();
        items.add(new ItemModel("Quora",
                "More related to \"How do I find the value of nCr%1000000007 for the large number n (n <= 10^6) in C?\"",
                "This email was sent by Quora. If you dont want to receive this type of email in the future, please unsubscribe.",
                "12:34 PM"));
        items.add(new ItemModel("Indeed",
                "Tuyển fresher C at Nhà Tuyển Dụng",
                "FIST ALLIANCES, Ky Nguyen Van",
                "12:28 PM"));
        items.add(new ItemModel("ACD Systems",
                "Claim your free copy of Video Source",
                "ACDSee Brand new tutorials, photos, videos",
                "11:39 AM"));
        items.add(new ItemModel("Edurila.com",
                "$19 Only (First 10 spots) - Bestselling ",
                "Are you looking to Learn Web Designing Course",
                "11:22 AM"));
        items.add(new ItemModel("Chris Abad",
                "Help make Campaign Monitor better",
                "Let us know your thoughts! No Images seem better!",
                "11:21 AM"));
        items.add(new ItemModel("Tuto.com",
                "8h de formation gratuite et les nouvea de la...",
                "Photoshop, SEO, Blender, CSS, Wordpress and so on",
                "11:04 AM"));
        items.add(new ItemModel("Random Nerd Tutorials",
                "ESP32/ESP8266 HTTP GET and POST",
                "New ESP Guides published on the RNT blog. Hi. I hope you're doing well",
                "Apr 8"));
        items.add(new ItemModel("ACD Systems",
                "Your accID temporary password",
                "Your accID temporarry has been sent!",
                "Apr 8"));
        items.add(new ItemModel("Xanh Tiệm",
                "GIVEAWAY || 1 ĐIỀU \"HƠN\" NHẬN ĐƯỢC KHI NHẬP HỘI TIỆM XANH",
                "Tuần này của bạn thế nào vậy?",
                "Feb 19"));
        items.add(new ItemModel("Do Ba Lam",
                "[IT2030] Tài liệu học tập",
                "Chào các bạn, Theo phân công của Viện và Bộ môn",
                "Feb 14"));
        items.add(new ItemModel("[Tuyển sinh] Hoàng Thi Thảo",
                "[ĐH FUNiX/FPT]_Thông tin Khoá Học Trực tuyến Lập trình viên",
                "Dear Anh / Chị ! Em là Hoàng Thảo - cán bộ",
                "Feb 3"));

        ListView listview = findViewById(R.id.list_view);

        MailAdapter mail = new MailAdapter(items);
        listview.setAdapter(mail);
    }
}
