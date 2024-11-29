<template>
  <v-menu min-width="200px" width="300PX" rounded>
    <template v-slot:activator="{ props }">
      <v-btn icon v-bind="props">
        <v-avatar color="primary" size="large">
          <v-img v-if="photo" :src="photo" alt="User Photo" />
          <span v-else class="text-h5">{{ getInitials }}</span>
        </v-avatar>
      </v-btn>
    </template>
    <v-card>
      <v-container class="d-flex flex-column align-center">
        <v-avatar color="primary">
          <v-img v-if="photo" :src="photo" alt="User Photo" />
          <span v-else class="text-h5">{{ getInitials }}</span>
        </v-avatar>
      </v-container>
      <v-divider></v-divider>
      <v-card-title class="text-center">{{ name }}</v-card-title>
      <v-card-subtitle class="text-center"> {{ email }}</v-card-subtitle>
      <v-card-text>
        <div class="mx-auto text-center">
          <v-divider class="my-3"></v-divider>
          <v-btn variant="text" rounded @click="$emit('edit')">
            Agendamentos
          </v-btn>
          <v-divider class="my-3"></v-divider>
          <v-btn variant="text" rounded @click="SignOut"> Sair </v-btn>
        </div>
      </v-card-text>
    </v-card>
  </v-menu>
</template>

<script>
export default {
  name: "VProfile",
  props: {
    name: {
      type: String,
      required: true,
    },
    email: {
      type: String,
      required: true,
    },
    photo: {
      type: String,
      default: null,
    },
  },
  computed: {
    getInitials() {
      return this.name
        .split(" ")
        .map((word) => word[0])
        .join("")
        .toUpperCase();
    },
  },
  methods: {
    async SignOut() {
      try {
        await this.$store.dispatch("auth/logout", this.$msalInstance);
        this.$router.push("/login");
      } catch (error) {
        console.error("Logout error:", error);
      }
    },
  },
};
</script>
