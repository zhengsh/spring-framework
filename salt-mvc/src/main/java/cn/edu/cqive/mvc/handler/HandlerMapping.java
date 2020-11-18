package cn.edu.cqive.mvc.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 事件映射器
 *
 * @author zhengsh
 * @date 2020-11-18
 */
public interface HandlerMapping {

    Object getHandlerMapping(String requestURI);
}
