package trinadhkoya.github.io.myprototype;

/**
 * Created by trinadhkoya on 19/10/17.
 */

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by trinadhkoya on 19/10/17.
 */

public class RequestAdaptedAdapter extends ArrayAdapter<Request> {


    RequestOperations requestOperations;
    Request oldRequest;

    // View lookup cache
    private static class ViewHolder {
        TextView requestTitle;
        Button acceptBtn;

    }

    public RequestAdaptedAdapter(Context context, ArrayList<Request> requestArrayList) {
        super(context, R.layout.item_user, requestArrayList);
        requestOperations = new RequestOperations(context);
        oldRequest = new Request();

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final Request request = getItem(position);
        ViewHolder viewHolder; // view lookup cache stored in tag
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_user_accepted, parent, false);
            viewHolder.requestTitle = (TextView) convertView.findViewById(R.id.requeset_title);
            viewHolder.acceptBtn = (Button) convertView.findViewById(R.id.btn_approve);

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
