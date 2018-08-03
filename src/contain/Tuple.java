package contain;

public class Tuple<A,B> {
	private A a;
	private B b;
	Tuple(){
		
	}
	Tuple(A aa,B bb){
		a=aa;
		b=bb;
	}
	public void print(){
		System.out.println("a :"+a+" b:"+b);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tuple t=new Tuple<String, Integer>("jack",20);
		t.print();
	}

}
