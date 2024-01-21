import {createRouter, createWebHistory} from 'vue-router';
import HomeView from '../views/HomeView'
import AboutView from '../views/AboutView'

const routes = [
    {
        path: '/',
        component: HomeView
    },
    {
        path: '/about',
        component: AboutView
    },
];


const router = createRouter({
    history: createWebHistory(),
    mode: 'history',
    routes,
})

export default router;

