package com.company.pr6.Builder;

public class Test {

    public static void recipe_simple(Builder b){
        b.addProduct("Sausage")
         .addProduct("Cheese")
         .addProduct("Tomato")
         .addSauce("Ketchup")
         .addLayer()
         .addProduct("Beef cutlet")
         .addProduct("Greens");
    }

    public static void main(String[] args) {
        Builder<String> reciper = new RecipeBuilder();
        Builder<Sandwich> cook = new SandwichBuilder();
        recipe_simple(reciper);
        recipe_simple(cook);

        System.out.println(reciper.make());
        System.out.println(cook.make().toString());
    }
}
