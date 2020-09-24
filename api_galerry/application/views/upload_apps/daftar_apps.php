
 <div class="row clearfix">
                <div class="col-lg-12"> 
                           <br>
                           <br>
                    <div class="card"> 

                        <div class="body">
                             <div> 
                                    <h4 class="card-title text-left">Data Apps</h4> 
                                     <p>Daftar data application</p>
                            </div>
                            <hr>
                            <div class="table-responsive">
                               <table id="example" class="table table-hover js-basic-example dataTable table-custom spacing5"> 
                                  <thead>
                                            <tr>
                                                <th style="display:none;">id</th>
                                                <th class="w200">Nama Aplikasi</th>
                                                <th class="mb-0">Type</th> 
                                                <th class="mb-0">Jumlah Install</th> 
                                                <th class="mb-0">Versi</th> 
                                                <th class="mb-0">App Id</th> 
                                                <th class="mb-0">Banner Code</th> 
                                                <th class="mb-0">Interstitial Code</th> 
                                                <th class="mb-0">Native Code</th> 
                                                <th class="mb-0">Action</th> 
                                            </tr>
                                  </thead> 
                                    <tbody>
                                            <?php foreach ($data as $key ) { ?>
                                            
                                              <tr>
                                                <td style="display:none;"><?php echo $key->id_app;?></td>
                                                <td><?php echo $key->app_name;?></td>
                                                <td><?php echo $key->Description;?></td> 
                                                <td><?php echo $key->intall;?></td> 
                                                <td><?php echo $key->versi;?></td> 
                                                <td><?php echo $key->app_id;?></td> 
                                                <td><?php echo $key->banner;?></td> 
                                                <td><?php echo $key->interstitial;?></td> 
                                                <td><?php echo $key->native;?></td> 
                                                <td><div class='btn btn-outline-success edit'   ><i class="fa fa-pencil"></i><span> Edit</span></div></td> 
                                            </tr>

                                            <?php } ?>
                                    </tbody>
                                 
                                </table> 
                            </div>
                        </div>
                    </div>
                </div>  
            </div>

<div class="modal fade" id="EditModal" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content ">
            <div class="modal-header">
              <a class="align-middle"><i class="fa fa-address-card-o fa-2x text-success" aria-hidden="true"></i><span > Aplication</span>  </a>
            <hr>
            </div>
            <input type="hidden" class="form-control" id="id"  placeholder="Tulis Nama User">
            <div class="modal-body col-sm-12 col-md-12 col-lg-12 mx-auto">
                <div class="form-group row">
                        <label for="staticEmail" class="col-sm-3 col-form-label">Nama Aplikasi</label>
                <div class="col-sm-9">
                        <input type="email" class="form-control" id="nama"  placeholder="Tulis nama application">
                </div>

              </div>  

              <div class="form-group row">
                      <label for="staticEmail" class="col-sm-3 col-form-label">Type</label>
                <div class="col-sm-9">
                  <select id="type" class="form-control form-control-sm">
                    <option >Pilih</option>
                    <option value="1">Wallpaper</option>
                    <option value="2">Coloring</option> 
                  </select>
                </div>
              </div>

               <div class="form-group row">
                        <label for="staticEmail" class="col-sm-3 col-form-label">Versi</label>
                <div class="col-sm-9">
                        <input type="versi" class="form-control" id="versi" placeholder="Tulis Versi application">
                </div>
              </div> 
              
               <div class="form-group row">
                        <label for="staticEmail" class="col-sm-3 col-form-label">App Id</label>
                <div class="col-sm-9">
                        <input type="text" class="form-control" id="appid" placeholder="Tulis NIP User">
                </div>
              </div> 

                <div class="form-group row">
                        <label for="staticEmail" class="col-sm-3 col-form-label">Banner Code</label>
                <div class="col-sm-9">
                        <input type="text" class="form-control" id="banner" placeholder="Tulis NIP User">
                </div>
              </div> 

              <div class="form-group row">
                        <label for="staticEmail" class="col-sm-3 col-form-label">Interstitial Code</label>
                <div class="col-sm-9">
                        <input type="text" class="form-control" id="inter" placeholder="Tulis NIP User">
                </div>
              </div> 

              <div class="form-group row">
                        <label for="staticEmail" class="col-sm-3 col-form-label">Native Code</label>
                <div class="col-sm-9">
                        <input type="text" class="form-control" id="native" placeholder="Tulis NIP User">
                </div>
              </div> 
 

            </div>



            <div class="modal-footer col-sm-12">
                <button type="button" id="upload" class="btn   btn-outline-primary col-sm-3" onclick="update()"  >Simpan</button>
                <button type="button" class="btn  btn-outline-danger col-sm-3" data-dismiss="modal">Batal</button>
            </div>
        </div>
    </div>
</div>
 
<script>$(document).ready(function() {
    //$('#example').DataTable();
    $('#example').DataTable( {
    fixedHeader: true
} ); 
} );

 $('.edit').click(function(){
      var id_                = $(this).closest("tr").find("td").eq(0).text();   
      var name_              = $(this).closest("tr").find("td").eq(1).text();   
      var type_              = $(this).closest("tr").find("td").eq(2).text();   
      var versi_             = $(this).closest("tr").find("td").eq(4).text();  
      var appid_             = $(this).closest("tr").find("td").eq(5).text();  
      var banner_            = $(this).closest("tr").find("td").eq(6).text();  
      var inter_             = $(this).closest("tr").find("td").eq(7).text();  
      var native_            = $(this).closest("tr").find("td").eq(8).text();  
      console.log(id_);
      $('#nama').val(name_);
      $('#versi').val(versi_);
      $('#appid').val(appid_); 
      $('#banner').val(banner_); 
      $('#inter').val(inter_); 
      $('#native').val(native_); 
      $('#EditModal').modal('show');
      $('#type').val('1'); 
      $('#id').val(id_); 
    });
 
function update(){
              $('#EditModal').modal('hide');
              $('body').removeClass('modal-open');
              $('.modal-backdrop').remove();
      var nama =$('#nama').val();
      var versi =$('#versi').val();
      var appid =$('#appid').val(); 
      var banner =$('#banner').val(); 
      var inter =$('#inter').val(); 
      var native =$('#native').val();  
      var type =$('#type').val(); 
      var id =$('#id').val();  

           $.ajax({url:"<?php echo site_url(); ?>/Data_apps/update",
             method:"POST",
             data:{id:id,nama:nama,versi:versi,appid:appid,banner:banner,inter:inter,native:native,type:type},
             success:function(response){
              console.log(response);
               var json = JSON.parse(response);
                if(json.status){ 
                  $('#nama').val();
                  $('#versi').val();
                  $('#appid').val(); 
                  $('#banner').val(); 
                  $('#inter').val(); 
                  $('#native').val();  
                  $('#type').val(); 
                  $('#id').val(); 

                show_data();
                }

             },
             complete:function(){   

             }
             });
} 
</script>