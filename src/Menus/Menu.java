package Menus;

import GameFrameWork.Buttons.Button;
import GameFrameWork.PanelTextBox;
import GameFrameWork.Window;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by citim on 5/10/2017.
 */
public abstract class Menu {
    public ArrayList<Button> buttons = new ArrayList<>();
    public ArrayList<GameFrameWork.Panel> panels = new ArrayList<>();


    public Menu(){
        buttons.add(new Button(0,0,0,0,""));
    }
    public void displayAll(){
        Window.window.paint(Window.window.getGraphics());
        Window.window.getGraphics().setColor(Color.black);
        Window.window.getGraphics().fillRect(0,0,1280,720);
        displayButtons();
        displayPanels();
    }
    public void displayButtons(){
        Window.window.getGraphics().setColor(Color.white);
        for (int scan = 0; scan < buttons.size(); scan++)
            buttons.get(scan).displayButton();
    }
    public void voidButtons(Button button){
        for (int scan = 0;buttons.size() > scan; scan++){
            if(buttons.get(scan) == button){
                buttons.remove(scan);
                scan--;
            }
        }
    }
    public void voidButtons(ArrayList<Button> buttons){
        for(int scan = 0; scan < buttons.size(); scan++){
            voidButtons(buttons.get(scan));
        }
    }
    public void voidButtons(){
        buttons = new ArrayList<>();
        buttons.add(new Button(0,0,0,0,""));
    }
    public void questionButtons(){ //questions for menu buttons first, then component buttons

        for (int scan = 0; scan < buttons.size(); scan++)
            buttons.get(scan).questionClicked();
        questionPressed();

        for(int scan = 0; scan < panels.size(); scan++){
            panels.get(scan).questionButtons();
        }
    }
    public abstract void questionPressed();//should loop through the buttons you may have clicked.(excludes the value of buttons.get(0)


//    public void questionPressed(){ //this is a template. an if scan== x is needed per button
//        for (int scan = 1; scan < buttons.size(); scan++) {
//        if(buttons.get(scan).clicked) {
//            if (scan == 1) {
//                //some code here
//                break;
//            }
//        }
//    }
//}

    public void displayPanels(){
        for(int scan = 0; scan < panels.size(); scan++){
            panels.get(scan).display();
        }
    }
}
