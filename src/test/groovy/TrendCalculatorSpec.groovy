import spock.lang.Specification

import static org.junit.Assert.assertNull

class TrendCalculatorSpec extends Specification {

    def "when the value list is null then return null"() {
        when:
        def result = TrendCalculator.calcTrend(null)

        then:
        assertNull(result)
    }
}
