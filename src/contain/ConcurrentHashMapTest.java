package contain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrentHashMapTest {
	final public static int THREAD_POOL_SIZE = 5;
	public static Map<String, Integer> HashTableObject = null;
	public static Map<String, Integer> SynchronizedMapObject = null;
	public static Map<String, Integer> ConcurrenctHashMapObject = null;

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		HashTableObject = new Hashtable<String, Integer>();
		currentPlatFlomTest(HashTableObject);
		SynchronizedMapObject = Collections
				.synchronizedMap(new HashMap<String, Integer>());
		currentPlatFlomTest(SynchronizedMapObject);
		ConcurrenctHashMapObject = new ConcurrentHashMap<String, Integer>();
		currentPlatFlomTest(ConcurrenctHashMapObject);
	}

	public static void currentPlatFlomTest(final Map<String, Integer> currentMapThreads)
			throws InterruptedException {
		System.out.println("Test started for: " + currentMapThreads.getClass());
		long averageTime = 0;

		for (int i = 0; i < 5; i++) {

			long startTime = System.nanoTime();
			ExecutorService currentService = Executors
					.newFixedThreadPool(THREAD_POOL_SIZE);

			for (int j = 0; j < THREAD_POOL_SIZE; j++) {

				currentService.execute(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						for (int i = 0; i < 500000; i++) {
							Integer cruInteger = (int) Math.ceil(Math.random() * 50000);
							Integer cruInteger2 = (int) currentMapThreads
									.get(String.valueOf(cruInteger));
							currentMapThreads.put(String.valueOf(cruInteger2),
									cruInteger);
						}
					}
				});
			}
			currentService.shutdown();
			currentService.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
			long entTime = System.nanoTime();
			long totalTime = (entTime - startTime) / 1000000L;
			averageTime += totalTime;
			System.out.println("2500K entried added/retrieved in " + totalTime
					+ " ms");

		}
		System.out.println("For " + currentMapThreads.getClass()
				+ " the average time is " + averageTime / 5 + " ms\n");
	}

}
