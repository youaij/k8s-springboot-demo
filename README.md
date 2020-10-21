# k8s-springboot-demo


#### 镜像操作

```bash
# 镜像制作(自行选择镜像仓库)
$ docker build -t ccr.ccs.tencentyun.com/youaijj/springboot-k8s-demo -f images/Dockerfile .

# 登入个人tke镜像仓库
$ docker login ccr.ccs.tencentyun.com

# 推镜像
$ docker push ccr.ccs.tencentyun.com/youaijj/springboot-k8s-demo

```

#### helm 部署应用

```bash
# chart语法检查
$ helm lint springboot-demo-chart/

# 打包chart
$ helm package springboot-demo-chart

# 替换检查
$ helm install --dry-run --debug local/springboot-demo-chart --name springboot-demo-chart

# 检查无误后，发布
$ helm install local/springboot-demo-chart --name springboot-demo-chart
```

#### 验证

```bash
➜  ~ kubectl get pod
NAME                                     READY   STATUS    RESTARTS   AGE
springboot-demo-chart-545bf4dbbf-hzpb4   1/1     Running   0          26m
➜  ~
➜  ~ kubectl get svc
NAME                    TYPE        CLUSTER-IP       EXTERNAL-IP   PORT(S)        AGE
springboot-demo-chart   ClusterIP   172.18.254.3     <none>        80/TCP         26m
➜  ~
```
service类型为ClusterIP，因此登入k8s集群一个节点上查询：
```bash
[root@VM-0-4-centos ~]# curl 172.18.254.3/config
{"msg":"prod profile","env":"prod"}
```
验证成功。