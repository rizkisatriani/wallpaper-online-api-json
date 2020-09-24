<html lang="en" class="">
<head>
<meta charset="UTF-8">
<title>Upload File Gallery</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css" />
</head>
<body>
<div class="container mt-5">
  <div class="row justify-content-center">
    <div class="card">
       <div class="card-header">Input Kategory</div>
 
         <div class="card-body">
            @if ($message = Session::get('success'))
 
                <div class="alert alert-success alert-block">
 
                    <button type="button" class="close" data-dismiss="alert">×</button>
 
                    <strong>{{ $message }}</strong>
 
                </div>
            @endif
 
            @if (count($errors) > 0)
                <div class="alert alert-danger">
                    <strong>Whoops!</strong> There were some problems with your input.<br><br>
                    <ul>
                    </ul>
                </div>
            @endif
 
            <form action="{{ url('/kat-post') }}" method="post" enctype="multipart/form-data">
                @csrf 
                <div class="form-group">
                <select name="app" id="app"  class="form-control form-control-sm"> 
                 @foreach ($apps as $id_app => $app_name)
                    <option value="{{ $app_name }}">{{$id_app }}</option>
                @endforeach
                </select>
                </div>  
                <div class="form-group">
                    <input type="input" class="form-control-file" name="kategory" id="kategory"  placeholder="Kategory"> 
                </div> 
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
 
         </div>
     </div>
  </div>
</div>
</html>