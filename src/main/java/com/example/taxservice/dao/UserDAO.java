package com.example.taxservice.dao;


import com.example.taxservice.connectionpool.ConnectionPool;
import com.example.taxservice.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    private static final String GET_ONE_BY_LOGIN = "SELECT * FROM tb_users WHERE login = ?";
    private static final String CREATE_USER = "INSERT INTO tb_users (login, password,is_legal) VALUES (?,?,?)";
    private static final String DELETE_USER_BY_LOGIN = "DELETE FROM tb_users WHERE login = ?";
    private static final String UPDATE_USER_BY_LOGIN = "UPDATE tb_users SET login = ? WHERE login = ?";


    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static Connection connection;


    public static void updateUserByLogin(String hasLogin, String setLogin) {
        if (assertHasUserByLogin(hasLogin)) {
            if (!assertHasUserByLogin(setLogin)) {
                connection = connectionPool.getConnection();
                try (PreparedStatement ps = connection.prepareStatement(UPDATE_USER_BY_LOGIN)) {
                    ps.setString(1, setLogin);
                    ps.setString(2, hasLogin);
                    ps.executeUpdate();
                } catch (SQLException exception) {
//            LOGGER.error(exception, exception);
                } finally {
                    connectionPool.releaseConnection(connection);
                }
            } else {
                System.out.println("Can't update login");
            }
        }
    }

    public static void deleteUserByLogin(String login) {
        if (assertHasUserByLogin(login)) {
            try (PreparedStatement ps = connection.prepareStatement(DELETE_USER_BY_LOGIN)) {
                ps.setString(1, login);
                ps.executeUpdate();
            } catch (SQLException exception) {
//                LOGGER.error(exception, exception);
            } finally {
                connectionPool.releaseConnection(connection);
            }
        }
    }

    public static void createNewUser(String login) throws SQLException {
        if (!assertHasUserByLogin(login)) {
            PreparedStatement ps = connection.prepareStatement(CREATE_USER);
            ps.setString(1, login);
            ps.setString(2, "pass");
            ps.setBoolean(3, false);
            ps.executeUpdate();
        }
    }


    public static User getUserByLogin(String login) {
        return getUserByStringParameter(login, GET_ONE_BY_LOGIN);
    }

    public static Boolean assertHasUserByLogin(String login) {
        User checkUserInDB = UserDAO.getUserByLogin(login);
        boolean answer = false;
        if (checkUserInDB != null) {
            if (checkUserInDB.getLogin().equals(login)) {
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
//            LOGGER.error(exception, exception);
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return user;
    }


    private static User getUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setLogin(resultSet.getString("login"));
        user.setPassword(resultSet.getString("password"));
        user.setLegal(resultSet.getBoolean("is_legal"));
        user.setInspector(resultSet.getBoolean("is_inspector"));
        return user;
    }

}
