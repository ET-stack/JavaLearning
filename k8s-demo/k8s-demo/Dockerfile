# 使用官方的 OpenJDK 作为基础镜像
FROM openjdk:8-jre-slim

# 维护者信息
MAINTAINER 1826869334@qq.com

# 创建工作目录 /app
VOLUME /tmp

# 将 JAR 文件复制到容器中 /app 目录
ADD target/*.jar app.jar


# 运行 JAR 文件
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080

