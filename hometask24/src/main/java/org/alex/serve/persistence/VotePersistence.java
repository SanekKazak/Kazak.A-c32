package org.alex.serve.persistence;

import org.alex.entity.Employee;
import org.alex.entity.Place;
import org.alex.api.Connect;
import org.alex.entity.Vote;

import java.sql.SQLException;

public class VotePersistence {
    Connect c;

    public VotePersistence() {
        this.c = new Connect();
    }

    public boolean isVoteExist(Vote vote) {
        try (var connection = c.getConnect()){

            var preparedStatement = connection.prepareStatement(
                    "select * from votes where user_login = ? and place_type = ?"
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

    public void createVote(Vote vote) {
        try (var connection = c.getConnect()){

            var st = connection.prepareStatement(
                    "INSERT INTO votes (user_login, place_type) VALUES (?, ?)");

            st.setString(1, vote.getEmployee().getLogin());
            st.setString(2, vote.getPlace().getType());

            st.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
