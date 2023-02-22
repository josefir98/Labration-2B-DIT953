package model;

import model.interfaces.IPlatForm;

public class DualPlatformDown implements IPlatForm {

    @Override
    public void lower() {

    }

    @Override
    public void lift() {
        if (getCurrentSpeed() == 0) {
            if (stage == 0 || stage == 1) {
                platformStage = stage;
            } else {
                throw new RuntimeException("This platforms has 2 stages, 0 and 1!");
            }
        } else {
            throw new RuntimeException("Generics.Vehicle must be still too change platform stage!");
        }
    }

    @Override
    public void gas() {

    }
}
