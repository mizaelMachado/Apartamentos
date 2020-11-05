<template>
  <div class="home">
 
    <FormApartamento/>
  </div>
</template>

<script>
// @ is an alias to /src
import FormApartamento from '@/components/Formulario.vue'

export default {
  name: 'Home',
  components: {
      FormApartamento
  }
}
</script>
