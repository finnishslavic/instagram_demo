package fi.spanasenko.android.utils;

import com.google.android.maps.GeoPoint;

/**
 * Utils
 * Holds static utility methods used across the application.
 */
public class Utils {

    private static final int EARTH_RADIUS = 6371;

    /**
     * Calculates distance between two geo points.
     * @param lat1 Latitude of first point.
     * @param lon1 Longitude of first point.
     * @param lat2 Latitude of second point.
     * @param lon2 Longitude of second point.
     * @return Distance between given geo points.
     */
    public static float calculateDistance(float lat1, float lon1, float lat2, float lon2) {
        float dLat = (float) Math.toRadians(lat2 - lat1);
        float dLon = (float) Math.toRadians(lon2 - lon1);
        float a =
                (float) (Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.cos(Math.toRadians(lat1))
                        * Math.cos(Math.toRadians(lat2)) * Math.sin(dLon / 2) * Math.sin(dLon / 2));
        float c = (float) (2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a)));
        float d = EARTH_RADIUS * c;
        return d;
    }

    /**
     * Creates GeoPoint object from given latitude and longitude.
     * @param lat Latitude of the geopoint.
     * @param lng Longitude of the geopoint.
     * @return GeoPoint object from given latitude and longitude.
     */
    public static GeoPoint getGeoPoint(float lat, float lng) {
        return new GeoPoint((int) (lat * 1E6), (int) (lng * 1E6));
    }

}
