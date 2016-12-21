import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
* Class TestRunner tests all classes present in Cryptography; it operates in conjunction with:
*	Test_mono_alphabetic_cipher.java
*	Test_poly_alphabetic_cipher.java
*
* @author John W. Hall, jwhall5@illinois.edu
* @version 1.0 December 20, 2016
*/
public class TestRunner {
	public static void main(String[] args) {
		Result result_mono = JUnitCore.runClasses(Test_mono_alphabetic_cipher.class);
		for (Failure failure : result_mono.getFailures())
			System.out.println(failure.toString());
		if (result_mono.wasSuccessful())
			System.out.println("Mono-alphabetic cipher functions correctly.");


		Result result_poly = JUnitCore.runClasses(Test_poly_alphabetic_cipher.class);
		for (Failure failure : result_poly.getFailures())
			System.out.println(failure.toString());
		if (result_poly.wasSuccessful())
			System.out.println("Poly-alphabetic cipher functions correctly.");
	}
}

