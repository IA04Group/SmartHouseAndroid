package smarthouseandroid.agent;

import jade.core.Agent;
import jade.core.behaviours.ParallelBehaviour;
import jade.util.Logger;

@SuppressWarnings("serial")
public class SmartAndroidAgent extends Agent implements AgentInterface {
	private Logger logger = Logger.getJADELogger(this.getClass().getName());
	
	protected void setup() {

		// Add initial behaviours
		ParallelBehaviour pbhv = new ParallelBehaviour();
		pbhv.addSubBehaviour(new AllumerBehaviour());
		pbhv.addSubBehaviour(new EteindreBehaviour());
		pbhv.addSubBehaviour(new ReceiveMessageBehaviour());
		
		addBehaviour(pbhv);
	}
	
	@Override
	public void allumer(int light) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eteindre(int light) {
		// TODO Auto-generated method stub
		
	}
	
}
