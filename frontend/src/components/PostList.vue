<!-- src/components/PostList.vue -->
<template>
  <div>
    <h2>전체 게시글 목록</h2>
    <hr>

    <div v-for="post in posts" :key="post.id" class="post" @click="goToPostDetail(post.id)">
      <h3>{{ post.title }}</h3>
      <p>{{ post.content }}</p>
      <p>작성자: {{ post.member.name }}</p>
      <p>작성일: {{ formatDateTime(post.createdAt) }}</p>
      <p>조회수: {{ post.views }}</p>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      posts: [],
    };
  },
  mounted() {
    this.loadPosts();
  },
  methods: {
    async loadPosts() {
      try {
        const response = await fetch("http://localhost:8080/api/posts");
        if (response.ok) {
          const data = await response.json();
          this.posts = data;
        } else {
          console.error("Error loading posts:", response.statusText);
        }
      } catch (error) {
        console.error("Error loading posts:", error);
      }
    },
    goToPostDetail(postId) {
      console.log(postId)
      this.$router.push({ name: 'post-detail', params: { postId } });
    },
    formatDateTime(dateTimeString) {
      const options = { year: 'numeric', month: 'long', day: 'numeric', hour: 'numeric', minute: 'numeric', second: 'numeric' };
      return new Date(dateTimeString).toLocaleDateString(undefined, options);
    },
  },
};
</script>

<style scoped>
.post {
  cursor: pointer;
  border: 1px solid #ddd;
  padding: 10px;
  margin-bottom: 10px;
}
</style>
