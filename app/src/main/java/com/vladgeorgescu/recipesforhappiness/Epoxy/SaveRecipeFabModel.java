package com.vladgeorgescu.recipesforhappiness.Epoxy;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.view.View;

import com.airbnb.epoxy.EpoxyAttribute;
import com.airbnb.epoxy.EpoxyModelClass;
import com.airbnb.epoxy.EpoxyModelWithHolder;
import com.vladgeorgescu.recipesforhappiness.R;

import butterknife.BindView;

@EpoxyModelClass(layout = R.layout.save_recipe_fab)
public class SaveRecipeFabModel extends EpoxyModelWithHolder<SaveRecipeFabModel.SaveRecipeFabHolder> {
    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    View.OnClickListener saveRecipeClickListener;

    @Override
    protected SaveRecipeFabHolder createNewHolder() {
        return new SaveRecipeFabHolder();
    }

    @Override
    public void bind(@NonNull SaveRecipeFabHolder holder) {
        holder.saveRecipeFab.setOnClickListener(saveRecipeClickListener);
    }

    @Override
    protected int getDefaultLayout() {
        return R.layout.save_recipe_fab;
    }

    class SaveRecipeFabHolder extends BaseEpoxyHolder {
        @BindView(R.id.save_recipe_fab)
        FloatingActionButton saveRecipeFab;
        @BindView(R.id.save_recipe_constraint_Layout)
        ConstraintLayout saveRecipeFabConstraintLayout;
    }
}
