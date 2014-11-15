package com.project.group4.propertymanagerassistant;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextClock;
import android.widget.TextView;

import com.project.group4.propertymanagerassistant.R;
import com.project.group4.propertymanagerassistant.database.DatabaseHandler;
import com.project.group4.propertymanagerassistant.database.Property;

/**
 * Created by benhoelzel on 10/26/14.
 */
public class FragmentPropertyTab extends Fragment {
    private Property mItem;
    private TextView textAddress;
    private TextView textUnit;
    private TextView textCity;
    private TextView textState;
    private TextView textZip;


    String textString;
    Long propertyId;
    TextView text;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_property_detail, container, false);

        setHasOptionsMenu(true);

        if (propertyId != null) {
            // Get property detail from database
            mItem = DatabaseHandler.getInstance(getActivity()).getProperty(propertyId);
        }

        if (mItem != null) {
            //Get text field
            textAddress = ((TextView) view.findViewById(R.id.textAddress));
            //Set text field with property address
            textAddress.setText(mItem.address);

            textUnit = ((TextView) view.findViewById(R.id.textUnit));
            textUnit.setText(mItem.unit);

            textCity = ((TextView) view.findViewById(R.id.textCity));
            textCity.setText(mItem.city);

            textState = ((TextView) view.findViewById(R.id.textState));
            textState.setText(mItem.state);

            textZip = ((TextView) view.findViewById(R.id.textZip));
            textZip.setText(mItem.zip);






        }

        return view;
    }


    /**
     * This is the method we use to set the property id from the adaptor
     *
     */
    public void setPropertyId(Long data){
        this.propertyId = data;
    }


    //MAYNOT NEED RIGHT NOW
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
       // text = (TextView) getActivity().findViewById(R.id.textView);//Set text view


    }

//Saving state of text?
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
       // outState.putString("text",textString);
    }


    /*
    //Testing to insure we got the correct property ID, we do need to make sure stuff is good before we acces the text view. Because we call this from adaptor, the view is not creting
    public void setPropertyId(String data){
        this.propertyId = data;//setting the string
        Log.d("FragmentOwnerTab", "Here now, with " + data);//testing
    }
*/

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.add("Edit");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d("WTF","Do Something");
        return super.onOptionsItemSelected(item);
    }
}