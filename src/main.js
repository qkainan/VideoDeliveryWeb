import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";

import * as ElementPlusIconsVue from "@element-plus/icons-vue";
import ElementPlus from "element-plus";
import "element-plus/dist/index.css";
import ViewUIPlus from "view-ui-plus";
import "view-ui-plus/dist/styles/viewuiplus.css";

import videoPlay from "vue3-video-play";
import "vue3-video-play/dist/style.css";

const app = createApp(App);
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
  app.component(key, component);
}
app
  .use(store)
  .use(router)
  .use(ElementPlus)
  .use(ViewUIPlus)
  .use(videoPlay)
  .mount("#app");
