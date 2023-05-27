package ml.pkom.mcpitanlibarch.api.client.render.handledscreen;

import ml.pkom.mcpitanlibarch.api.client.render.DrawObjectDM;

public class RenderArgs {
    public DrawObjectDM drawObjectDM;
    public float delta;
    public int mouseX, mouseY;

    public RenderArgs(DrawObjectDM drawObjectDM, int mouseX, int mouseY, float delta) {
        setDrawObjectDM(drawObjectDM);
        setDelta(delta);
        setMouseX(mouseX);
        setMouseY(mouseY);
    }

    public void setDrawObjectDM(DrawObjectDM drawObjectDM) {
        this.drawObjectDM = drawObjectDM;
    }

    public void setDelta(float delta) {
        this.delta = delta;
    }

    public void setMouseX(int mouseX) {
        this.mouseX = mouseX;
    }

    public void setMouseY(int mouseY) {
        this.mouseY = mouseY;
    }

    public DrawObjectDM getDrawObjectDM() {
        return drawObjectDM;
    }

    public float getDelta() {
        return delta;
    }

    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }
}
