package org.ascending.training.repository;

import junit.framework.TestCase;
import org.ascending.training.model.Issue;
import org.ascending.training.model.Employees;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static junit.framework.Assert.assertEquals;
public class IssueHibernateDaoImplTest {
    private IIssueDao issueHibernateDao;
    private IEmployeesDao employeeHibernateDao;

    private Issue i1;
    private Employees e1;
    private Employees e2;

    @Before
    public void setUp() {
        issueHibernateDao = new IssueHibernateDaoImpl();
        i1 = new Issue();
        //d1.setId(1);
        i1.setId((long) (Math.random()*(100L-1L)));
        i1.setProblemDescription("We ran into a problem when we ran a test. Please help us.");
        i1.setOpenDate("7/1/2023");
        i1.setPriority("High");
        issueHibernateDao.save(i1);
    }

    @After
    public void tearDown() {
        issueHibernateDao.delete(i1);
    }

    @Test
    public void getDepartmentsTest() {
        assertEquals(1, issueHibernateDao.getIssues().size());
    }
}

