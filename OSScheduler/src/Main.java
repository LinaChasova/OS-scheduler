import java.io.*;
import java.text.*;
import java.util.*;

/**
 * Created by AlinaCh on 22.03.2017.
 */
public class Main {

    public static BinaryMaxHeap<Process> work;
    public static int rows;

    /**
     * reads input file and makes an array list of all the commands that needs te be ran
     * @return data -  a list of commands
     * @throws FileNotFoundException
     * @throws ParseException
     */
    public static ArrayList<Entry<Process>> read() throws FileNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("input.csv"));
        ArrayList<Entry<Process>> data = new ArrayList<>();
        String names = sc.nextLine();
        while (sc.hasNextLine()) {
            String[]temp = sc.nextLine().split(",");
            Entry<Process> inf = new Entry<>(new Process(temp[0],
                    Integer.parseInt(temp[1]), Integer.parseInt(temp[2])), Integer.parseInt(temp[3]));
            data.add(inf);
        }
        rows = data.size();
        return data;
    }

    /**
     * runs the command sequentially or by priority (if some of them are in queue)
     * keeps commands that are in queue in BinaryMaxHeap
     * @param data - list of all commands
     * @return name of the last command that was able to finish before 2 mins
     */
    public static String schedule(ArrayList<Entry<Process>> data) {
        String result = "";
        if (data.size() != 0) {
            int i = 0, time = 0;
            work = new BinaryMaxHeap<>(data.size());
            Entry<Process> current = data.get(i);
            time = current.item.timerequired;
            i++;
            while (i < rows && time <= 120000) {
                result = current.item.name;
                if (time > data.get(i).item.event) {
                    work.insert(data.get(i));
                    i++;
                } else if (work.size() == 0) {
                    current = data.get(i);
                    time = current.item.event + current.item.timerequired;
                    i++;
                } else {
                    current = work.deleteMaximum();
                    time = time + current.item.timerequired;
                }
            }
            while (time <= 120000) {
                result = current.item.name;
                if (work.size() != 0) {
                    current = work.deleteMaximum();
                    time = time + current.item.timerequired;
                } else
                    break;
            }
        }
        return result;
    }

    /**
     * writes the last command that was able to finish to the output file
     * @param s answer
     */
    public static void write(String s) {
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream("output.txt"), "ascii"))) { writer.write(s); }
        catch (IOException ex) { }
    }

    public static void main(String[] args) throws FileNotFoundException, ParseException {
        write(schedule(read()));
    }
}
