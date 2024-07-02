<template>
  <RouterView />
</template>

<script setup>
import { RouterView } from "vue-router";
</script>

<style>
body {
  padding: 0;
  margin: 0;
  background-color: #102041; 
}

#app {
  height: 100vh;
  width: 100vw;
  max-width: 100vw;
  max-height: 100vh;
}
</style>