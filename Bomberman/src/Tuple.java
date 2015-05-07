
public class Tuple<A,B,C> {
	final A a;
	final B b;
	final C c;
	public Tuple(A a,B b,C c){
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public A first() {
		return a;
	}
	
	public B second() {
		return b;
	}
	
	public C third() {
		return c;
	}
}
