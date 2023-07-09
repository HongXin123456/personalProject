package org.ascending.training.repository;

import org.ascending.training.model.Issue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IssueJDBCDaoImpl implements IIssueDao{
    static final String DB_URL = "jdbc:postgresql://localhost:2468/project_db";
    static final String USER = "admin";
    static final String PASS = "admin";

    @Override
    public void save(Issue issue) {

    }

    @Override
    public List<Issue> getIssues() {

        //Logger logger = LoggerFactory.getLogger(getClass());
        Logger logger = LoggerFactory.getLogger(IssueJDBCDaoImpl.class);

        //Step1: Prepare the required data model
        List<Issue> issues = new ArrayList<Issue>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            //Step2: Open a connection ->5 key points to connect db
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //Step3: Execute a query
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM issues";
            rs = stmt.executeQuery(sql);

            //Step4: Extract data from result set
            while(rs.next()) {
                Long id = rs.getLong("id");
                String problemDescription = rs.getString("problemDescription");
                String open_date = rs.getString("open_date");
                String close_date = rs.getString("close_date");
                String closed = rs.getString("closed");
                String priority = rs.getString("priority");

                Issue issue = new Issue();
                issue.setId(id);
                issue.setProblemDescription(problemDescription);
                issue.setOpenDate(open_date);
                issue.setCloseDate(close_date);
                issue.setClosed(closed);
                issue.setPriority(priority);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //Step6: finally block used to close resources
            try {
                if(rs != null) rs.close();
                if(stmt != null) stmt.close();
                if(conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        logger.info("Finish getDepartments {}", issues);
        return issues;

    }

    @Override
    public Issue getById(Long id) {
        return null;
    }

    @Override
    public boolean delete(Issue issue) {
        return false;
    }
}
