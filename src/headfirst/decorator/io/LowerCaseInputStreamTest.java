package headfirst.decorator.io;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


//TODO: lowerCaseInoutStream(takes from: byte array input stream (takes string), byte array output stream, string buffer)
class LowerCaseInputStreamTest {
	InputStream is;
	OutputStream os;
	String allUpperCase;
	String expected;
	
	@BeforeEach
	void setUp() throws Exception {
		//in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("hi, I'm Nathan")));
		allUpperCase = "HI IM NATHAN";
		is = new ByteArrayInputStream(allUpperCase.getBytes());
		os = new ByteArrayOutputStream();
		expected = allUpperCase.toLowerCase();
	}

	@AfterEach
	void tearDown() throws Exception {
		is = null;
		os = null;
		allUpperCase = null;
	}


	@Test
	void testRead() throws IOException {  //use string for this 
		
		InputStream lowerIs = new LowerCaseInputStream(is);
		String testString = "";
		int eachChar = lowerIs.read(); //if end of string, true
		while(eachChar != -1) {
			testString = testString + (char) eachChar;
		//	os.write(eachChar); //build string here to compare with expected
			eachChar = lowerIs.read();
		}
		
		assertTrue(testString.equals(expected));
	//	os.write(eachChar); //writes the end of string because negative 1
		
		
		//redefine stdout to an output byte array setOut(ByteArrayOutputStream
		//tostring it or one other 
		
	}

	@Test
	void testReadByteArrayIntInt() throws IOException { //use os for this one.
		InputStream lowerIs = new LowerCaseInputStream(is);
		
		byte[] changingBytes = allUpperCase.getBytes(); //sentence in byte form
		lowerIs.read(changingBytes,0,changingBytes.length); //change the byte
		String changedString = new String(changingBytes); //convert to string
		assertTrue(changedString.equals(expected)); //compare against expected val
		
		//redefine stdout to an output byte array setOut(ByteArrayOutputStream
		//tostring it or one other 
	}

	
}
