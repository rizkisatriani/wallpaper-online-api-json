<template> 
    <!-- disini saya menggunakan bootstrap untuk design tabel nya. secara default bootstrap sudah di include di file welcome.blade.php jadi saya tidak perlu lagi untuk import file nya -->
    <div class="row">
      <div class="col-sm-12 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5">
          <div class="card-body">
            <h5 class="card-title text-center">Login</h5> 
            <form class="form-signin">
              <div class="form-label-group"> 
                <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
              </div>

              <div class="form-label-group">
                <label for="inputPassword"></label>
                <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
              </div>

              <hr class="my-4"> 
              <div class="custom-control custom-checkbox mb-3">
                <input type="checkbox" class="custom-control-input" id="customCheck1">
                <label class="custom-control-label" for="customCheck1">Remember password</label>
              </div>
              <button class="btn btn-lg btn-primary btn-block text-uppercase"  onclick="pop_up()" type="submit">Sign in</button>
            </form>
          </div>
        </div>
      </div>
    </div> 
</template>

<!-- script js -->
<!--  <script>
export default {
  data() {
    return {
      // variable array yang akan menampung hasil fetch dari api
      user: []
    };
  },
  created() {
    this.loadData();
  },
  methods: {
   loadData() {
      // fetch data dari api menggunakan axios
      axios.get("http://localhost:8000/api/users").then(response => {
        // mengirim data hasil fetch ke varibale array persons
      this.user = response.data; 
      console.log(response.data);
      });
    },
    deleteData(id) {
      // delete data
      axios.delete("http://localhost:8000/api/person/" + id).then(response => {
        this.loadData();
      });
    }
  }
};

 function pop_up(){ 
    alert('testing');
  }
</script> -->