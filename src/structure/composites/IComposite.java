package structure.composites;

import model.interfaces.IMotorized;
import model.interfaces.IMovable;

public interface IComposite <T extends IMovable>{
    void addComponent(T component);
    void removeComponent(T component);
}
