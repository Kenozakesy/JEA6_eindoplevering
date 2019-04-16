import Vue from 'vue';

require('./bootstrap');

window.Vue = require('vue');

Vue.component('login', require('./components/login.vue').default);

const app = new Vue({
    el: '#app'
});