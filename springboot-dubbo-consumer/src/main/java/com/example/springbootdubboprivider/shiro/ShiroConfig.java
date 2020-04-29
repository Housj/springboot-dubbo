package com.example.springbootdubboprivider.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.session.mgt.eis.MemorySessionDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sergei
 * @create 2020-03-19
 */
@Configuration
public class ShiroConfig {
    /**
     唯一需要修改的地方，有注释
     * ShiroFilterFactoryBean 处理拦截资源文件问题。
     * 注意：单独一个ShiroFilterFactoryBean配置是或报错的，
     * 因为在初始化ShiroFilterFactoryBean的时候需要注入：SecurityManager
     * Filter Chain定义说明
     * 1、一个URL可以配置多个Filter，使用逗号分隔
     * 2、当设置多个过滤器时，全部验证通过，才视为通过
     * 3、部分过滤器可指定参数，如perms，roles
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilter(DefaultWebSecurityManager securityManager){

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 必须设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        //访问的是后端url地址为 /login的接口,/未登录页面,会跳转到登录页面
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/list");
        // 未授权界面;，基于AOP拦截，都会到登录页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/login");
        // 拦截器.
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();

        List<Map<String, String>> perms = this.getShiroFilterProperties().getPerms();
        perms.forEach(perm -> filterChainDefinitionMap.put(perm.get("key"), perm.get("value")));

        // 配置不会被拦截的链接 顺序判断，anon放开，不会拦截，authc会拦截
        //静态资源不能被拦截
//        filterChainDefinitionMap.put("/assets/**", "anon");
//        filterChainDefinitionMap.put("/css/**", "anon");
//        filterChainDefinitionMap.put("/js/**", "anon");
//        filterChainDefinitionMap.put("/images/**", "anon");
//        filterChainDefinitionMap.put("/fonts/**", "anon");
//        filterChainDefinitionMap.put("/login", "anon");
//        filterChainDefinitionMap.put("/userLogin", "anon");
        // 配置退出过滤器,其中的具体的退出代码Shiro已经替我们实现了
//        filterChainDefinitionMap.put("/logout", "logout");
        //配置某个url需要某个权限码
//        filterChainDefinitionMap.put("/hello", "perms[how_are_you]");
        // 过滤链定义，从上向下顺序执行，一般将 /**放在最为下边
        // <!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
//        filterChainDefinitionMap.put("/**", "authc");


        //配置记住我或认证通过可以访问的地址
//        filterChainDefinitionMap.put("/index", "user");
//        filterChainDefinitionMap.put("/", "user");

        System.out.println("Shiro拦截器工厂类注入成功");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }


    @Bean
    public ShiroFilterProperties getShiroFilterProperties(){
        return new ShiroFilterProperties();
    }


    /**
     * 缓存
     * @return
     */
    @Bean
    public EhCacheManager getEhCacheCache() {
        EhCacheManager em = new EhCacheManager();
        em.setCacheManagerConfigFile("classpath:ehcache-shiro.xml");
        return em;
    }

    /**
     * 代理
     * @return
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator daap = new DefaultAdvisorAutoProxyCreator();
        daap.setProxyTargetClass(true);
        return daap;
    }

    @Bean
    public DefaultWebSessionManager getDefaultWebSessionManager() {
        DefaultWebSessionManager defaultWebSessionManager = new DefaultWebSessionManager();
        defaultWebSessionManager.setSessionDAO(getMemorySessionDAO());
        defaultWebSessionManager.setGlobalSessionTimeout(1 * 60 * 60 * 1000);
        defaultWebSessionManager.setSessionValidationSchedulerEnabled(true);
        defaultWebSessionManager.setSessionIdCookieEnabled(true);
        defaultWebSessionManager.setSessionIdCookie(getSimpleCookie());
        return defaultWebSessionManager;
    }

    @Bean
    public MemorySessionDAO getMemorySessionDAO() {
        MemorySessionDAO memorySessionDAO = new MemorySessionDAO();
        memorySessionDAO.setSessionIdGenerator(javaUuidSessionIdGenerator());
        return memorySessionDAO;
    }
    @Bean
    public JavaUuidSessionIdGenerator javaUuidSessionIdGenerator() {
        return new JavaUuidSessionIdGenerator();
    }

    /**
     * cookie对象
     * @return
     */
    @Bean
    public SimpleCookie getSimpleCookie() {
        SimpleCookie simpleCookie = new SimpleCookie();
        simpleCookie.setName("security.session.id");
        //<!-- 记住我cookie生效时间30天 ,单位秒;-->
        simpleCookie.setMaxAge(259200);
        simpleCookie.setPath("/");
        return simpleCookie;
    }

    /**
     * cookie管理对象;
     * @return
     */
    /*@Bean
    public CookieRememberMeManager rememberMeManager(){
        System.out.println("ShiroConfiguration.rememberMeManager()");
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(getSimpleCookie());
        return cookieRememberMeManager;
    }*/
    @Bean
    public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    /**
     * 注入 securityManager
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(
            ShiroRealm shiroRealm) {
        DefaultWebSecurityManager dwsm = new DefaultWebSecurityManager();
        // 关联realm.
        dwsm.setRealm(shiroRealm);
        //用户授权/认证信息Cache,采用EhCache缓存
        dwsm.setCacheManager(getEhCacheCache());
        dwsm.setSessionManager(getDefaultWebSessionManager());
        //注入记住我管理器;
        /*  dwsm.setRememberMeManager(rememberMeManager());*/
        return dwsm;
    }

    /*
     * 凭证匹配器 （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了
     * 所以我们需要修改下doGetAuthenticationInfo中的代码; )
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");// 散列算法:这里使用MD5算法;
        hashedCredentialsMatcher.setHashIterations(10);// 散列的次数，比如散列两次，相当于md5(md5(""));
        return hashedCredentialsMatcher;
    }

    @Bean
    public ShiroRealm shiroRealm(EhCacheManager cacheManager) {
        ShiroRealm shiroRealm = new ShiroRealm();
        shiroRealm.setCacheManager(cacheManager);
        shiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return shiroRealm;
    }

    //开启shiro注解支持
    @Bean
    public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor(ShiroRealm shiroRealm){
        AuthorizationAttributeSourceAdvisor aasa =new AuthorizationAttributeSourceAdvisor();
        aasa.setSecurityManager(getDefaultWebSecurityManager(shiroRealm));
        return aasa;
    }

    /**
     * 配置前台页面thymeleaf页面的标签
     * @return
     */
    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }
}
