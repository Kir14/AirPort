
import com.skillbox.airport.Airport;

import java.util.Calendar;

/*
Распечатайте с помощью библиотеки airport.jar время вылета и модели самолётов, вылетающих в ближайшие два часа.
 */

public class Main {
    public static void main(String[] args) {
        Airport airport = Airport.getInstance();

        airport.getTerminals().forEach(terminal -> {
            terminal.getFlights().stream()
                    .filter(flight -> {
                        Calendar now = Calendar.getInstance();
                        Calendar then = Calendar.getInstance();
                        then.add(Calendar.HOUR, 2);
                        Calendar flightDate = Calendar.getInstance();
                        flightDate.setTime(flight.getDate());
                        return now.before(flightDate) && then.after(flightDate);
                    })
                    .forEach(flight -> {
                        System.out.println("Время вылета " + flight.getDate() + ", модель самолета " + flight.getAircraft().getModel());
                    });
        });
    }
}
