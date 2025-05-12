package org.alex.serve.persistence;

import org.alex.api.Connect;
import org.alex.entity.Place;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlacePersistence implements Persistence<Place>{
    Connect c;

    public PlacePersistence() {
        this.c = new Connect();
    }

    @Override
    public boolean isExist(Place place) {
        try (var connection = c.getConnect()){

            var st = connection.prepareStatement(
                    "select * from places where place_type = ?"
            );

            st.setString(1, place.getType());

            var set = st.executeQuery();

            return set.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void create(Place place) {
        try (var connection = c.getConnect()){

            var st = connection.prepareStatement(
                    "INSERT INTO places (place_type, size) VALUES (?, ?)");

            st.setString(1, place.getType());
            st.setInt(2, place.getSize());

            st.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Place> getAll() {
        try (var connection = c.getConnect()){

            var places = new ArrayList<Place>();

            var st = connection.prepareStatement(
                    "select * from places");

            var set = st.executeQuery();

            while(set.next()){
                places.add(new Place(set.getString("place_type"), set.getInt("size")));
            }

            return places;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
