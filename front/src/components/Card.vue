<script>
export default {
  props: {
    id:Number,
    nombreproducto: String,
    precio: Number,
    imageUrl: String
  }
}
</script>
<template>
<router-link :to="`/Vistaproducto/${id}`"><button class="component">
    <div class="overlap">
      <img :src="imageUrl" alt="imagen" class="imagen">
    </div>
      <h5 class="nombreproducto">{{ nombreproducto }}</h5>
      <p class="text-wrapper">{{ precio }}</p>
    
    </button> </router-link>
  
</template>

<style scoped>
.component {
  background-color: #103973;
   border-radius: 10px;  
  height: 230px;
  position: relative;
  border: none;

  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
transition: all .2s ease-in-out; 
}
.component:hover{
  transform: scale(1.1);  
}
 .overlap {
  background-color: #00133b;
  border-radius: 10px;
  position: relative;
  top: 10px;
  left: center;
  height: 145px;
  width: 173px;
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
}
.imagen {
  border-radius: 10px;
  height: 85px;
  position: absolute;
  top: 5px;
  width: 99px;
}
 .text-wrapper {
  color: #ffffff;
  font-family: "Inter-Regular", Helvetica;
  font-size: 12px;
  font-weight: 400;
  height: 27px;
  left: center;
  letter-spacing: 0;
  line-height: normal;
  position: relative;
  text-align: center;
  top: -6px;
}

 .nombreproducto {
  color: #ffffff;
  font-family: "Inter-Regular", Helvetica;
  font-size: 16px;
  font-weight: 400;
  height: 50px;
  left: center;
  letter-spacing: 0;
  line-height: normal;
  position: relative;
  top: 20px;
  max-width: 150px;
}

</style>
