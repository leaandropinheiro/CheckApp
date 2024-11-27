<template>
  <v-row>
    <v-col cols="12">
      <v-autocomplete
        :items="examsList"
        class="mx-auto"
        density="comfortable"
        menu-icon=""
        placeholder="Busque por exame, vacina, check-up, teste, imagem..."
        prepend-inner-icon="mdi-magnify"
        theme="light"
        variant="outlined"
        hide-details
        clearable
        auto-select-first
        v-model="searchQuery"
        @update:search="handleInput"
        item-value="id"
        item-text="title"
        max-width="585.33"
      >
        <template v-slot:no-data>
          <v-list-item max-width="inherit">
            <div class="item-content">
              <v-card elevation="0" border="opacity-50 sm">
                <v-card-title
                  >2,5 Hexanodiona Urinária Final de Jornada</v-card-title
                >
                <v-card-subtitle
                  >Acetonylacetone, N-Hexano, Hexano,
                  Acetonilacetona</v-card-subtitle
                >
                <v-card-text>R$ 100</v-card-text>
              </v-card>
            </div>
          </v-list-item>
        </template>
        <template v-slot:item="{ item }">
          <v-list-item max-width="585.33">
            <v-list-item-title>{{ item.title }}</v-list-item-title>
            <v-list-item-subtitle class="text-break">
              {{ item.raw.synonymous }}
            </v-list-item-subtitle>
            <v-list-item-subtitle>{{ item.raw.price }}</v-list-item-subtitle>
          </v-list-item>
        </template>
      </v-autocomplete>
    </v-col>
  </v-row>
</template>

<script>
import { mapActions } from "vuex";

export default {
  name: "VSearchbar",
  data() {
    return {
      searchQuery: "",
      examsList: [],
      isHovering: false,
    };
  },
  methods: {
    ...mapActions("exams", ["fetchExams"]),

    async handleInput(query) {
      if (query && query.length > 2) {
        try {
          const exams = await this.$store.dispatch("fetchExams", {
            search: query,
          });

          // console.log("👉 exams =>", exams);

          this.examsList = exams.items.map((item) => ({
            id: item.id,
            title: item.title,
            price: item.price,
            category: item.category,
            synonymous: item.synonymous,
          }));

          console.log("👉 this.examsList =>", this.examsList);
        } catch (error) {
          console.error("Error fetching exams:", error);
        }
      } else {
        this.examsList = [];
      }
    },

    handleClear() {
      this.examsList = [];
      this.searchQuery = "";
    },
  },
};
</script>

<style>
.lista:hover {
  transition: all 0.3s ease;
  cursor: pointer;
}

.v-autocomplete__content {
  border: solid 0.5px #000 !important;
}
</style>
