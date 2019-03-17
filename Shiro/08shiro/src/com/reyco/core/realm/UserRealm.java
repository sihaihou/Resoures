package com.reyco.core.realm;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.reyco.core.pojo.Account;
import com.reyco.core.pojo.Permission;
import com.reyco.core.service.AccountService;
import com.reyco.core.service.PermissionService;


/**
 * 自定义realm
 * @author reyco
 *
 */
public class UserRealm extends AuthorizingRealm{
	
	@Autowired
	private AccountService accountService;
	@Autowired
	private PermissionService permissionService;
	
	@Override
	public String getName() {
		return "UserRealm";
	}
	/**
	 * 验证
	 * @param arg0
	 * @return
	 * @throws AuthenticationException
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = token.getPrincipal().toString();
		System.out.println("----------认证-----------------username="+username);
		Account account = accountService.searchUserByUserName(username);
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(account, account.getPassword(),ByteSource.Util.bytes(account.getSalt()),getName());
		return simpleAuthenticationInfo;
	}
	/**
	 * 授权
	 * @param principal
	 * @return
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
		Account account = (Account) principal.getPrimaryPrincipal();
		System.out.println("----------凭证-----------------username="+account);
		List<Permission> permissions = permissionService.searchPermissionByUserId(account.getId());
		if(null == permissions || permissions.size()==0) {
			return null;
		}
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		System.out.println("----------info-----------------info="+info);
		for (Permission permission : permissions) {
			String percode = permission.getPercode();
			if(null!=percode) {
				info.addStringPermission(percode);
			}
		}
		return info;
	}
	/**
	 * 清理缓存
	 */
	protected void clearCache() {
		Subject subject = SecurityUtils.getSubject();
		super.clearCache(subject.getPrincipals());
	}
}
