package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;

/**
 * This is the Main Class of your Game. You should only do initialization here.
 * Move your Logic into AppStates or Controls
 *
 * @author normenhansen
 */
public class Main extends SimpleApplication {

    int cont;
    float i;
    float ii;
    Geometry g1;
    Geometry g2;
    Geometry g3;
    Geometry g4;
    Node n;
    boolean b;

    public static void main(String[] args) {
        Main app = new Main();

        app.setDisplayStatView(false);
        app.setShowSettings(false);
        app.start();
    }

    @Override
    public void simpleInitApp() {

        b = false;
        cont = 0;
        i = 0;
        flyCam.setMoveSpeed(100f);
        g1 = crearGometrias(new Vector3f(-5f, -5f, -5f));
        g2 = crearGometrias(new Vector3f(5f, 5f, 5f));
        g3 = crearGometrias(new Vector3f(-10f, -10f, -10f));
        g4 = crearGometrias(new Vector3f(15f, 15f, 15f));
        //n = new Node();
        //n.attachChild(g2);
        rootNode.attachChild(g1);
        rootNode.attachChild(g2);
        rootNode.attachChild(g3);
        rootNode.attachChild(g4);

    }

    @Override
    public void simpleUpdate(float tpf) {
        Quaternion q = new Quaternion();
        i += tpf;
        ii += tpf;
        q.fromAngleAxis(i * 2, new Vector3f(0, 1, 0));
        g2.setLocalRotation(q);



    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }

    public Geometry crearGometrias(Vector3f pos) {
        Geometry g;
        Box b = new Box(1, 1, 1);
        g = new Geometry("Box " + cont, b);
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.randomColor());
        g.setMaterial(mat);
        g.setLocalTranslation(pos.getX(), pos.getY(), pos.getZ());
        return g;
    }
}
