import { createApp } from "vue"
import App from "./App.vue"

const app = createApp(App)
import { router } from "./router/index"
import ElementPlus from "element-plus"
import "element-plus/dist/index.css"
import "./style/index.scss"
import { createPinia } from "pinia"
import piniaPluginPersistedstate from "pinia-plugin-persistedstate"

import zhCn from "element-plus/dist/locale/zh-cn.mjs"

const pinia = createPinia()
pinia.use(piniaPluginPersistedstate)
import * as ElementPlusIconsVue from "@element-plus/icons-vue"
// 全局挂载和注册 element-plus 的所有 icon
app.config.globalProperties.$icons = []
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
  app.config.globalProperties.$icons.push(key)
  app.component(key, component)
}

app
  .use(ElementPlus, {
    locale: zhCn,
  })
  .use(router)
  .use(pinia)
  .mount("#app")
