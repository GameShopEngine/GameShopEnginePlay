package com.gameshopcorp.gameshopengine;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.math.Vector4f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.texture.Image;
import com.jme3.texture.Texture;
import com.jme3.texture.Texture2D;
import com.jme3.texture.image.ColorSpace;
import com.jme3.util.BufferUtils;

import java.nio.ByteBuffer;
import java.util.logging.Logger;

/**
 * Created by potterec on 3/17/2016.
 */
public class Main extends SimpleApplication {

//    public static void main(String[] args) {
//        Main app = new Main();
//        app.start();
//    }

    @Override
    public void simpleInitApp() {


//        Box b = new Box(1, 1, 1);
//        Geometry geom = new Geometry("Box", b);
//
//        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
//        mat.setColor("Color", ColorRGBA.Blue);
//        geom.setMaterial(mat);
//
//        rootNode.attachChild(geom);

//
        //System.out.println("Max Texture size: " + GL11.glGetInteger(GL11.GL_MAX_TEXTURE_SIZE));

        this.viewPort.setBackgroundColor(ColorRGBA.White);

        GameShopATMS gameShopATMS = new GameShopATMS( new GameShopLayer((short)128,(short)128), new Vector4f[]{new Vector4f(0,1,0,1)});

        gameShopATMS.layer.drawCircle((short) 63, (short) 63, (short) 63, ColorRGBA.fromRGBA255(0,0,0,255));;

        int n = 25;
        GameShopCurrencyMesh[] cms = new GameShopCurrencyMesh[n];
        for (int i = 0; i < n; i++){
            byte depth = 2;
            GameShopCurrencyLine[] cl = new GameShopCurrencyLine[8];
            cl = new GameShopCurrencyLine[]{

                    new GameShopCurrencyLine(new Vector3f[]{new Vector3f(0,0,-i), new Vector3f(.33f, 0, -i), new Vector3f(.66f,0,-i), new Vector3f(1, 0, -i)}, depth),
                    new GameShopCurrencyLine(new Vector3f[]{new Vector3f(0,.33f,-i), new Vector3f(.33f, .33f, -i), new Vector3f(.66f,.33f,-i), new Vector3f(1, .33f, -i)}, depth),
                    new GameShopCurrencyLine(new Vector3f[]{new Vector3f(0,.66f,-i), new Vector3f(.33f, .66f, -i), new Vector3f(.66f,.66f,-i), new Vector3f(1, .66f, -i)}, depth),
                    new GameShopCurrencyLine(new Vector3f[]{new Vector3f(0,1,-i), new Vector3f(.33f, 1, -i), new Vector3f(.66f,1,-i), new Vector3f(1, 1, -i)}, depth),

                    new GameShopCurrencyLine(new Vector3f[]{new Vector3f(1,0,-i), new Vector3f(1.33f, 0, -i), new Vector3f(1.66f,0,-i), new Vector3f(2, 0, -i)}, depth),
                    new GameShopCurrencyLine(new Vector3f[]{new Vector3f(1,.33f,-i), new Vector3f(1.33f, .33f, -i), new Vector3f(1.66f,.33f,-i), new Vector3f(2, .33f, -i)}, depth),
                    new GameShopCurrencyLine(new Vector3f[]{new Vector3f(1,.66f,-i), new Vector3f(1.33f, .66f, -i), new Vector3f(1.66f,.66f,-i), new Vector3f(2, .66f, -i)}, depth),
                    new GameShopCurrencyLine(new Vector3f[]{new Vector3f(1,1,-i), new Vector3f(1.33f, 1, -i), new Vector3f(1.66f,1,-i), new Vector3f(2, 1, -i)}, depth)


            };

            cms[i] = new GameShopCurrencyMesh(this, cl, gameShopATMS,this.getRootNode());
            //SimpleMesh sm = new SimpleMesh(this, new Vector3f[]{}, new Vector2f[]{}, makeTexture(), this.getRootNode());
        }
//
//        int n = 200;
//        CurrencyMesh[] cms = new CurrencyMesh[n];
//        for (int i = 0; i < n; i++){
//          byte depth = 16;
//          GameShopCurrencyLine[] cl = new GameShopCurrencyLine[4];
//          cl = new GameShopCurrencyLine[]{
//
//              new GameShopCurrencyLine(new Vector3f[]{new Vector3f(0,0,-i), new Vector3f(.33f, 0, -i), new Vector3f(.66f,0,-i), new Vector3f(1, 0, -i)}, depth),
//              new GameShopCurrencyLine(new Vector3f[]{new Vector3f(0,.33f,-i), new Vector3f(.33f, .33f, -i), new Vector3f(.66f,.33f,-i), new Vector3f(1, .33f, -i)}, depth),
//              new GameShopCurrencyLine(new Vector3f[]{new Vector3f(0,.66f,-i), new Vector3f(.33f, .66f, -i), new Vector3f(.66f,.66f,-i), new Vector3f(1, .66f, -i)}, depth),
//              new GameShopCurrencyLine(new Vector3f[]{new Vector3f(0,1,-i), new Vector3f(.33f, 1, -i), new Vector3f(.66f,1,-i), new Vector3f(1, 1, -i)}, depth)
//          };
//
//          cms[i] = new CurrencyMesh(this, cl, makeTexture(""),this.getRootNode());
//          //SimpleMesh sm = new SimpleMesh(this, new Vector3f[]{}, new Vector2f[]{}, makeTexture(), this.getRootNode());
//        }
//
//         GeometryBatchFactory.optimize(getRootNode());


        long maxMemory = Runtime.getRuntime().maxMemory();
        long allocatedMemory = Runtime.getRuntime().totalMemory();
        long freeMemory = Runtime.getRuntime().freeMemory();

        System.out.println("max: " + maxMemory);
        System.out.println("allocated: " + allocatedMemory);
        System.out.println("free: " + freeMemory);
        //44098840
    }

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }

    public Texture2D makeTexture(String side){
        GameShopLayer layer= new GameShopLayer((short) 128, (short) 128);
        layer.drawCircle((short) 64, (short) 64, (short) 64, ColorRGBA.fromRGBA255(255,215,175,255));

        //DRILL COLOR CODE
        // layer.drawCircle((short) 63, (short) 63, (short) 128, ColorRGBA.fromRGBA255(0,0,0,255));

        ATMS atms = new ATMS((byte) 1, layer);
        //atmsFront.frames[0] = layerFront;
        ByteBuffer data = BufferUtils.createByteBuffer(atms.frames[0].outputLayer());
        // ByteBuffer data = BufferUtils.createByteBuffer((byte)0,(byte)127,(byte)0,(byte)62);
        Image image = new Image(Image.Format.RGBA8, 128, 128, data, ColorSpace.Linear);
        return new Texture2D(image);
    }
}
