/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Random;
import main.GamePanel;

/**
 *
 * @author tranbachtung
 */
public class NPC_OldMan extends Entity{
    
    public NPC_OldMan(GamePanel gp){
        super(gp);
        
        direction ="down";
        speed = 1;
        
        dialogueSet = -1;
        
        getImage();
        setDialogue();
    }
    public void getImage(){
        
        up1 = setup("/npc/oldman_up_1", gp.tileSize, gp.tileSize);
        up2 = setup("/npc/oldman_up_2", gp.tileSize, gp.tileSize);
        down1 = setup("/npc/oldman_down_1", gp.tileSize, gp.tileSize);
        down2 = setup("/npc/oldman_down_2", gp.tileSize, gp.tileSize);
        left1 = setup("/npc/oldman_left_1", gp.tileSize, gp.tileSize);
        left2 = setup("/npc/oldman_left_2", gp.tileSize, gp.tileSize);
        right1 = setup("/npc/oldman_right_1", gp.tileSize, gp.tileSize);
        right2 = setup("/npc/oldman_right_2", gp.tileSize, gp.tileSize);
        
    }
    
    public void setDialogue(){
        
        dialogues[0][0] = "Hello adventure!";
        dialogues[0][1] = "So you've come to this island to find the treasure?";
        dialogues[0][2] = "I used to be a great wizard but now... \nI'm a bit too old for taking an adventure.";
        dialogues[0][3] = "Well, good luck on you.";
                
        dialogues[1][0] = "If you become tired, rest at the water.";
        dialogues[1][1] = "However the monster may appear while you are \nresting, so be careful.";
        dialogues[1][2] = "In any case, don't push yourself too hard.";
        
        dialogues[2][0] = "I wonder how to open that door...";
        
        
    }
    
    public void setAction(){
        
        actionLockCounter++;
        
        if(actionLockCounter == 100){
            Random random = new Random();
            int i = random.nextInt(100)+1; // pick a number from 1 to 100
            if(i <= 25){
                direction = "up";
            }
            if(i > 25 && i <= 50){
                direction = "down";
            }
            if(i > 50 && i <= 75){
                direction = "left";
            }
            if(i > 75 && i <= 100){
                direction = "right";
            }
            
            actionLockCounter = 0;
        }
        
    }
    
    public void speak(){
        // Do this character specific stuff
        
        facePlayer();
        startDialogue(this,dialogueSet);
        
        dialogueSet++;
        
        if(dialogues[dialogueSet][0] == null){
            
            dialogueSet-- ;
        }
        
    }
}
