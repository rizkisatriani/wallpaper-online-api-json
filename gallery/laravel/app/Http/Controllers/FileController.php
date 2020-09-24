<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Validator,Redirect,Response;
Use App\Image;

class FileController extends Controller
{

    public function index()
    {
        return view('create');
    }

    public function fileStore(Request $request)
    {
       request()->validate([
        'fileName' => 'required',
        'fileName.*' => 'mimes:jpeg,png,jpg'
       ]);
       
       if($request->hasfile('fileName'))
       {
         $x=0;
         foreach ($request->file('fileName') as $key => $value) 
         {
   
           if ($files = $value) 
           {
               $destinationPath = 'files/'; // upload path
               $fileName = $x.'_'.date('YmdHis') . "." . $files->getClientOriginalExtension();
               $files->move($destinationPath, $fileName);
               $save[$x]['url_image'] = "$fileName";
               $save[$x]['id_kategory'] = "1";
               $save[$x]['url_thumbn'] = "localhost"; 
            }
            $x++;
         }

        }

        Image::insert($save); // store file into mysql database

        return Redirect::to("multiple-file-upload")
        ->withSuccess('Files successfully uploaded.');

    }
}
