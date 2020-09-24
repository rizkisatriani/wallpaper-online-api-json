<?php

namespace App\Http\Controllers;

use App\image;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;

class ImageController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $result = DB::table('images')
            ->join('kategories', 'images.id_kategory', '=', 'kategories.id_kategory') 
            ->select('images.url_image', 'kategories.nama_kategory')
            ->orderBy( 'kategories.nama_kategory')
            ->get();
        return $result; 
    }
  
    public function indexkat($kat)
    {
        $result = DB::table('images')
            ->join('kategories', 'images.id_kategory', '=', 'kategories.id_kategory') 
            ->select('images.url_image', 'kategories.nama_kategory')
            ->where('kategories.nama_kategory', $kat)
            ->get();
        return $result; 
    }
    public function indexapp($app)
    {
        $result = DB::table('images')
            ->join('kategories', 'images.id_kategory', '=', 'kategories.id_kategory') 
            ->join('app_ids', 'kategories.id_app', '=', 'app_ids.id_app') 
            ->select('images.url_image', 'kategories.nama_kategory')
            ->where('app_ids.id_app', $app)
            ->get();
        return $result; 
    }
    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        //
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
       $this->validate($request, [

                'filename' => 'required',
                'filename.*' => 'mimes:jpg,png'

        ]);
        
        
        if($request->hasfile('filename'))
         {

            foreach($request->Image('url_image') as $file)
            {
                $name=$file->getClientOriginalName();
                $file->move(public_path().'/files/', $name);  
                $data[] = $name;  
            }
         }

         $file= new Image();
         $file->url_image=json_encode($data);
         
        
        $file->save();

        return back()->with('success', 'Your files has been successfully added');
    }

    /**
     * Display the specified resource.
     *
     * @param  \App\image  $image
     * @return \Illuminate\Http\Response
     */
    public function show(image $image)
    {
        //
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  \App\image  $image
     * @return \Illuminate\Http\Response
     */
    public function edit(image $image)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\image  $image
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, image $image)
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\image  $image
     * @return \Illuminate\Http\Response
     */
    public function destroy(image $image)
    {
        //
    }
}
