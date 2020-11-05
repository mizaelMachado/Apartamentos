import Vue from 'vue'
import VueRouter from 'vue-router'
import Busca from '../views/Busca.vue'
import Home from '../views/Home.vue'
Vue.use(VueRouter)

const routes = [
 
  {
    path: '/listar',
    name: 'listar',
    component: Busca
    },
 
{
    path: '/*',
    name: 'Home',
    component: Home
}
]

const router = new VueRouter({
  routes
})

export default router
