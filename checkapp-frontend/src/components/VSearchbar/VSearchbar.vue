<template>
  <v-row>
    <v-col cols="12">
      <v-autocomplete
        :items="examsList"
        class="mx-auto border-sm rounded-xl"
        density="comfortable"
        menu-icon=""
        placeholder="Busque por exame, vacina, check-up, teste, imagem..."
        prepend-inner-icon="mdi-magnify"
        hide-details
        clearable
        auto-select-first
        v-model="searchQuery"
        @update:search="handleInput"
        v-model:search-input="searchInput"
        item-value="id"
        item-text="title"
        max-width="585.33"
      >
        <template v-slot:no-data>
          <v-list-item prepend-icon="mdi-information-outline">
            <v-list-item-subtitle>
              Busque por exame, vacina, check-up, teste ou imagem...
            </v-list-item-subtitle>
            <div class="search-result-items d-flex flex-column"></div>
          </v-list-item>
        </template>
        <template v-slot:item="{ item }">
          <v-list-item>
            <div class="search-result-items d-flex flex-column">
              <span class="font-weight-black text-subtitle-1">
                {{ item.title }}
              </span>
              <span class="font-weight-thin text-subtitle-2">
                {{ item.raw.synonymous }}
              </span>
            </div>
            <div class="search-result-items-price">
              <span class="font-weight-black text-subtitle-1"
                >R$ {{ item.raw.price }},00
              </span>
            </div>
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
      searchInput: "",
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

          this.examsList = exams.items.map((item) => ({
            id: item.id,
            title: item.title,
            price: item.price,
            category: item.category,
            synonymous: item.synonymous,
          }));
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

/* Add this to your existing styles */
.v-autocomplete {
  max-width: 585.33px !important;
  width: 100% !important;
}

/* Estilo do container do dropdown */
.v-autocomplete__content {
  max-width: 583px !important;
  width: 583px !important;
  border-radius: 0px 0px 24px 24px !important;
  margin-top: 4px !important;
  border-bottom: 1px solid #723ab3 !important;
  border-left: 1px solid #723ab3 !important;
  border-right: 1px solid #723ab3 !important;
  visibility: visible !important;
}

/* Estilo dos items da lista */
.v-list-item {
  max-width: 585px !important;
  padding: 12px 16px !important;
}

/* Hover nos items */
.v-list-item:hover {
  background-color: #ffff !important;
}

/* Estilo do título do item */
.v-list-item-title {
  font-weight: 500 !important;
}

/* Estilo do subtítulo */
.v-list-item-subtitle {
  /* color: #666 !important; */
  font-size: 0.875rem !important;
}

/* Input focus styles */
.v-field.v-field--focused {
  background-color: #ffffff !important;
  border: 1px solid #723ab3 !important;
  border-radius: 24px 24px 0 0 !important;
}

/* Input default styles */
.v-field {
  background-color: #ffffff !important;
  border-radius: 24px !important;
  transition: all 0.5s ease;
}

.v-field__outline {
  display: none !important;
}
</style>
