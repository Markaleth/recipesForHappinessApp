package com.vladgeorgescu.recipesforhappiness.Epoxy;

import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.widget.TextView;

import com.airbnb.epoxy.EpoxyAttribute;
import com.airbnb.epoxy.EpoxyModelClass;
import com.airbnb.epoxy.EpoxyModelWithHolder;
import com.vladgeorgescu.recipesforhappiness.R;

import butterknife.BindView;

@EpoxyModelClass(layout = R.layout.add_recipe_form_label)
public class AddRecipeLabelEpoxyModel extends EpoxyModelWithHolder<AddRecipeLabelEpoxyModel.AddRecipeLabelHolder> {

    @EpoxyAttribute
    @StringRes
    int labelText;

    @Override
    protected AddRecipeLabelHolder createNewHolder() {
        return new AddRecipeLabelHolder();
    }


    @Override
    public void bind(@NonNull AddRecipeLabelHolder holder) {
        super.bind(holder);
        holder.addRecipeHeaderLabel.setText(labelText);

    }

    @Override
    protected int getDefaultLayout() {
        return R.layout.add_recipe_form_label;
    }


    class AddRecipeLabelHolder extends BaseEpoxyHolder {
        @BindView(R.id.addRecipeFormLabel)
        TextView addRecipeHeaderLabel;
    }
}
