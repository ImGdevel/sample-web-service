<!-- views/PostDetail.vue -->
<template>
  <main class="post-detail-container">
    <div class="container mt-5">
      <h1 class="display-5">{{ post.title }}</h1>
      <div class="post-meta text-muted mb-3 d-flex justify-content-between">
        <div class="text-left">
          <span class="mb-0">작성자: {{ post.member ? post.member.username : '알 수 없음' }}</span>
        </div>
        <div class="text-right">
          <span class="mb-0">작성일: {{ formatTime(post.createdAt) }}</span>
          <span class="mb-0" style="margin-left: 40px;">조회수: {{ post.views }}</span>
        </div>
      </div>
      <hr class="my-4">
      <div class="post-content">
        {{ post.content }}
      </div>
      <router-link to="/post" class="btn btn-primary mt-3">목록으로</router-link>
    </div>
  </main>
</template>

<script>
import axios from 'axios';

export default {
  name: 'PostDetail',
  data() {
    return {
      post: {
        id: 1,
        title: '',
        member: {},
        timestamp: 0,
        views: 0,
        content: '',
      },
    };
  },
  mounted() {
    // URL에서 postId를 받아오거나, 라우터를 통해 전달된 값을 사용할 수 있습니다.
    const postId = this.$route.params.id;
    
    this.fetchPostDetail(postId);
  },
  methods: {
    fetchPostDetail(postId) {
      axios.get(process.env.VUE_APP_API + `/api/posts/${postId}`)
        .then(response => {
          this.post = response.data;
          console.log(this.post);
        })
        .catch(error => {
          console.error('API 호출 중 에러:', error);
        });
    },
    formatTime(timestamp) {
      if(timestamp === undefined) return ""; 
      const date = new Date(timestamp);
      return `${date.getFullYear()}-${date.getMonth() + 1}-${date.getDate()} ${date.getHours()}:${date.getMinutes()}`;
    },
  },
};
</script>

<style scoped>
.post-detail-container {
  min-height: 100vh;
}

.post-content {
  font-size: 1.2rem;
  min-height: 300px;
}

.btn-primary {
  margin-top: 20px;
}
</style>
