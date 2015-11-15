class TrendCalculator {

    static def calcTrend(values) {
        if (!values) {
            return null
        }

        if (values && values.size() == 1) {
            return 0
        }

        values[0] == values[1] ? 0.0 : 1.0
    }
}
