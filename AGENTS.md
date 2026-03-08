# Repository Guidelines

## Project Structure & Module Organization

This repository is currently a **parent Maven project**. The root `pom.xml` centralizes dependency versions, annotation
processor setup, and shared build conventions. At the moment, the repository contains only root-level project files such
as `pom.xml`, `README.md`, and `LICENSE`.

When feature modules are added, keep a clear multi-module layout:

- `double-ai-agent-web/` – Spring Boot entrypoints and HTTP APIs
- `double-ai-agent-core/` – agent orchestration and domain logic
- `double-ai-agent-infra/` – external integrations and persistence
- `src/main/java` and `src/test/java` inside each module

Use lowercase package names under `top.wjstar` and keep module names prefixed with `double-ai-agent-`.

## Build, Test, and Development Commands

- `mvn validate` — verifies the parent build configuration and dependency management
- `mvn test` — runs module tests once test sources are added
- `mvn clean install` — performs a full clean build and installs artifacts locally
- `mvn -pl "module-name" test` — runs tests for a single module after modules exist

Run commands from the repository root unless you are working inside a specific module.

## Coding Style & Naming Conventions

Use **Java 17+** conventions and keep code simple and explicit.

- Indentation: 4 spaces, no tabs
- Class names: `UpperCamelCase`
- Methods and fields: `lowerCamelCase`
- Constants: `UPPER_SNAKE_CASE`
- Packages: lowercase, dot-separated

Prefer Lombok only where it reduces clear boilerplate. Use MapStruct for DTO mappings instead of handwritten repetitive
converters. Keep classes focused on one responsibility.

## Testing Guidelines

Place tests under `src/test/java` in the corresponding module. Name test classes `*Test` and mirror the package
structure of production code. Add focused unit tests for every new service, mapper, or utility with meaningful
assertions.

Before opening a PR, run `mvn test` or the narrowest relevant module command.

## Commit & Pull Request Guidelines

Follow the existing **Conventional Commits** pattern seen in history, for example:

- `chore(config): add parent pom setup`
- `feat(core): add agent executor`
- `fix(web): handle empty prompt`

PRs should include:

- a short summary of the change
- impacted modules or paths
- test evidence (`mvn test`, module-specific test output, or manual verification)
- linked issue, if applicable

## Security & Configuration Tips

Do not commit secrets, API keys, or environment-specific config. Once runtime modules are added, keep local overrides in
untracked files such as `application-local.yml` or use environment variables.
