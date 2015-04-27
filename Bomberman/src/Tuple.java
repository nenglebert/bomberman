
public class Tuple<A,B> {
	final A a;
	final B b;
	public Tuple(A a,B b){
		this.a = a;
		this.b = b;
	}
	
	public A first() {
		return a;
	}
	
	public B second() {
		return b;
	}
}
