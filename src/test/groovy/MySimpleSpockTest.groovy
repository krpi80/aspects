import spock.lang.*

class MySimpleSpockTest extends Specification {

	def "Should calculate maximum"() {
		expect:
		Math.max(a, b) == c

		where:
		a|b|c
		1|2|2
	}


}