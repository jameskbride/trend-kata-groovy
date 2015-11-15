class TrendCalculator {

    static def calcTrend(values) {
        if (!values) {
            return null
        }

        def pairs = values.collate(2)

        mapReducePairs(pairs)
    }

    private static double mapReducePairs(pairs) {
        def pairCalculations = pairs.collect { pair ->
            calculatePairTrend(pair)
        }.inject { result, currentValue ->
            result + currentValue
        }

        pairCalculations
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
