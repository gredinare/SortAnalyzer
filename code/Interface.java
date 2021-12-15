public class Interface {
    Calculator calculator;

    public Calculator getCalculator() {
        return calculator;
    }

    public void setCalculator() {
        this.calculator = new Calculator();
    }


    public void printTable(int row, int col) {
        String[] formatValue = new String[4];
        System.out.println("======================================================================================");
        System.out.println(String.format("%15s %15s %15s %15s %15s", "Arrays:", row, "", "Vetores:", col));
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println(String.format("%15s %15s %15s %15s %15s", "", "Best case", "Worst Case", "Medium Case", "Average"));

        for (int i = 0; i < getCalculator().getAnalyzeResult().length; i++) {

            for (int j = 0; j < formatValue.length; j++) {
                formatValue[j] = String.format("%.2f", getCalculator().getAnalyzeResult()[i][j]);
            }
            System.out.println(String.format("%15s %15s %15s %15s %15s", getCalculator().getAlgorithms().getAlgorithms()[i], formatValue[0], formatValue[1], formatValue[2], formatValue[3]));

        }


        System.out.println("======================================================================================");
        System.out.println("");
    }

    public void start(int row, int col) {
        setCalculator();
        getCalculator().startCalc(row, col);
        printTable(row, col);
    }
}
