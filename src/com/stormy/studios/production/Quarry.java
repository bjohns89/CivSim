package com.stormy.studios.production;

import com.stormy.studios.faction.Faction;
import com.stormy.studios.manager.GameManager;
import com.stormy.studios.recipe.BuildingRecipe;
import com.stormy.studios.resource.Resource;
import com.stormy.studios.resource.ResourceStack;
import com.stormy.studios.util.NameBuilder;
import com.stormy.studios.util.Random;

import static com.stormy.studios.resource.Resource.METAL;

public class Quarry extends Production {

    public Quarry(Faction faction) {
        super(faction);
        setName("quarry");
        setActiveProduction(true);
        setMaxWorkers(2);
        setBuildingRecipe(BuildingRecipe.QUARRY_RECIPE);
        setTurnsToWork(3);
        nameBuilder = new NameBuilder(name);
    }

    @Override
    public void changeActiveRecipe() {

    }

    @Override
    public void doWork() {
        if (ableToWork()) {
            if (Random.chance(25.0))
                faction.addToResourceList(new ResourceStack(METAL, 1 + (activeWorkers - 1)));
            else
                faction.addToResourceList(new ResourceStack(Resource.STONE, 1 + (activeWorkers - 1)));
            setTurnActivated(GameManager.WORLD_TURN);
        }
    }
}
