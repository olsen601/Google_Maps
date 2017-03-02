package com.RyanOlsen;

import java.io.BufferedReader;
import java.io.FileReader;
import com.google.maps;

public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here

    String key = null;

    try (BufferedReader reader = new BufferedReader(new FileReader("Key.txt"))){
        key = reader.readLine();
        System.out.println(key);
    } catch (Exception ioe) {
        System.out.println("No Key file found, or could not read key. Please verify Key.txt present");
        System.exit(-1);
    }

    GeoApiContext context = new GeoApiContext().setSpiKey(key);

    LatLng mctcLatLng = new LatLng(44.973074, -93.283356);

    ElevationResults[] results = ElevationApi.getByPoints(context, mctcLatLng).await();
    }
}
