public class FSM410 {
	public FSMController ctr;
	public FSMState state;

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
	public void a(FSM410 f) {
		f.setstate(S4.S4);
		f.out1();
	}
	
	public void b(FSM410 f) { return; }
}

public class s2 implements FSMState {
	public void b(FSM410 f) {
		f.setstate(S3.S3);
		f.out0();
	}
	
	public void a(FSM410 f) { return; }
}

public class s3 implements FSMState {
	public void a(FSM410 f) {
		f.setstate(S4.S4);
		f.out1();
	}
	
	public void b(FSM410 f) { return; }
}

public class s4 implements FSMState {
	public void a(FSM410 f) {
		f.setstate(S2.S2);
		f.out0();
	}
	
	public void a(FSM410 f) { return; }
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
