<?php

namespace App\Http\Controllers;

use App\app_id;
use Validator,Redirect,Response; 
use Illuminate\Http\Request; 
use Illuminate\Support\Facades\DB;
class AppIdController extends Controller
{ 
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {  
      $result = DB::table('app_ids')  
            ->select('id_app','app_name')
            ->get();
        return $result;  
    }
    public function select()
    {  
      $result = DB::table('app_ids')  
            ->select( 'app_name')
            ->get();

        return  $result ;  
    }
      public function indexweb()
    {  
        return view('apps'); 
    }
    /**
     * Show the form for creating a new resource. 
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
       $save['app_name'] = $request->input('apps');  
               App_id::insert($save); 
               return Redirect::to("apps")
        ->withSuccess('Files successfully uploaded.');
    }

    /**
     * Display the specified resource.
     *
     * @param  \App\app_id  $app_id
     * @return \Illuminate\Http\Response
     */
    public function show(app_id $app_id)
    {
        //
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  \App\app_id  $app_id
     * @return \Illuminate\Http\Response
     */
    public function edit(app_id $app_id)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\app_id  $app_id
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, app_id $app_id)
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\app_id  $app_id
     * @return \Illuminate\Http\Response
     */
    public function destroy(app_id $app_id)
    {
        //
    }
}
