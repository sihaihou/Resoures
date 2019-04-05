package com.sxt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxt.service.TestRestfulService;

@RequestMapping("/user")  
@Controller  
public class TestRestfulController {  
  
    @Autowired  
    private TestRestfulService newUserService;  
  
    /** 
     * 根据用户id查询用户数据 
     *  
     * @param id  path variable参数
     * @return 
     */  
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)  
    @ResponseBody  
    public ResponseEntity<String> queryUserById(@PathVariable("id") Long id) {  
        try {  
        	String user = this.newUserService.queryUserById(id);  
            if (null == user) {  
                // 资源不存在，响应404  
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);  
            }  
            // 200  
            // return ResponseEntity.status(HttpStatus.OK).body(user);  
            return ResponseEntity.ok(user);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        // 500  
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);  
    }  
  
    /** 
     * 新增用户 
     *  
     * @param user 
     * @return 
     */  
    @RequestMapping(method = RequestMethod.POST)  
    public ResponseEntity<Void> saveUser(String user) {  
        try {  
            this.newUserService.saveUser(user);  
            return ResponseEntity.status(HttpStatus.CREATED).build();  
        } catch (Exception e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
        // 500  
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);  
    }  
  
    /** 
     * 更新用户资源 
     *  
     * @param user 
     * @return 
     */  
    @RequestMapping(method = RequestMethod.PUT)  
    public ResponseEntity<Void> updateUser(String user) {  
        try {  
            this.newUserService.updateUser(user);  
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        // 500  
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);  
    }  
  
    /** 
     * 删除用户资源 
     *  
     * @param user 
     * @return 
     */  
    @RequestMapping(method = RequestMethod.DELETE)  
    public ResponseEntity<Void> deleteUser(@RequestParam(value = "id", defaultValue = "0") Long id) {  
        try {  
            if (id.intValue() == 0) {  
                // 请求参数有误  
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();  
            }  
            this.newUserService.deleteUserById(id);  
            // 204  
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        // 500  
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);  
    }  
}  
