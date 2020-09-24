<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Validator,Redirect,Response;
Use App\Image;
use Illuminate\Support\Facades\DB;

class FileController extends Controller
{

    public function index()
    {
       $result = DB::table('kategories') 
            ->join('app_ids', 'app_ids.id_app', '=', 'kategories.id_app') 
            ->select('kategories.id_kategory',DB::raw("concat(kategories.nama_kategory,' - apps : ',app_ids.app_name) as nama")  )
            ->get();
        return view('create', [
            'kat' => $result,
        ]);
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
               $save[$x]['id_kategory'] = $request->input('kategory');
               $save[$x]['url_thumbn'] = "localhost"; 
            }
            $x++;
         }

        }

        Image::insert($save); // store file into mysql database

        return Redirect::to("upload")
        ->withSuccess('Files successfully uploaded.');

    }
}
