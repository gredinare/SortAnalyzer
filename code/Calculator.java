public class Calculator {
    private Algorithms algorithms = new Algorithms();
    private DataBase database;
    private int[][] allComparisons;
    private double[][] analyzeResult;

    public Algorithms getAlgorithms() {
        return algorithms;
    }

    private int[][] getAllComparisons() {
        return allComparisons;
    }

    public double[][] getAnalyzeResult() {
        return analyzeResult;
    }

    private DataBase getDatabase() {
        return database;
    }

    private void setDatabase(int row, int col) {
        this.database = new DataBase(row, col);
    }

    private void setAllComparisons() {
        this.allComparisons = new int[getAlgorithms().getQtdAlgorithms()][getDatabase().getRows()];
    }

    private void setAnalyzeResult() {
        this.analyzeResult = new double[getAlgorithms().getQtdAlgorithms()][4];
    }


    private void makeMedium() {

        for (int i = 0; i < getAlgorithms().getQtdAlgorithms(); i++) {
            getAnalyzeResult()[i][0] = getAlgorithms().makeSort(i, database.getBest());
            database.resetBest();
        }

        for (int i = 0; i < getAlgorithms().getQtdAlgorithms(); i++) {
            getAnalyzeResult()[i][1] = getAlgorithms().makeSort(i, database.getWorst());
            database.resetWorst();
        }

        for (int i = 0; i < getAnalyzeResult().length; i++) {
            getAnalyzeResult()[i][2] = (getAnalyzeResult()[i][1] + getAnalyzeResult()[i][0]) / 2;
        }

    }

    private void makeAverage() {
        for (int i = 0; i < getAlgorithms().getQtdAlgorithms(); i++) {
            for (int j = 0; j < getDatabase().getRows(); j++) {
                getAllComparisons()[i][j] = algorithms.makeSort(i, database.getDatabase()[j]);
                database.resetDatabase();
            }
        }

        for (int i = 0; i < getAnalyzeResult().length; i++) {
            getAnalyzeResult()[i][3] = average(getAllComparisons()[i]);
        }
    }

    private double average(int[] array) {
        double average = 0;
        int size = array.length;

        for (int i = 0; i < size; i++) {
            average += Double.valueOf(array[i]);
        }

        average = average / size;

        return average;
    }

    public void startCalc(int row, int col) {
        setDatabase(row, col);
        setAllComparisons();
        setAnalyzeResult();
        makeMedium();
        makeAverage();
    }

}
