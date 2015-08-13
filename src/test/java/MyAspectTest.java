import a.Library;
import org.junit.Test;
import static org.junit.Assert.*;

public class MyAspectTest {
	
	@Test
	public void shouldAddAspect() {
		//new MyApect("abc");

		Library library = new Library();
		library.foo();
		assertTrue(Boolean.getBoolean("aspect"));
	}

	/*@Rule
	OutputCapture outputCapture = new OutputCapture();


	@Test
	public void shouldLogStats() {

		final MetricRegistry metrics = new MetricRegistry();
		final ConsoleReporter console = new ConsoleReporter(metrics);

		final Library library = new Library();
		library.foo();
		library.foo();
		library.foo();

		console.report();

		assertThat(outputCapture.getOutput(), contatinsString("foo"));
		assertThat(outputCapture.getOutput(), contatinsString("3"));


	}*/



}