package br.com.web.localize.service.util;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;

/**
 * <p>
 * <b>Title:</b> UtilGeometry.java
 * </p>
 * 
 * <p>
 * <b>Description:</b> Classe utilitária para trabalhar com geolocalização.
 * </p>
 * 
 * <p>
 * <b>Company: </b> Fábrica de Software
 * </p>
 * 
 * @author Silvânio Júniro
 * 
 * @version 1.0.0
 */
public class UtilGeometry {

	/**
	 * Método responsável por converter longitude e latitude em <code>Point</code>.
	 *
	 * @author Silvânio Júnior
	 *
	 * @param longitude
	 * 
	 * @param latitude
	 * 
	 * @return <code>Point</code>
	 */
	public static Point converterEmPoint(final Double longitude, final Double latitude) {
		
		final WKTReader fromText = new WKTReader();
		
		Geometry geometry = null;
		
		try {
			
			final String point = "POINT(" + longitude + " " + latitude + ")";
			
			geometry = fromText.read(point);
			
		} catch (final ParseException e) {
			
			e.printStackTrace();
			
		}
		
		return (Point) geometry;
	}
	/**
	 * Método responsável por converter longitude e latitude em <code>Point</code>.
	 *
	 * @author Silvânio Júnior
	 *
	 * @param longitude
	 * 
	 * @param latitude
	 * 
	 * @return <code>Point</code>
	 */
	public static Point converterEmPoint(final String longitude, final String latitude) {

		final WKTReader fromText = new WKTReader();

		Geometry geometry = null;

		try {

			final String point = "POINT(" + longitude + " " + latitude + ")";

			geometry = fromText.read(point);

		} catch (final ParseException e) {

			e.printStackTrace();

		}

		return (Point) geometry;
	}

	/**
	 * Método responsável por converter longitude, latitude e raio em <code>Geometry</code>
	 *
	 * @author Silvânio Júnior
	 *
	 * @param longitude
	 * 
	 * @param latitude
	 * 
	 * @param raio
	 * 
	 * @return <code>Geometry</code>
	 */
	public static Geometry converterCirculo(final String longitude, final String latitude, final Double raio) {

		return UtilGeometry.converterEmCirculo(new Double(longitude), new Double(latitude), raio);
	}

	/**
	 * Método responsável por converter longitude, latitude e raio em <code>Geometry</code>
	 *
	 * @author Silvânio Júnior
	 *
	 * @param longitude
	 * 
	 * @param latitude
	 * 
	 * @param raio
	 * 
	 * @return <code>Geometry</code>
	 */
	public static Geometry converterEmCirculo(final double longitude, final double latitude, final double raio) {

		//final GeometricShapeFactory shapeFactory = new GeometricShapeFactory();

		//shapeFactory.setNumPoints(32);

		//shapeFactory.setCentre(new Coordinate(longitude, latitude));

		//shapeFactory.setSize(raio * 2);
		
		//return shapeFactory.createCircle();
		
		return 	converterEmPoint(longitude,latitude).buffer(raio);

	}

	/**
	 * Método responsável por converter KM em Graus de localidade.
	 *
	 * @author Silvânio Júnior
	 *
	 * @param km
	 *            kilometro
	 * 
	 * @return <code>Double</code> Graus
	 */
	public static Double convertKmEmGraus(final Double km) {

		return km / 111.12d;

	}

	/**
	 * Método responsável por converter KM em Graus de localidade.
	 *
	 * @author Silvânio Júnior
	 *
	 * @param km
	 *            kilometro
	 * 
	 * @return <code>Double</code> Graus
	 */
	public static Double convertGrausEmKm(final Double graus) {
		
		return graus * 111.12d;
		
	}

}
