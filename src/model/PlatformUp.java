package model;

import model.interfaces.IPlatform;

public class PlatformUp implements IPlatform {

    private final IPlatform context;

    public PlatformUp(IPlatform context) {
        this.context = context;
    }

    @Override
    public void lower() {
        setPlatformState(new PlatformDown(context));
    }

    @Override
    public void lift() {
        // ok if empty?
    }

    @Override
    public void setPlatformState(IPlatform state) {
        context.setPlatformState(state);
    }

    @Override
    public IPlatform getPlatformState() {
        return this;
    }

    @Override
    public boolean isDown() {
        return false;
    }
}
