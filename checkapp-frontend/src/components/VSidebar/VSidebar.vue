<template>
  <v-card>
    <v-layout>
      <v-navigation-drawer v-model="drawer" :rail="rail" permanent>
        <v-list density="compact" nav>
          <v-list-item
            prepend-icon="mdi-home-city"
            title="Clinicas"
            value="home"
          >
          </v-list-item>
          <v-list-item
            prepend-icon="mdi-account"
            title="Exames"
            value="account"
          ></v-list-item>
          <v-list-item
            prepend-icon="mdi-account-group-outline"
            title="Vacinas"
            value="users"
          ></v-list-item>
        </v-list>
      </v-navigation-drawer>
      <v-main class="h-screen sidebar"></v-main>
    </v-layout>
  </v-card>
</template>

<script>
import emitter from "@/plugins/eventBus";
// import ClinicIcon from "@/components/icons/ClinicIcon.vue";

export default {
  //   components: { ClinicIcon },
  data() {
    return {
      drawer: null,
      rail: true,
    };
  },
  mounted() {
    emitter.on("toggle-sidebar", this.toggleDrawer);
  },
  beforeUnmount() {
    emitter.off("toggle-sidebar", this.toggleDrawer);
  },
  methods: {
    toggleDrawer() {
      this.rail = !this.rail;
    },
  },
};
</script>

<style></style>
