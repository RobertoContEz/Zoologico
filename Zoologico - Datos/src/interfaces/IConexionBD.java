package interfaces;

import com.mongodb.client.MongoDatabase;

/**
 *
 * @author R.Pacheco, R.Contreras, E.Villagrana y G.Gaxiola
 * Clase que hace conexión con la base de datos en Mongo
 */
public interface IConexionBD {

    MongoDatabase getConexion();
}
