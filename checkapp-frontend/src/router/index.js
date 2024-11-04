import { createRouter, createWebHashHistory } from 'vue-router'
import routes from './routes'

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

router.beforeEach((to, from, next) => {
  if (to.meta.title) {
    document.title = `CheckApp - ${to.meta.title}`
  } else {
    document.title = 'Default Title'
  }
  next()
})

export default router
