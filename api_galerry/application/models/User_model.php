<?php
class User_model extends CI_Model
{
	function __construct()
	{
		parent :: __construct();
	}
 
 	function check_login( $username )
		{
			// $this->support = $this->load->database('db_sigma', true);

			$this->db->select('*');
			$this->db->where('user_name', $username); 

			$query = $this->db->get('users', 1);

			if ( $query->num_rows() == 1 ) 
			{
				return $query->row();
			}
			else
			{
				return false;
			}
		}
}
