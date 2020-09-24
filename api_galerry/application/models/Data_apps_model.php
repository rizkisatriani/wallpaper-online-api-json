<?php
class Data_apps_model extends CI_Model
{
	function select()
	{ 
		$query = $this->db->get('tbl_asset');
		return $query;
	}
	function select_header()
	{ 
		$query = $this->db->select('*');
		$this->db->from('tbl_type');
		$this->db->join('app_ids', 'tbl_type.id_type = app_ids.type');
		$query = $this->db->get();
		return $query;
	}

	function insert($data)
	{
		$result=$this->db->insert('app_ids', $data);
		return $result;
	}

	function insert_kategori($data)
	{
		var_dump($data);
		$result=$this->db->insert_batch('kategories', $data);
		return $result;
	}

	function insert_image($data)
	{
		$result=$this->db->insert_batch('images', $data);
		return $result;
	}

	function update($data,$id)
	{
		$this->db->where('id_app', $id);
		$query=$this->db->update('app_ids', $data);
		return $query;
	}
}
