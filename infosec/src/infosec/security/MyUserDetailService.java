package infosec.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import infosec.dao.UserMapper;
import infosec.utils.PasswordHelper;

public class MyUserDetailService implements UserDetailsService{
	@Autowired
	private UserMapper userMapper;
	
	 //登陆验证时，通过username获取用户的所有权限信息，  
    //并返回User放到spring的全局缓存SecurityContextHolder中，以供授权器使用  
    public UserDetails loadUserByUsername(String username)   
            throws UsernameNotFoundException, DataAccessException {     
        Collection<GrantedAuthority> auths=new ArrayList<GrantedAuthority>();   
        GrantedAuthorityImpl auth3=new GrantedAuthorityImpl("ROLE_PUB"); 
        GrantedAuthorityImpl auth2=new GrantedAuthorityImpl("ROLE_ADMIN");   
        GrantedAuthorityImpl auth1=new GrantedAuthorityImpl("ROLE_USER");   
         
        System.out.println("验证用户");
        infosec.model.User users=userMapper.getUser(username);
        if(users==null){
        	System.out.println("哎呀，没找到该用户");
        	throw new UsernameNotFoundException("user not found"); 
        }else{
        	if(users.getRolecode().equals("ROLE_ADMIN")){
        		auths=new ArrayList<GrantedAuthority>();   
                auths.add(auth2); 
        	}else if(users.getRolecode().equals("ROLE_USER")){
        		auths=new ArrayList<GrantedAuthority>();   
                auths.add(auth1); 
        	}else{
        		auths=new ArrayList<GrantedAuthority>();   
                auths.add(auth3); 
        	}
//        	PasswordHelper phelper=new PasswordHelper();
//        	String pwd=phelper.getSaltedMD5Password(users.getPassword(), null);
//        	assert(1==1):pwd;
        	 User user = new User(username,users.getPassword(), true, true, true, true, auths);  
        	 return user;  
        }
        
         
        }   

}
