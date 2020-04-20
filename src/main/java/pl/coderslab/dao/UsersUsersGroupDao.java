package pl.coderslab.dao;

import pl.coderslab.model.SolutionsExerciseUsers;
import pl.coderslab.model.UsersGroups;
import pl.coderslab.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class UsersUsersGroupDao {


    private static final String FIND_ALL_USERS_IN_GROUP_QUERY ="SELECT users_id as user_id,users.username as username,exercise_id, exercises.title as exercise_name , solutions.updated as date_updated FROM solutions JOIN users JOIN exercises ORDER BY updated LIMIT ?";

    public UsersGroups[] findAll() {
        try (Connection conn = DBUtils.getConnection()) {
            UsersGroups[] usersGroups = new UsersGroups[0];
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_USERS_IN_GROUP_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                UsersGroups usersGroup = new UsersGroups();
                usersGroup.setId(resultSet.getInt("id"));
                usersGroup.setName(resultSet.getString("name"));
//                usersGroups = addToArray(usersGroup, usersGroups);
            }
            return usersGroups;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public SolutionsExerciseUsers[] addToArray(SolutionsExerciseUsers solutionsExerciseUsers, SolutionsExerciseUsers[] solutionsExerciseUsers1) {
        solutionsExerciseUsers1 = Arrays.copyOf(solutionsExerciseUsers1, solutionsExerciseUsers1.length + 1);
        solutionsExerciseUsers1[solutionsExerciseUsers1.length - 1] = solutionsExerciseUsers;
        return solutionsExerciseUsers1;
    }

}
