package be.vdab.ponos.featuretoggle.toggle;

public enum Feature {

    SEND_MESSAGES_OVER_AXON,
    CALCULATOR_V2;

    private boolean enabled;

    Feature() {
        this.enabled = false;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void enable() {
        this.enabled = true;
    }

    public void disable() {
        this.enabled = false;
    }
}
