package cn.edu.cqvie.cglib0.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

//@Scope("prototype")
//@Lazy

@Service
public class XService {

//	@Autowired
//	private YService yService;

	public XService() {
	}

    public XService(@Autowired YService yService) {
        System.out.println(" -------> x create");
        System.out.println(this);
    }

//	public YService getyService() {
//		return yService;
//	}
//
//	public void setyService(YService yService) {
//		this.yService = yService;
//	}
}
