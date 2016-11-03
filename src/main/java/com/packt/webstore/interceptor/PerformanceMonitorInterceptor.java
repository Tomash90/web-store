package com.packt.webstore.interceptor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.packt.webstore.domain.Cart;
import com.packt.webstore.domain.repository.CartRepository;

public class PerformanceMonitorInterceptor implements HandlerInterceptor {
	@Autowired
	private CartRepository cartRepository;
	ThreadLocal<StopWatch> stopWatchLocal = new ThreadLocal<StopWatch>();
	Logger logger = Logger.getLogger(this.getClass());

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception)
			throws Exception {
		StopWatch stopWatch = stopWatchLocal.get();
		stopWatch.stop();
		logger.info("Łączny czas przetwarzania żądania: " + stopWatch.getTotalTimeMillis()+" ms");
		stopWatchLocal.set(null);
		logger.info("---------------------------------------------------------------------------------------");
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		logger.info("Przetwarzanie żądania zakończono o: " + getCurrentTime());
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		StopWatch stopWatch = new StopWatch(handler.toString());
		stopWatch.start(handler.toString());
		stopWatchLocal.set(stopWatch);
		logger.info("Przetwarzanie żądania do ścieżki " + getURLPath(request));
		logger.info("Przetwarzanie żądania rozpoczęto o: " + getCurrentTime());
		
		HttpSession session = request.getSession(true);
		Cart cart = cartRepository.read(request.getRequestedSessionId());
		if(cart != null){
			session.setAttribute("cartSize", cart.getCartItems().size());
		}
		else {
			session.setAttribute("cartSize", 0);
		}
		
		return true;
	}

	private String getCurrentTime() {
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy 'o' hh:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		return formatter.format(calendar.getTime());
	}

	private String getURLPath(HttpServletRequest request) {
		String currentPath = request.getRequestURI();
		String queryString = request.getQueryString();
		queryString = queryString == null ? "" : "?" + queryString;
		return currentPath+queryString;
	}

}
