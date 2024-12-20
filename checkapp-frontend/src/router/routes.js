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
    path: "/Clinica",
    name: "Clinica",
    meta: {
      title: "Detalhes da Clinica",
      requiresAuth: true,
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
  {
    path: "/nova-unidade",
    name: "Nova unidade",
    meta: {
      title: "Nova unidade",
      requiresAuth: true,
    },
    component: () => import("@/views/unit/NewUnit.vue"),
  },
  {
    path: "/novo-exame",
    name: "Novo exame",
    meta: {
      title: "Novo exame",
      requiresAuth: true,
    },
    component: () => import("@/views/exam/NewExam.vue"),
  },
  {
    path: "/meus-agendamentos",
    name: "Meus agendamentos",
    meta: {
      title: "Meus agendamentos",
      requiresAuth: true,
    },
    component: () => import("@/views/schedule/VSchedule.vue"),
  },
];
