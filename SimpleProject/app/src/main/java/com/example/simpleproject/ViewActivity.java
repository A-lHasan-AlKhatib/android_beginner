package com.example.simpleproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.textfield.TextInputEditText;

public class ViewActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextInputEditText et_model, et_color, et_dpl, et_desc;
    private ImageView iv;
    private MyDB db;
    public static final int PICK_IMAGE_RQ = 1;
    public static final int ADD_CAR_RESULT_CODE = 2;
    public static final int EDIT_CAR_RESULT_CODE = 3;
    private int carId = -1;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_car);
        toolbar = findViewById(R.id.details_toolsbar);
        setSupportActionBar(toolbar);
        iv = findViewById(R.id.details_img);
        et_model = findViewById(R.id.details_model);
        et_color = findViewById(R.id.details_color);
        et_dpl = findViewById(R.id.details_dpl);
        et_desc = findViewById(R.id.details_desc);

        db = new MyDB(this);

        Intent intent = getIntent();
        carId = intent.getIntExtra(MainActivity.CAR_KEY, -1);
        if (carId == -1) {
            switchFields(true);
            clearFields();
            iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent in = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(in, PICK_IMAGE_RQ);
                }
            });
        } else {
            switchFields(false);
            Car c = db.getCar(carId);
            db.close();
            if (c != null)
                setCarToFields(c);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == PICK_IMAGE_RQ && resultCode == RESULT_OK) {
            if (data != null) {
                uri = data.getData();
                iv.setImageURI(uri);
            }
        }
    }

    private void setCarToFields(Car c) {
        iv.setImageURI(Uri.parse(c.getImg()));
        et_model.setText(c.getModel());
        et_color.setText(c.getColor());
        et_dpl.setText(String.valueOf(c.getDpl()));
        et_desc.setText(c.getDescription());
    }

    private void switchFields(Boolean enable) {
        iv.setEnabled(enable);
        et_desc.setEnabled(enable);
        et_dpl.setEnabled(enable);
        et_color.setEnabled(enable);
        et_model.setEnabled(enable);
    }

    public void clearFields() {
        iv.setImageURI(null);
        et_desc.setText("");
        et_dpl.setText("");
        et_color.setText("");
        et_model.setText("");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.details_menu, menu);
        MenuItem save = menu.findItem(R.id.details_menu_check);
        MenuItem edit = menu.findItem(R.id.details_menu_edit);
        MenuItem delete = menu.findItem(R.id.details_menu_delete);
        if (carId == -1) {
            save.setVisible(true);
            edit.setVisible(false);
            delete.setVisible(false);
        } else {
            save.setVisible(false);
            edit.setVisible(true);
            delete.setVisible(true);
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String model, color, desc;
        String imagePath = "";
        double dpl;
        switch (item.getItemId()) {
            case R.id.details_menu_check:
                model = et_model.getText().toString();
                color = et_color.getText().toString();
                desc = et_desc.getText().toString();
                dpl = Double.parseDouble(et_dpl.getText().toString());
                if (uri != null)
                    imagePath = uri.toString();
                Car car = new Car(0, model, Integer.parseInt(imagePath), color, dpl, desc);
                if (carId == -1) {
                    //insert
                    setResult(ADD_CAR_RESULT_CODE, null);
                } else {
                    //edit
                    setResult(EDIT_CAR_RESULT_CODE, null);
                }
                finish();
                return true;
            case R.id.details_menu_delete:

                Car c = new Car(carId, null, 0, null, 0, null);
                // delete from DB using id
                setResult(RESULT_OK, null);

                finish();
                return true;
            case R.id.details_menu_edit:
                switchFields(true);
                MenuItem save = toolbar.getMenu().findItem(R.id.details_menu_check);
                MenuItem edit = toolbar.getMenu().findItem(R.id.details_menu_edit);
                MenuItem delete = toolbar.getMenu().findItem(R.id.details_menu_delete);
                delete.setVisible(false);
                save.setVisible(false);
                edit.setVisible(true);

                return true;
            default:
                return false;
        }
    }
}
