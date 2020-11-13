package cn.edu.cqvie.cglib0.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.lang.annotation.Inherited;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

/**
 * @author zhengsh
 */
@Scope(SCOPE_PROTOTYPE)
public abstract class AbstractDogService {

}
