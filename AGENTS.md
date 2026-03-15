# AGENTS.md

This file provides guidance to `init-architect` (init-architect.ai/code) when working with code in this repository.

## Build Commands

```bash
mvn clean install                 # Full build, install all modules to local repo
mvn -pl ai-transfer test          # Run tests for a single module
mvn -pl ai-transfer spring-boot:run  # Start the ai-transfer application (port 8876)
mvn validate                      # Verify parent build configuration
```

Requires JDK 17+ and Maven 3.9+.

## Architecture

Multi-module Maven project (`top.wjstar:double-ai-agent`) for AI Agent applications.

```
double-ai-agent/                  (parent POM - version/dependency management)
├── ai-common/                    (shared utilities, no Spring Boot dependency)
│   └── R<T>                      (unified API response wrapper, top.wjstar.common.domain.vo)
└── ai-transfer/                  (Spring Boot application, port 8876)
    └── TransferApp.java          (@MapperScan on top.wjstar.transfer.mapper)
```

### ai-transfer Module Layers

Package: `top.wjstar.transfer`

```
model/         → MyBatis Plus entities (@TableName, @TableId AUTO)
mapper/        → MyBatis Plus mappers (extend BaseMapper<T>)
service/base/  → Service implementations (extend ServiceImpl, annotated @Service)
service/base/impl/ → Service interfaces (extend IService<T>)
```

**Note**: The interface/impl package naming is inverted from typical convention -- interfaces are in `impl/`,
implementations are in the parent `base/` package.

MyBatis XML mappers: `src/main/resources/mapperxml/`

### Database

MySQL database `ai_transfer`, configured in `ai-transfer/src/main/resources/application.yml`. Six `bb_` prefixed tables:
product, warehouse, inventory, sales_record, transfer_order, transfer_order_item.

### Key Tech Stack Versions

Spring Boot 3.3.4 | Spring AI 1.0.3 | Spring AI Alibaba 1.0.0.4 | MyBatis Plus 3.5.14 | MapStruct 1.6.2 | Hutool 5.8.23

Lombok and MapStruct annotation processors are configured in the parent `maven-compiler-plugin`.

## Conventions

- **Commit style**: Conventional Commits with Chinese descriptions (e.g., `feat(common): 新增项目统一返回结果实体R类`)
- **Entities**: Use `@Data`, `@TableName`, `@TableId(type = IdType.AUTO)`, `@TableField` for column mapping
- **Responses**: Always use `R<T>` from `ai-common` for API returns
- **Local config overrides**: Use `application-local.yml` (untracked), never commit secrets
- **Unused `com.*` classes**: Ignore `com/domain/` and `com/mapper/` packages under `ai-transfer` -- they are
  legacy/auto-generated. Only `top.wjstar.*` packages are active.
