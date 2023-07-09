package org.ascending.training;

import org.ascending.training.model.Issue;
import org.ascending.training.repository.IssueJDBCDaoImpl;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        IssueJDBCDaoImpl issueJDBCDao = new IssueJDBCDaoImpl();
        List<Issue> issues = issueJDBCDao.getIssues();
        System.out.format("List of issues %s", issues);
    }
}
