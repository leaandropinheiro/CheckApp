<template>
  <v-container max-width="inherit">
    <v-card elevation="5">
      <v-divider border="black thin"></v-divider>
      <v-container max-width="inherit">
        <v-col
          ><v-row class="">
            <v-col cols="12" lg="4" md="6" sm="12" xs="12" class="d-flex">
            </v-col> </v-row
        ></v-col>
      </v-container>
    </v-card>
  </v-container>
</template>

<script>
export default {
  name: "VHome",
  components: {},
  data() {
    return {
      exams: [],
    };
  },
  props: {},
};
</script>

<style scoped>
.container-router-view {
  max-width: auto !important;
}
</style>
