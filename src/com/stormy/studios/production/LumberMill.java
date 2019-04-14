package com.stormy.studios.production;

import com.stormy.studios.faction.Faction;
import com.stormy.studios.manager.GameManager;
import com.stormy.studios.recipe.BuildingRecipe;
import com.stormy.studios.resource.ResourceStack;
import com.stormy.studios.util.NameBuilder;

import static com.stormy.studios.resource.Resource.WOOD;

public class LumberMill extends Production {

    public LumberMill(Faction faction) {
        super(faction);
        setName("sawmill");
        setActiveProduction(true);
        setMaxWorkers(2);
        setBuildingRecipe(BuildingRecipe.LUMBER_MILL_RECIPE);
        setTurnsToWork(3);
        nameBuilder = new NameBuilder(name);
    }

    @Override
    public void changeActiveRecipe() {

    }

    @Override
    public void doWork() {
        if (ableToWork()) {
            faction.addToResourceList(new ResourceStack(WOOD, 1 + (activeWorkers - 1)));
            setTurnActivated(GameManager.WORLD_TURN);
        }
    }
}
