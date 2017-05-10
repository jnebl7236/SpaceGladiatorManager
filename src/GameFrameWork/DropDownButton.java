package GameFrameWork;

import java.util.ArrayList;

/**
 * Created by citim on 5/9/2017.
 */
public class DropDownButton extends Button {
    String[] buttonNames;
    ArrayList <Button> buttons = new ArrayList<>();
    boolean open = false;
    public DropDownButton(int x, int y, int xDimesion, int yDimension, String name,String[] buttons){
        super(x,y,xDimesion,yDimension,name);
        buttonNames = buttons;
    }
    public boolean questionClicked(){
        if  ((Window.window.xClick > x &&
                Window.window.xClick < x+xDimesion )&&
                (Window.window.yClick > y &&
                        Window.window.yClick < y+yDimension)) {
            if(!open)
            displayDrop();
            else
                voidDrop();
            return true;
        }
        return false;
    }
    public void displayDrop(){
        for(int scan = 0; scan < this.buttonNames.length; scan++) {
            buttons.add(new Button(x, 2 * y + scan * (yDimension + 2), xDimesion, yDimension, buttonNames[scan]));
            //make window display this
        }
            Window.window.buttons.addAll(buttons);
            Window.window.displayButtons();
            open = true;
        }

    public void voidDrop(){
        Window.window.voidButtons(buttons);
        Window.window.displayButtons();
        buttons = new ArrayList<>();
        open = false;
    }
}