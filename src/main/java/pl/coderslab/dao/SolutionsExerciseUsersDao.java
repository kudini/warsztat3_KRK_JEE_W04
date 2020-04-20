package pl.coderslab.dao;

import pl.coderslab.model.SolutionsExerciseUsers;
import pl.coderslab.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class SolutionsExerciseUsersDao {


    private static final String JOIN_AND_READ_SOLUTION_QUERY =
            "SELECT users_id as user_id,solutions.id as solution_id, username as username,exercise_id, title as exercise_name , solutions.updated as date_updated FROM solutions JOIN users u on solutions.users_id = u.id JOIN exercises e on solutions.exercise_id = e.id ORDER BY updated DESC limit ?" +
                    "";
    private static final String FIND_ALL_SOLUTION_BY_ID_QUERY =
            "SELECT users_id as user_id,solutions.id as solution_id, username as username,exercise_id, title as exercise_name , solutions.updated as date_updated FROM solutions JOIN users u on solutions.users_id = u.id JOIN exercises e on solutions.exercise_id = e.id WHERE users_id=?";
    private static final String FIND_ALL_SOLUTION_BY_EXERCISE_ID_QUERY =
            "SELECT users_id as user_id,solutions.id as solution_id, username as username,exercise_id, title as exercise_name , solutions.updated as date_updated FROM solutions JOIN users u on solutions.users_id = u.id JOIN exercises e on solutions.exercise_id = e.id WHERE exercise_id=?";


    //
//    public Solutions read(int solutionId) {
//        try (Connection connection = DBUtils.getConnection()) {
//            PreparedStatement preparedStatement = connection.prepareStatement(JOIN_AND_READ_SOLUTION_QUERY);
//            preparedStatement.setInt(1, solutionId);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            if (resultSet.next()) {
//                Solutions solutions = new Solutions();
//                solutions.setId(resultSet.getInt("id"));
//                solutions.setCreated(resultSet.getDate("created"));
//                solutions.setUpdated(resultSet.getDate("updated"));
//                solutions.setDescription(resultSet.getString("description"));
//                solutions.setExcerciseId(resultSet.getInt("exercise_id"));
//                solutions.setUsersId(resultSet.getInt("user_id"));
//                return solutions;
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
    public SolutionsExerciseUsers[] findRecent(int numberOfElements) {
        try (Connection conn = DBUtils.getConnection()) {
            SolutionsExerciseUsers[] solutionsExerciseUsers = new SolutionsExerciseUsers[0];
            PreparedStatement statement = conn.prepareStatement(JOIN_AND_READ_SOLUTION_QUERY);
            statement.setInt(1, numberOfElements);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                SolutionsExerciseUsers solutionsExerciseUsers1 = new SolutionsExerciseUsers();
                solutionsExerciseUsers1.setUserId(resultSet.getInt("user_id"));
                solutionsExerciseUsers1.setSolutionId(resultSet.getInt("solution_id"));
                solutionsExerciseUsers1.setUpdated(resultSet.getDate("date_updated"));
                solutionsExerciseUsers1.setExerciseName(resultSet.getString("exercise_name"));
                solutionsExerciseUsers1.setExerciseId(resultSet.getInt("exercise_id"));
                solutionsExerciseUsers1.setUsername(resultSet.getString("username"));
                solutionsExerciseUsers = addToArray(solutionsExerciseUsers1, solutionsExerciseUsers);
            }
            return solutionsExerciseUsers;
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

    public SolutionsExerciseUsers[] findAllbyId(int userId) {
        try (Connection conn = DBUtils.getConnection()) {
            SolutionsExerciseUsers[] solutionsExerciseUsers = new SolutionsExerciseUsers[0];
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_SOLUTION_BY_ID_QUERY);
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                SolutionsExerciseUsers solutionsExerciseUsers1 = new SolutionsExerciseUsers();
                solutionsExerciseUsers1.setUserId(resultSet.getInt("user_id"));
                solutionsExerciseUsers1.setSolutionId(resultSet.getInt("solution_id"));
                solutionsExerciseUsers1.setUpdated(resultSet.getDate("date_updated"));
                solutionsExerciseUsers1.setExerciseName(resultSet.getString("exercise_name"));
                solutionsExerciseUsers1.setExerciseId(resultSet.getInt("exercise_id"));
                solutionsExerciseUsers1.setUsername(resultSet.getString("username"));
                solutionsExerciseUsers = addToArray(solutionsExerciseUsers1, solutionsExerciseUsers);
            }
            return solutionsExerciseUsers;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public SolutionsExerciseUsers[] findAllbyExerciseId(int exerciseId) {
            try (Connection conn = DBUtils.getConnection()) {
                SolutionsExerciseUsers[] solutionsExerciseUsers = new SolutionsExerciseUsers[0];
                PreparedStatement statement = conn.prepareStatement(FIND_ALL_SOLUTION_BY_EXERCISE_ID_QUERY);
                statement.setInt(1, exerciseId);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    SolutionsExerciseUsers solutionsExerciseUsers1 = new SolutionsExerciseUsers();
                    solutionsExerciseUsers1.setUserId(resultSet.getInt("user_id"));
                    solutionsExerciseUsers1.setSolutionId(resultSet.getInt("solution_id"));
                    solutionsExerciseUsers1.setUpdated(resultSet.getDate("date_updated"));
                    solutionsExerciseUsers1.setExerciseName(resultSet.getString("exercise_name"));
                    solutionsExerciseUsers1.setExerciseId(resultSet.getInt("exercise_id"));
                    solutionsExerciseUsers1.setUsername(resultSet.getString("username"));
                    solutionsExerciseUsers = addToArray(solutionsExerciseUsers1, solutionsExerciseUsers);
                }
                return solutionsExerciseUsers;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
    }
}
