<template>
  <q-page> </q-page>
</template>
<script>
import { defineComponent } from "vue";
import { ref } from "vue";
import { api } from "boot/axios";
import { useQuasar } from "quasar";
export default defineComponent({
  // name: "IndexPage",
  data() {
    return {
      articles: [],
    };
  },
  mounted() {
    this.getArticles();
  },
  methods: {
    getArticles() {
      api
        .get("/articles")
        .then((resp) => {
          //this.articles = resp.data;
          console.log(resp);
        })
        .catch((err) => {
          console.error(err);
        });
    },
  },
});
</script>
