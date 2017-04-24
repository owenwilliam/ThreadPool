package com.owen.threadpool;

/**
 * 使用线程池
 * 
 * @author owenwilliam
 * @Date 2017-4-17
 *
 */
public class USThreadPool
{

	private ThreadPool tp;
	private static USThreadPool pool = new USThreadPool();

	private USThreadPool()
	{
		int workQueneSize = 80;
		int coreSize = 4;
		int maxSize = 10;

		//创建线程池
		tp = new ThreadPool(workQueneSize, coreSize, maxSize,
				ThreadPool.ARRAY_QUEUE);
	}

	public static USThreadPool getPool()
	{
		return pool;
	}

	public void execute(Runnable runnable)
	{
		tp.execute(runnable);
	}

	public void execute(String name)
	{
		execute(new ThreadRunnable(name));
	}
}
