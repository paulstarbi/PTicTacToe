package com.javaAcademy.tictactoe.io;

import java.util.Locale;
import java.util.ResourceBundle;

import com.javaAcademy.tictactoe.io.resolversImpl.CoordResolver;
import com.javaAcademy.tictactoe.io.resolversImpl.EmptyResolver;
import com.javaAcademy.tictactoe.io.resolversImpl.SizeResolver;
import com.javaAcademy.tictactoe.io.resolversImpl.StringResolver;
import com.javaAcademy.tictactoe.model.Type;

public class IOResolver {
	
	private static IOResolver instance;
	
	private Locale locale;
	
	private UserInput userInput;
	private Printer printer;

	private DataResolver<?> dataResolver;
	
	private IOResolver(Locale locale, UserInput userInput, Printer printer) {
		this.locale = locale;
		this.userInput = userInput;
		this.printer = printer;
	}

	public static IOResolver createIOResolver(Locale locale, UserInput userInput, Printer printer) {
		instance = new IOResolver(locale, userInput, printer);
		return instance;
	}
	
	public static IOResolver getIOResolverInstance() {
		return instance;
	}

	public String getMsgByKey(String key) {
		return ResourceBundle.getBundle("Messages", locale).getString(key);
	}
	
	public DataResolver<?> resolveIO(String key, Object ...params) {
		if(key.startsWith("int.size.")) {
			dataResolver = new SizeResolver(userInput, printer);
		} else if (key.startsWith("int.coord.")) {
			dataResolver = new CoordResolver(userInput, printer);
		} else if (key.startsWith("string.")) {
			dataResolver = new StringResolver(userInput, printer);
		} else { //key.startsWith("empty.")
			dataResolver = new EmptyResolver(userInput, printer);
		}
		dataResolver.resolveIO(key, params);
		return dataResolver;
	}

	public void setPrinter(Type type) {
		dataResolver.setPrinterType(type);
		userInput.setType(type);
	}

	public Printer getPrinter() {
		return printer;
	}
}