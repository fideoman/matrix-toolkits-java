package no.uib.cipr.matrix.io;

import no.uib.cipr.matrix.sparse.AbstractIterativeSolver;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.*;
import java.util.UUID;

/**
 * Logger to help logging the partial results at running iterative solvers
 * into a csv file.
 */
public class SolverLogger {

    /**
     * The name of the csv file
     */
    private String fileName;

    /**
     * CSV writer object
     */
    private CSVPrinter printer;

    /**
     * Generated unique id for every solver running
     */
    private String taskID;

    /**
     * The given solver
     */
    private AbstractIterativeSolver solver;

    /**
     * The time at the beginning of the running, to log the time of the iterations
     */
    private long startTimeMillis;

    /**
     * The header of the log file
     */
    private String[] HEADERS = {"ID", "TIME", "SOLVER", "PRECONDITIONER", "ITERATION", "RESIDUAL"};

    public SolverLogger(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Create the csv writer with the given file,
     * generate an ID and
     * save the starting system time.
     *
     * @param solver we want to log
     */
    public void start(AbstractIterativeSolver solver) {
        try {
            File f = new File(fileName);
            boolean exist = f.exists();
            FileWriter out = new FileWriter(fileName, true);

            printer = new CSVPrinter(out, exist ? CSVFormat.DEFAULT : CSVFormat.DEFAULT.withHeader(HEADERS));
            taskID = UUID.randomUUID().toString();
            this.solver = solver;

            startTimeMillis = System.currentTimeMillis();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Write one row into the file,
     * using the data of the solver and the iteration monitor of the solver
     */
    public void log() {
        try {
            printer.printRecord(
                    taskID,
                    System.currentTimeMillis() - startTimeMillis,
                    solver.getClass().getSimpleName(),
                    solver.getPreconditioner().getClass().getSimpleName(),
                    solver.getIterationMonitor().iterations(),
                    solver.getIterationMonitor().residual()
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Close the csv writer, if exists.
     */
    public void close() {
        try {
            if (printer != null)
                printer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
