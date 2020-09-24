<template>
    <header class="main-header ">
       <nav class="navbar navbar-expand-lg  navbar-dark bg-dark">
<a class="navbar-brand" href="#">API-Img</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" @click.prevent="home()" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Daftar Apps</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" @click.prevent="Gallery()" href="#">Image Gallery</a>
      </li> 
    </ul>
  </div>

    <ul class="navbar-nav" style="padding-right: 50px;"> 
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        Pengatutan
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="#">Action</a>
          <a class="dropdown-item" href="#">Another action</a>
          <a class="dropdown-item" href="#">Something else here</a>
        </div>
      </li>
    </ul> 
</nav>
    </header>
</template>

<script>
export default {
      methods: {  
        Gallery() { 
                    this.$router.push({ name: 'gallery' }).catch(()=>{});
        },
        home() { 
                    this.$router.push({ name: 'home' }).catch(()=>{});
        }
    } 
}
</script>