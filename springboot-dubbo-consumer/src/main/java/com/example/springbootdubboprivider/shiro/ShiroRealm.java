package com.example.springbootdubboprivider.shiro;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sergei.entity.Permission;
import com.sergei.entity.Role;
import com.sergei.entity.User;
import com.sergei.server.PermissionService;
import com.sergei.server.RoleService;
import com.sergei.server.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.util.ByteSource;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

/**
 * @author sergei
 * @create 2020-03-19
 */
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private SessionDAO sessionDAO;

    @Reference
    UserService userService;

    @Reference
    RoleService roleService;

    @Reference
    PermissionService permissionService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection auth) {
        //授权
        User user = (User) auth.getPrimaryPrincipal();
        System.out.println("进入到授权Realm中："+user.getUserName());

        Set<String> roles = roleService.findRoleByUserId(user.getId());
        System.out.println("roles="+roles.toString());
        Set<String> permissions = permissionService.findPermissionByUserId(user.getId());
        System.out.println("permissions="+permissions.toString());

        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();

        simpleAuthorizationInfo.addRoles(roles);
        simpleAuthorizationInfo.addStringPermissions(permissions);

        return simpleAuthorizationInfo;
    }


    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
        //认证
        String username = (String)auth.getPrincipal();
        String password = new String((char[]) auth.getCredentials());
        String EnCodePassword = new Md5Hash(password, username,10).toString();
        System.out.println("进入到认证Realm中："+username);

        //通过username在数据库中查询用户，判断密码
        User dbuser = userService.selectByUserName(username);
        //通过用户名在数据库中拿到，判断用户名和密码对不对
        if(dbuser!= null && dbuser.getPassWord().equals(EnCodePassword)){
            //在认证之前判断当前登录用户，只允许一个账号登录
            Collection<Session> sessions = sessionDAO.getActiveSessions();

            for (Session session : sessions){
                String loginedUsername = String.valueOf(session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY));

                if(username.equals(loginedUsername)){
                    session.setTimeout(0);
                    break;
                }
            }
           // SecurityUtils.getSubject().login(new );
            // 返回认证信息交由父类AuthorizingRealm认证,父类找到token里的password根据配置的密码加密规则加密，跟传入的密码比较
            return new SimpleAuthenticationInfo(dbuser, dbuser.getPassWord(), ByteSource.Util.bytes(dbuser.getUserName()),getName());
        }

        return null;
    }
}
