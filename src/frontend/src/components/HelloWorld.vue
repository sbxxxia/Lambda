<template>
  <v-container>
    <div id="header">
      <img src="https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_92x30dp.png">
    </div>
    <div id="container">
      <h2>멍멍</h2>
    </div>
    <div id="footer">
      <div class="text-center">
        <pagination
                v-model="page"
                :length="4"
                circle
        ></pagination>
      </div>
    </div>
  </v-container>
</template>

<script>
  export default {
    data () {
      return {
        page: 1,
      }
    },
  }
</script>
