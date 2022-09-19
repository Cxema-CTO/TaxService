package com.example.taxservice.dao;

import com.example.taxservice.connectionpool.ConnectionPool;
import com.example.taxservice.entity.Report;
import com.example.taxservice.password.EncodePassword;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static com.example.taxservice.dao.UserDAO.assertHasUserInDBbyUserName;

public class ReportDAO {

    private static final Logger LOGGER = Logger.getLogger(UserDAO.class);
    //
    private static final String GET_ALL_REPORTS = "SELECT * FROM tb_reports";
    private static final String GET_USER_ALL_REPORTS = "SELECT * FROM tb_reports WHERE user_name = ?";
    private static final String CREATE_NEW_REPORT = "INSERT INTO tb_reports (user_name, report_content, type) VALUES (?,?,?)";

    //    private static final String GET_ONE_REPORT_BY_ID = "SELECT * FROM tb_reports WHERE id = ?";
//    private static final String DELETE_ONE_REPORT_BY_ID = "SELECT * FROM tb_reports WHERE id = ?";
//    private static final String DELETE_USER_ALL_REPORTS = "SELECT * FROM tb_reports WHERE id = ?";
//    private static final String GET_ONE_BY_USERNAME = "SELECT * FROM tb_reports WHERE user_name = ?";


    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static Connection connection;

    public static void createNewReportInDB(String userName, String content, int type) throws SQLException {
            connection = connectionPool.getConnection();
            PreparedStatement ps;
            ps = connection.prepareStatement(CREATE_NEW_REPORT);
            ps.setString(1, userName);
            ps.setString(2, content);
            ps.setInt(3, type);
            ps.executeUpdate();
    }

    public static List<Report> getAllReports() {
        connection = connectionPool.getConnection();
        List<Report> reportList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_REPORTS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Report report = getReport(resultSet);
                reportList.add(report);
            }
//            userList.sort(Comparator.comparing(User::getUserName));
            reportList.sort(Comparator.comparing(Report::getId));
        } catch (SQLException exception) {
            LOGGER.error(exception, exception);
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return reportList;
    }

    public static List<Report> getAllUserReports(String userName) {
        connection = connectionPool.getConnection();
        List<Report> reportList = new ArrayList<>();
        if (assertHasUserInDBbyUserName(userName)) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_ALL_REPORTS)) {
                preparedStatement.setString(1, userName);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Report report = getReport(resultSet);
                    reportList.add(report);
                }
                reportList.sort(Comparator.comparing(Report::getId));
            } catch (SQLException exception) {
                LOGGER.error(exception, exception);
            } finally {
                connectionPool.releaseConnection(connection);
            }
        }
        return reportList;
    }


    private static Report getReport(ResultSet resultSet) throws SQLException {
        Report report = new Report();
        report.setId(resultSet.getInt("id"));
        report.setReportContent(resultSet.getString("report_content"));
        report.setAccepted(resultSet.getBoolean("is_accepted"));
        report.setReasonOfRefusal(resultSet.getString("reason_of_refusal"));
        report.setSubmissionDate(resultSet.getDate("submission_date"));
        report.setType(resultSet.getInt("type"));
        report.setUserName(resultSet.getString("user_name"));
        report.setSend(resultSet.getBoolean("is_send"));
        return report;
    }


}
