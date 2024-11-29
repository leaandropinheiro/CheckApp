import { createRouter, createWebHashHistory } from "vue-router";
import routes from "./routes";
import store from "@/store";

const router = createRouter({
  history: createWebHashHistory(),
  routes,
});

router.beforeEach((to, from, next) => {
  console.log(
    "Navigation guard - Auth state:",
    store.getters["auth/isAuthenticated"]
  );

  if (to.meta.requiresAuth && !store.getters["auth/isAuthenticated"]) {
    next("/login");
  } else {
    next();
  }
});

export default router;
