// src/router/index.js
import { createRouter, createWebHistory } from 'vue-router';
import PostList from '../components/PostList.vue';
import PostDetail from '../components/PostDetail.vue';

const routes = [
  {
    path: '/',
    name: 'post-list',
    component: PostList,
  },
  {
    path: '/post/:postId',
    name: 'post-detail',
    component: PostDetail,
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
