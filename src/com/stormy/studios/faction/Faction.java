package com.stormy.studios.faction;

import com.stormy.studios.production.Farm;
import com.stormy.studios.production.LumberMill;
import com.stormy.studios.production.Production;
import com.stormy.studios.production.Quarry;
import com.stormy.studios.resource.ResourceStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.stormy.studios.manager.GameManager.WORLD_TURN;
import static com.stormy.studios.resource.Resource.FOOD;

public class Faction {

    private final double food = 0.25;

    private int workers = 3, pop = workers;
    private String name;
    private HashMap<String, ResourceStack> resourceStackHashMap;
    private List<Production> productionList;

    public Faction(String name) {
        this.name = name;
        productionList = new ArrayList();
        resourceStackHashMap = new HashMap<>();
        initResource();
    }

    private void initResource() {
        addToResourceList(new ResourceStack(FOOD, 4));
        addProduction(new Farm(this));
        addProduction(new LumberMill(this));
        addProduction(new Quarry(this));
    }

    public void run() {
        for (Production production : productionList) {
            production.doWork();
        }

    }

    public void addProduction(Production production) {
        productionList.add(production.setTurnActivated(WORLD_TURN));
    }


    public HashMap<String, ResourceStack> getResourceStackHashMap() {
        return resourceStackHashMap;
    }

    public void addToResourceList(ResourceStack resourceStack) {
        if (resourceStackHashMap.get(resourceStack.getResourceName()) == null) {
            resourceStackHashMap.put(resourceStack.getResourceName(), resourceStack);
        } else {
            double count = resourceStack.getCount();
            resourceStackHashMap.get(resourceStack.getResourceName()).increase(count);
        }
    }

    public void changeWorkers(int amount) {
        workers += amount;
    }

    public int getWorkers() {
        return workers;
    }

    public List<Production> getProductionList() {
        return productionList;
    }
}