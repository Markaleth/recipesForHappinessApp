package com.vladgeorgescu.recipesforhappiness.TabFragments;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.vladgeorgescu.recipesforhappiness.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class StepsTabFragment extends Fragment {

    private Unbinder unbinder;
    private EditText stepName;
    private FloatingActionButton addExtraStep;
    private LinearLayout stepsLinerarLayout;
    private Context context;
    private CardView stepCardViewElement;

    public StepsTabFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.step_tab_fragment, container, false);
        stepCardViewElement = view.findViewById(R.id.addStepCardView);
        stepsLinerarLayout = view.findViewById(R.id.steps_layout);
        stepName = view.findViewById(R.id.stepName);
        addExtraStep = view.findViewById(R.id.addStepFab);
        ButterKnife.bind(getActivity());
        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.addStepFab})
    public void addNewIngredientRow() {
    }

}
