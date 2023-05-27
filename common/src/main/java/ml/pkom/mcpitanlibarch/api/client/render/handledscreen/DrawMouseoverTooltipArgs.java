package ml.pkom.mcpitanlibarch.api.client.render.handledscreen;

import ml.pkom.mcpitanlibarch.api.client.render.DrawObjectDM;

public class DrawMouseoverTooltipArgs {
    public DrawObjectDM drawObjectDM;
    public int mouseX, mouseY;

    public DrawMouseoverTooltipArgs(DrawObjectDM drawObjectDM, int mouseX, int mouseY) {
        setDrawObjectDM(drawObjectDM);
        setMouseX(mouseX);
        setMouseY(mouseY);
    }

    public void setDrawObjectDM(DrawObjectDM drawObjectDM) {
        this.drawObjectDM = drawObjectDM;
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

    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }
}
