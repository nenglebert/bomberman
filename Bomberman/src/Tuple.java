
public class Tuple<A,B,C> {
	private final A a;
	private final B b;
	private final C c;
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
