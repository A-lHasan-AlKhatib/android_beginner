package com.example.simpleproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;
    private FloatingActionButton floating;
    private Toolbar toolbar;
    private CarRecViewAdapter adapter;
    private static final int PERMISSION_REQ_CODE = 5;
    public static final int ADD_CAR_REQ_CODE = 1;
    public static final int EDIT_CAR_REQ_CODE = 2;
    public static final String CAR_KEY = "car_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQ_CODE);
        }

        toolbar = findViewById(R.id.main_details_toolbar);
        setSupportActionBar(toolbar);
        rv = findViewById(R.id.main_rec_view);
        floating = findViewById(R.id.main_floating_btn);
        adapter = new CarRecViewAdapter(new ArrayList<Car>(), new OnCarClickedListener() {
            @Override
            public void onItemClick(int carId) {
                Intent intent = new Intent(getBaseContext(), ViewActivity.class);
                intent.putExtra(CAR_KEY, EDIT_CAR_REQ_CODE);
                startActivityForResult(intent, EDIT_CAR_REQ_CODE);
            }
        });
        rv.setAdapter(adapter);
        RecyclerView.LayoutManager manager = new GridLayoutManager(this, 2);
        rv.setLayoutManager(manager);
        rv.setHasFixedSize(true);
        floating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ViewActivity.class);
                startActivityForResult(intent, ADD_CAR_REQ_CODE);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        SearchView view = (SearchView) menu.findItem(R.id.main_search).getActionView();
        view.setSubmitButtonEnabled(true);

        view.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //fetch from db
                ArrayList<Car> cars = new ArrayList<>();
                adapter.setCars(cars);
                adapter.notifyDataSetChanged();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //fetch from db
                ArrayList<Car> cars = new ArrayList<>();
                adapter.setCars(cars);
                adapter.notifyDataSetChanged();
                return false;
            }

        });

        view.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                //get all cars from DB
                ArrayList<Car> cars = new ArrayList<>();
                adapter.setCars(cars);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == ADD_CAR_REQ_CODE) {
            //تحديث بيانات ال list
            //adapter.setCars();
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == PERMISSION_REQ_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            } else {

            }
        }
    }
}