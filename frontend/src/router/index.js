import {createRouter, createWebHistory} from 'vue-router';
import HomeView from '@/views/HomeView'
import AboutView from '@/views/AboutView'
import PostView from '@/views/PostView'
import RestaurantView from '@/views/RestaurantView'
import MenuVuew from '@/views/MenuView'

const routes = [
    {
        path: '/',
        component: HomeView
    },
    {
        path: '/about',
        component: AboutView
    },
    {
        path: '/post',
        component: PostView
    },
    {
        path: '/restaurant',
        component: RestaurantView
    },
    {
        path: '/menu',
        component: MenuVuew
    },
    
];


const router = createRouter({
    history: createWebHistory(),
    mode: 'history',
    routes,
})

export default router;

