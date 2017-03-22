package pl.edu.wat.wel.secon.secon2017;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static android.R.attr.resource;

/**
 * Created by Damian Bondaruk on 12/03/2017.
 */

public class ListAdapter extends ArrayAdapter<List>{


    public ListAdapter(Activity context, ArrayList<List> list) {
        super(context, 0, list);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false
            );
        }

        List currentList = getItem(position);
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.time_list);
        dateTextView.setText(currentList.getDate());
        TextView messageTextView = (TextView) listItemView.findViewById(R.id.message_list);
        messageTextView.setText(currentList.getMessage());

        return listItemView;
    }
}
