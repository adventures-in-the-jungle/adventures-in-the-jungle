package io.github.adventures_in_the_jungle.logic.database;

import io.github.adventures_in_the_jungle.logic.initialization.AppStoragePaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class DatabaseConnection {

    private Logger logger;

    private Connection databaseConnection;
    private Statement databaseStatement;
    private ResultSet databaseResultSet;

    private String activeQuery;

    public DatabaseConnection()
    {
        this.logger = LogManager.getLogger(DatabaseConnection.class.getName());
        this.logger.trace("Database Connection Created!");
    }

    public DatabaseConnection(String m_activeQuery)
    {
        this.logger = LogManager.getLogger(DatabaseConnection.class.getName());
        this.logger.trace("Database Connection Created!");
        this.setActiveQuery(m_activeQuery);
    }

    public ResultSet executeActiveQuery()
    {
        try {
            databaseConnection = DriverManager.getConnection(AppStoragePaths.GetDBConnectionString());
            databaseStatement = databaseConnection.createStatement();
            databaseResultSet = databaseStatement.executeQuery(this.activeQuery);
            logger.debug("The following query succeeded: " + this.activeQuery);
        } catch (SQLException e) {
            logger.error("There was an error in executing the following query: " + this.activeQuery);
            throw new RuntimeException(e);
        }

        return this.databaseResultSet;
    }

    public void close()
    {
        if (this.databaseConnection != null) {
            try {
                databaseConnection.close();
            } catch (SQLException e) {
                assert false;
                logger.error("The database connection failed to close!");
            }
        }
        if (this.databaseStatement != null) {
            try {
                databaseStatement.close();
            } catch (SQLException e) {
                assert false;
                logger.error("The database statement failed to close!");
            }
        }
        if (this.databaseResultSet != null) {
            try {
                databaseResultSet.close();
            } catch (SQLException e) {
                assert false;
                logger.error("The database result set failed to close!");
            }
        }
    }

    public String getActiveQuery() {
        return activeQuery;
    }

    public void setActiveQuery(String m_activeQuery) {
        this.activeQuery = m_activeQuery;
        logger.trace("Active Query Set: " + this.activeQuery);
    }
}
