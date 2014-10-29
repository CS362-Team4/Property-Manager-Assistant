package com.project.group4.propertymanagerassistant;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.project.group4.propertymanagerassistant.dummy.DummyContent;

/**
 * A fragment representing a single Property detail screen.
 * This fragment is either contained in a {@link PropertyListActivity}
 * in two-pane mode (on tablets) or a {@link PropertyDetailActivity}
 * on handsets.
 */
public class PropertyDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private DummyContent.DummyItem mItem;

    //create viewPager
    ViewPager viewPager=null;
    //Declare TabAdaptor
    TabAdapter myTabAdapter;


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public PropertyDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
/*removed

        setContentView(R.layout.activity_property_detail);
        viewPager = (ViewPager) findViewById(R.id.pager);//get pager from app xml, need to assign it to current view
        myTabAdapter = new TabAdapter(getSupportFragmentManager());
        // FragmentManager fragmentManager = getFragmentManager();//frag manager
        viewPager.setAdapter(myTabAdapter);
*/
        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.view_tab_pager, container, false);


        viewPager = (ViewPager) rootView.findViewById(R.id.pager);//get pager from app xml, need to assign it to current view
        myTabAdapter = new TabAdapter(getFragmentManager());
        // FragmentManager fragmentManager = getFragmentManager();//frag manager
        viewPager.setAdapter(myTabAdapter);

//on fragment a b c for now
        // Show the dummy content as text in a TextView.
      //  if (mItem != null) {
      //      ((TextView) rootView.findViewById(R.id.property_detail)).setText(mItem.content);
      //  }

        return rootView;
    }


}
