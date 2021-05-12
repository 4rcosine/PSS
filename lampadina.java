//Classe della FSM
public class FSMLampadina {
	private FSMController ctr;
	private FSMState st = Off.OFF
	
	//Costruttore
	public FSMLampadina(FSMController controller) {
		ctr = controller;
	}
		
	// definizione degli eventi
	public void accendi() {
		st.accendi(this);
	}
	
	public void spegni() {
		st.spegni(this);
	}
	
	// definizione delle azioni
	public void click(){
		controller.click();
	}
	
	// per aggiornare “state”
	setst(FSMstate s) {
		st = s;
	}
}

//Interfaccia comune
public interface FSMState {
	public void accendi(FSMLampadina: f);
	public void spegni(FSMLampadina: f);
}

//Stato acceso
public class on implements FSMState {
	public void spegni (FSMLampadina f) {
		f.setst(Off.OFF);
		f.click();
	}
	
	public void accendi (FSMLampadina f) {
		f.click();
	}
}

//Stato spento
public class off implements FSMState {
	public void accendi (FSMLampadina f) {
		f.setst(On.ON);
		f.click();
	}
	
	public void spegni (FSMLampadina f) {
		f.click();
	}
}


//Controller
public class FSMController {
	public void click(){
		System.out.println("*click*");
	}
}
