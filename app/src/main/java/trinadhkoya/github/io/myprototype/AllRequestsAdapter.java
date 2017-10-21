package trinadhkoya.github.io.myprototype;

/**
 * Created by trinadhkoya on 19/10/17.
 */

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class AllRequestsAdapter extends ArrayAdapter<Request> {


    RequestOperations requestOperations;
    Request oldRequest;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView requestTitle;
        TextView statusButton;


    }

    public AllRequestsAdapter(Context context, ArrayList<Request> requestArrayList) {
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
            convertView = inflater.inflate(R.layout.items_user_all, parent, false);
            viewHolder.requestTitle = (TextView) convertView.findViewById(R.id.requeset_title);
            viewHolder.statusButton = (TextView) convertView.findViewById(R.id.text_status);
            assert request != null;
            if (request.getStatus().equals("ACCEPTED")) {
                viewHolder.statusButton.setText(request.getStatus());
                viewHolder.statusButton.setBackgroundColor(Color.parseColor("#219688"));

            } else if (request.getStatus().equals("REJECTED")) {
                viewHolder.statusButton.setText(request.getStatus());
                viewHolder.statusButton.setBackgroundColor(Color.parseColor("#da4538"));

            } else {
                viewHolder.statusButton.setText("PENDING");
                viewHolder.statusButton.setBackgroundColor(Color.parseColor("#fc9802"));


            }


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
