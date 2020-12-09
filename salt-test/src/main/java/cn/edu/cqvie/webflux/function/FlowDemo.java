package cn.edu.cqvie.webflux.function;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

/**
 * @author zhengsh
 * @date 2020-11-03
 */
public class FlowDemo {

	public static void main(String[] args) throws InterruptedException {
		//发布者
		SubmissionPublisher<String> publisher = new SubmissionPublisher<String>();
		//订阅者
		Flow.Subscriber subscriber = new Flow.Subscriber() {
			/**
			 * 建立调用关系
			 * @param subscription 订阅协议
			 */
			@Override
			public void onSubscribe(Flow.Subscription subscription) {
				System.out.println("建立调用关系，第一次调用");
				subscription.request(100L);
			}

			@Override
			public void onNext(Object item) {
				System.out.println("接受数据：" + item);
			}

			@Override
			public void onError(Throwable throwable) {
				System.out.println("Error");
			}

			@Override
			public void onComplete() {
				System.out.println("Complete");
			}
		};
		//建立订阅关系
		publisher.subscribe(subscriber);
		//发送数据
		for (int i = 0; i < 100; i++) {
			publisher.submit("webflux 发送数据： " + i);
		}
		Thread.currentThread().join();
		//结束
		publisher.close();


	}
}
