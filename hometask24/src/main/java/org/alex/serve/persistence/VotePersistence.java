package org.alex.serve.persistence;

import org.alex.api.Connect;
import org.alex.entity.Employee;
import org.alex.entity.Place;
import org.alex.entity.Vote;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

            return set.next();

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

    @Override
    public List<Vote> getAll() {
        try (var connection = c.getConnect()){

            var votes = new ArrayList<Vote>();

            var st = connection.prepareStatement(
                    "select * from votes");

            var set = st.executeQuery();

            while(set.next()){
                votes.add(new Vote(
                        new Place(set.getString("place_type")),
                        new Employee(set.getString("employee_login"))
                ));
            }

            return votes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
