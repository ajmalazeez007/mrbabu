package com.greycodes.mrbabudriver.fragments;


import android.app.DialogFragment;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.greycodes.mrbabudriver.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchDialog extends DialogFragment {


    View rootView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        rootView= inflater.inflate(R.layout.fragment_search_dialog, container, false);

        return rootView;
    }


}
