package thread;

class Sample
{
	
}

class Th1 extends Sample implements Runnable
{

	@Override
	public void run() {
		
		for(int i=1;i<=10;i++)
		{
			System.out.println(Thread.currentThread().getName()+" : "+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
	}
	
}

public class T002_RunnableInterface {
	public static void main(String[] args) {
		
		Th1 t1 = new Th1();
		Th1 t2 = new Th1();
		
		Thread th1  =new Thread(t1);
		Thread th2 = new Thread(t2);
		
		th1.setName("a");
		th2.setName("b");
		
		th1.start();
		th2.start();
		
	}
}
