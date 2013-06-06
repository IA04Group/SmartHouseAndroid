package fr.smarthouseandroid.agent;

import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

@SuppressWarnings("serial")
public class ReceiveMessageBehaviour extends CyclicBehaviour {

	@Override
	public void action() {
		//receive message from windows
		ACLMessage m = myAgent.receive();
		if(m.getPerformative() == ACLMessage.INFORM) {
			((SmartAndroidAgent)myAgent).pcs.firePropertyChange(SmartAndroidAgent.PROPERTY_NAME, "", "Window");
		}
		else {
			block();
		}
	}
}
