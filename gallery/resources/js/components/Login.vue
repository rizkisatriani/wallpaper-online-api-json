<template> 
    <!-- disini saya menggunakan bootstrap untuk design tabel nya. secara default bootstrap sudah di include di file welcome.blade.php jadi saya tidak perlu lagi untuk import file nya -->
    <div class="row" style="padding: 200px 0px  0px  350px;">
      <div class="col-sm-12 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5">
          <div class="card-body">
            <h5 class="card-title text-center">Login</h5> 
            <form class="form-signin">
              <div class="form-label-group"> 
                <input type="email" id="inputEmail" class="form-control" placeholder="Email address" v-model="data.email" required autofocus>
              </div>

              <div class="form-label-group">
                <label for="inputPassword"></label>
                <input type="password" id="inputPassword" class="form-control" placeholder="Password" v-model="data.password" required>
              </div>

              <hr class="my-4"> 
              <div class="custom-control custom-checkbox mb-3">
                <input type="checkbox" class="custom-control-input" id="customCheck1"  v-model="data.remember_me">
                <label class="custom-control-label" for="customCheck1">Remember password</label>
              </div>
              <button class="btn btn-lg btn-primary btn-block text-uppercase" @click.prevent="postLogin"  type="submit">Sign in</button>
            </form>
          </div>
        </div>
      </div>
    </div> 
</template>

<!-- script js -->
 <script>
 	import { mapActions, mapMutations, mapGetters, mapState } from 'vuex';
export default {
  data() {
   return {
            data: {
                email: '',
                password: '',
                remember_me: false
            }
        }
  },
  created() { 
    this.no_login=false;
    if (this.isAuth) {   
            //MAKA DI-DIRECT KE ROUTE DENGAN NAME home
            this.$router.push({ name: 'home' })
        }
  }, 
  computed: {
        ...mapGetters(['isAuth']), //MENGAMBIL GETTERS isAuth DARI VUEX
      	...mapState(['errors'])
    },
  methods: {
    ...mapActions('auth', ['submit']), //MENGISIASI FUNGSI submit() DARI VUEX AGAR DAPAT DIGUNAKAN PADA COMPONENT TERKAIT. submit() BERASAL DARI ACTION PADA FOLDER STORES/auth.js
        ...mapMutations(['CLEAR_ERRORS']),

           postLogin() {
            //DIMANA TOMBOL INI AKAN MENJALANKAN FUNGSI submit() DENGAN MENGIRIMKAN DATA YANG DIBUTUHKAN
            console.log(this.data.remember_me);
            //this.submit(this.data).then(() => {
                //KEMUDIAN DI CEK VALUE DARI isAuth
                //APABILA BERNILAI TRUE
                 console.log(this.data.remember_me);
              //  if (this.isAuth) {
                    this.CLEAR_ERRORS()
                    this.no_login=true;
                    //MAKA AKAN DI-DIRECT KE ROUTE DENGAN NAME home
                    this.$router.push({ name: 'home' })
                //}
           // })
        }
    } 
};
 
</script>