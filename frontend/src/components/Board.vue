<!-- components/Board.vue -->
<template>
    <div class="container mt-5">
      <h1>게시판</h1>
      <div class="mb-4">
        <div v-for="post in posts" :key="post._id" class="alert alert-info" role="alert">
          {{ post.content }}
        </div>
      </div>
      <textarea v-model="postContent" class="form-control mb-3" placeholder="게시글을 작성하세요"></textarea>
      <button @click="submitPost" class="btn btn-primary">게시</button>
    </div>
  </template>
  
  <script>
  export default {
    name: 'HelloWorld',
    props: {
      msg: String
    },
    data() {
      return {
        posts: [],
        postContent: "",
      };
    },
    mounted() {
      this.loadPosts();
    },
    methods: {
      async loadPosts() {
        try {
          const response = await this.$axios.get("http://localhost:8080/api/posts");
          this.posts = response.data;
        } catch (error) {
          console.error("Error loading posts:", error);
        }
      },
      async submitPost() {
        try {
          await this.$axios.post("http://localhost:8080/api/posts", {
            content: this.postContent,
          });
          this.loadPosts();
          this.postContent = "";
        } catch (error) {
          console.error("Error submitting post:", error);
        }
      },
    },
  };
  </script>
  
  <style scoped>
  /* Add any custom styles here */
  </style>
  