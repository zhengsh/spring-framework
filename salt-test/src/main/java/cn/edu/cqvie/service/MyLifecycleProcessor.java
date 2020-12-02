package cn.edu.cqvie.service;

import org.springframework.context.LifecycleProcessor;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

@Component
public class MyLifecycleProcessor implements SmartLifecycle {

	@Override
	public void start() {
		System.out.println("MyLifecycleProcessor start ...");
	}

	@Override
	public void stop() {
		System.out.println("MyLifecycleProcessor stop ...");

	}

	@Override
	public boolean isRunning() {
		return false;
	}

	@Override
	public boolean isAutoStartup() {
		return true;
	}
}
