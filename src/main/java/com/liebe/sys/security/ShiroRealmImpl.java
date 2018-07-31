package com.liebe.sys.security;

import com.liebe.sys.entity.User;
import com.liebe.sys.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2017/9/19.
 */
public class ShiroRealmImpl extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    //认证.登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.print("-----------------------------");
        UsernamePasswordToken utoken=(UsernamePasswordToken) token;//获取用户输入的token
        String username = utoken.getUsername();
        User user = userService.findUserByUserName(username);
        if(user ==null){
            return null;
        }
        return new SimpleAuthenticationInfo(user, user.getPassword(),this.getClass().getName());//放入shiro.调用CredentialsMatcher检验密码
    }
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        User user=(User) principal.fromRealm(this.getClass().getName()).iterator().next();//获取session中的用户
        List<String> permissions=new ArrayList<>();
//        Set<Role> roles = user.getRoles();
        System.out.println("授权判断--------------------------------------------------");
//        String userName = (String) principals.fromRealm( getName() ).iterator().next();
//        Admin admin=adminMapper.getAdminRoleIdsByUserName(userName);
//        if(admin==null)	{
//            return null;
//        }
        String username = user.getUsername();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //角色授权
        info.addRole("user");
        if(username.equals("admin")){
            info.addRole("admin");
        }
//        String [] roleCode=user.getRole().getCode().split(",");
//        for(int i=0;i<roleCode.length;i++){
//            info.addRole(roleCode[i]);
//        }
//        //权限资源授权
//        List<Menu> permissionList = new ArrayList<Menu>();
//        if(user.getRole().getCode().equals("super")){
//            //超级管理员
//            user.getRole().setrId("888888");
//            permissionList = menuMapper.getSuperAdminAuthorityList();
//        } else {
//            String[] rIds = admin.getRole().getrId().split(",");
//            permissionList = menuMapper.getUserAuthorityList(rIds);
//        }
//        if(permissionList!=null){
//            List<String> permissionStr=new ArrayList<String>();
//            for(int j=0;j<permissionList.size();j++){
//                permissionStr.add(permissionList.get(j).getPermission());
//            }
//            info.addStringPermissions(permissionStr);
//        }
        return info;

    }

}

