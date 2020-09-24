/**
 * First we will load all of this project's JavaScript dependencies which
 * includes Vue and other libraries. It is a great starting point when
 * building robust, powerful web applications using Vue and Laravel.
 */

require('./bootstrap');

window.Vue = require('vue');

import VueRouter from 'vue-router';
import VueAxios from 'vue-axios';
import Axios from 'axios';

Vue.use(VueRouter,VueAxios,Axios); 

import App from './components/main.vue';
import Login from './components/Login.vue';  
import Upload from './components/upload.vue'; 
 
 const routes =[{
 	name : 'login',
 	path : '/',
 	component : Login
 	},
 	{
 	name : 'upload',
 	path : '/test',
 	component : Upload
 	}];

const router = new VueRouter({ mode: 'history', routes: routes });
new Vue(Vue.util.extend({ router }, App)).$mount("#app");
