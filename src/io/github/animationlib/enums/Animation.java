package io.github.animationlib.enums;

public enum Animation {
    SWING_ARM(0),
    TAKE_DAMAGE(1),
    LEAVE_BED(2),
    EAT_FOOD(3),
    CRITICAL_EFFECT(4),
    MAGIC_CRITICAL_EFFECT(5);
    public int i;
    Animation(int i) {
        this.i = i;
    }
}
