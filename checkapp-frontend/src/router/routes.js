export default [
  {
    path: "/login",
    name: "login",
    meta: {
      title: "Login",
      requiresAuth: false,
    },
    component: () => import("@/views/auth/VLogin.vue"),
  },
  {
    path: "/",
    name: "home",
    meta: {
      title: "Home",
      requiresAuth: true,
    },
    component: () => import("@/views/home/VHome.vue"),
  },
  {
    path: "/clinica",
    name: "Clinica",
    meta: {
      requiresAuth: true,
      title: "Detalhes da Clinica",
    },
    component: () => import("@/views/clinic/VClinic.vue"),
  },
  {
    path: "/checkout",
    name: "Checkout",
    meta: {
      title: "Checkout",
      requiresAuth: true,
    },
    component: () => import("@/views/checkout/VCheckout.vue"),
  },
];
