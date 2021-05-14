public class FSM410 {
	private FSMController ctr;
	private FSMState state = s1.S1;
	
	//Costruttore
	public FSM410 (FSMController controller) {
		ctr = controller;
	}

	//Eventi
	public void a () {
		state.a(this);
	}
	
	public void b () {
		state.b(this);
	}
	
	//Azioni
	public void out0 () {
		ctr.out0();
	}
	
	public void out1 () {
		ctr.out1();
	}
	
	setstate(FSMState s) {
		state = s;
	}
}
//Interfaccia
public interface FSMState {
	public void a(FSM410: f);
	public void b(FSM410: f);
}
//Stati
public class s1 implements FSMState {
	public static FSMState S1 = new s1();
	public void a(FSM410 f) {
		f.setstate(s4.S4);
		f.out1();
	}
	
	public void b(FSM410 f) { return; }
}
public class s2 implements FSMState {
	public static FSMState S2 = new s2();
	
	public void b(FSM410 f) {
		f.setstate(s3.S3);
		f.out0();
	}
	
	public void a(FSM410 f) { return; }
}
public class s3 implements FSMState {
	
	public static FSMState S3 = new s3();
	public void a(FSM410 f) {
		f.setstate(s4.S4);
		f.out1();
	}
	
	public void b(FSM410 f) { return; }
}
public class s4 implements FSMState {
	public static FSMState S4 = new s4();
	public void a(FSM410 f) {
		f.setstate(s2.S2);
		f.out0();
	}
	
	public void b(FSM410 f) { return; }
}
//Controller
public class FSMController {
	public void out0() {
		System.out.print("0");
	}
	
	public void out1() {
		System.out.print("1");
	}
}
