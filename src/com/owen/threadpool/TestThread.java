package com.owen.threadpool;

/**
 * ≤‚ ‘œﬂ≥Ã
 * 
 * @author owenwilliam
 * @Date 2017-4-17
 *
 */
public class TestThread
{

	public static void main(String[] args)
	{

		for (int i = 0; i < 10; i++)
		{

			USThreadPool.getPool().execute("num:" + i);
		}

	}

}
