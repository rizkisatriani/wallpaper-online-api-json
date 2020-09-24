<?php

namespace App\Http\Controllers;

use App\app_id;
use Illuminate\Http\Request; 
class AppIdController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {  
        return App_id::all(); 
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
        //
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
