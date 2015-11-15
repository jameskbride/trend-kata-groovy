class TrendCalculator {

    static def calcTrend(values) {
        if (!values) {
            return null
        }

        calculatePairTrend(values)
    }

    private static double calculatePairTrend(values) {
        if (pairValuesMatch(values)) {
            return 0
        } else if (p1IsZeroAndP2IsPositive(values)) {
            return 1.0
        }

        BigDecimal pairTrend = new BigDecimal((values[1] - values[0]) / values[0])

        pairTrend.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue()
    }

    private static boolean p1IsZeroAndP2IsPositive(values) {
        values[0] == 0 && values[1] > 0
    }

    private static boolean pairValuesMatch(values) {
        values.size() == 1 || (values[0] == values[1])
    }
}
