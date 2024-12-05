import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import vuetify from "./plugins/vuetify";
import * as msal from "@azure/msal-browser";
import emitter from "@/plugins/eventBus";
import VSnacks from 'vue-snacks';

const msalConfig = {
  auth: {
    clientId: process.env.VUE_APP_AZURE_CLIENT_ID,
    authority: `https://login.microsoftonline.com/${process.env.VUE_APP_AZURE_TENANT_ID}`,
    redirectUri: window.location.origin,
    navigateToLoginRequestUrl: true
  },
  cache: {
    cacheLocation: "sessionStorage"
  }
};


const msalInstance = new msal.PublicClientApplication(msalConfig);

msalInstance.initialize().then(() => {
  const app = createApp(App);

  app.config.globalProperties.$msalInstance = msalInstance;
  app.config.globalProperties.$emitter = emitter;

  app.use(store).use(router).use(vuetify).use(VSnacks).mount("#app");
});
