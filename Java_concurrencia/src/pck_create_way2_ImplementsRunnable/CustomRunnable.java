package pck_create_way2_ImplementsRunnable;

public class CustomRunnable implements Runnable{

	@Override
	public void run() {
		System.out.println("My name is " + Thread.currentThread().getName()
				+ " , state " + Thread.currentThread().getState());
		
	}

}
