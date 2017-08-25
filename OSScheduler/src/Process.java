/**
 * Created by AlinaCh on 22.03.2017.
 */
public class Process {

    public String name = "";
    public Integer event;
    public Integer timerequired;

    /**
     * initializing of Process with given name, time of the start, and CPU time requires fot the command to run
     * @param name of the command
     * @param event time of the start of the command
     * @param timerequired CPU time requiered for the command to finish
     */
    public Process(String name, int event, int timerequired) {
        this.name = name;
        this.event = event;
        this.timerequired = timerequired;
    }

    /**
     * default initializing
     */
    public Process() {
        this.name = "";
        this.event = 0;
        this.timerequired = 0;
    }

    /**
     * text representation of the element
     * @return element
     */
    public String toString() {
        String result = name + " " + event.toString() + " " + timerequired.toString();
        return result;
    }
}
