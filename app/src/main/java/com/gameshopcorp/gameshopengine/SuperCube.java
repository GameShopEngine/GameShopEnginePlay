//package com.mygame;
////import com.gameshopcorp.heroes.graphics.ATMS;
////import com.gameshopcorp.heroes.graphics.CurrencyLine;
////import com.gameshopcorp.heroes.graphics.CurrencyMesh;
////import com.gameshopcorp.heroes.graphics.Layer;
//import com.jme3.app.SimpleApplication;
//import com.jme3.math.ColorRGBA;
//import com.jme3.math.FastMath;
//import com.jme3.math.Vector3f;
//import com.jme3.scene.Node;
//import com.jme3.texture.Image;
//import com.jme3.texture.Texture2D;
//import com.jme3.texture.image.ColorSpace;
//import com.jme3.util.BufferUtils;
//
//import java.nio.ByteBuffer;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Objects;
//
//public class SuperCube {
//
//    public HashMap<String, CurrencyMesh> sides;
//    SimpleApplication app;
//
//    HashMap<String, GameShopCurrencyLine> edges;
//    public Vector3f axis;
//    Node node;
//
//    //public HashMap<String, Vector3f> imports;
//    public HashMap<String, Vector3f[]> exports;
//    public String[] renderSides;
//    public SuperCube(SimpleApplication app, Vector3f axis, Node node, HashMap<String, Vector3f> imports, String[] renderSides){
//
//
//        this.app = app;
//        this.axis = axis.add(new Vector3f(axis));
//        this.node = node;
//        this.sides = new HashMap<>();
//        this.exports = new HashMap<>();
//        this.renderSides = renderSides;
//        this.edges = new HashMap<>();
//
//        Vector3f[] corners = new Vector3f[8];
//
//        if (imports == null){
//            corners = new Vector3f[]{
//                    //Front:0
//                    axis.add(new Vector3f(0,-0,0)),axis.add(new Vector3f(0,3f,0)), axis.add(new Vector3f(3,3,0)),axis.add(new Vector3f(3,-0,0)),
//                    //Back:4
//                    axis.add(new Vector3f(0,0,-3)), axis.add(new Vector3f(0,3,-3)),axis.add(new Vector3f(3,3,-3)), axis.add(new Vector3f(3,0,-3))};
//        } else {
//            corners = new Vector3f[]{
//                    //Front:0
//                    imports.get("frontBottomLeft"),imports.get("frontTopLeft"), imports.get("frontTopRight"),imports.get("frontBottomRight"),
//                    //Back:4
//                    imports.get("backBottomLeft"), imports.get("backTopLeft"),imports.get("backTopRight"), imports.get("backBottomRight")};
//
//        }
//        addEdgeCurrencyLines(corners);
//
//        if (Arrays.asList(renderSides).contains("all")) {
//            addFront();
//            addBack();
//            addRight();
//            addLeft();
//            addTop();
//            addBottom();
//        } else {
//
//            if (Arrays.asList(renderSides).contains("front")){
//                addFront();
//            }
//            if (Arrays.asList(renderSides).contains("back")){
//                addBack();
//            }
//            if (Arrays.asList(renderSides).contains("right")){
//                addRight();
//            }
//            if (Arrays.asList(renderSides).contains("left")){
//                addLeft();
//            }
//            if (Arrays.asList(renderSides).contains("top")){
//                addTop();
//            }
//            if (Arrays.asList(renderSides).contains("bottom")){
//                addBottom();
//            }
//
//        }
//    }
//    public void addEdgeCurrencyLines(Vector3f[] corners){
//
//        //Top Of Head
//        edges.put("frontTop", new GameShopCurrencyLine(new Vector3f[]{ corners[1], FastMath.interpolateLinear(.33f, corners[1], corners[2]), FastMath.interpolateLinear(.66f, corners[1], corners[2]), corners[2]}, (byte) 16));
//
//        //Chin
//        edges.put("frontBottom", new GameShopCurrencyLine(new Vector3f[]{corners[0], FastMath.interpolateLinear(.33f, corners[0], corners[3]), FastMath.interpolateLinear(.66f, corners[0], corners[3]), corners[3]}, (byte) 16));
//
//        edges.put("frontRight", new GameShopCurrencyLine(new Vector3f[]{corners[0],FastMath.interpolateLinear(.33f, corners[0], corners[1]) , FastMath.interpolateLinear(.66f, corners[0], corners[1]),corners[1]}, (byte) 16));
//        edges.put("frontLeft", new GameShopCurrencyLine(new Vector3f[]{corners[3],FastMath.interpolateLinear(.33f, corners[3], corners[2]) , FastMath.interpolateLinear(.66f, corners[3], corners[2]), corners[2]}, (byte) 16));
//
//        edges.put("backTop", new GameShopCurrencyLine(new Vector3f[]{corners[5], FastMath.interpolateLinear(.33f, corners[5], corners[6]), FastMath.interpolateLinear(.66f, corners[5], corners[6]), corners[6] }, (byte) 16));
//
//        //Back Of Neck
//        edges.put("backBottom", new GameShopCurrencyLine(new Vector3f[]{corners[4], FastMath.interpolateLinear(.33f, corners[4], corners[7]), FastMath.interpolateLinear(.66f, corners[4], corners[7]), corners[7]}, (byte) 16));
//
//        //Back Of Skull
//        edges.put("backRight",new GameShopCurrencyLine(new Vector3f[]{corners[4],FastMath.interpolateLinear(.33f, corners[4], corners[5]),  FastMath.interpolateLinear(.66f, corners[4], corners[5]), corners[5]}, (byte)16));
//        edges.put("backLeft", new GameShopCurrencyLine(new Vector3f[]{corners[7],FastMath.interpolateLinear(.33f, corners[7], corners[6]), FastMath.interpolateLinear(.66f, corners[7], corners[6]), corners[6]}, (byte)16));
//
//        edges.put("topLeft",new GameShopCurrencyLine(new Vector3f[]{corners[6],FastMath.interpolateLinear(.33f, corners[6], corners[2]), FastMath.interpolateLinear(.66f, corners[6], corners[2]),corners[2]}, (byte)16));
//        edges.put("topRight", new GameShopCurrencyLine(new Vector3f[]{corners[5],FastMath.interpolateLinear(.33f, corners[5], corners[1]), FastMath.interpolateLinear(.66f, corners[5], corners[1]),corners[1]}, (byte)16));
//
//        //Chin Sides
//        edges.put("bottomLeft", new GameShopCurrencyLine(new Vector3f[]{corners[7],FastMath.interpolateLinear(.33f, corners[7], corners[3]),FastMath.interpolateLinear(.66f, corners[7], corners[3]),corners[3] }, (byte)16));
//        edges.put("bottomRight", new GameShopCurrencyLine(new Vector3f[]{corners[4],FastMath.interpolateLinear(.33f, corners[4], corners[0]),FastMath.interpolateLinear(.66f, corners[4], corners[0]),corners[0] }, (byte)16));
//
//    }
//    public void addFront(){
//
//        //Vector3f[] mid = new Vector3f[]{axis.add(new Vector3f(1,1,0f)), axis.add(new Vector3f(2,1,0f)), axis.add(new Vector3f(1,2,0f)), axis.add(new Vector3f(2,2,0f)),};
//       // FastMath.interpolateLinear(.33f, frontRight.points[1], frontLeft.points[1]);
//        GameShopCurrencyLine cl = edges.get("frontBottom");
//        GameShopCurrencyLine cl1 = new GameShopCurrencyLine(new Vector3f[]{Objects.requireNonNull(edges.get("frontRight")).points[1], FastMath.interpolateLinear(.33f, Objects.requireNonNull(edges.get("frontRight")).points[1], Objects.requireNonNull(edges.get("frontLeft")).points[1]),  FastMath.interpolateLinear(.66f, Objects.requireNonNull(edges.get("frontRight")).points[1], Objects.requireNonNull(edges.get("frontLeft")).points[1]), Objects.requireNonNull(edges.get("frontLeft")).points[1]}, (byte) 16);
//        GameShopCurrencyLine cl2 = new GameShopCurrencyLine(new Vector3f[]{Objects.requireNonNull(edges.get("frontRight")).points[2], FastMath.interpolateLinear(.33f, Objects.requireNonNull(edges.get("frontRight")).points[2], Objects.requireNonNull(edges.get("frontLeft")).points[2]),  FastMath.interpolateLinear(.66f, Objects.requireNonNull(edges.get("frontRight")).points[2], Objects.requireNonNull(edges.get("frontLeft")).points[2]), Objects.requireNonNull(edges.get("frontLeft")).points[2]}, (byte) 16);
//        GameShopCurrencyLine cl3 = edges.get("frontTop");
//
//        sides.put("front", new CurrencyMesh(app, new GameShopCurrencyLine[]{cl, cl1, cl2, cl3}, makeTexture("front"), node));
//
//    }
//
//    public void addBack(){
//
//        //Vector3f[] mid = new Vector3f[]{axis.add(new Vector3f(2,1,-3)), axis.add(new Vector3f(1,1,-3)), axis.add(new Vector3f(2,2,-3)), axis.add(new Vector3f(1,2,-3))};
//        GameShopCurrencyLine cl = edges.get("backBottom"); //backRight, backLeft
//        GameShopCurrencyLine cl1 = new GameShopCurrencyLine(new Vector3f[]{Objects.requireNonNull(edges.get("backRight")).points[1], FastMath.interpolateLinear(.33f, Objects.requireNonNull(edges.get("backRight")).points[1], Objects.requireNonNull(edges.get("backLeft")).points[1]),  FastMath.interpolateLinear(.66f, Objects.requireNonNull(edges.get("backRight")).points[1], Objects.requireNonNull(edges.get("backLeft")).points[1]), Objects.requireNonNull(edges.get("backLeft")).points[1]}, (byte) 16);
//        GameShopCurrencyLine cl2 = new GameShopCurrencyLine(new Vector3f[]{Objects.requireNonNull(edges.get("backRight")).points[2], FastMath.interpolateLinear(.33f, Objects.requireNonNull(edges.get("backRight")).points[2], Objects.requireNonNull(edges.get("backLeft")).points[2]),  FastMath.interpolateLinear(.66f, Objects.requireNonNull(edges.get("backRight")).points[2], Objects.requireNonNull(edges.get("backRight")).points[2]), Objects.requireNonNull(edges.get("backLeft")).points[2]}, (byte) 16);
//        GameShopCurrencyLine cl3 = edges.get("backTop");
//
//
//        sides.put("back", new CurrencyMesh(app, new GameShopCurrencyLine[]{cl, cl1, cl2, cl3}, makeTexture("back"), node));
//
//    }
//
//    public void addRight(){
//       // Vector3f[] mid = new Vector3f[]{axis.add(new Vector3f(0f,1,-2)), axis.add(new Vector3f(0,1, -1)), axis.add(new Vector3f(0,2,-2)), axis.add(new Vector3f(0,2,-1)), };
//        GameShopCurrencyLine cl = edges.get("bottomRight");//backRight, frontRignh
//        GameShopCurrencyLine cl1 = new GameShopCurrencyLine(new Vector3f[]{Objects.requireNonNull(edges.get("backRight")).points[1], FastMath.interpolateLinear(.33f, Objects.requireNonNull(edges.get("backRight")).points[1], Objects.requireNonNull(edges.get("frontRight")).points[1]),  FastMath.interpolateLinear(.66f, Objects.requireNonNull(edges.get("backRight")).points[1], Objects.requireNonNull(edges.get("frontRight")).points[1]), Objects.requireNonNull(edges.get("frontRight")).points[1]}, (byte) 16);
//        GameShopCurrencyLine cl2 = new GameShopCurrencyLine(new Vector3f[]{Objects.requireNonNull(edges.get("backRight")).points[2], FastMath.interpolateLinear(.33f, Objects.requireNonNull(edges.get("backRight")).points[2], Objects.requireNonNull(edges.get("frontRight")).points[2]),  FastMath.interpolateLinear(.66f, Objects.requireNonNull(edges.get("backRight")).points[2], Objects.requireNonNull(edges.get("frontRight")).points[2]), Objects.requireNonNull(edges.get("frontRight")).points[2]}, (byte) 16);
//        GameShopCurrencyLine cl3 = edges.get("topRight");
//
//
//        sides.put("right", new CurrencyMesh(app, new GameShopCurrencyLine[]{cl, cl1, cl2, cl3}, makeTexture("right"), node));
//    }
//
//    public void addLeft(){
//
//        //Vector3f[] mid = new Vector3f[]{ axis.add(new Vector3f(3f,1,-2)), axis.add(new Vector3f(3,1,-1)), axis.add(new Vector3f(3,2,-2)), axis.add(new Vector3f(3,2,-1)) };
//        GameShopCurrencyLine cl = edges.get("bottomLeft");//backLeft, frontLeft
//        GameShopCurrencyLine cl1 = new GameShopCurrencyLine(new Vector3f[]{Objects.requireNonNull(edges.get("backLeft")).points[1], FastMath.interpolateLinear(.33f, Objects.requireNonNull(edges.get("backLeft")).points[1], Objects.requireNonNull(edges.get("frontLeft")).points[1]),  FastMath.interpolateLinear(.66f, Objects.requireNonNull(edges.get("backLeft")).points[1], Objects.requireNonNull(edges.get("frontLeft")).points[1]), Objects.requireNonNull(edges.get("frontLeft")).points[1]}, (byte) 16);
//        GameShopCurrencyLine cl2 = new GameShopCurrencyLine(new Vector3f[]{Objects.requireNonNull(edges.get("backLeft")).points[2], FastMath.interpolateLinear(.33f, Objects.requireNonNull(edges.get("backLeft")).points[2], Objects.requireNonNull(edges.get("frontLeft")).points[2]),  FastMath.interpolateLinear(.66f, Objects.requireNonNull(edges.get("backLeft")).points[2], Objects.requireNonNull(edges.get("frontLeft")).points[2]), Objects.requireNonNull(edges.get("frontLeft")).points[2]}, (byte) 16);
//        GameShopCurrencyLine cl3 = edges.get("topLeft");
//
//
//        sides.put("left", new CurrencyMesh(app, new GameShopCurrencyLine[]{cl, cl1, cl2, cl3}, makeTexture("left"), node));
//    }
//
//    public void addTop(){
//        //Vector3f[] mid = new Vector3f[]{axis.add(new Vector3f(1,3,-1)), axis.add(new Vector3f(2,3,-1)),axis.add(new Vector3f(1,3,-2)), axis.add(new Vector3f(2,3,-2)),};
//        GameShopCurrencyLine cl = edges.get("frontTop"); //topRight, topLeft
//        GameShopCurrencyLine cl1 = new GameShopCurrencyLine(new Vector3f[]{Objects.requireNonNull(edges.get("topRight")).points[2], FastMath.interpolateLinear(.33f, Objects.requireNonNull(edges.get("topRight")).points[2], Objects.requireNonNull(edges.get("topLeft")).points[2]),  FastMath.interpolateLinear(.66f, Objects.requireNonNull(edges.get("topRight")).points[2], Objects.requireNonNull(edges.get("topLeft")).points[2]), Objects.requireNonNull(edges.get("topLeft")).points[2]}, (byte) 16);
//        GameShopCurrencyLine cl2 = new GameShopCurrencyLine(new Vector3f[]{Objects.requireNonNull(edges.get("topRight")).points[1], FastMath.interpolateLinear(.33f, Objects.requireNonNull(edges.get("topRight")).points[1], Objects.requireNonNull(edges.get("topLeft")).points[1]),  FastMath.interpolateLinear(.66f, Objects.requireNonNull(edges.get("topRight")).points[1], Objects.requireNonNull(edges.get("topLeft")).points[1]), Objects.requireNonNull(edges.get("topLeft")).points[1]}, (byte) 16);
//        GameShopCurrencyLine cl3 = edges.get("backTop");
//
//
//        sides.put("top", new CurrencyMesh(app, new GameShopCurrencyLine[]{cl, cl1, cl2, cl3}, makeTexture("top"), node));
//
//    }
//
//    public void addBottom(){
//        //Vector3f[] mid = new Vector3f[]{axis.add(new Vector3f(1,0,-2)), axis.add(new Vector3f(2,0,-2)),axis.add(new Vector3f(1,0,-1)), axis.add(new Vector3f(2,0,-1))};
//        GameShopCurrencyLine cl = edges.get("backBottom");//bottomRight, bottomLeft
//        GameShopCurrencyLine cl1 = new GameShopCurrencyLine(new Vector3f[]{Objects.requireNonNull(edges.get("bottomRight")).points[1], FastMath.interpolateLinear(.33f, Objects.requireNonNull(edges.get("bottomRight")).points[1], Objects.requireNonNull(edges.get("bottomLeft")).points[1]),  FastMath.interpolateLinear(.66f, Objects.requireNonNull(edges.get("bottomRight")).points[1], Objects.requireNonNull(edges.get("bottomLeft")).points[1]), Objects.requireNonNull(edges.get("bottomLeft")).points[1]}, (byte) 16);
//        GameShopCurrencyLine cl2 = new GameShopCurrencyLine(new Vector3f[]{Objects.requireNonNull(edges.get("bottomRight")).points[2], FastMath.interpolateLinear(.33f, Objects.requireNonNull(edges.get("bottomRight")).points[2], Objects.requireNonNull(edges.get("bottomLeft")).points[2]),  FastMath.interpolateLinear(.66f, Objects.requireNonNull(edges.get("bottomRight")).points[2], Objects.requireNonNull(edges.get("bottomLeft")).points[2]), Objects.requireNonNull(edges.get("bottomLeft")).points[2]}, (byte) 16);
//        GameShopCurrencyLine cl3 = edges.get("frontBottom");
//
//
//        sides.put("bottom", new CurrencyMesh(app, new GameShopCurrencyLine[]{cl, cl1, cl2, cl3}, makeTexture("bottom"), node));
//
//    }
//
//    public void modCurrencyLine(String side,byte line, byte point, Vector3f newPoint){
//
//        for(CurrencyMesh cm: sides.values()){
//            int cli = 0;
//
//            for (GameShopCurrencyLine cl: cm.currencyLines){
//                int p = 0;
//                for (Vector3f v: cl.points){
//                    if (v.equals(Objects.requireNonNull(sides.get(side)).currencyLines[line].points[point])){
//                        //store.add(v);
//                         cm.modCurrencyLine((byte) cli, (byte) p, newPoint);
//                    }
//                    p++;
//                }
//                cli++;
//            }
//        }
//
//    }
//
//    public void addCurrencyLine(String side, byte line, byte point, Vector3f addNewPoint){
//
//        modCurrencyLine(side, line, point, Objects.requireNonNull(sides.get(side)).currencyLines[line].points[point].add(addNewPoint));
//
//    }
//
//    //This is to make the shape
//    public void make(){
//
//    }
//
//    public void makeExports(){
//
//    }
//
//    public Texture2D makeTexture(String side){
//        GameShopLayer layer= new GameShopLayer((short) 128, (short) 128);
//        layer.drawCircle((short) 63, (short) 63, (short) 128, ColorRGBA.fromRGBA255(255,215,175,255));
//
//        //DRILL COLOR CODE
//        // layer.drawCircle((short) 63, (short) 63, (short) 128, ColorRGBA.fromRGBA255(0,0,0,255));
//
//        ATMS atms = new ATMS((byte) 1, layer);
//        //atmsFront.frames[0] = layerFront;
//        ByteBuffer data = BufferUtils.createByteBuffer(atms.frames[0].outputLayer());
//        // ByteBuffer data = BufferUtils.createByteBuffer((byte)0,(byte)127,(byte)0,(byte)62);
//        Image image = new Image(Image.Format.RGBA8, 128, 128, data, ColorSpace.Linear);
//        return new Texture2D(image);
//    }
//
//    public void applyTextures(){
//
//    }
//
//}
