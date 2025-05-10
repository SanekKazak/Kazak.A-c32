package org.alex.serve.persistence;

import org.alex.api.Connect;
import org.alex.entity.Employee;
import org.alex.entity.Place;
import org.alex.entity.Vote;

import java.sql.SQLException;

public class PlacePersistence implements Persistence<Place>{
    Connect c;

    public PlacePersistence() {
        this.c = new Connect();
    }

    @Override
    public boolean isExist(Place place) {
        try (var connection = c.getConnect()){

            var preparedStatement = connection.prepareStatement(
                    "select * from places where type = ?"
            );

            preparedStatement.setString(1, place.getType());

            var set = preparedStatement.executeQuery();

            if(set.next()){
                return true;
            }else{
                return false;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void create(Place place) {
        try (var connection = c.getConnect()){

            var st = connection.prepareStatement(
                    "INSERT INTO places (type, size) VALUES (?, ?)");

            st.setString(1, place.getType());
            st.setInt(2, place.getSize());

            st.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
