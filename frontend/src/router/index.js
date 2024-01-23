import {createRouter, createWebHistory} from 'vue-router';
import HomeView from '@/views/HomeView'
import AboutView from '@/views/AboutView'
import PostView from '@/views/PostView'

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
    }
];


const router = createRouter({
    history: createWebHistory(),
    mode: 'history',
    routes,
})

export default router;

