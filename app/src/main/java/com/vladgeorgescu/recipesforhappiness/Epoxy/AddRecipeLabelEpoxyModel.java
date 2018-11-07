package com.vladgeorgescu.recipesforhappiness.Epoxy;

import android.support.annotation.NonNull;
import android.widget.TextView;

import com.airbnb.epoxy.EpoxyModelClass;
import com.airbnb.epoxy.EpoxyModelWithHolder;
import com.vladgeorgescu.recipesforhappiness.R;

import butterknife.BindView;

@EpoxyModelClass(layout = R.layout.add_new_recipe_header_label)
public class AddRecipeLabelEpoxyModel extends EpoxyModelWithHolder<AddRecipeLabelEpoxyModel.AddRecipeLabelHolder> {

    private int spanSize;
    private String labelText;

    @Override
    protected AddRecipeLabelHolder createNewHolder() {
        return new AddRecipeLabelHolder();
    }

    public void setLabelText(String labelText) {
        this.labelText = labelText;
    }

    @Override
    public void bind(@NonNull AddRecipeLabelHolder holder) {
        super.bind(holder);
        holder.addRecipeHeaderLabel.setText(labelText);

    }

    @Override
    public int getSpanSize(int totalSpanCount, int position, int itemCount) {
        return spanSize;
    }

    @Override
    protected int getDefaultLayout() {
        return R.layout.add_new_recipe_header_label;
    }


    class AddRecipeLabelHolder extends BaseEpoxyHolder {
        @BindView(R.id.addRecipeHeaderLabel)
        TextView addRecipeHeaderLabel;
    }
}
