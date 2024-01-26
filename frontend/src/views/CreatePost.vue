<!-- views/CreatePost.vue -->
<template>
    <main class="create-post-container">
      <h1>게시글 작성</h1>
      <!-- 게시글 작성 양식 등을 추가하세요 -->
      <form @submit.prevent="submitPost" class="post-form">
        <div class="form-group">
          <label for="title">제목:</label>
          <input type="text" class="form-control" v-model="post.title" required>
        </div>

        <div class="form-group">
          <label for="content">내용:</label>
          <textarea class="form-control" v-model="post.content" required></textarea>
        </div>
  
        <button type="submit" class="btn btn-primary">게시글 작성</button>
      </form>
    </main>
  </template>
  
  <script>
  export default {
    name: 'CreatePost',
    data() {
      return {
        post: {
          title: '',
          author: '',
          content: '',
        },
      };
    },
    methods: {
      submitPost() {
        // 게시글을 서버에 저장하는 로직을 추가하세요
        console.log('게시글 작성:', this.post);
        // 작성 후 홈으로 이동 또는 다른 동작을 수행할 수 있습니다.
        this.$router.push({ name: 'PostView' });
      },
    },
  };
  </script>
  
  <style lang="scss" scoped>


  .create-post-container {
    max-width: 600px;
    padding: 20px;
    text-align: left;
  }
  
  .post-form {
    background-color: #fff;
    padding: 20px;
  }
  
  .form-group {
    margin-bottom: 20px;
  }
  
  label {
    display: block;
    font-weight: bold;
    margin-bottom: 8px;
  }
  
  .input-control {
    width: 100%;
    padding: 10px;
    font-size: 16px;
    border: 1px solid #ddd;
    border-radius: 4px;
    outline-color: black;
  }
  
  button {
    padding: 10px 20px;
    background-color: #007BFF;
    color: #fff;
    border: none;
    border-radius: 4px;
    cursor: pointer;
  }
  </style>
  