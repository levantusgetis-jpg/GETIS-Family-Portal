# GETIS 家族私人门户

Workers + D1 + R2 架构，面向 Android Chrome PWA。

## 当前线上环境
- Worker：`getis-family-portal`
- 访问地址：https://getis-family-portal.levantusgetis.workers.dev
- D1：`getis-family-db`（已创建并初始化）
- R2：待在 Cloudflare Dashboard 首次启用 R2 并创建 bucket `getis-family-files`

## 功能
- 首次启动创建族长账号（密码至少 14 位）
- 登录、会话 Cookie、CSRF 校验
- 族长创建管理员/成员账号
- 家族 JSON 数据存储于 D1
- 审计日志
- 档案文件上传下载（启用并绑定 R2 后可用）
- Android Chrome PWA 安装入口

## 部署
1. 在 Cloudflare Dashboard 打开 R2，按页面提示启用 R2。
2. 创建 bucket：`getis-family-files`。
3. Worker Settings → Bindings 添加 R2 bucket binding：变量名 `FILES`，bucket 选择 `getis-family-files`。
4. 代码更新后部署 Worker。GitHub 的 `wrangler.jsonc` 已绑定生产 D1 和 R2 bucket 名称。
5. Android Chrome 打开 Worker HTTPS 地址，菜单选择“安装应用”或“添加到主屏幕”。

## 本地开发
```sh
npm install
npm run dev
```

不要把家族真实资料、密码或密钥提交到 GitHub。仓库目前公开，建议在 GitHub Settings → General → Change repository visibility 改为 Private。项目尚未经过独立安全审计，正式使用前请配置备份与恢复流程。
