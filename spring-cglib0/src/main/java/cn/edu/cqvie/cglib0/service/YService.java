package cn.edu.cqvie.cglib0.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


//import javax.annotation.PostConstruct;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Scope(SCOPE_PROTOTYPE)
@Service
@DependsOn("xService")
public class YService implements ApplicationContextAware {

    //    @Autowired
//    private XService xService;
    public YService() {
    }

    public YService(@Autowired XService xService) {
        System.out.println(this);
        System.out.println(" -------> y create");
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Aware");
    }

//	@PostConstruct
//	public void lifeInit() {
//		System.out.println("init" + xService);
//	}
}
