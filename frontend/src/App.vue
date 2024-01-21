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
  
  <WebHeader></WebHeader>
  <TheView></TheView>
</template>

<style>
</style>
