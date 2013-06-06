package fr.smarthouseandroid.agent;

import java.beans.PropertyChangeSupport;

import jade.core.Agent;
import jade.core.behaviours.ParallelBehaviour;
import jade.util.Logger;

@SuppressWarnings("serial")
public class SmartAndroidAgent extends Agent implements AgentInterface {
	public static final String PROPERTY_NAME = "WINDOW";
	private Logger logger = Logger.getJADELogger(this.getClass().getName());
	private ParallelBehaviour pbhv;
	private int lightN;
	PropertyChangeSupport pcs;
	
	protected void setup() {

		// Add initial behaviours
		pbhv = new ParallelBehaviour();
		pbhv.addSubBehaviour(new ReceiveMessageBehaviour());
		
		addBehaviour(pbhv);
	}
	
	@Override
	public void allumer(int light) {
		lightN = light;
		pbhv.addSubBehaviour(new AllumerBehaviour());
	}

	@Override
	public void eteindre(int light) {
		lightN = light;
		pbhv.addSubBehaviour(new EteindreBehaviour());		
	}

	public int getLightN() {
		return lightN;
	}

	public void setLightN(int lightN) {
		this.lightN = lightN;
	}
	
}
