/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gameshopcorp.gameshopengine;

import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector4f;
import com.jme3.texture.Image;
import com.jme3.texture.Texture2D;
import com.jme3.texture.image.ColorSpace;
import com.jme3.util.BufferUtils;

import java.nio.ByteBuffer;

/**
 *
 * @author chrx
 */
public class GameShopATMS {
    
    
    public GameShopLayer layer;
    public Vector4f[] textureSamples;

    public GameShopATMS(GameShopLayer layer, Vector4f[] textureSamples){

//        frames = new GameShopLayer[layers.length];
//        frames = layers;
        //this.layer = new GameShopLayer(layer.width, layer.height);
        this.layer = layer;
        this.textureSamples = new Vector4f[textureSamples.length];
        this.textureSamples = textureSamples;
    }


    public Texture2D makeTexture(){
        //16384
        //8192
        //4096
        //2048
        //1024
        //512
//        GameShopLayer layer= new GameShopLayer((short) 1024, (short) 1024);
//        layer.drawCircle((short) 512, (short) 512, (short) 512, ColorRGBA.fromRGBA255(255,215,175,255));
//
//        //DRILL COLOR CODE
//        // layer.drawCircle((short) 63, (short) 63, (short) 128, ColorRGBA.fromRGBA255(0,0,0,255));
//
//        ATMS atms = new ATMS((byte) 1, layer);
        //atmsFront.frames[0] = layerFront;
        ByteBuffer data = BufferUtils.createByteBuffer(this.layer.outputLayer());
        // ByteBuffer data = BufferUtils.createByteBuffer((byte)0,(byte)127,(byte)0,(byte)62);
        Image image = new Image(Image.Format.RGBA8 , this.layer.width, this.layer.height, data, ColorSpace.Linear);
        return new Texture2D(image);
    }
//    public void changeColor (ColorRGBA colorFrom, ColorRGBA colorTo){
//
//        for (GameShopLayer frame: frames){
//            for (short y = 0; y < frame.height; y++){
//
//                for (short x = 0; x < frame.width; x++){
//
//                    if (frame.layer[y][x * 4] == (byte) (colorFrom.getColorArray()[0] * 255) &&
//                            frame.layer[y][(x * 4) + 1] == (byte) (colorFrom.getColorArray()[1] * 255) &&
//                            frame.layer[y][(x * 4) + 2] == (byte) (colorFrom.getColorArray()[2] * 255) &&
//                            frame.layer[y][(x * 4) + 3] == (byte) (colorFrom.getColorArray()[3] * 255)
//                    ){
//
//                        frame.layer[y][x * 4] = (byte) (colorTo.getColorArray()[0] * 255);
//                                frame.layer[y][(x * 4) + 1] = (byte) (colorTo.getColorArray()[1] * 255);
//                                frame.layer[y][(x * 4) + 2] = (byte) (colorTo.getColorArray()[2] * 255);
//                                frame.layer[y][(x * 4) + 3] = (byte) (colorTo.getColorArray()[3] * 255);
//                    }
//                }
//            }
//        }
//    }
}
