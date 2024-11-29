<template>
  <v-container max-width="inherit" class="container1">
    <v-row cols="12" lg="12" md="12" sm="12" xs="12">
      <v-col cols="8" class="d-flex flex-column ga-5">
        <v-card border="opacity-50 sm" elevation="0">
          <v-card-title class="font-weight-bold">
            Informações do agendamento
          </v-card-title>
          <v-divider></v-divider>
          <v-container>
            <v-row>
              <v-col>
                <v-card elevation="0">
                  <v-card-subtitle class="subtitle">
                    Nome completo
                  </v-card-subtitle>
                  <v-card-title class="title">{{
                    currentUser.name
                  }}</v-card-title>
                </v-card>
              </v-col>
            </v-row>
          </v-container>
        </v-card>
        <v-card border="opacity-50 sm" elevation="0">
          <v-card-title>Forma de pagamento</v-card-title>
          <v-divider></v-divider>
        </v-card>
        <v-card border="opacity-50 sm" elevation="0">
          <v-card-title>Informações do agendamento</v-card-title>
          <v-card-subtitle></v-card-subtitle>
        </v-card>
      </v-col>
      <v-col cols="4">
        <v-card border="opacity-50 sm" elevation="0">
          <v-card-title>aquii</v-card-title>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import { mapGetters } from "vuex";

export default {
  name: "VCheckout",
  components: {},
  data() {
    return {};
  },
  computed: {
    ...mapGetters({
      isAuthenticated: "auth/isAuthenticated",
      currentUser: "auth/currentUser",
      userPhoto: "auth/userPhoto",
    }),
  },
};
</script>

<style scoped></style>
