package me.dnfneca.lypheamod.util;

public class Rotation {
    public static float normalizeAngle(float angle) {
        return (angle >= 0 ? angle : (360 - ((-angle) % 360))) % 360;
    }
}
