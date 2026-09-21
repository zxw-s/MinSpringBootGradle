# README.md 模板（SpringBoot + Maven，IDEA，GitHub）

# 项目名称

> 一句话描述项目（例如：SpringBoot简易学生管理后台API）

## ✨ 项目简介

基于 SpringBoot + Maven 开发的后端API项目，使用 IntelliJ IDEA 开发。
实现了【业务功能，如用户管理、数据增删改查】，适合学习演示、接口测试。

## 📋 环境要求

- JDK：JDK 8 / JDK 17
- 构建工具：Maven 3.6+
- IDE：IntelliJ IDEA
- 数据库：MySQL 8.0（可选，无数据库可删除本行）
- 接口测试：Postman / Apifox

## 📁 项目结构

```plaintext
├── src
│ ├── main
│ │ ├── java/com/xxx/demo
│ │ │ ├── controller # 接口控制器
│ │ │ ├── service # 业务逻辑层
│ │ │ ├── mapper # 数据库访问层（MyBatis可选）
│ │ │ ├── entity # 实体类
│ │ │ └── DemoApplication.java # SpringBoot启动入口
│ │ └── resources
│ │ ├── application.yml # 主配置文件
│ │ ├── application-local.yml # 本地配置（不提交git）
│ │ └── static # 静态资源
│ └── test # 单元测试
├── pom.xml # Maven依赖管理
├── .gitignore # Git忽略文件
└── README.md # 项目说明
```

## 🚀 快速启动

### 1. 克隆代码

```bash
git clone [https://github.com/](https://github.com/)你的用户名/仓库名.git
cd 仓库名
```

### 2. IDEA打开项目

1. IDEA `Open` 项目，选中包含 `pom.xml` 的根目录
2. 等待右下角Maven加载、自动下载依赖
3. 配置项目JDK，版本与pom.xml保持一致

### 3. 修改配置（数据库项目需要）

编辑 `application.yml`，修改数据库连接账号密码

> 本地私有配置推荐写在 `application-local.yml`，并加入.gitignore，避免提交到远程仓库

### 4. 启动项目

#### 方式1：IDEA直接运行

找到 `XxxApplication.java`（带`@SpringBootApplication`），右键 `Run` 默认访问地址：[http://localhost:8080](http://localhost:8080/)

#### 方式2：Maven命令启动

```bash
# 编译
mvn compile
# SpringBoot运行
mvn spring-boot:run
# 打包，jar包输出到 target 文件夹
mvn package
```

### 5. 打包后运行jar包

```bash
java -jar target/xxx-0.0.1-SNAPSHOT.jar
```

## 📌 接口示例

> 示例：获取用户列表

- 请求地址：`GET /api/user/list`
- 返回示例：

```
{
  "code":200,
  "msg":"success",
  "data":[]
}
```

## 📦 Maven常用命令

```bash
mvn clean                  # 清理target打包文件
mvn compile                # 编译源码
mvn test                   # 执行单元测试
mvn package                # 打包生成jar
mvn spring-boot:run        # 直接启动springboot项目
```

## 📝 开发规范

> Git提交规范：`type(scope): description`

- `feat`：新增接口/功能
- `fix`：修复bug
- `docs`：修改文档、注释
- `refactor`：代码重构，无功能变更
- `perf`：性能优化
- `test`：新增单元测试
- `chore`：修改pom、gitignore、构建配置

## ❗ 常见问题

1. Maven依赖下载慢
   
   > Maven配置阿里云镜像，刷新Maven项目

2. 端口8080被占用
   
   > 在application.yml 修改 server.port=8081

3. 数据库连接失败
   
   > 检查数据库地址、账号密码，确认MySQL服务已启动

4. 本地配置提交到仓库
   
   > 将 application-local.yml 写入.gitignore

## 📄 License

MIT

## 使用说明

1. 项目根目录新建 `README.md`
2. 复制全部内容，替换项目名、包名、功能描述
3. 配合 SpringBoot专用 `.gitignore` 一起使用
