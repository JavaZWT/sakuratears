package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;

/**
 * @Author: zwt
 * @Description: TODO
 * @Name: MyExecutorsTest
 * @Date: 2018/6/11 上午9:51
 * @Version: 1.0
 */

public class MyExecutorsTest {

    public static void main(String[] args) {
    	/**
    	 * @Author: zwt
    	 * @Description: 可缓存型线程池
    	 * @Name: main
    	 * @Date: 2018/6/11 上午9:54
    	 * @Params: [args]
    	 * @Return: void
    	 * @Version: 1.0
    	 */
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			final int index = i;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			cachedThreadPool.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println("Thread id=" + Thread.currentThread().getId() + ";index=" + index);
				}
			});
		}

		/**
		 * @Author: zwt
		 * @Description: 定长线程池
		 * @Name: main
		 * @Date: 2018/6/11 上午9:54
		 * @Params: [args]
		 * @Return: void
		 * @Version: 1.0
		 */
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 10; i++) {
			final int index = i;
			fixedThreadPool.execute(new Runnable() {
				@Override
				public void run() {
					try {
						System.out.println("Thread id=" + Thread.currentThread().getId() + ";index=" + index);
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}

		/**
		 * @Author: zwt
		 * @Description: 可以执行定时任务的线程池
		 * @Name: main
		 * @Date: 2018/6/11 上午9:54
		 * @Params: [args]
		 * @Return: void
		 * @Version: 1.0
		 */
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
		scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				System.out.println("Thread id="+Thread.currentThread().getId()+";5s后,每2s执行一次");
			}
		}, 5, 2, TimeUnit.SECONDS);

		/**
		 * @Author: zwt
		 * @Description: 单线程线程池
		 * @Name: main
		 * @Date: 2018/6/11 上午9:55
		 * @Params: [args]
		 * @Return: void
		 * @Version: 1.0
		 */
		ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 10; i++) {
			final int index = i;
			singleThreadExecutor.execute(new Runnable() {
				@Override
				public void run() {
					try {
						System.out.println("Thread id=" + Thread.currentThread().getId() + ";index=" + index);
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}

		/**
		 * @Author: zwt
		 * @Description: 自定义线程池
		 * @Name: main
		 * @Date: 2018/6/11 上午9:54
		 * @Params: [args]
		 * @Return: void
		 * @Version: 1.0
		 */
        ExecutorService myExecutor = new ThreadPoolExecutor(5, 10, 60L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(5), new AbortPolicy());
        for (int i = 0; i < 11; i++) {
            final int index = i;
            try {
                myExecutor.execute(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Thread id=" + Thread.currentThread().getId() + ";index=" + index);
                        try {
                            Thread.sleep(10000000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

