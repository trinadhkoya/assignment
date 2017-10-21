package trinadhkoya.github.io.myprototype;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main2Activity extends AppCompatActivity {

//    Toolbar toolbar;
    String userType;

    LinearLayout allRequestLayout;
    LinearLayout addRequestLayout;
    LinearLayout allAcceptedLayout;

    EditText addRequestET;
    Button addRequestButton;
    Button btnViewRequests;

    Button btnViewAcceptedRequest;
    ListView requestAcceptedListView;


    ListView allRequestsByUser;


    RequestOperations requestOperations;

    Request request;
    Random rand = new Random();

    List<Request> requests;
    ListView requestListView;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        requestOperations = new RequestOperations(this);
        requestOperations.open();


        request = new Request();

        allRequestLayout = (LinearLayout) findViewById(R.id.list_requests);
        addRequestLayout = (LinearLayout) findViewById(R.id.add_request_layout);
        allAcceptedLayout = (LinearLayout) findViewById(R.id.layout_accepted_requests);

        addRequestButton = (Button) findViewById(R.id.add_req_btn);
        addRequestET = (EditText) findViewById(R.id.add_req_et);

        btnViewRequests = (Button) findViewById(R.id.btn_view_requests);
        requestListView = (ListView) findViewById(R.id.requests_list);


        btnViewAcceptedRequest = (Button) findViewById(R.id.btn_view_accepted_requests);
        requestAcceptedListView = (ListView) findViewById(R.id.accepted_requests_list);

        allRequestsByUser = (ListView) findViewById(R.id.all_lists_requested);


//        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//            toolbar.setBackground(new ColorDrawable(Color.GREEN));
        }
        Bundle extras = getIntent().getExtras();


        if (extras != null) {
            userType = extras.getString("USER_TYPE");
            if (userType.equals("CUSTOMER")) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//                    toolbar.setBackground(new ColorDrawable(Color.RED));
//                    toolbar.setTitle(userType);
                }
                addRequestLayout.setVisibility(View.VISIBLE);
                allRequestLayout.setVisibility(View.GONE);
                allAcceptedLayout.setVisibility(View.GONE);


            } else if (userType.equals("SERVICE")) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//                    toolbar.setBackground(new ColorDrawable(Color.BLACK));
//                    toolbar.setTitle(userType);
                }
                addRequestLayout.setVisibility(View.GONE);
                allRequestLayout.setVisibility(View.VISIBLE);
                allAcceptedLayout.setVisibility(View.GONE);
            } else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//                    toolbar.setBackground(new ColorDrawable(Color.CYAN));
//                    toolbar.setTitle(userType);
                }
                addRequestLayout.setVisibility(View.GONE);
                allRequestLayout.setVisibility(View.GONE);
                allAcceptedLayout.setVisibility(View.VISIBLE);
            }


        }
    }


    public void onClickAddRequest(View view) {
        request.setStatus("");
        request.setRequestTitle(addRequestET.getText().toString());
        request.setCreatedDate(Utils.getDateTime());
        requestOperations.addRequest(request);
        Toast t = Toast.makeText(Main2Activity.this, "Request " + request.getReqId() + " has been Created successfully !", Toast.LENGTH_SHORT);
        t.show();


    }


    public void addAllRequests(View view) {

        requests = requestOperations.getAllRequests();
        AllRequestsAdapter requestAdapter = new AllRequestsAdapter(this, (ArrayList<Request>) requests);
        allRequestsByUser.setAdapter(requestAdapter);

    }


    public void onClickViewAllRequests(View view) {

        requests = requestOperations.getAllRequestsInPending();
        RequestAdapter requestAdapter = new RequestAdapter(this, (ArrayList<Request>) requests);
        requestListView.setAdapter(requestAdapter);

    }


    public void onClickViewAcceptedRequests(View view) {

        requests = requestOperations.getAcceptedRequests();
        System.out.println(requests.size());
        //requestOperations.close();
        RequestAdaptedAdapter requestAdapter = new RequestAdaptedAdapter(this, (ArrayList<Request>) requests);
        requestAcceptedListView.setAdapter(requestAdapter);

    }


}
