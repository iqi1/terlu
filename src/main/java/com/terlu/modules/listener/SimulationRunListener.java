package com.terlu.modules.listener;

import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SimulationRunListener  implements ServletContextListener {

	static Timer timer = new Timer();
	static TimerTask task;
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
//		task = new TimerTask() {
//			@Override
//			public void run() {
//				//System.out.print(period);
//				System.out.println("++++________________________________++++");	
//			}
//			
//		};
//		
//		timer.schedule(task, 10, 10);
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		timer.cancel();
		timer.purge();
		
	}

}
