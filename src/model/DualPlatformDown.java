package model;

import model.interfaces.IPlatform;

public class DualPlatformDown implements IPlatform {

    private IPlatform context;

    public DualPlatformDown(IPlatform context) {
        this.context = context;
    }

    @Override
    public void lower() {
        // ok if empty?
    }

    @Override
    public void lift() {
        setPlatformState(new DualPlatformUp(context));
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
