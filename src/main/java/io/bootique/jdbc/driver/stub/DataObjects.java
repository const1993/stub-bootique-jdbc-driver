package io.bootique.jdbc.driver.stub;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class DataObjects {

    private static DataObjects INSTANSE;

    private static Map<String, ResultSet> objects = new HashMap<>();

    public static Map<String, ResultSet> getObjects() {
        if (INSTANSE == null) {
            INSTANSE = new DataObjects();
            generateData();
            System.out.println("I have generated " + objects.size() + "objects");
        }

        return objects;
    }

    private static Map<Integer, Map<String, Object>> createArtists(String name) {

        Map<Integer, Map<String, Object>> artists = new HashMap();

        for (int i = 1; i <= 10; i++) {
            Map<String, Object> artist = new LinkedHashMap<>();
            artist.put("DATE_OF_BIRTH", LocalDate.now());
            artist.put("NAME", name);
            artist.put("ID", i);
            artists.put(i - 1 , artist);
        }
        System.out.println("Generated " + artists.size() + " artists");
        return artists;
    }

    private static Map<Integer, Map<String, Object>> createGallerys(String name) {
        Map<String, Object> gallery = new LinkedHashMap<>();
        gallery.put("NAME", name);
        gallery.put("ID", 1);
        Map<Integer, Map<String, Object>> galleries = new HashMap<>();
        galleries.put(0, gallery);

        System.out.println("Generated " + galleries.size() + " galleries");

        return galleries;
    }

    private static Map<Integer, Map<String, Object>> createPaintings(String name) {
        Map gallery = createGallerys("c").get(0);
        Map<Integer, Map<String, Object>> paintings = new HashMap<>();

        Map picasso = createArtists("a").get(0);
        for (int i = 1; i <= 100; i++) {
            Map<String, Object> painitng = new LinkedHashMap<>();
            painitng.put("NAME", name);
            painitng.put("ARTIST", picasso);
            painitng.put("GALLERY", gallery);
            painitng.put("ID", i);
            paintings.put(i - 1 , painitng);
        }
        System.out.println("Generated " + paintings.size() + " paintings");

        return paintings;
    }

    private static void generateData() {
        System.out.println("Generate");
        Map artistFields = new HashMap();
        artistFields.put(3, "ID");
        artistFields.put(2, "NAME");
        artistFields.put(1, "DATE_OF_BIRTH");

        Map paintingFields = new HashMap();
        paintingFields.put(4, "ID");
        paintingFields.put(3, "ARTIST_ID");
        paintingFields.put(2, "GALLERY_ID");
        paintingFields.put(1, "NAME");


        Map galleryFields = new HashMap();
        galleryFields.put(2, "ID");
        galleryFields.put(1, "NAME");

        objects.put("ARTIST", new StubResultSet(artistFields, createArtists("a")));
        objects.put("PAINTING", new StubResultSet(paintingFields, createPaintings("b")));
        objects.put("GALLERY", new StubResultSet(galleryFields, createGallerys("Armitage")));
    }

}
