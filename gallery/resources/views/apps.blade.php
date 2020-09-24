@extends('Header')


@section('konten')
<div class="container mt-5">
  <div class="row justify-content-center ">
    <div class="card col-md-5">
       <div class="card-header ">Apps</div> 
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
                        @foreach ($errors->all() as $error)
                            <li>{{ $error }}</li>
                        @endforeach
                    </ul>
                </div>
            @endif
 
            <form action="{{ url('/appss-post') }}" method="post" enctype="multipart/form-data">
                @csrf
                <div class="form-group">
                    <input type="input" class="form-control-file" name="apps" id="apps"  placeholder="Nama Apps"> 
                </div>   
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
 
         </div>
     </div>
  </div>
</div>

@endsection