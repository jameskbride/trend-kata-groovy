class TrendCalculator {

    static def calcTrend(values) {
        if (!values) {
            return null
        }

        if (values && values.size() == 1) {
            return 0
        }

        if (values[0] == values[1]) {
            return 0
        } else if (values[0] == 0 && values[1] > 0) {
            return 1.0
        }

        BigDecimal pairTrend = new BigDecimal((values[1] - values[0]) / values[0])

        pairTrend.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue()
    }
}
