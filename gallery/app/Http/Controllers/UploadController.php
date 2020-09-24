<?php
 
namespace App\Http\Controllers;
 
use Illuminate\Http\Request;
 
class UploadController extends Controller
{
	public function upload(){
		return view('upload');
	}
 
	public function proses_upload(Request $request){
		request()->validate([
        'fileName' => 'required',
        'fileName.*' => 'mimes:doc,docx,pdf,txt,jpeg,png,jpg,gif,svg'
       ]);
       
       if($request->hasfile('fileName'))
       {
         
         foreach ($request->file('fileName') as $key => $value) 
         {
   
           if ($files = $value) 
           {
               $destinationPath = 'public/files/'; // upload path
               $fileName = date('YmdHis') . "." . $files->getClientOriginalExtension();
               $files->move($destinationPath, $fileName);
               $save[]['file_name'] = "$fileName";
            }
         }

        }

        File::insert($save); // store file into mysql database

        return Redirect::to("multiple-file-upload")
        ->withSuccess('Files successfully uploaded.');
	}
}