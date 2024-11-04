import { routes as auth } from '../views/home'
import { routes as home } from '../modules/auth'

export default [
  ...auth,
  ...home
]
