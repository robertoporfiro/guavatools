package com.maninvestments.rabbitmq.testframework;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class RabbitInstanceControllerImpl implements RabbitInstanceController {

	private static final String RABBIT_START_COMMAND = "cmd /c runRabbit.bat";
	private static final String RABBIT_STOP_COMMAND_BASE = "cmd /c rabbitmqctl.bat -n testframework-rabbit@%1s stop";
	// TODO Get this running on linux by making these commands configurable
	static Logger log = Logger.getLogger(RabbitInstanceControllerImpl.class.getName());
	
	static String erlangHome;
	
	/**
	 * sets the location of the Erlang install based on either the environment variable <br>
	 * or "C:\Program Files (x86)\erl5.8.2" if that is not available
	 */
	static{
		erlangHome = System.getenv("ERLANG_HOME");
		if(erlangHome == null){
			erlangHome="C:\\Program Files (x86)\\erl5.8.2";
		}
		log.info("Using Erlang installation here: "+erlangHome);
	}
	
	@Override
	public Process start() throws BrokerProcessException {
		return executeRabbitProcess(RABBIT_START_COMMAND);
	}

	private Process executeRabbitProcess(String command) throws BrokerProcessException {
		File workingDirectory = new File("broker/installation/sbin");
		Process process;
		try {
			process=Runtime.getRuntime().exec(command,getEnvironmentAsArray(),workingDirectory);
			log.info("Process started: "+process.toString());
			pipeOutputToLogger(process.getErrorStream(), true);
			pipeOutputToLogger(process.getInputStream(), false);
		} catch (IOException e) {
			throw new BrokerProcessException("Error while starting Rabbit",e);
		}
		return process;

	}

	private String[] getEnvironmentAsArray() {
		Map<String, String> envMap  = new HashMap<String, String>();
		envMap.putAll(System.getenv());
		String[] envArray = new String[envMap.size()+1];
		int idx=0;
		for(Map.Entry<String, String> entry: envMap.entrySet()){
			envArray[idx] = entry.getKey()+"="+entry.getValue();
			idx++;
		}
		envArray[idx]="ERLANG_HOME="+erlangHome;
		return envArray;
	}

	private void pipeOutputToLogger(InputStream is, final boolean errorStream) {
		final BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		Runnable r = new Runnable() {
			@Override
			public void run() {
				try {
					String line = reader.readLine();
					while(true){
						if(line != null){
							if(errorStream){
								log.severe("RABBIT-PROC: "+line);
							}
							else{
								log.info("RABBIT-PROC: "+line);
							}
							
						}
						line = reader.readLine();
					}
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
				
			}
		};
		new Thread(r).start();		
	}

	@Override
	public int stop() throws BrokerProcessException {
		Process shutdownProcess = executeRabbitProcess(getRabbitStopCommand());
		try {
			shutdownProcess.waitFor();
		} catch (InterruptedException e) {
			log.warning(e.toString());
		}
		log.info("Rabbit shutdown");
		return shutdownProcess.exitValue();
	}

	private String getRabbitStopCommand() {
		String hostName = TestUtils.getLocalHostName();
		String command=String.format(RABBIT_STOP_COMMAND_BASE,hostName);
		log.info("Using this command to stop Rabbit: "+command);
		return command;
	}

	@Override
	public boolean isRunning() throws BrokerProcessException {
		return RabbitHelper.isRunning();
	}

	@Override
	public void waitForStartingBroker(int secondsToWait)throws BrokerProcessException {
		int iteration = 0;
		boolean isRunning = isRunning();
		while((!isRunning)  && iteration < secondsToWait){
			log.info("Server not yet running, will check again in 1 second");
			TestUtils.pause(1000);
			isRunning = isRunning();
			iteration ++;
		}
		if(! isRunning){
			throw new BrokerProcessException("Unable to start broker. After waiting "+secondsToWait+" seconds, the server still does not return a connection");
		}
		log.info("Started RabbitMQ in "+iteration+" seconds");
	}

}
