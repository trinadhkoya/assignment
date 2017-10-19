package trinadhkoya.github.io.myprototype;

import android.content.Context;
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

public class RequestAdapter extends ArrayAdapter<Request> {

    // View lookup cache
    private static class ViewHolder {
        TextView requestTitle;
        Button rejectBtn;
        Button acceptBtn;

    }

    public RequestAdapter(Context context, ArrayList<Request> requestArrayList) {
        super(context, R.layout.item_user, requestArrayList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Request request = getItem(position);
        ViewHolder viewHolder; // view lookup cache stored in tag
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_user, parent, false);
            viewHolder.requestTitle = (TextView) convertView.findViewById(R.id.requeset_title);
            viewHolder.rejectBtn = (Button) convertView.findViewById(R.id.btn_reject);
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
