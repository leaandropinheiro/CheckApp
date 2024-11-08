<template>
  <v-container max-width="inherit">
    <v-card elevation="5">
      <v-container max-width="inherit">
        <v-card-title class="font-weight-black">
          Resultados da pesquisa
        </v-card-title>
        <v-card-subtitle>Resultados da pesquisa realizada.</v-card-subtitle>
      </v-container>

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
  name: "VSearchResult",
  components: {},
  data() {
    return {};
  },
};
</script>

<style scoped></style>
