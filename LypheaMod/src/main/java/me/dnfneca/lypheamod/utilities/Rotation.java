package me.dnfneca.lypheamod.utilities;

public class Rotation {
    public static float normalizeAngle(float angle) {
        return (angle >= 0 ? angle : (360 - ((-angle) % 360))) % 360;
    }
}
