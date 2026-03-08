# double-ai-agent

一个基于 **Spring Boot 3 + Spring AI + Spring AI Alibaba** 的 Java AI Agent 项目骨架。

当前仓库处于**初始化阶段**：已经完成父级 Maven 工程、统一依赖版本管理和常用开发库配置，但**尚未引入具体业务模块与源码实现
**。

## 项目定位

`double-ai-agent` 旨在作为多 Agent / AI Agent 类应用的基础工程，用于后续承载：

- 大模型接入与统一配置
- Agent 编排与调用链路
- DTO / DO 映射能力
- 通用工具类与基础设施封装
- 面向 Spring 生态的服务化开发

基于当前仓库内容，可以明确它是一个**父级聚合 Maven 工程**，主要职责是统一管理版本、依赖和编译配置，而不是一个已经可直接启动运行的应用。

## 当前状态

目前已完成：

- 基于 `Spring Boot 3.3.4` 的父级工程配置
- 引入 `Spring AI` 与 `Spring AI Alibaba` 的 BOM 管理
- 预置 `Lombok`、`MapStruct`、`Hutool` 等常用依赖
- 配置 `maven-compiler-plugin` 注解处理器，支持 `Lombok` 与 `MapStruct`
- 配置常见 IDE / 构建产物忽略规则
- 添加 `MIT License`

目前尚未包含：

- 子模块定义
- `src/main/java` 业务代码
- `src/test/java` 测试代码
- `application.yml` / `application.properties`
- 可直接运行的启动类

## 技术栈

根据根目录 `pom.xml`，当前已确定的技术栈如下：

- Java 生态：Maven
- 父级框架：Spring Boot `3.3.4`
- AI 框架：Spring AI `1.0.3`
- 阿里云 AI 集成：Spring AI Alibaba `1.0.0.4`
- 注解工具：Lombok `1.18.30`
- 对象映射：MapStruct `1.6.2`
- 工具库：Hutool `5.8.23`
- 测试依赖：JUnit `3.8.1`

## 项目结构

当前仓库结构非常简洁：

```text
double-ai-agent/
├── LICENSE
├── pom.xml
└── README.md
```

其中：

- `pom.xml`：父级 Maven 配置，统一版本与依赖管理
- `LICENSE`：MIT 开源许可证
- `README.md`：项目说明文档

## pom.xml 设计说明

当前根工程采用：

- `packaging` 为 `pom`
- 适合作为后续多模块项目的聚合根
- 将公共依赖集中管理，避免子模块重复声明版本
- 将注解处理器统一放在编译插件中，降低模块配置成本

这符合以下工程实践：

- **KISS**：先构建稳定骨架，再逐步引入业务模块
- **DRY**：公共依赖与版本在父工程集中维护
- **YAGNI**：尚未创建无明确需求的模块与模板代码
- **SOLID**：父工程仅承担构建与依赖管理职责，职责单一

## 本地开发

### 环境要求

- JDK 17 或以上（与 Spring Boot 3 生态保持一致）
- Maven 3.9+（推荐）

### 校验项目

当前项目还不是可运行应用，但可以先做 Maven 配置校验：

```bash
mvn validate
```

如果后续引入子模块，也可以继续使用：

```bash
mvn clean install
```

## 后续建议演进方向

如果你准备把这个仓库继续落地为可运行项目，建议按以下顺序扩展：

1. 新增业务子模块，例如：
    - `double-ai-agent-web`
    - `double-ai-agent-core`
    - `double-ai-agent-infra`
2. 在子模块中引入 Spring Boot 启动类
3. 添加模型配置文件，如 `application.yml`
4. 封装统一的模型调用层与 Agent 抽象
5. 补充单元测试、集成测试与接口文档

一个常见的多模块拆分示例：

```text
double-ai-agent/
├── pom.xml
├── double-ai-agent-web/
├── double-ai-agent-core/
└── double-ai-agent-infra/
```

## 许可证

本项目采用 `MIT License`，详见 `LICENSE`。
