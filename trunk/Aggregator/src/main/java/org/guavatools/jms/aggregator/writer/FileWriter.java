package org.guavatools.jms.aggregator.writer;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.util.Date;

import org.apache.log4j.Logger;


/**
 * A reference implementation of the MessageWriter interface.
 * Shows how headers, footer and error handling may be implemented 
 * @author peet.denny
 *
 */
public class FileWriter implements MessageWriter {
	private static final String DEMO_WRAPPER_HEADER = "<DemoWrapper><header></header>";
	private static final String DEMO_WRAPPER_FOOTER = "<footer></footer></DemoWrapper>";
	private Logger log = Logger.getLogger(this.getClass().getName());
	String outputDirName = new String();
	
	DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT);
	/**
	 * Keeps a track of everything this FileWriter has written in order to aid problem resolution
	 */
	StringBuffer fileWriterHistory = new StringBuffer();
	private FileOutputStream fileOutputStream;
	private BufferedWriter bufferedWriter;
	@Override
	public void write(String text, int index) {
		try {
			bufferedWriter.write(text);
		} catch (IOException e) {
			handleError(e, "Error while writing batch chunk");
		}
		fileWriterHistory.append("\n batch chunk: "+index);
	}

	@Override
	public void end() {
		try {
			bufferedWriter.write(DEMO_WRAPPER_FOOTER);
			bufferedWriter.flush();
			bufferedWriter.close();
		} catch (IOException e) {
			handleError(e, "Error while closing file");
		}
		fileWriterHistory.append("\n ended file successfully");
		
	}

	@Override
	public void start(String correlationId) {
		log.debug("starting to write out message for correlationId "+correlationId);
		fileWriterHistory.append("BEGIN: "+correlationId);
		String outputFileName = generateOutputFileName(correlationId);
		log.debug("attempting to create new file at: "+outputFileName);
		File file = new File(outputFileName);
		if(file.exists()){
			log.error("File denoted by path exists already: "+file+"\n Files output by this system need to be unique");
			file = new File(outputFileName+"-DUPLICATE-"+new Date().getTime());
			log.error("Writing file out to this emergency location so as not to lose message: "+file);
		}
		try {
			file.createNewFile();
			
			fileOutputStream = new FileOutputStream(file);
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
			fileWriterHistory.append("\nOpened file at:"+file);
			bufferedWriter.write(DEMO_WRAPPER_HEADER);
		} catch (IOException e) {
			handleError(e,"Failed while opening new file");
		}
		fileWriterHistory.append("\nWrote header");
	}

	@Override
	public void onError(Exception e) {
		log.error(e);
	}

	public void setOutputDirName(String outputDirName) {
		this.outputDirName = outputDirName;
	}


	/**
	 *logs the error message, then the error and finally the fileWriterHistory
	 *This method is fail-fast in that it rethrows the error once it has been logged 
	 *This should halt execution
	 */
	private void handleError(Exception e, String errorMessage) {
		log.error(errorMessage);
		log.error(e);
		log.error("The filewriter managed to write the following elements to the file: \n"+fileWriterHistory.toString());
		throw new RuntimeException(e);
	}

	private String generateOutputFileName(String corrId) {
		StringBuffer buf = new StringBuffer();
		buf.append(outputDirName);
		buf.append("/");
		buf.append(format(new Date()));
		buf.append("-");
		buf.append(corrId);
		buf.append(".xml");
		return buf.toString();
	}

	private String format(Date date) {
		String dateString = formatter.format(date);
		dateString = dateString.replace("/", "-");
		dateString = dateString.replace(" ", "_");
		dateString = dateString.replace(":", "-");
		return dateString;
	}

	@Override
	protected void finalize() throws Throwable {
		log.warn("closing streams in finalize block. This usually means only a partial message was written out. Check consistency of message: ");
		bufferedWriter.flush();
		bufferedWriter.close();
	}
	
	
}

