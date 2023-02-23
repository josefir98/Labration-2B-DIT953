package model;

import model.interfaces.IPlatform;

public class GraduatedPlatformUp implements IPlatform {

    private final IPlatform context;

    public GraduatedPlatformUp(IPlatform context) {
        this.context = context;
    }

    @Override
    public void lower() {
        setPlatformState(new DualPlatformDown(context));
    }

    @Override
    public void lift() {
        //TODO ok if empty?
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
