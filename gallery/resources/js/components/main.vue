<style> 
</style>
<template>

	<div class="wrapper">
        <!-- <app-header v-if="isAuth" />  -->
        <app-header v-if="this.$route.name!='login'" /> 
    <div class='container'>
        <router-view></router-view>
    </div>
   <!--  <app-footer /> -->
    <!-- <app-footer v-if="isAuth" /> -->
    </div>

</template>
 
<script>
    import { mapState, mapGetters } from 'vuex'
    import Header from './Header.vue'
    import Footer from './Footer.vue'   
    export default {
        computed: {
            ...mapState(['token']),
            ...mapGetters(['isAuth']), 
            currentRouteName() {
        return this.$route.name;
    }


        },
        components: {
            'app-header': Header,
            'app-footer': Footer
        }
    }
</script>