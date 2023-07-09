package org.ascending.training.repository;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class IssueDaoTest {
    @Test
    public void getDepartmentsTest(){
       IssueJDBCDaoImpl issueDao = new IssueJDBCDaoImpl();
        assertEquals(0, issueDao.getIssues().size());
    }
}
