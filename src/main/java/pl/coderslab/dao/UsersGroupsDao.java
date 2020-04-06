package pl.coderslab.dao;

import pl.coderslab.model.UsersGroups;
import pl.coderslab.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class UsersGroupsDao {

    private static final String CREATE_USERGROUP_QUERY =
            "INSERT INTO users_groups(name) VALUES (?)";
    private static final String READ_USERGROUP_QUERY =
            "SELECT * FROM users_groups where id = ?";
    private static final String UPDATE_USERGROUP_QUERY =
            "UPDATE users_groups SET name = ? where id = ?";
    private static final String DELETE_USERGROUP_QUERY =
            "DELETE FROM users_groups WHERE id = ?";
    private static final String FIND_ALL_USERSGROUP_QUERY =
            "SELECT * FROM users_groups";


    public UsersGroups create(UsersGroups usersGroup) {
        try (Connection connection = DBUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_USERGROUP_QUERY, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, usersGroup.getName());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                usersGroup.setId(resultSet.getInt(1));
            }
            return usersGroup;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public UsersGroups read(int usersGroupId) {
        try (Connection connection = DBUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(READ_USERGROUP_QUERY);
            preparedStatement.setInt(1, usersGroupId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                UsersGroups usersGroups = new UsersGroups();
                usersGroups.setId(resultSet.getInt("id"));
                usersGroups.setName(resultSet.getString("name"));
                return usersGroups;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public UsersGroups[] findAll() {
        try (Connection conn = DBUtils.getConnection()) {
            UsersGroups[] usersGroups = new UsersGroups[0];
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_USERSGROUP_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                UsersGroups usersGroup = new UsersGroups();
                usersGroup.setId(resultSet.getInt("id"));
                usersGroup.setName(resultSet.getString("name"));
                usersGroups = addToArray(usersGroup, usersGroups);
            }
            return usersGroups;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public void update(UsersGroups usersGroups) {
        try (Connection conn = DBUtils.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(UPDATE_USERGROUP_QUERY);
            statement.setString(1, usersGroups.getName());
            statement.setInt(2, usersGroups.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int userGroupId) {
        try (Connection conn = DBUtils.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(DELETE_USERGROUP_QUERY);
            statement.setInt(1, userGroupId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public UsersGroups[] addToArray(UsersGroups userGroup, UsersGroups[] usersGroups) {
        usersGroups = Arrays.copyOf(usersGroups, usersGroups.length + 1);
        usersGroups[usersGroups.length - 1] = userGroup;
        return usersGroups;
    }
}
