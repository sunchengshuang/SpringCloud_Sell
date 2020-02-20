#!/usr/bin/env bash

#mvn clean package -Dmaven.test.skip=true -U

docker build -t springcloud/eurela .

#docker tag 45c497e590a5 registry.cn-hangzhou.aliyuncs.com/sunchengshuang/springcloud:latest  #给镜像打标签

docker push registry.cn-hangzhou.aliyuncs.com/sunchengshuang/springcloud:latest
