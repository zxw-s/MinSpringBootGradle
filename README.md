# README.md 模板（IDEA + Gradle + SpringBoot GitHub项目）

# 📖 项目简介

基于 SpringBoot + Gradle 构建的后端项目，使用 IDEA 开发。

> 技术栈：SpringBoot、Spring Web、Gradle，可自行扩展 MyBatis-Plus、Redis、MySQL等。

## ✨ 环境要求

- JDK：17（可修改为你的版本）
- IDE：IntelliJ IDEA
- 构建工具：Gradle
- 推荐Git版本：2.30+

## 📂 项目目录结构

```plaintext
├── src
│ ├── main
│ │ ├── java # 业务代码
│ │ │ └── com.xxx.demo
│ │ │ ├── controller # 接口层
│ │ │ ├── service # 业务层
│ │ │ ├── mapper # 数据访问层
│ │ │ └── entity # 实体类
│ │ └── resources
│ │ ├── application.yml # 项目配置文件
│ │ └── static # 静态资源
│ └── test # 单元测试代码
├── gradle # gradle wrapper
├── build.gradle # gradle构建配置
├── settings.gradle # 项目模块配置
└── README.md # 项目说明文档
```

## 🚀 快速启动

### 方式1：IDEA 启动

1. git clone 拉取代码到本地
2. IDEA 打开项目，等待 Gradle 依赖自动加载
   
   > ✅ 推荐配置阿里云镜像加速依赖下载
3. 等待依赖下载完成，找到启动类 `XxxApplication.java`
4. 右键 `Run` 启动项目
5. 访问地址：`[http://localhost:8080](http://localhost:8080)`

### 方式2：命令行启动

```bash
# windows / mac
./gradlew bootRun
```

## 打包（生成jar包）

```bash
./gradlew bootJar
```

打包产物位置：`build/libs/*.jar` 运行jar包：

```bash
java -jar build/libs/demo-0.0.1-SNAPSHOT.jar
```

## 📝 接口示例

| 请求方式 | 接口地址   | 说明   |
| ---- | ------ | ---- |
| GET  | /hello | 测试接口 |

## ⚙️ 配置说明

- `application.yml`：服务端口、数据库、Redis等配置
- `build.gradle`：项目依赖、插件、版本配置
- `settings.gradle`：项目模块管理

## 🧪 单元测试

```bash
./gradlew test
```

## 📌 Git 提交规范

遵循 Conventional Commits 规范

- `feat`: 新增功能
- `fix`: bug修复
- `docs`: 文档修改
- `refactor`: 代码重构
- `style`: 格式调整，无逻辑改动
- `test`: 新增/修改测试代码
- `chore`: 构建、工具类修改

## ❗常见问题

1. Gradle依赖下载缓慢：配置阿里云镜像
2. IDEA项目依赖爆红：刷新Gradle项目，清除缓存重启IDEA
3. 端口占用：修改`application.yml`中的`server.port`

## 📄 许可证

MIT

# 搭建 SpringBoot 完整步骤（IDEA + Gradle）

> 环境：IDEA，Gradle（推荐使用 **Groovy DSL build.gradle**，也可选 Kotlin DSL），SpringBoot 3.x

## 一、新建项目

1. IDEA → `New Project`

2. 左侧选 **Spring Initializr**（Spring官方脚手架，最省事）
   
   - Service URL：默认 `[https://start.spring.io](https://start.spring.io)`
   - **Project**：Gradle - Groovy（不要选Maven！）
   - Language：Java
   - Spring Boot Version：选稳定版（比如3.2.x，不要选M快照版）
   - Group / Artifact：自定义
     - Group：`com.demo`
     - Artifact：`min-springboot`
   - Name：`min-springboot`
   - Description：随便写
   - Package name：`com.demo.min`（对应你之前启动类包名！）
   - Packaging：Jar
   - Java：选你本机JDK版本（JDK17 对应 SpringBoot3+）

3. **Dependencies 勾选依赖** ✅ **Spring Web**（必须！用来写Controller接口）
   
   > 其他暂时不用：MyBatis、MySQL等后面再加

4. 点击 `Create`，等待IDEA下载Gradle和SpringBoot依赖（首次联网比较慢）

> 如果你的IDEA没有Spring Initializr插件：
> 可以去 [https://start.spring.io/](https://start.spring.io/) 手动生成Gradle项目，解压后用IDEA打开

## 二、目录结构（自动生成，对照）

```plaintext
min-springboot
├── src
│   └── main
│       └── java
│           └── com
│               └── demo
│                   └── min
│                       ├── MinSpringbootApplication.java //启动类
│                       └── controller                     //自己新建包
│                           └── HelloController.java
│       └── resources
│           ├── static
│           ├── templates
│           └── application.properties
├── build.gradle        //Gradle核心配置文件
├── settings.gradle
```

## 三、build.gradle（Gradle Groovy DSL，自动生成参考）

```gradle
plugins {
    id 'org.springframework.boot' version '3.2.5'
    id 'io.spring.dependency-management' version '1.1.4'
    id 'java'
}

group = 'com.demo'
version = '0.0.1-SNAPSHOT'

java {
    sourceCompatibility = '17'
}

repositories {
    mavenCentral()
}

dependencies {
    // Spring Web 依赖（提供web、controller能力）
    implementation 'org.springframework.boot:spring-boot-starter-web'
    // 测试依赖
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
}

tasks.named('test') {
    useJUnitPlatform()
}
```

## 四、放入之前写好的代码

1. 在 `com.demo.min` 包下新建子包：`controller`
2. 在controller包新建 `HelloController.java`

```java
package com.demo.min.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello SpringBoot + Gradle";
    }
}
```

启动类 `MinSpringbootApplication.java`（自动生成）

```java
package com.demo.min;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MinSpringbootApplication {
    public static void main(String[] args) {
        SpringApplication.run(MinSpringbootApplication.class, args);
    }
}
```

## 五、运行项目

两种运行方式：

1. 直接右键启动类 `main()` → Run
2. IDEA右侧Gradle面板 → `Tasks` → `application` → `bootRun`（Gradle命令启动）

项目默认端口：8080
浏览器访问：`[http://localhost:8080/hello](http://localhost:8080/hello)` 页面输出：`Hello SpringBoot + Gradle`

## 六、常见问题

### 1. Gradle下载依赖很慢

修改 `settings.gradle`，配置阿里云镜像：

```gradle
pluginManagement {
    repositories {
        maven { url '[https://maven.aliyun.com/repository/public](https://maven.aliyun.com/repository/public)' }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven { url '[https://maven.aliyun.com/repository/public](https://maven.aliyun.com/repository/public)' }
        mavenCentral()
    }
}
rootProject.name = "min-springboot"
include("min-springboot")
```

改完后刷新Gradle（IDEA右上角刷新图标）

### 2. JDK版本报错

SpringBoot3.x **强制JDK17+** SpringBoot2.x 可用JDK8。如果想用JDK8，初始化时选择SpringBoot2.7.x版本。

### 3. 访问404排查

- 确认 `@RestController` 注解
- 确认Controller在启动类包的子包下
- 确认项目启动成功，端口8080没有被占用
- 确认地址写对 `/hello`

## 七、Gradle常用命令（在IDEA终端执行）

```bash
# 启动项目
./gradlew bootRun

# 打包jar包
./gradlew bootJar

# 清理编译产物
./gradlew clean
```

## 八、修改 SpringBoot 端口（Gradle项目）

### 方式1：application.properties（推荐，永久生效）

文件路径：`src/main/resources/application.properties`

```properties
# 修改服务端口，默认8080，改成8088
server.port=8088
```

保存，**重启项目**。
访问地址变为：`[http://localhost:8088/hello](http://localhost:8088/hello)`

> 可选：配置项目上下文路径（访问前缀）

```bash
# 加上后访问地址：[http://localhost:8088/api/hello](http://localhost:8088/api/hello)
#server.servlet.context-path=/api
```

### 方式2：application.yml 写法（如果你用yml）

`src/main/resources/application.yml`

```yml
server:
  port: 8088
```

### 方式3：启动命令临时指定（不修改代码，临时生效）

#### 1）IDEA运行配置

启动类的 Run/Debug Configurations → `VM options` 或者 `Program arguments` Program arguments 添加：

```xml
--server.port=8088
```

#### 2）Gradle bootRun 命令行启动

```bash
./gradlew bootRun --args='--server.port=8088'
```

#### 3）java -jar 打包后运行

```bash
java -jar build/libs/min-springboot-0.0.1-SNAPSHOT.jar --server.port=8088
```

### 方式4：代码硬编码（不推荐，仅了解）

```java
@SpringBootApplication
public class MinSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(MinSpringBootApplication.class);
        // 设置端口
        app.setDefaultProperties(Map.of("server.port", "8088"));
        app.run(args);
    }
}
```

### ✅ 验证是否生效

启动项目，看控制台日志，类似：

```plaintext
Tomcat started on port 8088 (http) with context path ''
```

### 常见问题

1. **端口被占用**：换一个端口，比如 8081、9090
2. 修改配置后**没有重启项目** → 端口不变
3. 同时配置多个地方，优先级：
   命令行参数 > 代码设置 > application.yml > application.properties

## 九、application.properties（SpringBoot 配置模板，放在 `src/main/resources`）

> properties 是键值对格式，`#` 代表注释。
> 改完配置后，**重启项目**才生效。

```properties
# ========== 服务器配置 ==========
# 修改端口号（默认8080，端口被占用就改这个，例如8081）
server.port=8080
# 项目访问前缀（可选，加了之后访问地址变成 [http://localhost:8080/api/hello](http://localhost:8080/api/hello)）
# server.servlet.context-path=/api

# ========== 日志配置 ==========
# 日志级别：root根日志；com.demo.min 你的包，只看自己代码日志
logging.level.root=info
logging.level.com.demo.min=debug

# 日志文件输出（可选，不配置默认只在控制台打印）
# logging.file.name=logs/springboot.log

# ========== 编码配置 ==========
server.servlet.encoding.charset=UTF-8
server.servlet.encoding.enabled=true
server.servlet.encoding.force=true
```

### 配套 yml 版本（可选，有些人更喜欢 yaml，文件名 `application.yml`）

```yml
server:
  port: 8080
  # servlet:
  #   context-path: /api

logging:
  level:
    root: info
    com.demo.min: debug
  # file:
  #   name: logs/springboot.log
```

### 简单测试端口修改

把 `server.port=8081`，重启项目，访问地址变成： `[http://localhost:8081/hello](http://localhost:8081/hello)`

### 小提示

- 如果同时存在 `application.properties` 和 `application.yml`，**properties优先级更高**
- 配置项写错，启动时会直接报错，看控制台日志即可排查

接下来可以试试：

1. 新增接口返回JSON对象；
2. 或者写一个全局异常处理器？

---

## 十、拓展：打包运行（Gradle）

1. 执行 `./gradlew bootJar`，打包完成后 jar 在 `build/libs/` 目录
2. 终端运行 jar：

```bash
java -jar build/libs/min-springboot-0.0.1-SNAPSHOT.jar
```

## 十一、SpringBoot + Gradle 单元测试完整指南

> 我们项目：Gradle + SpringBoot，依赖 `spring-boot-starter-test`，使用 JUnit 5（Jupiter，SpringBoot3 默认）
> 测试类放在：`src/test/java`，包结构和 `src/main/java` 保持一致

### 1、确认 build.gradle 测试依赖

新建 Spring Initializr 项目时默认已经引入，检查 `dependencies`：

```gradle
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-web'
    // SpringBoot 测试全家桶：JUnit5、AssertJ、Mockito、MockMvc
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
}

// 必须：使用 JUnit Platform 运行测试
tasks.named('test') {
    useJUnitPlatform()
}
```

> `testImplementation`：只在测试阶段生效，打包不会打进jar

### 2、两种常用测试方式

#### 1）@SpringBootTest：完整启动Spring容器（集成测试）

会加载整个Spring上下文，适合**接口/业务层集成测试**，速度稍慢。
测试类位置：`src/test/java/com/demo/min/HelloControllerTest.java`

```java
package com.demo.min;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

// 启动完整Spring上下文，随机端口
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerTest {

    // 内置http客户端，用来调用接口
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testHelloApi() {
        // GET请求访问 /hello
        String result = restTemplate.getForObject("/hello", String.class);
        // 断言结果等于预期字符串
        assert "Hello SpringBoot + Gradle".equals(result);
    }
}
```

#### 2）@WebMvcTest：切片测试（推荐Controller测试，更快）

**只加载Web层，不启动完整Spring容器**，专门测试Controller，速度快。

```java
package com.demo.min;

import com.demo.min.controller.HelloController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// 指定要测试的Controller
@WebMvcTest(HelloController.class)
public class HelloControllerMvcTest {

    // MockMvc：模拟HTTP请求，不用启动真实服务器
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testHello() throws Exception {
        mockMvc.perform(get("/hello"))          // GET /hello
                .andExpect(status().isOk())     // 预期HTTP状态200
                .andExpect(content().string("Hello SpringBoot + Gradle")); // 返回内容匹配
    }
}
```

### 3、在 IDEA 运行测试 & Gradle命令运行测试

#### ✅ IDEA方式（简单）

直接右键测试类 / 测试方法 → `Run 'xxxTest'`

#### ✅ Gradle命令（终端执行）

```bash
# 执行全部测试
./gradlew test

# 只执行单个测试类
./gradlew test --tests HelloControllerMvcTest

# 只执行单个测试方法
./gradlew test --tests HelloControllerMvcTest.testHello
```

> 测试报告：执行完 `./gradlew test` 后，网页报告路径 `build/reports/tests/test/index.html`，浏览器打开可以看通过率、失败详情

### 4、测试常用注解小结

| 注解                | 作用                                        | 场景                           |
| ----------------- | ----------------------------------------- | ---------------------------- |
| `@SpringBootTest` | 加载完整Spring容器                              | 集成测试，数据库、多Bean协作             |
| `@WebMvcTest`     | 仅Web层切片，MockMvc                           | Controller接口测试               |
| `@MockBean`       | 模拟Bean，替换真实对象                             | 给Controller mock service返回数据 |
| `@Test`           | JUnit5测试方法，必须`org.junit.jupiter.api.Test` | 标记测试方法                       |

### 5、简单演示：Mock Service（mock依赖）

如果Controller依赖Service，不想启动真实Service，可以用`@MockBean`：

```java
@WebMvcTest(HelloController.class)
public class HelloControllerMvcTest {
    @Autowired
    private MockMvc mockMvc;

    // 模拟Service
    @MockBean
    private HelloService helloService;

    @Test
    void testMock() throws Exception {
        // 定义mock返回值
        when(helloService.getMsg()).thenReturn("mock message");
        mockMvc.perform(get("/hello"))
                .andExpect(content().string("mock message"));
    }
```

### 6、常见踩坑

1. ❗ 包名：测试类包名最好和main代码一致，方便注入Bean
2. ❗ JUnit包不要导错：`org.junit.jupiter.api.Test`（JUnit5），不要导入`org.junit.Test`（JUnit4）
3. ❗ `./gradlew test` 会自动执行**所有测试**，有失败会终止构建
4. ❗ `@WebMvcTest` 不会加载 `@Service`、`@Repository`，需要手动mock

### 7、可选：跳过测试（打包时临时用，不推荐长期）

```bash
./gradlew bootJar -x test
```

`-x test`：跳过测试任务直接打包
