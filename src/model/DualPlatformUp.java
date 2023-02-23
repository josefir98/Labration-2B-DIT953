package model;

import model.interfaces.IPlatform;

public class DualPlatformUp implements IPlatform {

    private IPlatform context;

    public DualPlatformUp(IPlatform context) {
        this.context = context;
    }

    @Override
    public void lower() {
        setPlatformState(new DualPlatformDown(context));
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
}
