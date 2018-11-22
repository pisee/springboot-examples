package com.doni.springboot.examples.client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

public class CliClientTest {

	private static final String ENCODING = "UTF-8";

	private String workDirectory = "cli";
	
	private String script = "test.bat";
	
	@Test
	public void callProcess() {
		String path = new CliClient().callProcess(new File(workDirectory).getAbsolutePath() + File.separator + script);
		System.out.println(path);
	}
	
	@Test
	public void read() {
		String csvFile = "D:\\70_codereview\\github\\springboot-examples\\cli\\test.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                // timestamp, name, pci.bus_id, driver_version, pstate, pcie.link.gen.max, pcie.link.gen.current, temperature.gpu, utilization.gpu [%], utilization.memory [%], memory.total [MB], memory.free [MB], memory.used [MB]
            	String[] gpuInfo = line.split(cvsSplitBy);
                System.out.println(Arrays.toString(gpuInfo));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	}
	
	@Test
	public void test() {
		try {
			String[] cmd = new String[]{"cmd", "/c", "nvidia-smi"};
			Process process = Runtime.getRuntime().exec(cmd);
			String contents = IOUtils.toString(process.getInputStream(), ENCODING);
			System.out.println(contents);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
