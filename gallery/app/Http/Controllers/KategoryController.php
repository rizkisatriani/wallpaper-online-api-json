<?php

namespace App\Http\Controllers;

use App\kategory;
use App\app_id;
use Validator,Redirect,Response;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;

class KategoryController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {

        $apps = App_id::pluck('id_app', 'app_name');
          return view('kategory', [
            'apps' => $apps,
        ]);    
    }

    public function data()
    {

        $result = DB::table('app_ids')
            ->join('kategories', 'app_ids.id_app', '=', 'kategories.id_app') 
            ->select('app_ids.app_name', 'kategories.nama_kategory')
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
               $save['id_app'] = $request->input('app');
              // $save['id_app'] = $request->input('app');
               $save['nama_kategory'] = $request->input('kategory');  
               Kategory::insert($save); 
               return Redirect::to("kat")
        ->withSuccess('Files successfully uploaded.');
    }

    /**
     * Display the specified resource.
     *
     * @param  \App\kategory  $kategory
     * @return \Illuminate\Http\Response
     */
    public function show(kategory $kategory)
    {
        //
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  \App\kategory  $kategory
     * @return \Illuminate\Http\Response
     */
    public function edit(kategory $kategory)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\kategory  $kategory
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, kategory $kategory)
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\kategory  $kategory
     * @return \Illuminate\Http\Response
     */
    public function destroy(kategory $kategory)
    {
        //
    }
}
