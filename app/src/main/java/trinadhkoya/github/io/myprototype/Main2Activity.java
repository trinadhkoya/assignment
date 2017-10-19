package trinadhkoya.github.io.myprototype;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class Main2Activity extends AppCompatActivity {

    Toolbar toolbar;
    String userType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            toolbar.setBackground(new ColorDrawable(Color.GREEN));
        }
        Bundle extras = getIntent().getExtras();


        if (extras != null) {
            userType = extras.getString("USER_TYPE");
            if (userType.equals("CUSTOMER")) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    toolbar.setBackground(new ColorDrawable(Color.RED));
                    toolbar.setTitle(userType);
                }
            } else if (userType.equals("SERVICE")) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    toolbar.setBackground(new ColorDrawable(Color.BLACK));
                    toolbar.setTitle(userType);
                }
            } else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    toolbar.setBackground(new ColorDrawable(Color.CYAN));
                    toolbar.setTitle(userType);
                }
            }


        }
    }
}
