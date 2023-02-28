package javamongo;

/**
 *
 * @author Jonathan
 */
public class JavaMongo {
    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        
        conexion.mostrar();
        conexion.insertar("nadar");
        System.out.println("Otro");
        conexion.mostrar();
        System.out.println("Otro Más");
        conexion.actualizar("nadar", "brincar");
        conexion.eliminar("brincar");
        conexion.mostrar();
    }
    
}
