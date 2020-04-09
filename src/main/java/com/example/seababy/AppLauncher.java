package com.example.seababy;
import com.example.seababy.service.physical.handler.userHandler;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;

public class AppLauncher extends AbstractVerticle {

  @Override
  public void start() throws Exception {

    // 创建HttpServer
    HttpServer server =  vertx.createHttpServer();

    // 创建路由对象
    Router router = Router.router(vertx);

    // 监听地址
    router.route(HttpMethod.GET, "/method").handler(new userHandler());
    server.requestHandler(router::accept);
    server.listen(8888);
  }

  public static void main(String[] args) {
    Vertx.vertx().deployVerticle(new AppLauncher());
  }

}
