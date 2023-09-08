import { createApp } from 'vue';
import App from './App.vue';
import router from './router';
import store from './store';
import AntDesignVue from 'ant-design-vue';
import AOS from 'aos';
import 'aos/dist/aos.css';
import axios from 'axios';

//import css files
import '@/assets/css/bootstrap.min.css';
import '@/assets/css/all.css';
import '@/assets/css/brands.css';
import '@/assets/css/solid.css';
import '@/assets/css/main.css';

//import js files
import '@/assets/js/brands.js';
import '@/assets/js/solid.js';
import '@/assets/js/main.js';

axios.defaults.baseURL = 'https://www.hubeinxunited.com:8080';
// axios.defaults.baseURL = 'https://123.249.12.92:8080';
// axios.defaults.baseURL = 'https://localhost:8080';

const app = createApp(App);

app.use(router);
app.use(store);
app.use(AntDesignVue);
app.use(AOS.init());

app.mount('#app');
