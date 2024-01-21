<script>
import WebHeader from './components/WebHeader.vue';
import TheView from './components/TheView.vue';

export default {
  name: 'App',
  components: {
    TheView,
    WebHeader
  },
}
</script>


<template>
  <!--<img alt="Vue logo" src="./assets/logo.png">-->
  <!-- <HelloWorld msg="Welcome to Your Vue.js App"/> -->
  <WebHeader></WebHeader>
  <TheView></TheView>
</template>



<style>
</style>
