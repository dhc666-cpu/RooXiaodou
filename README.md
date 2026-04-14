


          
# 袋鼠小兜（医疗版）

一个基于 Java Spring Boot 和 Vue 的医疗 AI 对话助手，使用 LangChain4j 集成大语言模型，提供智能医疗问答服务。


## 📋 项目概述

**袋鼠小兜**是一个专注于医疗领域的 AI 对话助手，能够：
- 回答医疗相关问题
- 提供健康咨询和建议
- 支持流式对话，实时显示回复
- 保存对话历史，提供连续对话体验
- 集成了工具调用能力，可执行特定医疗相关任务


## 🛠 技术栈

### 后端
- **Java 17**
- **Spring Boot 3.2.6**
- **LangChain4j 1.0.0-beta3** - 大语言模型集成框架
- **MongoDB** - 存储对话记忆
- **MySQL** - 存储业务数据
- **Knife4j** - API 文档

### 前端
- **Vue 3**
- **Element Plus** - UI 组件库
- **Axios** - HTTP 客户端
- **Vite** - 构建工具


## 📁 项目结构

```
java-ai-langchain4j/
├── src/
│   ├── main/
│   │   ├── java/com/dhc/java/ai/langchain4j/
│   │   │   ├── assistant/       # AI 助手实现
│   │   │   ├── bean/             # 数据模型
│   │   │   ├── config/           # 配置类
│   │   │   ├── controller/       # 控制器
│   │   │   ├── entity/           # 实体类
│   │   │   ├── mapper/           # MyBatis 映射
│   │   │   ├── service/          # 业务逻辑
│   │   │   ├── store/            # 存储实现
│   │   │   ├── tools/            # 工具类
│   │   │   └── RooXiaodouApp.java # 应用入口
│   │   └── resources/
│   │       ├── mapper/           # MyBatis XML 映射
│   │       ├── static/           # 前端构建产物
│   │       ├── application.properties # 应用配置
│   │       └── xiaodou-prompt-template.txt # 系统提示模板
├── frontend/                      # 前端项目
│   ├── src/
│   │   ├── components/            # Vue 组件
│   │   ├── assets/               # 静态资源
│   │   ├── main.js               # 前端入口
│   │   └── App.vue               # 根组件
│   ├── index.html                # HTML 模板
│   ├── vite.config.js            # Vite 配置
│   └── package.json              # 前端依赖
├── pom.xml                       # Maven 配置
└── README.md                     # 项目说明
```


## 🚀 快速开始

### 环境要求
- **Java 17** 或以上
- **Maven 3.6** 或以上
- **Node.js 16** 或以上
- **MongoDB** 服务
- **MySQL** 服务


### 安装步骤

1. **克隆仓库**
   ```bash
   git clone https://github.com/your-username/RooXiaodou.git
   cd RooXiaodou
   ```

2. **配置数据库**
   - 修改 `src/main/resources/application.properties` 文件，配置 MongoDB 和 MySQL 连接信息：
     ```properties
     # MongoDB 配置
     spring.data.mongodb.uri=mongodb://localhost:27017/xiaodou

     # MySQL 配置
     spring.datasource.url=jdbc:mysql://localhost:3306/xiaodou?useSSL=false&serverTimezone=UTC
     spring.datasource.username=root
     spring.datasource.password=your-password
     ```

3. **安装前端依赖**
   ```bash
   cd frontend
   npm install
   ```


### 构建与运行

1. **构建前端**
   ```bash
   # 在 frontend 目录下执行
   npm run build
   ```
   前端构建产物会输出到 `src/main/resources/static` 目录。

2. **构建后端**
   ```bash
   # 在项目根目录执行
   mvn clean package
   ```

3. **运行应用**
   ```bash
   # 方式 1：直接运行
   mvn spring-boot:run

   # 方式 2：运行打包后的 JAR 文件
   java -jar target/java-ai-langchain4j-1.0-SNAPSHOT.jar
   ```

4. **访问应用**
   打开浏览器，访问 `http://localhost:8080/` 即可使用袋鼠小兜。


## 🔍 API 接口

### 对话接口
- **URL**: `/xiaodou/chat`
- **方法**: `POST`
- **请求体**:
  ```json
  {
    "memoryId": 123456, // 对话 ID
    "message": "你好"    // 用户问题
  }
  ```
- **响应**: 流式文本响应 (`text/stream;charset=utf-8`)


## 📦 部署指南

### 本地部署
按照 **快速开始** 步骤执行即可。

### 服务器部署
1. **构建项目**
   ```bash
   mvn clean package
   ```

2. **上传 JAR 文件**
   将 `target/java-ai-langchain4j-1.0-SNAPSHOT.jar` 上传到服务器。

3. **安装 Java**
   确保服务器安装了 Java 17 或以上版本：
   ```bash
   # Ubuntu 示例
   apt update && apt install openjdk-17-jdk -y
   ```

4. **运行服务**
   ```bash
   nohup java -jar java-ai-langchain4j-1.0-SNAPSHOT.jar > app.log 2>&1 &
   ```

5. **配置防火墙**
   开放 8080 端口：
   ```bash
   ufw allow 8080/tcp
   ```

6. **访问地址**
   通过服务器公网 IP 访问：`http://服务器IP:8080/`


## 📝 配置说明

### 大语言模型配置
修改 `application.properties` 文件，配置大语言模型参数：
```properties
# 大语言模型配置（示例：使用阿里云百炼）
langchain4j.dashscope.api-key=your-api-key
langchain4j.dashscope.model=qwen-plus
```


## 🤝 贡献

欢迎提交 Issue 和 Pull Request 来改进项目！


## 📄 许可证

本项目采用 MIT 许可证 - 详见 [LICENSE](LICENSE) 文件。


## 🙏 致谢

- **LangChain4j** - 提供大语言模型集成能力
- **Spring Boot** - 后端框架
- **Vue 3** - 前端框架
- **Element Plus** - UI 组件库


---

**袋鼠小兜** - 您的智能医疗助手 🤖
        
