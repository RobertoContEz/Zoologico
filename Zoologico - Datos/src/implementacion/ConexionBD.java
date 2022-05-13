package implementacion;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import interfaces.IConexionBD;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 *
 * @author R.Pacheco, R.Contreras, E.Villagrana y G.Gaxiola
 */
public class ConexionBD implements IConexionBD {

    /**
     * Atributos que contienen los valores necesarios para la conexión
     */
    private static final String HOST = "localhost";
    private static final int PUERTO = 27017;
    private static final String BASE_DATOS = "ZoologicoBD";

    private MongoDatabase conexion = null;

    /**
     * Configuración de la conexión hacia la base de datos en MongoDB.
     *
     * @return un objeto con la conexión a la base de datos enc aso de hacerse
     * correctamente, null en caso contrario.
     */
    @Override
    public MongoDatabase getConexion() {
        if (conexion == null) {
            try {
                //CONFIGURACIÓN PARA QUE MONGODRIVE REALICE EL MAPEO DE POJOS AUMATICAMENTE
                CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
                CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
                ConnectionString cadenaConexion = new ConnectionString("mongodb://" + HOST + "/" + PUERTO);

                MongoClientSettings clientsSettings = MongoClientSettings.builder()
                        .applyConnectionString(cadenaConexion)
                        .codecRegistry(codecRegistry)
                        .build();

                MongoClient clienteMongo = MongoClients.create(clientsSettings);
                MongoDatabase baseDatos = clienteMongo.getDatabase(BASE_DATOS);

                conexion = baseDatos;
                return baseDatos;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return null;
            }
        } else {
            return conexion;
        }
    }

}
