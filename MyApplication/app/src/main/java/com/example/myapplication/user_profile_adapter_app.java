package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class user_profile_adapter_app extends AppCompatActivity {
    ArrayList<User> data;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        lv=findViewById(R.id.test_lv);
        data=new ArrayList<>();

        data.add(new User("Tamerwefweed R Alnauizi |" ,"Wellcome at my profile, you can follow me now!" ,
                "100","100","100",R.drawable.ic_man));
        data.add(new User("Alaa I Alnauizi |" ,"Wellcome at my profile, you can follow me now!" ,
                "1000","828","700",R.drawable.ic_girl));
        data.add(new User("Omer H Alnauizi |" ,"Wellcome at my profile, you can follow me now!" ,
                "991","212","789",R.drawable.musician));
        data.add(new User("Mosa N Alnauizi |" ,"Wellcome at my profile, you can follow me now!" ,
                "797","50","788",R.drawable.programmer));
        data.add(new User("Jood O Alnauizi |" ,"Wellcome at my profile, you can follow me now!" ,
                "852","20","320",R.drawable.ic_iconfinder_169_man_artist_1_3099493));
        data.add(new User("Amal K Alnauizi |" ,"Wellcome at my profile, you can follow me now!" ,
                "410","214","321",R.drawable.farmer));
        data.add(new User("Nour A Alnauizi |" ,"Wellcome at my profile, you can follow me now!" ,
                "214","85","96",R.drawable.judge));
        data.add(new User("Alaa M Alnauizi |" ,"Wellcome at my profile, you can follow me now!" ,
                "852","231","866",R.drawable.cooker));
        UserCustomAdapter adapter=new UserCustomAdapter(this,data);
        lv.setAdapter(adapter);
    }
}
