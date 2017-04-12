package com.school.restws;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement  
public class User {  
      
    private String userId;  
    private String userName;  
    private String age;  
    private String email;  
      
    public User() {};  
      
    public User(String userId, String userName, String age, String email) {  
        this.userId = userId;  
        this.userName = userName;  
        this.age = age;  
        this.email = email;  
    }  
    public User(String userId, String userName, String age) {  
        this.userId = userId;  
        this.userName = userName;  
        this.age = age;  
    }  
  
    public String getUserId() {  
        return userId;  
    }  
    public void setUserId(String userId) {  
        this.userId = userId;  
    }  
    public String getEmail() {  
        return email;  
    }  
  
    public void setEmail(String email) {  
        this.email = email;  
    }  
  
    public String getUserName() {  
        return userName;  
    }  
    public void setUserName(String userName) {  
        this.userName = userName;  
    }  
    public String getAge() {  
        return age;  
    }  
    public void setAge(String age) {  
        this.age = age;  
    }  
  
    @Override  
    public String toString() {  
        return "{ \"userId\" : \"" + userId + "\", \"userName\" : \"" + userName + "\", \"age\" :\""  
                + age + "\", \"email\" :\"" + email + "\"}";  
    }  
      
      
      
}  
