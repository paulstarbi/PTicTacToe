package com.javaAcademy.tictactoe.IOTests;

import java.io.ByteArrayInputStream;
import java.util.Locale;

import org.testng.annotations.*;

import com.javaAcademy.tictactoe.exceptions.CancelGameException;
import com.javaAcademy.tictactoe.helper.IOResolver;
import com.javaAcademy.tictactoe.helper.resolversImpl.StringResolver;

public class StringResolverTest {
	
	private Locale locale;
	
	@BeforeTest
	public void createIOResolver() {
		locale = new Locale("en", "EN");
		IOResolver.createIOResolver(locale);
	}

	@Test(expectedExceptions = CancelGameException.class)
	public void shouldThrowCancelGameException() {
		String string = "q";
		
		StringResolver<?> dataResolver = new StringResolver<String>(locale);
		ByteArrayInputStream in = new ByteArrayInputStream(string.getBytes());
		System.setIn(in);
		
		dataResolver.resolveIO("string.cancelGameException");
	}
}
