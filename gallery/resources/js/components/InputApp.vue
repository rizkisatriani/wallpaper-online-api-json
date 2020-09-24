 <template> 

    
  <div class="container">  
  <div class="content"> 
          <h2  >Upload Gallery</h2>
        <h3  >Unggah data asset untuk api gallery </h3>
      <div class="row "> 
          <h2>App Name </h2> 
        <div class="select">
          <v-select :options="data_apps.app_name"></v-select>
        </div>
      </div>  
  </div> 
 
  <br/>
</div>
</template>
 
<script>

  export default { 
 create(){ 
  },
    data(){
      return {
        data_apps :[], 
        data : [1,2,3,4]
      }
    }, 
  mounted(){

 axios.get('api/app_select').then(response =>(this.data_apps = response.data )) ;
 axios.get('api/image').then(response =>(this.image_apps = response.data)) ; 
  } 
  }
</script>