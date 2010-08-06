package org.guavatools.jms.aggregator.writer;

/**
 * Classes that implement this interface can be used to write out message fragments arriving in batches to a file or other type of output.
 * @author peet.denny
 *
 */
public interface MessageWriter {

	/**
	 * Writes the text of a message out to a location
	 * @param text
	 * @param index the index of the file within the batch
	 */
	public void write(String text, int index);

	/**
	 * Is designed to open files / streams write out headers or whatever
	 * @param correlationId 
	 */
	public void start(String correlationId);

	/**
	 * Write out headers and close files / streams
	 */
	public void end();

	
	/**
	 * Allows the message writer to handle the method if need be
	 * Use this method to close up files and streams and perhaps raise an error with a monitoring service
	 * @param e
	 */
	public void onError(Exception e);

}

