package com.service.Impl;

import com.dao.UserDao;
import com.domain.Role;
import com.domain.UserInfo;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Description: UserService实现类
 * 对应spring-security.xml文件中的userService
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userDao.findByUsername(username);

        //使用springSecurity自带的User对象对UserInfo对象进行封装成UserDetails对象
        //需要传入三个参数，（username，password，权限authorities）
        //{noop}前缀是在密码没有加密的情况下需要加入的前缀，保证安全
        //User user = new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),getAuthorities(userInfo.getRoles()));

        //使用更强大的构造函数处理，其中增加了user的status判断，0表示用户不可用 1表示用户可用
        User user = new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),userInfo.getStatus()==0?false:true,true,true,true,getAuthorities(userInfo.getRoles()));
        return user;
    }

    /**
     * @Description 作用是返回一个list集合，集合中装入的是角色描述
     * @Param [roles]
     * @return java.util.List<org.springframework.security.core.authority.SimpleGrantedAuthority>
     **/
    private List<SimpleGrantedAuthority> getAuthorities(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role :
                roles) {
            //因为配置文件中有access="ROLE_USER,ROLE_ADMIN"，因此需要进行字符串拼接
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }

        return list;
    }
}
