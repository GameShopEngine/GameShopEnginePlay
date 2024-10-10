//package com.mygame;
//
//import com.jme3.app.SimpleApplication;
//import com.jme3.math.Vector2f;
//import com.jme3.math.Vector3f;
//import com.jme3.scene.Node;
//import com.jme3.scene.VertexBuffer;
//import com.jme3.texture.Texture;
//import com.jme3.texture.Texture2D;
//import com.jme3.util.BufferUtils;
//
//import java.nio.ByteBuffer;
//public class CurrencyMesh {
//
//    public GameShopCurrencyLine[] vInfinitesimals;
//    public SimpleMesh[] simpleMeshes;
//
//    public GameShopCurrencyLine[] currencyLines;
//    public float width;
//    public float height;
//
//    public float dim;
//
//    SimpleApplication app;
//
//    Texture2D texture;
//    Node node;
//
//    public CurrencyMesh(SimpleApplication app, GameShopCurrencyLine[] currencyLines, Texture2D texture, Node node){
//
//        this.app = app;
//        this.currencyLines = currencyLines;
//        this.texture = texture;
//        this.node = node;
//
//        setDimensions();
//        setImageArray();
//        drawSimpleMeshes();
//
//    }
//
//    public void updateTexture(Texture2D texture){
//        this.texture = texture;
//    }
//    public SimpleMesh getMeshFromValue(int x, int y){
//
//        return  simpleMeshes[(this.vInfinitesimals[0].infinitesimals.length * x) + y];
//    }
//
//    public void modCurrencyLine(byte line, byte point, Vector3f newPoint){
//        this.currencyLines[line].modCurrency(point, newPoint);
//        for (int i = 0; i < this.vInfinitesimals.length; i++){
//
//            this.vInfinitesimals[i].modCurrency((byte) 0, currencyLines[0].infinitesimals[i]); ;//= new CurrencyLine(new Vector3f[]{currencyLines[0].infinitesimals[i], currencyLines[1].infinitesimals[i], currencyLines[2].infinitesimals[i], currencyLines[3].infinitesimals[i]}, (byte)16);
//            this.vInfinitesimals[i].modCurrency((byte) 1, currencyLines[1].infinitesimals[i]);
//            this.vInfinitesimals[i].modCurrency((byte) 2, currencyLines[2].infinitesimals[i]);
//            this.vInfinitesimals[i].modCurrency((byte) 3, currencyLines[3].infinitesimals[i]);
//        }
//        updateSimpleMeshes();
//    }
//
//    public void updateSimpleMeshes(){
//
//        int maxX = this.vInfinitesimals[0].infinitesimals.length - 1;
//        int maxY = this.vInfinitesimals.length - 1;
//        for (int y = 0; y < maxY; y++){
//            for (int x = 0; x < maxX; x++){
//
//                Vector3f[] simpleMesh = new Vector3f[4];
//
//                simpleMesh[0] = this.vInfinitesimals[y].infinitesimals[x];
//                simpleMesh[1] = this.vInfinitesimals[y + 1].infinitesimals[x];
//                simpleMesh[2] = this.vInfinitesimals[y].infinitesimals[x + 1];
//                simpleMesh[3] = this.vInfinitesimals[y + 1].infinitesimals[x + 1];
//                Vector2f[] texCoord = new Vector2f[4];
//
//                Vector2f distance = new Vector2f(((this.vInfinitesimals[maxY].infinitesimals[maxX].x) - (this.vInfinitesimals[0].infinitesimals[0].x)), ((this.vInfinitesimals[maxY].infinitesimals[maxX].y) - (this.vInfinitesimals[0].infinitesimals[0].y)));
//                Vector2f base = new Vector2f(this.vInfinitesimals[0].infinitesimals[0].x, this.vInfinitesimals[0].infinitesimals[0].y);
//
//                texCoord[0] = new Vector2f( new Vector2f(((this.vInfinitesimals[y].infinitesimals[x].x) - base.x) / distance.x,(this.vInfinitesimals[y].infinitesimals[x].y - base.y)/distance.y)); // new Vector2f(0,0);
//                texCoord[1] = new Vector2f( new Vector2f(((this.vInfinitesimals[y + 1].infinitesimals[x].x) - base.x) / distance.x,(this.vInfinitesimals[y + 1].infinitesimals[x].y - base.y )/distance.y));//new Vector2f(1,0);
//                texCoord[2] = new Vector2f( new Vector2f(((this.vInfinitesimals[y].infinitesimals[x + 1].x) - base.x) / distance.x,(this.vInfinitesimals[y].infinitesimals[x + 1].y - base.y)/distance.y));//new Vector2f(0,1);
//                texCoord[3] = new Vector2f( new Vector2f(((this.vInfinitesimals[y + 1].infinitesimals[x + 1].x) - base.x)/distance.x,(this.vInfinitesimals[y + 1].infinitesimals[x + 1].y - base.y)/distance.y));//new Vector2f(1,1);
//
//                simpleMeshes[(this.vInfinitesimals[0].infinitesimals.length * y) + x].texCoord = texCoord;
//                simpleMeshes[(this.vInfinitesimals[0].infinitesimals.length * y) + x].vertices = simpleMesh;
//
//                simpleMeshes[(this.vInfinitesimals[0].infinitesimals.length * y) + x].m.setBuffer(VertexBuffer.Type.Position, 3, BufferUtils.createFloatBuffer(simpleMeshes[(this.vInfinitesimals[0].infinitesimals.length * y) + x].vertices));
//                simpleMeshes[(this.vInfinitesimals[0].infinitesimals.length * y) + x].m.setBuffer(VertexBuffer.Type.TexCoord, 2, BufferUtils.createFloatBuffer(simpleMeshes[(this.vInfinitesimals[0].infinitesimals.length * y) + x].texCoord));
//                //m.setBuffer(VertexBuffer.Type.Index, 1, BufferUtils.createShortBuffer(indexes));
//
//                simpleMeshes[(this.vInfinitesimals[0].infinitesimals.length * y) + x].m.updateBound();
//
//                //simpleMeshes[(this.vInfinitesimals[0].infinitesimals.length * y) + x].geom.updateModelBound();
//
//
//
//
//            }
//        }
//    }
//
//    public void setDimensions(){
//
//        this.dim = 3;
//
//        width = currencyLines[0].points[currencyLines[0].points.length - 1].x - currencyLines[0].points[0].x;
//        height = currencyLines[currencyLines.length - 1].points[0].y - currencyLines[0].points[0].y;
//        this.vInfinitesimals = new GameShopCurrencyLine[currencyLines[0].infinitesimals.length];
//
//        for (int i = 0; i < this.vInfinitesimals.length; i++){
//
//            this.vInfinitesimals[i] = new GameShopCurrencyLine(new Vector3f[]{currencyLines[0].infinitesimals[i], currencyLines[1].infinitesimals[i], currencyLines[2].infinitesimals[i], currencyLines[3].infinitesimals[i]}, (byte)16);
//
//        }
//    }
//
//    public void setImageArray(){
//        int imageArray = 1;
//
//        width = this.vInfinitesimals.length;
//        height = this.vInfinitesimals[0].infinitesimals.length;
//
//        imageArray = (int)width * (int)height;
//
//        simpleMeshes = new SimpleMesh[imageArray];
//    }
//    public void drawSimpleMeshes(){
//        int maxX = this.vInfinitesimals[0].infinitesimals.length - 1;
//        int maxY = this.vInfinitesimals.length - 1;
//        for (int y = 0; y < maxY; y++){
//            for (int x = 0; x < maxX; x++){
//
//                Vector3f[] simpleMesh = new Vector3f[4];
//
//                simpleMesh[0] = this.vInfinitesimals[y].infinitesimals[x];
//                simpleMesh[1] = this.vInfinitesimals[y + 1].infinitesimals[x];
//                simpleMesh[2] = this.vInfinitesimals[y].infinitesimals[x + 1];
//                simpleMesh[3] = this.vInfinitesimals[y + 1].infinitesimals[x + 1];
//                Vector2f[] texCoord = new Vector2f[4];
//
//                Vector2f distance = new Vector2f(((this.vInfinitesimals[maxY].infinitesimals[maxX].x) - (this.vInfinitesimals[0].infinitesimals[0].x)), ((this.vInfinitesimals[maxY].infinitesimals[maxX].y) - (this.vInfinitesimals[0].infinitesimals[0].y)));
//                Vector2f base = new Vector2f(this.vInfinitesimals[0].infinitesimals[0].x, this.vInfinitesimals[0].infinitesimals[0].y);
//
//                texCoord[0] = new Vector2f( new Vector2f(((this.vInfinitesimals[y].infinitesimals[x].x) - base.x) / distance.x,(this.vInfinitesimals[y].infinitesimals[x].y - base.y)/distance.y)); // new Vector2f(0,0);
//                texCoord[1] = new Vector2f( new Vector2f(((this.vInfinitesimals[y + 1].infinitesimals[x].x) - base.x) / distance.x,(this.vInfinitesimals[y + 1].infinitesimals[x].y - base.y )/distance.y));//new Vector2f(1,0);
//                texCoord[2] = new Vector2f( new Vector2f(((this.vInfinitesimals[y].infinitesimals[x + 1].x) - base.x) / distance.x,(this.vInfinitesimals[y].infinitesimals[x + 1].y - base.y)/distance.y));//new Vector2f(0,1);
//                texCoord[3] = new Vector2f( new Vector2f(((this.vInfinitesimals[y + 1].infinitesimals[x + 1].x) - base.x)/distance.x,(this.vInfinitesimals[y + 1].infinitesimals[x + 1].y - base.y)/distance.y));//new Vector2f(1,1);
//
//                simpleMeshes[(this.vInfinitesimals[0].infinitesimals.length * y) + x] = new SimpleMesh(app, simpleMesh, texCoord, texture, node);
//
//            }
//        }
//    }
//}
