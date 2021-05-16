public class FSM411 {
    public FSMController ctr;
    public FSMState st = s0.S0;

    //Costruttore
    public FSM411 (FSMController controller) {
        ctr = controller;
    }

    //Definizione degli eventi
    public void a() {
        st.a(this);
    }

    public void b() {
        st.b(this);
    }

    public void c() {
        st.c(this);
    }

    //Definizione delle azioni
    public void out0() {
        ctr.out0();
    }

    public void out1() {
        ctr.out1();
    }

    //Setstate
    public void setState(FSMState stato) {
        st = stato;
    }
}

public interface FSMState {
    public void a(FSM411 f);
    public void b(FSM411 f);
    public void c(FSM411 f);
}

public class s0 implements FSMState {
    public static FSMState S0 = new s0();

    public void a(FSM411 f) {
        f.out1();
        f.setState(s1.S1);
    }

    public void b(FSM411 f) { return; }

    public void c(FSM411 f) { return; }
}

public class s1 implements FSMState {
    public static FSMState S1 = new s1();

    public void a(FSM411 f) {
        f.out0();
        f.setState(s0.S0);
    }

    public void b(FSM411 f) {
        f.out0();
        f.setState(s2.S2);
    }

    public void c(FSM411 f) { return; }
}

public class s2 implements FSMState {
    public static FSMState S2 = new s2();

    public void a(FSM411 f) { return; }

    public void b(FSM411 f) {
        f.out1();
        f.setState(s0.S0);
    }

    public void c(FSM411 f) {
        f.out0();
    }
}

//Controller
public class FSMController {
    public void out0() {
        System.out.println("0");
    }

    public void out1() {
        System.out.println("1");
    }
}
