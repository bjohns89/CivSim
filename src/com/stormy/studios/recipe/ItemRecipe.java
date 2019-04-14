package com.stormy.studios.recipe;

import com.stormy.studios.resource.ResourceStack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static com.stormy.studios.resource.Resource.*;

public class ItemRecipe implements Recipe {

    public static final ItemRecipe TEST_ITEM_RECIPE = new ItemRecipe(new ResourceStack(FOOD, 100), new ResourceStack(WOOD, 1), new ResourceStack(METAL, 1));

    private ResourceStack output;
    private List<ResourceStack> input;

    public ItemRecipe(ResourceStack output, ResourceStack... input) {
        this.output = output;
        this.input = Arrays.asList(input);
    }

    @Override
    public void takeMaterials(HashMap<String, ResourceStack> factionInput) {

    }

    @Override
    public boolean hasMaterials(HashMap<String, ResourceStack> factionInput) {
        int count = 0;
        for (int i = 0; i < input.size(); i++) {
            if (factionInput.get(input.get(i).getResourceName()) == null) return false;
            if (factionInput.get(input.get(i).getResourceName()).getCount() >= input.get(i).getCount()) {
                count++;
            }
        }
        return count == input.size();
    }

    @Override
    public String toString() {
        return output + " <= " + input;
    }
}
