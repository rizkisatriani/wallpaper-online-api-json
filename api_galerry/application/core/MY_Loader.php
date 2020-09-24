<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

	class My_Loader extends CI_loader
	{

    public function template_login()
    {
        $data['el'] = "";

        $this->view('inc/head'); 
        $this->view('inc/footer');
        $this->view('login/login');
    }

    public function template_page($page)
    { 
        $this->view('inc/head');
        $this->view('inc/header');
        $this->view('inc/sidebar');
        $this->view('inc/footer');
        switch ($page) {
            case 'home': 
        $this->view('home/dashboard.php');
                break;
            case 'upload': 
        $this->view('upload_data/index.php');
                break;
            case 'list-assets': 
        $this->view('data_assets/index.php');
                break;
            case 'list-user': 
        $this->view('data_user/index.php');
                break;
            case 'list_apps': 
        $this->view('upload_apps/index.php');
                break;
            
            default:
                 
                break;
        } 
        
    }
  
  }
