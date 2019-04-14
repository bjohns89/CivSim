package com.stormy.studios.recipe;

import com.stormy.studios.resource.ResourceStack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static com.stormy.studios.resource.Resource.STONE;
import static com.stormy.studios.resource.Resource.WOOD;

public class BuildingRecipe implements Recipe {

    public static final BuildingRecipe FARM_RECIPE = new BuildingRecipe(new ResourceStack(WOOD, 2), new ResourceStack(STONE, 2));
    public static final BuildingRecipe QUARRY_RECIPE = new BuildingRecipe(new ResourceStack(WOOD, 3), new ResourceStack(STONE, 3));
    public static final BuildingRecipe LUMBER_MILL_RECIPE = new BuildingRecipe(new ResourceStack(WOOD, 3), new ResourceStack(STONE, 2));
    // public static final BuildingRecipe FARM_RECIPE = new BuildingRecipe(new ResourceStack(WOOD, 2), new ResourceStack(STONE, 2));

    private List<ResourceStack> input;

    public BuildingRecipe(ResourceStack... input) {
        this.input = Arrays.asList(input);
    }

    @Override
    public boolean hasMaterials(HashMap<String, ResourceStack> factionInput) {
        int count = 0;
        for (ResourceStack anInput : input) {
            if (factionInput.get(anInput.getResourceName()) == null) return false;
            if (factionInput.get(anInput.getResourceName()).getCount() >= anInput.getCount()) {
                count++;
            }
        }
        return count == input.size();
    }

    @Override
    public void takeMaterials(HashMap<String, ResourceStack> factionInput) {

    }
}
