package model.platform;

/**
 * Interface for things that have a platform
 */
public interface IPlatform {
    void lower();
    void lift();
    void setPlatformState(IPlatform state);
    IPlatform getPlatformState();

    boolean isDown();
}
