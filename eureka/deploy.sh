#!/usr/bin/env bash
#编译+部署eureka站点
#需要配置如下参数
# 项目路径，在Excute Shell 中配置项目路径，pwd 就可以获得该项目的路径
# export PROJ_PATH=这个jenkins任务在部署机器上的路径
# 输入你环境上的tomtat的全路径
# export TOMCAT_APP_PATH=tomcat在部署机器上的路径
### base 函数
killTomcat()
{
   pid=`ps -ef|grep tomcat|grep java|awk '{print $2}'`
   echo "tomcat Id list :$pid"
   if [ "$pid" = ""]
   then
     echo "no tomcat pid alive"
   else
     kill -9 $pid
   fi
}
cd $PROJ_PATH/SpringCloud_Sell/eureka # 修改
#mvn clean install
mvn clean package install '-Dmaven.test.skip=true'
# 停tomcat
killTomcat
# 删除原有工程
rm -rf TOMCAT_APP_PATH/webapps/ROOT
rm -f TOMCAT_APP_PATH/webapps/ROOT.jar
rm -f TOMCAT_APP_PATH/webapps/eureka-0.0.1-SNAPSHOT.jar
# 复制1新的工程
cp $PROJ_PATH/SpringCloud_Sell/eureka/target/eureka-0.0.1-SNAPSHOT.jar $TOMCAT_APP_PATH/webapps/ # 修改
cd $TOMCAT_APP_PATH/webapps
mv eureka-0.0.1-SNAPSHOT.jar ROOT.jar
# 启动tomtat
cd $TOMCAT_APP_PATH
sh bin/startup.sh
java -jar ROOT.jar