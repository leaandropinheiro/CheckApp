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
      >
        <template v-slot:item="{ item }">
          <v-list-item>
            <v-list-item-content>
              <v-list-item-title>{{ item.title }}</v-list-item-title>
              <v-list-item-subtitle>{{ item.synonymous }}</v-list-item-subtitle>
              <!-- <v-list-item-subtitle>R$ {{ item.price }}</v-list-item-subtitle> -->
            </v-list-item-content>
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
    };
  },
  methods: {
    ...mapActions("exams", ["fetchExams"]),

    async handleInput(query) {
      if (query && query.length > 2) {
        try {
          const exams = await this.$store.dispatch("fetchExams", { search: query });

          this.examsList = exams.items.map((item) => ({
            id: item.id,
            title: item.title,
            price: item.price,
            category: item.category,
            synonymous: item.synonymous,
          }));

          console.log("👉 this.examsList => ", this.examsList);
        } catch (error) {
          console.error("Error fetching exams:", error);
        }
      } else {
        this.examsList = [];
      }
    },
  },
};
</script>

<style scoped></style>
