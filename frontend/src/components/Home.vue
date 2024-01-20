<template>
  <div>
    <h1 class="header">게시판</h1>
    
    <div class="post-container" v-if="posts.length > 0">
      <h2>게시글 목록</h2>
      <ul class="post-list">
        <li v-for="post in posts" :key="post.id" @click="selectPost(post)">
          {{ post.title }}
        </li>
      </ul>
    </div>
    
    <div class="selected-post" v-if="selectedPost">
      <h2>{{ selectedPost.title }}</h2>
      <p>{{ selectedPost.content }}</p>
    </div>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  data() {
    return {
      posts: [
        { id: 1, title: '첫 번째 게시글', content: '첫 번째 게시글 내용입니다.' },
        { id: 2, title: '두 번째 게시글', content: '두 번째 게시글 내용입니다.' },
        // 여러 게시글을 추가할 수 있습니다.
      ],
      selectedPost: null,
    };
  },
  methods: {
    selectPost(post) {
      this.selectedPost = post;
    },
  },
};
</script>

<style scoped>
/* 스타일링 */
.header {
  text-align: center;
  color: #333;
}

.post-container {
  margin-top: 20px;
}

.post-list {
  list-style-type: none;
  padding: 0;
  cursor: pointer;
}

.post-list li {
  padding: 10px;
  border: 1px solid #ddd;
  margin-bottom: 5px;
  background-color: #f9f9f9;
  transition: background-color 0.3s;
}

.post-list li:hover {
  background-color: #e0e0e0;
}

.selected-post {
  margin-top: 20px;
  border: 1px solid #ddd;
  padding: 15px;
  background-color: #fff;
}
</style>
