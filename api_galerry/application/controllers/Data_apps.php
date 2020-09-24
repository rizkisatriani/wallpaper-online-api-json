<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Data_apps extends CI_Controller
{
	public function __construct()
	{
		parent::__construct();
		$this->load->model('excel_import_model');
		$this->load->model('data_apps_model');
		$this->load->library('excel');
	}
 
	function fetch()
	{
		$data = $this->data_apps_model->select_header(); 
		$x['data']= $data->result() ; 
		$this->load->view('upload_apps/daftar_apps',$x);
	}

	function add()
	{ 
		$this->load->view('upload_apps/tambah_app');
	}
 

    function insert_app()
	{ 			
		   	
          $data = array(
						  'app_name'=>$this->input->post('app_name'),
				          'native'=>$this->input->post('native'),
				          'banner'=>$this->input->post('banner'),
				          'interstitial'=>$this->input->post('interstitial'),
				          'app_id'=>$this->input->post('app_id'),
				          'versi'=>$this->input->post('versi'),
				          'type'=>$this->input->post('type')
					);
		$cek_insert=$this->data_apps_model->insert($data);
		if($cek_insert){ 
          $id_apps=$this->db->insert_id(); 
			echo $id_apps;
		}else{
		}
	}


	 function insert_image_kat()
	{ 			 
        $kategori=array();
        $data_kategory= $this->input->post('data_kat');  
        $id_apps=$this->input->post('id_apps'); 
 			array_push($kategori, array('id_app' 		=> $id_apps,
 										'nama_kategory'	=>$data_kategory)); 
 			 
			$cek_insert_kat=$this->data_apps_model->insert_kategori($kategori);

          	$id_kategori=$this->db->insert_id(); 
			echo $id_kategori;
 			$countfiles = count($_FILES[$data_kategory]['name']);
			
 				   for($x=0;$x<$countfiles;$x++){
  
 				  $_FILES['file']['name'] 		= $_FILES[$data_kategory]['name'][$x];
		          $_FILES['file']['type'] 		= $_FILES[$data_kategory]['type'][$x]; 
         		  $_FILES['file']['tmp_name'] 	= $_FILES[$data_kategory]['tmp_name'][$x];
         		  $_FILES['file']['size'] 		= $_FILES[$data_kategory]['size'][$x];

	 				$config['file_name']     		=$x;//$x.'_'.date('YmdHis') ;
			   		$config['upload_path']          = './uploads/';
	                $config['allowed_types']        = 'gif|jpg|png';
	                $config['max_size']             = 1000; 
 
                $this->load->library('upload', $config);

 			if ( ! $this->upload->do_upload('file'))
                {
                        $error = array('error' => $this->upload->display_errors());
                        var_dump($error); 
                }
                else
                {

        		$image=array();
                        $data = array('upload_data' => $this->upload->data());
 				array_push($image, array('id_kategory' 		=> $id_kategori,
 										'url_image'	=>$data['upload_data']['file_name']));
			$cek_insert_image=$this->data_apps_model->insert_image($image);
                        var_dump($data);
                       echo $data['upload_data']['file_name'];
                }/**/
            }  
	}

		function update(){
		$data = array(
						  'app_name'=>$this->input->post('nama'),
					      'versi'=>$this->input->post('versi'),
					      'app_id'=>$this->input->post('appid'), 
					      'banner'=>$this->input->post('banner'), 
					      'interstitial'=>$this->input->post('inter'), 
					      'native'=>$this->input->post('native'),  
					      'type'=>$this->input->post('type') 
					);
		$id=$this->input->post('id');
		$cek_insert=$this->data_apps_model->update($data,$id);
		if($cek_insert){ 
			$pesan="success";
			$kode=200;
			$x['message']=$pesan;
			$x['kode']=$kode;
			$x['status']= true; 
		}else{
			$pesan="fail";
			$kode=404;
			$x['message']=$pesan;
			$x['kode']=$kode;
			$x['status']= false; 
		}
		echo json_encode($x);
	}
	 
}

?>