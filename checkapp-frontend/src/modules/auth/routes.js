export default [
  {
    name: 'login',
    path: '/login',
    meta: {
      title: 'Login'
    },
    component: () => import(/* webpackChunkName: "login" */ './pages/VLogin')
  }
]
