
public class fibonnaci {
	
	public static int f(int x) {
		if (x==0) {
			return 0;
		} else if (x==1) {
			return 1;
		} else {
			return f(x-1) + f(x-2);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(f(1));

	}

}
