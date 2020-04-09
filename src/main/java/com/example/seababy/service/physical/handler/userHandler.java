package com.example.seababy.service.physical.handler;


import com.example.seababy.service.physical.mapper.UserMapper;
import com.example.seababy.service.physical.model.User;
import com.example.seababy.utils.MybatisUtil;
import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;

import java.util.List;

public class userHandler implements Handler<RoutingContext> {
  @Override
  public void handle(RoutingContext routingContext) {
    String param = routingContext.request().getParam("param");
    System.out.println("接收到用户传递的参数为1：" + param);

    //UserDao userDao = new UserDaoImpl(MybatisUtil.GetSqlSession());
    UserMapper userMapper = MybatisUtil.GetSqlSession().getMapper(UserMapper.class);
    List<User> userList = userMapper.queryUserAll();
    for (User user : userList) {
      System.out.println(user);
    }
    routingContext.response().end(param);
  }
}
