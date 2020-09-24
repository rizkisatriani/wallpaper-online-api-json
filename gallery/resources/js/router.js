/**
 * First we will load all of this project's JavaScript dependencies which
 * includes Vue and other libraries. It is a great starting point when
 * building robust, powerful web applications using Vue and Laravel.
 */
 
import Vue from 'vue'
import Router from 'vue-router' 

Vue.use(Router)
 
import Login from './components/Login.vue';  
import Upload from './components/home.vue';  
import Gallery from './components/Gallery.vue'; 
import InputApp from './components/InputApp.vue'; 
import store from './store.js'
 
const router = new Router({ 
    mode:'history',
    routes:[{
 	path : '/',
    name : 'login',
 	component : Login
 	},
    {
    path : '/gallery.php',
    name : 'gallery',
    component : Gallery 
    },
    {
    path : '/add-app.php',
    name : 'addapp',
    component : InputApp 
    },
 	{
 	name : 'home',
 	path : '/index.php',
 	component : Upload,
    meta: { requiresAuth: true }
 	}]});

/*router.beforeEach((to, from, next) => {
    if (to.matched.some(record => record.meta.requiresAuth)) {
        let auth = store.getters.isAuth

        if (!auth) {
            next({ name:'login'})
        } else {
            next()
        }
    } else {
        next()
    }
});*/

 export default router
