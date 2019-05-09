package sg.edu.rp.c346.demodatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TaskArrayAdapter extends ArrayAdapter<Task> {

    // Create arraylist with task objects
    private ArrayList<Task> objects;
    // To hold the context object
    private Context context;
    // Create the UI objects to hold the UI elements in row layout

    private TextView tvID;
    private TextView tvDesc;
    private TextView tvDate;

    public TaskArrayAdapter(Context context, int resource, ArrayList<Task> objects) {
        super(context, resource, objects);

        this.context = context;
        this.objects = objects;
    }
    public View getView(int pos, View convertView, ViewGroup parent)
    {
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //  Change R.layout.rowxyz if file is rowxyz.xml .
        View rowView = inflater.inflate(R.layout.row, parent,
                false);
        // Get the TextView object
        tvID =
                rowView.findViewById(R.id.textViewID);
        tvDesc = rowView.findViewById(R.id.textViewDesc);
        tvDate = rowView.findViewById(R.id.textViewDate);
        // Parameter "pos" is the index of the
        //  row ListView is requesting.
        //  We get back the object at the same index.
        Task object = objects.get(pos);
        // Set the TextView to show the object info
        tvID.setText(object.getId());
        tvDesc.setText(object.getDescription());
        tvDate.setText(object.getDate());
        // Return this row that is being populated.
        return rowView;
    }

}
