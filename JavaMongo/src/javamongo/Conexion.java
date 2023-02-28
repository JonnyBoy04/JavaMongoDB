package javamongo;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jonathan
 */
public class Conexion {

    DB baseDeDatos;
    DBCollection coleccion;
    BasicDBObject document = new BasicDBObject();

    public Conexion() {
        Mongo mongo = new Mongo("127.0.0.1", 27017);
        baseDeDatos = mongo.getDB("actSeis");
        coleccion = baseDeDatos.getCollection("ActividadesSeis");
        System.out.println("Conexión Exitosa");
    }

    public boolean insertar(String accion) {
        document.put("accion", accion);
        coleccion.insert(document);
        return true;
    }

    public void mostrar() {
        DBCursor cursor = coleccion.find();
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }
    }

    public boolean actualizar(String accionV, String accionN) {
        document.put("accion", accionV);
        BasicDBObject documentoN = new BasicDBObject();
        documentoN.put("accion", accionN);

        coleccion.findAndModify(document, documentoN);
        return true;
    }

    public boolean eliminar(String accion) {
        document.put("accion", accion);
        coleccion.remove(document);
        return true;
    }

}
