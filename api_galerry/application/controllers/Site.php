<?php
defined('BASEPATH') OR exit('No direct script access allowed');
 
 
	class Site extends CI_Controller {

	public function index()
	{
		$this->load->template_login(); 
	}
 

		function login(){ 
			echo "test";
		$this->load->model('user_model');  
		$nip = $this->input->post('username');
		$password = $this->input->post('password'); 
		$user = $this->user_model->check_login($nip);
 		
 		if ($user->PASSWORD==$password) { 
				$this->session->set_userdata(array(
												'logged_in' => TRUE,
												'id_user' => $user->id_user,
												'username' => $user->user_name,  
												'level' => $user->level 
												));
 
			$this->session->set_userdata("error_info","".site_url()."/home" );
			redirect(site_url()."/home");
		}
		else{ 
			$this->session->set_userdata("error_info","NIP atau password yang anda masukan salah ".$user->user_name );
			  redirect(site_url());
			return false;
		}
		}

		function logout(){
 		$session= array('logged_in' ,'id_user' ,'username' ,'nip' ,'gender' , 'level' ,'firstlogin','error_info' ); 
 		$this->session->unset_userdata($session);
		redirect(site_url()); 
		}
 
		function load_page( $page = 'dashboard' , $act = null )
	{ 
		$page = $this->uri->segment(1);
 
		if(!$this->session->userdata('logged_in') )
		{
			redirect(site_url());
		} else { 
      		switch( $page )
			{
				case 'list-user' :
				case 'list_apps' :
				case 'list-assets' :
				case 'upload' :
				case 'home' : 
					$this->load->template_page($page);
				break;  
				default :
				echo $page;
					$id = $this->session->userdata('id_user');
					$user = $this->user_model->get_detil_user($id);
					$idportal = $this->user_model->id_portal_by_page($page);
					/* berdasarkan data di tb_portal */
					$arrportal_bynip = explode(',', $user['id_portal']);

					if(!in_array($idportal, $arrportal_bynip) )
					{
						$this->session->set_userdata('error_logged', 'User Anda tidak memiliki hak akses ke portal tersebut');
						redirect(site_url());
					} else {
						$this->session->unset_userdata('error_logged');
						$this->load->template_page($page);
					}
				break;
            }
		}
	}
}
