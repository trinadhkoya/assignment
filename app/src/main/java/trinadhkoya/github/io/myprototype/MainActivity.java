package trinadhkoya.github.io.myprototype;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText userNameEditText;
    EditText passwordEditText;
    Button formSubmitBtn;

    LinearLayout formLayout;


    TextView customerTV;
    TextView serviceTV;
    TextView serviceProviderTV;


    String userName = "";
    String userPass = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        formLayout = (LinearLayout) findViewById(R.id.form_layout);
        userNameEditText = (EditText) findViewById(R.id.et_name);
        passwordEditText = (EditText) findViewById(R.id.et_password);
        formSubmitBtn = (Button) findViewById(R.id.btn_submit);

        customerTV = (TextView) findViewById(R.id.tv_user);
        serviceTV = (TextView) findViewById(R.id.tv_service);
        serviceProviderTV = (TextView) findViewById(R.id.service_provider);

    }


    public void onClickService(View view) {

        serviceTV.setTypeface(null, Typeface.BOLD);
        customerTV.setTypeface(null, Typeface.NORMAL);
        serviceProviderTV.setTypeface(null, Typeface.NORMAL);
        Constants.TYPE = "SERVICE";
        if (serviceTV.getText().toString().trim().equals(Constants.TYPE)) {

            if (userNameEditText.getText().toString().trim().equals(Constants.CC_NAME) && passwordEditText.getText().toString().equals(Constants.CC_PW)) {

                formSubmitBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                        intent.putExtra("USER_TYPE", Constants.TYPE);
                        startActivity(intent);


                    }
                });

            } else {
                Toast.makeText(this, "Service Credentials Wrong", Toast.LENGTH_SHORT).show();
            }


        }

    }


    public void onClickServiceProvider(View view) {

        serviceTV.setTypeface(null, Typeface.NORMAL);
        customerTV.setTypeface(null, Typeface.NORMAL);
        serviceProviderTV.setTypeface(null, Typeface.BOLD);
        Constants.TYPE = "SERVICE PROVIDER";
        if (serviceProviderTV.getText().toString().trim().equals(Constants.TYPE)) {
            if (userNameEditText.getText().toString().trim().equals(Constants.SUBSCRIBER_NAME) && passwordEditText.getText().toString().equals(Constants.SUBSCRIBER_PW)) {


                formSubmitBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                        intent.putExtra("USER_TYPE", Constants.TYPE);
                        startActivity(intent);
                    }
                });
            } else {
                Toast.makeText(this, "Service Provider Credentials Wrong", Toast.LENGTH_SHORT).show();
            }
        }

    }


    public void onClickCustomer(View view) {

        serviceTV.setTypeface(null, Typeface.NORMAL);
        customerTV.setTypeface(null, Typeface.BOLD);
        serviceProviderTV.setTypeface(null, Typeface.NORMAL);
        Constants.TYPE = "CUSTOMER";
        if (customerTV.getText().toString().trim().equals(Constants.TYPE)) {
            if (userNameEditText.getText().toString().trim().equals(Constants.USER_NAME) && passwordEditText.getText().toString().equals(Constants.USER_PW)) {


                formSubmitBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                        intent.putExtra("USER_TYPE", Constants.TYPE);
                        startActivity(intent);
                        ;

                    }
                });

            } else {
                Toast.makeText(this, "Customer Credentials Wrong", Toast.LENGTH_SHORT).show();
            }
        }

    }


}
