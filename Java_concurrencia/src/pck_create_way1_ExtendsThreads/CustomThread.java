package pck_create_way1_ExtendsThreads;

public class CustomThread extends Thread{

	@Override
	public void run() {
		System.out.println("My name is " + this.getName() + " , state " + this.getState());
	}

	
	
}
