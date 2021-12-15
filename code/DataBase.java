import java.util.Random;

public class DataBase {
    private int rows, columns;
    private int[] best, worst;
    private int[][] database, databaseBkp;

    private int[][] getDatabaseBkp() {
        return databaseBkp;
    }

    public int[][] getDatabase() {
        return database;
    }

    public int[] getBest() {
        return best;
    }

    public int[] getWorst() {
        return worst;
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    private void setDatabaseBkp() {
        this.databaseBkp = new int[getRows()][getColumns()];
    }

    private void setDatabase() {
        this.database = new int[getRows()][getColumns()];
    }

    private void setColumns(int columns) {
        this.columns = columns;
    }

    private void setRows(int rows) {
        this.rows = rows;
    }


    private void randomizerArray() {
        Random random = new Random();

        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getColumns(); j++) {
                getDatabaseBkp()[i][j] = random.nextInt(0, 9999);
            }
        }
        resetDatabase();
    }

    public void resetBest() {
        this.best = new int[getColumns()];

        for (int i = 0; i < getColumns(); i++) {
            getBest()[i] = i;
        }
    }

    public void resetWorst() {
        this.worst = new int[getColumns()];

        for (int i = 0; i < getColumns(); i++) {
            getWorst()[i] = getColumns() - i - 1;
        }
    }

    public void resetDatabase() {
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getColumns(); j++) {
                getDatabase()[i][j] = getDatabaseBkp()[i][j];
            }
        }
    }

    private void printArray(int[] array) {
        for (int i = 0; i < getColumns(); i++) {
            System.out.print(String.format("%10s", array[i]));
        }
        System.out.println("");
    }

    public void printBestWorst() {
        System.out.print(String.format("%15s", "Best case:"));
        printArray(getBest());
        System.out.print(String.format("%15s", "Worst case:"));
        printArray(getWorst());
        System.out.println("");
    }

    public void printDatabase() {
        for (int i = 0; i < getRows(); i++) {
            System.out.print(String.format("%15s", i + ":"));
            printArray(getDatabase()[i]);
        }
    }

    public DataBase(int row, int col) {
        setRows(row);
        setColumns(col);
        resetBest();
        resetWorst();
        setDatabaseBkp();
        setDatabase();
        randomizerArray();
    }

}
