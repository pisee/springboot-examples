package com.doni.springboot.examples.client;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CliClient {
//	private static final String ENCODING = "UTF-8";
	private static final String ENCODING = "MS949";
	
	@Value(value = "${process.work.directory}")
	private String workDirectory = "cli";
	
	@Value(value = "${process.work.script}")
	private String script = "test.bat";
	
	public String callProcess(String... options) {

		ProcessBuilder builder = new ProcessBuilder(options);
		builder.directory(new File(workDirectory).getAbsoluteFile());
		builder.redirectErrorStream(true);
//		String contents = "";
		File file = new File(new File(workDirectory).getAbsoluteFile()+File.separator+"test.log");
		try {
			builder.redirectOutput(file);
			Process process = builder.start();
//			contents = IOUtils.toString(process.getInputStream(), ENCODING);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return file.getAbsolutePath();
	}

	public String byRuntime(String... command)  {
		Runtime runtime = Runtime.getRuntime();
		String contents = "";
		try {
			Process process = runtime.exec(command);
			contents = IOUtils.toString(process.getInputStream(), ENCODING);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return contents;
	}

	public String byProcessBuilder(String... command) {
		ProcessBuilder builder = new ProcessBuilder(command);
		String contents = "";
		try {
			Process process = builder.start();
			contents = IOUtils.toString(process.getInputStream(), ENCODING);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return contents;
	}
}
