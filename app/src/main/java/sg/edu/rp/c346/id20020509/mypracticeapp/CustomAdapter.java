package sg.edu.rp.c346.id20020509.mypracticeapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Practice> practiceList;

    public CustomAdapter (Context context, int resource, ArrayList<Practice> objects) {
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        practiceList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //"Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        //Obtain the UI components and do the necessary binding
        TextView tvDisplayID = rowView.findViewById(R.id.tvDisplayID);
        TextView tvDisplayDescription = rowView.findViewById(R.id.tvDisplayDescription);
        RatingBar rbDisplay = rowView.findViewById(R.id.rbDisplay);
        ImageView ivDisplay = rowView.findViewById(R.id.ivDisplay);

        //Obtain the to do information based on the position
        Practice currentPractice = practiceList.get(position);

        //Set values to the TextView to display the corresponding information
        tvDisplayDescription.setText(currentPractice.getDescription());
        rbDisplay.setRating(currentPractice.getStars());

        if (currentPractice.getStars() == 1) {
            ivDisplay.setImageResource(R.drawable.sacrilegious);
        }

        else if (currentPractice.getStars() == 2) {
            ivDisplay.setImageResource(R.drawable.lamentable);
        }

        else if (currentPractice.getStars() == 3) {
            ivDisplay.setImageResource(R.drawable.interesting);
        }

        else if (currentPractice.getStars() == 4) {
            ivDisplay.setImageResource(R.drawable.amazing);
        }

        else if (currentPractice.getStars() == 5) {
            ivDisplay.setImageResource(R.drawable.lingling);
        }

        return rowView;

    }

}
