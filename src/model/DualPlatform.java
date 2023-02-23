package model;

import model.interfaces.IPlatform;

public class DualPlatform implements IPlatform {

    private IPlatform context;

    public DualPlatform(IPlatform context) {
        this.context = context;
    }

    @Override
    public void lower() {
        context.lower();
    }

    @Override
    public void lift() {
        context.lift();
    }

    @Override
    public void setPlatformState(IPlatform state) {
        context = state;
    }

    @Override
    public IPlatform getPlatformState() {
        return context.getPlatformState();
    }

    @Override
    public boolean isDown() {
        return context.isDown();
    }
}
