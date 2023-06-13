记录一些模板代码

# 使用mybatis plus插件生成各层次代码
示例代码目录: mybatis-plus-generator-ui-demo
```bash
# 1 运行src/main/test/GeneratoryUiServer中的代码
# 2 浏览器输入http://localhost:8068进入代码生成UI
# 3 输出配置中根据需要配置各生成的规则
```


```bash
# 增加master分支
git checkout -b master
git remote add master git@github.com:yubaobei/template-code.git
git branch --set-upstream-to=remotes/origin/master
```

# springboot通用父pom
示例代码目录: parent


# 打包项目,配置文件和依赖分离,使用dockerfile构建image
示例代码目录: sample-build-with-docker

```bash
# cd build
mvn clean install

cd output/
docker builkd -t app:test .
```