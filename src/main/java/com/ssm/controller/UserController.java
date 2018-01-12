package com.ssm.controller;

import com.ssm.bean.User;
import com.ssm.service.IUserService;
import com.ssm.util.JsonUtil;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private IUserService userService;

    /**
     * 登录
     */
    @RequestMapping("/login")
    @ResponseBody
    public JSONObject login(HttpServletRequest request) {
        logger.debug("login ...");
        String data = request.getParameter("data");
        JSONObject object = new JSONObject();
        Map<String, Object> param = JsonUtil.getMapFromJson(data);
        List<User> users = userService.getUser(param);
        if (users.size() > 0) {
            object.put("code", 200);
            object.put("message", "success");
            object.put("uid", users.get(0).getId());
            object.put("username", users.get(0).getUsername());
            object.put("carId", users.get(0).getCarId());
            request.getSession().setAttribute("id",users.get(0).getId());
            request.getSession().setAttribute("cardId",users.get(0).getCarId());
            request.getSession().setAttribute("username",users.get(0).getUsername());
        }else{
            object.put("code", 100);
            object.put("message", "用户名密码错误");
        }
        return object;
    }

    /**
     * 退出登录
     *
     * @param request
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        logger.info("logout begin ...");
        JSONObject obj = new JSONObject();
        request.getSession().removeAttribute("username");
        obj.put("code", 200);
        obj.put("message", "success");
        request.getSession().removeAttribute("id");
        return "./login";
    }
    /**
     * 根据iD查找user
     * @param request
     * @return
     */
    @RequestMapping("/queryUserById")
    @ResponseBody
    public JSONObject queryUserById(HttpServletRequest request) {
        logger.debug("login ...");
        String id = (String) request.getSession().getAttribute("id");
        JSONObject object = new JSONObject();
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("id", id);
        List<User> users = userService.getUser(param);
        if (users.size() > 0) {
            object.put("code", 200);
            object.put("message", "success");
            object.put("user", users.get(0));
        }else{
            object.put("code", 100);
        }
        return object;
    }

    /**
     * 修改密码
     * @param request
     * @return
     */
    @RequestMapping("/updatePwd")
    @ResponseBody
    public JSONObject updatePwd(HttpServletRequest request) {
        logger.debug("updatePwd ...");
        String id = (String) request.getSession().getAttribute("id");
        String data = request.getParameter("data");
        JSONObject object = new JSONObject();
        Map<String, Object> param = JsonUtil.getMapFromJson(data);
        param.put("id", id);
        int i = userService.updatePwd(param);
        if (i > 0) {
            object.put("code", 200);
            object.put("message", "success");
        }else{
            object.put("code", 100);
        }
        return object;
    }


    /**
     * 查询出入场信细
     */

    /**
     * 查询当前可用车位信息
     */

    /**
     * 查询当前在场信息
     */

    /**
     * 查询计费标准
     */

    /**
     * 查询车辆历史记录
     */
}

