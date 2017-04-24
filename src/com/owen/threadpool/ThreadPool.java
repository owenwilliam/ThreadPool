package com.owen.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * �����̳߳�
 * 
 * @author owenwilliam
 * @Date 2017-4-17
 *
 */
public class ThreadPool
{

	public static final int ARRAY_QUEUE = 0; //ArrayBlockingQueue  �н���в���
	public static final int LINKED_QUEUE = 1; //LinkedBlockingQueue ʹ���޽���в���

	private ThreadPoolExecutor executor;
	private BlockingQueue<Runnable> workQueue;

	/**
	 * @param workQueneSize
	 *            ���г���
	 * @param coreSize
	 *            ���߳���
	 * @param maxSize
	 *            ����߳���
	 * @param queueType
	 *            ��������
	 */
	public ThreadPool(final int workQueneSize, final int coreSize,
			final int maxSize, int queueType)
	{
		this(workQueneSize, coreSize, maxSize, queueType, null);
	}

	/**
	 * 
	 * @param workQueneSize
	 *            ���г���
	 * @param coreSize
	 *            ���߳���
	 * @param maxSize
	 *            ����߳���
	 * @param queueType
	 *            ��������
	 * @param policy
	 *            �������
	 */
	public ThreadPool(final int workQueneSize, final int coreSize,
			final int maxSize, int queueType, RejectedExecutionHandler policy)
	{
		workQueue = createQueue(queueType, workQueneSize);
		executor = new ThreadPoolExecutor(coreSize, maxSize, 60,
				TimeUnit.SECONDS, workQueue, policy != null ? policy
						: new ThreadPoolExecutor.AbortPolicy());
	}

	public void execute(Runnable runnable)
	{
		if (workQueue.size() > 4)
		{
			
			System.out.println("��ǰ�ȴ��̴߳�С��'"+runnable.getClass().getSimpleName()+
					         "':"+workQueue.size());
		}
		executor.execute(runnable);
	}

	/**
	 * �������У�ѡ��ͬ�Ͷ��в���
	 * ArrayBlockingQueue  �н���в���
	 * LinkedBlockingQueue ʹ���޽���в���
	 * @param queueType
	 * @param queueSize
	 * @return
	 */
	private BlockingQueue<Runnable> createQueue(int queueType, int queueSize)
	{
		return queueType == LINKED_QUEUE ? new LinkedBlockingQueue<Runnable>(
				queueSize) : new ArrayBlockingQueue<Runnable>(queueSize);
	}

	public BlockingQueue<Runnable> getQueue()
	{
		return executor.getQueue();
	}
}
