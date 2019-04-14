package com.stormy.studios.recipe;

import com.stormy.studios.resource.ResourceStack;

import java.util.HashMap;

public interface Recipe {
    boolean hasMaterials(HashMap<String, ResourceStack> factionInput);

    void takeMaterials(HashMap<String, ResourceStack> factionInput);
}
