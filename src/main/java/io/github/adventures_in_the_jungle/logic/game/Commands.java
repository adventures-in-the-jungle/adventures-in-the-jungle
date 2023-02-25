package io.github.adventures_in_the_jungle.logic.game;

import java.text.DateFormat;
import java.text.Format;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

/**
 * An enumeration to manage the commands passed to the program.
 */
public enum Commands {
    HELP, TIME, EXIT;

    /**
     * Retrieves the current date and time in Tokyo, in the Japanese language.
     * @return A string formatted in the Japanese locale.
     */
    private static String GetJapanDateTime()
    {
        // Create a new date with the time zone of Tokyo.
        ZonedDateTime japanTime = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));

        // Declare an object to manage the Japanese date format locale.
        DateTimeFormatter japaneseDateFormat = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL).withLocale(Locale.JAPANESE);

        // Return the date and time in Tokyo, in the Japanese language.
        return japanTime.format(japaneseDateFormat);
    }

    /**
     * A static helper method to manage commands passed to the program.
     * @param m_command The command passed to the program.
     * @return A string containing the command feedback.
     */
    public static String GetCommandFeedback(Commands m_command)
    {
        String feedback = new String();
        switch (m_command)
        {
            case HELP -> feedback = "Please enter in a command containing your choice or type in EXIT to end the program.";
            case EXIT -> feedback = "The program has ended. Thank you for playing!";
            case TIME -> feedback = "The current time in Tokyo is " + Commands.GetJapanDateTime();
        }
        return feedback;
    }
}
