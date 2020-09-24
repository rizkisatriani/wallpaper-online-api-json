 

<template>  
  <div class="container"> 
    <div class="banner-home">
      <h2 class="banner">Mulai Tambah Aplikasi</h2>
      <h3 class="banner">Pastikan sudah riset terlebih dahulu sebelum upload aplikasimu</h3>
      <div v-on:click="GotoAdd()" class="btn create">CREATE</div>
  </div>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br> 
  <br> 
  <br> 
  <br> 
  <br> 
  <br> 
  <br> 
  <div class="content"> 
          <h2  >Aplikasi Gallery</h2>
        <h3  >Daftar aplikasi yang terhubung ke api-gallery</h3>
      <div class="row "> 
           <div v-for="data in data_apps"  class="col-lg-4">
                <div class="card" > 
                    <div class="line"></div> 
                      <div class="card-body">
                        <input type="hidden" id="id_app" v-model="data.id_app" placeholder="edit me">
                        <h4 class="card-title">{{ data.app_name }}</h4>
                        <p class="card-text">Some example text some example text. John Doe is an architect and engineer</p>
                        <a href="#" v-on:click="GotoDetil(data.id_app)"  class="btn btn-primary">Lihat</a>
                      </div>
              </div>   
          </div> 
      </div>  
  </div>

   <div class="content" style="background:#fff;"> 
      <h2  >Kategory Gallery</h2>
      <h3  >Daftar aplikasi yang terhubung ke api-gallery</h3>
  <div class="row "> 
 
   <div v-for="data in kategory_apps"   class="col-lg-4">
                <div class="card" > 
                    <div class="line"></div> 
                      <div class="card-body">
                        <h4 class="card-title">{{ data.nama_kategory }}</h4>
                        <p class="card-text">{{ data.app_name }}</p>
                        <a href="#" class="btn btn-primary">Lihat</a>
                      </div>
              </div>   
          </div> 
    
  </div>  
  </div>
 
  <br/>
</div>
</template>

<script> 
  export default { 
    data(){
      return {
        data_apps :[],
        kategory_apps :[],
        data : [1,2,3,4]
      }
    }, 
  mounted(){
 axios.get('api/app').then(response =>(this.data_apps = response.data)) ;
 axios.get('api/kategory').then(response =>(this.kategory_apps = response.data)) ;
  }, 
    methods: { 
     GotoDetil(id_app){ 
     this.$router.push({ name: 'gallery', params: { id_app: id_app } }).catch(()=>{}); 
      console.log(id_app); 
     }, GotoAdd() { 
                    this.$router.push({ name: 'addapp' }).catch(()=>{});
        }
    }
  }
</script>