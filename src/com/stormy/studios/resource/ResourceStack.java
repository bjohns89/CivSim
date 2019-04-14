package com.stormy.studios.resource;

public class ResourceStack {

    private double count;
    private Resource resource;

    public ResourceStack(Resource resource, int count) {
        this.count = count;
        this.resource = resource;
    }

    public String getResourceName() {
        return resource.getName();
    }

    public void increase(double count) {
        this.count += count;
    }


    public double getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @Override
    public String toString() {
        return resource.getName() + " " + count;
    }

}
