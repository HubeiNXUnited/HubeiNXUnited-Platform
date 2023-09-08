import { createRouter, createWebHashHistory } from 'vue-router';
import HomePage from '@/views/HomePage.vue';
import AboutUs from '@/views/AboutUs.vue';
import ResourceCenter from '@/views/ResourceCenter.vue';
import FreshmanHub from '@/views/FreshmanHub.vue';

const routes: any = [
	{ path: '/', component: HomePage, name: 'HomePage' },
	{ path: '/AboutUs', component: AboutUs, name: 'AboutUs' },
	{ path: '/ResourceCenter', component: ResourceCenter, name: 'ResourceCenter' },
	{ path: '/FreshmanHub', component: FreshmanHub, name: 'FreshmanHub' },
];

const router = createRouter({
	history: createWebHashHistory(),
	routes,
});

export default router;
