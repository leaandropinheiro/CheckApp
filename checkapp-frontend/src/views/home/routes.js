export default [
  {
    path: "/",
    name: "home",
    meta: {
      title: "Home",
    },
    component: () => import(/* webpackChunkName: "home" */ "./VHome.vue"),
  },
  {
    path: "/resultados",
    name: "Resultados",
    meta: {
      title: "Resultados da busca",
    },
    component: () =>
      import(/* webpackChunkName: "home" */ "./VSearchResult.vue"),
  },
];
