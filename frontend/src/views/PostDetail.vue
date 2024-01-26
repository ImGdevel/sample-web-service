<!-- views/PostDetail.vue -->
<template>
    <div>
      <h2>{{ post.title }}</h2>
      <p>작성자: {{ post.author }}</p>
      <p>작성일: {{ formatTime(post.timestamp) }}</p>
      <p>조회수: {{ post.views }}</p>
      <p>{{ post.content }}</p>
    </div>
  </template>
  
  <script>
  export default {
    name: 'PostDetail',
    data() {
      return {
        post: {}, // 상세 페이지에 표시될 게시글 데이터
      };
    },
    methods: {
      formatTime(timestamp) {
        const date = new Date(timestamp);
        return `${date.getFullYear()}-${date.getMonth() + 1}-${date.getDate()} ${date.getHours()}:${date.getMinutes()}`;
      },
    },
    created() {
      // 게시글 데이터를 API 또는 저장소에서 가져오는 로직을 추가하세요.
      // 예를 들어, 게시글 ID를 라우터 파라미터로 받아서 해당 게시글 정보를 가져오는 방식 등.
      const postId = this.$route.params.id;
      // 예시로 하드코딩한 데이터
      this.post = {
        id: postId,
        title: `게시글 ${postId} 제목`,
        author: '작성자',
        timestamp: Date.now(),
        views: 100,
        content: `게시글 ${postId} 내용입니다.`,
      };
    },
  };
  </script>
  
  <style scoped>
  /* 필요한 스타일을 추가하세요 */
  </style>
  