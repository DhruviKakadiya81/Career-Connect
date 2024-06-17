/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package SessionPCG;

import EntityPC.ApprovedJob;
import java.util.Calendar;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;

/**
 *
 * @author HP
 */
@Stateless
public class ChartBean {

    @PersistenceContext(unitName = "project_sem8_persistence_unit")
    private EntityManager entityManager;

    public long countJobRequestsInMay() {
        try {
            // Set up calendar instances to calculate the start and end dates for May
            Calendar calStart = Calendar.getInstance();
            calStart.set(Calendar.MONTH, Calendar.MAY);
            calStart.set(Calendar.DAY_OF_MONTH, 1);
            calStart.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            Calendar calEnd = Calendar.getInstance();
            calEnd.set(Calendar.MONTH, Calendar.JUNE);
            calEnd.set(Calendar.DAY_OF_MONTH, 1);
            calEnd.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            // Query to count job requests within the specified date range (May only)
            return entityManager.createQuery(
                    "SELECT COUNT(jr) FROM JobRequest jr "
                    + "WHERE jr.requestedDate >= :startDate "
                    + "AND jr.requestedDate < :endDate", Long.class)
                    .setParameter("startDate", calStart.getTime(), TemporalType.DATE)
                    .setParameter("endDate", calEnd.getTime(), TemporalType.DATE)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return -1; // Handle exceptions as needed
        }
    }

    public long countJobRequestsInJanuary() {
        try {
            Calendar calStart = Calendar.getInstance();
            calStart.set(Calendar.MONTH, Calendar.JANUARY);
            calStart.set(Calendar.DAY_OF_MONTH, 1);
            calStart.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            Calendar calEnd = Calendar.getInstance();
            calEnd.set(Calendar.MONTH, Calendar.FEBRUARY);
            calEnd.set(Calendar.DAY_OF_MONTH, 1);
            calEnd.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            return entityManager.createQuery(
                    "SELECT COUNT(jr) FROM JobRequest jr "
                    + "WHERE jr.requestedDate >= :startDate "
                    + "AND jr.requestedDate < :endDate", Long.class)
                    .setParameter("startDate", calStart.getTime(), TemporalType.DATE)
                    .setParameter("endDate", calEnd.getTime(), TemporalType.DATE)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return -1; // Handle exceptions as needed
        }
    }

    public long countJobRequestsInFebruary() {
        try {
            Calendar calStart = Calendar.getInstance();
            calStart.set(Calendar.MONTH, Calendar.FEBRUARY);
            calStart.set(Calendar.DAY_OF_MONTH, 1);
            calStart.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            Calendar calEnd = Calendar.getInstance();
            calEnd.set(Calendar.MONTH, Calendar.MARCH);
            calEnd.set(Calendar.DAY_OF_MONTH, 1);
            calEnd.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            return entityManager.createQuery(
                    "SELECT COUNT(jr) FROM JobRequest jr "
                    + "WHERE jr.requestedDate >= :startDate "
                    + "AND jr.requestedDate < :endDate", Long.class)
                    .setParameter("startDate", calStart.getTime(), TemporalType.DATE)
                    .setParameter("endDate", calEnd.getTime(), TemporalType.DATE)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return -1; // Handle exceptions as needed
        }
    }

    public long countJobRequestsInMarch() {
        try {
            Calendar calStart = Calendar.getInstance();
            calStart.set(Calendar.MONTH, Calendar.MARCH);
            calStart.set(Calendar.DAY_OF_MONTH, 1);
            calStart.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            Calendar calEnd = Calendar.getInstance();
            calEnd.set(Calendar.MONTH, Calendar.APRIL);
            calEnd.set(Calendar.DAY_OF_MONTH, 1);
            calEnd.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            return entityManager.createQuery(
                    "SELECT COUNT(jr) FROM JobRequest jr "
                    + "WHERE jr.requestedDate >= :startDate "
                    + "AND jr.requestedDate < :endDate", Long.class)
                    .setParameter("startDate", calStart.getTime(), TemporalType.DATE)
                    .setParameter("endDate", calEnd.getTime(), TemporalType.DATE)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return -1; // Handle exceptions as needed
        }
    }

    public long countJobRequestsInApril() {
        try {
            Calendar calStart = Calendar.getInstance();
            calStart.set(Calendar.MONTH, Calendar.APRIL);
            calStart.set(Calendar.DAY_OF_MONTH, 1);
            calStart.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            Calendar calEnd = Calendar.getInstance();
            calEnd.set(Calendar.MONTH, Calendar.MAY);
            calEnd.set(Calendar.DAY_OF_MONTH, 1);
            calEnd.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            return entityManager.createQuery(
                    "SELECT COUNT(jr) FROM JobRequest jr "
                    + "WHERE jr.requestedDate >= :startDate "
                    + "AND jr.requestedDate < :endDate", Long.class)
                    .setParameter("startDate", calStart.getTime(), TemporalType.DATE)
                    .setParameter("endDate", calEnd.getTime(), TemporalType.DATE)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return -1; // Handle exceptions as needed
        }
    }

    public long countJobRequestsInJune() {
        try {
            Calendar calStart = Calendar.getInstance();
            calStart.set(Calendar.MONTH, Calendar.JUNE);
            calStart.set(Calendar.DAY_OF_MONTH, 1);
            calStart.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            Calendar calEnd = Calendar.getInstance();
            calEnd.set(Calendar.MONTH, Calendar.JULY);
            calEnd.set(Calendar.DAY_OF_MONTH, 1);
            calEnd.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            return entityManager.createQuery(
                    "SELECT COUNT(jr) FROM JobRequest jr "
                    + "WHERE jr.requestedDate >= :startDate "
                    + "AND jr.requestedDate < :endDate", Long.class)
                    .setParameter("startDate", calStart.getTime(), TemporalType.DATE)
                    .setParameter("endDate", calEnd.getTime(), TemporalType.DATE)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return -1; // Handle exceptions as needed
        }
    }

    public long countJobRequestsInJuly() {
        try {
            Calendar calStart = Calendar.getInstance();
            calStart.set(Calendar.MONTH, Calendar.JULY);
            calStart.set(Calendar.DAY_OF_MONTH, 1);
            calStart.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            Calendar calEnd = Calendar.getInstance();
            calEnd.set(Calendar.MONTH, Calendar.AUGUST);
            calEnd.set(Calendar.DAY_OF_MONTH, 1);
            calEnd.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            return entityManager.createQuery(
                    "SELECT COUNT(jr) FROM JobRequest jr "
                    + "WHERE jr.requestedDate >= :startDate "
                    + "AND jr.requestedDate < :endDate", Long.class)
                    .setParameter("startDate", calStart.getTime(), TemporalType.DATE)
                    .setParameter("endDate", calEnd.getTime(), TemporalType.DATE)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return -1; // Handle exceptions as needed
        }
    }

    public long countJobRequestsInAugust() {
        try {
            Calendar calStart = Calendar.getInstance();
            calStart.set(Calendar.MONTH, Calendar.AUGUST);
            calStart.set(Calendar.DAY_OF_MONTH, 1);
            calStart.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            Calendar calEnd = Calendar.getInstance();
            calEnd.set(Calendar.MONTH, Calendar.SEPTEMBER);
            calEnd.set(Calendar.DAY_OF_MONTH, 1);
            calEnd.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            return entityManager.createQuery(
                    "SELECT COUNT(jr) FROM JobRequest jr "
                    + "WHERE jr.requestedDate >= :startDate "
                    + "AND jr.requestedDate < :endDate", Long.class)
                    .setParameter("startDate", calStart.getTime(), TemporalType.DATE)
                    .setParameter("endDate", calEnd.getTime(), TemporalType.DATE)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return -1; // Handle exceptions as needed
        }
    }

    public long countJobRequestsInSeptember() {
        try {
            Calendar calStart = Calendar.getInstance();
            calStart.set(Calendar.MONTH, Calendar.SEPTEMBER);
            calStart.set(Calendar.DAY_OF_MONTH, 1);
            calStart.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            Calendar calEnd = Calendar.getInstance();
            calEnd.set(Calendar.MONTH, Calendar.OCTOBER);
            calEnd.set(Calendar.DAY_OF_MONTH, 1);
            calEnd.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            return entityManager.createQuery(
                    "SELECT COUNT(jr) FROM JobRequest jr "
                    + "WHERE jr.requestedDate >= :startDate "
                    + "AND jr.requestedDate < :endDate", Long.class)
                    .setParameter("startDate", calStart.getTime(), TemporalType.DATE)
                    .setParameter("endDate", calEnd.getTime(), TemporalType.DATE)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return -1; // Handle exceptions as needed
        }
    }

    public long countJobRequestsInOctober() {
        try {
            Calendar calStart = Calendar.getInstance();
            calStart.set(Calendar.MONTH, Calendar.OCTOBER);
            calStart.set(Calendar.DAY_OF_MONTH, 1);
            calStart.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            Calendar calEnd = Calendar.getInstance();
            calEnd.set(Calendar.MONTH, Calendar.NOVEMBER);
            calEnd.set(Calendar.DAY_OF_MONTH, 1);
            calEnd.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            return entityManager.createQuery(
                    "SELECT COUNT(jr) FROM JobRequest jr "
                    + "WHERE jr.requestedDate >= :startDate "
                    + "AND jr.requestedDate < :endDate", Long.class)
                    .setParameter("startDate", calStart.getTime(), TemporalType.DATE)
                    .setParameter("endDate", calEnd.getTime(), TemporalType.DATE)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return -1; // Handle exceptions as needed
        }
    }

    public long countJobRequestsInNovember() {
        try {
            Calendar calStart = Calendar.getInstance();
            calStart.set(Calendar.MONTH, Calendar.NOVEMBER);
            calStart.set(Calendar.DAY_OF_MONTH, 1);
            calStart.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            Calendar calEnd = Calendar.getInstance();
            calEnd.set(Calendar.MONTH, Calendar.DECEMBER);
            calEnd.set(Calendar.DAY_OF_MONTH, 1);
            calEnd.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            return entityManager.createQuery(
                    "SELECT COUNT(jr) FROM JobRequest jr "
                    + "WHERE jr.requestedDate >= :startDate "
                    + "AND jr.requestedDate < :endDate", Long.class)
                    .setParameter("startDate", calStart.getTime(), TemporalType.DATE)
                    .setParameter("endDate", calEnd.getTime(), TemporalType.DATE)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return -1; // Handle exceptions as needed
        }
    }

    public long countJobRequestsInDecember() {
        try {
            Calendar calStart = Calendar.getInstance();
            calStart.set(Calendar.MONTH, Calendar.DECEMBER);
            calStart.set(Calendar.DAY_OF_MONTH, 1);
            calStart.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            Calendar calEnd = Calendar.getInstance();
            calEnd.set(Calendar.MONTH, Calendar.JANUARY);
            calEnd.set(Calendar.DAY_OF_MONTH, 1);
            calEnd.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR) + 1);

            return entityManager.createQuery(
                    "SELECT COUNT(jr) FROM JobRequest jr "
                    + "WHERE jr.requestedDate >= :startDate "
                    + "AND jr.requestedDate < :endDate", Long.class)
                    .setParameter("startDate", calStart.getTime(), TemporalType.DATE)
                    .setParameter("endDate", calEnd.getTime(), TemporalType.DATE)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return -1; // Handle exceptions as needed
        }
    }

    public long countInterviewsInJanuary() {
        try {
            Calendar calStart = Calendar.getInstance();
            calStart.set(Calendar.MONTH, Calendar.JANUARY);
            calStart.set(Calendar.DAY_OF_MONTH, 1);
            calStart.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            Calendar calEnd = Calendar.getInstance();
            calEnd.set(Calendar.MONTH, Calendar.FEBRUARY);
            calEnd.set(Calendar.DAY_OF_MONTH, 1);
            calEnd.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            return entityManager.createQuery(
                    "SELECT COUNT(i) FROM Interview i "
                    + "WHERE i.interviewDate >= :startDate "
                    + "AND i.interviewDate < :endDate", Long.class)
                    .setParameter("startDate", calStart.getTime(), TemporalType.DATE)
                    .setParameter("endDate", calEnd.getTime(), TemporalType.DATE)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public long countInterviewsInFebruary() {
        try {
            Calendar calStart = Calendar.getInstance();
            calStart.set(Calendar.MONTH, Calendar.FEBRUARY);
            calStart.set(Calendar.DAY_OF_MONTH, 1);
            calStart.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            Calendar calEnd = Calendar.getInstance();
            calEnd.set(Calendar.MONTH, Calendar.MARCH);
            calEnd.set(Calendar.DAY_OF_MONTH, 1);
            calEnd.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            return entityManager.createQuery(
                    "SELECT COUNT(i) FROM Interview i "
                    + "WHERE i.interviewDate >= :startDate "
                    + "AND i.interviewDate < :endDate", Long.class)
                    .setParameter("startDate", calStart.getTime(), TemporalType.DATE)
                    .setParameter("endDate", calEnd.getTime(), TemporalType.DATE)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public long countInterviewsInMarch() {
        try {
            Calendar calStart = Calendar.getInstance();
            calStart.set(Calendar.MONTH, Calendar.MARCH);
            calStart.set(Calendar.DAY_OF_MONTH, 1);
            calStart.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            Calendar calEnd = Calendar.getInstance();
            calEnd.set(Calendar.MONTH, Calendar.APRIL);
            calEnd.set(Calendar.DAY_OF_MONTH, 1);
            calEnd.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            return entityManager.createQuery(
                    "SELECT COUNT(i) FROM Interview i "
                    + "WHERE i.interviewDate >= :startDate "
                    + "AND i.interviewDate < :endDate", Long.class)
                    .setParameter("startDate", calStart.getTime(), TemporalType.DATE)
                    .setParameter("endDate", calEnd.getTime(), TemporalType.DATE)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public long countInterviewsInApril() {
        try {
            Calendar calStart = Calendar.getInstance();
            calStart.set(Calendar.MONTH, Calendar.APRIL);
            calStart.set(Calendar.DAY_OF_MONTH, 1);
            calStart.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            Calendar calEnd = Calendar.getInstance();
            calEnd.set(Calendar.MONTH, Calendar.MAY);
            calEnd.set(Calendar.DAY_OF_MONTH, 1);
            calEnd.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            return entityManager.createQuery(
                    "SELECT COUNT(i) FROM Interview i "
                    + "WHERE i.interviewDate >= :startDate "
                    + "AND i.interviewDate < :endDate", Long.class)
                    .setParameter("startDate", calStart.getTime(), TemporalType.DATE)
                    .setParameter("endDate", calEnd.getTime(), TemporalType.DATE)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public long countInterviewsInMay() {
        try {
            Calendar calStart = Calendar.getInstance();
            calStart.set(Calendar.MONTH, Calendar.MAY);
            calStart.set(Calendar.DAY_OF_MONTH, 1);
            calStart.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            Calendar calEnd = Calendar.getInstance();
            calEnd.set(Calendar.MONTH, Calendar.JUNE);
            calEnd.set(Calendar.DAY_OF_MONTH, 1);
            calEnd.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            return entityManager.createQuery(
                    "SELECT COUNT(i) FROM Interview i "
                    + "WHERE i.interviewDate >= :startDate "
                    + "AND i.interviewDate < :endDate", Long.class)
                    .setParameter("startDate", calStart.getTime(), TemporalType.DATE)
                    .setParameter("endDate", calEnd.getTime(), TemporalType.DATE)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public long countInterviewsInJuly() {
        try {
            Calendar calStart = Calendar.getInstance();
            calStart.set(Calendar.MONTH, Calendar.JULY);
            calStart.set(Calendar.DAY_OF_MONTH, 1);
            calStart.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            Calendar calEnd = Calendar.getInstance();
            calEnd.set(Calendar.MONTH, Calendar.AUGUST);
            calEnd.set(Calendar.DAY_OF_MONTH, 1);
            calEnd.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            return entityManager.createQuery(
                    "SELECT COUNT(i) FROM Interview i "
                    + "WHERE i.interviewDate >= :startDate "
                    + "AND i.interviewDate < :endDate", Long.class)
                    .setParameter("startDate", calStart.getTime(), TemporalType.DATE)
                    .setParameter("endDate", calEnd.getTime(), TemporalType.DATE)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public long countInterviewsInAugust() {
        try {
            Calendar calStart = Calendar.getInstance();
            calStart.set(Calendar.MONTH, Calendar.AUGUST);
            calStart.set(Calendar.DAY_OF_MONTH, 1);
            calStart.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            Calendar calEnd = Calendar.getInstance();
            calEnd.set(Calendar.MONTH, Calendar.SEPTEMBER);
            calEnd.set(Calendar.DAY_OF_MONTH, 1);
            calEnd.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            return entityManager.createQuery(
                    "SELECT COUNT(i) FROM Interview i "
                    + "WHERE i.interviewDate >= :startDate "
                    + "AND i.interviewDate < :endDate", Long.class)
                    .setParameter("startDate", calStart.getTime(), TemporalType.DATE)
                    .setParameter("endDate", calEnd.getTime(), TemporalType.DATE)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public long countInterviewsInSeptember() {
        try {
            Calendar calStart = Calendar.getInstance();
            calStart.set(Calendar.MONTH, Calendar.SEPTEMBER);
            calStart.set(Calendar.DAY_OF_MONTH, 1);
            calStart.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            Calendar calEnd = Calendar.getInstance();
            calEnd.set(Calendar.MONTH, Calendar.OCTOBER);
            calEnd.set(Calendar.DAY_OF_MONTH, 1);
            calEnd.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            return entityManager.createQuery(
                    "SELECT COUNT(i) FROM Interview i "
                    + "WHERE i.interviewDate >= :startDate "
                    + "AND i.interviewDate < :endDate", Long.class)
                    .setParameter("startDate", calStart.getTime(), TemporalType.DATE)
                    .setParameter("endDate", calEnd.getTime(), TemporalType.DATE)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public long countInterviewsInOctober() {
        try {
            Calendar calStart = Calendar.getInstance();
            calStart.set(Calendar.MONTH, Calendar.OCTOBER);
            calStart.set(Calendar.DAY_OF_MONTH, 1);
            calStart.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            Calendar calEnd = Calendar.getInstance();
            calEnd.set(Calendar.MONTH, Calendar.NOVEMBER);
            calEnd.set(Calendar.DAY_OF_MONTH, 1);
            calEnd.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            return entityManager.createQuery(
                    "SELECT COUNT(i) FROM Interview i "
                    + "WHERE i.interviewDate >= :startDate "
                    + "AND i.interviewDate < :endDate", Long.class)
                    .setParameter("startDate", calStart.getTime(), TemporalType.DATE)
                    .setParameter("endDate", calEnd.getTime(), TemporalType.DATE)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public long countInterviewsInNovember() {
        try {
            Calendar calStart = Calendar.getInstance();
            calStart.set(Calendar.MONTH, Calendar.NOVEMBER);
            calStart.set(Calendar.DAY_OF_MONTH, 1);
            calStart.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            Calendar calEnd = Calendar.getInstance();
            calEnd.set(Calendar.MONTH, Calendar.DECEMBER);
            calEnd.set(Calendar.DAY_OF_MONTH, 1);
            calEnd.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            return entityManager.createQuery(
                    "SELECT COUNT(i) FROM Interview i "
                    + "WHERE i.interviewDate >= :startDate "
                    + "AND i.interviewDate < :endDate", Long.class)
                    .setParameter("startDate", calStart.getTime(), TemporalType.DATE)
                    .setParameter("endDate", calEnd.getTime(), TemporalType.DATE)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public long countInterviewsInDecember() {
        try {
            Calendar calStart = Calendar.getInstance();
            calStart.set(Calendar.MONTH, Calendar.DECEMBER);
            calStart.set(Calendar.DAY_OF_MONTH, 1);
            calStart.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            Calendar calEnd = Calendar.getInstance();
            calEnd.set(Calendar.MONTH, Calendar.JANUARY);
            calEnd.set(Calendar.DAY_OF_MONTH, 1);
            calEnd.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR) + 1);

            return entityManager.createQuery(
                    "SELECT COUNT(i) FROM Interview i "
                    + "WHERE i.interviewDate >= :startDate "
                    + "AND i.interviewDate < :endDate", Long.class)
                    .setParameter("startDate", calStart.getTime(), TemporalType.DATE)
                    .setParameter("endDate", calEnd.getTime(), TemporalType.DATE)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

    }

    public long countApprovedJobsInJanuary() {
        try {
            Calendar calStart = Calendar.getInstance();
            calStart.set(Calendar.MONTH, Calendar.JANUARY);
            calStart.set(Calendar.DAY_OF_MONTH, 1);
            calStart.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            Calendar calEnd = Calendar.getInstance();
            calEnd.set(Calendar.MONTH, Calendar.FEBRUARY);
            calEnd.set(Calendar.DAY_OF_MONTH, 1);
            calEnd.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            return entityManager.createQuery(
                    "SELECT COUNT(a) FROM ApprovedJob a "
                    + "WHERE a.approvedDate >= :startDate "
                    + "AND a.approvedDate < :endDate", Long.class)
                    .setParameter("startDate", calStart.getTime(), TemporalType.DATE)
                    .setParameter("endDate", calEnd.getTime(), TemporalType.DATE)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public long countApprovedJobsInFebruary() {
        try {
            Calendar calStart = Calendar.getInstance();
            calStart.set(Calendar.MONTH, Calendar.FEBRUARY);
            calStart.set(Calendar.DAY_OF_MONTH, 1);
            calStart.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            Calendar calEnd = Calendar.getInstance();
            calEnd.set(Calendar.MONTH, Calendar.MARCH);
            calEnd.set(Calendar.DAY_OF_MONTH, 1);
            calEnd.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            return entityManager.createQuery(
                    "SELECT COUNT(a) FROM ApprovedJob a "
                    + "WHERE a.approvedDate >= :startDate "
                    + "AND a.approvedDate < :endDate", Long.class)
                    .setParameter("startDate", calStart.getTime(), TemporalType.DATE)
                    .setParameter("endDate", calEnd.getTime(), TemporalType.DATE)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public long countApprovedJobsInMarch() {
        try {
            Calendar calStart = Calendar.getInstance();
            calStart.set(Calendar.MONTH, Calendar.MARCH);
            calStart.set(Calendar.DAY_OF_MONTH, 1);
            calStart.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            Calendar calEnd = Calendar.getInstance();
            calEnd.set(Calendar.MONTH, Calendar.APRIL);
            calEnd.set(Calendar.DAY_OF_MONTH, 1);
            calEnd.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            return entityManager.createQuery(
                    "SELECT COUNT(a) FROM ApprovedJob a "
                    + "WHERE a.approvedDate >= :startDate "
                    + "AND a.approvedDate < :endDate", Long.class)
                    .setParameter("startDate", calStart.getTime(), TemporalType.DATE)
                    .setParameter("endDate", calEnd.getTime(), TemporalType.DATE)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public long countApprovedJobsInApril() {
        try {
            Calendar calStart = Calendar.getInstance();
            calStart.set(Calendar.MONTH, Calendar.APRIL);
            calStart.set(Calendar.DAY_OF_MONTH, 1);
            calStart.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            Calendar calEnd = Calendar.getInstance();
            calEnd.set(Calendar.MONTH, Calendar.MAY);
            calEnd.set(Calendar.DAY_OF_MONTH, 1);
            calEnd.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            return entityManager.createQuery(
                    "SELECT COUNT(a) FROM ApprovedJob a "
                    + "WHERE a.approvedDate >= :startDate "
                    + "AND a.approvedDate < :endDate", Long.class)
                    .setParameter("startDate", calStart.getTime(), TemporalType.DATE)
                    .setParameter("endDate", calEnd.getTime(), TemporalType.DATE)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public long countApprovedJobsInMay() {
        try {
            Calendar calStart = Calendar.getInstance();
            calStart.set(Calendar.MONTH, Calendar.MAY);
            calStart.set(Calendar.DAY_OF_MONTH, 1);
            calStart.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            Calendar calEnd = Calendar.getInstance();
            calEnd.set(Calendar.MONTH, Calendar.JUNE);
            calEnd.set(Calendar.DAY_OF_MONTH, 1);
            calEnd.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            return entityManager.createQuery(
                    "SELECT COUNT(a) FROM ApprovedJob a "
                    + "WHERE a.approvedDate >= :startDate "
                    + "AND a.approvedDate < :endDate", Long.class)
                    .setParameter("startDate", calStart.getTime(), TemporalType.DATE)
                    .setParameter("endDate", calEnd.getTime(), TemporalType.DATE)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public long countApprovedJobsInJune() {
        try {
            Calendar calStart = Calendar.getInstance();
            calStart.set(Calendar.MONTH, Calendar.JUNE);
            calStart.set(Calendar.DAY_OF_MONTH, 1);
            calStart.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            Calendar calEnd = Calendar.getInstance();
            calEnd.set(Calendar.MONTH, Calendar.JULY);
            calEnd.set(Calendar.DAY_OF_MONTH, 1);
            calEnd.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            return entityManager.createQuery(
                    "SELECT COUNT(a) FROM ApprovedJob a "
                    + "WHERE a.approvedDate >= :startDate "
                    + "AND a.approvedDate < :endDate", Long.class)
                    .setParameter("startDate", calStart.getTime(), TemporalType.DATE)
                    .setParameter("endDate", calEnd.getTime(), TemporalType.DATE)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public long countApprovedJobsInJuly() {
        try {
            Calendar calStart = Calendar.getInstance();
            calStart.set(Calendar.MONTH, Calendar.JULY);
            calStart.set(Calendar.DAY_OF_MONTH, 1);
            calStart.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            Calendar calEnd = Calendar.getInstance();
            calEnd.set(Calendar.MONTH, Calendar.AUGUST);
            calEnd.set(Calendar.DAY_OF_MONTH, 1);
            calEnd.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            return entityManager.createQuery(
                    "SELECT COUNT(a) FROM ApprovedJob a "
                    + "WHERE a.approvedDate >= :startDate "
                    + "AND a.approvedDate < :endDate", Long.class)
                    .setParameter("startDate", calStart.getTime(), TemporalType.DATE)
                    .setParameter("endDate", calEnd.getTime(), TemporalType.DATE)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public long countApprovedJobsInAugust() {
        try {
            Calendar calStart = Calendar.getInstance();
            calStart.set(Calendar.MONTH, Calendar.AUGUST);
            calStart.set(Calendar.DAY_OF_MONTH, 1);
            calStart.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            Calendar calEnd = Calendar.getInstance();
            calEnd.set(Calendar.MONTH, Calendar.SEPTEMBER);
            calEnd.set(Calendar.DAY_OF_MONTH, 1);
            calEnd.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            return entityManager.createQuery(
                    "SELECT COUNT(a) FROM ApprovedJob a "
                    + "WHERE a.approvedDate >= :startDate "
                    + "AND a.approvedDate < :endDate", Long.class)
                    .setParameter("startDate", calStart.getTime(), TemporalType.DATE)
                    .setParameter("endDate", calEnd.getTime(), TemporalType.DATE)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public long countApprovedJobsInSeptember() {
        try {
            Calendar calStart = Calendar.getInstance();
            calStart.set(Calendar.MONTH, Calendar.SEPTEMBER);
            calStart.set(Calendar.DAY_OF_MONTH, 1);
            calStart.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            Calendar calEnd = Calendar.getInstance();
            calEnd.set(Calendar.MONTH, Calendar.OCTOBER);
            calEnd.set(Calendar.DAY_OF_MONTH, 1);
            calEnd.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            return entityManager.createQuery(
                    "SELECT COUNT(a) FROM ApprovedJob a "
                    + "WHERE a.approvedDate >= :startDate "
                    + "AND a.approvedDate < :endDate", Long.class)
                    .setParameter("startDate", calStart.getTime(), TemporalType.DATE)
                    .setParameter("endDate", calEnd.getTime(), TemporalType.DATE)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public long countApprovedJobsInOctober() {
        try {
            Calendar calStart = Calendar.getInstance();
            calStart.set(Calendar.MONTH, Calendar.OCTOBER);
            calStart.set(Calendar.DAY_OF_MONTH, 1);
            calStart.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            Calendar calEnd = Calendar.getInstance();
            calEnd.set(Calendar.MONTH, Calendar.NOVEMBER);
            calEnd.set(Calendar.DAY_OF_MONTH, 1);
            calEnd.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            return entityManager.createQuery(
                    "SELECT COUNT(a) FROM ApprovedJob a "
                    + "WHERE a.approvedDate >= :startDate "
                    + "AND a.approvedDate < :endDate", Long.class)
                    .setParameter("startDate", calStart.getTime(), TemporalType.DATE)
                    .setParameter("endDate", calEnd.getTime(), TemporalType.DATE)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public long countApprovedJobsInNovember() {
        try {
            Calendar calStart = Calendar.getInstance();
            calStart.set(Calendar.MONTH, Calendar.NOVEMBER);
            calStart.set(Calendar.DAY_OF_MONTH, 1);
            calStart.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            Calendar calEnd = Calendar.getInstance();
            calEnd.set(Calendar.MONTH, Calendar.DECEMBER);
            calEnd.set(Calendar.DAY_OF_MONTH, 1);
            calEnd.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            return entityManager.createQuery(
                    "SELECT COUNT(a) FROM ApprovedJob a "
                    + "WHERE a.approvedDate >= :startDate "
                    + "AND a.approvedDate < :endDate", Long.class)
                    .setParameter("startDate", calStart.getTime(), TemporalType.DATE)
                    .setParameter("endDate", calEnd.getTime(), TemporalType.DATE)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public long countApprovedJobsInDecember() {
        try {
            Calendar calStart = Calendar.getInstance();
            calStart.set(Calendar.MONTH, Calendar.DECEMBER);
            calStart.set(Calendar.DAY_OF_MONTH, 1);
            calStart.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            Calendar calEnd = Calendar.getInstance();
            calEnd.set(Calendar.MONTH, Calendar.JANUARY);
            calEnd.set(Calendar.DAY_OF_MONTH, 1);
            calEnd.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR) + 1);

            return entityManager.createQuery(
                    "SELECT COUNT(a) FROM ApprovedJob a "
                    + "WHERE a.approvedDate >= :startDate "
                    + "AND a.approvedDate < :endDate", Long.class)
                    .setParameter("startDate", calStart.getTime(), TemporalType.DATE)
                    .setParameter("endDate", calEnd.getTime(), TemporalType.DATE)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
    
    
    public int getTotalCompanies() {
        return entityManager.createQuery("SELECT COUNT(r) FROM RoleMaster r WHERE r.groupname = 'Company'", Long.class).getSingleResult().intValue();
    }

    public int getTotalUsers() {
        return entityManager.createQuery("SELECT COUNT(r) FROM RoleMaster r WHERE r.groupname = 'User'", Long.class).getSingleResult().intValue();
    }
    
    public int getTotalJobs() {
        Long count = entityManager.createQuery("SELECT COUNT(j) FROM Job j", Long.class)
                                .getSingleResult();
        return count.intValue();
    }
    
    public Collection<ApprovedJob> displayApprovedJobs() {
    
            return entityManager.createNamedQuery("ApprovedJob.findAll").getResultList();

}
    
    
}
