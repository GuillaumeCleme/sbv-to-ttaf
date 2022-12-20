package clement.guillaume.sbv_to_ttaf.test;

import java.io.IOException;

import clement.guillaume.sbv_to_ttaf.SbvToTtaf;
import junit.framework.TestCase;

public class SbvToTtafTest extends TestCase {

	/**
	 * Construct new test instance
	 *
	 * @param name the test name
	 */
	public SbvToTtafTest(String name) {
		super(name);
	}

	/**
	 * Run the void main(String[]) method test
	 * @throws IOException 
	 */
	public void testMain() throws IOException {
	
		// add test code here
		String[] args = {"src/test/resources/captions.sbv","target/captions.ttaf"};
		SbvToTtaf.main(args);
		assertTrue(true);
	}
}