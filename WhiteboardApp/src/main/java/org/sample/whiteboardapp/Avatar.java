package org.sample.whiteboardapp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tjd3084
 */
public class Avatar  {
    public double positionX;
    public double positionY;
    public Prop prop;
    public String UserID;
    public String nickname;
    public String orientation = "up";
    public String name;
    public Boolean moving;
    public Avatar(double X, double Y, String nick){
        positionX = X;
        positionY = Y;
        nickname = nick;
        name = nick;
    }    
    public void moveAvatar(int x, int y,User user){
        moving = true;
        if(user.fast == true){       
            positionX = x;
            positionY = y;
        }
        else if(x - positionX == 0){
            while(positionY > y && moving == true){
                positionY = positionY + 1;
                
            }
        }
         else if(y - positionY == 0){
            while(positionX > x && moving == true){
                positionX = positionX + 1;
            }
        }
         else{
             double SpeedY = (1*(y - positionY)/(x - positionX));
             while(positionX > x && moving == true){
                positionX = positionX + 1;
                positionY = positionY + SpeedY;
            }
         }
    }
     public void setAvatarID(String id){
        UserID = id;
    }     
    public void placeAvatar(int x,int y, String id){
        positionX = x;
        positionY = y;
        UserID = id;
    }
    public void dropAvatar(){
        UserID = null;
    }    
   // public void clearAvatars(Stage stage){
        //do something. not part of sprint one.
    //} 
    public void stopAvatar(){
        moving = false;
    }
    public void setProp(Avatar avatar, Prop prop){
        avatar.prop = prop;
    }
}
