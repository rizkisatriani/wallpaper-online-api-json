/**
 * First we will load all of this project's JavaScript dependencies which
 * includes Vue and other libraries. It is a great starting point when
 * building robust, powerful web applications using Vue and Laravel.
 */

require('./bootstrap'); 
window.Vue = require('vue'); 
import App from './components/main.vue'; 
import router from './router.js';
import store from './store.js';
import vSelect from "vue-select";
Vue.component("v-select", vSelect);
 
/* const routes =[{
 	name : 'login',
 	path : '/',
 	component : Login
 	},
 	{
 	name : 'upload',
 	path : '/test',
 	component : Upload
 	}];*/
 

/*const router = new VueRouter({
 mode: 'history', 
 routes: routes });*/ 
new Vue({
    el: '#app',
    router,
    store,
    components: {
        App
    }
})
//new Vue(Vue.util.extend({ router }, App)).$mount("#app");
