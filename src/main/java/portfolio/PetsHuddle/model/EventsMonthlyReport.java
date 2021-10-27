package portfolio.PetsHuddle.model;

public class EventsMonthlyReport {

    private int numOfEventsInMonth;
    private int numOfPetsInMonthlyEvent;

    public EventsMonthlyReport(int numOfEventsInMonth, int numOfPetsInMonthlyEvent) {
        this.numOfEventsInMonth = numOfEventsInMonth;
        this.numOfPetsInMonthlyEvent = numOfPetsInMonthlyEvent;
    }

    public int getNumOfEventsInMonth() {
        return numOfEventsInMonth;
    }

    public void setNumOfEventsInMonth(int numOfEventsInMonth) {
        this.numOfEventsInMonth = numOfEventsInMonth;
    }

    public int getNumOfPetsInMonthlyEvent() {
        return numOfPetsInMonthlyEvent;
    }

    public void setNumOfPetsInMonthlyEvent(int numOfPetsInMonthlyEvent) {
        this.numOfPetsInMonthlyEvent = numOfPetsInMonthlyEvent;
    }
}
