package com.owen.threadpool;

/**
 * �����߳�
 * @author owenwilliam
 * @Date 2017-4-17
 *
 */
public class ThreadRunnable implements Runnable
{

	String name;

	public ThreadRunnable(String name)
	{
		this.name = name;
	}

	@Override
	public void run()
	{
		// ����һ����������Ĵ���ʽ̫���ˣ�������һ����ӡ���
		System.out.println("start .." + name);
		try
		{
			// ���ڹ۲죬�ȴ�һ��ʱ��
			Thread.sleep(2000);
		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}

}
