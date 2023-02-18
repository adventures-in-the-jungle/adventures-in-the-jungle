import io.github.adventures_in_the_jungle.logic.game.Scenario;
import io.github.adventures_in_the_jungle.logic.initialization.AppStoragePaths;
import io.github.adventures_in_the_jungle.logic.initialization.Setup;
import org.junit.jupiter.api.Test;
import java.sql.*;
import java.util.ArrayList;

public class DBReadTest {


    @Test
    public void DBReadTest(){

        try {
            Setup.FirstTimeSetup();
        } catch (Exception e) {
            System.out.println("The process of copying the database to the user's home directory failed!");
            assert false;
        }

        String connectionString = AppStoragePaths.GetDBConnectionString();
        String query = "SELECT * FROM SCENARIO";

        System.out.println("DB Connection String: " + connectionString);

        Connection databaseConnection = null;
        Statement databaseStatement = null;
        ResultSet databaseResultSet = null;

        try {
            databaseConnection = DriverManager.getConnection(connectionString);
            databaseStatement = databaseConnection.createStatement();
            databaseResultSet = databaseStatement.executeQuery(query);

            ArrayList<Scenario> scenarioList = new ArrayList<Scenario>();

            while(databaseResultSet.next())
            {
                int scenarioID = databaseResultSet.getInt("SCENARIO_ID");
                String scenarioText = databaseResultSet.getString("SCENARIO_TEXT");
                boolean scenarioIsEnd = databaseResultSet.getBoolean("SCENARIO_IS_END");
                boolean scenarioIsWon = databaseResultSet.getBoolean("SCENARIO_PLAYER_WON");
                Scenario testScenario = new Scenario(scenarioID, scenarioText, scenarioIsEnd, scenarioIsWon);
                scenarioList.add(testScenario);
            }

            for(int i = 0; i < scenarioList.size(); i++)
            {
                Scenario currentScenario = scenarioList.get(i);
                System.out.println("For scenario ID " + currentScenario.getScenarioID() + ", the text is: " + currentScenario.getScenarioText());
                System.out.println("For scenario ID " + currentScenario.getScenarioID() + ", the scenario end flag is set to: " + currentScenario.getScenarioIsEnd());
                System.out.println("For scenario ID " + currentScenario.getScenarioID() + ", the scenario won flag is set to: " + currentScenario.getScenarioIsWon());
            }

            assert true;
        }
        catch(Exception e){
            assert false;
           System.out.println("Database connection failed!");
        }
        finally {
            if(databaseConnection != null)
            {
                try {
                    databaseConnection.close();
                } catch (SQLException e) {
                    assert false;
                    System.err.println("The database connection failed to close!");
                }
            }
            if(databaseStatement != null)
            {
                try {
                    databaseStatement.close();
                } catch (SQLException e) {
                    assert false;
                    System.err.println("The database statement failed to close!");
                }
            }
            if(databaseResultSet != null)
            {
                try {
                    databaseResultSet.close();
                } catch (SQLException e) {
                    assert false;
                    System.err.println("The database result set failed to close!");
                }
            }
        }
    }
}
