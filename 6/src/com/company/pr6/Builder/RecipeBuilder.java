package com.company.pr6.Builder;

public class RecipeBuilder implements Builder<String>{

    private StringBuilder recipe;

    RecipeBuilder(){
        this.recipe = new StringBuilder();
        recipe.append("Take bread\n");
    }

    @Override
    public Builder<String> addProduct(String s) {
        recipe.append("Add ").append(s).append(" to sandwich.\n");
        return this;
    }

    @Override
    public Builder<String> addLayer() {
        recipe.append("Cover sandwich with bread.\n");
        return this;
    }

    @Override
    public Builder<String> addSauce(String s) {
        recipe.append("Pour ").append(s).append(" over the sandwich.\n");
        return this;
    }

    public String make(){
        addLayer();
        return recipe.toString();
    }
}
