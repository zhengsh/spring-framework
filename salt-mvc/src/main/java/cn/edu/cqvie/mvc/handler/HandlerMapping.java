package cn.edu.cqvie.mvc.handler;

/**
 * 事件映射器
 *
 * @author zhengsh
 * @date 2020-11-18
 */
public interface HandlerMapping {

    Object getHandlerMapping(String requestURI);
}
