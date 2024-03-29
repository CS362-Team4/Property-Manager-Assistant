package com.project.group4.propertymanagerassistant.database;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.project.group4.propertymanagerassistant.R;

/**
 * Created by benhoelzel on 10/26/14.
 */
public class FragmentPropertyTab extends Fragment {
    String textString;
    String propertyId;
    TextView text;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_owner_tab, container, false);

       //
        if(savedInstanceState==null){
            //First run, create text...
            TextView myText = (TextView) view.findViewById(R.id.textView);//Get textview from view id
            myText.append(" :: " + propertyId);
            textString = myText.getText().toString() ;

        }
        else{
            //USED WITH SAVING INSTANCED, we need to save it o scroll back is killed.
            //Use the previouslly saved data as the text to be displayed
            textString = savedInstanceState.getString("text");
            TextView myText = (TextView) view.findViewById(R.id.textView);//Get textview from view id
            myText.setText(textString);
        }
        //
        return view;
    }


    //MAYNOT NEED RIGHT NOW
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        text = (TextView) getActivity().findViewById(R.id.textView);//Set text view


    }

//Saving state of text?
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("text",textString);
    }


    //Testing to insure we got the correct property ID, we do need to make sure stuff is good before we acces the text view. Because we call this from adaptor, the view is not creting
    public void setPropertyId(String data){
        this.propertyId = data;//setting the string
        Log.d("FragmentOwnerTab", "Here now, with " + data);//testing
    }



}