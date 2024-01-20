<!-- src/components/PostDetail.vue -->
<template>
    <div>
      <h2>게시글 상세 내용</h2>
      <div v-if="post">
        <h3>{{ post.title }}</h3>
        <p>{{ post.content }}</p>
        <p>작성자: {{ post.member.name }}</p>
        <p>작성일: {{ formatDateTime(post.createdAt) }}</p>
        <p>조회수: {{ post.views }}</p>
      </div>
      <div v-else>
        <p>게시글을 찾을 수 없습니다.</p>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        post: null,
      };
    },
    mounted() {
      this.loadPost();
    },
    methods: {
      async loadPost() {
        try {
          const postId = this.$route.params.postId;
          const response = await fetch(`http://localhost:8080/api/posts/${postId}`);
          console.log("??");
          if (response.ok) {
            const data = await response.json();
            this.post = data;
          } else {
            console.error("Error loading post:", response.statusText);
            this.post = null;
          }
        } catch (error) {
          console.error("Error loading post:", error);
          this.post = null;
        }
      },
      formatDateTime(dateTimeString) {
        const options = { year: 'numeric', month: 'long', day: 'numeric', hour: 'numeric', minute: 'numeric', second: 'numeric' };
        return new Date(dateTimeString).toLocaleDateString(undefined, options);
      },
    },

    
  };
  </script>
  
  <style scoped>
  /* Add any custom styles here */
  </style>
  