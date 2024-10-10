package com.gameshopcorp.gameshopengine;
import com.jme3.math.ColorRGBA;
import com.jme3.texture.Texture2D;

public class ATMS {

    public GameShopLayer[] frames;


    public ATMS(byte amountFrames, GameShopLayer... layers){

        frames = new GameShopLayer[amountFrames];
        frames = layers;
    }

    public void changeColor (ColorRGBA colorFrom, ColorRGBA colorTo){

        for (GameShopLayer frame: frames){
            for (short y = 0; y < frame.height; y++){

                for (short x = 0; x < frame.width; x++){

                    if (frame.layer[y][x * 4] == (byte) (colorFrom.getColorArray()[0] * 255) &&
                            frame.layer[y][(x * 4) + 1] == (byte) (colorFrom.getColorArray()[1] * 255) &&
                            frame.layer[y][(x * 4) + 2] == (byte) (colorFrom.getColorArray()[2] * 255) &&
                            frame.layer[y][(x * 4) + 3] == (byte) (colorFrom.getColorArray()[3] * 255)
                    ){

                        frame.layer[y][x * 4] = (byte) (colorTo.getColorArray()[0] * 255);
                                frame.layer[y][(x * 4) + 1] = (byte) (colorTo.getColorArray()[1] * 255);
                                frame.layer[y][(x * 4) + 2] = (byte) (colorTo.getColorArray()[2] * 255);
                                frame.layer[y][(x * 4) + 3] = (byte) (colorTo.getColorArray()[3] * 255);
                    }
                }
            }
        }
    }
}
