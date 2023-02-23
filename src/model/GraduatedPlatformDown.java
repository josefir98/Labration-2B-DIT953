package model;

import model.interfaces.IPlatform;

public class GraduatedPlatformDown implements IPlatform {

    private final IPlatform context;

    public GraduatedPlatformDown(IPlatform context) {
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
