export default [
  {
    path: "/",
    name: "home",
    meta: {
      title: "Home",
    },
    component: () => import(/* webpackChunkName: "home" */ "@/views/home/VHome.vue"),
  },
  {
    path: "/clinica",
    name: "Clinica",
    meta: {
      title: "Detalhes da CLinica",
    },
    component: () =>
      import(/* webpackChunkName: "home" */ "@/views/clinic/VClinic.vue"),
  },
];
