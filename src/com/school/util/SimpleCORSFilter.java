package com.school.util;

import java.io.IOException; 
import javax.servlet.Filter; 
import javax.servlet.FilterChain; 
import javax.servlet.FilterConfig; 
import javax.servlet.ServletException; 
import javax.servlet.ServletRequest; 
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 


/**
 * ��ӿ�������ͷ
 * @author Long
 *
 */
public class SimpleCORSFilter implements Filter { 
  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException { 
    HttpServletResponse response = (HttpServletResponse) res; 
    HttpServletRequest request = (HttpServletRequest) req;
    response.setHeader("Access-Control-Allow-Origin", "*");//��������      
response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));//cookie������������� 
   response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE"); 
        response.setHeader("Access-Control-Max-Age", "3600"); 
        response.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token");  
        response.setHeader("Access-Control-Allow-Credentials", "true");//cookie ���� 
        response.setHeader("XDomainRequestAllowed","1");  
    chain.doFilter(req, res); 
  } 
  public void init(FilterConfig filterConfig) {} 
  public void destroy() {} 
} 