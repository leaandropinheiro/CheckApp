import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import vuetify from "./plugins/vuetify";
import * as msal from "@azure/msal-browser";
import emitter from "@/plugins/eventBus";

const msalConfig = {
  auth: {
    clientId: process.env.VUE_APP_AZURE_CLIENT_ID,
    authority: `https://login.microsoftonline.com/${process.env.VUE_APP_AZURE_TENANT_ID}`,
    redirectUrl: process.env.VUE_APP_AZURE_REDIRECT_URL,
  },
};

const msalInstance = new msal.PublicClientApplication(msalConfig);

msalInstance.initialize().then(() => {
  const app = createApp(App);

  app.config.globalProperties.$msalInstance = msalInstance;
  app.config.globalProperties.$emitter = emitter;

  app.use(store).use(router).use(vuetify).mount("#app");
});
