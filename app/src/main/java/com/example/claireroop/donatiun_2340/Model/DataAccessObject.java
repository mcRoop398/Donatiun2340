package com.example.claireroop.donatiun_2340.Model;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * General interface for data access objects for this app.
 */

@SuppressWarnings("unused")
public interface DataAccessObject {
    /**
     * Gets the currently logged in user.
     * @return Logged in user. null if no user logged in.
     */
    Account getCurrentAccount();

    /**
     * Set the currently logged in user.
     * @param account Account to be logged in.
     */
    void setCurrentAccount(Account account);

    /**
     * Try a username and password against auth backend.
     * currentUser will be set if this succeeds.
    // * @param username username to check
     //* @param password password to check
     * @return if the user could be logged in
    // * @throws UserInputException on bad password
     * @throws NoSuchElementException on user not found
     */
    @SuppressWarnings("SameReturnValue")
   // boolean attemptLogin(String username, String password)
            //throws UserInputException, NoSuchElementException;

    /**
     * Gets the next available water source report ID.
     * @return available ID
     */
    //int getNewWaterSourceReportId();

    /**
     * Gets the next available water purity report ID.
     * @return available ID
     */
    //int getNewWaterPurityReportId();

    /**
     * Get all water source reports.
     * @return all water source reports
     */
    //List<WaterSourceReport> getWaterSourceReports();

    /**
     * Get all water purity reports.
     * @return all water purity reports
     */
    //List<WaterPurityReport> getWaterPurityReports();

    /**
     * Gets a list of water source reports that match the criteria.
     * @param location Location to search for.
     * @param radiusMeters Meters around location to search. (square radius)
     * @param year Target year.
     * @return A list of matching water source reports.
     */
    //List<WaterPurityReport>
    //getWaterPurityReportsByLocationYear(Location location, double radiusMeters, int year);

    /**
     * Get all log events.
     * @return All log events.
     */
    //List<LogEvent> getLogEvents();
    /**
     * Adds a new water source report to the list.
     * @param waterSourceReport Water source report to add.
     */
    //void addWaterSourceReport(WaterSourceReport waterSourceReport);
    /**
     * Adds a new water purity report to the list.
     * @param waterPurityReport Water purity report to add.
     */
    //void addWaterPurityReport(WaterPurityReport waterPurityReport);
    /**
     * Given an id/username, return a user object with a matching id.
     * @param id The id to search for.
     * @throws NoSuchElementException if a matching user could not be found.
     * @return The found user object.
     */
    Account getAccountById(String id);
    /**
     * Adds a new user to the stored users list. Does not do validation of user info.
     * @param account The account object to append to the user list.
     */
    void addAccount(Account account);

    /**
     * Store a log event.
     * @param logEvent Log event to store
     */
    //void addLogEvent(LogEvent logEvent);
}
