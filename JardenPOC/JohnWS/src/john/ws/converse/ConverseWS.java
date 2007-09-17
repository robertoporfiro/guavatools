package john.ws.converse;

import java.io.Serializable;

import javax.jws.*;

import weblogic.jws.Context;
import weblogic.jws.Conversation;
import weblogic.wsee.jws.JwsContext;

@WebService
public class ConverseWS implements Serializable {
	private static final long serialVersionUID = 1L;
	private int count;
	private String name;
	private static final int MAX_COUNT = 3;
	@Context
	JwsContext jwsContext;

	@Conversation (Conversation.Phase.START)
	public String start(String name) {
		this.name = name;
		this.count = MAX_COUNT;
		return name + ", you have " + count + " steps to go.";
	}

	@Conversation (Conversation.Phase.CONTINUE)
	public String keepGoing() {
		--count;
		if (count <= 0) {
			jwsContext.finishConversation(); // doesn't seem to work
				// according to api should be equivalent to Conversation.Phase.FINISH
				// but the conversation is still current.
			return stop();
		}
		return name + ", you have " + count + " steps to go.";
	}

	@Conversation (Conversation.Phase.FINISH)
	public String stop() {
		return name + ", you have finished!";
	}
}