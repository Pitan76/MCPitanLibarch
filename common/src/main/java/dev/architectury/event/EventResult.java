package dev.architectury.event;

public class EventResult {
    public static me.shedaniel.architectury.event.EventResult pass() {
        return me.shedaniel.architectury.event.EventResult.pass();
    }

    public static me.shedaniel.architectury.event.EventResult interrupt(Boolean value) {
        return me.shedaniel.architectury.event.EventResult.interrupt(value);
    }

    public static me.shedaniel.architectury.event.EventResult interruptTrue() {
        return me.shedaniel.architectury.event.EventResult.interruptTrue();
    }

    public static me.shedaniel.architectury.event.EventResult interruptDefault() {
        return me.shedaniel.architectury.event.EventResult.interruptDefault();
    }

    public static me.shedaniel.architectury.event.EventResult interruptFalse() {
        return me.shedaniel.architectury.event.EventResult.interruptFalse();
    }
}
