package org.alex.serve.persistence;

import org.alex.entity.Employee;
import org.alex.entity.Entity;
import org.alex.entity.Place;
import org.alex.api.Connect;
import org.alex.entity.Vote;

import java.sql.SQLException;

public class VotePersistence implements Persistence<Vote>{
    Connect c;

    public VotePersistence() {
        this.c = new Connect();
    }

    @Override
    public boolean isExist(Vote vote) {
        try (var connection = c.getConnect()){

            var preparedStatement = connection.prepareStatement(
                    "select * from votes where employee_login = ? and place_type = ?"
            );

            preparedStatement.setString(1, vote.getEmployee().getLogin());
            preparedStatement.setString(2, vote.getPlace().getType());

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
    public void create(Vote vote) {
        try (var connection = c.getConnect()){

            var st = connection.prepareStatement(
                    "INSERT INTO votes (employee_login, place_type) VALUES (?, ?)");

            st.setString(1, vote.getEmployee().getLogin());
            st.setString(2, vote.getPlace().getType());

            st.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
