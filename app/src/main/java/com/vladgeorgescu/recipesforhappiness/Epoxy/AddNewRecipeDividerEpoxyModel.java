package com.vladgeorgescu.recipesforhappiness.Epoxy;

import android.support.annotation.NonNull;
import android.view.View;

import com.airbnb.epoxy.EpoxyModelClass;
import com.airbnb.epoxy.EpoxyModelWithHolder;
import com.vladgeorgescu.recipesforhappiness.R;

import butterknife.BindView;

@EpoxyModelClass(layout = R.layout.add_new_recipe_divider)
public class AddNewRecipeDividerEpoxyModel extends EpoxyModelWithHolder<AddNewRecipeDividerEpoxyModel.DividerHolder> {


    @Override
    protected DividerHolder createNewHolder() {
        return new DividerHolder();
    }

    @Override
    public void bind(@NonNull DividerHolder holder) {
        super.bind(holder);

    }

    @Override
    protected int getDefaultLayout() {
        return R.layout.add_new_recipe_divider;
    }

    class DividerHolder extends BaseEpoxyHolder{
        @BindView(R.id.add_recipe_divider)
        View addRecipeDivider;

    }
}
