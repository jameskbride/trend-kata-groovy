import spock.lang.Specification
import spock.lang.Unroll

import static org.junit.Assert.assertNull

class TrendCalculatorSpec extends Specification {

    def "when the value list is null then return null"() {
        when:
        def result = TrendCalculator.calcTrend(null)

        then:
        assertNull(result)
    }

    def "when the value list is empty then return null"() {
        when:
        def result = TrendCalculator.calcTrend([])

        then:
        assertNull(result)
    }

    def "when the list contains a single value then return zero"() {
        when:
        def result = TrendCalculator.calcTrend([0])

        then:
        assert 0 == result
    }

    def "given a pair of values (p1, p2) when p1 is zero and p2 is greater than zero then return 1.0"() {
        when:
        def result = TrendCalculator.calcTrend([0, 1.1])

        then:
        assert 1.0 == result
    }

    def "given a pair of values (p1, p2) when p1 equals p2 then return 0.0"() {
        when:
        def result = TrendCalculator.calcTrend([0, 0])

        then:
        assert 0.0 == result
    }

    def "given a pair of values (p1, p2) when p1 is non-zero and p2 different then return (p2-p1)/p1"(p1, p2, result) {
        expect:
        result == TrendCalculator.calcTrend([p1, p2])

        where:
        p1  | p2  | result
        1.0 | 3.0 | 2.0
        1.0 | 0.0 | -1.0
        2.2 | 4.5 | 1.045
    }

    def "when there are two pairs of values the trend is calculated"() {
        when:
        def result = TrendCalculator.calcTrend([1.0, 3.0, 1.0, 0.0])

        then:
        assert 1.0 == result
    }

    def "when there is an odd number of values then trend is calculated"() {
        when:
        def result = TrendCalculator.calcTrend([1.0, 3.0, 1.0])

        then:
        assert 2.0 == result
    }
}
