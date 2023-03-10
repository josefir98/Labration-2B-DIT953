package model.platform;

public class GraduatedPlatform implements IGraduatedPlatform {
    private IPlatform context;
    private final int MAX_ANGLE = 70;
    private int angle;

    public GraduatedPlatform(PlatformUp context) {
        this.context = context;
        this.angle = MAX_ANGLE;
    }

    public GraduatedPlatform(PlatformDown context) {
        this.context = context;
        this.angle = 0;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int newAngle) {
        if (angle < 0 || angle > MAX_ANGLE) {
            throw new RuntimeException("The specified angle must be between 0 and 70 degrees!");
        } else if (newAngle == 0) {
            setPlatformState(new PlatformDown(this));
        } else {
            setPlatformState(new PlatformUp(this));
        }
        angle = newAngle;
    }

    @Override
    public void lower() {
        if (angle > 0) {
            context.lower();
            angle--;
        }
    }

    @Override
    public void lift() {
        if (angle < MAX_ANGLE) {
            context.lift();
            angle++;
        }
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
