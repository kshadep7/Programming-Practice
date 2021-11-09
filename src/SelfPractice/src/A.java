public class A{
static String str =  "abc";
}

class B extends A{
	static String str  = "xyz";
}

class C extends B{

	public static void main(String[] args) {
		B b = new B();

		System.out.println(b instanceof B);
		System.out.println((b instanceof B) && (!(b instanceof A)));
		System.out.println((b instanceof B) && (!(b instanceof C)));
		System.out.println();

	}
}
