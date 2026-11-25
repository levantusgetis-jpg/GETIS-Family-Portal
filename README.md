# GETIS 家族私人门户

Cloudflare Workers + D1 + R2 部署版，适用于 Android Chrome 安装为 PWA。

## 部署前
1. 在 Cloudflare 创建 D1 数据库 `getis-family-db`，将真实 Database ID 写入 `wrangler.jsonc`，替换 `REPLACE_WITH_D1_DATABASE_ID`。
2. 在 D1 SQL Console 执行 `schema.sql`。
3. 创建 R2 bucket：`getis-family-files`。
4. Worker → Settings → Variables and Secrets 添加 Secret：`SESSION_SECRET`（至少 48 个随机字符）。
5. 在 Cloudflare Workers Builds 连接本仓库，根目录保持仓库根目录，分支选 `main`。

## 本地
```sh
npm install
npm run dev
```

部署后用 Android Chrome 打开 HTTPS Worker 域名，选择“安装应用”。

不要将密钥、家族真实资料或用户文件提交到 GitHub。项目尚未经过独立安全审计，正式使用前请做好 D1/R2 备份。
