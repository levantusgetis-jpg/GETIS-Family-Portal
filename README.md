# GETIS 家族私人门户

Workers + D1 + R2 架构，面向 Android Chrome PWA。

## 当前线上环境
- Worker：`getis-family-portal`
- 访问地址：https://getis-family-portal.levantusgetis.workers.dev
- D1：`getis-family-db`（已创建并初始化）
- 档案文件：小文件保存在 D1（单文件最大 500KB），无需启用 R2。

## 功能
- 首次启动创建族长账号（密码至少 14 位）
- 登录、会话 Cookie、CSRF 校验
- 族长创建管理员/成员账号
- 家族 JSON 数据存储于 D1
- 审计日志
- 小档案文件上传下载（D1 保存，单文件最大 500KB）
- Android Chrome PWA 安装入口

## 部署
Worker 与 D1 已配置。无需开通 R2，也无需绑定银行卡。

## 本地开发
```sh
npm install
npm run dev
```

不要把家族真实资料、密码或密钥提交到 GitHub。仓库目前公开，建议在 GitHub Settings → General → Change repository visibility 改为 Private。项目尚未经过独立安全审计，正式使用前请配置备份与恢复流程。
