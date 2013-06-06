package smarthouseandroid;

import jade.android.MicroRuntimeServiceBinder;
import jade.util.Logger;
import smarthouse.smarthouseandroid.R;
import smarthouseandroid.agent.AgentInterface;
import smarthouseandroid.agent.SmartAndroidAgent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.app.Activity;
import android.content.ServiceConnection;

public class MainActivity extends Activity {
	private Logger logger = Logger.getJADELogger(this.getClass().getName());
	
	private MicroRuntimeServiceBinder microRuntimeServiceBinder;
	private ServiceConnection serviceConnection;
	
	private Button allumerButton;
	private Button eteindreButton;
	private EditText lightNumber;
	private int n;
	private AgentInterface aInterface;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        n = 0;
        setContentView(R.layout.activity_main_layout);
        
        allumerButton = (Button) findViewById(R.id.bouton_allumer);
        eteindreButton = (Button) findViewById(R.id.bouton_eteindre);
        lightNumber = (EditText) findViewById(R.id.number_picker);
        
        lightNumber.setImeActionLabel("Entrer", KeyEvent.KEYCODE_ENTER);
        
        
        aInterface = new SmartAndroidAgent();
        
        
        allumerButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String s = lightNumber.getText().toString();
				if(!s.equals(null))
					n = Integer.parseInt(s);
				else
					n = 0;
				//TODO lien agent
				aInterface.allumer(n);
			}
		});
        
        eteindreButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String s = lightNumber.getText().toString();
				if(!s.equals(null))
					n = Integer.parseInt(s);
				else
					n = 0;
				//TODO lien agent
				aInterface.eteindre(n);
			}
		});
    }

	public Button getAllumerButton() {
		return allumerButton;
	}

	public void setAllumerButton(Button allumerButton) {
		this.allumerButton = allumerButton;
	}

	public Button getEteindreButton() {
		return eteindreButton;
	}

	public void setEteindreButton(Button eteindreButton) {
		this.eteindreButton = eteindreButton;
	}

	public EditText getLightNumber() {
		return lightNumber;
	}

	public void setLightNumber(EditText lightNumber) {
		this.lightNumber = lightNumber;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public AgentInterface getaInterface() {
		return aInterface;
	}

	public void setaInterface(AgentInterface aInterface) {
		this.aInterface = aInterface;
	}
    
}
