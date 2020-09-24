  <div id="main-content"> 
          <div class="container-fluid">
              <div class="block-header">
                  <div class="row clearfix">
                      <div class="col-md-6 col-sm-12">
                          <h1>Upload Data</h1>
                          <nav aria-label="breadcrumb">
                              <ol class="breadcrumb">
                              <li class="breadcrumb-item"><a href="#">Home</a></li>
                              <li class="breadcrumb-item"><a href="#">Upload</a></li> 
                              </ol>
                          </nav>
                      </div>            
                    <!--   <div class="col-md-6 col-sm-12 text-right hidden-xs">
                          <a href="javascript:void(0);" class="btn btn-sm btn-primary" title="">Download</a>
                          <a href="https://themeforest.net/item/oculux-bootstrap-4x-admin-dashboard-clean-modern-ui-kit/23091507" class="btn btn-sm btn-success" title="Themeforest"><i class="icon-printer"></i> Print</a>
                      </div> -->
                  </div>
              </div>
              
    <div id='content'>
      
      <div>
              <h4 class="card-title text-left">Unggah Data Aplikasi</h4> 
               <p>Silahkan upload daftar data asset yang akan di stock take </p>
      </div>
   <div class="row" > 
        <div class="col-sm-12 col-md-12 col-lg-12 mx-auto">
 
          <div class="skeleton  card card-upload my-2 ">
            <div class="card-body text-left">  
              <h6 class="card-title text-left">Form Data Asset</h6>  
                 
                <div class="form-group row">
                        <label for="staticEmail" class="col-sm-2 col-form-label">Nama Aplikasi</label>
                <div class="col-sm-10">
                        <input type="email" class="form-control" id="nama"  placeholder="Tulis nama application">
                </div>

              </div>  

              <div class="form-group row">
                      <label for="staticEmail" class="col-sm-2 col-form-label">Type</label>
                <div class="col-sm-10">
                  <select id="type" class="form-control form-control-sm">
                    <option >Pilih</option>
                    <option value="1">Wallpaper</option>
                    <option value="2">Coloring</option> 
                  </select>
                </div>
              </div>

               <div class="form-group row">
                        <label for="staticEmail" class="col-sm-2 col-form-label">Versi</label>
                <div class="col-sm-10">
                        <input type="versi" class="form-control" id="versi" placeholder="Tulis Versi application">
                </div>
              </div> 
              
               <div class="form-group row">
                        <label for="staticEmail" class="col-sm-2 col-form-label">App Id</label>
                <div class="col-sm-10">
                        <input type="text" class="form-control" id="appid" placeholder="Tulis App Id">
                </div>
              </div> 

                <div class="form-group row">
                        <label for="staticEmail" class="col-sm-2 col-form-label">Banner Code</label>
                <div class="col-sm-10">
                        <input type="text" class="form-control" id="banner" placeholder="Tulis Banner Code">
                </div>
              </div> 

              <div class="form-group row">
                        <label for="staticEmail" class="col-sm-2 col-form-label">Interstitial Code</label>
                <div class="col-sm-10">
                        <input type="text" class="form-control" id="inter" placeholder="Tulis Interstitial Code">
                </div>
              </div> 

              <div class="form-group row">
                        <label for="staticEmail" class="col-sm-2 col-form-label">Native Code</label>
                <div class="col-sm-10">
                        <input type="text" class="form-control" id="native" placeholder="Tulis Native Code">
                </div>
              </div> 
 

              <button class="btn btn-primary my-2 my-sm-2 float-right" id="modalupload" onclick="simpan()">Simpan</button>  
                
                      <br/> 
                      <br/> 
                      <br/> 

              <div class="form-group row">
                <label for="staticEmail" class="col-sm-2 col-form-label">Kategori</label>
                <div class="col-sm-4">
                        <input type="text" class="form-control" id="Kategori" placeholder="Tulis Kategori">
                </div>
                <button class="btn btn-outline-success col-sm-2"    onclick="addKategory()">Tambah Kategori</button>  
                      <div id="listapp" class="text-left col-lg-12">
                      <br/> 
                      <br/>  
                      </div> 
              </div>
 
            </div>
          </div> 
      </div> 
    </div>
    </div>
      <div id="response" class="col-sm-12 col-md-12 col-lg-12 mx-auto"></div>
      </div>
  <div class="modal fade" id="addevent" tabindex="-1" role="dialog">
      <div class="modal-dialog" role="document">
          <div class="modal-content text-center">
              <div class="modal-header">
              </div>
              <div class="modal-body">
                  <div class="form-group">
                      <div class="form-line">
                  <h3 class="title" id="defaultModalLabel">Upload Data Asset</h3>
                          <label>Apakah anda yakin ingin upload data ?</label>
                      </div>
                  </div>      
              </div>
              <div class="modal-footer col-sm-12">
                  <button type="button" id="upload" class="btn   btn-primary col-sm-6" data-dismiss="modal">Upload</button>
                  <button type="button" class="btn  btn-danger col-sm-6" data-dismiss="modal">Tolak</button>
              </div>
          </div>
      </div>
  </div>

   

  </div>  
  <script>
var data_kat=[];
var data_file=[];
var idAPP; 
var x;
 function simpan_kat(name,pos){  
      let fd = new FormData();  
       fd.append("data_kat", name); 
       fd.append("id_apps", idAPP); 
             $.each($('#listapp').children("div").children("input[type=file]")[pos-1].files, function(x, file) {
              fd.append(""+name+"[]", file);
              console.log(file);
              });  

      $.ajax({ 
               url:"<?php echo site_url(); ?>/Data_apps/insert_image_kat",
               method:"POST",
               data:fd, 
               processData: false,
              contentType: false,
               success:function(data){ 
                  console.log(data); 
                }
                });
  }

  function Snackbar(pesan){
      var x = $("#snackbar");
      x.find('p').text(pesan);
    x.addClass('show');
    setTimeout(function(){ x.removeClass('show'); }, 3000);
  }

  
  //===============================================

  function addKategory(){
    data_kat.push(kategory); 
              var kategory=$('#Kategori').val();
              $('#listapp').append('<br><div class=" col-lg-12 text-left row"> <h6 class="col-sm-3 ">'+kategory+'</h6>  <input class=" col-sm-3" type="file" name='+kategory+'[]  multiple="multiple" /> <button class="btn btn-outline-success  col-sm-2" onclick="simpan_kat(\''+kategory+'\',\''+data_kat.length+'\')">Simpan</button><br><br></div><br><br>' );     
    
  }

  function simpan(){ 

  
      let fd = new FormData(); 
      let fd_kat = new FormData(); 
          fd.append('app_name',$('#app_name').val());
          fd.append('native',$('#native').val());
          fd.append('banner',$('#banner').val());
          fd.append('interstitial',$('#inter').val());
          fd.append('app_id',$('#appid').val());
          fd.append('versi',$('#versi').val());
          fd.append('type',$('#type').val());
          fd.append('data_kat',JSON.stringify(data_kat));  
/*
           for (var i = 0; i < data_kat.length; i++) {  
            var name=data_kat[i];
             // /fd.append(''+name+'', $('#listapp').children("div").children("input[type=file]")[0].files);
              $.each($('#listapp').children("div").children("input[type=file]")[0].files, function(x, file) {
              fd.append(""+name+"[]", file);
              console.log(file);
              }); 
            } */

      $.ajax({ 
               url:"<?php echo site_url(); ?>/Data_apps/insert_app",
               method:"POST",
               data:fd, 
               processData: false,
              contentType: false,
               success:function(data){ 
                idAPP=data;
                  console.log(data); 
                }
                });
  }



  </script>