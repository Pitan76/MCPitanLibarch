package ml.pkom.mcpitanlibarch.api.client.render.handledscreen;

public class KeyEventArgs {
    public int keyCode, scanCode, modifiers;

    public KeyEventArgs(int keyCode, int scanCode, int modifiers) {
        setKeyCode(keyCode);
        setScanCode(scanCode);
        setModifiers(modifiers);
    }

    public void setKeyCode(int keyCode) {
        this.keyCode = keyCode;
    }

    public void setModifiers(int modifiers) {
        this.modifiers = modifiers;
    }

    public void setScanCode(int scanCode) {
        this.scanCode = scanCode;
    }

    public int getKeyCode() {
        return keyCode;
    }

    public int getModifiers() {
        return modifiers;
    }

    public int getScanCode() {
        return scanCode;
    }
}
