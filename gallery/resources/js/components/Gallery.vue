 <template> 

    
  <div class="container">  
  <div class="content"> 
          <h2  >Aplikasi Gallery</h2>
        <h3  >Daftar aplikasi yang terhubung ke api-gallery</h3>
      <div class="row "> 
           <div v-for="data in image_apps" :key="data.ka"  class="col-lg-4">
                <div class="card" > 
                  <div class="img_gallery"  v-bind:style="{ 'background-image': 'url(/files/' + data.url_image + ')' }" >
                  </div> 
                    <div class="line"></div> 
                      <div class="card-body">
                        <h4 class="card-title">{{ data.nama_kategory }}</h4>
                        <p class="card-text">Some example text some example text. John Doe is an architect and engineer</p> 
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
    generate: {
    fallback: true
  },
    data(){
      return {
        image_apps :[], 
        data : [1,2,3,4]
      }
    },
    create(){ 
    this.no_login=true;
    },
  mounted(){
 axios.get('api/image').then(response =>(this.image_apps = response.data)) ; 
  } 
  }
</script>