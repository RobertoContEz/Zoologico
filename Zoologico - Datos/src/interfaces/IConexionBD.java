package interfaces;

import com.mongodb.client.MongoDatabase;

/**
 *
 * @author R.Pacheco, R.Contreras, E.Villagrana y G.Gaxiola
 */
public interface IConexionBD {

    MongoDatabase getConexion();
}
