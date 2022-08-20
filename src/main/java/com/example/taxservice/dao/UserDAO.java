package com.example.taxservice.dao;


import com.example.taxservice.connectionpool.ConnectionPool;
import com.example.taxservice.entity.User;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UserDAO {
    private static final Logger LOGGER = Logger.getLogger(UserDAO.class);
    private static final String GET_ALL_USERS = "SELECT * FROM tb_users";
    private static final String GET_ONE_BY_USERNAME = "SELECT * FROM tb_users WHERE user_name = ?";
    private static final String CREATE_NEW_USER = "INSERT INTO tb_users (user_name, password,is_legal) VALUES (?,?,?)";
    private static final String DELETE_USER = "DELETE FROM tb_users WHERE user_name = ?";
    private static final String UPDATE_USER_USERNAME = "UPDATE tb_users SET user_name = ? WHERE user_name = ?";
    private static final String UPDATE_USER_PASSWORD = "UPDATE tb_users SET password = ? WHERE user_name = ?";


    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static Connection connection;


    public static List<User> getAllUsers() {
        connection = connectionPool.getConnection();
        List<User> userList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_USERS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = getUser(resultSet);
                userList.add(user);
            }
//            userList.sort(Comparator.comparing(User::getUserName));
            userList.sort(Comparator.comparing(User::getId));
        } catch (SQLException exception) {
            LOGGER.error(exception, exception);
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return userList;
    }


    public static void updateUserNameInDB(String hasUserName, String setUserName) {
        if (assertHasUserInDBbyUserName(hasUserName)) {
            if (!assertHasUserInDBbyUserName(setUserName)) {
                connection = connectionPool.getConnection();
                try (PreparedStatement ps = connection.prepareStatement(UPDATE_USER_USERNAME)) {
                    ps.setString(1, setUserName);
                    ps.setString(2, hasUserName);
                    ps.executeUpdate();
                } catch (SQLException exception) {
                    LOGGER.error(exception, exception);
                } finally {
                    connectionPool.releaseConnection(connection);
                }
            } else {
                System.out.println("Username is already taken, choose another username");
            }
        }
    }


    public static void updateUserPasswordInDB(String userName, String newPassword) {
        if (assertHasUserInDBbyUserName(userName)) {
            connection = connectionPool.getConnection();
            try (PreparedStatement ps = connection.prepareStatement(UPDATE_USER_PASSWORD)) {
                ps.setString(1, newPassword);
                ps.setString(2, userName);
                ps.executeUpdate();
            } catch (SQLException exception) {
                LOGGER.error(exception, exception);
            } finally {
                connectionPool.releaseConnection(connection);
            }
        }
    }

    public static void deleteUserInDB(String userName) {
        if (assertHasUserInDBbyUserName(userName)) {
            connection = connectionPool.getConnection();
            try (PreparedStatement ps = connection.prepareStatement(DELETE_USER)) {
                ps.setString(1, userName);
                ps.executeUpdate();
            } catch (SQLException exception) {
                LOGGER.error(exception, exception);
            } finally {
                connectionPool.releaseConnection(connection);
            }
        }
    }


    public static void createNewUserInDB(String userName, String password, Boolean isLegal) throws SQLException {
        if (!assertHasUserInDBbyUserName(userName)) {
            PreparedStatement ps = connection.prepareStatement(CREATE_NEW_USER);
            ps.setString(1, userName);
            ps.setString(2, password);
            ps.setBoolean(3, isLegal);
            ps.executeUpdate();
        } else {
            System.out.println("Can't create, user with this username exists, choose another username");
        }
    }


    public static User getUserFromDB(String userName) {
        return getUserByStringParameter(userName, GET_ONE_BY_USERNAME);
    }

//    public static User getUserFromDBbyPassword(String userName) {
//        return getUserByStringParameter(userName, GET_ONE_BY_USERNAME);
//    }


    public static Boolean assertHasUserInDBbyUserName(String userName) {
        User checkUserInDB = UserDAO.getUserFromDB(userName);
        boolean answer = false;
        if (checkUserInDB != null) {
            if (checkUserInDB.getUserName().equals(userName)) {
                answer = true;
            }
        }
        return answer;
    }


    private static User getUserByStringParameter(String stringParameter, String sql) {
        connection = connectionPool.getConnection();
        User user = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, stringParameter);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = getUser(resultSet);
            }
        } catch (SQLException exception) {
            LOGGER.error(exception, exception);
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return user;
    }


    private static User getUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setUserName(resultSet.getString("user_name"));
        user.setPassword(resultSet.getString("password"));
        user.setLegal(resultSet.getBoolean("is_legal"));
        user.setInspector(resultSet.getBoolean("is_inspector"));
        return user;
    }


}
