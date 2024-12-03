<template>
  <v-card width="56" elevation="0">
    <v-layout height="100vh" fixed>
      <v-navigation-drawer theme="" permanent rail>
        <v-list>
          <v-list-item
            class="v-sidebar-list-item"
            prepend-icon="mdi-home-outline"
            :active="isCurrentRoute('/')"
            @click="toggleHome"
          ></v-list-item>
        </v-list>

        <v-list>
          <v-list-item
            class="v-sidebar-list-item"
            prepend-icon="mdi-calendar-blank-outline"
            :active="isCurrentRoute('/meus-agendamentos')"
            @click="toggleSchedule"
          >
          </v-list-item>
        </v-list>

        <v-list>
          <v-list-item
            class="v-sidebar-list-item"
            prepend-icon="mdi-home-plus"
            :active="isCurrentRoute('/nova-unidade')"
            @click="toggleCreateUnit"
          >
          </v-list-item>
        </v-list>

        <v-list>
          <v-list-item
            class="v-sidebar-list-item"
            prepend-icon="mdi-heart-plus-outline"
            :active="isCurrentRoute('/novo-exame')"
            @click="toggleCreateExam"
          >
          </v-list-item>
        </v-list>
      </v-navigation-drawer>
    </v-layout>
  </v-card>
</template>
<script>
export default {
  components: {},
  data() {
    return {
      drawer: null,
      rail: true,
    };
  },
  mounted() {},
  beforeUnmount() {},
  methods: {
    toggleDrawer() {
      this.rail = !this.rail;
    },

    toggleHome() {
      this.$router.push("/");
    },

    toggleSchedule() {
      this.$router.push("/meus-agendamentos");
    },

    toggleCreateUnit() {
      this.$router.push("/nova-unidade");
    },

    toggleCreateExam() {
      this.$router.push("/novo-exame");
    },

    isCurrentRoute(route) {
      return this.$route.path === route;
    },
  },
  computed: {
    isMenuOpen() {
      return this.rail ? "mdi-menu-close" : "mdi-menu-open";
    },
  },
  watch: {},
};
</script>

<style>
.v-navigation-drawer__content {
  min-width: 51px !important;
}

.v-sidebar-list-item:hover {
  color: #723ab3 !important;
  border-right: 1px solid #723ab3 !important;
}

:deep(.v-list-item--active > .v-list-item__overlay) {
  color: #723ab3 !important;
  border-right: 1px solid #723ab3 !important;
}

.v-list-item--active {
  color: #723ab3 !important;
  border-right: 1px solid #723ab3 !important;
}

:deep(.v-list-item__overlay) {
  color: #723ab3 !important;
  border-right: 1px solid #723ab3 !important;
}
</style>
