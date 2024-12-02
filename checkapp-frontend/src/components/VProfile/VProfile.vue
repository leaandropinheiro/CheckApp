<template>
  <v-menu min-width="200px" width="300PX" rounded>
    <template v-slot:activator="{ props }">
      <v-btn icon v-bind="props">
        <v-avatar size="50" class="avatar-container">
          <v-img v-if="photo" :src="photo" alt="User Photo" />
          <span v-else class="text-h5">{{ getInitials }}</span>
        </v-avatar>
      </v-btn>
    </template>
    <v-card class="card-profile-menu rounded-xl">
      <v-container class="d-flex flex-column align-center">
        <v-avatar size="100">
          <v-img
            v-if="photo"
            :src="photo"
            alt="User Photo"
            class="avatar-container-menu"
          />
          <span v-else class="text-h5">{{ getInitials }}</span>
        </v-avatar>
        <v-card-title class="text-center">
          Olá, {{ showFirstName }}
          <v-card-subtitle class="text-center"> {{ email }}</v-card-subtitle>
        </v-card-title>
      </v-container>
      <v-divider></v-divider>
      <v-list class="bg-transparent">
        <v-list-item @click="myAccount" class="menu-item">
          Minha conta
        </v-list-item>
        <v-list-item @click="$emit('edit')" class="menu-item">
          Meus agendamentos
        </v-list-item>
        <v-list-item @click="SignOut" class="menu-item"> Sair </v-list-item>
      </v-list>
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

    showFirstName() {
      const firstName = this.name.split(" ")[0];
      return (
        firstName.charAt(0).toUpperCase() + firstName.slice(1).toLowerCase()
      );
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

    myAccount() {
      this.$router.push("/profile");
    },
  },
};
</script>

<style scoped>
.avatar-container {
  border-radius: 100% !important;
  overflow: hidden;
}

.avatar-container-menu {
  border-radius: 100%;
}

.bg-primary {
  background-color: var(--primary) !important;
}

.card-profile-menu {
  background-color: rgba(255, 255, 255, 0.108) !important;
  backdrop-filter: blur(10px);
  border: solid 1px #fff;
}

.menu-item:hover {
  background: transparent !important;
  color: #723ab3;
}
</style>
