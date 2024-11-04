<template>
  <v-hover>
    <template v-slot:default="{ isHovering, props }">
      <v-card
        class="mx-auto card"
        v-bind="props"
        :prepend-avatar="logo"
        :color="isHovering ? '#fff' : undefined"
        :elevation="isHovering ? 16 : 0"
        :style="{
          transform: isHovering ? 'scale(1.05)' : 'scale(1)',
          transition: 'transform 0.3s ease',
          cursor: 'pointer',
        }"
        border="opacity-50 sm "
      >
        <template v-slot:title>
          <div class="title-rating">
            <span class="font-weight-medium">{{ title }}</span>
            <div
              class="rating d-flex align-end flex-end ga-2"
              v-if="avaliacoesMedia"
            >
              <v-rating
                :model-value="avaliacoesMedia"
                color="amber"
                density="compact"
                size="small"
                half-increments
                readonly
              ></v-rating>
              <v-card-subtitle class="avaliacoes">
                {{ avaliacoesMedia }} ({{ avaliacoesTotal }})
              </v-card-subtitle>
            </div>
          </div>
        </template>

        <template v-slot:subtitle>
          <span class="font-weight-light">{{ subtitle }}</span>
        </template>

        <v-divider></v-divider>
        <v-card-text>
          <v-list
            v-if="comentarios.length"
            lines="one"
            class="lista-comentarios"
          >
            <v-list-item
              v-for="(comentario, index) in comentarios"
              :key="index"
              class="lista-comentarios-item"
            >
              <v-list-item-content class="d-flex ga-2 align-center">
                <v-list-item-avatar>
                  <v-icon color="black">mdi-account</v-icon>
                </v-list-item-avatar>
                <v-list-item-subtitle
                  v-html="comentario"
                ></v-list-item-subtitle>
              </v-list-item-content>
            </v-list-item>
          </v-list>
        </v-card-text>

        <v-container v-if="localidade">
          <v-card
            elevation="0"
            variant="outlined"
            class="card-footer px-0 d-flex align-center justify-space-between"
          >
            <v-col cols="auto" class="d-flex px-0 align-center">
              <v-icon color="black">mdi-map-marker</v-icon>
              <v-card-text
                class="text-subtitle-2 font-weight-medium localidade"
              >
                {{ localidade }}
              </v-card-text>
            </v-col>
            <v-btn color="black" text @click="verMais"> Ver mais </v-btn>
          </v-card>
        </v-container>
      </v-card>
    </template>
  </v-hover>
</template>

<script>
import { defineComponent } from "vue";

export default defineComponent({
  name: "VCards",
  props: {
    logo: {
      type: String,
      default: "",
    },
    title: {
      type: String,
      default: "",
    },
    subtitle: {
      type: String,
      default: "",
    },
    localidade: {
      type: String,
      default: "",
    },
    servicos: {
      type: Object,
      required: true,
    },
    avaliacoesTotal: {
      type: Number,
      required: true,
    },
    avaliacoesMedia: {
      type: Number,
      required: true,
    },
    avaliacoesComentarios: {
      type: String,
      default: "",
    },
    comentarios: {
      type: Array,
      default: () => [],
    },
  },
  mounted() {
    console.log("👉 this.localidade =>", this.localidade);
    console.log(this.servicos);
    console.log(this.avaliacoes);
    console.log("👉 this.comentarios =>", this.comentarios);
  },
  computed: {},
  methods: {},
  watch: {},
});
</script>

<style>
.card {
  height: auto !important;
  width: 100% !important;
}
.v-img__img--cover {
  width: 100% !important;
  height: 100% !important;
  object-fit: contain;
}

.v-img__img .v-img__img--cover {
  width: 1rem !important;
  height: 1rem !important;
}

.v-responsive {
  height: 100% !important;
  width: 100% !important;
}

.v-avatar.v-avatar--density-default {
  height: none !important;
  width: none !important;
  border-radius: 0;
}

.title-rating {
  display: flex;
  justify-content: space-between;
  align-items: end;
}
.avaliacoes {
  padding: 0 !important;
}
.card-footer {
  padding: 0 8px 0 5px !important;
}

.localidade {
  padding: 0 10px 0 0 !important;
  max-width: 250px;
}

.lista-comentarios {
  display: flex;
  flex-direction: column;
}

.lista-comentarios-item {
  padding: 1px 15px 1px 15px !important;
  min-height: 0px !important;
}
</style>
