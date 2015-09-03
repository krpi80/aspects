import spock.lang.*
import groovy.json.*
import static groovy.json.JsonOutput.*


class RefsResolverTest extends Specification {

  def pp = JsonOutput.&prettyPrint
	
  def "Should return the same json"() {
    expect:
    pp(json) == pp(RefsResolver.resolve(json))
    where:
    _| json
    _| '{"name":"John Doe"}'
    _| '{"person1" : {"name":"John Doe"}, "person2" : {"name":"John Doe"}}'
    _| '["abc"]'
  }

  def "Should resolve ref"() {
    expect:
    pp(resolvedJson) == pp(RefsResolver.resolve(json))
    where:
    json << ['{"person1" : {"@id":1, "name":"John Doe"}, "person2" : {"@ref":1}}']
    resolvedJson << ['{"person1" : {"name":"John Doe"}, "person2" : {"name":"John Doe"}}']
  }

  def "Should throw exception on circular references"() {
    when:
    RefsResolver.resolve(json)
    then:
    thrown(StackOverflowError)
    where:
    json << ['{"person1" : {"@id":1, "name":"John Doe", "person2" : {"@ref":1}}}']
  }

}