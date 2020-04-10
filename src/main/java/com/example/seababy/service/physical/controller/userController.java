package com.example.seababy.service.physical.controller;

import com.example.seababy.annotations.RequestMapping;
import com.example.seababy.annotations.RestController;
import com.example.seababy.service.physical.mapper.UserMapper;
import com.example.seababy.service.physical.model.User;
import com.example.seababy.utils.MybatisUtil;
import io.vertx.ext.web.RoutingContext;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RestController
public class userController {
  private static final UserMapper userMapper = MybatisUtil.GetSqlSession().getMapper(UserMapper.class);

  @RequestMapping("test/world")
  public String test(RoutingContext routingContext) {
    String param = routingContext.request().getParam("param");
    System.out.println("接收到用户传递的参数为1：" + param);
    List<User> userList = userMapper.queryUserAll();
    for (User user : userList) {
      System.out.println(user);
    }
   // routingContext.response().end(param);
    return param;
  }
  @RequestMapping("helloWorld/world")
  public String helloWorld() {
    return "Hellos world";
  }
}
