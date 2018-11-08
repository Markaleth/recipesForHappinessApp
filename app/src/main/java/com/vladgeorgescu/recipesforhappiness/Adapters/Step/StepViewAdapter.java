//package com.vladgeorgescu.recipesforhappiness.Adapters.Step;
//
//import android.content.Context;
//import android.support.annotation.NonNull;
//import android.support.v7.widget.RecyclerView;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Toast;
//
//import com.vladgeorgescu.recipesforhappiness.Adapters.Ingredient.IngredientHolder;
//import com.vladgeorgescu.recipesforhappiness.Model.Ingredient;
//import com.vladgeorgescu.recipesforhappiness.Model.Step;
//import com.vladgeorgescu.recipesforhappiness.R;
//
//import java.util.ArrayList;
//
//public class StepViewAdapter extends RecyclerView.Adapter<StepHolder> {
//
//    private ArrayList<Step> stepArrayList;
//    private Context context;
//
//    public StepViewAdapter(ArrayList<Step> ingredientArrayList, Context context) {
//        this.stepArrayList = ingredientArrayList;
//        this.context = context;
//    }
//
//    @NonNull
//    @Override
//    public StepHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        Log.d("StepViewAdapter", ".onCreateViewHolder: called");
////        View addStepView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.step_row, viewGroup, false);
//        StepHolder stepHolder = new StepHolder(addStepView);
////        return stepHolder;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull StepHolder stepHolder, int i) {
//        Log.d("StepViewAdapter", ".onBindViewOrder: called");
//        stepHolder.getAddAdditionalStep().setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, "Add another ingredient!", Toast.LENGTH_SHORT).show();
//                Log.d("IngredientViewAdapter", "onClick: event");
//                stepArrayList.add(new Step(""));
//                notifyDataSetChanged();
//            }
//        });
//    }
//
//    @Override
//    public int getItemCount() {
//        return stepArrayList.size();
//    }
//
//    public ArrayList<Step> getStepArrayList() {
//        return stepArrayList;
//    }
//}
