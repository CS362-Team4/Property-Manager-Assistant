package com.project.group4.propertymanagerassistant;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by benhoelzel on 10/26/14.
 */
public class FragmentTenantTab extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_tenant_tab, container, false);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        menu.removeItem(2);
        menu.add(menu.NONE, 2, 2, "Edit");
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d("FragmentTenantTab", "onOptionsItemSelected");
        return super.onOptionsItemSelected(item);
    }
}
