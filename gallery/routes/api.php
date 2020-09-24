<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/

Route::middleware('auth:api')->get('/user', function (Request $request) {
    return $request->user();
});
 
Route::post('/login', 'LoginController@login');
//Route::get('app','AppIdController@Index');
Route::get('app','AppIdController@Index');
Route::get('app_select','AppIdController@Select');
Route::get('kategory','KategoryController@Data');
Route::get('image','ImageController@Index');
Route::get('image/{kat}','ImageController@Indexkat');
Route::get('image-app/{app}','ImageController@indexapp');
Route::get('/upload', 'UploadController@upload');
Route::post('/upload/proses', 'UploadController@proses_upload');
Route::post('save-multiple-file-upload', 'UploadController@proses_upload');
