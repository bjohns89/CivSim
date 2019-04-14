package com.stormy.studios.production;

import com.stormy.studios.faction.Faction;
import com.stormy.studios.manager.GameManager;
import com.stormy.studios.recipe.BuildingRecipe;
import com.stormy.studios.resource.ResourceStack;
import com.stormy.studios.util.NameBuilder;

import static com.stormy.studios.resource.Resource.FOOD;

public class Farm extends Production {

    public Farm(Faction faction) {
        super(faction);
        setName("farm");
        setActiveProduction(true);
        setMaxWorkers(2);
        setBuildingRecipe(BuildingRecipe.FARM_RECIPE);
        setTurnsToWork(3);
        nameBuilder = new NameBuilder(name);
        setTurnActivated(GameManager.WORLD_TURN);
    }

    @Override
    public void changeActiveRecipe() {

    }

    @Override
    public void doWork() {
        //  System.out.println(name + GameManager.WORLD_TURN + " " + getTurnActivated() + " " + 1 + (activeWorkers - 1));
        if (ableToWork()) {
            faction.addToResourceList(new ResourceStack(FOOD, 1 + (activeWorkers - 1)));
            setTurnActivated(GameManager.WORLD_TURN);
        }
    }
}
