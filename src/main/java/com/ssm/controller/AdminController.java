package com.ssm.controller;

import com.ssm.bean.*;
import com.ssm.bean.dto.ParkDTA;
import com.ssm.service.*;
import com.ssm.util.JsonUtil;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {
    Logger logger = LoggerFactory.getLogger(AdminController.class);
    @Autowired
    private IUserService userService;
    @Autowired
    private IAdminService adminService;
    @Autowired
    private IParkService parkService;
    @Autowired
    private IChargerService chargerService;
    @Autowired
    private ISitInfoService sitInfoService;

    /**
     * 登录
     */
    @RequestMapping("/login")
    @ResponseBody
    public JSONObject login(HttpServletRequest request) {
        logger.debug(" admin login ...");
        String data = request.getParameter("data");
        JSONObject object = new JSONObject();
        Map<String, Object> param = JsonUtil.getMapFromJson(data);
        List<Admin> admin = adminService.getAdmin(param);
        if (admin.size() > 0) {
            object.put("code", 200);
            object.put("message", "success");
            object.put("uid", admin.get(0).getId());
            object.put("username", admin.get(0).getUsername());
            request.getSession().setAttribute("id", admin.get(0).getId());
            request.getSession().setAttribute("admin", admin.get(0).getUsername());
        } else {
            object.put("code", 100);
            object.put("message", "用户名密码错误");
        }
        return object;
    }

    /**
     * 修改用户信息
     */
    @RequestMapping("/updateInfo")
    @ResponseBody
    public JSONObject updateInfo(HttpServletRequest request) {
        logger.debug(" updateInfo ...");
        String data = request.getParameter("data");
        JSONObject object = new JSONObject();
        Map<String, Object> param = JsonUtil.getMapFromJson(data);
        int i = userService.updateInfo(param);
        if (i > 0) {
            object.put("code", 200);
            object.put("message", "success");
        } else {
            object.put("code", 100);
            object.put("message", "失败");
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
        return "./login_manager";
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
        int i = adminService.updatePwd(param);
        if (i > 0) {
            object.put("code", 200);
            object.put("message", "success");
        }else{
            object.put("code", 100);
        }
        return object;
    }
    /**
     * 停车
     */
    @RequestMapping("/tingche")
    @ResponseBody
    public JSONObject tingche(HttpServletRequest request) {
        logger.debug("tingche ...");
        String data = request.getParameter("data");
        JSONObject object = new JSONObject();
        Map<String, Object> param = JsonUtil.getMapFromJson(data);
        int i = parkService.tingche(param);
        if (i != 0) {
            object.put("code", 200);
            object.put("message", "注册成功");
        } else {
            object.put("code", 100);
            object.put("message", "注册失败");
        }
        return object;
    }

    /**
     * 出车
     */
    @RequestMapping("/chuche")
    @ResponseBody
    public JSONObject chuche(HttpServletRequest request) {
        logger.debug("chuche ...");
        String data = request.getParameter("data");
        JSONObject object = new JSONObject();
        Map<String, Object> param = JsonUtil.getMapFromJson(data);
        Park park = parkService.chuche(param);
        if (park !=null) {
            object.put("code", 200);
            object.put("message", "出车成功");
            object.put("fee", park.getFee());
        } else {
            object.put("code", 100);
            object.put("message", "出车成功");
        }
        return object;
    }


    /**
     * 用户注册
     */
    @RequestMapping("/register")
    @ResponseBody
    public JSONObject register(HttpServletRequest request) {
        logger.debug("register ...");
        String data = request.getParameter("data");
        JSONObject object = new JSONObject();
        Map<String, Object> param = JsonUtil.getMapFromJson(data);
        int i = userService.addUser(param);
        if (i != 0) {
            object.put("code", 200);
            object.put("message", "注册成功");
        } else {
            object.put("code", 100);
            object.put("message", "注册失败");
        }
        return object;
    }

    /**
     * 修改密码
     */
    @RequestMapping("changepwd")
    @ResponseBody
    public JSONObject changepwd(HttpServletRequest request) {
        logger.debug("changepwd begin ...");
        String data = request.getParameter("data");
        JSONObject object = new JSONObject();
        Map<String, Object> param = JsonUtil.getMapFromJson(data);

        return object;
    }


    /**
     * 查询出入场信细
     */
    @RequestMapping("queryPark")
    @ResponseBody
    public JSONObject queryPark(HttpServletRequest request) {
        JSONObject object = new JSONObject();
        List<Park> parks = parkService.queryAll();
        if (parks.size() != 0) {
            object.put("code", 200);
            object.put("message", "success");
            object.put("parks", parks);
            object.put("size", parks.size());
        } else {
            object.put("code", 100);
            object.put("message", "暂无数据");
        }
        return object;
    }

    /**
     * 查询出入场信细
     */
    @RequestMapping("queryParkByCarId")
    @ResponseBody
    public JSONObject queryParkByCarId(HttpServletRequest request) {
        String data = request.getParameter("data");
        Map<String, Object> param = JsonUtil.getMapFromJson(data);
        JSONObject object = new JSONObject();
        List<Park> parks;
        if (param.get("carId").equals("")) {
            parks = parkService.queryAll();
        } else {
            parks = parkService.queryUserByCarId(param);
        }
        if (parks.size() != 0) {
            object.put("code", 200);
            object.put("message", "success");
            object.put("parks", parks);
            object.put("size", parks.size());
        } else {
            object.put("code", 100);
            object.put("message", "暂无数据");
        }
        return object;
    }

    /**
     * 查询用户信细
     */
    @RequestMapping("queryUser")
    @ResponseBody
    public JSONObject queryUser(HttpServletRequest request) {
        JSONObject object = new JSONObject();
        List<User> users = userService.queryAll();
        if (users.size() != 0) {
            object.put("code", 200);
            object.put("message", "success");
            object.put("users", users);
            object.put("size", users.size());
        } else {
            object.put("code", 100);
            object.put("message", "暂无数据");
        }
        return object;
    }

    /**
     * 按车牌号查询用户信细
     */
    @RequestMapping("queryUserByCarId")
    @ResponseBody
    public JSONObject queryUserByCarId(HttpServletRequest request) {
        String data = request.getParameter("data");
        Map<String, Object> param = JsonUtil.getMapFromJson(data);
        List<User> users;
        JSONObject object = new JSONObject();
        if (param.get("carId").equals("")) {
            users = userService.queryAll();
        } else {
            users = userService.queryUserByCarId(param);
        }
        if (users.size() != 0) {
            object.put("code", 200);
            object.put("message", "success");
            object.put("users", users);
            object.put("size", users.size());
        } else {
            object.put("code", 100);
            object.put("message", "暂无数据");
        }
        return object;
    }

    /**
     * 按车牌号查询用户信细
     */
    @RequestMapping("queryUserById")
    @ResponseBody
    public JSONObject queryUserById(HttpServletRequest request) {
        String data = request.getParameter("data");
        Map<String, Object> param = JsonUtil.getMapFromJson(data);
        List<User> users;
        JSONObject object = new JSONObject();
        users = userService.queryUserById(param);
        if (users.size() != 0) {
            object.put("code", 200);
            object.put("message", "success");
            object.put("users", users);
            object.put("size", users.size());
        } else {
            object.put("code", 100);
            object.put("message", "暂无数据");
        }
        return object;
    }

    /**
     * 查询当前可用车位信息
     */
    @RequestMapping("querySit")
    @ResponseBody
    public JSONObject querySit(HttpServletRequest request) {
        JSONObject object = new JSONObject();
        List<SitInfor> sitInfors;
        sitInfors = sitInfoService.queryFree();
        if (sitInfors.size() != 0) {
            object.put("code", 200);
            object.put("message", "success");
            object.put("sitInfors", sitInfors);
            object.put("size", sitInfors.size());
        } else {
            object.put("code", 100);
            object.put("message", "暂无数据");
        }
        return object;
    }

    /**
     * 查询当前在场信息
     */
    @RequestMapping("queryParking")
    @ResponseBody
    public JSONObject queryParking(HttpServletRequest request) {
        JSONObject object = new JSONObject();
        List<ParkDTA> parks;
        parks = parkService.queryParking();
        if (parks.size() != 0) {
            object.put("code", 200);
            object.put("message", "success");
            object.put("parks", parks);
            object.put("size", parks.size());
        } else {
            object.put("code", 100);
            object.put("message", "暂无数据");
        }
        return object;
    }

    /**
     * 查询计费标准
     */
    @RequestMapping("queryCharger")
    @ResponseBody
    public JSONObject queryCharger(HttpServletRequest request) {
        JSONObject object = new JSONObject();
        List<Charger> chargers = chargerService.queryAll();
        if (chargers.size() != 0) {
            object.put("code", 200);
            object.put("message", "success");
            object.put("chargers", chargers);
            object.put("size", chargers.size());
        } else {
            object.put("code", 100);
            object.put("message", "暂无数据");
        }
        return object;
    }

    /**
     * 充值
     */
    @RequestMapping("charger")
    @ResponseBody
    public JSONObject charger(HttpServletRequest request) {
        String data = request.getParameter("data");
        Map<String, Object> param = JsonUtil.getMapFromJson(data);
        JSONObject object = new JSONObject();
       int i = userService.charger(param);
        if (i != 0) {
            object.put("code", 200);
            object.put("message", "success");
        } else {
            object.put("code", 100);
        }
        return object;
    }
}

