package com.stormy.studios.production;

import com.stormy.studios.faction.Faction;
import com.stormy.studios.manager.GameManager;
import com.stormy.studios.recipe.BuildingRecipe;
import com.stormy.studios.recipe.ItemRecipe;
import com.stormy.studios.util.NameBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Production {

    protected int turnsToWork, maxWorkers, activeWorkers = 0, turnActivated;
    protected Faction faction;
    protected List<ItemRecipe> possibleItemRecipes;
    protected BuildingRecipe recipe;
    protected ItemRecipe activeItemRecipe;
    protected boolean activeProduction, selectedHud = false;
    protected String name;
    protected NameBuilder nameBuilder;

    public Production(Faction faction) {
        this.faction = faction;
        possibleItemRecipes = new ArrayList<>();
    }

    public abstract void changeActiveRecipe();

    public abstract void doWork();

    public void changeWorkers(int amount) {
        activeWorkers += amount;
    }

    public boolean ableToWork() {
        return activeProduction && activeWorkers > 0 && GameManager.WORLD_TURN >= turnActivated + turnsToWork;
    }

    public Production setTurnActivated(int turnActivated) {
        this.turnActivated = turnActivated;
        return this;
    }

    public void setPossibleItemRecipes(ItemRecipe... possibleItemRecipes) {
        this.possibleItemRecipes = Arrays.asList(possibleItemRecipes);
    }

    //


    public int getTurnsToWork() {
        return turnsToWork;
    }

    public void setTurnsToWork(int turnsToWork) {
        this.turnsToWork = turnsToWork;
    }

    public int getMaxWorkers() {
        return maxWorkers;
    }

    public void setMaxWorkers(int maxWorkers) {
        this.maxWorkers = maxWorkers;
    }

    public int getActiveWorkers() {
        return activeWorkers;
    }

    public void setActiveWorkers(int activeWorkers) {
        this.activeWorkers = activeWorkers;
    }

    public int getTurnActivated() {
        return turnActivated;
    }

    public Faction getFaction() {
        return faction;
    }

    public void setFaction(Faction faction) {
        this.faction = faction;
    }

    public List<ItemRecipe> getPossibleItemRecipes() {
        return possibleItemRecipes;
    }

    public void setPossibleItemRecipes(List<ItemRecipe> possibleItemRecipes) {
        this.possibleItemRecipes = possibleItemRecipes;
    }

    public BuildingRecipe getRecipe() {
        return recipe;
    }

    public void setBuildingRecipe(BuildingRecipe recipe) {
        this.recipe = recipe;
    }

    public ItemRecipe getActiveItemRecipe() {
        return activeItemRecipe;
    }

    public void setActiveItemRecipe(ItemRecipe activeItemRecipe) {
        this.activeItemRecipe = activeItemRecipe;
    }

    public boolean isActiveProduction() {
        return activeProduction;
    }

    public void setActiveProduction(boolean activeProduction) {
        this.activeProduction = activeProduction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NameBuilder getNameBuilder() {
        return nameBuilder;
    }

    public void setNameBuilder(NameBuilder nameBuilder) {
        this.nameBuilder = nameBuilder;
    }
}
