package trinadhkoya.github.io.myprototype;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by trinadhkoya on 19/10/17.
 */

public class RequestAdapter extends ArrayAdapter<Request> {


    RequestOperations requestOperations;
    Request oldRequest;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView requestTitle;
        Button rejectBtn;
        Button acceptBtn;

    }

    public RequestAdapter(Context context, ArrayList<Request> requestArrayList) {
        super(context, R.layout.item_user, requestArrayList);
        requestOperations = new RequestOperations(context);
        oldRequest = new Request();
        mContext = context;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final Request request = getItem(position);
        ViewHolder viewHolder; // view lookup cache stored in tag
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_user, parent, false);
            viewHolder.requestTitle = (TextView) convertView.findViewById(R.id.requeset_title);
            viewHolder.rejectBtn = (Button) convertView.findViewById(R.id.btn_reject);
            viewHolder.acceptBtn = (Button) convertView.findViewById(R.id.btn_approve);
            viewHolder.acceptBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext, "Accepted Successfully ", Toast.LENGTH_SHORT).show();
                    if (request != null) {
                        Log.d("POSITION FUCK", +position + "and DB ID" + request.getReqId());
                    }

                    if (request != null) {
                        oldRequest.setReqId(request.getReqId());
                    }
                    oldRequest.setStatus("ACCEPTED");
                    if (request != null) {
                        oldRequest.setRequestTitle(request.getRequestTitle());
                    }
                    oldRequest.setCreatedDate(Utils.getDateTime());
                    requestOperations.updateRequest(oldRequest);

                }
            });

            viewHolder.rejectBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext, "Rejected Successfully ", Toast.LENGTH_SHORT).show();
                    assert request != null;
                    Log.d("POSITION FUCK", +position + "and DB ID" + request.getReqId());
                    oldRequest.setReqId(request.getReqId());
                    oldRequest.setStatus("REJECTED");
                    oldRequest.setRequestTitle(request.getRequestTitle());
                    oldRequest.setCreatedDate(Utils.getDateTime());
                    requestOperations.updateRequest(oldRequest);

                }
            });

            convertView.setTag(viewHolder);
        } else {
            // View is being recycled, retrieve the viewHolder object from tag
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // Populate the data from the data object via the viewHolder object
        // into the template view.
        viewHolder.requestTitle.setText(request.getRequestTitle());
        // Return the completed view to render on screen
        return convertView;
    }

}
